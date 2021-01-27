package com.raja.library_manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	 
		
		@GetMapping("/home")
		public String showHomePage() {
			
			
			return "home";
			
			
		}
		

	}



