package com.fourthwah.mangadexdownloader.CoverEndpoint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MangaCoverObject {
    private String result;
    private String response;
    private MangaCoverData data;

    public MangaCoverObject() {

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

    public MangaCoverData getData() {
        return data;
    }

    public void setData(MangaCoverData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CoverObject{" +
                "result='" + result + '\'' +
                ", response='" + response + '\'' +
                ", data=" + data +
                '}';
    }
}
