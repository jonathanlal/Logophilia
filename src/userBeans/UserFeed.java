package userBeans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class UserFeed {
	

	UserFeedDao ufdao = new UserFeedDao();
	
	public void initializeFeed(String username){
		
		ufdao.createUserFeedRecord(username);
		
	}
	
	
	public ArrayList<String> createFeedArray(String username){
		
		ArrayList<String> resultsArray = new ArrayList<String>();

		String feedID = ufdao.getFeedIDDB(username);
		String feedType = ufdao.getFeedTypeDB(username);
		
		
		ArrayList<String> postid = new ArrayList<String>(Arrays.asList(feedID.split(",")));
		ArrayList<String> posttype = new ArrayList<String>(Arrays.asList(feedType.split(",")));
		
		for(int i = 0; i < postid.size();i++){
			
			resultsArray.add(postid.get(i));
			resultsArray.add(posttype.get(i));
			
			
		}
		
		
		return resultsArray;
		
	}
	
	
	
	public void addToFeed(String postid, String type, String username){
		String feedID = ufdao.getFeedIDDB(username);
		String feedType = ufdao.getFeedTypeDB(username);
		
		
		
		
		if(feedID.isEmpty() || feedID == null){
			String addFeedID =  postid;
			String addFeedType = type;			
			ufdao.addToFeedDB(addFeedID, addFeedType, username);	
		}else{
		
		//ArrayList<String> feedid = ufdao.getFeedIDDB(username);
		//ArrayList<String> feedtype = ufdao.getFeedTypeDB(username);
			ArrayList<String> ArrayFeedID = new ArrayList<String>(Arrays.asList(feedID.split(",")));
			ArrayList<String> ArrayFeedType = new ArrayList<String>(Arrays.asList(feedType.split(",")));
			
			ArrayFeedID.add(postid);
			ArrayFeedType.add(type);
			
		
//		String addFeedID = feedID + postid;
//		String addFeedType = feedType + type;
		
//		ufdao.addToFeedDB(addFeedID, addFeedType, username);
		refreshFeed(ArrayFeedID, ArrayFeedType, username);
		

		
		}

		
	}
	
	public void refreshFeed(ArrayList<String> feedID, ArrayList<String> feedType, String username){
		
		String feedIDString = feedID.toString();
		String feedTypeString = feedType.toString();
		
		
		ufdao.addToFeedDB(feedIDString.substring(1, feedIDString.length()-1), feedTypeString.substring(1, feedTypeString.length()-1), username);
		
		
	}
	public void nullFeed(String username){

		ufdao.nullUserFeed(username);
		
	}
	
	
	
	public ArrayList<String> getFeed(String username){
		
		
		return ufdao.getFeedDB(username);
	}
	

	public int getQuotePostID(String username){
		
		return ufdao.getQuoteID(username);
	}
	public int getWordPostID(String username){
		
		return ufdao.getWordID(username);
	}
	
	public ArrayList<String> feedID(String username){
	
		String feedID = ufdao.getFeedIDDB(username);	
		
//		if(feedID.contains("w") || feedID.contains("q")){
		
		ArrayList<String> postid = new ArrayList<String>(Arrays.asList(feedID.split(","))); // remove last comma 
		
		
			return postid;
			
//		}else{
//			 ArrayList<String> test = new ArrayList<String>();
//			
//			return test;
//			
//		}
		
			
	}
	
	public ArrayList<String> feedType(String username){
		
		String feedType = ufdao.getFeedTypeDB(username);
		ArrayList<String> posttype = new ArrayList<String>(Arrays.asList(feedType.split(",")));
		
		
			return posttype;
	}
	public ArrayList<ArrayList<ArrayList<String>>> getMainFeedByUser(String username){
		
		ArrayList<ArrayList<ArrayList<String>>> feedsuperarray = new ArrayList<ArrayList<ArrayList<String>>>();

		ArrayList<ArrayList<String>> feed = new ArrayList<ArrayList<String>>();
		
		
		
		 UserFeed uf = new UserFeed();

			QuotePost qp = new QuotePost();

			WordPost wp = new WordPost();
	        

	        
	        ArrayList<String> idFeedArray = uf.feedID(username);
			 ArrayList<String> typeFeedArray = uf.feedType(username);
//			 
//			Collections.reverse(idFeedArray);
//			 Collections.reverse(typeFeedArray);

			 	ArrayList<String> WordOrQuotePostID = new ArrayList<String>();
				ArrayList<String> WordOrQuotePost = new ArrayList<String>();
//				ArrayList<ArrayList<String>> DefinitionOrAuthorPost = new ArrayList<ArrayList<String>>();
				ArrayList<String> DefinitionOrAuthorPost = new ArrayList<String>();

				ArrayList<String> usertextpost = new ArrayList<String>();
				ArrayList<String> imagepost = new ArrayList<String>();
				ArrayList<String> timepost = new ArrayList<String>();
				ArrayList<String> userpost = new ArrayList<String>();
				ArrayList<String> comments = new ArrayList<String>();
				ArrayList<String> likes = new ArrayList<String>();
				ArrayList<String> words = new ArrayList<String>();
//				ArrayList<Integer> commentsArrayIndex = new ArrayList<Integer>();
				
				if(idFeedArray.size() > 0 && !idFeedArray.isEmpty()){
				
				for(int i = 0; i < idFeedArray.size();i++){
					 
					 String ID = idFeedArray.get(i);
					 String Type = typeFeedArray.get(i);

					 if(Type.contains("w")){
						 
						 ArrayList<String> WordPost = wp.getWordPostByID(ID); 	
//							Collections.reverse(WordPost);

						 
						// if(WordPost.size() > 1){ // for when the user has no posts 
						 
						 WordOrQuotePostID.add(WordPost.get(0).replace("[", ""));
//						 	WordPost.remove(0);
				
								WordOrQuotePost.add(WordPost.get(1));		
								words.add(WordPost.get(1));		
//								ArrayList<String> definitions = new ArrayList<String>(Arrays.asList(WordPost.get(2).split(", ")));

								DefinitionOrAuthorPost.add(WordPost.get(2));					
								usertextpost.add(WordPost.get(3));  
								imagepost.add(WordPost.get(4));
								timepost.add(WordPost.get(5));
								userpost.add(WordPost.get(6));
								
								likes.add(WordPost.get(7));
								comments.add(WordPost.get(8).replace("]", ""));	
								
//								commentsArrayIndex.add(i);
								
//								 session.setAttribute("WordPostv", WordPost);
						// }
					 }
					 
					 if(Type.contains("q")){
						 
						 ArrayList<String> QuotePost = qp.getQuotePostByID(ID); 

						// if(QuotePost.size() > 1){ // for when the user has no posts 

//						 session.setAttribute("WordPostv2", QuotePost);
						 	// get ID 
						 	WordOrQuotePostID.add(QuotePost.get(0).replace("[", ""));

						 	WordOrQuotePost.add(QuotePost.get(1));	
						 	
						 	words.add("null");	// ??? for saved words check? 
						 	
							usertextpost.add(QuotePost.get(2));  
						 	
							DefinitionOrAuthorPost.add(QuotePost.get(3));	
							
					
							imagepost.add(QuotePost.get(4));
							
							timepost.add(QuotePost.get(5));
							
							userpost.add(QuotePost.get(6));	
							
							likes.add(QuotePost.get(7));
							comments.add(QuotePost.get(8).replace("]", ""));	
						// }
					 }

				 											} 
		
	 			ArrayList<String> likesArraySize = new ArrayList<String>();
	 			for(int i = 0; i < likes.size(); i ++){
	 				if (likes.get(i) != null){
	 		ArrayList<String> likesSizes = new ArrayList<String>(Arrays.asList(likes.get(i).split(",")));
	 			likesArraySize.add(Integer.toString(likesSizes.size()));
	 				}else{
	 					likesArraySize.add("0");
	 					
	 				}
	 			}
	 			
	 			ArrayList<ArrayList<String>> arrayception = new ArrayList<ArrayList<String>>();
	 			for(int i = 0; i < comments.size(); i ++){
	 				ArrayList<String> commentsArrayID = new ArrayList<String>(Arrays.asList(comments.get(i).split(" !X ")));
	 				commentsArrayID.remove(0);
	 				arrayception.add(commentsArrayID);				
	 			}
				
				Collections.reverse(WordOrQuotePostID);
				Collections.reverse(userpost);
		    	Collections.reverse(timepost);
		    	Collections.reverse(imagepost);
		    	Collections.reverse(DefinitionOrAuthorPost);
		    	Collections.reverse(usertextpost);
		    	Collections.reverse(WordOrQuotePost);
				Collections.reverse(idFeedArray);
				Collections.reverse(typeFeedArray);
				
				
				Collections.reverse(likesArraySize);
				
				Collections.reverse(arrayception); // comments lol

				

				
				
		feed.add(WordOrQuotePostID); //0
		feed.add(WordOrQuotePost); //1
		feed.add(DefinitionOrAuthorPost); //2
		feed.add(usertextpost); //3
		feed.add(imagepost); //4
		feed.add(timepost); //5
		feed.add(userpost); //6
//		feed.add(commentsArrayIndex);
		feed.add(likesArraySize); //7
		feed.add(idFeedArray); //8
		feed.add(typeFeedArray); //9
		
		

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
        
        
        
        Collections.reverse(savedwordsArray);
        
        feed.add(savedwordsArray); // 10
		
        
        
		
		feedsuperarray.add(feed); // add 0
		
		feedsuperarray.add(arrayception); // add 1
		
		
        
        
        
        
        
		
		
	}
				return feedsuperarray;
	}
	
	
	
}
