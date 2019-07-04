package lms.service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DTO.AdministratorDTO;
import DTO.CourseDTO;
import lms.domain.Administrator;
import lms.domain.Course;
import lms.domain.CourseAttending;
import lms.domain.Student;
import lms.domain.StudentYear;
import lms.domain.StudyProgram;
import lms.domain.YearOfStudy;
import lms.repository.AdministratorRepository;
import lms.repository.CourseRepository;
import lms.repository.StudentYearRepository;
import lms.repository.YearOfStudyRepository;

@Service
public class AdministratorService {

	@Autowired
	AdministratorRepository administratorRepository;
	
	@Autowired
	StudentYearRepository studentYearRepository;
	
	@Autowired
	CourseRepository courseRepository;


	@Autowired
	YearOfStudyRepository yearOfStudyRepository;
	
	public AdministratorService() {}

	public Iterable<AdministratorDTO> getAllAdmin() {
		
		Iterable<Administrator> as = administratorRepository.findAll();
		Set<AdministratorDTO> ret = new HashSet<>();

		for(Administrator a: as)
			ret.add(a.toDTO());
		
		return ret;
	}

	public void addAdministrator(Administrator a) {
		administratorRepository.save(a);
	}

	public void addCourse(Course c) {
		courseRepository.save(c);
	}

	public Optional<Course> getCourseId(Long id) {
		return courseRepository.findById(id);
	}

	public Optional<Administrator> getAdminId(Long id) {
		return administratorRepository.findById(id);
	}

	public void removeAdministrator(Long id) {
		Optional<Administrator> a = administratorRepository.findById(id);
		administratorRepository.delete(a.get());
	}

	public void updateAdministrator(Long id, Administrator a) {
		Optional<Administrator> add = administratorRepository.findById(id);
		if (add.isPresent()) {
			a.setId(add.get().getId());
			administratorRepository.save(a);
		}
	}


	public void updateCourse(Long id, Course c) {
		Optional<Course> add = courseRepository.findById(id);
		if (add.isPresent()) {
			c.setId(add.get().getId());
			courseRepository.save(c);
		}
	}


	public Iterable<CourseDTO> getAllCourse() {
		Iterable<Course> c = courseRepository.findAll();
		Set<CourseDTO> cd = new HashSet<>();
		for(Course ct: c)
			cd.add(ct.toDTO());
		return cd;
	}
	
	public Iterable<Student>getAllStudentsWhoPass(StudyProgram studyProgram, int yearNumber)
	{
		
		YearOfStudy yearOfStudy = null;
		
		int pointsNeeded = 38;
		
		for(YearOfStudy yos: studyProgram.getYearsOfStudy())
			if(yos.getNumberOfYear() == yearNumber)
			{
				yearOfStudy = yos;
			}
		
		
		Set<Student> ret = new HashSet<Student>();
		
		Set<Student> allStudentsOnYear = new HashSet<Student>();
		
		
		for(StudentYear sy: yearOfStudy.getStudentYears())
		{
			allStudentsOnYear.add(sy.getStudent());
		}
		
		for(Student s: allStudentsOnYear)
		{
			int points = 0;
			
			for(CourseAttending ca: s.getCourseAttendings())
			{
				points+=ca.getCourseRealization().getCourse().getEcts();
			}
			
			if(points>=pointsNeeded)
			{
				ret.add(s);
			}
		}
		
		
		return ret;
	}
	
	public boolean enrollStudentInNextYear(Student student, Set<Course>facultativeCourses)
	{
		
		
		boolean isIn = false;
		
		int currentYear = 0;
		
		StudyProgram studyProgram = null;
		
		for(StudentYear sy: student.getStudentYears())
		{
			currentYear++;
			studyProgram = sy.getYearOfStudy().getStudyProgram();
		}
		
		for(Student s: this.getAllStudentsWhoPass(studyProgram, currentYear))
			if(s == student)
				isIn = true;
			
		if(!isIn)
			return false;
		
		
		
		YearOfStudy nextYOS = null;
		
		
		for(YearOfStudy yos: yearOfStudyRepository.findAll())
		{
			if(yos.getStudyProgram() == studyProgram && yos.getNumberOfYear() == currentYear+1)
				nextYOS = yos;
		}
		
		for(Course c: facultativeCourses)
			if(c.isObligatory())
				return false;
		
	
			Set<Course> newSet = nextYOS.getCourses();
			
			newSet.addAll(facultativeCourses);
			
			nextYOS.setCourses(newSet);
		
		StudentYear nextYear = new StudentYear(LocalDate.now(), nextYOS, student);
		
		Set<StudentYear> newYears = student.getStudentYears();
		
		newYears.add(nextYear);
		
		student.setStudentYears(newYears);
		
		
		
		
		
		
		
		return true;
	}

}
