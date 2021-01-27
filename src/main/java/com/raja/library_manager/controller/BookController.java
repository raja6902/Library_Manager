package com.raja.library_manager.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.raja.library_manager.dto.BookIssueDetails;
import com.raja.library_manager.entity.Books;
import com.raja.library_manager.entity.Member;
import com.raja.library_manager.service.BookService;
import com.raja.library_manager.service.MemberService;

@Controller
public class BookController {

	@Autowired
	private BookService  bookserve;
	
	@Autowired
	private MemberService memberserve;
	
	@GetMapping("/books")
	public String listBooks(Model model) {
		
		List<Books> listBooks = bookserve.findAll();
		model.addAttribute("listBooks", listBooks);
		
		return "books";
		
	}
	
	
	  @GetMapping("/books/new") 
	  public String bookShowNewForm(Model model) {
	  List<Member> listMember = memberserve.findAll();
	  
	  model.addAttribute("book" , new Books());
	  model.addAttribute("listMember" , listMember);
	  
	  
	  return "book_form";
	 
	}
	@PostMapping("/books/save")
	public String saveBook(Model model , Books book){
		
	bookserve.saveBook(book);
    return "redirect:/bookIssueDetails";
		
	}
	 @GetMapping("/new/search")
	    public String searchCustomers( Model theModel , String title) {
		 
		  
	      List<Books> thebooks = bookserve.findBytitle(title);                
	        theModel.addAttribute("books", thebooks);
	        
		  return "books"; 
}
	 @GetMapping("/issuebooks")
	 public String listBookswithmember(Model model ,Member member) {
		List<Books> listBooks=  bookserve.findAllByOrderByTitle();
		 

		 model.addAttribute("member" , member);
		 model.addAttribute("listBooks" , listBooks);
		 return "booksissueReccord";
		 
	 }
	 @GetMapping("/Book/edit/{id}")
	 public String showEditBookForm(@PathVariable("id")Long id, Model model) {
		 Books  book= bookserve.findById(id);
		 model.addAttribute("book", book);
		 List<Member> listMember = memberserve.findAll();
		  
			model.addAttribute("listMember" , listMember);
		 
		 return "book_form";
	 }
	 @GetMapping("/Book/delete/{id}")
	 public String  DedeteBook(@PathVariable("id")Long id, Model model) {
    bookserve.deleteById(id);
   return "redirect:/books";
	 }
	 @GetMapping("/bookIssueDetails")
	 public String  getBookandMember(Model model){
			
		 List<BookIssueDetails> listBookissueDetails = bookserve.getBookandMember();
			model.addAttribute("listBookIssueDetails", listBookissueDetails);
			
			return "bookIssueDetails";
		}

   @GetMapping("/showFormForanAdd")
   public String showFormForAdd(Model theModel) {
	   
	   Books thebook = new Books();
	   
	   theModel.addAttribute("book", thebook);
	   
	   return "newbook_form";
	   
   }
   @GetMapping("/showFormForanUpdate")
   public String showFormForanUpdate(@RequestParam("bookId")long theId, Model theModel) {
	   Books thebook = bookserve.findById(theId);
	   theModel.addAttribute("book", thebook);
	   
	   return "newbook_form";
	   
   }
   @PostMapping("/bookssave")
	public String saveaBook(@ModelAttribute("book")  Books book){
		
	bookserve.saveBook(book);
   return "redirect:/issuebooks";
 
}
@GetMapping("/showDelete")
public String showDelete(@RequestParam("bookId")long theId) {
	
	bookserve.deleteById(theId);
	 return "redirect:/issuebooks";
}
@GetMapping("/showReturn")
public String showReturn(@RequestParam("bookId")long theId) {
	
	bookserve.returnBook(theId);
	 return "redirect:/issuebooks";
}
}










