package com.javaspring.daikichi;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daikichi")
public class DaikichiController {
	
	//static using query parameters
	@RequestMapping(value="", method=RequestMethod.GET)
	public String wellcome() {
		return "Wellcome";
	}
	
	@RequestMapping("/today")
	public String today() {
		return "today is your lucky day";
	}
	
	@RequestMapping("/tomorrow")
	public String tomorrow() {
		return "tomorrow will be better";
	}
	
	//dynamic using path variables
	
	@RequestMapping("/{action}/{place}")
	public String toDo(@PathVariable("action") String action, @PathVariable("place") String place) {
		return "congratulations you will "+ action +" to "+ place;
	}
	
	@RequestMapping("/lotto/{num}")
	public String lotto(@PathVariable("num") int num) {
		return num%2 != 0? "You have" : "You will take a grand journey in";
//		if(num%2 != 0) {
//			return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
//		}
//		else {
//			return "You will take a grand journey in the near future, but be weary of tempting offers";
//		}
	}
	
	
}
