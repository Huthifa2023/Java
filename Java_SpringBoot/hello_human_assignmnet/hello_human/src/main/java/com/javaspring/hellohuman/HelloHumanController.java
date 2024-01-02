package com.javaspring.hellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloHumanController {
	
	@RequestMapping("")
	public String hello(@RequestParam(value="name" , required = false) String qParam, @RequestParam(value="times") int times) {
		String out = "";
		for(int i=0; i < times; i++) {
			out += " "+qParam;
		}
		if(qParam == null) {
			return "hello human!";
		}
		else {
			return out;
		}
	}
}
