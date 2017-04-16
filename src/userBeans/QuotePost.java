package userBeans;

import java.util.ArrayList;
import java.util.Arrays;

public class QuotePost {
	
	
	
	QuotePostDao qpDao = new QuotePostDao();

	
	public ArrayList<String> getAllQuotePosts(){
//		QuotePostDao qpDao = new QuotePostDao();

		
		return qpDao.getAllQuotePostsinDB();
	}
	
	public ArrayList<String> getLikesQuotePost(String postID){

		String likes = qpDao.getLikesQuotePostInDB(postID);
		
		if(likes != null){
			ArrayList<String> quotepostlikes = new ArrayList<String>(Arrays.asList(likes.split(",")));
			return quotepostlikes;
		}else{
			
			return null;
		}
		
		
		
	}
	
public void addLikeQuotePost(String username, String PostID){
		
		ArrayList<String> likes = getLikesQuotePost(PostID);
		String finallikes = null;
		
		// if likes == null or contains username already...
		if(likes == null || !likes.toString().contains(username)){
			if(likes == null){
				finallikes = username;

			}else{
				likes.add(username);
				finallikes = likes.toString().substring(1);
				finallikes = finallikes.substring(0, finallikes.length()-1);

			}

			qpDao.setLikesQuotePost(finallikes, PostID);
			
		}		
		
	
	}
	
	
	
	
	
	public void createQuotePost(String quote, String author, String usertext, String image, String time, String user){
//		QuotePostDao qpDao = new QuotePostDao();
		qpDao.createQuotePostinDB(quote, author, usertext, image, time, user);	
	}

	
	public ArrayList<String> getQuotePosts(String username){
//		QuotePostDao qpDao = new QuotePostDao();
		
		ArrayList<String> QuotePosts = new ArrayList<String>();
		
		QuotePosts = qpDao.getQuotePostsinDB(username);
		
		
		return QuotePosts;	
	}
		
	public int getTotaltAmountOfQuotePosts(String username){
		
//		QuotePostDao qpDao = new QuotePostDao();

		return qpDao.getTotalAmountOFPOSTSFROMDB(username);
		
	}	
	
	
	public void deleteQuotePostfromDB(String username, String quote){
		
//		QuotePostDao qpDao = new QuotePostDao();

		qpDao.deleteQuotePost(username, quote);
		
	}


	public int getTotaltAmountOfPosts(String username){
		
//		WordPostDao wpDao = new WordPostDao();

		return qpDao.getTotalAmountOFPOSTSFROMDB(username);
		
	}


	public ArrayList<String> getQuotePostByID(String ID) {
		
		return qpDao.getQuotePostinDBByID(ID);
	}


	public void deleteQuotePostfromDB(String postID) {
		
		qpDao.deleteQuotePost(postID);
		
	}	
	
	
	

	
	
	
	

}
