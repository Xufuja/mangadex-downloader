package com.fourthwah.mangadexdownloader.AuthorEndpoint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class MangaAuthorAttributes {
    private String name;
    private Short version;

    public MangaAuthorAttributes() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Short getVersion() {
        return version;
    }

    public void setVersion(Short version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "MangaArtistAttributes{" +
                "name='" + name + '\'' +
                ", version=" + version +
                '}';
    }
}
