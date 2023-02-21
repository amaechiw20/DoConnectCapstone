/**
 * 
 */
package com.doConnect.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import com.doConnect.entity.Answer;
import com.doConnect.entity.User;



/**
 * @author : Edward Lam
 * @date   : 2023-02-20
 */
public class AnswerController {
	@GetMapping("/getallanswers")
	public List<User> getAllUser(){
		return new ArrayList<User>();
	}
	
	@GetMapping("/getAllAnswerFalse")
	public List<Answer> getAllAnswerFalse(){
		return new ArrayList<Answer>();
	}
	
	@GetMapping("/addanswer")
	public void addAnswer() {
		
	}
	
	@GetMapping("/getanswerbyid")
	public Answer getbyId(int aid) {
		return new Answer();
	}
	
	@GetMapping("/updateanswer")
	public void updateAnswer() {
		
	}
	
	@GetMapping("/deleteanswerbyid")
	public void deleteAnswerbyId() {
		
	}
	
	@GetMapping("/getAnswersbyQuestionID")
	public Answer getAnswerbyQuestionId() {
		return new Answer();
	}
}
