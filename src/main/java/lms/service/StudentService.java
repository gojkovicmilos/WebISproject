package lms.service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lms.SecurityHash;
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
	
	public StudentService() {}

	public void enrollInFirstYear(Student student) {
		YearOfStudy yearOfStudy = yearOfStudyRepository.findFirstByNumberOfYear(1);
		StudentYear studentYear = new StudentYear();
		studentYear.setYearOfStudy(yearOfStudy);
		student.getStudentYears().add(studentYear);
		studentRepository.save(student);
	}

	public Optional<Student> getByCardNumber(String cardNumber) {
		return studentRepository.findFirstByCardNumber(cardNumber);
	}

	public Set<Course> findAllCurrentCourses(Student student) {
		Set<Course> ret = new HashSet<>();

		for (StudentYear studentYear : student.getStudentYears())
			for (Course course : studentYear.getYearOfStudy().getCourses())
				ret.add(course);

		return ret;

	}

	public Set<Course> findAllFinishedCourses(Student student) {
		Set<Course> ret = new HashSet<>();

		for (CourseAttending courseAttending : student.getCourseAttendings())
			ret.add(courseAttending.getCourseRealization().getCourse());

		return ret;

	}
	
	public Iterable<Student> getByFirstName(String firstName) {
		return studentRepository.findByFirstName(firstName);
	}
	
	public Iterable<Student> getByLastName(String lastName) {
		return studentRepository.findByLastName(lastName);
	}

	public Iterable<Student> getStudents() {
		return studentRepository.findAll();
	}

	public Optional<Student> getStudentById(Long id) {
		return studentRepository.findById(id);
	}

	public void addStudent(Student s) throws NoSuchAlgorithmException {
		
		//s.setPass(SecurityHash.hashIt(s.getPass()));
		studentRepository.save(s);
	}

	public Optional<Student> getStudent(Long id) {
		return studentRepository.findById(id);
	}

	public void removeStudent(Long id) {
		Optional<Student> s = studentRepository.findById(id);
		studentRepository.delete(s.get());
	}

	public void updateStudent(Long id, Student s) {
		Optional<Student> S = studentRepository.findById(id);
		if (S.isPresent()) {
			s.setId(S.get().getId());
			studentRepository.save(s);
		}
	}
	
	public void softRemoveStudent(Long id)
	{
		Student s = studentRepository.findById(id).get();
		
		s.setDeleted(true);
		updateStudent(id, s);
	
	}
	
	public Student logIn(String card, String pass)
	{
		
		for(Student s: studentRepository.findAll())
			if(s.getCardNumber().equals(card))
				if(SecurityHash.hashIt(pass).equals(s.getPass()))
					return s;
		
		return null;
		
		

		
	}
	
	
	
	

}
