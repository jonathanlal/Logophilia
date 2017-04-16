package logophilia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

import userBeans.WordPost;

public class Feed {

	
	public ArrayList<ArrayList<ArrayList<String>>> getMainFeedIndex(){
		
		
		ArrayList<ArrayList<ArrayList<String>>> feedsuperarray = new ArrayList<ArrayList<ArrayList<String>>>();
		ArrayList<ArrayList<String>> feedinfo = new ArrayList<ArrayList<String>>();

		
		
		WordPost wp = new WordPost();
//		HttpSession session = (request.getSession());

		
		ArrayList<ArrayList<String>> wordposts = wp.getAllWordPosts();
		if(wordposts.size() > 0){
		
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
//		ArrayList<String> dislikesSize = new ArrayList<String>();
		ArrayList<ArrayList<String>> arrayception = new ArrayList<ArrayList<String>>();

		

		for(int i=0; i < wordposts.size();i++){
			
			ArrayList<String> wordpost = wordposts.get(i);
			
			wordpostID.add(wordpost.get(0));
			wordpostUserWord.add(wordpost.get(1));
			
			wordpostUserText.add(wordpost.get(2));
			
			
			wordpostUserDefinition.add(wordpost.get(3));  
			wordpostUserImage.add(wordpost.get(4));
			wordpostUserTime.add(wordpost.get(5));
			wordpostUserUser.add(wordpost.get(6));
			if(wordpost.get(7) != null){
			ArrayList<String> likes = new ArrayList<String>(Arrays.asList(wordpost.get(7).split(",")));
			wordpostlikesSize.add(Integer.toString(likes.size()));
			wordpostlikes.addAll(likes);
			}else{
			wordpostlikesSize.add("0");	
			}
			
			if(wordpost.get(8) != null){
			ArrayList<String> comments = new ArrayList<String>(Arrays.asList(wordpost.get(8).split("!X")));
			CommentsSize.add(Integer.toString(comments.size()-1)); // -1 because one extra !X
			comments.remove(0);
			arrayception.add(comments);
			}else{
				CommentsSize.add("0");
				arrayception.add(wordpostComments);

			}
			
		}
		

		
		Collections.reverse(arrayception);	//comments
		Collections.reverse(wordposts);
		
		feedsuperarray.add(arrayception); // comments 0
		feedsuperarray.add(wordposts); // word posts 1
		
		
		Collections.reverse(wordpostID);
		Collections.reverse(wordpostUserUser);
		
		Collections.reverse(wordpostUserTime);
		Collections.reverse(wordpostUserImage);
		Collections.reverse(wordpostUserDefinition);
		Collections.reverse(wordpostUserText);
		Collections.reverse(wordpostUserWord);
		Collections.reverse(CommentsSize);
		Collections.reverse(wordpostlikesSize);
		
		
		
		feedinfo.add(wordpostID); // 0
		feedinfo.add(wordpostUserUser); //1
		
		feedinfo.add(wordpostUserTime); // 2
		feedinfo.add(wordpostUserImage);  // 3
		feedinfo.add(wordpostUserDefinition); // 4
		feedinfo.add(wordpostUserText); // 5
		feedinfo.add(wordpostUserWord); // 6
		feedinfo.add(CommentsSize); //7 
		feedinfo.add(wordpostlikesSize); //8
		
		
		
		feedsuperarray.add(feedinfo); // wordpost info 2
		
		

		}
		


		
		
		
		return feedsuperarray;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
}
