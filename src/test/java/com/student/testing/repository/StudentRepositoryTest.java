package com.student.testing.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.student.testing.entity.StudentEntity;

@DataJpaTest
class StudentRepositoryTest {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private TestEntityManager testEntityManager;

	@BeforeEach
	void setup() {
		StudentEntity studentEntity = new  StudentEntity(44, "abc", 999, "gdg", null, null);
		testEntityManager.persist(studentEntity);
	}

	@Test
	public void testById() {
		
		StudentEntity studentEntity = studentRepository.findById(1).get();
		assertEquals("abc", studentEntity.getName());
		
	}
}
