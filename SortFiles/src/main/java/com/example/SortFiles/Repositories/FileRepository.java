package com.example.SortFiles.Repositories;

import com.example.SortFiles.Beans.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<File,Integer> {
}
