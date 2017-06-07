package neumont.csc280.WebsiteBuilder.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import neumont.csc280.WebsiteBuilder.entities.Page;
import neumont.csc280.WebsiteBuilder.entities.User;

/**
 * Servlet implementation class ListPages
 */
@WebServlet("/ListPages")
public class ListPages extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		User user = (User)session.getAttribute("user");
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.getWriter().write("<div>");
		for (Page page : user.getPages())
		{
			response.getWriter().write("<div id=\"individualTemplate\">" +
        	"<a href=\"firstTemplate.html\">" + "Page Name: " + page.getName() + "<br>" + "Page Description: " + page.getDescription() + "<br>" +"<button id='deleteButton' onclick='doFunction();'>Delete</button>" + "</a></div>");
		}
		response.getWriter().write("</div>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
