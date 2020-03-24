package com.cognizant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.dao.EmployeeDao;
import com.cognizant.model.Employee;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	
	@Autowired
	private EmployeeDao employeedao;

	public String insert(Employee e) {
	     return employeedao.insert(e);	
	}

	public String update(Employee e) {
		return employeedao.update(e);
	}

	public String delete(Employee e) {
		return employeedao.delete(e);
	}

	public List<Employee> getAll() {
		return employeedao.getAll();
	}

	public EmployeeDao getEmployeedao() {
		return employeedao;
	}

	public void setEmployeedao(EmployeeDao employeedao) {
		this.employeedao = employeedao;
	}

}
