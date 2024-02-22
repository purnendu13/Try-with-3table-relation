package com.example.tableRelationDemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="bookEntity")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookEntity {
	@Id
	private int bookId;
	private String bookName;
	private int bookQuantity;
	
	public int getBookId() {
		return bookId;
	}

	public void setBookId(int i) {
		this.bookId = i;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getBookQuantity() {
		return bookQuantity;
	}

	public void setBookQuantity(int bookQuantity) {
		this.bookQuantity = bookQuantity;
	}

	
	
	@OneToOne(mappedBy = "bookEntity")
	private StudentEntity studentEntity;

}
