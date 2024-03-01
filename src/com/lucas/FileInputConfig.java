package com.lucas;

/**
 * Supports a text file input of numbers, one number per line.
 * 
 * Ex:
 * 1
 * 2
 * 10
 */
public class FileInputConfig implements InputConfig {

	private final String fileName;

	public FileInputConfig(String fileName) {
		this.fileName = fileName;
	}

	public String getFileName() {
		return fileName;
	}
}
