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

import logophilia.Feed;
import userBeans.PostComment;
import userBeans.UserBean;
import userBeans.UserErosDao;
import userBeans.UserNotifications;
import userBeans.WordPost;

/**
 * Servlet implementation class AddCommentIndex
 */
public class AddCommentIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCommentIndex() {
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
		
		String comment = request.getParameter("comment");
		
		String postID = request.getParameter("postID");
		
		String postUser = request.getParameter("postUser");
		
		String postType = request.getParameter("type");
		
	

		
				
        Date creationTime = new Date(session.getCreationTime() );
        DateFormat formatter = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM);
        
        String postDate = formatter.format(creationTime).toString();
        
       PostComment pc = new PostComment();
       

       // add date to comment? 
        pc.AddWordPostComment(postID, username, postDate, comment);
        
        
        // send notification
		if(postUser != username){
        UserNotifications un = new UserNotifications();
        
        String notification = username + " commented on your post. +2 Eros";
		
		un.addNotification(postUser, notification, postDate, "not implemented");
		}
        
        // increase eros

       	UserBean userbean = new UserBean();
    	userbean.addErosAnotherUser(username);
		userbean.addEros(username);
	
		String eros = UserErosDao.getNetEros(username);
		String currenteros = UserErosDao.getCurrentEros(username);
   
        session.setAttribute("currenteros", currenteros);
        session.setAttribute("eros", eros);
        
        
		
		Feed indexfeed = new Feed();
		
		ArrayList<ArrayList<ArrayList<String>>> superarray = indexfeed.getMainFeedIndex();
		ArrayList<ArrayList<String>> wordpostinfo = new ArrayList<ArrayList<String>>();		
		
		
		ArrayList<String> wordpostID = new ArrayList<String>();
		ArrayList<String> wordpostUserWord = new ArrayList<String>();

		ArrayList<String> wordpostUserText = new ArrayList<String>();
		ArrayList<String> wordpostUserDefinition = new ArrayList<String>();

		ArrayList<String> wordpostUserImage = new ArrayList<String>();
		ArrayList<String> wordpostUserTime = new ArrayList<String>();
		ArrayList<String> wordpostUserUser = new ArrayList<String>();
		ArrayList<String> wordpostComments = new ArrayList<String>();

		ArrayList<String> CommentsSize = new ArrayList<String>();
		ArrayList<String> wordpostlikesSize = new ArrayList<String>();
		ArrayList<String> wordpostlikes = new ArrayList<String>();
		ArrayList<ArrayList<String>> arrayception = new ArrayList<ArrayList<String>>();
		
		ArrayList<ArrayList<String>> wordposts = new ArrayList<ArrayList<String>>();
		
		arrayception = superarray.get(0);
		wordposts = superarray.get(1);
		
		wordpostinfo = superarray.get(2);
		
		
		wordpostID = wordpostinfo.get(0);
		wordpostUserUser = wordpostinfo.get(1);
		wordpostUserTime = wordpostinfo.get(2);
		wordpostUserImage = wordpostinfo.get(3);
		wordpostUserDefinition = wordpostinfo.get(4);
		wordpostUserText = wordpostinfo.get(5);
		wordpostUserWord = wordpostinfo.get(6);
		CommentsSize = wordpostinfo.get(7);
		wordpostlikesSize = wordpostinfo.get(8);
		

		session.setAttribute("arrayception", arrayception);	
		session.setAttribute("indexwordpostID", wordpostID);		
		session.setAttribute("indexWordPostUserArray", wordpostUserUser);
		session.setAttribute("indexWordPostTimeArray", wordpostUserTime);		
		session.setAttribute("indexWordPostImageArray", wordpostUserImage);		
		session.setAttribute("indexWordPostDefinitionArray", wordpostUserDefinition);		
		session.setAttribute("indexWordPostUserTextArray", wordpostUserText);		
		session.setAttribute("indexWordPostWordArray", wordpostUserWord);
		session.setAttribute("indexwordpostComments", CommentsSize);
		session.setAttribute("indexwordpostlikesSize", wordpostlikesSize);	
		session.setAttribute("indexWordPostsArray", wordposts);
		
		
		
		
		
		
	RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);

   	 
   	 
		
		
        
        
        
        
        
        
        
        
        
        
	}

}
