package com.example.SortFiles.Beans;

import com.fasterxml.jackson.annotation.JsonTypeId;
import org.springframework.stereotype.Component;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Component
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private LocalDateTime creationDate;
}
