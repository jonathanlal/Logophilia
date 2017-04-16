package userServlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import userBeans.QuotePost;
import userBeans.UserFeed;
import userBeans.WordPost;

/**
 * Servlet implementation class UserPostMenu
 */
//@WebServlet("/UserPostMenu")
public class UserPostMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserPostMenu() {
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

        
        
		WordPost wp = new WordPost();
		QuotePost qp = new QuotePost();
		UserFeed uf = new UserFeed();


        
        String action = request.getParameter("action");
        
        
//        if(action.contains("edit")){
//
//        	
//        	
//        }
//        if(action.contains("addToList")){
//
//
//
//	  			
//	            RequestDispatcher rd=request.getRequestDispatcher("test.jsp");    
//	            
//	             rd.forward(request,response);   
//	
//		
//        }
//        if(action.contains("delete")){
        	
       
        	
//       	 ArrayList<String> idFeedArray = uf.feedID(username);
//		 ArrayList<String> typeFeedArray = uf.feedType(username);
 
        	
        	try{
//        		String wordtestarray = request.getParameter("wordtestarray");
        	 	String type = request.getParameter("deletetype");
            	String postID = request.getParameter("deleteword"); // this is only the number of word posts it does not include quote posts
            	
        	if(type.contains("w")){

        		// delete from usefeed mySQL
        		
//      		int NumberInArray = 0; // Initialise
        		
        		//get feed id & type from userfeed
        		ArrayList<String> ufID = uf.feedID(username);
        		ArrayList<String> ufType = uf.feedType(username);  
        		
//		    	Collections.reverse(ufID);
//		    	Collections.reverse(ufType);

        		

        		//get index of desired deleted post
            
            	
        		String WordPostID = wp.getwordpostID(username, postID);
        		
        		int NumberInArray = ufID.indexOf(WordPostID);
        		ufType.remove(1);
        		ufID.remove(1);
        		
        		
//        		int count = 0;
            	
//            	for(int i = 0; i < ufID.size(); i++){
//            		
//            		
//            		if(ufID.get(i).toString().contains("\\d")){
//            			count = count + 1;
//            		
//            		}
//            		if(ufID.get(i).contains(WordPostID)){
//
//            	 		
//                		
//            		}
//            	}
            	
            	
            	

            	//delete chosen index from userfeed arrays
       
        		        		
        		// delete from mySQL
        		wp.deleteWordPostfromDB(postID);

        		if(wp.getTotaltAmountOfPosts(username)== 0){


        	 		uf.nullFeed(username);

        		
        		}else{
        			
            		
            		//this part adds the "," to the end of the arraylist to stop it from fucking up....
            		ufID.set(ufID.size()-1, ufID.get(ufID.size()-1)+",");
            		ufType.set(ufID.size()-1, ufType.get(ufID.size()-1)+",");
            		
            		
            		uf.refreshFeed(ufID, ufType, username);
        			
        			
        			
        		}
        	
        		
             	session.setAttribute("typedeletetest", ufType);
            	session.setAttribute("deletewordtest", ufID);
            	session.setAttribute("postIDtest", postID);
        		session.setAttribute("NumberInArray", NumberInArray);
        		session.setAttribute("wordtestarray2", ufID.size());
        		
        		
        	
        		

        	}
        	if(type.contains("q")){
        		
	// delete from usefeed mySQL
        		
        		
        	    		

        	

        		        		
       
        		
        		int NumberInArray = 0;
        		ArrayList<String> ufID = uf.feedID(username);
        		ArrayList<String> ufType = uf.feedType(username);

//            	int NumberInArray = ufID.indexOf(postID);
            	
            	
            	int count = 0;
            	
            	for(int i = 0; i < ufID.size(); i++){
            		
            		
            		if(ufID.get(i).contains("\\d")){
            			count = count + 1;
            		
            		}
            		if(ufID.get(i).contains(postID)){
            			NumberInArray = count;
            		}
            	}
            	

        		ufID.remove(NumberInArray);
        		ufType.remove(NumberInArray);
        		
        		// delete from mySQL
        		qp.deleteQuotePostfromDB(postID);


        		session.setAttribute("NumberInArray", NumberInArray);

        		if(qp.getTotaltAmountOfPosts(username)== 0){


        	 		uf.nullFeed(username);

        		
        		}else{
        			
            		
            		//this part adds the "," to the end of the arraylist to stop it from fucking up....
            		ufID.set(ufID.size()-1, ufID.get(ufID.size()-1)+",");
            		ufType.set(ufID.size()-1, ufType.get(ufID.size()-1)+",");
            		
            		
            		uf.refreshFeed(ufID, ufType, username);
        			
        			
        			
        		}
        		
        		
             	session.setAttribute("typedeletetest", ufType);
            	session.setAttribute("deletewordtest", ufID);
            	session.setAttribute("postIDtest", postID);

        		
        	}
        	
        	
//        	}
        		
        		
        	}finally{	
        		
        		
//        		if()
        		
        		
       		 ArrayList<String> idFeedArray = uf.feedID(username);
			 ArrayList<String> typeFeedArray = uf.feedType(username);

			 
//			 if(typeFeedArray.toString().matches("[wq]")){
			 

				ArrayList<String> WordOrQuotePost = new ArrayList<String>();
				ArrayList<String> DefinitionOrAuthorPost = new ArrayList<String>();
				ArrayList<String> usertextpost = new ArrayList<String>();
				ArrayList<String> imagepost = new ArrayList<String>();
				ArrayList<String> timepost = new ArrayList<String>();
				ArrayList<String> userpost = new ArrayList<String>();
				
				
				for(int i = 0; i < idFeedArray.size();i++){
					 
					 String ID = idFeedArray.get(i);
					 String Type = typeFeedArray.get(i);

					 if(Type.contains("w")){
						 
						 ArrayList<String> WordPost = wp.getWordPostByID(ID); 		 

							 session.setAttribute("WordPostv", WordPost);
								WordOrQuotePost.add(WordPost.get(0).replace("[", ""));						
								DefinitionOrAuthorPost.add(WordPost.get(1));					
								usertextpost.add(WordPost.get(2));  
								imagepost.add(WordPost.get(3));
								timepost.add(WordPost.get(4));
								userpost.add(WordPost.get(5).replace("]", ""));				 
					 }
					 
					 if(Type.contains("q")){
						 
						 ArrayList<String> QuotePost = qp.getQuotePostByID(ID); 

						 session.setAttribute("WordPostv2", QuotePost);

						 	WordOrQuotePost.add(QuotePost.get(0).replace("[", ""));						
							DefinitionOrAuthorPost.add(QuotePost.get(1));					
							usertextpost.add(QuotePost.get(2));  
							imagepost.add(QuotePost.get(3));
							timepost.add(QuotePost.get(4));
							userpost.add(QuotePost.get(5).replace("]", ""));				 
					 }

				 											} 

				Collections.reverse(userpost);
				session.setAttribute("userpost", userpost);

		    	Collections.reverse(timepost);
				session.setAttribute("timepost", timepost);
				
				
		    	Collections.reverse(imagepost);
				session.setAttribute("imagepost", imagepost);

				
		    	Collections.reverse(DefinitionOrAuthorPost);
				session.setAttribute("DefinitionOrAuthorPost", DefinitionOrAuthorPost);

				
		    	Collections.reverse(usertextpost);
				session.setAttribute("usertextpost", usertextpost);

				
		    	Collections.reverse(WordOrQuotePost);
				session.setAttribute("WordOrQuotePost", WordOrQuotePost);
				
				
				Collections.reverse(idFeedArray);

				session.setAttribute("idFeedArray", idFeedArray);
			 
				Collections.reverse(typeFeedArray);

				session.setAttribute("typeFeedArray", typeFeedArray);
        		
        		
//			 }
//        		
//        		
        		
        		
        		
        		
        		
        		
        		
        		
        		
        		
        		
        		
        		
        		
        		
        		
        		
        		
        	
        	
        	
            RequestDispatcher rd=request.getRequestDispatcher("test.jsp");    
            
             rd.forward(request,response);   
        	}
//        }

	}
}
