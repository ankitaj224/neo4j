package edu.uic.ids517.model;

import java.io.File;

public class UploadBean {
private File file;
private String extension;
private String uploadType;
public File getFile() {
	return file;
}
public void setFile(File file) {
	this.file = file;
}
public String getExtension() {
	return extension;
}
public void setExtension(String extension) {
	this.extension = extension;
}
public String getUploadType() {
	return uploadType;
}
public void setUploadType(String uploadType) {
	this.uploadType = uploadType;
}


}
