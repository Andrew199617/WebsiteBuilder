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
	String title;
	String description;
	String address;
	String firstSuccessStory;
	String firstSuccessDescription;
	String secondSuccessStory;
	String secondSuccessDescription;
	String JobTitle;
	String JobDescription;
	String FAQQuestion;
	String FAQAnswer;
	String profileName;
	String email;
	String bio;
	Page page = null;
	boolean pageCreated = false;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		missionStatement = request.getParameter("missionStatement");
		history = request.getParameter("history");
		title = request.getParameter("title");
		description = request.getParameter("description");
		address = request.getParameter("address");
		JobTitle = request.getParameter("JobTitle");
		FAQQuestion = request.getParameter("FAQQuestion");
		FAQAnswer = request.getParameter("FAQAnswer");
		profileName = request.getParameter("profileName");
		bio = request.getParameter("bio");
		email = request.getParameter("email");
		
		if(missionStatement != null && history != null)
		{
			AddAboutUs(request,response);
			return;
		}else if(title != null && description != null){
			AddFirstTemplateTitle(request, response);
			return;
		}else if(address != null){
			AddAddress(request, response);
			return;
		}else if(firstSuccessStory != null && firstSuccessDescription != null){
			AddSuccessStory(request, response);
			return;
		}else if(JobTitle != null && JobDescription != null){
			AddJob(request, response);
			return;
		}else if(FAQQuestion != null && FAQAnswer != null){
			AddFAQ(request, response);
			return;
		}else if(profileName != null && bio != null && bio != email){
			AddProfile(request, response);
			return;
		}
		else{
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
			page.setTitle(title);
			page.setDescription(description);
			
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
		response.getWriter().write(title + ","  + description);
	}
	
	private void AddAddress(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
			page.setAddress(address);
			
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
		response.getWriter().write(address);
	}
	
	private void AddSuccessStory(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
			page.setSuccessStory(firstSuccessStory);
			page.setSuccessDescription(firstSuccessDescription);
			
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
		response.getWriter().write(firstSuccessStory + ","  +firstSuccessDescription);
	}
	private void AddJob(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
			page.setJobTitle(JobTitle);
			page.setJobDescription(JobDescription);
			
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
		response.getWriter().write(JobTitle + "," + JobDescription);
	}
	
	private void AddFAQ(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
			page.setFAQQuestion(FAQQuestion);
			page.setFAQAnswer(FAQAnswer);
			
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
		response.getWriter().write(FAQQuestion + "," + FAQAnswer);
	}
	private void AddProfile(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
			page.setProfileName(profileName);
			page.setBio(bio);
			page.setEmail(email);
			
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
		response.getWriter().write(profileName + "," + email + "," + bio);
	}


}
