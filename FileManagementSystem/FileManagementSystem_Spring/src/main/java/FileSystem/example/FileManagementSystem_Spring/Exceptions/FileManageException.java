package FileSystem.example.FileManagementSystem_Spring.Exceptions;

public class Exception extends java.lang.Exception {

    public Exception(Errors errors) {
        super(errors.getMessage());
    }
}
