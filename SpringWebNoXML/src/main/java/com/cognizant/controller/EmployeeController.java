package com.cognizant.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cognizant.model.Employee;
import com.cognizant.service.EmployeeService;
import com.cognizant.service.EmployeeServiceImpl;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeService es = new EmployeeServiceImpl();

	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String insertpage() {
		return "insert";
	}

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insert(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		Employee e = new Employee(id, name);
		System.out.println(e);
		String str = es.insert(e);
		request.setAttribute("msg", str);
		return "insert";

	}

	@RequestMapping(value = "getAll", method = RequestMethod.GET)
	public String getAllpage(HttpServletRequest request) {
		List<Employee> employee = es.getAll();
		request.setAttribute("employees", employee);
		System.out.println(employee);
		return "getAll";
	}
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String updatepage() {
		return "update";
	}
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		Employee e = new Employee(id, name);
		System.out.println(e);
		String str = es.update(e);
		request.setAttribute("msg", str);
		return "update";

	}
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deletepage() {
		return "delete";
	}
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		Employee e = new Employee(id, name);
		System.out.println(e);
		String str = es.delete(e);
		request.setAttribute("msg", str);
		return "delete";

	}
}
