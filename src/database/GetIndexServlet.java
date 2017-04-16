package database;

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

import logophilia.Feed;
import userBeans.WordPost;

/**
 * Servlet implementation class GetIndexServlet
 */
//@WebServlet("/GetIndexServlet")
public class GetIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetIndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
//		WordPost wp = new WordPost();
		
		HttpSession session = (request.getSession());

		
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
		
		
		
		
		
		
		
		
		
//		ArrayList<ArrayList<String>> wordposts = wp.getAllWordPosts();
//		if(wordposts.size() > 0){
//		
//		ArrayList<String> wordpostID = new ArrayList<String>();
//		ArrayList<String> wordpostUserWord = new ArrayList<String>();
//
//		ArrayList<String> wordpostUserText = new ArrayList<String>();
//		ArrayList<String> wordpostUserDefinition = new ArrayList<String>();
//
//		ArrayList<String> wordpostUserImage = new ArrayList<String>();
//		ArrayList<String> wordpostUserTime = new ArrayList<String>();
//		ArrayList<String> wordpostUserUser = new ArrayList<String>();
//		ArrayList<String> wordpostComments = new ArrayList<String>();
//
//		ArrayList<String> CommentsSize = new ArrayList<String>();
//		ArrayList<String> wordpostlikesSize = new ArrayList<String>();
//		ArrayList<String> wordpostlikes = new ArrayList<String>();
//		ArrayList<ArrayList<String>> arrayception = new ArrayList<ArrayList<String>>();
//
//		
//
//		for(int i=0; i < wordposts.size();i++){
//			
//			ArrayList<String> wordpost = wordposts.get(i);
//			
//			wordpostID.add(wordpost.get(0));
//			wordpostUserWord.add(wordpost.get(1));
//			
//			wordpostUserText.add(wordpost.get(2));
//			
//			
//			wordpostUserDefinition.add(wordpost.get(3));  
//			wordpostUserImage.add(wordpost.get(4));
//			wordpostUserTime.add(wordpost.get(5));
//			wordpostUserUser.add(wordpost.get(6));
//			if(wordpost.get(7) != null){
//			ArrayList<String> likes = new ArrayList<String>(Arrays.asList(wordpost.get(7).split(",")));
//			wordpostlikesSize.add(Integer.toString(likes.size()));
//			wordpostlikes.addAll(likes);
//			}else{
//			wordpostlikesSize.add("0");	
//			}
//			
//			if(wordpost.get(8) != null){
//			ArrayList<String> comments = new ArrayList<String>(Arrays.asList(wordpost.get(8).split("!X")));
//			CommentsSize.add(Integer.toString(comments.size()-1)); // -1 because one extra !X
//			comments.remove(0);
//			arrayception.add(comments);
//			}else{
//				CommentsSize.add("0");
//				arrayception.add(wordpostComments);
//
//			}
//			
//		}
		

		
//		Collections.reverse(arrayception);

//		session.setAttribute("arrayception", arrayception);
		
		
		
//		Collections.reverse(wordpostID);
//		session.setAttribute("indexwordpostID", wordpostID);
		
		
//    	Collections.reverse(wordpostUserUser);
//		session.setAttribute("indexWordPostUserArray", wordpostUserUser);

//    	Collections.reverse(wordpostUserTime);
//		session.setAttribute("indexWordPostTimeArray", wordpostUserTime);
		
		
//    	Collections.reverse(wordpostUserImage);
//		session.setAttribute("indexWordPostImageArray", wordpostUserImage);

		
//    	Collections.reverse(wordpostUserDefinition);
//		session.setAttribute("indexWordPostDefinitionArray", wordpostUserDefinition);

		
//    	Collections.reverse(wordpostUserText);
//		session.setAttribute("indexWordPostUserTextArray", wordpostUserText);

		
//    	Collections.reverse(wordpostUserWord);
//		session.setAttribute("indexWordPostWordArray", wordpostUserWord);

//		Collections.reverse(CommentsSize);
//		session.setAttribute("indexwordpostComments", CommentsSize);
		

//		Collections.reverse(wordpostlikesSize);
//		session.setAttribute("indexwordpostlikesSize", wordpostlikesSize);
		
		
//    	Collections.reverse(wordposts);

    	
//		session.setAttribute("indexWordPostsArray", wordposts);
		

//		}
	

		
	RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);

		
		
		
		
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
