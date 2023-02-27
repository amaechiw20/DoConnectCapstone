/**
 * 
 */
package com.doconnect.repo;



import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doconnect.entity.Answer;



/**
 * @author : Edward Lam
 * @date   : 2023-02-20
 */
@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long>{
	Set<Answer> findByStatusFalse();
}
