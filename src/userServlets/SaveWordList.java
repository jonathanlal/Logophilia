package userServlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import userBeans.SavedLists;
import userBeans.SavedWords;


public class SaveWordList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SaveWordList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = (request.getSession());
        String username = session.getAttribute("loggedInUser").toString();


		String id = request.getParameter("id");
		String type = request.getParameter("type");

		SavedLists sl = new SavedLists();
   
		sl.saveList(id, username, type);

				
				
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
				
		
        RequestDispatcher rd=request.getRequestDispatcher("List.jsp");    
        
        rd.forward(request,response); 
				
				
				
	}

}
