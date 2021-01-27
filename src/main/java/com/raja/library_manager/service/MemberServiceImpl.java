package com.raja.library_manager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raja.library_manager.entity.Books;
import com.raja.library_manager.entity.Member;
import com.raja.library_manager.repository.BookRepository;
import com.raja.library_manager.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberRepository memberRepo;
	
	@Autowired
	private BookRepository bookrepo;
	@Override
	public List<Member> findAll(){
		
		return memberRepo.findAll();
	}
	
 
@Override	
public void saveMember(Member member) {
	
	memberRepo.save(member);
}
 
 
 

@Override
public void deleteById(long theId){
	
	memberRepo.deleteById(theId);
}
 
 
@Override
public List<Member> findByFirstNameOrLastName(String searchName){
	
	return memberRepo.findByfirstNameOrlastName(searchName);
}


@Override
public Optional<Member> findById(long id) {
	 
	return memberRepo.findById(id);
}
 
@Override 
public void removeBookById(Long theId) {
	Member memb = new Member();
	Books book = bookrepo.findById(theId).get();
	memb.removeBooks(book);
	
}

@Override
public void returnBook(Long theId) {
	
	Member member = memberRepo.findById(theId).get();
	List<Books> book = member.getBook();
 
    
}

}






