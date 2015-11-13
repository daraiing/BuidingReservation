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

import com.exercise.spring.model.Building;
import com.exercise.spring.model.Room;
import com.exercise.spring.model.Schedule;

public class RoomDao {

	@Autowired
	DataSource dataSource;

	public List<Room> getAllRoomByBuilding(int bid) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "select * from room where r_bid=" + bid;

		return jdbcTemplate.query(sql, new RowMapper<Room>() {

			@Override
			public Room mapRow(ResultSet rs, int rownumber) throws SQLException {
				Room r = new Room();
				r.setR_id(rs.getInt(1));
				r.setR_no(rs.getString(2));
				r.setR_name(rs.getString(3));
				r.setR_seat(rs.getInt(4));
				r.setR_bid(rs.getInt(5));
				return r;
			}
		});
	}

	public List<Room> getAllRoom() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "select * from room";

		return jdbcTemplate.query(sql, new RowMapper<Room>() {

			@Override
			public Room mapRow(ResultSet rs, int rownumber) throws SQLException {
				Room r = new Room();
				r.setR_id(rs.getInt(1));
				r.setR_no(rs.getString(2));
				r.setR_name(rs.getString(3));
				r.setR_seat(rs.getInt(4));
				r.setR_bid(rs.getInt(5));
				return r;
			}
		});
	}

	public List<Room> getAllRoomGroupBy() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "select room.*,b_name from room,building where room.r_bid = building.b_id";

		return jdbcTemplate.query(sql, new RowMapper<Room>() {

			@Override
			public Room mapRow(ResultSet rs, int rownumber) throws SQLException {
				Room r = new Room();
				r.setR_id(rs.getInt(1));
				r.setR_no(rs.getString(2));
				r.setR_name(rs.getString(3));
				r.setR_seat(rs.getInt(4));
				r.setR_bid(rs.getInt(5));
				r.setR_bname(rs.getString(6));
				return r;
			}
		});
	}

	public String getRoomNameByID(int id) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "select r_name from room where r_id=" + id;

		List<Room> st = jdbcTemplate.query(sql, new RowMapper<Room>() {
			@Override
			public Room mapRow(ResultSet rs, int arg1) throws SQLException {
				Room r = new Room();
				r.setR_name(rs.getString(1));
				return r;
			}
		});
		if (st.size() != 0) {
			return st.get(0).getR_name();
		} else {
			return null;
		}

	}

	public int getRoomIDbyName(String name) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "select r_id from room where r_name like '" + name + "'";

		List<Room> st = jdbcTemplate.query(sql, new RowMapper<Room>() {
			@Override
			public Room mapRow(ResultSet rs, int arg1) throws SQLException {
				Room r = new Room();
				r.setR_id(rs.getInt(1));
				return r;
			}
		});
		if (st.size() != 0) {
			return st.get(0).getR_id();
		} else {
			return -1;
		}

	}

	public Room getRoomById(int id) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "select room.*,b_name from room,building where r_id=" + id + " and room.r_bid = building.b_id";

		List<Room> rs = jdbcTemplate.query(sql, new RowMapper<Room>() {
			@Override
			public Room mapRow(ResultSet rs, int rownumber) throws SQLException {
				Room r = new Room();
				r.setR_id(rs.getInt(1));
				r.setR_no(rs.getString(2));
				r.setR_name(rs.getString(3));
				r.setR_seat(rs.getInt(4));
				r.setR_bname(rs.getString(6));
				return r;
			}
		});
		if (rs.size() != 0) {
			return rs.get(0);
		} else {
			return null;
		}
	}

	public Boolean updateRoom(Room r) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String query = "update room set r_no=?, r_name=?, r_seat=?,r_bid=? where r_id=?";
		return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, r.getR_no());
				ps.setString(2, r.getR_name());
				ps.setInt(3, r.getR_seat());
				ps.setInt(4, r.getR_bid());
				ps.setInt(5, r.getR_id());
				if (ps.executeUpdate() >= 1) {
					return true;
				}
				;
				return false;
			}
		});
	}
	
	public void deleteRoom(int id)
	{
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "delete from room where s_id=" + id;
		jdbcTemplate.update(sql);
	}
	
	public Boolean insertRoom(Room room) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String query = "insert into room(r_no,r_name,r_seat,r_bid) values(?,?,?,?)";
		return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, room.getR_no());
				ps.setString(2, room.getR_name());
				ps.setInt(3, room.getR_seat());
				ps.setInt(4, room.getR_bid());
				if (ps.executeUpdate() >= 1) {
					return true;
				}
				;
				return false;
			}
		});
	}
}
