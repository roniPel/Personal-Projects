package com.example.FetchMetadataSystem.Exceptions;

public class FetchMetadataException extends Exception{
    public FetchMetadataException(Errors errors) {
        super(errors.getMessage());
    }

}
