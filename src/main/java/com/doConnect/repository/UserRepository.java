/**
 * 
 */
package com.doConnect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doConnect.entity.Question;
import com.doConnect.entity.User;


/**
 * @author : Edward Lam
 * @date   : 2023-02-20
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	List<User> findByNameIs(String name);
	List<User> findByTypeIs(String userType);
	User findByUserName(String username);
}
