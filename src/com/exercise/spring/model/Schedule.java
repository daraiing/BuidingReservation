package com.exercise.spring.model;

public class Schedule {
	
	int s_id;
	int s_rid;
	int s_bid;
	int mseat;
	String s_rname;
	String s_bname;
	String 	s_sdate;
	String s_date;
	String s_uname;
	String s_status;
	/**
	 * @return the s_id
	 */
	public synchronized int getS_id() {
		return s_id;
	}
	/**
	 * @param s_id the s_id to set
	 */
	public synchronized void setS_id(int s_id) {
		this.s_id = s_id;
	}
	/**
	 * @return the s_rname
	 */

	/**
	 * @return the s_sdate
	 */
	public synchronized String getS_sdate() {
		return s_sdate;
	}
	/**
	 * @param s_sdate the s_sdate to set
	 */
	public synchronized void setS_sdate(String s_sdate) {
		this.s_sdate = s_sdate;
	}
	/**
	 * @return the s_date
	 */
	public synchronized String getS_date() {
		return s_date;
	}
	/**
	 * @param s_date the s_date to set
	 */
	public synchronized void setS_date(String s_date) {
		this.s_date = s_date;
	}
	/**
	 * @return the s_uname
	 */
	public synchronized String getS_uname() {
		return s_uname;
	}
	/**
	 * @param s_uname the s_uname to set
	 */
	public synchronized void setS_uname(String s_uname) {
		this.s_uname = s_uname;
	}
	/**
	 * @return the s_status
	 */
	public synchronized String getS_status() {
		return s_status;
	}
	/**
	 * @param s_status the s_status to set
	 */
	public synchronized void setS_status(String s_status) {
		this.s_status = s_status;
	}
	/**
	 * @return the s_rid
	 */
	public synchronized int getS_rid() {
		return s_rid;
	}
	/**
	 * @param s_rid the s_rid to set
	 */
	public synchronized void setS_rid(int s_rid) {
		this.s_rid = s_rid;
	}
	/**
	 * @return the s_bid
	 */
	public synchronized int getS_bid() {
		return s_bid;
	}
	/**
	 * @param s_bid the s_bid to set
	 */
	public synchronized void setS_bid(int s_bid) {
		this.s_bid = s_bid;
	}
	/**
	 * @return the s_rname
	 */
	public synchronized String getS_rname() {
		return s_rname;
	}
	/**
	 * @param s_rname the s_rname to set
	 */
	public synchronized void setS_rname(String s_rname) {
		this.s_rname = s_rname;
	}
	/**
	 * @return the s_bname
	 */
	public synchronized String getS_bname() {
		return s_bname;
	}
	/**
	 * @param s_bname the s_bname to set
	 */
	public synchronized void setS_bname(String s_bname) {
		this.s_bname = s_bname;
	}
	/**
	 * @return the mseat
	 */
	public synchronized int getMseat() {
		return mseat;
	}
	/**
	 * @param mseat the mseat to set
	 */
	public synchronized void setMseat(int mseat) {
		this.mseat = mseat;
	}

	
	

}
