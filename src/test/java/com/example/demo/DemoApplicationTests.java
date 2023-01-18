package com.example.demo;

import com.example.demo.dao.StudentRepo;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Mock
	private StudentRepo mockStudentRepo;

	@InjectMocks
	private StudentService myService;

	@Test
	public void testGetData() {
		// Arrange
		List<Student> expectedData = Arrays.asList(new Student("Mike", "Two"));
		when(mockStudentRepo.findAll()).thenReturn(expectedData);

		// Act
		Iterable<Student> actualData = myService.findAll();

		// Assert
		assertEquals(expectedData, actualData);

		verify(mockStudentRepo, times(1)).findAll();
	}
}
