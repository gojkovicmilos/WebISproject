package lms.domain;

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
import javax.validation.constraints.Size;

import org.hibernate.annotations.Where;

@Entity
@Where(clause = "deleted = 'false'")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private Boolean deleted = false;

	@Size(max = 50)
	private String title;
	
	private int ects;
	
	private boolean obligatory;
	
	private int numberOfLectures;

	private int numberOfExcercises;
	
	@Version
	private int version = 0;
	
	private String img_url;
	
	private String link;
	
	
	@OneToMany(mappedBy = "course", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<CourseRealization> courseRealizations;
	
	@OneToMany(mappedBy = "course", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<ExamRealization> ExamRealizations;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private YearOfStudy yearOfStudy;
	
	
	
	
	public Course() {
	}

	

	public Course(Long id, @NotNull Boolean deleted, @Size(max = 50) String title, int ects, boolean obligatory,
			int numberOfLectures, int numberOfExcercises, int version, Set<CourseRealization> courseRealizations,
			Set<ExamRealization> examRealizations, YearOfStudy yearOfStudy,String img_url, String link) {
		this.id = id;
		this.deleted = deleted;
		this.title = title;
		this.ects = ects;
		this.obligatory = obligatory;
		this.numberOfLectures = numberOfLectures;
		this.numberOfExcercises = numberOfExcercises;
		this.version = version;
		this.courseRealizations = courseRealizations;
		ExamRealizations = examRealizations;
		this.yearOfStudy = yearOfStudy;
		this.img_url = img_url;
		this.link = link;
	}



	public Set<ExamRealization> getExamRealizations() {
		return ExamRealizations;
	}



	public void setExamRealizations(Set<ExamRealization> examRealizations) {
		ExamRealizations = examRealizations;
	}



	public YearOfStudy getYearOfStudy() {
		return yearOfStudy;
	}

	public void setYearOfStudy(YearOfStudy yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
	}

	public Set<CourseRealization> getCourseRealizations() {
		return courseRealizations;
	}

	public void setCourseRealizations(Set<CourseRealization> courseRealizations) {
		this.courseRealizations = courseRealizations;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getEcts() {
		return ects;
	}

	public void setEcts(int ects) {
		this.ects = ects;
	}

	public boolean isObligatory() {
		return obligatory;
	}

	public void setObligatory(boolean obligatory) {
		this.obligatory = obligatory;
	}

	public int getNumberOfLectures() {
		return numberOfLectures;
	}

	public void setNumberOfLectures(int numberOfLectures) {
		this.numberOfLectures = numberOfLectures;
	}

	public int getNumberOfExcercises() {
		return numberOfExcercises;
	}

	public void setNumberOfExcercises(int numberOfExcercises) {
		this.numberOfExcercises = numberOfExcercises;
	}
	
	

	public String getImg_url() {
		return img_url;
	}



	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	
	
	public String getLink() {
		return link;
	}



	public void setLink(String link) {
		this.link = link;
	}



	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Course object = (Course) o;
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
