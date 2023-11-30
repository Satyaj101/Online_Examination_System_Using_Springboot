package com.example.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

	   @Autowired
	   private UserRepository userRepository;
	   
   
	   @GetMapping("/user")
	   public ResponseEntity<List<User>> getAllUser() {
	       List<User> users = (List<User>) userRepository.findAll();
	       return new ResponseEntity<>(users, HttpStatus.OK);
	   }
	   
	  
	   @GetMapping("/user/{email}")
	   public ResponseEntity<User> getUserDetails(@PathVariable("email") String email) {
	       User user = userRepository.findByEmail(email);

	       if (user != null) {
	           return new ResponseEntity<>(user, HttpStatus.OK);
	       } else {
	           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	       }
	   }
	   
	   
	   @PostMapping("/user")
	   public ResponseEntity<User> addNewUser(@RequestBody User user) {
	       User savedUser = userRepository.save(user);
	       return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	   }   
	   
}
