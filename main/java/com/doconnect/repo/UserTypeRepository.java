package com.doconnect.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.doconnect.entity.UserType;

@Repository
public interface UserTypeRepository extends CrudRepository<UserType, String> {

}
