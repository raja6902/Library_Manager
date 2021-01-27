package com.raja.library_manager.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.raja.library_manager.dto.BookIssueDetails;

import com.raja.library_manager.entity.Books;

 

public interface BookRepository extends JpaRepository<Books, Long>{
	 
	
	public List<Books> findByTitle(String title);
	Optional<Books> findById(Long theId);
	 @Query("select  b from Books b where b.title Like:searchName OR b.author Like:searchName")
	 public List<Books> findByfirstNameOrlastName(
	           @Param("searchName") String searchName);
 
	 
		
	 @Query("SELECT new com.raja.library_manager.dto.BookIssueDetails(b.title,b.issueDate, b.returnDate,b.fine, m.firstName,m.lastName,m.email) FROM Books b JOIN b.member m")
	 public List<BookIssueDetails> getBookandMember();
		 

	 @Modifying
	    @Query("DELETE Books b WHERE b.member.membershipId = ?1")
	    void deleteByMemberId(Long memberId);
	 
	 public List<Books> findAllByOrderByTitleAsc();

}
