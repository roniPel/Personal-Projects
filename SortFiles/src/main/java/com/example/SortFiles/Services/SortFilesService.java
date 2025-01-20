package com.example.SortFiles.Services;

import com.example.SortFiles.Beans.File;

import java.util.List;

public interface SortFilesService {
    List<File> GetAllFiles();
    boolean SortfilesByCreationDate();
    boolean UploadFiles(List<File> files);
    boolean CreateSortedFolders();
}
