package com.doconnect.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doconnect.entity.Question;
import com.doconnect.exception.ResourceNotFoundException;
import com.doconnect.repository.QuestionRepository;

@RestController
@RequestMapping("/questions")
public class QuestionController {

	@Autowired
	private QuestionRepository questionRepo;
	
	//add a question
	@PostMapping("/addquestion")
	public Question AddQuestion(@RequestBody Question question) {
		return questionRepo.save(question);
	}
	
	// update a question detail
	@PutMapping("/updatequestion/{id}")
	public ResponseEntity<Question> UpdateQuestion(@PathVariable Integer id, @RequestBody Question questionDetails){
		Question question = questionRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Question with the id : "+id+" doesn't exist!!!"));
		
		question.setDescription_question(questionDetails.getDescription_question());
		question.setImage_src(questionDetails.getImage_src());
		question.setTopic(questionDetails.getTopic());
		question.setTitle(questionDetails.getTitle());
		
		Question updatedQuestion = questionRepo.save(question);
		return ResponseEntity.ok(updatedQuestion);
	}
	
	//delete question by id
	@DeleteMapping("/deletequestionbyid/{id}")
	public ResponseEntity<Map<String, Boolean>> DeleteQuestionbyId(@PathVariable Integer id){
		Question question = questionRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Question with the id : "+id+" doesn't exist!!!"));
	
		questionRepo.delete(question);
		Map<String, Boolean> response = new HashMap();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	//get all question
	@GetMapping("/getallquestion")
	public List<Question> GetAllQuestion(){
		return questionRepo.findAll();
	}
	
	//get question by topic
	@GetMapping("/getquestionbytopic")
	public List<Question> GetQuestionByTopic(@PathVariable String topic){
		return questionRepo.findByTopic(topic);
	}
	
	//get question by id
	@GetMapping("/getquestionbyid/{id}")
	public ResponseEntity<Question> GetQuestionbyTopic(@PathVariable Integer id){
		Question question = questionRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Question with the id : "+id+" doesn't exist!!!"));
		return ResponseEntity.ok(question);
	}

}