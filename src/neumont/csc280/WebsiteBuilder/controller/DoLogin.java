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
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import neumont.csc280.WebsiteBuilder.entities.User;


@WebServlet("/dologin")
public class DoLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static String MyPath = "D:/Self Taught/Eclipse/WebsiteBuilder/WebContent";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = null;
		Session dbSession = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = dbSession.beginTransaction();
		try {
			String hql = "FROM users u WHERE u.username='" + username +"'";
			Query<User> query = dbSession.createQuery(hql, User.class);
			List<User> results = query.list();
			if(results.size() > 0) {
				user = results.get(0);
				dbSession.save(user);
			}
			transaction.commit();
		}
		catch(Exception ex) {
			transaction.rollback();
			ex.printStackTrace();
		}


		if(user == null || !user.getPassword().equals(password)) {
			handleInvalidLogin(request, response);
			return;
		}
		
		HttpSession session = request.getSession(true);
		session.setAttribute("user", user);
		

		File welcomePage = new File(MyPath + "/createPage.html");
		
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

		response.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html");
		response.getWriter().write(sb.toString());
	}
	
	private void handleInvalidLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("error");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
