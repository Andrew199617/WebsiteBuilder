package neumont.csc280.WebsiteBuilder.controller;

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
 * Servlet implementation class EditPage
 */
@WebServlet("/EditPage")
public class EditPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String missionStatement = request.getParameter("missionStatement");
		String history = request.getParameter("history");
		
		
		HttpSession session = request.getSession(true);
		User user = (User)session.getAttribute("user");
		
		Session dbSession = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = dbSession.beginTransaction();
		Page page = new Page();
		try {
			page.setName("test");
			page.setHistory(history);
			page.setMissionStatement(missionStatement);
			page.setOwner(user);
			user.getPages().add(page);
			
			dbSession.save(page);
			
			transaction.commit();
		}
		catch(Exception e)
		{
			transaction.rollback();
			e.printStackTrace();
		}
		
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(missionStatement + ","  + history);
	}

}
