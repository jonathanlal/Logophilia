package userServlets;

import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import userBeans.PostComment;
import userBeans.QuotePost;
import userBeans.UserBean;
import userBeans.UserErosDao;
import userBeans.UserFeed;
import userBeans.UserNotifications;
import userBeans.WordLists;
import userBeans.WordPost;


public class AddComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AddComment() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		HttpSession session = (request.getSession());
		String username = session.getAttribute("loggedInUser").toString();
		
		String comment = request.getParameter("comment");
		
		String postID = request.getParameter("postID");
		
		String postUser = request.getParameter("postUser");
		
		String postType = request.getParameter("type");
		
				
        Date creationTime = new Date(session.getCreationTime() );
        DateFormat formatter = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM);
        
        String postDate = formatter.format(creationTime).toString();
        
       PostComment pc = new PostComment();
       

       if (postType.contains("w")){
       
       // add date to comment? 
        pc.AddWordPostComment(postID, username, postDate, comment);

        // send notification
		if(postUser != username){
        UserNotifications un = new UserNotifications();
        
        String notification = username + " commented on your wordpost. +2 Eros";
		
		un.addNotification(postUser, notification, postDate, "not implemented");
		}
		
		
       }
       if(postType.contains("q")){
    	   
           // add date to comment? 
           pc.AddQuotePostComment(postID, username, postDate, comment);

           // send notification
   		if(postUser != username){
           UserNotifications un = new UserNotifications();
           
           String notification = username + " commented on your quotepost. +2 Eros";
   		
   		un.addNotification(postUser, notification, postDate, "not implemented");
   		}
    	   
       }
       
       
       
       
       
       
        
        // increase eros

       	UserBean userbean = new UserBean();
       	userbean.addErosAnotherUser(username);
		userbean.addEros(username);
	
		String eros = UserErosDao.getNetEros(username);
		String currenteros = UserErosDao.getCurrentEros(username);
   
        session.setAttribute("currenteros", currenteros);
        session.setAttribute("eros", eros);
        
        
        
        
        
        
        
        
        
        
        
        
        UserFeed uf = new UserFeed();
		
		ArrayList<ArrayList<ArrayList<String>>> feed = uf.getMainFeedByUser(username);
		
		ArrayList<ArrayList<String>> posts = feed.get(0);
		
		  ArrayList<String>	WordOrQuotePostID = posts.get(0);
		  ArrayList<String> WordOrQuotePost = posts.get(1);
		  ArrayList<String> DefinitionOrAuthorPost = posts.get(2);
		  ArrayList<String> usertextpost = posts.get(3);
		  ArrayList<String> imagepost = posts.get(4);
		  ArrayList<String> timepost = posts.get(5);
		  ArrayList<String> userpost = posts.get(6);
		  ArrayList<String> likesArraySize = posts.get(7);
		  ArrayList<String> idFeedArray = posts.get(8);
		  ArrayList<String> typeFeedArray = posts.get(9);
		  
			session.setAttribute("wordorquotepostID", WordOrQuotePostID);
			session.setAttribute("WordOrQuotePost", WordOrQuotePost);
			session.setAttribute("DefinitionOrAuthorPost", DefinitionOrAuthorPost);
			session.setAttribute("usertextpost", usertextpost);
			session.setAttribute("imagepost", imagepost);
			session.setAttribute("timepost", timepost);
			session.setAttribute("userpost", userpost);
			session.setAttribute("likesArraySize", likesArraySize);

			session.setAttribute("idFeedArray", idFeedArray);
			session.setAttribute("typeFeedArray", typeFeedArray);

			
			ArrayList<ArrayList<String>> arrayception = feed.get(1);
			
			session.setAttribute("arrayception", arrayception);
			  
        
        
		
		
        
	        RequestDispatcher rd=request.getRequestDispatcher("UserProfile.jsp");    
            
            rd.forward(request,response);    
        // 
        
        
        
		
		
		
	}

}
