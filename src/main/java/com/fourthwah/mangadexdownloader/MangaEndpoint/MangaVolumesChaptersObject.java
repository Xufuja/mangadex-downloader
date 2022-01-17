package com.fourthwah.mangadexdownloader.MangaEndpoint;

public class MangaVolumesChaptersObject {
    private String result;
    private MangaVolumes volumes;

    public MangaVolumesChaptersObject() {

    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public MangaVolumes getVolumes() {
        return volumes;
    }

    public void setVolumes(MangaVolumes volumes) {
        this.volumes = volumes;
    }

    @Override
    public String toString() {
        return "MangaVolumesChaptersObject{" +
                "result='" + result + '\'' +
                ", volumes=" + volumes +
                '}';
    }
}
