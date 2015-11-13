package com.exercise.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exercise.spring.dao.BuildingDao;
import com.exercise.spring.model.Building;

@Controller
@RequestMapping("/info")
public class InfoController {
	@Autowired
	BuildingDao buildingDao;
	
	@RequestMapping("/")
	public String info(Model model){
		List<Building> list = buildingDao.getAllBuilding();
		model.addAttribute("blist", list);
		return "info";
	}

}
