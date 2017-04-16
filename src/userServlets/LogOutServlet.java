package userServlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import userBeans.WordLists;

/**
 * Servlet implementation class UserControlServlet
 */
//@WebServlet("/logout")
public class LogOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogOutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = (request.getSession());
		
//		String logout = request.getParameter("Logout");    
//		String UserSelectionTodaysWord = request.getParameter("button1");
//		String UserSelectionViewT = request.getParameter("ViewT");
//		String UserSelectionViewL = request.getParameter("ViewL");
//		String user = session.getAttribute("loggedInUser").toString();
//		String charts = request.getParameter("leaderboard");
		
//		if(logout != null){
			try{
			response.reset();
			
//			request.logout();
		    session.invalidate();
			
		  
			}finally{
				   RequestDispatcher rd=request.getRequestDispatcher("index.jsp");    
		            
		             rd.forward(request,response);  
				
			}	
//		}
//		if(charts != null){
//			
//			
//			LeaderBoard lb = new LeaderBoard();
//			
//			ArrayList<String> leaderboard = lb.getLeaderBoard();
//			
//			request.setAttribute("scores", leaderboard);
//			
//			
//			RequestDispatcher rd = request.getRequestDispatcher("Leaderboard.jsp");
//			rd.forward(request, response);
//			
//			
//			
//			
//		}
		
		
		
		
		
//		if(UserSelectionTodaysWord.contains("My Lists")){
//			
//
//			
//			
//WordLists ul = new WordLists();
//			
//
//			String results = ul.userfilesfromuserfile(user);
//			String results2 = results.substring(1, results.length()-1);
//			
//			
//			
//			
//			
//
//			request.setAttribute("Listresults", results2);
//			
//			
//			
//			
//			
//			
//			
//			
//			
//			
//			
//			
//			
//			
//			
//		    RequestDispatcher rd=request.getRequestDispatcher("/WordListsTable.jsp");    
//	            
//             rd.forward(request,response);  
//
//			
//		}
//
//		
//		
//		else{
//			
//			   RequestDispatcher rd=request.getRequestDispatcher("index.jsp");    
//	            
//	             rd.forward(request,response);  	
//			
//		}
//		
//		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		
		
		
		
		
	}

}
