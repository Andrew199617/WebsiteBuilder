package neumont.csc280.WebsiteBuilder.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="users")
public class User {
private int userID;
	
	private String username;
	
	private String password;
	
	//private List<ShoppingList> shoppingLists = new ArrayList<>();

	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	@Column(name="username", nullable=false)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name="pword", nullable=false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//	@OneToMany(mappedBy="owner")
//	public List<ShoppingList> getShoppingLists() {
//		return shoppingLists;
//	}
//
//	public void setShoppingLists(List<ShoppingList> shoppingLists) {
//		this.shoppingLists = shoppingLists;
//	}
	
}
