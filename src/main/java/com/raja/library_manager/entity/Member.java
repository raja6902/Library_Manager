package com.raja.library_manager.entity;

 
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity; 
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id; 
import javax.persistence.OneToMany; 
import javax.persistence.Table;
 
@Entity
@Table(name="member")
public class Member {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="member_id")
	private Long membershipId;
	
	@Column(name="first_name" ,length=45, nullable=false)
	private String firstName;
	
	@Column(name="last_name",length=45, nullable=false)
	private String lastName;
	
	private String email;
    
	@Column(name="first_line_address")
	private String firstLineOfAddress;
	
	private String city;
	
	private String postcode;
	
	private String phonenumber;
	
	@OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST,CascadeType.DETACH}, mappedBy = "member")
	private List<Books> book;

	public Member() {
		 
	}
	

 

	public Member(Long membershipId, String firstName, String lastName, String email, String firstLineOfAddress,
			String city, String postcode, String phonenumber, List<Books> book) {
		this.membershipId = membershipId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.firstLineOfAddress = firstLineOfAddress;
		this.city = city;
		this.postcode = postcode;
		this.phonenumber = phonenumber;
		this.book = book;
	}

 
	public Member(String firstName, String lastName, String email, String firstLineOfAddress, String city,
			String postcode, String phonenumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.firstLineOfAddress = firstLineOfAddress;
		this.city = city;
		this.postcode = postcode;
		this.phonenumber = phonenumber;
	}




	public Long getMembershipId() {
		return membershipId;
	}

	public void setMembershipId(Long membershipId) {
		this.membershipId = membershipId;
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

 
public String getFirstLineOfAddress() {
		return firstLineOfAddress;
	}




	public void setFirstLineOfAddress(String firstLineOfAddress) {
		this.firstLineOfAddress = firstLineOfAddress;
	}




	public String getCity() {
		return city;
	}




	public void setCity(String city) {
		this.city = city;
	}




	public String getPostcode() {
		return postcode;
	}




	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}




	public String getPhonenumber() {
		return phonenumber;
	}




	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}




public List<Books> getBook() {
	return book;
}


public void setBook(List<Books> book) {
	this.book = book;
}

public void removeBooks(Books b) {
	
	this.book.remove(b);
	b.getMember().removeBooks(b);
	
 	
}


 


@Override
public String toString() {
	return "Member [membershipId=" + membershipId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
			+ email + ", firstLineOfAddress=" + firstLineOfAddress + ", city=" + city + ", postcode=" + postcode
			+ ", phonenumber=" + phonenumber + "]";
}




public void addBook(Books tempBook) {
	
if(book==null) {
	book=new ArrayList<>();
}
book.add(tempBook);
tempBook.setMember(this);

}




public void removeBooks(List<Books> book2 ) {
	this.book.remove(book2);
 
	
	
}
 
}














	 