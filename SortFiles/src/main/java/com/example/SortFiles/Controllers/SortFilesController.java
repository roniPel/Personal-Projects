package com.example.SortFiles.Controllers;

import com.example.SortFiles.Beans.File;
import com.example.SortFiles.Services.SortFilesService;
import com.example.SortFiles.Utilities.SortFilesUtility;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("/Controller")
@RequiredArgsConstructor
public class SortFilesController {
    private final SortFilesService service;
    private final SortFilesUtility utility;

    @PostMapping(value = {"/UploadFiles"})
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> UploadFiles(@RequestBody List<File> files) {
        return new ResponseEntity<>(service.UploadFiles(files),HttpStatus.OK);
    }

    @GetMapping(value = {"/GetFolders"})
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> GetFolders() {
        return new ResponseEntity<>(service.CreateSortedFolders(),HttpStatus.OK);
    }

    @GetMapping(value = {"DownloadSortedFiles"})
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> DownloadSortedFiles() {
        return new ResponseEntity<>(service.SortfilesByCreationDate(),HttpStatus.OK);
    }
}
