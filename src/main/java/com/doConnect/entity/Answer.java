package com.doconnect.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "description")
	private String description_answer;

	@Column(name = "image")
	private String img_src;

	@Column(name = "status")
	private String status;

	@Column(name = "datetime")
	private String datetime;

	@ManyToOne
	@JoinColumn(name = "question")
	private Question question;

	// @OneToOne
	@Column(name = "approved_by")
	private String approved_by;

	// @OneToOne
	@Column(name = "created_by")
	private String created_by;

	public Answer(int id, String description_answer, String img_src, String status, String datetime, Question question,
			String approved_by, String created_by) {
		super();
		this.id = id;
		this.description_answer = description_answer;
		this.img_src = img_src;
		this.status = status;
		this.datetime = datetime;
		this.question = question;
		this.approved_by = approved_by;
		this.created_by = created_by;
	}

	public Answer() {
		super();

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription_answer() {
		return description_answer;
	}

	/**
	 * @param description_answer the description_answer to set
	 */
	public void setDescription_answer(String description_answer) {
		this.description_answer = description_answer;
	}

	/**
	 * @return the img_src
	 */
	public String getImg_src() {
		return img_src;
	}

	/**
	 * @param img_src the img_src to set
	 */
	public void setImg_src(String img_src) {
		this.img_src = img_src;
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
	 * @return the question
	 */
	public Question getQuestion() {
		return question;
	}

	/**
	 * @param question the question to set
	 */
	public void setQuestion(Question question) {
		this.question = question;
	}

	/**
	 * @return the approved_by
	 */
	public String getApproved_by() {
		return approved_by;
	}

	/**
	 * @param approved_by the approved_by to set
	 */
	public void setApproved_by(String approved_by) {
		this.approved_by = approved_by;
	}

	/**
	 * @return the created_by
	 */
	public String getCreated_by() {
		return created_by;
	}

	/**
	 * @param created_by the created_by to set
	 */
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}
}
