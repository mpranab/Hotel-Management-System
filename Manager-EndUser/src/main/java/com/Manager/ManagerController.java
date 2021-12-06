package com.Manager;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManagerController {

	@GetMapping("/Manager")
	public String Hello() {
		return "Hello World!!";
	}
}
