package com.fourthwah.mangadexdownloader.MangaEndpoint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class MangaObject {
    private String result;
    private String response;
    private MangaData data;

    public MangaObject() {

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

    public MangaData getData() {
        return data;
    }

    public void setData(MangaData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "MangaObject{" +
                "result='" + result + '\'' +
                ", response='" + response + '\'' +
                ", data=" + data +
                '}';
    }
}
