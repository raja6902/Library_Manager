package com.raja.library_manager.dto;

import java.time.LocalDate;

import javax.persistence.Entity;
 
public class BookIssueDetails {
	
	private String title;
	
	private LocalDate issueDate;
	
	private LocalDate returnDate; 
	
	private Float fine;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	 

	public BookIssueDetails(String title, LocalDate issueDate, LocalDate returnDate, Float fine, String firstName, String lastName,
			String email) {
		this.title = title;
		this.issueDate = issueDate;
		this.returnDate = returnDate;
		this.fine=fine;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public BookIssueDetails() {
		 
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

	@Override
	public String toString() {
		return "BookIssueDetails [title=" + title + ", issueDate=" + issueDate + ", returnDate=" + returnDate + "fine=" + fine
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
	

}
