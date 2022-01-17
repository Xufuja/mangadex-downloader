package com.fourthwah.mangadexdownloader.MangaEndpoint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MangaData {
    private String id;
    private String type;
    private MangaAttributes attributes;
    private List<MangaRelationship> relationships;

    public MangaData() {

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

    public MangaAttributes getAttributes() {
        return attributes;
    }

    public void setAttributes(MangaAttributes attributes) {
        this.attributes = attributes;
    }

    public List<MangaRelationship> getRelationships() {
        return relationships;
    }

    public void setRelationships(List<MangaRelationship> relationships) {
        this.relationships = relationships;
    }

    @Override
    public String toString() {
        return "MangaData{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", attributes=" + attributes +
                ", relationships=" + relationships +
                '}';
    }
}
