package com.example.SortFiles.Exceptions;

import lombok.Getter;

@Getter
public enum Errors {
    NO_FILES_IN_SYSTEM("\nThere are no files uploaded to the system. \nPlease upload files and then try again.\n"),
    GENERAL_ERROR("\nAn error occurred.  Please try again.\n");
    private String message;

    /**
     * Constructor which inserts the relevant message into each error.
     * @param message String message relevant for each error
     */
    Errors(String message){
        this.message = message;
    }
}
