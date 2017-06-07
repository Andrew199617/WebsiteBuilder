package neumont.csc280.WebsiteBuilder.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity(name="users")
public class User {

	@Id
	@Column(name="user_id", unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userID;
	
	@Column(name = "username", unique = true, nullable = false)
	private String username;

	@Column(name="pword", unique = false, nullable = false)
	private String password;

	@OneToMany(fetch = FetchType.EAGER, mappedBy="owner")
	private List<Page> pages = new ArrayList<>();

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
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
	
	public List<Page> getPages() {
		return pages;
	}

	public void setPages(List<Page> pages) {
		this.pages = pages;
	}
	
}
