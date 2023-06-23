package springmvc.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springmvc.model.User;

@Controller
public class contactForm {
	
	@RequestMapping("/contactForm")
	public String form(Model m) {
		m.addAttribute("h","Your Form");
		m.addAttribute("tarun","123");
		System.out.println("Hello Contact Form");
		return "contactForm";
	}
	
	
	@RequestMapping(path="processedForm", method=RequestMethod.POST)
	 public String handleForm(@ModelAttribute User user) {
		 return "success";
	 }
	
//	@RequestMapping(path="/processedForm", method=RequestMethod.POST)
//	public String handleForm(@RequestParam("email")String userEmail, 
//			@RequestParam("userName") String userName,
//			@RequestParam("userPass") String password,
//			Model model) {
//		
//		
//		User user = new User();
//		user.setEmail(userEmail);
//		user.setUserName(userName);
//		user.setUserPass(password);
//		System.out.println(user);
//		
////		System.out.println("Email :" +userEmail);
////		System.out.println("User Name :" +userName);
////		System.out.println("Password:" +password);
////		
//		//Process
////		boolean isU = false;
////		boolean isL = false;
////		boolean sp = false;
////		boolean num = false;
////		boolean
////		
////		for(char c : password) {
////			if(Character.isLetter(c)) {
////				is
////			}
////		}
//		
////		model.addAttribute("userName", userName);
////		model.addAttribute("email", userEmail);
////		model.addAttribute("userPass",password);
//		
//		model.addAttribute("user",user);
//		return "success";
//		
//	}
}
