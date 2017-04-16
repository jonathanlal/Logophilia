package userServlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import userBeans.QuoteLists;
import userBeans.WordLists;


public class OpenQuoteListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public OpenQuoteListServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = (request.getSession());
		String username = session.getAttribute("loggedInUser").toString();
		
		
		String listIDString = request.getParameter("id");
        int listID = Integer.parseInt(listIDString);
		
		
		QuoteLists ql = new QuoteLists();
		ArrayList<String> likesUsers;
		int likesSize;
		ArrayList<String> list = ql.getAllFromList(listID);	
		
		String name = list.get(0);
		String description = list.get(1);
		String size = list.get(2);
		String likesString = list.get(3);
		
		if(likesString != null){
	 		likesUsers = new ArrayList<String>(Arrays.asList(likesString.split(",")));
	 		likesSize = likesUsers.size();
			}else{
			likesUsers = new ArrayList<String>();
			likesSize = 0;
			}

			String creator = list.get(4);		
			String quotesString = list.get(5); // remove spaces from string of words
			ArrayList<String> quotes = new ArrayList<String>(Arrays.asList(quotesString.split(" !X! ")));
		
			String authorsString = list.get(6);
			ArrayList<String> authors = new ArrayList<String>(Arrays.asList(authorsString.split(",")));

			String date = list.get(7);
	    	String listdate = date.substring(0, 11);
	    	String listtime = date.substring(12,20);
			
			String image = list.get(8);	

			String comments = list.get(9);
			ArrayList<String> commentsArray = new ArrayList<String>();
			if(comments != null){
			commentsArray = new ArrayList<String>(Arrays.asList(comments.split(" !X ")));
			commentsArray.remove(0);
			}
			  request.setAttribute("commentsArray", commentsArray);
			  request.setAttribute("commentsArraySize", commentsArray.size());
		
		
			  
		        ArrayList<ArrayList<String>> listinfo = ql.getListInfoProfile(username);    
		        
		        ArrayList<String> listids = listinfo.get(0);
		        ArrayList<String> listnames = listinfo.get(1);
		   
		        listids.remove(listIDString);
		        listnames.remove(name);
				  
				request.setAttribute("addtolistIds", listids);
				request.setAttribute("addtolistNames", listnames);
		
		
				// for likes getParameters
				request.setAttribute("typelist", "w");
				request.setAttribute("idlist", listID);
				request.setAttribute("listname", name);
		        request.setAttribute("listdate", listdate);
		        request.setAttribute("listtime", listtime);
		        request.setAttribute("listcreator", creator);
		        
		        request.setAttribute("quotesfromDB", quotes);
		        request.setAttribute("authorsfromDB", authors);       
		        
		        request.setAttribute("description", description);
		        request.setAttribute("listsize", size);               
		        request.setAttribute("listimage", image);
		        request.setAttribute("listlikesSize", likesSize);
		        request.setAttribute("listlikes", likesUsers);

				
				
		        RequestDispatcher rd=request.getRequestDispatcher("List.jsp");    
		        
		        rd.forward(request,response); 
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
