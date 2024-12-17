package FileSystem.example.FileManagementSystem_Spring.Methods;

import FileSystem.example.FileManagementSystem_Spring.Beans.Directory;
import FileSystem.example.FileManagementSystem_Spring.Beans.File;
import FileSystem.example.FileManagementSystem_Spring.Exceptions.Errors;
import FileSystem.example.FileManagementSystem_Spring.Exceptions.FileManageException;
import FileSystem.example.FileManagementSystem_Spring.Repositories.DirectoryRepository;
import FileSystem.example.FileManagementSystem_Spring.Repositories.FileRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.LazyInitializationException;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@RequiredArgsConstructor
public class RequiredMethods {

    private final DirectoryRepository dirRepo;
    private final FileRepository fileRepo;
    private Integer mainDirId;
    // Todo - finish all methods + add Complexity

    /**
     * Adds a new File under the Directory branch
     * @param parentDirName
     * @param fileName
     * @param fileSize
     * @return true if object was created successfully, exception if it was not created
     */
    public int addFile(String parentDirName, String fileName, Long fileSize) throws FileManageException {
        if(fileRepo.existsByName(fileName) || dirRepo.existsByName(fileName)) {
            throw new FileManageException(Errors.FILE_DIR_NAME_ALREADY_EXISTS);
        }
        Directory parentDir;
        try {
            parentDir = dirRepo.findByName(parentDirName);
            File file = File.builder()
                    .creationDate(LocalDate.now())
                    .name(fileName)
                    .size(fileSize)
                    .directoryId(parentDir.getId())
                    .build();
            fileRepo.saveAndFlush(file);
            System.out.println(file);

            List<File> files = new ArrayList<>();;
            files.add(file);
            parentDir.setFiles(files);
            //fileRepo.saveAll(files);
            dirRepo.saveAndFlush(parentDir);
            return fileRepo.findByName(fileName).getId();
        } catch (LazyInitializationException e) {
            throw new FileManageException(Errors.FILE_DIR_DOES_NOT_EXIST);
        }


    }

    private void SaveFiles(List<File> files) {
    }

    /**
     * Adds a new Directory under the parent Directory
     * @param parentDirName
     * @param dirName
     * @return id of object if object was created successfully, exception if it was not created
     */
    public int addDir(String parentDirName, String dirName) throws FileManageException {
        // Special case - creation of first (main) directory
        if((parentDirName== null) && (dirName == null) ){
            Directory mainDir = Directory.builder()
                    .name("Main Directory")
                    .creationDate(LocalDate.now())
                    .parentDirId(0)
                    .build();
            dirRepo.saveAndFlush(mainDir);
            setMainDirId(dirRepo.findByName("Main Directory").getId());
            return mainDirId;
        }
        if(dirRepo.existsByName(dirName) || fileRepo.existsByName(dirName)) {
            throw new FileManageException(Errors.FILE_DIR_NAME_ALREADY_EXISTS);
        }
        int parentDirId = mainDirId;
        Directory parentDir = FindDirId(parentDirName);
        if(parentDir != null) {
            parentDirId = parentDir.getId();
        }
        else {
            Directory parentDirectory = Directory.builder()
                    .creationDate(LocalDate.now())
                    .name(parentDirName)
                    .parentDirId(parentDirId)
                    .build();
            dirRepo.saveAndFlush(parentDirectory);
            System.out.println("Created Parent Directory: ");
            System.out.println(parentDirectory);
            parentDirId = parentDirectory.getId();
        }

        Directory directory = Directory.builder()
                .creationDate(LocalDate.now())
                .name(dirName)
                .parentDirId(parentDirId)
                .build();
        System.out.println(directory.toString());
        dirRepo.saveAndFlush(directory);
        return dirRepo.findByName(dirName).getId();
    }

    /**
     *
     * @param parentDirName
     * @return directory Id if exists, null if it doesn't exist
     */
    private Directory FindDirId(String parentDirName) throws FileManageException {
        if(!dirRepo.existsByName(parentDirName)) {
            return null;
        }
        return dirRepo.findByName(parentDirName);
    }

    /**
     * Returns the size of the given file
     * @param fileName
     * @return file's size if exists, 0 if doesn't exist
     */
    public long getFileSize(String fileName) {
        if(fileRepo.existsByName(fileName)){
            return fileRepo.findByName(fileName).getSize();
        }
        return 0L;
    }

    /**
     * Returns the name of the file with the maximum size
     * @return file with the largest size or null
     */
    public File getBiggestFile() throws FileManageException {
        return fileRepo.findTopByOrderBySizeDesc()
                .orElseThrow(
                        ()-> new FileManageException(Errors.NO_FILES_IN_SYSTEM) );
    }

    /**
     * Displays all files & directories with their
     * hierarchical structure (a file should display all
     * file properties and a directory should display
     * all directory properties)
     */
    public void showFileSystem(){
        List<Directory> directories = dirRepo.findAll();
        System.out.println("Directories: "+directories);
        //directories.forEach();
//        for(Directory dir : directories) {
//            System.out.println(
//            "Company{" +
//                    "id=" + dir.getId() +
//                    ", name='" + dir.getName() + '\'' +
//                    ", creation date='" + dir.getCreationDate() + '\'' +
//                    ", files=" + dir.getFiles() +
//                    '}'+"\n");
//        }
    }

    /**
     * Deletes the Directory or the File with this name
     * @param name
     * @return true if file or directory were deleted successfully, exception if failed
     */
    public boolean Delete(String name) throws FileManageException {
        if(!fileRepo.existsByName(name)){
            if(!dirRepo.existsByName(name)) {
                throw new FileManageException(Errors.FILE_DIR_DOES_NOT_EXIST);
            }
            Directory directory = dirRepo.findByName(name);
            //Todo - Delete all linked directories and files!
            dirRepo.delete(directory);
            return true;
        }
        File file = fileRepo.findByName(name);
        fileRepo.delete(file);
        return true;
    }

    public void setMainDirId(Integer mainDirId) {
        this.mainDirId = mainDirId;
    }
}
