package com.raja.library_manager.service;

import java.util.List;
import java.util.Optional;

import com.raja.library_manager.entity.Books;
import com.raja.library_manager.entity.Member;

public interface MemberService {

	List<Member> findAll();

	void saveMember(Member member);

	Optional<Member> findById(long theId);

	List<Member> findByFirstNameOrLastName(String searchName);

	void deleteById(long theId);

	void removeBookById(Long theId);

	void returnBook(Long theId);

	 

	 
 
	

}
