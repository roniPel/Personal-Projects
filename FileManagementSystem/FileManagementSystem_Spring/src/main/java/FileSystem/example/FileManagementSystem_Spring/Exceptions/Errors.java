package FileSystem.example.FileManagementSystem_Spring.Exceptions;

import lombok.Getter;

@Getter
public enum Errors {
    FILE_DIR_NAME_ALREADY_EXISTS("\nThe file or directory name already exists! \n"),
    FILE_DIR_DOES_NOT_EXIST("\nThe file or directory do not exist in the system! \n"),
    NO_FILES_IN_SYSTEM("\nThere are no files in the system! \n"),
    GENERAL_ERROR("\nThere was an error. Please try again later. \n");

     private String message;
     Errors(String message) {
         this.message = message;
     }
}
