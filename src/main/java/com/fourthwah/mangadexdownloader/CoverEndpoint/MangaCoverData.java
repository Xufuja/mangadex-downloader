package com.fourthwah.mangadexdownloader.CoverEndpoint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MangaCoverData {
    private String id;
    private String type;
    private MangaCoverAttributes attributes;

    public MangaCoverData() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public MangaCoverAttributes getAttributes() {
        return attributes;
    }

    public void setAttributes(MangaCoverAttributes attributes) {
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        return "CoverData{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", attributes=" + attributes +
                '}';
    }
}
