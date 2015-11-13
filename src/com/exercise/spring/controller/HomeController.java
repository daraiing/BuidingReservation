package com.exercise.spring.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.exercise.spring.model.Schedule;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String index()
	{
		return "index";
	}

}