package database;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import logophilia.*;

public class AddToDatabase {

	
	
	public void AddDefinitionfromMerriam(String query) throws IOException{
		
//		WordDatabaseDao wd = new WordDatabaseDao();
//		String definition = getDefinitionfromMerriam(query);
		
		
		
		
		
	}
	
	
	
	
	
	

	
	
	public String getDefinitionfromMerriam(String query) throws IOException{
	
		Merriam m = new Merriam();
	String merriamResults = m.finalResults(query);
	List<String> myList2 = new ArrayList<String>(Arrays.asList(merriamResults.split("\\^!")));
	
	String firstdefinition = myList2.get(1);
	String firstdefinitionOnly1 = firstdefinition.replaceAll(", Definition-1:.*", "");
	String finaldefinitionlol = firstdefinitionOnly1.replaceAll("Definition-0:", "");			
	String finaldefinitionlolagain = finaldefinitionlol.substring(1);
	
	
	return finaldefinitionlolagain;
	
	}
	
	
//	public String getEtymologyfromMerriam(String query) throws IOException{
//		
//		
//		
//		return etymology;
//	}
//	public String getImagefromMerriam(String query) throws IOException{
//		
//		
//		return Merriamimage;
//	}
//				public String getImageCaptionfromMerriam(String query) throws IOException{
//					
//					return MerriamimageCaption;
//					
//				}
//	
	
}
