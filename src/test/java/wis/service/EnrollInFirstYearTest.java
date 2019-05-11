package wis.service;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import lms.domain.Student;
import lms.service.StudentService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class EnrollInFirstYearTest {

	@Autowired
	StudentService studentService;
	
	@Test
	@Transactional
	@Rollback(true)
	public void test() {
		Optional<Student> student = studentService.getByCardNumber("123");
		studentService.enrollInFirstYear(student.get());
		Optional<Student> student1 = studentService.getByCardNumber("123");
		assertEquals(1, student1.get().getStudentYears().iterator().next().getYearOfStudy().getNumberOfYear());
	}
}
