package lms.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Where;

@Entity
@Where(clause = "deleted = 'false'")
public class ExamAttending {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private Boolean deleted = false;

	@Version
	private int version = 0;

	@ManyToOne(fetch = FetchType.LAZY)
	private Student student;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private ExamRealization examRealization;
	
	private int points;
	
	
	
	public ExamAttending() {
	}

	

	

	public int getPoints() {
		return points;
	}



	public void setPoints(int points) {
		this.points = points;
	}



	public ExamRealization getExamRealization() {
		return examRealization;
	}

	public void setExamRealization(ExamRealization examRealization) {
		this.examRealization = examRealization;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ExamAttending object = (ExamAttending) o;
		if (object.id == null || id == null) {
			return false;
		}
		return Objects.equals(id, object.id);
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}

}
