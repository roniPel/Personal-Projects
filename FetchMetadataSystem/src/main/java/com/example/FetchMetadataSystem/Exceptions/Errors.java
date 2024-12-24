package com.example.FetchMetadataSystem.Exceptions;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public enum Errors {
    INVALID_URL("\nThe inserted URL is invalid.  Please try a different URL. \n"),
    NETWORK_ISSUE("\nThere was a problem with the network.  Please fix the network issue and then try again. \n"),
    GENERAL_ERROR("\nThere was an error. Please try again later. \n"),
    ILLEGAL_ARGUMENT("\nAn illegal argument was inserted.  Please check input. \n"),
    VALIDATION_ERROR("\n The validation failed.  Please check that your data was inserted correctly. \n");

    private String message;

    Errors(String message) {
        this.message = message;
    }
}
