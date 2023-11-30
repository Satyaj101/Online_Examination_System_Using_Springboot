package com.example.subject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class SubjectController {
	
	 @Autowired
	 private SubjectRepository subjectRepository;
	 

	 
	 
	   @GetMapping("/subject")
	    public ResponseEntity<List<Subject>> getAllSubjects() {
	        List<Subject> subjects = (List<Subject>) subjectRepository.findAll();

	        if (subjects.isEmpty()) {
	            return new ResponseEntity<>(HttpStatus.ACCEPTED);
	        } else {
	            return new ResponseEntity<>(subjects, HttpStatus.OK);
	        }
	    }
	   
	

	   
	   @PostMapping("/subject")
	   public ResponseEntity<Subject> addNewSubject(@RequestBody Subject subject) {
	       Subject savedSubject = subjectRepository.save(subject);
	       return new ResponseEntity<>(savedSubject, HttpStatus.CREATED);
	   }

	   
	   
	   
	   
	   

	   

	   
	   @DeleteMapping("/subject/{name}")
	    public ResponseEntity<String> deleteSubject(@PathVariable String name) {
	         subjectRepository.deleteByName(name);
	        return ResponseEntity.ok( " SUBJECT(s) deleted");
	    }
	


}
