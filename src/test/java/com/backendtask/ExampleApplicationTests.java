package com.backendtask;

import com.backendtask.topic.TopicControllerTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {ExampleApplicationTests.class, TopicControllerTest.class})
class ExampleApplicationTests {

	@Test
	void contextLoads() {
	}

}
