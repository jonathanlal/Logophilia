package logos;

import java.util.ArrayList;

public class Logophilia {
	
	LogophiliaDao logos = new LogophiliaDao();
	
	public boolean checkIfWordExists(String word){

		return logos.validate(word);
	}
	
	public int getWordID(String word){
		
		return logos.getWordIDInDB(word);
	}

	public void addWord(String word, String date, String username){
		
		logos.AddWordInDB(word,date,username);
		
	}
	
	public void addImage(String image, int wordID, String date, String username){
		
		logos.AddImageInDB(image, wordID, date, username);
	}
	
	public ArrayList<String> getImages(String wordID){
		
		return logos.getImagesDao(wordID);
	}
	
	
	public void addDefinition(String definition, int wordID, String date, String username, String dictionary){
		
		logos.AddDefinitionInDB(definition, wordID, date, username, dictionary);
	}
	
	
	
	
}
