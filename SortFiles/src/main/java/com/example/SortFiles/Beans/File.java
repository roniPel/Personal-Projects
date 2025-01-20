package com.example.SortFiles.Beans;

import com.fasterxml.jackson.annotation.JsonTypeId;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class File {
    private int id;
    private String name;
    private LocalDateTime creationDate;
}
