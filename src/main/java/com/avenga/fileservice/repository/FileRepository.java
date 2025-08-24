package com.avenga.fileservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.avenga.fileservice.model.File;

public interface FileRepository extends MongoRepository<File, String> {
}
