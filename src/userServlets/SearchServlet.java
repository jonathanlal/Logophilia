package userServlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import database.AddToDatabase;
import userBeans.SearchHistory;
import userBeans.UserBean;
import userBeans.UserErosDao;
import userBeans.WordLists;
import logophilia.*;


@SuppressWarnings("serial")
//@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	

	public SearchServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		//CHECK BOXES
		//String Chkquery = request.getParameter("Chkquery");
//		String Etymology = request.getParameter("Etymology");
//		String Sound = request.getParameter("Sound");
//		String MerriamImage = request.getParameter("MerriamImage");
//		String GoogleImages = request.getParameter("GoogleImages");
//		String multdef = request.getParameter("multdef");
		//String Report = request.getParameter("Report");

	
		
		//get session query instead
		String query = request.getParameter("query");
//		session.setAttribute("querySession", query); 
		
   // 	HttpSession session = (request.getSession());


		
		Merriam merriam = new Merriam();
		
		
		//AddToDatabase addToDB = new AddToDatabase();
		

		
		
		//MerriamFix merriamfix = new MerriamFix();
		String merriamResults = merriam.finalResults(query);
		List<String> myList2 = new ArrayList<String>(Arrays.asList(merriamResults.split("\\^!")));
		
		

		request.setAttribute("iresults", myList2.get(5)); 									// Size of query results
		
		


    	HttpSession session = (request.getSession());

		
       Object username = session.getAttribute("loggedInUser");
		
	
		try{

//			UserBean userbean = new UserBean();
//
//			
			
		//	String username = request.getParameter("testsad");
			
			if(null != username){

		    	session.setAttribute("querySession", query);

		        //String username = session.getAttribute("loggedInUser").toString();
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
			
			

		       
		    //   session.setAttribute("rank", rank);
		 

				
				
				
				//String username = session.getAttribute("loggedInUser").toString();
				//UserBean userbean = new UserBean();
//				userbean.addEros(username);
				
				
				
//				String username = session.getAttribute("LoggedInUser").toString();
//			
//				userbean.addEros(session.getAttribute("LoggedInUser").toString());
//				
//				
//			}
//			String username = session.getAttribute("LoggedInUser").toString();
//
//			userbean.addEros(session.getAttribute("LoggedInUser").toString());

		
				//DEFAULT RESULTS
//			if(username.isEmpty()){
//			UserBean userbean = new UserBean();
//			userbean.addEros(username);
//			}
			
			// SET ONE WORD
			//String firstword = myList2.get(0).substring(0, 32); //.replaceAll(chill, ""); //.substring(0, 21);
			//String finalfirstword = firstword.replaceAll("(\\,|\\[).*", "");  //.split("([^[]+)", 0); //  .replaceAll("([^[]+)", "");
			request.setAttribute("oneword", query); // lol bypass with query
			
			//SET ONE DEFINITION
			String firstdefinition = myList2.get(1);
			String firstdefinitionOnly1 = firstdefinition.replaceAll(", Definition-1:.*", "");
			String finaldefinitionlol = firstdefinitionOnly1.replaceAll("Definition-0:", "");			
			String finaldefinitionlolagain = finaldefinitionlol.substring(1);
			
		//	String[] finaldefinitionlolagain2 = finaldefinitionlolagain.split("\\(([^\\)]+)\\)");
			
			String[] finaldefinitionlolagain3 = finaldefinitionlolagain.split("( [a-z] \\()");

			
		//	String[] finalfinal = finaldefinitionlolagain3
			
			//StringBuffer sbf = new StringBuffer(finaldefinitionlolagain);
			
			
			
			
			request.setAttribute("onedefinition", finaldefinitionlolagain3);
			
			
			
			
			
//			String[] firstdefinitionFormatted = myList2.get(1).split(":\\s");
//			String[] firstdefinitionFormatted2 = myList2.get(1).split("Definition");
			


			


		
//		if(MerriamImage.contains("MerriamImage")){
				
				

				request.setAttribute("resultimgcC", myList2.get(4));						// MERRIAM CAPTION	
				String MerriamImgHack = "http://assets2.merriam-webster.com/mw/static/art/dict/";
				String MerriamMidQ = query;
				String MerriamImg = MerriamImgHack + MerriamMidQ + ".gif";
				request.setAttribute("resultimgcH", MerriamImg);   							// Merriam image 
				
				
//				return;		
//		}
//		if (GoogleImages.contains("GoogleImages")){
			
			google2 google = new google2();
			String googleResults = google.finalResults(query);
			List<String> myList = new ArrayList<String>(Arrays.asList(googleResults.split("\\s+")));
			request.setAttribute("myList", myList);												//images from google json
			
			
//			return;	
//	}
//			
//		if(Etymology.contains("Etymology")){		
				
			request.setAttribute("resultsety", myList2.get(2));								// etymology
			
//			return;
//		}
//		if(Sound.contains("Sound")){		
			
			String audioToString = myList2.get(3).toString();   
			String RemoveSquareBrackets = audioToString.replaceAll("[{}\\[\\]]", "");				
			request.setAttribute("resultsound", RemoveSquareBrackets );					 // sound	
			
//			return;
//		}		
//		if(multdef.contains("multdef")){		
			
			//String finaldefinitions = myList2.get(1).replaceAll("Definition-[0-9]: ", "");
			//ArrayList<String> foo = new ArrayList<String>();
			
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
			
			
			
			
			
			
			
			
			
			
			
			String finalword = myList2.get(0).replaceAll("Word-[0-9]: ", "");
			//String finalwordlol = finalword.replace("\"", "");
			String finalwordnobrakers1 = finalword.substring(1);
			String finalwordnobrakers = finalwordnobrakers1.substring(0, finalwordnobrakers1.length()-1);

			String[] finalwordlol2 = finalwordnobrakers.split(",");

			
			ArrayList<String> test = new ArrayList<String>(Arrays.asList(finalwordlol2));
			String oneword = test.get(0);
			request.setAttribute("firstword1", oneword);
			test.remove(0);
			
			//			finalwordlol2 = finalwordlol2 finalwordlol2[0];
			//finalwordlol2[1].substring(1);
			
			request.setAttribute("resultsw", test);									// word
	
//			return;
//		}					
		}finally{
			
			//SHUFFLE
			//String shuffle = myList2.get(6);
			request.setAttribute("shuffle", myList2.get(6));
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/DefineWord.jsp");
			dispatcher.forward(request, response);
			
			
		}		
		return;
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
