package database;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import userBeans.WordListsDao;
import userBeans.QuotePost;
import userBeans.SavedWords;
import userBeans.SearchHistory;
import userBeans.UserBean;
import userBeans.UserFeed;
import userBeans.WordLists;
import userBeans.WordPost;

public class GetProfileServlet extends HttpServlet {
	
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public GetProfileServlet() {
        super();
    }

 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	 
	HttpSession session = (request.getSession());
	
  String username=request.getParameter("Selectedusername");    

     


  	
  	
  	UserBean userbean = new UserBean();
  	
  	WordListsDao userlist = new WordListsDao();
	 UserFeed uf = new UserFeed();

		WordLists ul = new WordLists();
  	WordPost wp = new WordPost();
	QuotePost qp = new QuotePost();

  	
		  SavedWords sw = new SavedWords();
		 SearchHistory sh = new SearchHistory();


		  
		
  	ArrayList<String> listsize = new ArrayList<String>();

  	listsize = ul.getListSizes(username);

		String usertitleresults = userbean.getProfileInfoTitle(username);
		String userbodyresults = userbean.getProfileInfoBody(username);


  	String creationTime = userbean.getCreationTimeOfUser(username);

    	String rank = userbean.getRank(username);
    	

//	   	String[] profileImg = userbean.getProfileImage(username).split(",");
//	   	String[] coverImg = userbean.getCoverImage(username).split(",");

     	String profileImg = userbean.getProfileImage(username);
	   	String coverImg = userbean.getCoverImage(username);
	   	
	   	
	   	
//	   	int wordpostsize = 0;
//	   	int wordpostsize = wp.getTotaltAmountOfPosts(username);
//		
//		if(wordpostsize < 0){
	   	
	   	
	   	
	   	//-------------------------------------LOAD WORD POSTS SECTION-------------------------------------
//			   	
		
		ArrayList<ArrayList<String>> feed = uf.getMainFeedByUser(username);
		
		  ArrayList<String>	WordOrQuotePostID = feed.get(0);
		  ArrayList<String> WordOrQuotePost = feed.get(1);
		  ArrayList<String> DefinitionOrAuthorPost = feed.get(2);
		  ArrayList<String> usertextpost = feed.get(3);
		  ArrayList<String> imagepost = feed.get(4);
		  ArrayList<String> timepost = feed.get(5);
		  ArrayList<String> userpost = feed.get(6);
		  ArrayList<String> comments = feed.get(7);
		  ArrayList<String> idFeedArray = feed.get(8);
		  ArrayList<String> typeFeedArray = feed.get(9);
		

			request.setAttribute("SwordorquotepostID", WordOrQuotePostID);
			request.setAttribute("Suserpost", userpost);
			request.setAttribute("Stimepost", timepost);
			request.setAttribute("Simagepost", imagepost);
			request.setAttribute("SDefinitionOrAuthorPost", DefinitionOrAuthorPost);
			request.setAttribute("Susertextpost", usertextpost);
			request.setAttribute("SWordOrQuotePost", WordOrQuotePost);
			request.setAttribute("SidFeedArray", idFeedArray);
			request.setAttribute("StypeFeedArray", typeFeedArray);
			request.setAttribute("ScommentsArray", comments);
			
			ArrayList<ArrayList<String>> arrayception = new ArrayList<ArrayList<String>>();
			for(int i = 0; i < comments.size(); i ++){
				ArrayList<String> commentsArrayID = new ArrayList<String>(Arrays.asList(comments.get(i).split(" !X ")));
				commentsArrayID.remove(0);
				arrayception.add(commentsArrayID);				
			}
			
			request.setAttribute("Sarrayception", arrayception);
	   	
	   	
	   	
	   	
	   	
	   	
	   	
	   	
	   	
	   	
	   	
	   	
	   	
	   	
	   	
	   	
	   	
	    ArrayList<String> searchhistory2 = sh.getSearchHistory(username);
	    searchhistory2.remove(0);
      String Finalhstory = searchhistory2.toString().replaceAll("]", "").substring(1);
      ArrayList<String> savedwordsArray23 = new ArrayList<String>(Arrays.asList(Finalhstory.split(","))); 
	   	
  	Collections.reverse(savedwordsArray23);

      
	   	session.setAttribute("SelectedUsersearchhistory", savedwordsArray23);


		   ArrayList<String> savedwords2 = sw.getSavedWords(username);
	        savedwords2.remove(0);
	        String FinalSearches2 = savedwords2.toString().replaceAll("]", "").substring(1);
	        ArrayList<String> savedwordsArray2 = new ArrayList<String>(Arrays.asList(FinalSearches2.split(","))); 
	        
	    	Collections.reverse(savedwordsArray2);

	        
	        
		session.setAttribute("SelectedUsersavedwords", savedwordsArray2);

	   	
    //  session.removeAttribute("userlists");
      
	//	session.setAttribute("profileImg", profileImg);
		
  	session.setAttribute("SelectedUseruserbodyresults", userbodyresults);
  	session.setAttribute("SelectedUserusertitleresults", usertitleresults);


		session.setAttribute("SelectedUserprofileImg", profileImg);

		session.setAttribute("SelectedUsercoverImg", coverImg);
    	
//    	session.setAttribute("searchhistory", userbean.getSearchHistory(username));
//    	
//    	
//		session.setAttribute("savedwords", userbean.getSavedWords(username));

    	
  	session.setAttribute("SelectedUserRank", rank);
  	
  	
  												// FIX THIS PART FOR USER SETTINGS STATS
  	session.setAttribute("SelectedUserAmountOfUserLists", ul.getTotalAmountofLists(username));
//  	session.setAttribute("AmountOfUserShards", listsize.size());
//	session.setAttribute("SelectedUserAmountOfUserWordPosts", wp.getTotaltAmountOfPosts(username));


  	session.setAttribute("SelectedUserlistsizes", listsize);
  	
  	session.setAttribute("SelectedUseruserlists", userlist.getLists(username));
  	
  	
  	session.setAttribute("SelectedUsercreationTime", creationTime);
  	session.setAttribute("SelectedUserloggedInUser", username);
  	
  	
  	
  	
  //	userbean.MakeListDirectory(username);
		
  	// 	List<String> userLists = new ArrayList<String>(Arrays.asList(userbean.userLists().split(",")));
  	
  	
  	//CHANGE TO SESSION ? 
		//request.setAttribute("UserList", userLists); 	


		
	//	List<String> FinalUserList = new ArrayList<String>(Arrays.asList(userLists.split(",")));
//  	
//  	String getEros = userbean.getEros(username);
//  	
//  	
// 	session.setAttribute("userEros", getEros);
		//UserErosDao.CheckErosNull(username);

	//userbean.checkErosNotNull(username);
      String eros = userbean.getEros(username);
      String currenteros = userbean.currentEros(username);
  	


      
      
//      String eros = UserErosDao.getNetEros(username);
     session.setAttribute("SelectedUsercurrenteros", currenteros);
     session.setAttribute("SelectedUsereros", eros);
    //  request.setAttribute("eros", eros);
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
   	
//   	
//   	if(2 > 1){
   		
//   	  	StringBuffer requestURL = new StringBuffer(request.getRequestURL());
//   	  	
//   	  	
//   	  	
//   	  	UserBean ub = new UserBean();
//   		
//   		
//   		request.setAttribute("super", requestURL.toString());
//   	  String servletPath = request.getServletPath();
//   		
//   		
//   		String url = request.getContextPath() + servletPath;
//   		response.sendRedirect(url);
//   		
   		
   		
//   		
//   	}
   	
 	RequestDispatcher rd = getServletContext().getRequestDispatcher("/getProfile.jsp");
	rd.forward(request, response);   
  
  
     
//	   RequestDispatcher rd=request.getRequestDispatcher("getProfile.jsp");    
//	       
//	       rd.forward(request,response);  
  
  
  
  
  //forward the request to profile.jsp
//  request.getRequestDispatcher("getProfile.jsp")
//       .forward(request, response);
  //display user info which was stored in userpojo by profile.jsp 
 }

 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 }

}