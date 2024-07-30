package com.student.testing.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;

import com.student.testing.entity.StudentEntity;
import com.student.testing.helper.DataNotFoundException;

public interface StudentService {
	
	StudentEntity addStudent(StudentEntity studentEntity);
	
	List<StudentEntity> getAllUser();
	
	StudentEntity getStudentById(Integer id);
	
	void  deleteStudent(Integer id);
	
	StudentEntity updateStudent(StudentEntity  studentEntity, Integer id) throws DataNotFoundException ;
	
	StudentEntity getStudentByName(String name);
	
	Page<StudentEntity> fetchStudentsBetweenIdsWithPagination(Date startDate, Date endDate, int pageNumber,int pageSize);

}
