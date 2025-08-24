package com.avenga.fileservice.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.avenga.fileservice.service.FileService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import java.io.File;
import java.nio.file.Files;

@Component
@Slf4j
public class FileScheduler {

    private final FileService fileService;

    @Value("${file.watch.folder}")
    private String folderPath;

    public FileScheduler(FileService fileService) {
        this.fileService = fileService;
    }

    @Scheduled(fixedRate = 600_000)
    public void processFiles() {
        File folder = new File(folderPath);
        File[] files = folder.listFiles();
        if (files == null) return;

        for (File file : files) {
            if (file.isFile()) {
                try {
                    byte[] content = Files.readAllBytes(file.toPath());
                    fileService.saveFile(file.getName(), content);
                    Files.delete(file.toPath());
                } catch (Exception e) {
                	log.error("Failed to process file: {}", file.getName(), e);
                }
            }
        }
    }
}
