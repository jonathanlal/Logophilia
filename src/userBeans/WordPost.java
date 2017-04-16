package userBeans;

import java.util.ArrayList;
import java.util.Arrays;

public class WordPost {
	
	WordPostDao wpDao = new WordPostDao();

	
	public ArrayList<ArrayList<String>> getAllWordPosts(){

		
		return wpDao.getAllWordPostsinDB();
	}
	
	
	public void createWordPost(String word, String usertext, String definition, String image, String time, String user){
		wpDao.createWordPostinDB(word, usertext, definition, image, time, user);	
	}

	
	public ArrayList<String> getWordPosts(String username){
		
		ArrayList<String> wordposts = new ArrayList<String>();
		
		wordposts = wpDao.getWordPostsinDB(username);
		
		
		return wordposts;	
	}
		
	public int getTotaltAmountOfPosts(String username){
		

		return wpDao.getTotalAmountOFPOSTSFROMDB(username);
		
	}	
	
	
	public void deleteWordPostfromDB(String postID){
		

		wpDao.deleteWordPost(postID);
		
	}


	public ArrayList<String> getWordPostByID(String iD) {
		

		// TODO Auto-generated method stub
		return wpDao.getWordPostinDBByID(iD);
	}
	
	
	
	public ArrayList<String> getLikesWordPost(String postID){

		String likes = wpDao.getLikesWordPostInDB(postID);
		
		if(likes != null){
			ArrayList<String> wordpostlikes = new ArrayList<String>(Arrays.asList(likes.split(",")));
			return wordpostlikes;
		}else{
			
			return null;
		}
		
		
		
	}
	
	
	public void addLikeWordPost(String username, String PostID){
		
		ArrayList<String> likes = getLikesWordPost(PostID);
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

			wpDao.setLikesWordPost(finallikes, PostID);
			
		}		
		
	
	}


	public String getwordpostID(String username, String postID) {
		String id = wpDao.getwordPostIDDB(username, postID);

			

				return id;
	}
	
	
	
//	
//	
//	public void EditUserTxtWordPost(String word, String usertext, String definition, String image, String time, String user){
//		
//		WordPostDao wpDao = new WordPostDao();
//		
//		
//		wpDao.editusertxtwordpostinDB(word, usertext, definition, image, time, user);
//		
//		
//	}
	
	

}
