package com.student.testing.repository;

import java.awt.print.Pageable;
import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.student.testing.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity,Integer> {
	
	StudentEntity findByName(String name);
	
	@Query(value = "SELECT * FROM Student s WHERE s.start_date >= :startDate AND s.start_date <= :endDate", nativeQuery = true)
    Page<StudentEntity> findByStartDateBetween(@Param("startDate") Date startDate, @Param("endDate") Date endDate, PageRequest pageRequest);

}
