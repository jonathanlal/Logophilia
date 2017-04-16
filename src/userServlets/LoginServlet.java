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

import database.DailyWord;
import userBeans.UserSettings;
import userBeans.WordListsDao;
import userBeans.LoginDao;
import userBeans.QuoteLists;
//import userBeans.QuotePost;
import userBeans.SavedWords;
import userBeans.SearchHistory;
import userBeans.UserBean;
import userBeans.UserFeed;
import userBeans.WordLists;
import userBeans.WordPost;  
import userBeans.UserNotifications;



public class LoginServlet extends HttpServlet{  
	
 
    private static final long serialVersionUID = 1L;  

    public void doPost(HttpServletRequest request, HttpServletResponse response)    
            throws ServletException, IOException {    
  
 
    	HttpSession session = (request.getSession());
        String username=request.getParameter("username");    
        String userpass=request.getParameter("userpass");  
        
        if(LoginDao.validate(username, userpass)){    
        	
        	UserBean userbean = new UserBean();
			 QuoteLists ql = new QuoteLists();
			WordLists ul = new WordLists();
			WordPost wp = new WordPost();
			SavedWords sw = new SavedWords();
			SearchHistory sh = new SearchHistory();
			WordListsDao userlist = new WordListsDao();

			ArrayList<String> listsize = new ArrayList<String>();
			String userbodyresults, usertitleresults, creationTime, rank, profileImg, coverImg, eros, currenteros;

        	listsize = ul.getListSizes(username);
			usertitleresults = userbean.getProfileInfoTitle(username);
			userbodyresults = userbean.getProfileInfoBody(username);
        	creationTime = userbean.getCreationTimeOfUser(username); 	
          	rank = userbean.getRank(username);   	
		   	profileImg = userbean.getProfileImage(username);
		   	coverImg = userbean.getCoverImage(username);
	        eros = userbean.getEros(username);
	        currenteros = userbean.currentEros(username);
        

			
	        
	        
	        
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
			  ArrayList<String> savedwordscheck = posts.get(10);
			  
				session.setAttribute("wordorquotepostID", WordOrQuotePostID);
				session.setAttribute("WordOrQuotePost", WordOrQuotePost);
				session.setAttribute("DefinitionOrAuthorPost", DefinitionOrAuthorPost);
				session.setAttribute("usertextpost", usertextpost);
				session.setAttribute("imagepost", imagepost);
				session.setAttribute("timepost", timepost);
				session.setAttribute("userpost", userpost);
				session.setAttribute("likesArraySize", likesArraySize);
				session.setAttribute("savedwordsArrayCheck", savedwordscheck);

				session.setAttribute("idFeedArray", idFeedArray);
				session.setAttribute("typeFeedArray", typeFeedArray);

				
				ArrayList<ArrayList<String>> arrayception = feed.get(1);
				
				session.setAttribute("arrayception", arrayception);
				
				
	        
	    
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        

		   	
		    ArrayList<String> searchhistory2 = sh.getSearchHistory(username);
		    searchhistory2.remove(0);
	        String Finalhstory = searchhistory2.toString().replaceAll("]", "").substring(1);
	        ArrayList<String> savedwordsArray23 = new ArrayList<String>(Arrays.asList(Finalhstory.split(","))); 
		   	
	    	Collections.reverse(savedwordsArray23);

	        
			session.setAttribute("searchhistory", savedwordsArray23);

			ArrayList<String> savedwords2 = sw.getSavedWords(username);
//			savedwords2.remove(0);
//			String FinalSearches2 = savedwords2.toString().replaceAll("]", "").substring(1);
//			ArrayList<String> savedwordsArray2 = new ArrayList<String>(Arrays.asList(FinalSearches2.split(",")));

			Collections.reverse(savedwords2);

			session.setAttribute("savedwords", savedwords2);

			session.removeAttribute("userlists");

			session.setAttribute("userbodyresults", userbodyresults);
			session.setAttribute("usertitleresults", usertitleresults);

			session.setAttribute("profileImg", profileImg);

			session.setAttribute("coverImg", coverImg);


			session.setAttribute("Rank", rank);
			// FIX THIS PART FOR USER SETTINGS STATS
			session.setAttribute("AmountOfUserLists", ul.getTotalAmountofLists(username));
			session.setAttribute("AmountOfUserWordPosts", wp.getTotaltAmountOfPosts(username));

			session.setAttribute("listsizes", listsize);

			session.setAttribute("userlists", userlist.getLists(username));

			session.setAttribute("creationTime", creationTime);
			session.setAttribute("loggedInUser", username);

			session.setAttribute("listsizes", ul.getListSizes(username));
			session.setAttribute("userlists", ul.getUserLists(username));

			session.setAttribute("quotelistsizes", ql.getListSizes(username));
			session.setAttribute("quotelists", ql.getUserLists(username));

			session.setAttribute("currenteros", currenteros);
			session.setAttribute("eros", eros);
			
				
	        ArrayList<ArrayList<String>> listinfo = ul.getListInfoProfile(username);
	        
	        
	        ArrayList<String> listids = listinfo.get(0);
	        ArrayList<String> listnames = listinfo.get(1);
	        ArrayList<String> listsizes = listinfo.get(2);
	        ArrayList<String> listlikes = listinfo.get(3); // fix this to get size of each element in it
	        
	        
	        session.setAttribute("userlistids", listids);
	    	session.setAttribute("userlistsizes", listsizes);		
	        session.setAttribute("userlistnames", listnames);
	        session.setAttribute("userlistlikes", listlikes);
				
				
				
				
				
				
				
				
			UserSettings us = new UserSettings();
			ArrayList<String> settings = us.getSettings(username);
			
  			String newtab = settings.get(0);
  			String hidesearch = settings.get(1);
  			String hideprofileimg = settings.get(2);
 

			//SET DEFAULT SETTINGS
			session.setAttribute("newTab", newtab);			
			if(!newtab.isEmpty()){
				session.setAttribute("newTabSetting", "target=\"_blank\"");
			}
			
			session.setAttribute("hideSearch", hidesearch);
			if(!hidesearch.isEmpty()){
				session.setAttribute("hideSearchSetting", "display: none;");
			}
			
			
			session.setAttribute("hideProfileImg", hideprofileimg);
			if(!hideprofileimg.isEmpty()){
				session.setAttribute("hideProfileImgSetting", "display: none;");
			}
			
				
				
				
				
				// GET NOTIFICATIONS
			UserNotifications un = new UserNotifications();
				
			ArrayList<String> notifications	= un.getNotifications(username);
			session.setAttribute("notifications", notifications);
			session.setAttribute("notificationsSize", notifications.size());

				
				
			//DAILY WORD
			DailyWord dw = new DailyWord();
			ArrayList<String> dailywordinfo = dw.getDailyWord();
			
			String word = dailywordinfo.get(0);
			String definitions = dailywordinfo.get(1);
			
			Date now = new Date();
	        DateFormat formatter = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM);       
	        String date = formatter.format(now).toString();
	        
	        session.setAttribute("date", date);
	        session.setAttribute("dailyword", word);
	        session.setAttribute("dailyworddefinitions", definitions);
			
			
        	
	            RequestDispatcher rd=request.getRequestDispatcher("UserProfile.jsp");    
	            
	             rd.forward(request,response);    
            
            
        }    
        else{    
                	
        	
	            RequestDispatcher rd=request.getRequestDispatcher("login.jsp");   
	            
	            rd.include(request,response);    
        }    
  
    }
    
    
}   