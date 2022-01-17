package com.fourthwah.mangadexdownloader.MangaEndpoint;

import java.util.List;

public class MangaTagAttributes {
    private MangaProperties name;
    private List<String> description;
    private String group;
    private Byte version;

    public MangaTagAttributes() {

    }

    public MangaProperties getName() {
        return name;
    }

    public void setName(MangaProperties name) {
        this.name = name;
    }

    public List<String> getDescription() {
        return description;
    }

    public void setDescription(List<String> description) {
        this.description = description;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Byte getVersion() {
        return version;
    }

    public void setVersion(Byte version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "MangaTagAttributes{" +
                "name=" + name +
                ", description=" + description +
                ", group='" + group + '\'' +
                ", version=" + version +
                '}';
    }
}
