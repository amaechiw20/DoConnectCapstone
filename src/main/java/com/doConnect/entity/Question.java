package com.doconnect.entity;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



/**
 * @author : Edward Lam
 * @date   : 2023-02-20
 */

@Entity
@Table(name = "questions")
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "description")
	private String description_question;
	
	@Column(name = "image")
	private String image_src;
	
	@Column(name = "datetime")
	private String datetime;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "topic")
	private String topic;
	
	@Column(name = "title")
	private String title;
	
	
	
	
	/**
	 * @param id
	 * @param description_question
	 * @param image_src
	 * @param datetime
	 * @param status
	 * @param topic
	 * @param title
	 * @param answers
	 * @param qcreated_by
	 * @param qapproved_by
	 */
	public Question(int id, String description_question, String image_src, String datetime, String status, String topic,
			String title, List<Answer> answers, String qcreated_by, String qapproved_by) {
		super();
		this.id = id;
		this.description_question = description_question;
		this.image_src = image_src;
		this.datetime = datetime;
		this.status = status;
		this.topic = topic;
		this.title = title;
		this.answers = answers;
		this.qcreated_by = qcreated_by;
		this.qapproved_by = qapproved_by;
	}
	
	
	
	
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}




	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the description_question
	 */
	public String getDescription_question() {
		return description_question;
	}
	/**
	 * @param description_question the description_question to set
	 */
	public void setDescription_question(String description_question) {
		this.description_question = description_question;
	}
	/**
	 * @return the image_src
	 */
	public String getImage_src() {
		return image_src;
	}
	/**
	 * @param image_src the image_src to set
	 */
	public void setImage_src(String image_src) {
		this.image_src = image_src;
	}
	/**
	 * @return the datetime
	 */
	public String getDatetime() {
		return datetime;
	}
	/**
	 * @param datetime the datetime to set
	 */
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the topic
	 */
	public String getTopic() {
		return topic;
	}
	/**
	 * @param topic the topic to set
	 */
	public void setTopic(String topic) {
		this.topic = topic;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the answers
	 */
	public List<Answer> getAnswers() {
		return answers;
	}
	/**
	 * @param answers the answers to set
	 */
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	/**
	 * @return the qcreated_by
	 */
	public String getQcreated_by() {
		return qcreated_by;
	}
	/**
	 * @param qcreated_by the qcreated_by to set
	 */
	public void setQcreated_by(String qcreated_by) {
		this.qcreated_by = qcreated_by;
	}
	/**
	 * @return the qapproved_by
	 */
	public String getQapproved_by() {
		return qapproved_by;
	}
	/**
	 * @param qapproved_by the qapproved_by to set
	 */
	public void setQapproved_by(String qapproved_by) {
		this.qapproved_by = qapproved_by;
	}




	@OneToMany(mappedBy = "question", fetch = FetchType.EAGER)
	@JsonIgnore
	private List<Answer> answers;
	
	// @OneToOne
	private String qcreated_by;
	//
	// @OneToOne
	private String qapproved_by;
}
