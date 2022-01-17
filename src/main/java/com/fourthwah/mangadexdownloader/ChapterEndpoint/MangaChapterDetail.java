package com.fourthwah.mangadexdownloader.ChapterEndpoint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MangaChapterDetail {
    private String chapter;
    private String id;
    private List<String> others;
    private Byte count;

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getOthers() {
        return others;
    }

    public void setOthers(List<String> others) {
        this.others = others;
    }

    public Byte getCount() {
        return count;
    }

    public void setCount(Byte count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "MangaChapterDetail{" +
                "chapter='" + chapter + '\'' +
                ", id='" + id + '\'' +
                ", others=" + others +
                ", count=" + count +
                '}';
    }
}
