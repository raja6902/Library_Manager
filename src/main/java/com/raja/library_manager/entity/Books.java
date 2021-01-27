package com.raja.library_manager.entity;

 
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

 

@Entity
@Table(name="books")
public class Books {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	 
	
	 
	private String title;
	
	
	@Column(name="author" , length=65)
	private String author;
	
	@Column(name="category")
	private String category;
	
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="issue_date")
	private LocalDate issueDate;
	
	 
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="return_date")
	private LocalDate returnDate;
	
	
	 
	@Column(name="fine")
	private Float fine;
	
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST,CascadeType.DETACH})
	@JoinColumn(name="member_id")
	private Member member;

	public Books() {
	 
	}

	public Books(Long id, String title, String author, String category, LocalDate issueDate, LocalDate returnDate,
			Float fine) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.category = category;
		this.issueDate = issueDate;
		this.returnDate = returnDate;
		this.fine = fine;
	}

	public Books(String title, String author, String category, LocalDate issueDate, LocalDate returnDate, Float fine,
			Member member) {
		this.title = title;
		this.author = author;
		this.category = category;
		this.issueDate = issueDate;
		this.returnDate = returnDate;
		this.fine = fine;
		this.member = member;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@Override
	public String toString() {
		return "Books [id=" + id + ", title=" + title + ", author=" + author + ", category=" + category + ", issueDate="
				+ issueDate + ", returnDate=" + returnDate + ", fine=" + fine + "]";
	}
	private void removeMember(Member member) {
		
		this.member.removeBooks(this);
		this.getMember().removeBooks(this);
	}

} 

	 