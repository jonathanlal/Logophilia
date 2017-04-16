package userServlets;

import java.io.File;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import userBeans.UserBean;

/**
 * Servlet implementation class UserSaveProfileDescription
 */
//@WebServlet("/UserSaveProfileDescription")
public class UserSaveProfileDescription extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String title = "";
	String body = "";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserSaveProfileDescription() {
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

		//doGet();
		title = request.getParameter("Ptitle");
		body = request.getParameter("Pbody");
        String username = session.getAttribute("loggedInUser").toString();

        String usertitleresults = "";
		String userbodyresults = "";
			
			
			
			UserBean ub = new UserBean();
			UserBean ub2 = new UserBean();


			
			ub.setProfileInfo(title, body, username);
			
			
			usertitleresults = ub.getProfileInfoTitle(username);

			userbodyresults = ub2.getProfileInfoBody(username);
			
			
		
        	session.setAttribute("usertitleresults", usertitleresults);
        	
        	session.setAttribute("userbodyresults", userbodyresults);


	RequestDispatcher rd = request.getRequestDispatcher("UserProfile.jsp");
		rd.forward(request, response);
//	}
		
		
		
		
		
		
		
		
		
		
		
	}
	}


