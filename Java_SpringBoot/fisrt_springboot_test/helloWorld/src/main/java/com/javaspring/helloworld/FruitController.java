package com.javaspring.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class FruitController {
	@RequestMapping("/")
	public String demo(Model model) {
		model.addAttribute("fruit", "banana");
		return "demo.jsp";
	}
}
