package com.avenga.fileservice.service;

public interface FileService {

	long countFiles();
	void saveFile(String name, byte[] content);
}
