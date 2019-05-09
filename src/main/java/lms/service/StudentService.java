package lms.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lms.domain.Course;
import lms.domain.CourseAttending;
import lms.domain.Student;
import lms.domain.StudentYear;
import lms.domain.YearOfStudy;
import lms.repository.CourseAttendingRepository;
import lms.repository.CourseRepository;
import lms.repository.StudentRepository;
import lms.repository.YearOfStudyRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	YearOfStudyRepository yearOfStudyRepository;
	
	@Autowired
	CourseAttendingRepository courseAttendingRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	
	public void enrollInFirstYear(Student student) {
		YearOfStudy yearOfStudy = yearOfStudyRepository.findFirstByNumberOfYear(1);
		StudentYear studentYear = new StudentYear();
		studentYear.setYearOfStudy(yearOfStudy);
		student.getStudentYears().add(studentYear);
		studentRepository.save(student);
	}
	
	public Student findByCardNumber(String cardNumber) {
		return studentRepository.findFirstByCardNumber(cardNumber);
	}
	
	
	public Set<Course> findAllCurrentCourses(Student student)
	{
		Set<Course> ret = new HashSet<>();
		
		for(StudentYear studentYear: student.getStudentYears())
			for(Course course: studentYear.getYearOfStudy().getCourses())
				ret.add(course);
		
		return ret;
		
		
	}
	
	public Set<Course> findAllFinishedCourses(Student student)
	{
		Set<Course> ret = new HashSet<>();
		
		for(CourseAttending courseAttending: student.getCourseAttendings())
			ret.add(courseAttending.getCourseRealization().getCourse());
		
		return ret;
			
	}
	

	
}
