package springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping("/home")
	public String home(Model model) {
		System.out.println("Home url");
		model.addAttribute("Name", "Tarun Kumar");
		model.addAttribute("id",456);
		List<String> friends = new ArrayList<String>();
		friends.add("A");
		friends.add("B");
		friends.add("C");
		friends.add("D");
		friends.add("E");
		model.addAttribute("list",friends);
		
		return "index";
	}
	
	
	@RequestMapping("/about")
	public String about() {
		System.out.println("About Page");
		return "about";
	}
	
	@RequestMapping("/help")
	public ModelAndView help() {
		
		System.out.println("Help Page New");
		ModelAndView mV = new ModelAndView();
		mV.addObject("name", "Sourav");
		mV.addObject("rN", 123);
		
		mV.setViewName("help");
		
		return mV;
	}
	
}
