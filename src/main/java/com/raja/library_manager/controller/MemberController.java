package com.raja.library_manager.controller;

import java.util.List;
import java.util.Optional;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.raja.library_manager.entity.Member;
import com.raja.library_manager.service.BookService;
import com.raja.library_manager.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberserve;
 
	@Autowired
	private BookService bookserve;
	
	
	
	@GetMapping("/members")
	public String listAddress(Model model) {
		List<Member> listmembers = memberserve.findAll();
        model.addAttribute("members", listmembers);
		return "members";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		 
		Member theMember = new Member();
 	
		theModel.addAttribute("member",  theMember);
		 
 
		return "person-form";

	}
	@PostMapping("/save")
	public String saveMember(@ModelAttribute("member")Member theMemebr) {
		
		
		memberserve.saveMember(theMemebr);
		
		return "redirect:/members";
		
	}
	
	  

 
	 @GetMapping("/search")
	    public String searchCustomers(@RequestParam("theSearchName") String theSearchName,
                Model theModel) {
		 
		  
	      List<Member> theCustomers = memberserve.findByFirstNameOrLastName(theSearchName);                
	        theModel.addAttribute("members", theCustomers);
	        
 		  return "members"; 
	 }
	 @GetMapping("/delete")
		public String delete(@RequestParam("memberId") long theId, Model theModel) {

			memberserve.deleteById(theId);

			return "redirect:/members";

		}
	 @GetMapping("/return")
		public String bookreturn(@RequestParam("id") long theId, Model theModel) {

			memberserve.removeBookById(theId);

			return "redirect:/members";

		}
	 @GetMapping("/showFormForUpdate")
	   public String showFormForUpdatw(@RequestParam("memberId")long theId, Model theModel) {
		   
		  Member theMember= memberserve.findById(theId).get();
		   //set member as a model attribute to pre-populate the form.
		   
		   theModel.addAttribute("member", theMember);
		   
		   
		   
		   return "person-form";
	   }
	 @GetMapping("/showReturnBook")
		public String returntheBook(@RequestParam("memberId") long theId, Model theModel) {

			memberserve.returnBook(theId);

			return "redirect:/members";
}

}





























 