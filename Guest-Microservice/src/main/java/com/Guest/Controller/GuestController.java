package com.Guest.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GuestController {
	@GetMapping("/Guest")
	public String Hello() {
		return "Hello World!!";
	}

}
