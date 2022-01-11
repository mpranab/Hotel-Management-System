package com.Manager.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Manager.Models.ManagerInformation;
import com.Manager.Repository.ManagerRepository;
import com.Manager.SecurityConfiguration.ManagerAuthResponse;
import com.Manager.Service.ManagerService;
import com.Manager.Models.JwtRequest;
import com.Manager.Models.JwtResponse;
import com.Manager.Models.ManagerInformation;
import com.Manager.Repository.ManagerRepository;
import com.Manager.Service.ManagerService;
import com.Manager.helper.JwtUtil;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("Manager")
public class ManagerController {

	@Autowired
	private ManagerService userservice;
	@Autowired
	private ManagerRepository ownerRepo;
	@Autowired
	private AuthenticationManager authenticates;;
	@Autowired
	JwtUtil jwtutil;

	@PostMapping("/subs")
	private ResponseEntity<JwtResponse>subscribeClient(@RequestBody JwtRequest authreq){
		ManagerInformation usermodel =new ManagerInformation();
		System.out.println(authreq);

		
		usermodel.setUsername(authreq.getUsername());
		usermodel.setPassword(authreq.getPassword());
		usermodel.setMobileNumber(authreq.getMobileNumber());
		usermodel.setEmail(authreq.getEmail());
		
		
		try {
			ownerRepo.save(usermodel);
		}
		catch(Exception e){
			return new ResponseEntity<JwtResponse>(new JwtResponse
					("Error during subscription ") , HttpStatus.OK);
		}
		
		return new ResponseEntity<JwtResponse>(new JwtResponse
				("Successfully authenticated " +authreq.getUsername()), HttpStatus.OK);

	}
	
	
	@PostMapping("/auth")
	private ResponseEntity<?> authenticateClient(@RequestBody JwtRequest authreq){
		String email=authreq.getEmail();
		String password= authreq.getPassword();
		System.out.println(authreq);
		
			authenticates.authenticate(new UsernamePasswordAuthenticationToken(email, password));
				
		
		
		UserDetails userdetails= userservice.loadUserByUsername(email);
		
		String jwt = jwtutil.generateToken(userdetails);
		
		return ResponseEntity.ok(new JwtResponse(jwt));
	}
	
	@GetMapping("/test")
	private String testingtoken() {
		try {
			return "Testing Successful...!";	
		}
		catch(Exception e) {
			return "Please login first..!";
		}
	}
	
	@GetMapping("/dashboard")
	private String dashboard() {
		return "Welcome to dashboard...!";
	}
	
}
