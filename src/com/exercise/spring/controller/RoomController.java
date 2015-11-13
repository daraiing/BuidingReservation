package com.exercise.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.exercise.spring.dao.RoomDao;
import com.exercise.spring.model.Room;

@Controller
@RequestMapping("/room")
public class RoomController {

	@Autowired
	RoomDao roomDao;

	@RequestMapping("/list")
	public String room(@RequestParam("id") int id, Model model) {
		List<Room> list = roomDao.getAllRoomByBuilding(id);

		model.addAttribute("list", list);
		return "room";
	}

}
