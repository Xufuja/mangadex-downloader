package com.fourthwah.mangadexdownloader.DownloadEndpoint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MangaPagesObject {
    private String result;
    private String baseUrl;
    private MangaPageDetail chapter;

    public MangaPagesObject() {

    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public MangaPageDetail getChapter() {
        return chapter;
    }

    public void setChapter(MangaPageDetail chapter) {
        this.chapter = chapter;
    }

    @Override
    public String toString() {
        return "MangaPages{" +
                "result='" + result + '\'' +
                ", baseUrl='" + baseUrl + '\'' +
                ", chapter=" + chapter +
                '}';
    }
}
