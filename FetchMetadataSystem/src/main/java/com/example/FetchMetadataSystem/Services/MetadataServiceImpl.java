package com.example.FetchMetadataSystem.Services;

import com.example.FetchMetadataSystem.Beans.Metadata;
import com.example.FetchMetadataSystem.Exceptions.Errors;
import com.example.FetchMetadataSystem.Exceptions.FetchMetadataException;
import com.example.FetchMetadataSystem.Repositories.MetadataRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Transactional
@RequiredArgsConstructor
public class MetadataServiceImpl implements MetadataService{
    private final MetadataRepository metaRepo;
    @Override
    public Metadata FetchMetadata(String url) throws FetchMetadataException, IOException {

        try {
            // Fetch metadata using Jsoup
            Document document = Jsoup.connect(url).get();

            String title = document.title();
            String description = document.select("meta[name=description").attr("content");
            String imageURL = document.select("meta[name=imageURL").attr("content");

            return Metadata.builder()
                    .title(title)
                    .description(description)
                    .imageURL(imageURL)
                    .build();
        } catch (IOException ioE) {
           throw new FetchMetadataException(Errors.NETWORK_ISSUE);
        } catch (Exception e) {
            throw new FetchMetadataException(Errors.GENERAL_ERROR);
        }
    }
}
