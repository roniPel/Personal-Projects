package com.example.SortFiles.Services;

import com.example.SortFiles.Beans.File;
import com.example.SortFiles.Repositories.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
//@Transactional
public class SortFilesServiceImpl implements SortFilesService{
    private final FileRepository fileRepo;
    @Override
    //Verify files exist, Create folders, sort.
    public List<File> GetAllFiles() {
        // Check if repo is empty
        // Check if files are sorted
        // Check if folders exist
        return null;
    }

    @Override
    //Verify files exist, Create folders,
    public boolean SortfilesByCreationDate() {
        return false;
    }

    @Override
    public boolean UploadFiles(List<File> files) {
        return false;
    }

    @Override
    public boolean CreateSortedFolders() {
        return false;
    }
}
