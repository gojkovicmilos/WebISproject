package lms.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Where;

@Entity
@Where(clause = "deleted = 'false'")
public class ExamTeaching {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private Boolean deleted = false;

	@Version
	private int version = 0;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Teacher teacher;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private ExamRealization examRealization;
	
	
	

	public ExamTeaching() {
	}

	public ExamTeaching(Long id, @NotNull Boolean deleted, int version, Teacher teacher,
			ExamRealization examRealization) {
		this.id = id;
		this.deleted = deleted;
		this.version = version;
		this.teacher = teacher;
		this.examRealization = examRealization;
	}
	
	

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public ExamRealization getExamRealization() {
		return examRealization;
	}

	public void setExamRealization(ExamRealization examRealization) {
		this.examRealization = examRealization;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
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


	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ExamTeaching object = (ExamTeaching) o;
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
