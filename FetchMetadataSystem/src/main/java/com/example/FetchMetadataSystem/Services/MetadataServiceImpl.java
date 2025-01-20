package com.example.FetchMetadataSystem.Services;

import com.example.FetchMetadataSystem.Beans.Metadata;
import com.example.FetchMetadataSystem.Exceptions.Errors;
import com.example.FetchMetadataSystem.Exceptions.FetchMetadataException;
import com.example.FetchMetadataSystem.Repositories.MetadataRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.lang.runtime.ObjectMethods;

@Service
@Transactional
@RequiredArgsConstructor
public class MetadataServiceImpl implements MetadataService{
    private final MetadataRepository metaRepo;
    private final RestTemplate restTemplate;
    @Override
    public Metadata FetchMetadata(String url) throws FetchMetadataException, IOException {
        //Todo - verify URL is valid

        // Get all metadata as string
        String myMetaData = restTemplate.getForObject(url, String.class);
        // Use object mapper to map items in the json object
        ObjectMapper objectMapper = new ObjectMapper();
        // Get snippet data, by using items field
        var myData = objectMapper.readTree(myMetaData).get("Items").get(0).get("");

        try {
            // Fetch metadata using Jsoup
            Document document = Jsoup.connect(url).get();

            String title = document.title();
            String description = document.select("meta[name=description").attr("content");
            String imageURL = document.select("meta[name=imageURL").attr("content");

//            Metadata metadata = Metadata.builder()
//                    .title("test")
//                    .imageURL("test")
//                    .description("test")
//                    .URL(url)
//                    .build();

            Metadata metadata = Metadata.builder()
                    .title(title)
                    .description(description)
                    .imageURL(imageURL)
                    .URL(url)
                    .build();

            metaRepo.saveAndFlush(metadata);
            return metadata;
        } catch (IOException ioE) {
           throw new FetchMetadataException(Errors.NETWORK_ISSUE);
        } catch (Exception e) {
            throw new FetchMetadataException(Errors.GENERAL_ERROR);
        }
    }
}
