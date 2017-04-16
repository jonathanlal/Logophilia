package userBeans;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SearchHistory {

	
	
public void addToSearchHistory(String word, String username){


	SearchHistoryDao shdao = new SearchHistoryDao();
	
	
	ArrayList<String> searchedwords = shdao.getSearchedWordsfromDB(username);
	
	
	
	searchedwords.add(word);
	

	String Finalsearches = searchedwords.toString().substring(1);
	
	Finalsearches = Finalsearches.substring(0, Finalsearches.length()-1);
	shdao.addToSearchHistoryfromDB(Finalsearches, username);

	
}

public void ResetSearchHistoryAfterSave(String username){


	SearchHistoryDao shdao = new SearchHistoryDao();
	
	
	ArrayList<String> searchedwords = new ArrayList<String>(Arrays.asList(shdao.getSearchedWordsfromDB(username).toString().split(",")));
	
	searchedwords.remove(searchedwords.size() -1);	
	

	String Finalsearches = searchedwords.toString().substring(1);
	
	Finalsearches = Finalsearches.substring(0, Finalsearches.length()-1);
	shdao.addToSearchHistoryfromDB(Finalsearches, username);

	
}
	
public ArrayList<String> getSearchHistory(String username){
	
	SearchHistoryDao shdao = new SearchHistoryDao();
	
	
   ArrayList<String> searchedwords = new ArrayList<String>(Arrays.asList(shdao.getSearchedWordsfromDB(username).toString().split(",")));

	
	return searchedwords;
	
}
	
	
public void CreateSearchHistory(String username){


	SearchHistoryDao shdao = new SearchHistoryDao();
	
	
	shdao.CreateSearchedWords(username);
	
	
}
	
	
	
}

