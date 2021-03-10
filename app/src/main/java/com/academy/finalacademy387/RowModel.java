package com.academy.finalacademy387;

import java.io.Serializable;

//RowModel rm1 = new RowModel();
//rm1.title
//rm1.description
public class RowModel implements Serializable {

    private String title;
    private String description;
    private int imageResourceId;

    public RowModel(){
        super();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }
}
