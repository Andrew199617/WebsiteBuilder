package neumont.csc280.WebsiteBuilder.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import neumont.csc280.WebsiteBuilder.entities.Page;
import neumont.csc280.WebsiteBuilder.entities.User;

@WebServlet("/EditPage")
public class EditPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String missionStatement;
	String history;
	String firstTemplateTitle;
	String firstTemplateDescription;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String dataNeeded = request.getParameter("dataNeeded");
		HttpSession session = request.getSession(true);
		User user = (User)session.getAttribute("user");

		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(firstTemplateTitle + ","  + firstTemplateDescription);
		switch(dataNeeded){
		case "title/description":
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		missionStatement = request.getParameter("missionStatement");
		history = request.getParameter("history");
		firstTemplateTitle = request.getParameter("firstTemplateTitle");
		firstTemplateDescription = request.getParameter("firstTemplateDescription");
		
		
		if(missionStatement != null && history != null)
		{
			AddAboutUs(request,response);
			return;
		} else if(firstTemplateTitle != "" || firstTemplateTitle != null || 
				firstTemplateDescription != "" || firstTemplateDescription != null){
			System.out.println("You made it here");
			AddFirstTemplateTitle(request, response);
			return;
		}
		
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		//response.getWriter().write("error");
	}

	private void AddAboutUs(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Session dbSession = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = dbSession.beginTransaction();
		try {
			CreatePage.page.setHistory(history);
			CreatePage.page.setMissionStatement(missionStatement);
			
			dbSession.update(CreatePage.page);

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
	
	private void AddFirstTemplateTitle(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Session dbSession = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = dbSession.beginTransaction();
		try {
			CreatePage.page.setTitle(firstTemplateTitle);
			CreatePage.page.setDescription(firstTemplateDescription);

			dbSession.update(CreatePage.page);
			
			transaction.commit();
		}
		catch(Exception e)
		{
			transaction.rollback();
			e.printStackTrace();
		}
		
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(firstTemplateTitle + ","  + firstTemplateDescription);
	}

}
