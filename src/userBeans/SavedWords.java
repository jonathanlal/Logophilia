package userBeans;

import java.util.ArrayList;
import java.util.Arrays;

public class SavedWords {

	SavedWordsDao swdao = new SavedWordsDao();

public void setSavedWord(String word, String username){


	
	
	String SavedWords = swdao.getSavedWordsfromDB(username);
	
	
	if(SavedWords.isEmpty()){
		
		SavedWords = SavedWords + word;

	}else{
		
		SavedWords = SavedWords +", "+ word;

	}
	
	

//	String Finalsearches = SavedWords.toString().substring(1);
	
//	Finalsearches = Finalsearches.substring(0, Finalsearches.length()-1);
	swdao.setSavedWordsfromDB(SavedWords, username);

	
}

public void removeSavedWord(String word,String username){
	
	 ArrayList<String> savedwords = getSavedWords(username);
    // savedwordswithbeginning.remove(0); // remove beginning 'X!X' 
//     String savedwordsfinal = savedwordswithbeginning.toString().replaceAll("]", "").substring(1);
//     ArrayList<String> savedwords = new ArrayList<String>(Arrays.asList(savedwordsfinal.split(","))); 
          
 	
 	for(int i = 0; i<savedwords.size(); i ++){
 		
 		if(savedwords.get(i).contains(word)){
 			savedwords.remove(i);
 		}
 	}
 	
 	
	String Finalsearches = savedwords.toString().substring(1);
	
	Finalsearches = Finalsearches.substring(0, Finalsearches.length()-1);
	
	
	swdao.setSavedWordsfromDB(Finalsearches, username);

 	
 	
	
}


public ArrayList<String> getSavedWords(String username){
	
//	SavedWordsDao swdao = new SavedWordsDao();
	
	String savedwordsString = swdao.getSavedWordsfromDB(username);
	ArrayList<String> savedwords = new ArrayList<String>();
	
	if (!savedwordsString.isEmpty()){
	
   savedwords = new ArrayList<String>(Arrays.asList(savedwordsString.split(",")));
	
	
	}
	
	return savedwords;
	
}


public void CreateUserSavedWords(String username){


//	SavedWordsDao swdao = new SavedWordsDao();


	swdao.CreateSavedWords(username);

}

		
	}

