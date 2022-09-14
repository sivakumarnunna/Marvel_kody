package com.kody_marvel.model;

public class Thumbnail {
	
    public String path;
    public String extension;
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	@Override
	public String toString() {
		return "Thumbnail [path=" + path + ", extension=" + extension + "]";
	}


}
