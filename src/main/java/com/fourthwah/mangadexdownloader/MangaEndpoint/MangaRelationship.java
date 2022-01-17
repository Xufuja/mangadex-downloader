package com.fourthwah.mangadexdownloader.MangaEndpoint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MangaRelationship {
    private String id;
    private String type;
    private String related;
    private MangaAttributes attributes;

    public MangaRelationship() {

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

    public String getRelated() {
        return related;
    }

    public void setRelated(String related) {
        this.related = related;
    }

    public MangaAttributes getAttributes() {
        return attributes;
    }

    public void setAttributes(MangaAttributes attributes) {
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        return "MangaRelationship{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", related='" + related + '\'' +
                ", attributes=" + attributes +
                '}';
    }
}
