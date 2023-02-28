package com.doconnect.controller;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doconnect.entity.Answer;
import com.doconnect.entity.Question;
import com.doconnect.entity.User;
import com.doconnect.exception.AnswerNotFoundException;
import com.doconnect.exception.QuestionNotFoundException;
import com.doconnect.exception.UserNotFoundException;
import com.doconnect.repo.AnswerRepository;
import com.doconnect.repo.QuestionRepository;
import com.doconnect.repo.UserRepository;

@RestController
@RequestMapping("/")
public class CustomerController {
	

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private AnswerRepository answerRepository;
	
	
	@GetMapping("/user/adduser")
	public User addUser(@RequestBody User user) {
		return userRepository.save(user);
	}
	
//	@GetMapping("/user/updateuser")
//	public ResponseEntity<User> UpdateUser(@PathVariable Integer uid, @RequestBody User userDetails) {
//		User user = userRepository.findById(uid)
//				.orElseThrow(() -> new UserNotFoundException("User not exist with id :" + uid));
//		
//		user.setEmail(userDetails.getEmail());
//		user.setName(userDetails.getName());
//		user.setPassword(userDetails.getPassword());
//		user.setUsername(userDetails.getUsername());
//		user.setUserType(userDetails.getUserType());
//
//		User updatedUser = userRepository.save(user);
//		return ResponseEntity.ok(updatedUser);
//	}
	
	@GetMapping("/user/getLogin")
	public void getLogin() {
		
	}
	
	@GetMapping("/user/getuserbyname")
	public List<User> getUserbyName(String userType) {
		return userRepository.findByUsertype(userType);
	}
	
	@GetMapping("/user/getbyid")
	public User GetbyId(int uid) {
		return new User();
	}
	
	@GetMapping ("/user/getallusers")
	public List<User> getallusers(){
		return (List<User>) userRepository.findAll();
	}
	
	@GetMapping("/user/getbyalluserType")
	public List<User> getallCustomer(String userType){
		return userRepository.findByUsertype(userType);
	}
	
//	@GetMapping ("/user/DeleteById")
//	public ResponseEntity<Map<String, Boolean>> userDeleteById(@PathVariable Integer uid) {
//		User user = userRepository.findById(uid)
//				.orElseThrow(() -> new UserNotFoundException("User not exist with id :" + uid));
//		
//		userRepository.delete(user);
//		Map<String, Boolean> response = new HashMap<>();
//		response.put("deleted", Boolean.TRUE);
//		return ResponseEntity.ok(response);
//	}
	
	@GetMapping("/Question/addquestion")
	public Question addQuestion(@RequestBody Question q) {
		return questionRepository.save(q);
	}
	
	@GetMapping("/Question/updatequestion")
	public ResponseEntity<Question> updateQuestion(@PathVariable Long id, @RequestBody Question questionBody) {
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
	
	@GetMapping("/Question/deletequestionbyid")
	public  ResponseEntity<Map<String, Boolean>> deleteQuestionbyId(@PathVariable Long qid) {
		Question question = questionRepository.findById(qid)
				.orElseThrow(() -> new QuestionNotFoundException("Question not exist with id :" + qid));
		
		questionRepository.delete(question);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/Question/getallquestion")
	public List<Question> getAllQuestion(){
		return new ArrayList<Question>();
	}
	
	@GetMapping("/Question/getallquestionFalse")
	public List<Question> getAllQuestionFalse(){
		return questionRepository.findAll();
	}
	
	@GetMapping("/Question/getQuestionbytopic")
	public List<Question> getQuestionbyTopic(String topic) {
		return questionRepository.findByTopic(topic);
	}
	
	@GetMapping("/Question/getquestionbyid")
	public Optional<Question> getQuestionbyId(Long qid) {
		return questionRepository.findById(qid);
	}
	
	@GetMapping("/Answer/addanswer")
	public Answer addAnswer(@RequestBody Answer a) {
		return answerRepository.save(a);
	}
	
	@GetMapping("/Answer/getanswerbyid")
	public Optional<Answer> getbyId(Long aid) {
		return answerRepository.findById(aid);
	}
	
	@GetMapping("/Answer/updateanswer")
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
	
	@GetMapping("/Answer/deleteanswerbyid")
	public ResponseEntity<Map<String, Boolean>> deleteAnswerbyId(@PathVariable Long id) {
		Answer answer = answerRepository.findById(id)
				.orElseThrow(() -> new AnswerNotFoundException("Answer not exist with id :" + id));
		
		answerRepository.delete(answer);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/Answer/getAnswersbyQuestionID")
	public List<Answer> getAnswerbyQuestionId(@PathVariable Long id, QuestionRepository qr) {
		Optional<Question> q = qr.findById(id);
		return q.get().getAnswers();
	}
}
