/**
 * 
 */
package com.doConnect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doConnect.entity.Question;




/**
 * @author : Edward Lam
 * @date   : 2023-02-20
 */
@Repository
public interface QuestionRepository extends JpaRepository<Question, Long>{
	List<Question> findByStatusFalse();
	List<Question> findByTopic(String topic);
	
}
