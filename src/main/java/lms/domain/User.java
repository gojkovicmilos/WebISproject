package lms.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String username;

	private String password;
	
	private String role;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<UserPermission> userPermissions;

	public User() {
		
	}

	public User(Long id, String username, String password, Set<UserPermission> userPermissions, String role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.userPermissions = userPermissions;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<UserPermission> getUserPermissions() {
		return userPermissions;
	}

	public void setUserPermissions(Set<UserPermission> userPermissions) {
		this.userPermissions = userPermissions;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
		
}
