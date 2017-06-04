package neumont.csc280.WebsiteBuilder.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
		
		
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");

		File welcomePage = new File(DoLogin.MyPath + "/createUserSuccess.html");
		
		BufferedReader br = new BufferedReader(new FileReader(welcomePage));
	    StringBuilder sb = new StringBuilder();
		try {
		    String line = br.readLine();
		
		    while (line != null) {
		        sb.append(line);
		        sb.append("\n");
		        line = br.readLine();
		    }
		} finally {
		    br.close();
		}
		    
		response.getWriter().write(sb.toString());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		User user = new User();
//		user.setUsername(username);
//		user.setPassword(password);
//		user.setUserID(nextUserID++);
	}

}
