package com.fourthwah.mangadexdownloader.AuthorEndpoint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class MangaAuthorObject {
    private String result;
    private String response;
    private MangaAuthorData data;

    public MangaAuthorObject() {

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

    public MangaAuthorData getData() {
        return data;
    }

    public void setData(MangaAuthorData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "MangaArtistObject{" +
                "result='" + result + '\'' +
                ", response='" + response + '\'' +
                ", data=" + data +
                '}';
    }
}
