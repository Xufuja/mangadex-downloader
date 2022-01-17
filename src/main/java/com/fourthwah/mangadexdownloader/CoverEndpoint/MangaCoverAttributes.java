package com.fourthwah.mangadexdownloader.CoverEndpoint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MangaCoverAttributes {
    private String description;
    private String volume;
    private String fileName;
    private String createdAt;
    private String updatedAt;
    private Byte version;

    public MangaCoverAttributes() {

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
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

    public Byte getVersion() {
        return version;
    }

    public void setVersion(Byte version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "CoverAttributes{" +
                "description='" + description + '\'' +
                ", volume='" + volume + '\'' +
                ", fileName='" + fileName + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", version=" + version +
                '}';
    }
}
