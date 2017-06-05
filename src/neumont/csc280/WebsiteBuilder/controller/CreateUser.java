package neumont.csc280.WebsiteBuilder.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import neumont.csc280.WebsiteBuilder.entities.User;


@WebServlet("/CreateUser")
public class CreateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String retypePassword = request.getParameter("retype_password");
		
		if(password == "" || retypePassword == "" || username == "") {
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write("error");
			return;
		}
		if(!password.equals(retypePassword)) {
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write("error");
			return;
		}

		Session dbSession = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = dbSession.beginTransaction();
		try {

			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			dbSession.save(user);
			transaction.commit();
		}
		catch(Exception ex) {
			transaction.rollback();
			ex.printStackTrace();
		}
		

		File successPage = new File(DoLogin.MyPath + "/createUserSuccess.html");
		
		BufferedReader br = new BufferedReader(new FileReader(successPage));
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

	    response.setContentType("text/html");
		response.getWriter().write(sb.toString());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
