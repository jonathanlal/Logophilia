package userServlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import userBeans.SavedWords;
import userBeans.SearchHistory;


public class SaveWordSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SaveWordSearch() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NullPointerException {
	
		//String wordfromlist = "";

		

		
		
		
    	HttpSession session = (request.getSession());
        String username = session.getAttribute("loggedInUser").toString();


    	
//    	String querySession = session.getAttribute("querySession").toString();
		String word = request.getParameter("word");

      
 
        SavedWords sw = new SavedWords();
        SearchHistory sh = new SearchHistory();
 
        
        
//		if(word != null){
			
				sw.setSavedWord(word, username);
				sh.ResetSearchHistoryAfterSave(username); // when page goes back it adds the searched word back into search history, so remove it

  
		        ArrayList<String> savedwords = sw.getSavedWords(username);
//		        savedwords2.remove(0);
//		        String FinalSearches2 = savedwords2.toString().replaceAll("]", "").substring(1);
//		        ArrayList<String> savedwordsArray2 = new ArrayList<String>(Arrays.asList(FinalSearches2.split(","))); 
		        
		    	Collections.reverse(savedwords);

		        
				session.setAttribute("savedwords", savedwords);

				
			
			
//		}else{
//
//	        
//	        
//				sw.setSavedWord(word, username);
//				sh.ResetSearchHistoryAfterSave(username);   // THIS ?!???!? 
//
//				
//				ArrayList<String> savedwords = sw.getSavedWords(username);
//				savedwords.remove(0);
//				String FinalSearches = savedwords.toString().replaceAll("]", "").substring(1);
//				ArrayList<String> savedwordsArray = new ArrayList<String>(Arrays.asList(FinalSearches.split(",")));
//				
//		    	Collections.reverse(savedwordsArray);
//
//				
//				session.setAttribute("savedwords", savedwordsArray);
//			
//				
//
//		}
        
        
        
        
        
        
		
		
//		  SavedWords sw = new SavedWords();
//		  
//		  sw.setSavedWord(word, username);
//		  
//		  
//			session.setAttribute("savedwords", sw.getSavedWords(username));
//
//		  
//		  
//			
//			
//			
//			
//			String querySession = session.getAttribute("querySession").toString();
//			
//			
////			
//			if(querySession != null){
//				
//
//		        
//		        ArrayList<String> savedword2s = sw.getSavedWords(username.toString());
//		        
//		        savedword2s.remove(0);
//		        String FinalSearch2es = savedword2s.toString().replaceAll("]", "").substring(1);
//		        ArrayList<String> savedwordsArra2y = new ArrayList<String>(Arrays.asList(FinalSearch2es.split(",")));
//		        
//		        
//				session.setAttribute("savedwords", savedwordsArra2y);
//				
//			}
			
		
		
			
	//	if(!wordfromlist.isEmpty()){
	    	//HttpSession session = (request.getSession());

	    	//session.removeAttribute("savedwords");

		  //	String word = session.getAttribute("querySession").toString();
	      //  String username = session.getAttribute("loggedInUser").toString();
	      // UserBean userbean = new UserBean();
	       
		//	userbean.SaveWord(username, wordfromlist);
			//session.setAttribute("savedwords", userbean.getSavedWords(username));
	//	}
			
			
	//	String dispatchtest = "SearchServlet?query=" + word;
		
	   	
//        RequestDispatcher rd=request.getRequestDispatcher("UserProfile.jsp");    
//        
//         rd.forward(request,response);    
        
		


String referer = request.getHeader("Referer");
response.sendRedirect(referer);
		
		
		
		
		
   
		
		
	}

}
