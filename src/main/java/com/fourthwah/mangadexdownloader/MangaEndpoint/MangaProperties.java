package com.fourthwah.mangadexdownloader.MangaEndpoint;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MangaProperties {
    private Map<String, String> properties;

    public MangaProperties() {
        properties = new HashMap<>();
    }

    @JsonAnyGetter
    public Map<String, String> getProperties() {
        return properties;
    }
    @JsonAnySetter
    public void setProperties(String property, String value){
        properties.put(property, value);
    }

    @Override
    public String toString() {
        return "MangaProperties{" +
                "properties=" + properties +
                '}';
    }
}
