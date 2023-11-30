package com.example.Exam;

import java.util.List;
import java.util.Optional;

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
public class ExamController {
	
	@Autowired
	private ExamRepository examRepository;

    @GetMapping("/exam")
    public ResponseEntity<List<Exam>> getAllExam() {
        List<Exam> exams = (List<Exam>) examRepository.findAll();

        if (exams.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(exams, HttpStatus.OK);
        }
    }
	

    @GetMapping("/exam/{id}")
    public ResponseEntity<Exam> getParticularExam(@PathVariable("id") int id) {
        Optional<Exam> optionalExam = examRepository.findById(id);

        if (optionalExam.isPresent()) {
            return new ResponseEntity<>(optionalExam.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
    
    @PostMapping("/exam")
    public ResponseEntity<Exam> addNewExam(@RequestBody Exam exam) {
        Exam savedExam = examRepository.save(exam);

        return new ResponseEntity<>(savedExam, HttpStatus.OK);
    }
    
    
	 @DeleteMapping("/exam/{id}")
	 public ResponseEntity<Void> deleteQuestion(@PathVariable("id") int id) {
	     examRepository.deleteById(id);
	     return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	 }
	
	
	

	
}
