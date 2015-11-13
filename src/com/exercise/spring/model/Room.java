package com.exercise.spring.model;

public class Room {
	
int r_id;
String r_name;
String r_no;
int r_seat;
String r_status;
int r_bid;
String r_bname;
/**
 * @return the r_id
 */
public synchronized int getR_id() {
	return r_id;
}
/**
 * @param r_id the r_id to set
 */
public synchronized void setR_id(int r_id) {
	this.r_id = r_id;
}
/**
 * @return the r_name
 */
public synchronized String getR_name() {
	return r_name;
}
/**
 * @param r_name the r_name to set
 */
public synchronized void setR_name(String r_name) {
	this.r_name = r_name;
}
/**
 * @return the r_no
 */
public synchronized String getR_no() {
	return r_no;
}
/**
 * @param r_no the r_no to set
 */
public synchronized void setR_no(String r_no) {
	this.r_no = r_no;
}
/**
 * @return the r_bid
 */
public synchronized int getR_bid() {
	return r_bid;
}
/**
 * @param r_bid the r_bid to set
 */
public synchronized void setR_bid(int r_bid) {
	this.r_bid = r_bid;
}
/**
 * @return the r_seat
 */
public synchronized int getR_seat() {
	return r_seat;
}
/**
 * @param r_seat the r_seat to set
 */
public synchronized void setR_seat(int r_seat) {
	this.r_seat = r_seat;
}
/**
 * @return the r_status
 */
public synchronized String getR_status() {
	return r_status;
}
/**
 * @param r_status the r_status to set
 */
public synchronized void setR_status(String r_status) {
	this.r_status = r_status;
}
/**
 * @return the r_bname
 */
public synchronized String getR_bname() {
	return r_bname;
}
/**
 * @param r_bname the r_bname to set
 */
public synchronized void setR_bname(String r_bname) {
	this.r_bname = r_bname;
}


}
