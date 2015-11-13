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
import com.exercise.spring.model.Reserve;




public class ReserveDao {
	
	@Autowired
	DataSource dataSource;
	
	public Boolean insertStudent(Reserve reserve){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String query = "insert into reserve values (?,?,?,?,?,?,?,?,?)";
		return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1, reserve.getId());
				ps.setString(2, reserve.getName());
				ps.setString(3, reserve.getCompanyname());
				ps.setString(4, reserve.getStartdate());
				ps.setString(5, reserve.getEnddate());
				ps.setString(6, reserve.getTime());
				ps.setString(7, reserve.getBuilding());
				ps.setString(8, reserve.getRoom());
				ps.setString(9, reserve.getPurpose());
				if (ps.executeUpdate() >= 1) {
					return true;
				}
				;
				return false;	
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

}
