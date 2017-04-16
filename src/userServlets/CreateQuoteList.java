package userServlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class CreateQuoteList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CreateQuoteList() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = (request.getSession());
		String username = session.getAttribute("loggedInUser").toString();
		
		
		String SizeString = request.getParameter("size");
		int size = Integer.parseInt(SizeString);
		
		
		
		
		
		request.setAttribute("n", size);
		session.removeAttribute("quotelistSize");
		session.setAttribute("quotelistSize", size);
		
		
		
        RequestDispatcher rd=request.getRequestDispatcher("CreateNewQuoteList.jsp");    
        
        rd.forward(request,response); 
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		
	}

}
