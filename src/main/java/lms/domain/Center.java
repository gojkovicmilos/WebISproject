package lms.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Where;
// p
@Entity
@Where(clause = "deleted = 'false'")
public class Center {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Date yearOfEstablishment;
	
	@NotNull
	private Boolean deleted = false;
	
	@Version
	private int version = 0;
	
	@OneToOne(fetch = FetchType.LAZY)
	private University university;
	
	@OneToMany(mappedBy = "center", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })	
	private Set<Faculty> faculties;
	
	public Center() {
		
	}

	public Center(Long id, Date yearOfEstablishment, @NotNull Boolean deleted, int version, University university,
			Set<Faculty> faculties) {
		super();
		this.id = id;
		this.yearOfEstablishment = yearOfEstablishment;
		this.deleted = deleted;
		this.version = version;
		this.university = university;
		this.faculties = faculties;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getYearOfEstablishment() {
		return yearOfEstablishment;
	}

	public void setYearOfEstablishment(Date yearOfEstablishment) {
		this.yearOfEstablishment = yearOfEstablishment;
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

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	public Set<Faculty> getFaculties() {
		return faculties;
	}

	public void setFaculties(Set<Faculty> faculties) {
		this.faculties = faculties;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
	
	
	
}
