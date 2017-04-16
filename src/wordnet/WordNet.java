package wordnet;

import java.util.ArrayList;

public class WordNet {
	
	WordNetDao wndao = new WordNetDao();
	
//	public int getWordID(String word){
//		
//		return wndao.getWordIDFromDB(word);
//		
//	}
	
	
	public ArrayList<String> getDefinitions(String word){
		
		
		int wordID = wndao.getWordIDFromDB(word);
		
	ArrayList<Integer> ids = wndao.getDefinitionIDsFromDB(wordID);
	ArrayList<String> definitions = new ArrayList<String>();	
	
		for(int i = 0; i < ids.size();i++){
			
			String definition = wndao.getDefinition(ids.get(i));
			definitions.add(definition);
			
			
		}
		
		
		
		return definitions;
		
	}

	public ArrayList<String> getSynoyms(String word) {

		
		int wordID = wndao.getWordIDFromDB(word);
		ArrayList<Integer> synsetIDs = wndao.getFirstSynonymIDFromDB(wordID);
		ArrayList<Integer> wordids = wndao.getSynonymIDsFromDB(synsetIDs);		
		ArrayList<String> synonyms = new ArrayList<String>();
		
		
		for(int i = 0; i < wordids.size();i++){
			
			int wordid = wordids.get(i);
			
			String synonym = wndao.getWord(wordid);
			if(!synonym.equals(word))
			synonyms.add(synonym);
			
			
		}
		
		
		return synonyms;
		
		
		
	}

	public ArrayList<String> getExamples(String word) {


		
		int wordID = wndao.getWordIDFromDB(word);
		
		ArrayList<Integer> synsetIDs = wndao.getFirstSynonymIDFromDB(wordID);
		
		ArrayList<String> examples = new ArrayList<String>();
		
		
		for(int i = 0; i < synsetIDs.size();i++){
			
			int synID = synsetIDs.get(i);
			
			String example = wndao.getExample(synID);
			if(example == null){
			}else if(example.contains(word)){
				
				
				examples.add(example);

				
			}
			
		}
		
		
		return examples;
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
