package com.doConnect.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author William Amaechi
 * @date Feb 20, 2023
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "questions")
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String description_question;
	private String image_src;
	private String datetime;
	private String status;
	private String topic;
	private String title;
	@OneToMany(mappedBy = "question", fetch=FetchType.EAGER)
	@JsonIgnore
	private List<Answer> answers;
	
	// @OneToOne
	private String qcreated_by;
	//
	// @OneToOne
	private String qapproved_by;
}
