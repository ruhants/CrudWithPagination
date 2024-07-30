package com.student.testing.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.testing.entity.StudentEntity;
import com.student.testing.helper.DataNotFoundException;
import com.student.testing.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/create")
	public StudentEntity addStudent(@RequestBody StudentEntity studentEntity) {
		return studentService.addStudent(studentEntity);
		
	}
	
	@GetMapping("/allStudents")
	public List<StudentEntity> getAllUser() {
		return studentService.getAllUser();
	}

	@GetMapping("/{student-Id}")
	public StudentEntity getStudentById(@PathVariable("student-Id") Integer id) {
		return studentService.getStudentById(id);
		
	}
	@DeleteMapping("/{student-Id}")
	public void deleteStudent(@PathVariable("student-Id") Integer id) {
		studentService.deleteStudent(id);
	}
	
	@PutMapping("/{student-Id}")
	public ResponseEntity<StudentEntity> updateStudent(@PathVariable("student-Id") Integer id,@RequestBody StudentEntity studentEntity ) throws DataNotFoundException  {
		StudentEntity updated =this.studentService.updateStudent(studentEntity,id);
		return new ResponseEntity<StudentEntity>(updated,HttpStatus.OK);
		
	}
	
	@GetMapping("/byname")
	public StudentEntity getStudentTByName(@RequestParam String name){
		return studentService.getStudentByName(name);
		
		
	}
	// http://localhost:8080/student/pagination?startDate=2022-01-15&endDate=2023-10-15&pageNumber=0&pageSize=10
	@GetMapping("/pagination")
    public Page<StudentEntity> getStudentsBetweenDates(
    		 @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
    	        @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate,
    	        @RequestParam(value = "pageNumber", defaultValue = "0") int pageNumber,
    	        @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
    	        @RequestParam(value = "sortBy", defaultValue = "id") String sortBy) {

		Sort sort = Sort.by(Sort.Direction.DESC, sortBy);
        
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize,sort);
        return studentService.fetchStudentsBetweenIdsWithPagination(startDate, endDate, pageNumber, pageSize);
    }
}

