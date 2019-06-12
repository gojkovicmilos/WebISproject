package DTO;

import java.time.LocalDate;

public class StudentYearDTO {


	private Long id;

	

	private LocalDate registrationDate;

	private String yearOfStudy;

	private StudentDTO student;

	

	public StudentYearDTO(Long id, LocalDate registrationDate, String yearOfStudy, StudentDTO student) {
		this.id = id;
		this.registrationDate = registrationDate;
		this.yearOfStudy = yearOfStudy;
		this.student = student;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}

	

	public String getYearOfStudy() {
		return yearOfStudy;
	}

	public void setYearOfStudy(String yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
	}

	public StudentDTO getStudent() {
		return student;
	}

	public void setStudent(StudentDTO student) {
		this.student = student;
	}
	
	
	
	

	
}
