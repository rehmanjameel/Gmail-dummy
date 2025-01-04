package com.base.gmailclone.model;

public class ItemModel {
    private int imageResId; // Image resource ID from drawable
    private String title;
    private String date;
    private String description;

    public ItemModel(int imageResId, String title, String date, String description) {
        this.imageResId = imageResId;
        this.title = title;
        this.date = date;
        this.description = description;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }
}
