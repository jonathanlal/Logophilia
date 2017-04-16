package wordnet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logophilia.Merriam;
import userBeans.SearchHistory;
import userBeans.UserBean;
import userBeans.UserErosDao;
import userBeans.WordLists;

/**
 * Servlet implementation class GetWordInfo
 */
public class GetWordInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetWordInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		WordNet wn = new WordNet();
		
		String query = request.getParameter("query");
		
		
		ArrayList<String> definitions = wn.getDefinitions(query);
		ArrayList<String> synoynms = wn.getSynoyms(query);
		ArrayList<String> examples = wn.getExamples(query);
		
		
		
		
		Merriam merriam = new Merriam();

		
		
		
		String merriamResults = merriam.finalResults(query);
		List<String> myList2 = new ArrayList<String>(Arrays.asList(merriamResults.split("\\^!")));
		
		

		request.setAttribute("iresults", myList2.get(5)); 									// Size of query results
		
		


    	HttpSession session = (request.getSession());

		
       Object username = session.getAttribute("loggedInUser");
		
	
//		try{


			if(null != username){

		    	session.setAttribute("querySession", query);

				session.removeAttribute("searchhistory");
				  session.removeAttribute("eros");
			       session.removeAttribute("currenteros");

				UserBean userbean = new UserBean();
				SearchHistory sh = new SearchHistory();
				WordLists ul = new WordLists();
				
				
				ArrayList<String> userlists = ul.getUserLists(username.toString());
				userbean.addEros(username.toString());
				sh.addToSearchHistory(query, username.toString());
				
								
			   String eros = UserErosDao.getNetEros(username.toString());
			   String currenteros = UserErosDao.getCurrentEros(username.toString());
			   
			        session.setAttribute("currenteros", currenteros);
			        session.setAttribute("eros", eros);
			        
			        ArrayList<String> searchhistory = sh.getSearchHistory(username.toString());
			        searchhistory.remove(0);
			        String FinalSearches = searchhistory.toString().replaceAll("]", "").substring(1);
			        ArrayList<String> searchhistoryArray = new ArrayList<String>(Arrays.asList(FinalSearches.split(",")));
			        
			    	Collections.reverse(searchhistoryArray);

					session.setAttribute("searchhistory", searchhistoryArray);
					session.setAttribute("userlists", userlists);
				
				
			}
			

			
			//SET ONE DEFINITION
			String firstdefinition = myList2.get(1);
			String firstdefinitionOnly1 = firstdefinition.replaceAll(", Definition-1:.*", "");
			String finaldefinitionlol = firstdefinitionOnly1.replaceAll("Definition-0:", "");			
			String finaldefinitionlolagain = finaldefinitionlol.substring(1);
			
			String[] finaldefinitionlolagain3 = finaldefinitionlolagain.split("( [a-z] \\()");

			request.setAttribute("onedefinition", finaldefinitionlolagain3);
			

		
			String finalword = myList2.get(0).replaceAll("Word-[0-9]: ", "");
			String finalwordnobrakers1 = finalword.substring(1);
			String finalwordnobrakers = finalwordnobrakers1.substring(0, finalwordnobrakers1.length()-1);

			String[] finalwordlol2 = finalwordnobrakers.split(",");
			ArrayList<String> test = new ArrayList<String>(Arrays.asList(finalwordlol2));
			String oneword = test.get(0);
			request.setAttribute("firstword1", oneword);
			test.remove(0);
			
			request.setAttribute("resultsw", test);		
		
		
		
		
			String finaldefinitions = myList2.get(1);
			//	foo.add(finaldefinitions);
			//	foo.remove(0);
			//	String[] testing = myList2.get(1).toArray
				String asdasdasdasd = finaldefinitions.substring(1);
				String asopdiujasdmn = asdasdasdasd.substring(0, asdasdasdasd.length()-1);

				String[] finaldefinitionsarray = asopdiujasdmn.split("Definition-[0-9]: ");
				
				ArrayList<String> testdefinitions = new ArrayList<String>(Arrays.asList(finaldefinitionsarray));
				//String test2 = testdefinitions.remove(0);
				
				
				testdefinitions.remove(1);
				testdefinitions.remove(0);
				request.setAttribute("resultsd", testdefinitions);								// definition	
				request.setAttribute("resultsd2", myList2.get(1));
		
			
			
			
		
				request.setAttribute("resultimgcC", myList2.get(4));						// MERRIAM CAPTION	
				String MerriamImgHack = "http://assets2.merriam-webster.com/mw/static/art/dict/";
				String MerriamMidQ = query;
				String MerriamImg = MerriamImgHack + MerriamMidQ + ".gif";
				request.setAttribute("resultimgcH", MerriamImg);   							// Merriam image 
		
		
		
		
				request.setAttribute("resultsety", myList2.get(2));								// etymology

		
				String audioToString = myList2.get(3).toString();   
				String RemoveSquareBrackets = audioToString.replaceAll("[{}\\[\\]]", "");				
				request.setAttribute("resultsound", RemoveSquareBrackets );					 // sound	
				
				
				
				
		
		
		
		
		request.setAttribute("oneword", query);

		
		request.setAttribute("definitions", definitions);
		
		request.setAttribute("synonyms", synoynms);
		
		request.setAttribute("examples", examples);
		
		

		
	      RequestDispatcher rd=request.getRequestDispatcher("search.jsp");    
	      
	      rd.forward(request,response);    
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
