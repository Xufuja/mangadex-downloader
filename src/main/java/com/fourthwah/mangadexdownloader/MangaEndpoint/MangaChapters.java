package com.fourthwah.mangadexdownloader.MangaEndpoint;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fourthwah.mangadexdownloader.ChapterEndpoint.MangaChapterDetail;

import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MangaChapters {
    private Map<String, MangaChapterDetail> properties;

    public MangaChapters() {
        properties = new HashMap<>();
    }

    @JsonAnyGetter
    public Map<String, MangaChapterDetail> getProperties() {
        return properties;
    }
    @JsonAnySetter
    public void setProperties(String property, MangaChapterDetail value){
        properties.put(property, value);
    }

    @Override
    public String toString() {
        return "MangaChapters{" +
                "properties=" + properties +
                '}';
    }
}
