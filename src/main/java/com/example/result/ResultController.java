package com.example.result;

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
public class ResultController {

	  @Autowired
	  private ResultRepository resultRepository;

	  @GetMapping("/result")
	  public ResponseEntity<List<Result>> getAllResult() {
	      List<Result> results = (List<Result>) resultRepository.findAll();
	      return new ResponseEntity<>(results, HttpStatus.OK);
	  }
	  

	  @PostMapping("/result")
	  public ResponseEntity<Result> addNewResult(@RequestBody Result result) {
	      Result savedResult = resultRepository.save(result);
	      return new ResponseEntity<>(savedResult, HttpStatus.CREATED);
	  }

	  
	  @GetMapping("/user/{email}/result")
	  public ResponseEntity<List<Result>> getAllResultForStudent(@PathVariable("email") String email) {
	      List<Result> results = resultRepository.findByEmailEmail(email);
	      return new ResponseEntity<>(results, HttpStatus.OK);
	  }
	  
}
