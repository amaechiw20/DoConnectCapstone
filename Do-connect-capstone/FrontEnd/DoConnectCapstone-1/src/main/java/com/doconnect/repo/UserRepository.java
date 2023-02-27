package com.doconnect.repo;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.doconnect.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
	
	public List<User> findByName(String name);
	public List<User> findByUsertype(String userType);
	public User findByUsername(String username);

}
