package com.exercise.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	RoomDao roomDao;
	@Autowired
	BuildingDao buildingDao;
	@Autowired
	ScheduleDao scheduleDao;
	
	@RequestMapping("/")
	public String admin()
	{
		return "admin";
	}
	
	@RequestMapping("roommgmt")
	public String room(Model model)
	{
		List<Room> rlist = roomDao.getAllRoomGroupBy();
		model.addAttribute("rlist", rlist);
		return "adminroom";
	}
	
	@RequestMapping("buildingmgmt")
	public String building(Model model)
	{
		List<Building> blist = buildingDao.getAllBuilding();
		model.addAttribute("blist", blist);
		return "adminbuilding";
	}
	
	@RequestMapping(value="updateb",method=RequestMethod.GET)
	public ModelAndView updateb(@RequestParam("id") int id)
	{
		Building b = buildingDao.getBuildingById(id);
		return new ModelAndView("adminupdateb", "command", b);
	}
	
	@RequestMapping(value="updatebp",method=RequestMethod.POST)
	public String postupdateb(Building b)
	{
		buildingDao.updateBuilding(b);
		
			return "redirect:/admin/buildingmgmt";
		
	}
	
	@RequestMapping(value="updater",method=RequestMethod.GET)
	public ModelAndView updater(@RequestParam("id") int id)
	{
		Room r = roomDao.getRoomById(id);
		return new ModelAndView("adminupdater", "command",r );
	}
	
	@RequestMapping(value="updaterp",method=RequestMethod.POST)
	public String postupdater(Room r)
	{
		int b_id = buildingDao.getRoomIDbyName(r.getR_bname());
		r.setR_bid(b_id);
		roomDao.updateRoom(r);
			return "redirect:/admin/roommgmt";
		
	}
	
	@RequestMapping(value="schedulemgmt", method=RequestMethod.GET)
	public String sch(Model model) {

	List<Schedule> slist = scheduleDao.getAllSchedule();
	model.addAttribute("slist", slist);
		return "adminschedule";
	}
	
	@RequestMapping(value="updates",method=RequestMethod.GET)
	public ModelAndView updates(@RequestParam("id") int id)
	{
		String bname = buildingDao.getBnameByRid(id);
		String rname = roomDao.getRoomNameByID(id);
//		model.addAttribute("b", bname);
//		model.addAttribute("r", rname);
		Schedule s = scheduleDao.getScheduleById(id);
		s.setS_bname(bname);
		s.setS_rname(rname);
		return new ModelAndView("adminupdates", "command",s);
	}
	
	@RequestMapping(value="updatesp",method=RequestMethod.POST)
	public String updatesp(Schedule schedule)
	{
		int r_id = roomDao.getRoomIDbyName(schedule.getS_rname());
		int b_id = buildingDao.getRoomIDbyName(schedule.getS_bname());
		
		schedule.setS_bid(b_id);
		schedule.setS_rid(r_id);
		
		scheduleDao.updateRoom(schedule);
		
		return "redirect:/admin/schedulemgmt";
	}
	
	@RequestMapping("/deletes")
	public String deletes(@RequestParam("id") int id)
	{
		scheduleDao.deleteSchedule(id);
		return "redirect:/admin/schedulemgmt";
	}
	
	@RequestMapping("/deleter")
	public String deleter(@RequestParam("id") int id)
	{
		roomDao.deleteRoom(id);
		return "redirect:/admin/roommgmt";
	}
	
	@RequestMapping("/deleteb")
	public String deleteb(@RequestParam("id") int id)
	{
		buildingDao.deleteBuilding(id);
		return "redirect:/admin/buildingmgmt";
	}
	
	@RequestMapping(value="/insertb",method=RequestMethod.GET)
	public ModelAndView newb()
	{
		return new ModelAndView("adminInsertb","command",new Building());
	}
	
	@RequestMapping(value="/insertbp",method=RequestMethod.POST)
	public String newbp(Building building)
	{
		Boolean Isadd = buildingDao.insertBuilding(building);
		if(Isadd)
		{
			return "redirect:/admin/buildingmgmt";
		}
		
		else
		{
			return null;
		}
	}
	
	@RequestMapping(value="/insertr",method=RequestMethod.GET)
	public ModelAndView newr()
	{
		return new ModelAndView("adminInsertr","command",new Room());
	}
	
	@RequestMapping(value="/insertrp",method=RequestMethod.POST)
	public String newrp(Room room)
	{
		Boolean Isadd = roomDao.insertRoom(room);
		if(Isadd)
		{
			return "redirect:/admin/roommgmt";
		}
		
		else
		{
			return null;
		}
	}
}
