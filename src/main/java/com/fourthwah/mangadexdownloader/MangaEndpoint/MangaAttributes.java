package com.fourthwah.mangadexdownloader.MangaEndpoint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MangaAttributes {
    private MangaProperties title;
    private List<MangaProperties> altTitles;
    private MangaProperties description;
    private Boolean isLocked;
    private MangaProperties links;
    private String originalLanguage;
    private String lastVolume;
    private String lastChapter;
    private String publicationDemographic;
    private String status;
    private Short year;
    private String contentRating;
    private List<MangaTags> tags;
    private String state;
    private Byte version;
    private String createdAt;
    private String updatedAt;

    public MangaAttributes() {

    }

    public MangaProperties getTitle() {
        return title;
    }

    public void setTitle(MangaProperties title) {
        this.title = title;
    }

    public List<MangaProperties> getAltTitles() {
        return altTitles;
    }

    public void setAltTitles(List<MangaProperties> altTitles) {
        this.altTitles = altTitles;
    }

    public MangaProperties getDescription() {
        return description;
    }

    public void setDescription(MangaProperties description) {
        this.description = description;
    }

    public Boolean getLocked() {
        return isLocked;
    }

    public void setLocked(Boolean locked) {
        isLocked = locked;
    }

    public MangaProperties getLinks() {
        return links;
    }

    public void setLinks(MangaProperties links) {
        this.links = links;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getLastVolume() {
        return lastVolume;
    }

    public void setLastVolume(String lastVolume) {
        this.lastVolume = lastVolume;
    }

    public String getLastChapter() {
        return lastChapter;
    }

    public void setLastChapter(String lastChapter) {
        this.lastChapter = lastChapter;
    }

    public String getPublicationDemographic() {
        return publicationDemographic;
    }

    public void setPublicationDemographic(String publicationDemographic) {
        this.publicationDemographic = publicationDemographic;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Short getYear() {
        return year;
    }

    public void setYear(Short year) {
        this.year = year;
    }

    public String getContentRating() {
        return contentRating;
    }

    public void setContentRating(String contentRating) {
        this.contentRating = contentRating;
    }

    public List<MangaTags> getTags() {
        return tags;
    }

    public void setTags(List<MangaTags> tags) {
        this.tags = tags;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

    @Override
    public String toString() {
        return "MangaAttributes{" +
                "title=" + title +
                ", altTitles=" + altTitles +
                ", description=" + description +
                ", isLocked=" + isLocked +
                ", links=" + links +
                ", originalLanguage='" + originalLanguage + '\'' +
                ", lastVolume='" + lastVolume + '\'' +
                ", lastChapter='" + lastChapter + '\'' +
                ", publicationDemographic='" + publicationDemographic + '\'' +
                ", status='" + status + '\'' +
                ", year=" + year +
                ", contentRating='" + contentRating + '\'' +
                ", tags=" + tags +
                ", state='" + state + '\'' +
                ", version=" + version +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }
}
