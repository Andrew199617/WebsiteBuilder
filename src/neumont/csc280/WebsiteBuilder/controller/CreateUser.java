package neumont.csc280.WebsiteBuilder.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import neumont.csc280.WebsiteBuilder.entities.User;


@WebServlet("/CreateUser")
public class CreateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int nextUserID = 1;

    public CreateUser() {
        super();
 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String retypePassword = request.getParameter("retype_password");
		if(password == null || retypePassword == null || username == null) {
			throw new IllegalArgumentException("username, password, and retype password are all required");
		}
		if(!password.equals(retypePassword)) {
			throw new IllegalArgumentException("password and retype password do not match");
		}
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setUserID(nextUserID++);
		
		request.setAttribute("user", user);
		request.getRequestDispatcher("createUserSuccess.html")
			.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
