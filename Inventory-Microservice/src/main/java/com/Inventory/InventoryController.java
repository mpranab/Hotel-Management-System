package com.Inventory;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InventoryController {

	@GetMapping("/Inventory")
	public String Hello() {
		return "Hello World!!";
	}
}
