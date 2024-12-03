package FileSystem.example.FileManagementSystem_Spring.Clr_Test;

import FileSystem.example.FileManagementSystem_Spring.Methods.RequiredMethods;
import FileSystem.example.FileManagementSystem_Spring.Utils.FactoryUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
@RequiredArgsConstructor
public class Test_CRUD implements CommandLineRunner {
    private final RequiredMethods requiredMethods;
    @Override
    public void run(String... args) throws Exception {
        try {
            // CRUD - Create, Read, Update, Delete
            System.out.println("Start running CommandLineRunner Testing");

            // Add Dir
            AddDir();

            // Add File
            AddFile();

            // Get file size
            GetFileSize();

            // Get Biggest File
            GetBiggestFile();

            // Delete
            Delete();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
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
        System.out.println("*** Add Directory Method ***");
        //System.out.println("Please insert a Directory Name: ");
        String parentDirName = "Main Directory";
        String dirName = "Test Dir 1";
        requiredMethods.addDir(parentDirName,dirName);
    }

    private void AddFile(){
        String parentDirName = "Test Dir 1";
        String fileName = "Test File 1";
        long fileSize = FactoryUtils.GenerateRandomSize();
        requiredMethods.addFile(parentDirName,fileName,fileSize);
    }

}
