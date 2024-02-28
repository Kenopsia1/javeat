package com.generation.javeat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.generation.javeat.model.repositories.UserRepository;

@SpringBootTest
class JaveatApplicationTests {

	@Autowired
	UserRepository uRepo;
	
	@Test
	void contextLoads() {
		uRepo.findAll();
	}

}
