package com.Owner;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OwnerController {

	@GetMapping("/Owner")
	public String Hello() {
		return "Hello World!!";
	}
}
