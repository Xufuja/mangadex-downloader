package com.fourthwah.mangadexdownloader.MangaEndpoint;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MangaVolumes {

    private Map<String, MangaVolumeDetail> properties;

    public MangaVolumes() {
        properties = new HashMap<>();
    }

    @JsonAnyGetter
    public Map<String, MangaVolumeDetail> getProperties() {
        return properties;
    }
    @JsonAnySetter
    public void setProperties(String property, MangaVolumeDetail value){
        properties.put(property, value);
    }

    @Override
    public String toString() {
        return "MangaVolumes{" +
                "properties=" + properties +
                '}';
    }
}
