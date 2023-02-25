package com.doConnect;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.doConnect.entity.User;
import com.doConnect.repository.UserRepository;

@SpringBootApplication
public class DoConnectApplication {

	@Autowired
	private UserRepository repo;
	
	@PostConstruct
    public void initUsers() {
	repo.deleteAll();
        List<User> users = Stream.of(
                new User(101, "ABC", "gyanendra", "password", "gsytec@gmail.com","ABC"),
                new User(102, "user1", "pwd1", "user1@gmail.com","ABC","ABC"),
                new User(103, "user2", "pwd2", "user2@gmail.com","ABC","ABC"),
                new User(104, "user3", "pwd3", "user3@gmail.com","ABC","ABC")
        ).collect(Collectors.toList());
        repo.saveAll(users);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(DoConnectApplication.class, args);
	}

}
