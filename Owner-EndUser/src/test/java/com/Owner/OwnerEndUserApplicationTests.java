package com.Owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.Owner.Models.OwnerInformation;
import com.Owner.Repository.OwnerRepository;
import com.Owner.Service.OwnerService;

@RunWith(SpringRunner.class)
@SpringBootTest
class OwnerEndUserApplicationTests {
	
	@Autowired
	OwnerService service;
	
	@MockBean
	private OwnerRepository repo;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void addOwnerInfosTest() {
		OwnerInformation owner = new OwnerInformation("1","abc@gmail.com","098685");
		when(repo.insert(owner)).thenReturn(owner);
		
	}

}
