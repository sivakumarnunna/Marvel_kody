package com.kody_marvel.model;

public class Item {
    public String resourceURI;
    public String name;
    public String type;
	public String getResourceURI() {
		return resourceURI;
	}
	public void setResourceURI(String resourceURI) {
		this.resourceURI = resourceURI;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Item [resourceURI=" + resourceURI + ", name=" + name + ", type=" + type + "]";
	}


}
