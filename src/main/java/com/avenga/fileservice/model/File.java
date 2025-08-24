package com.avenga.fileservice.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "files")
@Data
public class File {
    
    @Id
    private String id;
    
    private String filename;
    private byte[] content;
    private Date uploadDate;
    
    public File(String filename, byte[] content) {
        this.filename = filename;
        this.content = content;
        this.uploadDate = new Date();
    }

}
