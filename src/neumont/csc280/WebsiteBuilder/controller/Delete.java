package neumont.csc280.WebsiteBuilder.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageName = request.getParameter("pageName");
		
		Session dbSession = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = dbSession.beginTransaction();
		try 
		{
			String itemsDelete = "delete from pages where name = \'" + pageName + "\'";
			dbSession.createQuery(itemsDelete).executeUpdate();
		    
			transaction.commit();
		} 
		catch(Exception e)
		{
			transaction.rollback();
			e.printStackTrace();
		}

	}

}
