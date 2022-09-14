package com.kody_marvel.model;

import java.util.ArrayList;

public class Data {
	
    public int offset;
    public int limit;
    public int total;
    public int count;
    public ArrayList<Result> results;
    
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public ArrayList<Result> getResults() {
		return results;
	}
	public void setResults(ArrayList<Result> results) {
		this.results = results;
	}
	@Override
	public String toString() {
		return "Data [offset=" + offset + ", limit=" + limit + ", total=" + total + ", count=" + count + ", results="
				+ results + "]";
	}


}
