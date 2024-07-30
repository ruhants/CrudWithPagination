package com.student.testing.entity;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="student")
public class StudentEntity {
	
	@Id
	@Column(name="Id")
	private int id;
	@Column(name="Name")
	private String name;
	@Column(name="Roll_Number")
	private int rollNumber;
	@Column(name="Adress")
	private String adress;
	
	@Column(name="Start_Date")
    private Date startDate; // or LocalDate or LocalDateTime
    
    @Column(name="End_Date")
    private Date endDate;

	public StudentEntity() {
		super();
		
	}

	public StudentEntity(int id, String name, int rollNumber, String adress, Date startDate, Date endDate) {
		super();
		this.id = id;
		this.name = name;
		this.rollNumber = rollNumber;
		this.adress = adress;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "StudentEntity [id=" + id + ", name=" + name + ", rollNumber=" + rollNumber + ", adress=" + adress
				+ ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(adress, endDate, id, name, rollNumber, startDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentEntity other = (StudentEntity) obj;
		return Objects.equals(adress, other.adress) && Objects.equals(endDate, other.endDate) && id == other.id
				&& Objects.equals(name, other.name) && rollNumber == other.rollNumber
				&& Objects.equals(startDate, other.startDate);
	}

	
}
