/**
 * 
 */
package com.doConnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doConnect.entity.Answer;



/**
 * @author : Edward Lam
 * @date   : 2023-02-20
 */
@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long>{

}
