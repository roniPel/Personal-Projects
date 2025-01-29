package com.example.SortFiles.Exceptions;

public class SortFilesException extends Exception{
    public SortFilesException(Errors errors) {
        super(errors.getMessage());
    }
}
