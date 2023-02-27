package com.doconnect.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.doconnect.entity.Answer;
import com.doconnect.entity.Question;
import com.doconnect.exception.ResourceNotFoundException;
import com.doconnect.repo.AnswerRepository;
import com.doconnect.repo.QuestionRepository;

/**
 * @author William Amaechi
 * @date Feb 27, 2023
 */

@Service
public class AnswerService {
	
	@Autowired
	private AnswerRepository answerRepository;
	
	public List<Answer> getAllAnswer(){
		return answerRepository.findAll();
	}
	
	public Set<Answer> getAllAnswerFalse(){
		return answerRepository.findByStatusFalse();
	}
	
	public Answer addAnswer(@RequestBody Answer a) {
		return answerRepository.save(a);
	}
	
	public Optional<Answer> getbyId(Long aid) {
		return answerRepository.findById(aid);
	}
	
	public ResponseEntity<Answer> updateAnswer(@PathVariable Long id, Answer answerBody) {
		Answer answer = answerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Answer not exist with id :" + id));
		
		answer.setDatetime(answerBody.getDatetime());
		answer.setDescription_answer(answerBody.getDescription_answer());
		answer.setImg_src(answerBody.getImg_src());
		answer.setStatus(answer.getStatus());
		answer.setApproved_by(answer.getApproved_by());
		answer.setCreated_by(answer.getCreated_by());

		Answer updatedAnswer = answerRepository.save(answer);
		return ResponseEntity.ok(updatedAnswer);
	}

	public ResponseEntity<Map<String, Boolean>> deleteAnswerbyId(@PathVariable Long id) {
		Answer answer = answerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Answer not exist with id :" + id));
		
		answerRepository.delete(answer);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	public List<Answer> getAnswerbyQuestionId(@PathVariable Long id, QuestionRepository qr) {
		Optional<Question> q = qr.findById(id);
		return q.get().getAnswers();
	}
}
