package FileSystem.example.FileManagementSystem_Spring.Repositories;

import FileSystem.example.FileManagementSystem_Spring.Beans.Directory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DirectoryRepository extends JpaRepository<Directory,String> {
    List<Directory> findByParentDir(String parentDir);
}
