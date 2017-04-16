package userServlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import userBeans.UserNotifications;

/**
 * Servlet implementation class ClearAllNotifications
 */
public class ClearAllNotifications extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClearAllNotifications() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = (request.getSession());
		String username = session.getAttribute("loggedInUser").toString();
		
		
		UserNotifications un = new UserNotifications();
		
		un.clearNotifications(username);
		
		
		ArrayList<String> notifications = new ArrayList<String>();
		session.setAttribute("notifications", notifications);
		session.setAttribute("notificationsSize", notifications.size());
		
        RequestDispatcher rd=request.getRequestDispatcher("UserProfile.jsp");    
        
        rd.forward(request,response);    
		
		
	}

}
