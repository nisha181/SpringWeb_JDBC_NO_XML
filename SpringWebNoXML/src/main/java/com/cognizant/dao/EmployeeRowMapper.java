package com.cognizant.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cognizant.model.Employee;

public class EmployeeRowMapper implements RowMapper<Employee> {
 {

}


public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
	
	    Employee s = new Employee();
		s.setId(rs.getInt(1));
		s.setName(rs.getString(2));
		return s;
    }
}
