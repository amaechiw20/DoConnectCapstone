/**
 * 
 */
package com.doConnect.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author : Edward Lam
 * @date   : 2023-02-20
 */
public class Answer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String description_answer;
	private String img_src;
	private String status;
	private String datetime;
	
	@ManyToOne
	private Question question;
	

	// @OneToOne
	private String approved_by;

	// @OneToOne
	private String created_by;
}
