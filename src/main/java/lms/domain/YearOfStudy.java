package lms.domain;

import java.util.Objects;
import java.util.Set;

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
public class YearOfStudy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private Boolean deleted = false;

	@Version
	private int version = 0;

	private int numberOfYear;
	
	@OneToMany(mappedBy = "yearOfStudy", fetch = FetchType.LAZY)
	private Set<Course> courses;

	@OneToMany(mappedBy = "yearOfStudy", fetch = FetchType.LAZY)
	private Set<StudentYear> studentYears;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private StudyProgram studyProgram;
	
	
	
	public YearOfStudy() {
	}
	
	


	



	public YearOfStudy(Long id, @NotNull Boolean deleted, int version, int numberOfYear, Set<Course> courses,
			Set<StudentYear> studentYears, StudyProgram studyProgram) {
		this.id = id;
		this.deleted = deleted;
		this.version = version;
		this.numberOfYear = numberOfYear;
		this.courses = courses;
		this.studentYears = studentYears;
		this.studyProgram = studyProgram;
	}








	public StudyProgram getStudyProgram() {
		return studyProgram;
	}








	public void setStudyProgram(StudyProgram studyProgram) {
		this.studyProgram = studyProgram;
	}








	public Set<StudentYear> getStudentYears() {
		return studentYears;
	}

	public void setStudentYears(Set<StudentYear> studentYears) {
		this.studentYears = studentYears;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
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

	public int getNumberOfYear() {
		return numberOfYear;
	}

	public void setNumberOfYear(int numberOfYear) {
		this.numberOfYear = numberOfYear;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		YearOfStudy object = (YearOfStudy) o;
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