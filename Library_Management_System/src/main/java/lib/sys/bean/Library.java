package lib.sys.bean;

import javax.persistence.*;

import org.springframework.stereotype.Component;

@Entity
public class Library {
	
	
	public Library() {
		
	}
	
	

	public Library(String bookName, String author, byte[] picByte) {
		super();
		this.bookName = bookName;
		this.author = author;
		this.picByte = picByte;
	}



	@Id

	private String bookName;

	private String author;

	private byte[] picByte;

	public String getBookName() {
		return bookName;
	}



	public void setBookName(String bookName) {
		this.bookName = bookName;
	}



	public String getAuthor() {
		return author;
	}



	public void setAuthor(String author) {
		this.author = author;
	}



	public byte[] getPicByte() {
		return picByte;
	}



	public void setPicByte(byte[] picByte) {
		this.picByte = picByte;
	}

	

	
	
	
	
}
