package com.academy.finalacademy387.book.model;

import java.util.List;

public class VolumeInfo {
    private String title;
    private String publisher;
    private String description;
    private List<VolumeInfo> imageLinks;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<VolumeInfo> getImageLinks() {
        return imageLinks;
    }

    public void setImageLinks(List<VolumeInfo> imageLinks) {
        this.imageLinks = imageLinks;
    }
}
