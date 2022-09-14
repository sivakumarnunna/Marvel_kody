package com.kody_marvel.model;

public class Url {
	
	public String type;
    public String url;
    

    public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "Url [type=" + type + ", url=" + url + "]";
	}


}
