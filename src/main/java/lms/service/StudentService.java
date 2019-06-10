package lms.service;

import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DTO.CourseGradeDTO;
import DTO.EvaluationPointsDTO;
import lms.domain.Course;
import lms.domain.CourseAttending;
import lms.domain.EvaluationAttending;
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

	public StudentService() {
	}

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
		
		for (CourseAttending courseAttending : student.getCourseAttendings())
			if(ret.contains(courseAttending.getCourseRealization().getCourse()))
				ret.remove(courseAttending.getCourseRealization().getCourse());

		return ret;

	}

	public Set<CourseGradeDTO> findAllFinishedCourses(Student student) {
		Set<CourseGradeDTO> ret = new HashSet<>();

		for (CourseAttending courseAttending : student.getCourseAttendings())
			ret.add(new CourseGradeDTO(courseAttending.getCourseRealization().getCourse(), courseAttending.getGrade()));

		return ret;

	}
	
	
	public Set<EvaluationPointsDTO>findAllEvaluations(StudentYear studentYear)
	{
		Set<EvaluationPointsDTO> ret = new HashSet<>();
		
		for(EvaluationAttending ea: studentYear.getEvaluationAttendings())
			ret.add(new EvaluationPointsDTO(ea.getEvaluation().getEvaluationType(), ea.getEvaluation().getTotalPoints(), ea.getAchievedPoints()));
		
		
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

	

}
