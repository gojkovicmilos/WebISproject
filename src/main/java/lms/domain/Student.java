package lms.domain;

import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Where;

@Entity
@Where(clause = "deleted = 'false'")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(max = 50)
	private String firstName;

	@Size(max = 50)
	private String lastName;

	@Size(max = 10)
	private String cardNumber;

	@NotNull
	private Boolean deleted = false;

	

	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<CourseAttending> courseAttendings;

	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<ExamAttending> examAttendings;

	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<StudentYear> studentYears;

	public Student() {
	}

	public Student(@Size(max = 50) String firstName, @Size(max = 50) String lastName,
			@Size(max = 10) String cardNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.cardNumber = cardNumber;
	}

	public Student(Long id, @Size(max = 50) String firstName, @Size(max = 50) String lastName,
			@Size(max = 10) String cardNumber, @NotNull Boolean deleted,
			Set<CourseAttending> courseAttendings, Set<ExamAttending> examAttendings, Set<StudentYear> studentYears) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.cardNumber = cardNumber;
		this.deleted = deleted;
		this.courseAttendings = courseAttendings;
		this.examAttendings = examAttendings;
		this.studentYears = studentYears;
	}

	public Set<ExamAttending> getExamAttendings() {
		return examAttendings;
	}

	public void setExamAttendings(Set<ExamAttending> examAttendings) {
		this.examAttendings = examAttendings;
	}

	public Set<StudentYear> getStudentYears() {
		return studentYears;
	}

	public void setStudentYears(Set<StudentYear> studentYears) {
		this.studentYears = studentYears;
	}

	public Set<CourseAttending> getCourseAttendings() {
		return courseAttendings;
	}

	public void setCourseAttendings(Set<CourseAttending> courseAttendings) {
		this.courseAttendings = courseAttendings;
	}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
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
		Student object = (Student) o;
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
