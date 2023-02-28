package com.doconnect.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.doconnect.entity.Question;
import com.doconnect.exception.ResourceNotFoundException;
import com.doconnect.repo.QuestionRepository;
 

@Service
public class QuestionService {
	
	@Autowired
	private QuestionRepository questionRepo;
	
	//adds a Question to Database
	public Question addQuestion(@RequestBody Question q) {
		return questionRepo.save(q);
	}
	
	
	public ResponseEntity<Question> updateQuestion(@PathVariable Long id, @RequestBody Question questionBody) {
		Question question = questionRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Question not exist with id :" + id));

		question.setAnswers(questionBody.getAnswers());
		question.setDatetime(questionBody.getDatetime());
		question.setDescription_question(questionBody.getDescription_question());
		question.setImage_src(questionBody.getImage_src());
		question.setStatus(questionBody.getStatus());
		question.setTitle(questionBody.getTitle());
		question.setTopic(questionBody.getTopic());

		Question updatedQuestion = questionRepo.save(question);
		return ResponseEntity.ok(updatedQuestion);
	}

	public ResponseEntity<Map<String, Boolean>> deleteQuestionbyId(@PathVariable Long id) {
		Question question = questionRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Question not exist with id :" + id));

		questionRepo.delete(question);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

	public List<Question> getAllQuestion() {
		return questionRepo.findAll();
	}

	public List<Question> getAllQuestionFalse() {
		return questionRepo.findByStatusFalse();
	}

	public List<Question> getQuestionbyTopic(String topic) {
		return questionRepo.findByTopic(topic);
	}

	public Optional<Question> getQuestionbyId(Long qid) {
		return questionRepo.findById(qid);
	}
}
