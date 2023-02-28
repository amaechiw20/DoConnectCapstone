/**
 * 
 */
package com.doconnect.repo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doconnect.entity.Question;




/**
 * @author : Edward Lam
 * @date   : 2023-02-20
 */
@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer>{
	List<Question> findByStatusFalse();
	List<Question> findByTopic(String topic);
	List<Question> findByTopicAndTitle(String topic, String title);
	List<Question> findByStatus(String string);
	
}
