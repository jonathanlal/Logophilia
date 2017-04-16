package userBeans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import logophilia.Merriam;

public class QuoteLists {
	
	QuoteListsDao qldao = new QuoteListsDao();
	
	
  public void CreateList(String listname, String date, String description, String username, ArrayList<String> quotesArray, ArrayList<String> authorsArray, String imageURL) throws IOException{
		  
	
			int listSize = quotesArray.size();
			
 
			 String StringofQuotes = quotesArray.toString();
			 String StringofAuthors = authorsArray.toString();
			  
			 qldao.createUserList(listname, date, description, listSize, username, StringofQuotes, StringofAuthors);

			  
		  
			    
		  
	  }
	
  public boolean checkIfListExists(String listname){
	  
	  
		 boolean test = qldao.checkifListNameExists(listname);
		  
		  return test;
	  }

  public void setListImage(String image,String listname){
	  
	  qldao.setImageofListfromDB(image, listname);
  }
	
	
  public ArrayList<String> getListSizes(String username){
	  
	  return qldao.getsizeofListfromDBUSERNAME(username);
  }
  
  public ArrayList<String> getUserLists(String username) throws IOException{
	  
	  return qldao.getLists(username);
	  
	  
  }

public void addLikeQuoteList(String username, String postID) {

	ArrayList<String> likes = getLikesQuoteList(postID);
	String finallikes = null;
	
	if(likes == null || !likes.toString().contains(username)){
		if(likes == null){
			finallikes = username;

		}else{
			likes.add(username);
			finallikes = likes.toString().substring(1);
			finallikes = finallikes.substring(0, finallikes.length()-1);

		}

		qldao.setLikesQuoteList(finallikes, postID);
		
	}		
	
	

}
public ArrayList<String> getLikesQuoteList(String postID){

	String likes = qldao.getLikesQuoteListInDB(postID);
	
	if(likes != null){
		ArrayList<String> wordlistlikes = new ArrayList<String>(Arrays.asList(likes.split(",")));
		return wordlistlikes;
	}else{
		
		return null;
	}
	
	
	
}

public ArrayList<String> getAllFromList(int listID) {
	
	return qldao.getAllFromList(listID);
}

public ArrayList<ArrayList<String>> getListInfoProfile(String username) {
	  return qldao.getListInfoProfile(username);

}


	
	
	
	
	
	
	
	
	
	

}
