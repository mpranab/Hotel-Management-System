package com.Staff;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StaffController {

	@GetMapping("/Staff")
	public String Hello() {
		return "Hello World!!";
	}
}
