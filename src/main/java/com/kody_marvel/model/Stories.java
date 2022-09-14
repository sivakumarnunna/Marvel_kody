package com.kody_marvel.model;

import java.util.ArrayList;

public class Stories {
	
    public int available;
    public String collectionURI;
    public ArrayList<Item> items;
    public int returned;
	public int getAvailable() {
		return available;
	}
	public void setAvailable(int available) {
		this.available = available;
	}
	public String getCollectionURI() {
		return collectionURI;
	}
	public void setCollectionURI(String collectionURI) {
		this.collectionURI = collectionURI;
	}
	public ArrayList<Item> getItems() {
		return items;
	}
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
	public int getReturned() {
		return returned;
	}
	public void setReturned(int returned) {
		this.returned = returned;
	}
	@Override
	public String toString() {
		return "Stories [available=" + available + ", collectionURI=" + collectionURI + ", items=" + items
				+ ", returned=" + returned + "]";
	}


}
