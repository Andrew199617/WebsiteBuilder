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

import neumont.csc280.WebsiteBuilder.entities.Page;
import neumont.csc280.WebsiteBuilder.entities.User;

/**
 * Servlet implementation class LoadPage
 */
@WebServlet("/*")
public class LoadPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		User user = (User)session.getAttribute("user");
		
		String pathInfo = request.getPathInfo(); // /{value}/test
		String[] pathParts = pathInfo.split("/");
		
		File welcomePage = null;
		if(pathParts.length > 0 && user != null) {
			for( Page page : user.getPages()) {
				if(page.getName().equalsIgnoreCase(pathParts[1]))
				{
					System.out.println("page found");
					switch(page.getTemplateNum()) {
					case "1":
						welcomePage = new File(DoLogin.MyPath + "/firstTemplate.html");
						break;
					case "2":
						welcomePage = new File(DoLogin.MyPath + "/secondTemplate.html");
						break;
					case "3":
						welcomePage = new File(DoLogin.MyPath + "/thirdTemplate.html");
						break;
					}
				}
			}
		}
		
		if(welcomePage != null)
		{
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
		else {
			response.setCharacterEncoding("UTF-8");
		    response.setContentType("text/plain");
			response.getWriter().write("Site Not Published");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
