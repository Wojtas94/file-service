package com.avenga.fileservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avenga.fileservice.model.File;
import com.avenga.fileservice.repository.FileRepository;

@Service
public class FileServiceImpl implements FileService {
	
	private final FileRepository fileRepository;
	
	@Autowired
	public FileServiceImpl(FileRepository fileRepository) {
		this.fileRepository = fileRepository;
	}

	@Override
	public long countFiles() {
		return fileRepository.count();
	}

	@Override
	public void saveFile(String name, byte[] content) {
		fileRepository.save(new File(name, content));
	}
}
