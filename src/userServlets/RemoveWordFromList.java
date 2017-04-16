package userServlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logos.Logophilia;
import userBeans.SavedWords;
import userBeans.WordLists;


public class RemoveWordFromList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public RemoveWordFromList() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = (request.getSession());
		String username = session.getAttribute("loggedInUser").toString();
		
		String id = request.getParameter("id");
		String type = request.getParameter("type");
		String word = request.getParameter("word");
		

		if(type.contains("w")){
			
			WordLists wl = new WordLists();
			wl.removeWord(word, id);
			
		}
		
		
		
		
		
		
		
		
		
		WordLists ul = new WordLists();
		ArrayList<String> likesUsers;
		int likesSize;
		ArrayList<String> list = ul.getAllFromList(Integer.parseInt(id));	
		
		String name = list.get(0);
		String description = list.get(1);
		String size = list.get(2);
		String likesString = list.get(3);
		
		if(likesString != null){
		likesUsers = new ArrayList<String>(Arrays.asList(likesString.split(",")));
		likesSize = likesUsers.size();
		}else{
		likesUsers = new ArrayList<String>();
		likesSize = 0;
		}

		String creator = list.get(4);		
		String wordsString = list.get(5).replace(" ", ""); // remove spaces from string of words
		ArrayList<String> words = new ArrayList<String>(Arrays.asList(wordsString.split(",")));
		
		String definitionsString = list.get(6).replace("]]", "").replace("[[", "");
		ArrayList<String> definitionsMaster = new ArrayList<String>(Arrays.asList(definitionsString.split("], \\[")));
			ArrayList<ArrayList<String>> definitionsAll = new ArrayList<ArrayList<String>>();		
			for(int i = 0; i < definitionsMaster.size(); i++){
				String replacedSplitChar = definitionsMaster.get(i).replace("], [", "");
				ArrayList<String> definitions = new ArrayList<String>(Arrays.asList(replacedSplitChar.split(",")));
				definitionsAll.add(definitions);
			}
		
		String date2 = list.get(7);
   	String listdate = date2.substring(0, 11);
   	String listtime = date2.substring(12,20);
		
		String imagelist = list.get(8);	
		
		
		
		String comments = list.get(9);
		ArrayList<String> commentsArray = new ArrayList<String>();
		if(comments != null){
		commentsArray = new ArrayList<String>(Arrays.asList(comments.split(" !X ")));
		commentsArray.remove(0);
		}
		  request.setAttribute("commentsArray", commentsArray);
		  request.setAttribute("commentsArraySize", commentsArray.size());

		
		
		SavedWords sw = new SavedWords();
       ArrayList<String> savedwords = sw.getSavedWords(username);
       ArrayList<String> savedwordsArray = new ArrayList<String>();
    	boolean found = false;  	
    	if(savedwords.size()> 0){    	
       for(int i = 0; i < words.size(); i ++){
       	
       	String check = words.get(i);

       	for(int x = 0; x < savedwords.size();x++){
       		
           	if(savedwords.get(x).contains(check)){
           		savedwordsArray.add("yes");
           		found = true;
           	}           	
       	}
       	if(!found){
       		savedwordsArray.add("no");
       	}
       	found = false;
       }        
    	}       
		
		
		  request.setAttribute("SavedWordsListCheck", savedwordsArray);

		  Logophilia logos = new Logophilia();
		  ArrayList<ArrayList<String>> wordimages = new ArrayList<ArrayList<String>>();
		  for(int i = 0; i <words.size();i++){
			  ArrayList<String> images = new ArrayList<String>();
			  int wordID = logos.getWordID(words.get(i));
			  images = logos.getImages(Integer.toString(wordID));
			  wordimages.add(images);
		  }
		  request.setAttribute("wordimagesArray", wordimages);
		  
		
		// for likes getParameters
		request.setAttribute("typelist", "w");
		request.setAttribute("idlist", Integer.parseInt(id));
		request.setAttribute("listname", name);
       request.setAttribute("listdate", listdate);
       request.setAttribute("listtime", listtime);
       request.setAttribute("listcreator", creator);
       request.setAttribute("wordsfromDB", words);
       request.setAttribute("definitionsfromDB", definitionsAll);       
       request.setAttribute("description", description);
       request.setAttribute("listsize", size);               
       request.setAttribute("listimage", imagelist);
       request.setAttribute("listlikesSize", likesSize);
       request.setAttribute("listlikes", likesUsers);

		
		
       RequestDispatcher rd=request.getRequestDispatcher("List.jsp");    
       
       rd.forward(request,response); 
       
		
		
		
		
		
		
		
		
	}

}
