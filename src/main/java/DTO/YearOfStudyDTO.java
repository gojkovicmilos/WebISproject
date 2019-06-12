package DTO;

import java.util.Set;

import lms.domain.StudyProgram;

public class YearOfStudyDTO {
	
	private Long id;
	
	private int numberOfYear;

	private Set<CourseDTO> courses;

	private Set<StudentYearDTO> studentYears;

	private String studyProgram;
	
	
	

	

	public YearOfStudyDTO(Long id, int numberOfYear, Set<CourseDTO> courses, Set<StudentYearDTO> studentYears,
			String studyProgram) {
		this.id = id;
		this.numberOfYear = numberOfYear;
		this.courses = courses;
		this.studentYears = studentYears;
		this.studyProgram = studyProgram;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumberOfYear() {
		return numberOfYear;
	}

	public void setNumberOfYear(int numberOfYear) {
		this.numberOfYear = numberOfYear;
	}

	public Set<CourseDTO> getCourses() {
		return courses;
	}

	public void setCourses(Set<CourseDTO> courses) {
		this.courses = courses;
	}

	public Set<StudentYearDTO> getStudentYears() {
		return studentYears;
	}

	public void setStudentYears(Set<StudentYearDTO> studentYears) {
		this.studentYears = studentYears;
	}

	public String getStudyProgram() {
		return studyProgram;
	}

	public void setStudyProgram(String studyProgram) {
		this.studyProgram = studyProgram;
	}

	
	
	

}
