package com.exercise.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/search")
public class SearchController {
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String search()
	{
		return "";
	}

}
