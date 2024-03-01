package com.lucas;
/**
 * Writes out computation results, separated by a specified delimiter
 *
 */
public class FileOutputConfig implements OutputConfig {
	
	private final String fileName;

	public FileOutputConfig(String fileName) {
		this.fileName = fileName;
	}

	public String getFileName() {
		return fileName;
	}
}
