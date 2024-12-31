package com.example.FetchMetadataSystem.Models;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Metadata {
    private String title;
    private String description;
    private String imageURL;

//    public Metadata(String title, String description, String imageURL) {
//        this.title = title;
//        this.description = description;
//        this.imageURL = imageURL;
//    }
}
