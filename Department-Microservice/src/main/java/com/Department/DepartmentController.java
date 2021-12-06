package com.Department;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {
	@GetMapping("/Department")
	public String Hello() {
		return "Hello World!!";
	}
}
