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

import userBeans.SavedWords;
import userBeans.UserFeed;

/**
 * Servlet implementation class RemoveSaved
 */
public class RemoveSaved extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveSaved() {
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
        
        
		
		String savedword = request.getParameter("word");
		
		SavedWords sw = new SavedWords();
		
		sw.removeSavedWord(savedword, username);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
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
			
		
		
		
		
		
		
			
			
			ArrayList<String> savedwords = sw.getSavedWords(username);
//			savedwords2.remove(0);
//			String FinalSearches2 = savedwords2.toString().replaceAll("]", "").substring(1);
//			ArrayList<String> savedwordsArray2 = new ArrayList<String>(Arrays.asList(FinalSearches2.split(",")));

			Collections.reverse(savedwords);

			session.removeAttribute("savedwords");

			session.setAttribute("savedwords", savedwords);
		
		
		
		
		
		
		
		
		
		
		
		
		
	
		
	    RequestDispatcher rd=request.getRequestDispatcher("UserProfile.jsp");   
        
        rd.include(request,response);    
		
		
	}

}
