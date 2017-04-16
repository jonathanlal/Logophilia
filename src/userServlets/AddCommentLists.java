package userServlets;

import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import userBeans.PostComment;
import userBeans.SavedWords;
import userBeans.UserNotifications;
import userBeans.WordLists;

/**
 * Servlet implementation class AddCommentLists
 */
public class AddCommentLists extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCommentLists() {
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
		
		String comment = request.getParameter("comment");
		
		String postID = request.getParameter("postID");
		
		String postUser = request.getParameter("postUser");
		
		String postType = request.getParameter("type");
		
				
        Date creationTime = new Date(session.getCreationTime() );
        DateFormat formatter = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM);
        
        String postDate = formatter.format(creationTime).toString();
        
       PostComment pc = new PostComment();
       

       if (postType.contains("w")){
       
       // add date to comment? 
        pc.AddWordListComment(postID, username, postDate, comment);

        // send notification
		if(postUser != username){
        UserNotifications un = new UserNotifications();
        
        String notification = username + " commented on your wordlist. +2 Eros";
		
		un.addNotification(postUser, notification, postDate, "not implemented");
		}
		
		
       }
       if(postType.contains("q")){
    	   
           // add date to comment? 
           pc.AddQuoteListComment(postID, username, postDate, comment);

           // send notification
   		if(postUser != username){
           UserNotifications un = new UserNotifications();
           
           String notification = username + " commented on your quotelists. +2 Eros";
   		
   		un.addNotification(postUser, notification, postDate, "not implemented");
   		}
    	   
       }
       
       
       
       
       
       
       
		WordLists ul = new WordLists();
		ArrayList<String> likesUsers;
		int likesSize;
		ArrayList<String> list = ul.getAllFromList(Integer.parseInt(postID));	
		
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
		
		String date = list.get(7);
   	String listdate = date.substring(0, 11);
   	String listtime = date.substring(12,20);
		
		String image = list.get(8);	
		
		
		
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

		
		
		// for likes getParameters
		request.setAttribute("typelist", "w");
		request.setAttribute("idlist", Integer.parseInt(postID));
		request.setAttribute("listname", name);
       request.setAttribute("listdate", listdate);
       request.setAttribute("listtime", listtime);
       request.setAttribute("listcreator", creator);
       request.setAttribute("wordsfromDB", words);
       request.setAttribute("definitionsfromDB", definitionsAll);       
       request.setAttribute("description", description);
       request.setAttribute("listsize", size);               
       request.setAttribute("listimage", image);
       request.setAttribute("listlikesSize", likesSize);
       request.setAttribute("listlikes", likesUsers);

		
		
       RequestDispatcher rd=request.getRequestDispatcher("List.jsp");    
       
       rd.forward(request,response); 
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
	}

}
