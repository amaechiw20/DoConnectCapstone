package com.doconnect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doconnect.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer>{
	
	public List<Question> findByTopic(String topic);
}
