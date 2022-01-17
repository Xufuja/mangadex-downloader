package com.fourthwah.mangadexdownloader.DownloadEndpoint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MangaPageDetail {
    private String hash;
    private List<String> data;
    private List<String> dataSaver;

    public MangaPageDetail() {

    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    public List<String> getDataSaver() {
        return dataSaver;
    }

    public void setDataSaver(List<String> dataSaver) {
        this.dataSaver = dataSaver;
    }

    @Override
    public String toString() {
        return "MangaPageDetail{" +
                "hash='" + hash + '\'' +
                ", data=" + data +
                ", dataSaver=" + dataSaver +
                '}';
    }
}
