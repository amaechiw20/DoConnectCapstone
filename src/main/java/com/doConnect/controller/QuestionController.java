/**
 * 
 */
package com.doConnect.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




/**
 * @author : Edward Lam
 * @date   : 2023-02-20
 */

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")

public class QuestionController {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@GetMapping("/addquestion")
	public Question addQuestion(@RequestBody Question q) {
		return questionRepository.save(q);
	
	}
	
	@GetMapping("/updatequestion")
	public ResponseEntity<Question> updateQuestion(@PathVariable Long id, @RequestBody Question questionBody){
		Question question = questionRepository.findById(id)
				.orElseThrow(() -> new QuestionNotFoundException("Question not exist with id :" + id));
		
		question.setAnswers(questionBody.getAnswers());
		question.setDatetime(questionBody.getDatetime());
		question.setDescription_question(questionBody.getDescription_question());
		question.setImage_src(questionBody.getImage_src());
		question.setStatus(questionBody.getStatus());
		question.setTitle(questionBody.getTitle());
		question.setTopic(questionBody.getTopic());
		
		Question updatedQuestion = questionRepository.save(question);
		return ResponseEntity.ok(updatedQuestion);
	}
	
	@GetMapping("/deletequestionbyid")
	public ResponseEntity<Map<String, Boolean>> deleteQuestionbyId(@PathVariable Long id) {
		Question question = questionRepository.findById(id)
				.orElseThrow(() -> new QuestionNotFoundException("Employee not exist with id :" + id));
		
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
	
	@GetMapping("/getQuestionbytopic")
	public List<Question> getQuestionbyTopic(String topic){
		return questionRepository.findByTopicIs(topic);
	}
	
	@GetMapping("/getquestionbyid")
	public Optional<Question> getQuestionbyId(Long qid) {
		return questionRepository.findById(qid);
	}
	
}
