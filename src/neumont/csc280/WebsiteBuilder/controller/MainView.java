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

import neumont.csc280.WebsiteBuilder.entities.User;


@WebServlet("/MainView")
public class MainView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		File welcomePage = new File(DoLogin.MyPath + "index.html");
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
