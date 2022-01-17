package com.fourthwah.mangadexdownloader;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fourthwah.mangadexdownloader.AuthorEndpoint.MangaAuthorObject;
import com.fourthwah.mangadexdownloader.CoverEndpoint.MangaCoverObject;
import com.fourthwah.mangadexdownloader.MangaEndpoint.*;
import com.fourthwah.mangadexdownloader.DownloadEndpoint.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

@SpringBootApplication
public class MangadexDownloaderApplication {
	private static final Logger log = LoggerFactory.getLogger(MangadexDownloaderApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MangadexDownloaderApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			String titleUrl = "https://mangadex.org/title/aa6c76f7-5f5f-46b6-a800-911145f81b9b/sono-bisque-doll-wa-koi-o-suru";
			String titleId = titleUrl.split("//")[1].split("/")[2];
			String language = "en";

			MangaObject mangaObject = restTemplate.getForObject("https://api.mangadex.org/manga/" + titleId, MangaObject.class);

			Map<String, String> metaData = mangaMetaData(mangaObject);

			String title = metaData.get("title");
			String mainCoverId = metaData.get("mainCoverId");
			String authorId = metaData.get("authorId");
			String artistId = metaData.get("artistId");
			String enDescription = metaData.get("enDescription");
			List<String> genres = Arrays.asList(metaData.get("genre").split(","));
			String status = metaData.get("status");

			MangaCoverObject coverObject = restTemplate.getForObject("https://api.mangadex.org/cover/" + mainCoverId, MangaCoverObject.class);
			String coverFilename = coverObject.getData().getAttributes().getFileName();

			MangaVolumesChaptersObject mangaVolumesChaptersObject = restTemplate.getForObject("https://api.mangadex.org/manga/" + titleId + "/aggregate?translatedLanguage[]=" + language, MangaVolumesChaptersObject.class);
			List<String> volumes = new ArrayList<>();
			for (String x : mangaVolumesChaptersObject.getVolumes().getProperties().keySet()) {
				volumes.add(x);
			}

			Map<String, String> toDownload = new HashMap<>();
			for (String x : volumes) {
				for (String y : mangaVolumesChaptersObject.getVolumes().getProperties().get(x).getChapters().getProperties().keySet()) {
					toDownload.put(String.format("%1$3s", x).replace(' ', '0') + "_" + String.format("%1$6.2f", Double.parseDouble(y)).replace(' ', '0'), mangaVolumesChaptersObject.getVolumes().getProperties().get(x).getChapters().getProperties().get(y).getId());
				}
			}
			File titleDirectory = new File(System.getProperty("user.home") + "/Desktop/" + title);
			if (!titleDirectory.exists()) {
				titleDirectory.mkdir();
			}
			String coverType = coverFilename.split("\\.")[1];
			File coverArt = new File(titleDirectory + "/cover." + coverType);

			URL coverDownload = new URL("https://uploads.mangadex.org/covers/" + titleId + "/" + coverFilename);
			BufferedImage coverImage = ImageIO.read(coverDownload);
			ImageIO.write(coverImage, coverFilename.split("\\.")[1], coverArt);

			File detailsJson = new File(titleDirectory + "/details.json");
			if (!detailsJson.exists()) {
				ObjectMapper mapper = new ObjectMapper();
				ObjectNode rootNode = mapper.createObjectNode();
				rootNode.put("title", title);
				MangaAuthorObject mangaAuthorObject = restTemplate.getForObject("https://api.mangadex.org/author/" + authorId, MangaAuthorObject.class);
				MangaAuthorObject mangaArtistObject = restTemplate.getForObject("https://api.mangadex.org/author/" + artistId, MangaAuthorObject.class);
				rootNode.put("author", mangaAuthorObject.getData().getAttributes().getName());
				rootNode.put("artist", mangaArtistObject.getData().getAttributes().getName());
				rootNode.put("description", enDescription);

				ArrayNode genre = mapper.createArrayNode();
				for (String x : genres) {
					genre.add(x);
				}

				rootNode.set("genre", genre);

				switch (status) {
					case "unknown": {
						status = "0";
						break;
					}
					case "ongoing": {
						status = "1";
						break;
					}
					case "completed": {
						status = "2";
						break;
					}
					case "licensed": {
						status = "3";
						break;
					}
				}
				rootNode.put("status", status);

				ArrayNode statusValues = mapper.createArrayNode();
				statusValues.add("0 = Unknown");
				statusValues.add("1 = Ongoing");
				statusValues.add("2 = Completed");
				statusValues.add("3 = Licensed");
				rootNode.set("_status values", statusValues);

				String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootNode);
				try (FileWriter fileWriter = new FileWriter(detailsJson, true);
					 BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
					 PrintWriter printWriter = new PrintWriter(bufferedWriter)) {
					printWriter.println(jsonString);
				} catch (IOException e) {
					log.error(e.getStackTrace().toString());
				}
			}
			String archivePath = titleDirectory + "/archive.txt";
			toDownload = deduplicate(archivePath, toDownload);

			for (String x : toDownload.keySet()) {
				log.info("Downloading chapter: " + toDownload.get(x));
				String url = "https://api.mangadex.org/at-home/server/" + toDownload.get(x);
				MangaPagesObject mangaPages = restTemplate.getForObject(url, MangaPagesObject.class);
				String downloadUrl = mangaPages.getBaseUrl();
				String hash = mangaPages.getChapter().getHash();
				List<String> pageList = mangaPages.getChapter().getData();

				for (String y : pageList) {
					URL download = new URL(downloadUrl + "/data/" + hash + "/" + y);
					BufferedImage pageImage = ImageIO.read(download);
					File directory = new File(titleDirectory + "/" + x);
					if (!directory.exists()) {
						directory.mkdir();
					}
					File file = new File(directory + "/" + y);
					ImageIO.write(pageImage, y.split("\\.")[1], file);
				}
				try (FileWriter fileWriter = new FileWriter(archivePath, true);
					 BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
					 PrintWriter printWriter = new PrintWriter(bufferedWriter)) {
					printWriter.println(x + "=" + toDownload.get(x));
				} catch (IOException e) {
					log.error(e.getStackTrace().toString());
				}
			}

		};
	}

	public HashMap<String, String> mangaMetaData(MangaObject mangaObject) {
		HashMap<String, String> metaData = new HashMap<>();
		String title = "";
		for (var x : mangaObject.getData().getAttributes().getTitle().getProperties().keySet()) {
			if (x.equals("en")) {
				title = mangaObject.getData().getAttributes().getTitle().getProperties().get(x);
			}
		}
		metaData.put("title", title);
		List<MangaRelationship> relationships = mangaObject.getData().getRelationships();

		for (MangaRelationship x : relationships) {
			if (x.getType().equals("cover_art")) {
				metaData.put("mainCoverId", x.getId());
			}
		}

		for (var x : mangaObject.getData().getRelationships()) {
			if (x.getType().equals("author")) {
				metaData.put("authorId", x.getId());
			} else if (x.getType().equals("artist")) {
				metaData.put("artistId", x.getId());
			}
		}

		for (var x : mangaObject.getData().getAttributes().getDescription().getProperties().keySet()) {
			if (x.equals("en")) {
				metaData.put("enDescription", mangaObject.getData().getAttributes().getDescription().getProperties().get(x));
			}
		}
		String genre = "";
		for (var x : mangaObject.getData().getAttributes().getTags()) {
			if (x.getAttributes().getGroup().equals("genre")) {
				for (var y : x.getAttributes().getName().getProperties().keySet()) {
					if (y.equals("en")) {
						genre += x.getAttributes().getName().getProperties().get(y) + ",";
					}
				}
			}
		}
		metaData.put("genre", genre);

		metaData.put("status", mangaObject.getData().getAttributes().getStatus().toString());
		return metaData;

	}

	public Map<String, String> deduplicate(String archivePath, Map<String, String> toDownload) {
		try {
			List<String> lines = Files.readAllLines(Path.of(archivePath));
			for (String line : lines) {
				String split = line.split("=")[0];
				if (toDownload.containsKey(split)) {
					toDownload.remove(split);
					log.info("Chapter: " + split + " already downloaded");
				}
			}
		} catch (IOException e) {
			log.error(e.getStackTrace().toString());
		}
		return toDownload;
	}
}