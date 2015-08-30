package org.wcy.wee.demo.excel.model;

public class ExcelData {

	private Long id;
	private String content;
	private String date;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "ExcelData [id=" + id + ", content=" + content + ", date="
				+ date + "]";
	}
	
	
}
