package com.smartcontactmnager.helper;

public class Message {

	private String content;
	public Message(String content, String type) {
		super();
		this.content = content;
		this.type = type;
	}
	private String type;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	


}
