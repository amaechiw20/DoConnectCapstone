/**
 * 
 */
package com.doConnect.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import com.doConnect.entity.Answer;
import com.doConnect.entity.Question;
import com.doConnect.entity.User;


/**
 * @author : Edward Lam
 * @date   : 2023-02-20
 */
public class CustomerController {
	@GetMapping("/")
	public void home() {
		
	}
	
	
	@GetMapping("/user/adduser ")
	public void addUser() {
		
	}
	
	@GetMapping("/User/updateuser")
	public void UpdateUser() {
		
	}
	
	@GetMapping("/User/getbyLogin")
	public void getLogin() {
		
	}
	
	@GetMapping("/User/getbyalluserType")
	public User getUserbyName(String name) {
		return new User();
	}
	
	@GetMapping("/User/getbyid")
	public User GetbyId(int uid) {
		return new User();
	}
	
	@GetMapping ("/User/getallusers")
	public List<User> getallusers(){
		return new ArrayList<User>();
	}
	
	@GetMapping("/User/getbyalluserType")
	public List<User> getallCustomer(){
		return new ArrayList<User>();
	}
	
	@GetMapping ("/User/DeleteById")
	public void userDeleteById(int uid) {
		
	}
	
	@GetMapping("/Question/addquestion")
	public void addQuestion() {
		
	}
	
	@GetMapping("/Question/updatequestion")
	public void updateQuestion() {
		
	}
	@GetMapping("/Question /deletequestionbyid")
	public void deleteQuestionbyId() {
		
	}
	
	@GetMapping("Question /getallquestion")
	public List<Question> getAllQuestion(){
		return new ArrayList<Question>();
	}
	
	@GetMapping("Question /getallquestionFalse")
	public List<Question> getAllQuestionFalse(){
		return new ArrayList<Question>();
	}
	
	@GetMapping("Question /getQuestionbytopic")
	public Question getQuestionbyTopic(String topic) {
		return new Question();
	}
	
	@GetMapping("Question /getquestionbyid")
	public Question getQuestionbyId() {
		return new Question();
	}
	
	@GetMapping("/Answer /addanswer")
	public void addAnswer() {
		
	}
	
	@GetMapping("/Answer /getanswerbyid")
	public Answer getbyId() {
		return new Answer();
	}
	
	@GetMapping("/Answer /updateanswer")
	public void updateAnswer() {
		
	}
	
	@GetMapping("/Answer /deleteanswerbyid")
	public void deleteAnswerbyId() {
		
	}
	
	@GetMapping("/Answer/getAnswersbyQuestionID")
	public Answer getAnswerbyQuestionId() {
		return new Answer();
	}

}
