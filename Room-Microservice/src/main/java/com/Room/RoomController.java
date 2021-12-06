package com.Room;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomController {

	@GetMapping("/Room")
	public String Hello() {
		return "Hello World!!";
	}
}
