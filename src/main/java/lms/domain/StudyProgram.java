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
import javax.persistence.OneToOne;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Where(clause = "deleted = 'false'")
public class StudyProgram {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(max = 50)
	private String name;
	
	@NotNull
	private Boolean deleted = false;
	
	@Version
	private int version = 0;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Teacher rukovodilac;

	@ManyToOne(cascade=CascadeType.ALL)
	private Faculty faculty;
	
	@JsonIgnore()
	@ManyToOne(cascade=CascadeType.ALL)
	private Center center;
	
	/*@JsonIgnore*/
	@OneToMany(mappedBy = "studyProgram", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })	
	private Set<YearOfStudy> yearsOfStudy;
	
	private String img_url;

	
	public StudyProgram() {}
	
	


	public StudyProgram(Long id, @Size(max = 50) String name, @NotNull Boolean deleted, int version,
			Teacher rukovodilac, Faculty faculty, Set<YearOfStudy> yearsOfStudy, String img_url) {
		this.id = id;
		this.name = name;
		this.deleted = deleted;
		this.version = version;
		this.rukovodilac = rukovodilac;
		this.faculty = faculty;
		this.yearsOfStudy = yearsOfStudy;
		this.img_url = img_url;
	}




	public Teacher getRukovodilac() {
		return rukovodilac;
	}

	public void setRukovodilac(Teacher rukovodilac) {
		this.rukovodilac = rukovodilac;
	}

	public Set<YearOfStudy> getYearsOfStudy() {
		return yearsOfStudy;
	}

	public void setYearsOfStudy(Set<YearOfStudy> yearsOfStudy) {
		this.yearsOfStudy = yearsOfStudy;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	
	public String getImg_url() {
		return img_url;
	}


	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		StudyProgram object = (StudyProgram) o;
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