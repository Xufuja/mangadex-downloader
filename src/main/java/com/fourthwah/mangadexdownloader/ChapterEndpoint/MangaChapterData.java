package com.fourthwah.mangadexdownloader.ChapterEndpoint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fourthwah.mangadexdownloader.MangaEndpoint.MangaRelationship;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MangaChapterData {
    private String id;
    private String type;
    private MangaChapterAttributes attributes;
    private List<MangaRelationship> relationships;

    public MangaChapterData() {

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

    public MangaChapterAttributes getAttributes() {
        return attributes;
    }

    public void setAttributes(MangaChapterAttributes attributes) {
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
