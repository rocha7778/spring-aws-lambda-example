package com.rocha.aws.app.model;

public class Book {
	
	private String id;
	private String text;
	
	
	public Book() {
	}

	public Book(String id, String text) {
		super();
		this.id = id;
		this.text = text;
	}

	public String getId() {
		return id;
	}

	public String getText() {
		return text;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", text=" + text + "]";
	}
	
	
}
