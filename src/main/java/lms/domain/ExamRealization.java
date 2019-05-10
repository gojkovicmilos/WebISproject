package lms.domain;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Where;

@Entity
@Where(clause = "deleted = 'false'")
public class ExamRealization {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private Boolean deleted = false;

	@Version
	private int version = 0;

	private LocalDate examDate;
	
	
	@OneToMany(mappedBy = "examRealization", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<ExamTeaching> examTeachings;

	@OneToMany(mappedBy = "examRealization", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<ExamAttending> examAttendings;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Course course;
	
	
	
	public ExamRealization() {
	}

	
	
	
	


	



	public ExamRealization(Long id, @NotNull Boolean deleted, int version, LocalDate examDate,
			Set<ExamTeaching> examTeachings, Set<ExamAttending> examAttendings, Course course) {
		this.id = id;
		this.deleted = deleted;
		this.version = version;
		this.examDate = examDate;
		this.examTeachings = examTeachings;
		this.examAttendings = examAttendings;
		this.course = course;
	}











	public Set<ExamTeaching> getExamTeachings() {
		return examTeachings;
	}





	public void setExamTeachings(Set<ExamTeaching> examTeachings) {
		this.examTeachings = examTeachings;
	}





	public Set<ExamAttending> getExamAttendings() {
		return examAttendings;
	}





	public void setExamAttendings(Set<ExamAttending> examAttendings) {
		this.examAttendings = examAttendings;
	}





	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
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


	
	public LocalDate getExamDate() {
		return examDate;
	}











	public void setExamDate(LocalDate examDate) {
		this.examDate = examDate;
	}











	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ExamRealization object = (ExamRealization) o;
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
