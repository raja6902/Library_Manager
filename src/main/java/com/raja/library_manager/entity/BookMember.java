package com.raja.library_manager.entity;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.Query;

public class BookMember {

	private String title;
	private LocalDate issueDate;
	private LocalDate returnDate;
	private Float fine;
	private String firstName;
	private String lastName;
	private String email;
	public BookMember() {
		 
	}
	public BookMember(String title, LocalDate issueDate, LocalDate returnDate, Float fine,
			String firstName, String lastName, String email) {
		this.title = title;
		this.issueDate = issueDate;
		this.returnDate = returnDate;
		this.fine = fine;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public LocalDate getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}
	public LocalDate getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}
	public Float getFine() {
		return fine;
	}
	public void setFine(Float fine) {
		this.fine = fine;
	}
	 
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}