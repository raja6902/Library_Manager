package com.raja.library_manager.service;

import java.util.List;
import java.util.Optional;

import com.raja.library_manager.dto.BookIssueDetails;
import com.raja.library_manager.entity.Books;
import com.raja.library_manager.entity.Member;

public interface BookService {

	List<Books> findAll();

	void saveBook(Books book);

	List<Books> findBytitle(String title);

 

	Books findById(Long theId);

	void deleteById(Long theId);

	List<BookIssueDetails> getBookandMember();

	void deleteBymemberId(Long theId);

	List<Books> findAllByOrderByTitle();

	void returnBook(Long theId);
 

 
   
 

}
