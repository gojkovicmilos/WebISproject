package lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lms.domain.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	List<Student> findByFirstNameLike(String firstName);
	List<Student> findByCourseAttendingsCourseRealizationCourseTitle(String courseTitle);
	Student findFirstByCardNumber(String cardNumber);
}
