package lms.service;

import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DTO.CourseDTO;
import DTO.CourseGradeDTO;
import DTO.EvaluationPointsDTO;
import DTO.StudentDTO;
import lms.domain.Course;
import lms.domain.CourseAttending;
import lms.domain.Evaluation;
import lms.domain.EvaluationAttending;
import lms.domain.Student;
import lms.domain.StudentYear;
import lms.domain.User;
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
	CourseAttendingService courseAttendingService;

	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	UserService userService;

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

	public Set<CourseDTO> findAllCurrentCourses(Student student) {
		Set<CourseDTO> ret = new HashSet<>();

		for (StudentYear studentYear : student.getStudentYears())
			for (Course course : studentYear.getYearOfStudy().getCourses())
				ret.add(course.toDTO());
		
		for (CourseAttending courseAttending : student.getCourseAttendings())
			if(ret.contains(courseAttending.getCourseRealization().getCourse().toDTO()))
				ret.remove(courseAttending.getCourseRealization().getCourse().toDTO());

		return ret;

	}

	public Set<CourseGradeDTO> findAllFinishedCourses(Student student) {
		Set<CourseGradeDTO> ret = new HashSet<>();

		for (CourseAttending courseAttending : student.getCourseAttendings())
			ret.add(new CourseGradeDTO(courseAttending.getCourseRealization().getCourse().getTitle(), courseAttending.getGrade()));

		return ret;

	}
	
	
	public Set<EvaluationPointsDTO>findAllEvaluations(Course course, Student student)
	{
		
		CourseAttending ca = courseAttendingService.getCourseAttendingSubjectStudent(course, student);
		
		Set<EvaluationPointsDTO> ret = new HashSet<>();
		
		for(Evaluation e: ca.getCourseRealization().getEvaluations())
			for(EvaluationAttending ea: e.getEvaluationAttendings())
				if(ea.getStudentYear().getStudent() == ca.getStudent())
					ret.add(new EvaluationPointsDTO(e.getEvaluationType().getTitle(), e.getTotalPoints(), ea.getAchievedPoints()));
			
			
		
		
		return ret;
	}
	
	

	public Iterable<Student> getByFirstName(String firstName) {
		return studentRepository.findByFirstName(firstName);
	}

	public Iterable<Student> getByLastName(String lastName) {
		return studentRepository.findByLastName(lastName);
	}

	public Iterable<StudentDTO> getStudents() {
		List<Student> ss = studentRepository.findAll();
		Set<StudentDTO> ret = new HashSet<>();

		for(Student student: ss)
			ret.add(student.toDTO());
		
		return ret;
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
	
	public void removeStudentSoft(Long id) {
		Optional<Student> s = studentRepository.findById(id);
		if(s.isPresent()) {
			s.get().setDeleted(true);
			studentRepository.save(s.get());
			Optional<User> u = userService.getUser(s.get().getUser().getUsername());
			if(u.isPresent()) {
				userService.removeUserSoft(u.get().getId());
			}
		}
	}

	public void updateStudent(Long id, Student s) {
		Optional<Student> S = studentRepository.findById(id);
		if (S.isPresent()) {
			s.setId(S.get().getId());
			studentRepository.save(s);
		}
	}
	
	

	

}
