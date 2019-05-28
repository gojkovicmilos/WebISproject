package lms.domain;

import java.io.IOException;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Where;
import org.springframework.web.multipart.MultipartFile;

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

	@ManyToOne(cascade = CascadeType.ALL)
	private University university;

	@OneToMany(mappedBy = "center", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<Faculty> faculties;

	@OneToMany(mappedBy = "center", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<StudyProgram> studyPrograms;

	private String name;

	private String pic_name;

	private String mimetype;

	@Lob
	private byte[] pic;

	public Center() {

	}

	public Center(Long id, Date yearOfEstablishment, @NotNull Boolean deleted, int version, University university,
			Set<Faculty> faculties, Set<StudyProgram> studyPrograms, String name, String pic_name, String mimetype,
			byte[] pic) {
		super();
		this.id = id;
		this.yearOfEstablishment = yearOfEstablishment;
		this.deleted = deleted;
		this.version = version;
		this.university = university;
		this.faculties = faculties;
		this.studyPrograms = studyPrograms;
		this.name = name;
		this.pic_name = pic_name;
		this.mimetype = mimetype;
		this.pic = pic;
	}

	public Center(MultipartFile file) {
		// TODO Auto-generated constructor stub
		this.pic_name = file.getName();
		this.mimetype = file.getContentType();
		try {
			this.pic = file.getBytes();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	public Set<StudyProgram> getStudyPrograms() {
		return studyPrograms;
	}

	public void setStudyPrograms(Set<StudyProgram> studyPrograms) {
		this.studyPrograms = studyPrograms;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPic_name() {
		return pic_name;
	}

	public void setPic_name(String pic_name) {
		this.pic_name = pic_name;
	}

	public String getMimetype() {
		return mimetype;
	}

	public void setMimetype(String mimetype) {
		this.mimetype = mimetype;
	}

	public byte[] getPic() {
		return pic;
	}

	public void setPic(byte[] pic) {
		this.pic = pic;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Center object = (Center) o;
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
