package com.doConnect.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
@Table(name ="answers")
public class Answer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
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
