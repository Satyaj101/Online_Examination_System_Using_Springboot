package com.example.question;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class QuestionController {
   
	 @Autowired
	  private QuestionRepository questionRepository; 

	 


	 
	 @GetMapping("/question")
	 public List<Question> getAllQuestion(){
		 return (List<Question>) this.questionRepository.findAll(); 
	 }
	 

	 
	 
	 @PostMapping("/question")
	 public ResponseEntity<Question> addNewQuestion(@RequestBody Question question) {
	     Question savedQuestion = questionRepository.save(question);
	     return new ResponseEntity<>(savedQuestion, HttpStatus.CREATED);
	 }

	 
	 
	 @GetMapping("/exam/{id}/question")
	 public ResponseEntity<List<Question>> getAllQuestionForExam(@PathVariable("id") int id) {
	     List<Question> questions = questionRepository.findByEnameId(id);
	     return new ResponseEntity<>(questions, HttpStatus.OK);
	 }
	 
	 
	 @PutMapping("/question/{id}")
	 public ResponseEntity<Question> updateQuestion(@PathVariable("id") int id, @RequestBody Question question) {
	     question.setId(id);
	     Question updatedQuestion = questionRepository.save(question);
	     return new ResponseEntity<>(updatedQuestion, HttpStatus.OK);
	 }

 
	 @DeleteMapping("/question/{id}")
	 public ResponseEntity<Void> deleteQuestion(@PathVariable("id") int id) {
	     questionRepository.deleteById(id);
	     return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	 }

	 
	 
	 
	 
	 
	 
	 
}
