package com.fourthwah.mangadexdownloader.ChapterEndpoint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MangaChapterObject {
    private String result;
    private String response;
    private MangaChapterData data;

    public MangaChapterObject() {

    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public MangaChapterData getData() {
        return data;
    }

    public void setData(MangaChapterData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "MangaChapterObject{" +
                "result='" + result + '\'' +
                ", response='" + response + '\'' +
                ", data=" + data +
                '}';
    }
}
