 
package com.raja.library_manager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raja.library_manager.dto.BookIssueDetails;
import com.raja.library_manager.entity.Books;
import com.raja.library_manager.entity.Member;
import com.raja.library_manager.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepository bookrepo;
 
@Override	
public List<Books> findAll(){
		
		return bookrepo.findAll();
	}
 
@Override
public void saveBook(Books book) {
	
	bookrepo.save(book);
}
 
 
@Override
public List<Books> findBytitle(String title){
	
	return bookrepo.findByTitle(title);
}
 
@Override
public List<Books> findAllByOrderByTitle(){
	
	return bookrepo.findAllByOrderByTitleAsc();
}

 
@Override
public Books findById(Long theId) {
	return bookrepo.findById(theId).get();
 
}
 
@Override
public void deleteById(Long theId){
	
	bookrepo.deleteById(theId);
}
 
 
@Override
public List<BookIssueDetails>  getBookandMember(){
	
	return bookrepo.getBookandMember();
}
 
@Override
public void deleteBymemberId(Long theId) {
	
	bookrepo.deleteByMemberId(theId);
}
@Override
public void returnBook(Long theId) {

	Books book = bookrepo.findById(theId).get();

	 Member member = book.getMember();
	 book.setMember(null);

}
 

}





