package com.fourthwah.mangadexdownloader.MangaEndpoint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MangaVolumeDetail {
    private String volume;
    private Short count;
    private MangaChapters chapters;

    public MangaVolumeDetail() {

    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public Short getCount() {
        return count;
    }

    public void setCount(Short count) {
        this.count = count;
    }

    public MangaChapters getChapters() {
        return chapters;
    }

    public void setChapters(MangaChapters chapters) {
        this.chapters = chapters;
    }

    @Override
    public String toString() {
        return "MangaVolumeDetail{" +
                "volume='" + volume + '\'' +
                ", count=" + count +
                ", chapters=" + chapters +
                '}';
    }
}
