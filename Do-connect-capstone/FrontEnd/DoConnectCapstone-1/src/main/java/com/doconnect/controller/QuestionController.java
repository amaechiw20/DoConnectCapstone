package com.doconnect.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doconnect.entity.Question;
import com.doconnect.exception.QuestionNotFoundException;
import com.doconnect.repo.QuestionRepository;

@RestController
@RequestMapping("/")
public class QuestionController {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@PostMapping("/addquestion")
	public Question addQuestion(@RequestBody Question q) {
		return questionRepository.save(q);
	
	}
	
	@GetMapping("/getquestionbyid/{id}")
	public ResponseEntity<Question> gqtquestionbyid(@PathVariable Integer id){
		Question question =  questionRepository.findById(id)
				.orElseThrow(() -> new QuestionNotFoundException("Question not exist with id :" + id));
		return ResponseEntity.ok(question);
	}
	
	@PutMapping("/updatequestionstatus/{id}")
	public ResponseEntity<Question> updateQuestion(@PathVariable Integer id){
		Question question = (Question) questionRepository.findById(id)
				.orElseThrow(() -> new QuestionNotFoundException("Question not exist with id :" + id));
		
		question.setStatus("Approved");
		
		Question updatedQuestion = questionRepository.save(question);
		return ResponseEntity.ok(updatedQuestion);
	}
	
	@DeleteMapping("/deletequestionbyid/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteQuestionbyId(@PathVariable Integer id) {
		Question question = questionRepository.findById(id)
				.orElseThrow(() -> new QuestionNotFoundException("Question not exist with id :" + id));
		
		questionRepository.delete(question);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/getallquestion")
	public List<Question>getAllQuestion(){
		return questionRepository.findAll();
	}
	
	@GetMapping("/getallquestionFalse")
	public List<Question> getAllQuestionFalse(){
		return questionRepository.findByStatusFalse();
	}
	
	@PostMapping("/searchquestion")
	public List<Question> SearchQuestion(@RequestBody Question q){
		return questionRepository.findByTopicAndTitle(q.getTopic(), q.getTitle());
	}
	
	@GetMapping("/pendingquestion")
	public List<Question> PendingQuestion(){
		return questionRepository.findByStatus("Pending");
	}
}
