package com.example.FetchMetadataSystem.Repositories;

import com.example.FetchMetadataSystem.Beans.Metadata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetadataRepository extends JpaRepository<Metadata, String> {
}
