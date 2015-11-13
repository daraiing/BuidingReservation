package com.exercise.spring.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;

import com.exercise.spring.model.Reserve;
import com.exercise.spring.model.Room;
import com.exercise.spring.model.Schedule;

public class ScheduleDao {
	@Autowired
	DataSource dataSource;

	public List<Schedule> getAllSchedule() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "select * from schedule";

		return jdbcTemplate.query(sql, new RowMapper<Schedule>() {

			@Override
			public Schedule mapRow(ResultSet rs, int rownumber) throws SQLException {
				Schedule s = new Schedule();
				s.setS_id(rs.getInt(1));
				s.setS_rid(rs.getInt(2));
				s.setS_bid(rs.getInt(3));
				s.setS_sdate(rs.getString(4));
				s.setS_date(rs.getString(5));
				s.setS_uname(rs.getString(6));
				s.setS_status(rs.getString(7));

				return s;
			}
		});
	}

	public List<Schedule> getAllScheduleById(int rid) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "select * from schedule s,room r where s_rid=" + rid;

		return jdbcTemplate.query(sql, new RowMapper<Schedule>() {

			@Override
			public Schedule mapRow(ResultSet rs, int rownumber) throws SQLException {
				Schedule s = new Schedule();
				s.setS_id(rs.getInt(1));
				s.setS_rid(rs.getInt(2));
				s.setS_bid(rs.getInt(3));
				s.setS_sdate(rs.getString(4));
				s.setS_date(rs.getString(5));
				s.setS_uname(rs.getString(6));
				s.setS_status(rs.getString(7));

				return s;
			}
		});
	}

	public Boolean insertSchedule(Schedule schedule) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String query = "insert into schedule(s_rid,s_bid,s_sdate,s_edate,s_uname,s_status) values (?,?,?,?,?,?)";
		return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1, schedule.getS_rid());
				ps.setInt(2, schedule.getS_bid());
				ps.setString(3, schedule.getS_sdate());
				ps.setString(4, schedule.getS_date());
				ps.setString(5, schedule.getS_uname());
				ps.setString(6, "Unavailable");
				if (ps.executeUpdate() >= 1) {
					return true;
				}
				;
				return false;
			}
		});
	}
	
	public Boolean updateRoom(Schedule schedule) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String query = "update schedule set s_rid=?,s_bid=?,s_sdate=?,s_edate=?,s_uname=?,s_status=? where s_id=? ";
		return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1, schedule.getS_rid());
				ps.setInt(2, schedule.getS_bid());
				ps.setString(3, schedule.getS_sdate());
				ps.setString(4, schedule.getS_date());
				ps.setString(5, schedule.getS_uname());
				ps.setString(6, schedule.getS_status());
				ps.setInt(7, schedule.getS_id());
				if (ps.executeUpdate() >= 1) {
					return true;
				}
				;
				return false;
			}
		});
	}
	
	public Schedule getScheduleById(int id)
	{
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "select * from schedule where s_id=" + id;
		List<Schedule> s =  jdbcTemplate.query(sql, new RowMapper<Schedule>() {

			@Override
			public Schedule mapRow(ResultSet rs, int rownumber) throws SQLException {
				Schedule s = new Schedule();
				s.setS_id(rs.getInt(1));
				s.setS_rid(rs.getInt(2));
				s.setS_bid(rs.getInt(3));
				s.setS_sdate(rs.getString(4));
				s.setS_date(rs.getString(5));
				s.setS_uname(rs.getString(6));
				s.setS_status(rs.getString(7));

				return s;
			}
		});
		if(s.size()!=0)
		{
			return s.get(0);
		}
		else
		{
			return null;
		}
	}
	
	public void deleteSchedule(int id)
	{
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "delete from schedule where s_id=" + id;
		jdbcTemplate.update(sql);
	}


}
