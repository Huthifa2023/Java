package com.javaspring.helloworld;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/index")
public class HelloController {
	@RequestMapping("")
	public String index() {
		return "Hello World"
				+ "no no no non onon \n\n"
				+"\n" +
				"sadfjalskdjflksjflk";
	}
	@RequestMapping("/mam")
	public String Mam() {
		return "mam mam mam mam mam";
	}
	
	@RequestMapping("/nam")
	public String nam() {
		return "nam nam asdfsfs fasdfdsd f";
	}
	
	@RequestMapping("/search")
    public String index(@RequestParam(value="q", required=false) String searchQuery) {
		if(searchQuery == null) {
			return "you searched for nothing";
		}
        return "You searched for: " + searchQuery;
    }
	
	@RequestMapping("/m/{courseId}/{moduleId}")
    public String showLesson(@PathVariable("courseId") String courseId, @PathVariable("moduleId") String moduleId){
    	return "Course: " + courseId + ", Module: " + moduleId;
    }
	
}


