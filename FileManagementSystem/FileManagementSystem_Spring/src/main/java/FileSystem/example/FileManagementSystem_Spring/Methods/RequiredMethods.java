package FileSystem.example.FileManagementSystem_Spring.Methods;

import org.springframework.stereotype.Component;

@Component
public class RequiredMethods {
    // Todo - finish all methods

    /**
     *
     * @param parentDirName
     * @param fileName
     * @param fileSize
     * @return
     */
    public boolean addFile(String parentDirName, String fileName, Long fileSize) {
        return true;
    }

    /**
     *
     * @param parentDirName
     * @param dirName
     * @return
     */
    public boolean addDir(String parentDirName, String dirName) {
        return true;
    }

    /**
     *
     * @param fileName
     * @return
     */
    public long getFileSize(String fileName) {
        return 0L;
    }

    /**
     *
     * @return
     */
    public String getBiggestFile() {
        return "None";
    }

    /**
     *
     */
    public void showFileSystem(){

    }

    /**
     *
     * @param name
     * @return
     */
    public boolean Delete(String name){
        return true;
    }

}
