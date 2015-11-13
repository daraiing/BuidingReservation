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

public class BuildingDao {

	@Autowired
	DataSource dataSource;

	public List<Building> getAllBuilding() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "select * from building";

		return jdbcTemplate.query(sql, new RowMapper<Building>() {

			@Override
			public Building mapRow(ResultSet rs, int rownumber) throws SQLException {
				Building b = new Building();
				b.setB_id(rs.getInt(1));
				b.setB_name(rs.getString(2));
				b.setB_location(rs.getString(3));
				return b;
			}
		});
	}

	public Building getBuildingById(int id) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "select * from building where b_id=" + id;

		List<Building> rs = jdbcTemplate.query(sql, new RowMapper<Building>() {
			@Override
			public Building mapRow(ResultSet rs, int rownumber) throws SQLException {
				Building b = new Building();
				b.setB_id(rs.getInt(1));
				b.setB_name(rs.getString(2));
				b.setB_location(rs.getString(3));
				return b;
			}
		});
		if (rs.size() != 0) {
			return rs.get(0);
		} else {
			return null;
		}
	}

	public int getRoomIDbyName(String name) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "select b_id from building where b_name like '" + name + "'";

		List<Building> st = jdbcTemplate.query(sql, new RowMapper<Building>() {
			@Override
			public Building mapRow(ResultSet rs, int arg1) throws SQLException {
				Building b = new Building();
				b.setB_id(rs.getInt(1));
				return b;
			}
		});
		if (st.size() != 0) {
			return st.get(0).getB_id();
		} else {
			return -1;
		}

	}

	public Boolean updateBuilding(Building b) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "update building set b_name = ?, b_location = ? where b_id=?";
		return jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, b.getB_name());
				ps.setString(2, b.getB_location());
				ps.setInt(3, b.getB_id());
				return ps.execute();
			}
		});

	}
	
	public String getBnameByRid(int id)
	{
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String query = "select b.b_name from room r,building b where r_id = "+id+" And r.r_bid = b.b_id";
		List<Building> st = jdbcTemplate.query(query, new RowMapper<Building>() {
			@Override
			public Building mapRow(ResultSet rs, int arg1) throws SQLException {
				Building b = new Building();
				b.setB_name(rs.getString(1));;
				return b;
			}
		});
		if(st.size()!=0)
		{
		return st.get(0).getB_name();}
		else
		{
			return null;
		}
	}
	
	public void deleteBuilding(int id)
	{
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "delete from building where s_id=" + id;
		jdbcTemplate.update(sql);
	}
	
	public Boolean insertBuilding(Building building) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String query = "insert into building(b_name,b_location) values (?,?)";
		return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, building.getB_name());
				ps.setString(2, building.getB_location());
				if (ps.executeUpdate() >= 1) {
					return true;
				}
				;
				return false;
			}
		});
	}

}
