package com.tpcs.demo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class IssueApplicationTests {

	//@Autowired
	//CustomerInfoMapper customerInfoMapper;

	@Test
	void getUser() {
		System.out.println("hello world!");
	}

}