package com.exercise.spring.model;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Reserve {
	int id;
	String name;
	String companyname;
	String startdate;
	String enddate;
	String time;
	String building;
	String room;
	String purpose;
	/**
	 * @return the id
	 */
	public synchronized int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public synchronized void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public synchronized String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public synchronized void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the companyname
	 */
	public synchronized String getCompanyname() {
		return companyname;
	}
	/**
	 * @param companyname the companyname to set
	 */
	public synchronized void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	/**
	 * @return the startdate
	 */
	public synchronized String getStartdate() {
		return startdate;
	}
	/**
	 * @param startdate the startdate to set
	 */
	public synchronized void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	/**
	 * @return the enddate
	 */
	public synchronized String getEnddate() {
		return enddate;
	}
	/**
	 * @param enddate the enddate to set
	 */
	public synchronized void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	/**
	 * @return the time
	 */
	public synchronized String getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public synchronized void setTime(String time) {
		this.time = time;
	}
	/**
	 * @return the building
	 */
	public synchronized String getBuilding() {
		return building;
	}
	/**
	 * @param building the building to set
	 */
	public synchronized void setBuilding(String building) {
		this.building = building;
	}
	/**
	 * @return the room
	 */
	public synchronized String getRoom() {
		return room;
	}
	/**
	 * @param room the room to set
	 */
	public synchronized void setRoom(String room) {
		this.room = room;
	}
	/**
	 * @return the purpose
	 */
	public synchronized String getPurpose() {
		return purpose;
	}
	/**
	 * @param purpose the purpose to set
	 */
	public synchronized void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String convertDateToString(Date dt) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String dateToString = df.format(dt);
        return dateToString;
    }
	

}
