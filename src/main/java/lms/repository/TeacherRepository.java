package lms.repository;

import java.sql.Statement;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lms.domain.Student;
import lms.domain.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long>, TeacherRepositoryCustom {

	public List<Teacher> findTeacherByFirstName(String firstName);

	Optional<Teacher> findByPersonalIdentificationNumber(String personalIdentificationNumber);

	List<Student> findByFirstNameOrLastNameLikeIgnoreCase(String name, String name1);
	List<Student> findByLastNameLikeIgnoreCase(String lastName);
	List<Student> findByFirstNameLikeIgnoreCase(String firstName);

	List<Student> findByCourseAttendingsCourseRealizationCourseTitle(String courseTitle);
	List<Student> findFirstByCardNumber(String cardNumber);
}
