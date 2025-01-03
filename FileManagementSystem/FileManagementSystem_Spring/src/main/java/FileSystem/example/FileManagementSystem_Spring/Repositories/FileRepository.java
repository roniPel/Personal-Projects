package FileSystem.example.FileManagementSystem_Spring.Repositories;

import FileSystem.example.FileManagementSystem_Spring.Beans.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.*;
import java.util.List;
import java.util.Optional;

@Repository
public interface FileRepository extends JpaRepository<File, String> {

    Optional<File> findTopByOrderBySizeDesc();

    List<File> findByDirectoryName(String name);
}
