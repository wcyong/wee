package org.wcy.weixin.json;

public class ModelMsgData {

	private String value;
	private String color;
	
	public ModelMsgData() {
	}
	
	public ModelMsgData(String value, String color) {
		this.value = value;
		this.color = color;
	}


	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	
}
