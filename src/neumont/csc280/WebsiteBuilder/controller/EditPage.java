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

@WebServlet("/EditPage")
public class EditPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String missionStatement;
	String history;
	String firstTemplateTitle;
	String firstTemplateDescription;
	Page page = null;
	boolean pageCreated = false;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
		}else if(firstTemplateTitle != "" || firstTemplateTitle != null || 
				firstTemplateDescription != "" || firstTemplateDescription != null){
			System.out.println("You made it here");
			AddFirstTemplateTitle(request, response);
			return;
		}else{
			System.out.print("Testing");
		}
		
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		//response.getWriter().write("error");
	}

	private void AddAboutUs(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession(true);
		User user = (User)session.getAttribute("user");
		
		Session dbSession = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = dbSession.beginTransaction();
		if(page == null){
			page = new Page();
			page.setOwner(user);
			user.getPages().add(page);
		}
		try {
			page.setHistory(history);
			page.setMissionStatement(missionStatement);
			
			if(pageCreated){
				dbSession.update(page);
			} else {
				dbSession.save(page);
				pageCreated = true;
			}
			
			
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
		HttpSession session = request.getSession(true);
		User user = (User)session.getAttribute("user");
		
		Session dbSession = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = dbSession.beginTransaction();
		if(page == null){
			page = new Page();
			page.setOwner(user);
			user.getPages().add(page);
		}
		try {
			page.setTitle(firstTemplateTitle);
			page.setDescription(firstTemplateDescription);
			
			if(pageCreated){
				dbSession.update(page);
			} else {
				dbSession.save(page);
				pageCreated = true;
			}
			
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
