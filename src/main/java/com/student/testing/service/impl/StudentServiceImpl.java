package com.student.testing.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.student.testing.entity.StudentEntity;
import com.student.testing.helper.DataNotFoundException;
import com.student.testing.repository.StudentRepository;
import com.student.testing.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public StudentEntity addStudent(StudentEntity studentEntity) {
		// TODO Auto-generated method stub
		return studentRepository.save(studentEntity);
	}

	@Override
	public List<StudentEntity> getAllUser() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	@Override
	public StudentEntity getStudentById(Integer id) {
		// TODO Auto-generated method stub
		return studentRepository.findById(id).get();
	}
	@Override
	public void deleteStudent(Integer id) {
		// TODO Auto-generated method stub
		studentRepository.deleteById(id);	
	}
	@Override
	public StudentEntity updateStudent(StudentEntity studentEntity, Integer id) throws DataNotFoundException{
		
		
			StudentEntity studentEntity2 = studentRepository.findById(id).orElseThrow(()-> new  DataNotFoundException("Student with ID " + id + " not found"));
			studentEntity2.setName(studentEntity.getName());
			studentEntity2.setAdress(studentEntity.getAdress());
			studentEntity2.setRollNumber(studentEntity.getRollNumber());	
	
		return studentRepository.save(studentEntity2);	
	}

	@Override
	public StudentEntity getStudentByName(String name) {
		// TODO Auto-generated method stub
		return studentRepository.findByName(name);
	}

	@Override
	public Page<StudentEntity> fetchStudentsBetweenIdsWithPagination(Date startDate, Date endDate, int pageNumber,int pageSize) {
		//int PagaeSize =5;
		PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
		// TODO Auto-generated method stub
		return studentRepository.findByStartDateBetween(startDate, endDate,pageRequest);
	}
}