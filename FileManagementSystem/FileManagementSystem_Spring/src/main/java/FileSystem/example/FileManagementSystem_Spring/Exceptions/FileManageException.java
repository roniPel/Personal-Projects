package FileSystem.example.FileManagementSystem_Spring.Exceptions;

public class FileManageException extends java.lang.Exception {

    public FileManageException(Errors errors) {
        super(errors.getMessage());
    }
}
