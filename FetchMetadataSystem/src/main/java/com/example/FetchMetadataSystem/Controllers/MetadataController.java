package com.example.FetchMetadataSystem.Controllers;

import com.example.FetchMetadataSystem.Beans.Metadata;
import com.example.FetchMetadataSystem.Exceptions.FetchMetadataException;
import com.example.FetchMetadataSystem.Services.MetadataService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
//@CrossOrigin()
//@RequiredArgsConstructor
@RequestMapping("/FetchMetadata")
public class MetadataController {
    @Autowired
    private MetadataService metadataService;

//    @PostMapping
//    public ResponseEntity<?> FetchMetadata
//            (@RequestBody @Valid UrlRequest urlRequest)
//            throws FetchMetadataException, IOException {
//        try {
//            return new ResponseEntity<>
//                    (metadataService.FetchMetadata
//                            (urlRequest.getUrl()), HttpStatus.OK);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Error fetching metadata: "+e.getMessage());
//        }
//    }

    @PostMapping
    public ResponseEntity<?> FetchMetadata
            (@RequestBody @Valid String url)
            throws FetchMetadataException, IOException {
        try {
            return new ResponseEntity<>
                    (metadataService.FetchMetadata
                            (url), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error fetching metadata: "+e.getMessage());
        }
    }
}
