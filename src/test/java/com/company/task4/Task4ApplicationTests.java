package com.company.task4;

import com.company.task4.entity.User;
import io.jmix.core.security.CurrentAuthentication;
import io.jmix.core.security.SystemAuthenticator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.context.SecurityContext;

@SpringBootTest
class Task4ApplicationTests {


//	private final String username = "admin";
//	@Autowired
//	private SystemAuthenticator systemAuthenticator;
//	@Autowired
//	private CurrentAuthentication currentAuthentication;

	@Test
	void contextLoads() {

	}

//	@BeforeEach
//	void setUp() {
//		systemAuthenticator.begin(username);
//	}
//	@AfterEach
//	void tearDown()
//	{
//		systemAuthenticator.end();
//	}
//	@Test
//	void checkSystemUser()
//	{
//		User user = (User) currentAuthentication.getUser();
//		Assertions.assertEquals(user.getUsername(), username);
//	}

}
