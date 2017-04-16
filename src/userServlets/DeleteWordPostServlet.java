package userServlets;

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

import userBeans.QuotePost;
import userBeans.UserFeed;
import userBeans.WordPost;


public class DeleteWordPostServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteWordPostServlet() {
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

      
        
        
        String deleteID = request.getParameter("deleteID");
        String deleteType = request.getParameter("deletetype");
        
		WordPost wp = new WordPost();
		QuotePost qp = new QuotePost();

        
        
		
		
//
	 
		//TRY REGEX TO DELETE IT FROM ARRAYLIST BY MAKING IT STRING. REGEZ!!!
		
		
		//
		
		
		
		UserFeed uf = new UserFeed();
		 ArrayList<String> idFeedArray = uf.feedID(username);
		 ArrayList<String> typeFeedArray = uf.feedType(username);
		 
//		 int sizeofIndex = idFeedArray.size(); // need to remove the last entry of feed because its empty (i.e. ...w,w,w,[empty]
//		 idFeedArray.remove(sizeofIndex -1);
//		 typeFeedArray.remove(sizeofIndex -1);
		 
//		 Integer positionInIndex = 0;
	
//		 for(int i = 0; i < idFeedArray.size(); i++){
//			 
//			 if(idFeedArray.get(i).contains(deleteID)){
//				positionInIndex = i;
//			 }
//			 
//		 }
		 
		 	int positionInIndex = 0;

		 
	
		     for (int i = 0; i < idFeedArray.size(); i++)
		     {
		         String id = idFeedArray.get(i);
		         if (deleteID.equals(id))
		         {
		        	 positionInIndex = i;
		         }else{
		        	 positionInIndex = -1;
		         }
		     } 


		 
		 
		 
		 
		 
//		 	int positionInIndex = idFeedArray.indexOf(deleteID);
		 

			idFeedArray.remove(positionInIndex);  // remove deleted post from index of feed
			
			//String getType = typeFeedArray.get(positionInIndex); // get the type of post we are deleting before removing from arraylist
			
			typeFeedArray.remove(positionInIndex); // remove deleted post from index of feed (must happen after we get the type
			
			
			if(deleteType.contains("w")){
					
				wp.deleteWordPostfromDB(deleteID); // delete post
				uf.refreshFeed(idFeedArray,typeFeedArray, username); // refresh userfeed
				

			}
			
			if(deleteType.contains("q")){
				
				qp.deleteQuotePostfromDB(deleteID); // delete post
				uf.refreshFeed(idFeedArray,typeFeedArray, username); // refresh userfeed
				

			}
			
			
//			 UserFeed uf = new UserFeed();
				
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
				  ArrayList<String> idFeedArrayNew = posts.get(8);
				  ArrayList<String> typeFeedArrayNew = posts.get(9);
				  
					session.setAttribute("wordorquotepostID", WordOrQuotePostID);
					session.setAttribute("WordOrQuotePost", WordOrQuotePost);
					session.setAttribute("DefinitionOrAuthorPost", DefinitionOrAuthorPost);
					session.setAttribute("usertextpost", usertextpost);
					session.setAttribute("imagepost", imagepost);
					session.setAttribute("timepost", timepost);
					session.setAttribute("userpost", userpost);
					session.setAttribute("likesArraySize", likesArraySize);

					session.setAttribute("idFeedArray", idFeedArrayNew);
					session.setAttribute("typeFeedArray", typeFeedArrayNew);

					
					ArrayList<ArrayList<String>> arrayception = feed.get(1);
					
					session.setAttribute("arrayception", arrayception);
					  
		        
		        
				
				
		        
			        RequestDispatcher rd=request.getRequestDispatcher("UserProfile.jsp");    
		            
		            rd.forward(request,response);    
			
			
			
			
			
			
		
		
		
	}
		
		
	}


