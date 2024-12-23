package com.example.FetchMetadataSystem.Beans;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Metadata {
    @Id
    private String URL;
    private String title;
    private String description;
    private String imageURL;
}
