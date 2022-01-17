package com.fourthwah.mangadexdownloader.ChapterEndpoint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fourthwah.mangadexdownloader.MangaEndpoint.MangaProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MangaChapterAttributes {
    private MangaProperties title;
    private String volume;
    private String chapter;
    private Short pages;
    private String tranlatedLanguage;
    private String uploader;
    public String externalUrl;
    private Byte version;
    private String createdAt;
    private String updatedAt;
    private String publishedAt;

    public MangaChapterAttributes() {

    }

    public MangaProperties getTitle() {
        return title;
    }

    public void setTitle(MangaProperties title) {
        this.title = title;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public Short getPages() {
        return pages;
    }

    public void setPages(Short pages) {
        this.pages = pages;
    }

    public String getTranlatedLanguage() {
        return tranlatedLanguage;
    }

    public void setTranlatedLanguage(String tranlatedLanguage) {
        this.tranlatedLanguage = tranlatedLanguage;
    }

    public String getUploader() {
        return uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }

    public String getExternalUrl() {
        return externalUrl;
    }

    public void setExternalUrl(String externalUrl) {
        this.externalUrl = externalUrl;
    }

    public Byte getVersion() {
        return version;
    }

    public void setVersion(Byte version) {
        this.version = version;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    @Override
    public String toString() {
        return "MangaChapterAttributes{" +
                "title=" + title +
                ", volume='" + volume + '\'' +
                ", chapter='" + chapter + '\'' +
                ", pages=" + pages +
                ", tranlatedLanguage='" + tranlatedLanguage + '\'' +
                ", uploader='" + uploader + '\'' +
                ", externalUrl='" + externalUrl + '\'' +
                ", version=" + version +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                '}';
    }
}
