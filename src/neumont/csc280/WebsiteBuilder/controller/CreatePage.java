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
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import neumont.csc280.WebsiteBuilder.entities.Page;
import neumont.csc280.WebsiteBuilder.entities.User;

/**
 * Servlet implementation class CreatePage
 */
@WebServlet("/CreatePage")
public class CreatePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public static Page page = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageName = request.getParameter("websiteName");
		
		String templateNum = request.getParameter("templateNum");
		
		HttpSession session = request.getSession(true);
		User user = (User)session.getAttribute("user");
		if(page == null) {
			page = new Page();
			Session dbSession = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction transaction = dbSession.beginTransaction();
			try {
			
				page.setName(pageName);
				page.setOwner(user);
				
				dbSession.save(page);
				
				transaction.commit();
			}
			catch(Exception ex) {
				transaction.rollback();
				ex.printStackTrace();
			}
			session.setAttribute("page", page);
		
		}
		
		
		
		File welcomePage = new File(DoLogin.MyPath + "/WelcomePage.html");
		
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

}
