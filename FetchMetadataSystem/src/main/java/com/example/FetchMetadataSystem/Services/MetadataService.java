package com.example.FetchMetadataSystem.Services;

import com.example.FetchMetadataSystem.Beans.Metadata;
import com.example.FetchMetadataSystem.Exceptions.FetchMetadataException;
import org.springframework.stereotype.Service;

import java.io.IOException;


public interface MetadataService {
    Metadata FetchMetadata(String url) throws FetchMetadataException, IOException;
}
