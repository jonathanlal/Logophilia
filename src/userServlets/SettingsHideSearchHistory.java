package userServlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import userBeans.UserSettings;

/**
 * Servlet implementation class SettingsHideSearchHistory
 */
public class SettingsHideSearchHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SettingsHideSearchHistory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		UserSettings us = new UserSettings();
		HttpSession session = (request.getSession());
		
		String username;
   	 if(null == session.getAttribute("fbAccount")){  
   		 
   		 username = session.getAttribute("loggedInUser").toString();
   	 
   	 }else{
			username = session.getAttribute("fbAccount").toString();

   		 
   	 }
		

		String status = request.getParameter("tabsearch");
		
		
		if(status == null){
			
			us.setHideSearch("", username);
			
			session.removeAttribute("hideSearchSetting");
			session.setAttribute("hideSearch", "");

		}
		
		else if(status.contains("on")){
			
			us.setHideSearch("checked", username);

			session.setAttribute("hideSearchSetting", "display: none;");
			session.setAttribute("hideSearch", "checked");

			
		}

		
        RequestDispatcher rd=request.getRequestDispatcher("Settings.jsp");    
        
        rd.forward(request,response);    
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
