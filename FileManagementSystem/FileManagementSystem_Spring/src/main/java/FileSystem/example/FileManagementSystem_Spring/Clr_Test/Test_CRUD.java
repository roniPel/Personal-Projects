package FileSystem.example.FileManagementSystem_Spring.Clr_Test;

import FileSystem.example.FileManagementSystem_Spring.Beans.File;
import FileSystem.example.FileManagementSystem_Spring.Exceptions.FileManageException;
import FileSystem.example.FileManagementSystem_Spring.Methods.RequiredMethods;
import FileSystem.example.FileManagementSystem_Spring.Utils.FactoryUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.nio.file.FileSystemException;

@Component
@Order(1)
@RequiredArgsConstructor
public class Test_CRUD implements CommandLineRunner {
    private final RequiredMethods requiredMethods;
    @Override
    public void run(String... args) throws Exception {
        try {
            // CRUD - Create, Read, Update, Delete
            GenerateMainDirectory();
            // Add Dir
            AddDir();

            // Add File
            AddFile();

            // Get file size
            GetFileSize();

            // Get Biggest File
            GetBiggestFile();

            // ShowAll
            ShowAll();

            // Delete
            Delete();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void GenerateMainDirectory() throws FileManageException {
        requiredMethods.addDir(null,null);
    }

    private void ShowAll() {
        System.out.println("*** Show All Method ***");
        requiredMethods.showFileSystem();
        System.out.println();
    }

    //Todo - finish all tests

    private void Delete() throws FileManageException {
        System.out.println("*** Delete Method ***");
        String name = "Test File 1";
        System.out.print("File / Directory was deleted? ");
        System.out.println(requiredMethods.Delete(name));
    }

    private void GetBiggestFile() throws FileManageException {
        System.out.println("*** Get Biggest File Method ***");
        File biggestFile = requiredMethods.getBiggestFile();
        System.out.println("The biggest file is: '"
                + biggestFile.getName() +
                "' with a size of: " + biggestFile.getSize());
        System.out.println();
    }

    private void GetFileSize() {
        System.out.println("*** Get File Size Method ***");
        String fileName = "Test File 1";
        System.out.print("File '"+ fileName + "' size is: ");
        System.out.println(requiredMethods.getFileSize(fileName));
        System.out.println();
    }

    private void AddDir() throws FileManageException {
        System.out.println("*** Add Directory Method ***");
        //System.out.println("Please insert a Directory Name: ");
        String parentDirName = "Main Directory";
        String dirName = "Test Dir 1";
        System.out.print("Directory added successfully? ");
        System.out.println(
                requiredMethods.addDir(parentDirName,dirName));
        System.out.println();
    }

    private void AddFile() throws FileManageException {
        System.out.println("*** Add File Method ***");
        String parentDirName = "Test Dir 1";
        String fileName = "Test File 1";
        long fileSize = FactoryUtils.GenerateRandomSize();
        System.out.print("File added successfully? ");
        System.out.println(
                requiredMethods.addFile(parentDirName,fileName,fileSize));
        System.out.println();
    }

}
