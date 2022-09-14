package com.kody_marvel.model;

import java.util.ArrayList;
import java.util.Date;

public class Result {
	
	    public int id;
	    public String name;
	    public String description;
	    public String modified;
	    public Thumbnail thumbnail;
	    public String resourceURI;
	    public Comics comics;
	    public Series series;
	    public Stories stories;
	    public Events events;
	    public ArrayList<Url> urls;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getModified() {
			return modified;
		}
		public void setModified(String modified) {
			this.modified = modified;
		}
		public Thumbnail getThumbnail() {
			return thumbnail;
		}
		public void setThumbnail(Thumbnail thumbnail) {
			this.thumbnail = thumbnail;
		}
		public String getResourceURI() {
			return resourceURI;
		}
		public void setResourceURI(String resourceURI) {
			this.resourceURI = resourceURI;
		}
		public Comics getComics() {
			return comics;
		}
		public void setComics(Comics comics) {
			this.comics = comics;
		}
		public Series getSeries() {
			return series;
		}
		public void setSeries(Series series) {
			this.series = series;
		}
		public Stories getStories() {
			return stories;
		}
		public void setStories(Stories stories) {
			this.stories = stories;
		}
		public Events getEvents() {
			return events;
		}
		public void setEvents(Events events) {
			this.events = events;
		}
		public ArrayList<Url> getUrls() {
			return urls;
		}
		public void setUrls(ArrayList<Url> urls) {
			this.urls = urls;
		}
		@Override
		public String toString() {
			return "Result [id=" + id + ", name=" + name + ", description=" + description + ", modified=" + modified
					+ ", thumbnail=" + thumbnail + ", resourceURI=" + resourceURI + ", comics=" + comics + ", series="
					+ series + ", stories=" + stories + ", events=" + events + ", urls=" + urls + "]";
		}
	}


