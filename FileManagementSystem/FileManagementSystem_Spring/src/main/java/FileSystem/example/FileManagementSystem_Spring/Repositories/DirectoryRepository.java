package FileSystem.example.FileManagementSystem_Spring.Repositories;

import FileSystem.example.FileManagementSystem_Spring.Beans.Directory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectoryRepository extends JpaRepository<Directory,Integer> {
    Directory findByName(String name);

    boolean existsByName(String parentDirName);
}
