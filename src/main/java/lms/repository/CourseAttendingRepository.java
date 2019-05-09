package lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lms.domain.ExamAttending;

@Repository
public interface CourseAttendingRepository extends JpaRepository<ExamAttending, Long>{

	

}
