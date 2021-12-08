package com.Department.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Department.Model.Department;
import com.Department.Model.DepartmentList;
import com.Department.Service.Departmentservice;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	Departmentservice service;

	@GetMapping("/hello")
	public String hello() {
		return "Hello Department!!";
	}

	@PostMapping("/add")
	public Department addDept(@RequestBody Department dept) {
		return this.service.addDepartment(dept);
	}

	@GetMapping("/findAll")
	public DepartmentList getDepartment() {

		DepartmentList list = new DepartmentList();
		list.setAlldept(this.service.getAlldept());
		return list;
	}

	@GetMapping("/findById/{id}")
	public Optional<Department> getDepartment(@PathVariable("id") String id) {

		return this.service.getDepartment(Long.parseLong(id));
	}

	@PutMapping("/update")
	public Department updateDepartment(@RequestBody Department dept) {
		return this.service.updateDepartment(dept);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteDepartment(@PathVariable("id") String id) {
		return this.service.deleteDepartment(Long.parseLong(id));
	}
}
