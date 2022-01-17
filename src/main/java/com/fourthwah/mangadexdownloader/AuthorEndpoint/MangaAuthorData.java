package com.fourthwah.mangadexdownloader.AuthorEndpoint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class MangaAuthorData {
    private String id;
    private String type;
    private MangaAuthorAttributes attributes;

    public MangaAuthorData() {

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

    public MangaAuthorAttributes getAttributes() {
        return attributes;
    }

    public void setAttributes(MangaAuthorAttributes attributes) {
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        return "MangaArtistData{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", attributes=" + attributes +
                '}';
    }
}
