package com.student.testing.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.student.testing.entity.StudentEntity;
import com.student.testing.repository.StudentRepository;
import com.student.testing.service.StudentService;

@SpringBootTest
class StudentServiceImplTest {
	
	@Autowired
	private StudentService studentService;
	
	@MockBean
	private StudentRepository studentRepository;
	
	@BeforeEach
    public void setup() {
		Optional<StudentEntity> student = Optional.of(new StudentEntity(1,"abc",100,"ddd", null, null));
		Mockito.when(studentRepository.findById(1)).thenReturn(student);
	}

	
	@Test
	public void testStudentStudentBy_IdSucess() {
		String student_name ="abc";
		StudentEntity studentID = studentService.getStudentById(1);
		assertEquals(student_name, studentID.getName());	
	}
}
