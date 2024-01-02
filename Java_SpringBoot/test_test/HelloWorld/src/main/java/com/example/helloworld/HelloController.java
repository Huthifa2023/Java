package com.example.helloworld;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class HelloController {
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("dojoName", "my is huthifa");
		return "demo.jsp";
	}
	
	@RequestMapping("/dojos")
    public String index1(Model model) {
        ArrayList<String> dojos = new ArrayList<String>();
        dojos.add("Burbank");
        dojos.add("Chicago");
        dojos.add("Bellevue");
        model.addAttribute("dojosFromMyController", dojos);
        return "demo.jsp";
    }
	@RequestMapping("/count")
	public String count(HttpSession session) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		else {
			int current = (int) session.getAttribute("count");
			current += 1;
			session.setAttribute("count", current);
		}
		return "demo.jsp";
	}
}
