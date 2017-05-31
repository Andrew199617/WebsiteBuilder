package neumont.csc280.WebsiteBuilder.controller;

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

    public MainView() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		User currentUser = (User) session.getAttribute("user");
		if(currentUser == null) {
			session.setAttribute("error", "You must login");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}
		request.setAttribute("user", currentUser);
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
