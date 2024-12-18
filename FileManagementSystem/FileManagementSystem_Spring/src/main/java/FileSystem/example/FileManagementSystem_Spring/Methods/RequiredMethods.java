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
    private final String mainDirName = "Main";
    // Todo - finish all methods + add Complexity

    /**
     * Adds a new File under the Directory branch
     * @param parentDirName - parent directory name
     * @param fileName - new file name
     * @param fileSize - new file size
     * @return true if object was created successfully, exception if it was not created
     * Complexity: time - o(log(n)), space - o(1)
     */
    public boolean addFile(String parentDirName, String fileName, Long fileSize) throws FileManageException {
        // Verifications:
        // Case: filename already exists
        if(fileRepo.existsById(fileName) || dirRepo.existsById(fileName)) {
            throw new FileManageException(Errors.FILE_DIR_NAME_ALREADY_EXISTS);
        }
        // case: parent directory doesn't exist
        Directory parentDir;
        parentDir = dirRepo.findById(parentDirName).orElseThrow(
                ()-> new FileManageException(Errors.FILE_DIR_DOES_NOT_EXIST)
        );

        // Create new file
        File file = File.builder()
                .creationDate(LocalDate.now())
                .name(fileName)
                .size(fileSize)
                .directoryName(parentDir.getName())
                .build();
        fileRepo.saveAndFlush(file);
        System.out.println(file);

        List<File> files = new ArrayList<>();;
        files.add(file);
        parentDir.setFiles(files);
        //fileRepo.saveAll(files);
        dirRepo.saveAndFlush(parentDir);
        return true;
    }

    /**
     * Adds a new Directory under the parent Directory
     * @param parentDirName - parent directory name
     * @param dirName - new directory name
     * @return true if object was created successfully, exception if it was not created
     * Complexity: time - o(log(n)), space - o(1)
     */
    public boolean addDir(String parentDirName, String dirName) throws FileManageException {
        // Verifications:
        // Special case - creation of first (main) directory
        if((parentDirName== null) && (dirName == null) ){
            Directory mainDir = Directory.builder()
                    .name(mainDirName)
                    .creationDate(LocalDate.now())
                    .parentDir("")
                    .build();
            dirRepo.saveAndFlush(mainDir);
            return true;
        }
        // case: Parent Dir doesn't exist / value entered is null
        if( (parentDirName==null) || (!dirRepo.existsById(parentDirName)) ) {
            throw new FileManageException(Errors.FILE_DIR_DOES_NOT_EXIST);
        }
        // case: directory/ file name already exists
        if(dirRepo.existsById(dirName) || fileRepo.existsById(dirName)) {
            throw new FileManageException(Errors.FILE_DIR_NAME_ALREADY_EXISTS);
        }

        // Create new directory
        Directory parentDirectory = Directory.builder()
                .creationDate(LocalDate.now())
                .name(parentDirName)
                .parentDir(parentDirName)
                .build();
        dirRepo.saveAndFlush(parentDirectory);
        System.out.println("Created Parent Directory: ");
        System.out.println(parentDirectory.getName());


        Directory directory = Directory.builder()
                .creationDate(LocalDate.now())
                .name(dirName)
                .build();
        System.out.println(directory.toString());
        dirRepo.saveAndFlush(directory);
        return true;
    }

    /**
     * Returns the size of the given file
     * @param fileName - file name
     * @return file's size if exists, exception if file doesn't exist
     * Complexity: time - o(log(n)), space - o(1)
     */
    public long getFileSize(String fileName) throws FileManageException {
        File file = fileRepo.findById(fileName).orElseThrow(
                () -> new FileManageException(Errors.FILE_DIR_DOES_NOT_EXIST)
        );
        return file.getSize();
    }

    /**
     * Returns the name of the file with the maximum size
     * @return file with the largest size or exception if no files exist in system
     * Complexity: time - o(n), space - o(1)
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
     * Complexity: time - o(n), space - o(n)
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
     * @param name - name of file or directory to delete
     * @return true if file or directory were deleted successfully, exception if failed
     * Complexity: time - o(n), space - o(n)
     */
    public boolean Delete(String name) throws FileManageException {
        // Verify file/ directory exists
        if(!fileRepo.existsById(name)){
            if(!dirRepo.existsById(name)) {
                throw new FileManageException(Errors.FILE_DIR_DOES_NOT_EXIST);
            }

            // Case: delete a directory

            // Step 1 - find all sub-files
            List<File> filesToDelete = fileRepo.findByDirectoryName(name);
            // Step 2 - find all subdirectories
            List<Directory> directoriesToDelete = dirRepo.findByParentDir(name);

            // Step 3 - delete all sub-files and sub-directories
            fileRepo.deleteAll(filesToDelete);
            dirRepo.deleteAll(directoriesToDelete);
            return true;
        }

        // Case: delete a file
        File file = fileRepo.findById(name).get();
        fileRepo.delete(file);
        return true;
    }
}
