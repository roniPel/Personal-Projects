package com.example.FetchMetadataSystem.Controllers;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;
import org.springframework.stereotype.Component;

@Getter
@Setter
public class UrlRequest {
    @NotNull(message = "URL cannot be null")
    @URL(message = "Invalid URL format")
    private String url;

}
