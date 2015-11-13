package com.exercise.spring.model;

public class Building {
	
	int b_id;
	String b_name;
	String b_location;
	/**
	 * @return the b_id
	 */
	public synchronized int getB_id() {
		return b_id;
	}
	/**
	 * @param b_id the b_id to set
	 */
	public synchronized void setB_id(int b_id) {
		this.b_id = b_id;
	}
	/**
	 * @return the b_name
	 */
	public synchronized String getB_name() {
		return b_name;
	}
	/**
	 * @param b_name the b_name to set
	 */
	public synchronized void setB_name(String b_name) {
		this.b_name = b_name;
	}
	/**
	 * @return the b_location
	 */
	public synchronized String getB_location() {
		return b_location;
	}
	/**
	 * @param b_location the b_location to set
	 */
	public synchronized void setB_location(String b_location) {
		this.b_location = b_location;
	}
	
	

}
