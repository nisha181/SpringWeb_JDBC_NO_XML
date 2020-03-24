package com.cognizant.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cognizant.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	public EmployeeDaoImpl() {
		super();
	}

	public EmployeeDaoImpl(JdbcTemplate jt) {
		super();
		this.jt = jt;
	}

	@Autowired
	private JdbcTemplate jt;

	public String insert(Employee e) {
		String sql = "insert into Student1 values(?,?)";
		String flag = "Fail";
		int result = jt.update(sql, e.getId(), e.getName());
		if (result == 1)
			flag = "Success";
		return flag;

	}

	public String update(Employee e) {
		String flag = "Fail";
		String sql = "update Student1 set name=? where id=?";
		int result = jt.update(sql, e.getName(), e.getId());
		if (result == 1)
			flag = "Success";
		return flag;
	}

	public String delete(Employee e) {
		String flag = "Fail";
		String sql = "delete from Student1 where id=?";
		int result = jt.update(sql, e.getId());
		if (result != 0)
			flag = "Success";
		return flag;

	}

	public List<Employee> getAll() {
		String sql = "select * from Student1";
		EmployeeRowMapper rowMapper = new EmployeeRowMapper();
		List<Employee> rs = jt.query(sql, rowMapper);
		return rs;
	}

	public JdbcTemplate getJt() {
		return jt;
	}

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	@Override
	public String toString() {
		return "EmployeeDaoImpl [jt=" + jt + "]";
	}

}
