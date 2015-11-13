package com.exercise.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.exercise.spring.dao.BuildingDao;
import com.exercise.spring.dao.RoomDao;
import com.exercise.spring.dao.ScheduleDao;
import com.exercise.spring.model.Building;
import com.exercise.spring.model.Room;
import com.exercise.spring.model.Schedule;

@Controller
@RequestMapping("/schedule")
public class ScheduleController {
	@Autowired
	RoomDao roomDao;
	@Autowired
	BuildingDao buildingDao;
	@Autowired
	ScheduleDao scheduleDao;

	@RequestMapping("/")
	public String sch(Model model) {

		List<Room> r = roomDao.getAllRoom();
		List<Building> bs = buildingDao.getAllBuilding();
		for (Building b : bs) {
			List<Room> rs = roomDao.getAllRoomByBuilding(b.getB_id());
			model.addAttribute(String.valueOf(b.getB_id()), rs);
		}
		model.addAttribute("blist", bs);
		return "schedule";
	}

	@RequestMapping("/show")
	public String show(Model model, @RequestParam("id") int id) {
		List<Schedule> slist = scheduleDao.getAllScheduleById(id);
		model.addAttribute("slist", slist);
		model.addAttribute("rid", id);
		return "showSchedule";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView res(Model model,@RequestParam("id") int id,@RequestParam("sdate") String sdate) {
	
		String bname = buildingDao.getBnameByRid(id);
		String rname = roomDao.getRoomNameByID(id);
		model.addAttribute("b", bname);
		model.addAttribute("r", rname);
		model.addAttribute("rid", id);
		model.addAttribute("sdate", sdate);
		return new ModelAndView("reserve", "command", new Schedule());
	}

	@RequestMapping(value = "addpost", method = RequestMethod.POST)
	public String respost(ModelMap model, Schedule schedule) {
		int r_id = roomDao.getRoomIDbyName(schedule.getS_rname());
		int b_id = buildingDao.getRoomIDbyName(schedule.getS_bname());
		schedule.setS_rid(r_id);
		scheduleDao.insertSchedule(schedule);
		return "redirect:/schedule/";
	}

}
