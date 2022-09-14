package com.kody_marvel.model;

public class Root {
	
	public int code;
    public String status;
    public String copyright;
    public String attributionText;
    public String attributionHTML;
    public String etag;
    public Data data;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCopyright() {
		return copyright;
	}
	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}
	public String getAttributionText() {
		return attributionText;
	}
	public void setAttributionText(String attributionText) {
		this.attributionText = attributionText;
	}
	public String getAttributionHTML() {
		return attributionHTML;
	}
	public void setAttributionHTML(String attributionHTML) {
		this.attributionHTML = attributionHTML;
	}
	public String getEtag() {
		return etag;
	}
	public void setEtag(String etag) {
		this.etag = etag;
	}
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "Root [code=" + code + ", status=" + status + ", copyright=" + copyright + ", attributionText="
				+ attributionText + ", attributionHTML=" + attributionHTML + ", etag=" + etag + ", data=" + data + "]";
	}


}
