/**
 * 
 */
package com.doConnect.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.doConnect.entity.Answer;
import com.doConnect.entity.Question;
import com.doConnect.repository.AnswerRepository;
import com.doConnect.repository.QuestionRepository;

import exception.AnswerNotFoundException;




/**
 * @author : Edward Lam
 * @date   : 2023-02-20
 */
public class AnswerController {
	
	AnswerRepository answerRepository;
	
	@GetMapping("/getallanswers")
	public List<Answer> getAllAnswer(){
		return answerRepository.findAll();
	}
	
	@GetMapping("/getAllAnswerFalse")
	public List<Answer> getAllAnswerFalse(){
		return answerRepository.findByStatusFalse();
	}
	
	@GetMapping("/addanswer")
	public Answer addAnswer(@RequestBody Answer a) {
		return answerRepository.save(a);
	}
	
	@GetMapping("/getanswerbyid")
	public Optional<Answer> getbyId(Long aid) {
		return answerRepository.findById(aid);
	}
	
	@GetMapping("/updateanswer")
	public ResponseEntity<Answer> updateAnswer(@PathVariable Long id, Answer answerBody) {
		Answer answer = answerRepository.findById(id)
				.orElseThrow(() -> new AnswerNotFoundException("Answer not exist with id :" + id));
		
		answer.setDatetime(answerBody.getDatetime());
		answer.setDescription_answer(answerBody.getDescription_answer());
		answer.setImg_src(answerBody.getImg_src());
		answer.setStatus(answer.getStatus());
		answer.setApproved_by(answer.getApproved_by());
		answer.setCreated_by(answer.getCreated_by());

		Answer updatedAnswer = answerRepository.save(answer);
		return ResponseEntity.ok(updatedAnswer);
	}
	
	@GetMapping("/deleteanswerbyid")
	public ResponseEntity<Map<String, Boolean>> deleteAnswerbyId(@PathVariable Long id) {
		Answer answer = answerRepository.findById(id)
				.orElseThrow(() -> new AnswerNotFoundException("Answer not exist with id :" + id));
		
		answerRepository.delete(answer);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/getAnswersbyQuestionID")
	public List<Answer> getAnswerbyQuestionId(@PathVariable Long id, QuestionRepository qr) {
		Optional<Question> q = qr.findById(id);
		return q.get().getAnswers();
	}
}
