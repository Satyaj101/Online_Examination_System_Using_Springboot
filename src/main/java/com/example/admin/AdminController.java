package com.example.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {
	
	@Autowired
	private AdminRepository adminRepository ;

	
	  @GetMapping("/admin/{name}")
	    public ResponseEntity<Admin> getAdminDetails(@PathVariable("name") String name) {
	        Admin admin = adminRepository.findByName(name);

	        if (admin != null) {
	            return new ResponseEntity<>(admin,HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	
	
	

}
