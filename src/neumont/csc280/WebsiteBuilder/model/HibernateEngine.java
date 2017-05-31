package neumont.csc280.WebsiteBuilder.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import neumont.csc280.WebsiteBuilder.entities.User;

public class HibernateEngine {
private Connection connection;
	
	public void connect() throws ClassNotFoundException, SQLException {
		if(connection == null) {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping_lists", "shopping", "testtesttest9");
		}
	}
	
	public void disconnect() throws SQLException {
		if(connection != null) {
			connection.close();
			connection = null;
		}
	}
	
	public void createUser(User user) {
		String sql = "Insert into users (username, pword) " +
				"values ('" + user.getUsername() + "', '" + user.getPassword() + "')";
		try {
			Statement stmt = connection.createStatement();
			user.setUserID(stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public User loadUser(int userID) throws SQLException {
		String sql = "select user_id, username, pword " +
					"from users " +
					"where user_id = " + userID;
		Statement stmt = connection.createStatement();
		ResultSet results = stmt.executeQuery(sql);
		User u = new User();
		if(!results.next()) {
			throw new IllegalArgumentException("No user with user id" + userID);
		}
		u.setUserID(userID);
		u.setUsername(results.getString("username"));
		u.setPassword(results.getString("pword"));
		results.close();
		//loadShoppingListsForUser(u);
		return u;
	}
	
	public User findUser(String username) {
		String sql = "select user_id, username, pword " +
				"from users " +
				"where username = '" + username + "'";
		User u = new User();
		try {
			Statement stmt = connection.createStatement();
			ResultSet results = stmt.executeQuery(sql);
			if(!results.next()) {
				return null;
			}
			u.setUserID(results.getInt("user_id"));
			u.setUsername(results.getString("username"));
			u.setPassword(results.getString("pword"));
			results.close();
		}
		catch(Exception ex) {
			throw new RuntimeException(ex);
		}
		//loadShoppingListsForUser(u);
		return u;
	}
	
//	public void loadShoppingListsForUser(User user) {
//		String sql =
//				"select list_id, name, user_id " +
//				"from shopping_lists.lists " +
//				"where user_id = " + user.getUserID();
//		try {
//			Statement stmt = connection.createStatement();
//			ResultSet results = stmt.executeQuery(sql);
//			while(results.next()) {
//				ShoppingList list = new ShoppingList();
//				list.setListID(results.getInt("list_id"));
//				list.setName(results.getString("name"));
//				list.setOwner(user);
//				user.getShoppingLists().add(list);
//			}
//			results.close();
//		}
//		catch(Exception ex) {
//			throw new RuntimeException(ex);
//		}
//	}
//	
//	public void createShoppingList(ShoppingList list) {
//		String sql = "Insert into lists (name, user_id) " +
//				"values ('" + list.getName() + "', '" + list.getOwner().getUserID() + "')";
//		try {
//			Statement stmt = connection.createStatement();
//			list.setListID(stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS));
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
//	}
//	
//	public ShoppingList loadShoppingList(int listID) throws SQLException {
//		String sql = "select list_id, name, owner_id " +
//					"from lists " +
//					"where list_id = " + listID;
//		Statement stmt = connection.createStatement();
//		ResultSet results = stmt.executeQuery(sql);
//		ShoppingList list = new ShoppingList();
//		if(!results.next()) {
//			throw new IllegalArgumentException("No list with list id" + listID);
//		}
//		list.setListID(results.getInt("list_id"));
//		list.setName(results.getString("name"));
//		//TODO Owner id?
//		results.close();
//		return list;
//	}
}
