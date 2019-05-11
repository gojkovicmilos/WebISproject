package lms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lms.domain.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	List<Student> findByFirstNameLike(String firstName);
	List<Student> findByLastName(String lastName);
	List<Student> findByCourseAttendingsCourseRealizationCourseTitle(String courseTitle);
	Optional<Student> findFirstByCardNumber(String cardNumber);
}
