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
	
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String dataNeeded = request.getParameter("dataNeeded");

		switch(dataNeeded){
		case "title/description":
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(CreatePage.page.getTitle() + ","  + CreatePage.page.getDescription());
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		missionStatement = request.getParameter("missionStatement");
		history = request.getParameter("history");
		
		title = request.getParameter("title");
		description = request.getParameter("description");
		
		address = request.getParameter("address");
		
		firstSuccessStory = request.getParameter("firstSuccessStory");
		firstSuccessDescription = request.getParameter("firstSuccessDescription");
		
		JobTitle = request.getParameter("jobTitle");
		JobDescription = request.getParameter("jobDescription");
		
		FAQQuestion = request.getParameter("FAQQuestion");
		FAQAnswer = request.getParameter("FAQAnswer");
		
		profileName = request.getParameter("profileName");
		bio = request.getParameter("bio");
		email = request.getParameter("email");
		
		
		if(missionStatement != null && history != null) {
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
			
			CreatePage.page.setTitle(title);
			CreatePage.page.setDescription(description);

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
		response.getWriter().write(title + ","  + description);
	}
	
	private void AddAddress(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Session dbSession = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = dbSession.beginTransaction();
		try {
			CreatePage.page.setAddress(address);
			
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
		response.getWriter().write(address);
	}
	
	private void AddSuccessStory(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Session dbSession = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = dbSession.beginTransaction();
		try {
			CreatePage.page.setSuccessStory(firstSuccessStory);
			CreatePage.page.setSuccessDescription(firstSuccessDescription);
			
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
		response.getWriter().write(firstSuccessStory + ","  +firstSuccessDescription);
	}
	
	private void AddJob(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Session dbSession = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = dbSession.beginTransaction();
		try {
			CreatePage.page.setJobTitle(JobTitle);
			CreatePage.page.setJobDescription(JobDescription);
			
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
		response.getWriter().write(JobTitle + "," + JobDescription);
	}
	
	private void AddFAQ(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Session dbSession = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = dbSession.beginTransaction();
		try {
			CreatePage.page.setFAQQuestion(FAQQuestion);
			CreatePage.page.setFAQAnswer(FAQAnswer);
			
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
		response.getWriter().write(FAQQuestion + "," + FAQAnswer);
	}
	private void AddProfile(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Session dbSession = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = dbSession.beginTransaction();
		try {
			CreatePage.page.setProfileName(profileName);
			CreatePage.page.setBio(bio);
			CreatePage.page.setEmail(email);
			
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
		response.getWriter().write(profileName + "," + email + "," + bio);
	}


}
