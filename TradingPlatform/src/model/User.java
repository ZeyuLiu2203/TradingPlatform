package model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;



@Entity
@Table(name="tpuser")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NamedQueries({
	@NamedQuery(name = "user.findAll", query = "SELECT u FROM User u"),
	@NamedQuery(name = "user.findByUsername", query = "SELECT u FROM User u where u.username = :uname"),
})
public class User implements IStorable {
	
	@Id
	@Column(name="userId")
	private int id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="email")
	private String email;
	
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="lastname")
	private String lastname;
	
	private List<Trade> portfolio;

	public User() {
	}

	public int getId() {
		return id;
	}
	
	
	
	
	

	public User(int id, String username, String password, String email, String firstname, String lastname) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public User setId(int id) {
		this.id = id;
		return this;
	}

	public List<Trade> getPortfolio() {
		return portfolio;
	}


	public void addShareToPortfolio(Trade share) {
		if (this.portfolio == null)
			this.portfolio = new ArrayList<>();

		this.portfolio.add(share);
	}

	public String getUsername() {
		return username;
	}

	public User setUsername(String username) {
		if (username.length() > 0)
			this.username = username;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public User setPassword(String password) {
		if (password.length() >= 6)
			this.password = password;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public User setEmail(String email) {
		this.email = email;
		return this;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public User setLastname(String lastname) {
		this.lastname = lastname;
		return this;
	}
	
	public User setFirstname(String firstname) {
		this.firstname = firstname;
		return this;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				 + "]";
	}

}
