package com.nisum.training;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.nisum.TrainingController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrainingApplicationTests {

	
	TrainingController trainingController = new TrainingController();
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testAddTwoNumbers() {
		Long result = trainingController.addNumbers(2L, 3L);
		assertTrue("Numbers should be equal", result == 5L);
	}
	
	@Test
	public void testAddTwoNumbersForLargeValue() {
		Long result = trainingController.addNumbers(5555L, 0L);
		assertTrue("Numbers should be equal", result == 5555L);
	}

}
