package FileSystem.example.FileManagementSystem_Spring.Clr_Test;

import FileSystem.example.FileManagementSystem_Spring.Methods.RequiredMethods;
import FileSystem.example.FileManagementSystem_Spring.Utils.FactoryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class Test_CRUD implements CommandLineRunner {
    @Autowired
    private RequiredMethods requiredMethods;
    @Override
    public void run(String... args) throws Exception {
        // CRUD - Create, Read, Update, Delete
        System.out.println("Start running CommandLineRunner Testing");
        // Add File
        AddFile();
        
        // Add Dir
        AddDir();
        
        // Get file size
        GetFileSize();

        // Get Biggest File
        GetBiggestFile();
        
        // Delete
        Delete();

    }

    //Todo - finish all tests

    private void Delete() {
        String name = "";
        requiredMethods.Delete(name);
    }

    private void GetBiggestFile() {
        requiredMethods.getBiggestFile();
    }

    private void GetFileSize() {
        String fileName = "";
        requiredMethods.getFileSize(fileName);
    }

    private void AddDir() {
        String parentDirName = "";
        String dirName = "";
        requiredMethods.addDir(parentDirName,dirName);
    }

    private void AddFile(){
        String parentDirName = "";
        String fileName = "";
        long fileSize = FactoryUtils.GenerateRandomSize();
        requiredMethods.addFile(parentDirName,fileName,fileSize);
    }

}
