package com.example.FetchMetadataSystem.Models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Metadata {
    private String title;
    private String description;
    private String imageURL;

    public Metadata(String title, String description, String imageURL) {
        this.title = title;
        this.description = description;
        this.imageURL = imageURL;
    }
}
