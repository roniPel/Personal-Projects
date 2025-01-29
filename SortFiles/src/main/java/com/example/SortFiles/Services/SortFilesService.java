package com.example.SortFiles.Services;

import com.example.SortFiles.Beans.File;

import java.util.List;

public interface SortFilesService {
    List<File> GetAllFiles();   //Verify files exist, Create folders, sort.
    boolean SortfilesByCreationDate();  // Verify files exist, create folders.
    boolean UploadFiles(List<File> files);
    boolean CreateSortedFolders();
}
