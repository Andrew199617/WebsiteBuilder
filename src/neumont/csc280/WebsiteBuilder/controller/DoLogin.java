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

import neumont.csc280.WebsiteBuilder.entities.User;


@WebServlet("/dologin")
public class DoLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DoLogin() {
        super();
     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//JDBCEngine jdbc = Master.getJDBCEngine();
		//User user = jdbc.findUser(username);
		User user = null;
		Session dbSession = Master.getSessionFactory().getCurrentSession();
		Transaction transaction = dbSession.beginTransaction();
		try {
			String hql = "FROM users u WHERE u.username='" + username +"'";
			Query<User> query = dbSession.createQuery(hql, User.class);
			List<User> results = query.list();
			if(results.size() > 0) {
				user = results.get(0);
//				user.setLastLoggedin(System.currentTimeMillis());
				dbSession.save(user);
			}
			if(user == null || !user.getPassword().equals(password)) {
				handleInvalidLogin(request, response);
				return;
			}
			HttpSession session = request.getSession(true);
			session.setAttribute("user", user);
			request.getRequestDispatcher("main.html").include(request, response);
			transaction.commit();
		}
		catch(Exception ex) {
			transaction.rollback();
			throw new RuntimeException(ex);
		}
	}
	
	private void handleInvalidLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("error", "Invalid username or password");
		request.getRequestDispatcher("index.jsp")
			.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
