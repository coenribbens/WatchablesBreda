package com.example.watchablesbreda;

import java.io.Serializable;
import java.util.ArrayList;

public class Watchable implements Serializable {

    private String watchableId;
    private String watchableName;
    private String watchableLocation;
    private String watchableArtist;
    private String watchableMaterial;
    private String watchableDescription;
    private String watchablePostDate;
    private String watchableImageUrl;

    public Watchable(String watchableId, String watchableName, String watchableLocation, String watchableArtist, String watchableMaterial, String watchableDescription, String watchablePostDate, String watchableImageUrl) {
        this.watchableId = watchableId;
        this.watchableName = watchableName;
        this.watchableLocation = watchableLocation;
        this.watchableArtist = watchableArtist;
        this.watchableMaterial = watchableMaterial;
        this.watchableDescription = watchableDescription;
        this.watchablePostDate = watchablePostDate;
        this.watchableImageUrl = watchableImageUrl;
    }

    public String getWatchableId() {
        return watchableId;
    }

    public void setWatchableId(String watchableId) {
        this.watchableId = watchableId;
    }

    public String getWatchableName() {
        return watchableName;
    }

    public void setWatchableName(String watchableName) {
        this.watchableName = watchableName;
    }

    public String getWatchableLocation() {
        return watchableLocation;
    }

    public void setWatchableLocation(String watchableLocation) {
        this.watchableLocation = watchableLocation;
    }

    public String getWatchableArtist() {
        return watchableArtist;
    }

    public void setWatchableArtist(String watchableArtist) {
        this.watchableArtist = watchableArtist;
    }

    public String getWatchableMaterial() {
        return watchableMaterial;
    }

    public void setWatchableMaterial(String watchableMaterial) {
        this.watchableMaterial = watchableMaterial;
    }

    public String getWatchableDescription() {
        return watchableDescription;
    }

    public void setWatchableDescription(String watchableDescription) {
        this.watchableDescription = watchableDescription;
    }

    public String getWatchablePostDate() {
        return watchablePostDate;
    }

    public void setWatchablePostDate(String watchablePostDate) {
        this.watchablePostDate = watchablePostDate;
    }

    public String getWatchableImageUrl() {
        return watchableImageUrl;
    }

    public void setWatchableImageUrl(String watchableImageUrl) {
        this.watchableImageUrl = watchableImageUrl;
    }
}
