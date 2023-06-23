package productCrudApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class mainController {
	
	@RequestMapping("/")
	public String home() {
		System.out.println("Hello");
		return "index";
	}
	
	@RequestMapping("/add-product")
	public String addProduct() {
		return "add_product_form";
	}
}
