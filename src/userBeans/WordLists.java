package userBeans;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

import logophilia.*;
import wordnet.WordNet;

public class WordLists {
	
	 ArrayList<String> UserListsFromUserFile = new ArrayList<String>();
	 ArrayList<String> UserListsFromUserFile2 = new ArrayList<String>();
	 
		ArrayList<String> definitionsList;


		  WordListsDao uldao = new WordListsDao();

	  ArrayList<String> UserLists = new ArrayList<String>();
	  ArrayList<String> UserListsURL = new ArrayList<String>();
	public File folder = new File("C:/Users/jonathanlal/workspace/jonaProjects/Logophilia/WebContent/word_lists");
	   String temp = "";
	  

   
	  
	  
	  
	  public ArrayList<String> getUserLists(String username) throws IOException{
		
		  //  ArrayList<String> lists = new ArrayList<String>();
		  
		  
		  
		 // lists = WordListsDao.getUserListsFromDB(username);
		  
		  //single out user records from database

			
			//READ FILE
		  
//					File f = null;	
//					String directoryAbsolute = "C:/Users/jonathanlal/workspace/jonaProjects/Logophilia/WebContent/userfiles";
//					//f = new File(user+"_testlist.txt");
//
//					File DefaultLists = new File(directoryAbsolute + File.separator + username + File.separator + "lists" + File.separator + username+".txt");
//
//					//File fileSaveDir = new File(directoryAbsolute + File.separator + f);
//					FileInputStream fis = new FileInputStream(DefaultLists);
//					 
//
//					BufferedReader br = new BufferedReader(new InputStreamReader(fis));
//				 
//					String line = null;
//					while ((line = br.readLine()) != null) {
//					
//						lists.add(line);
//					}
//				 
//					br.close();
//					
					
		  
	     // String userlists = WordListsDao.getLists(username);
//	        ArrayList<String> wordsArrayList = new ArrayList<String>(Arrays.asList(newlistofwords.split(" !x!,")));
	       //ArrayList<String> userlistsarray = new ArrayList<String>(Arrays.asList(userlists));
		  
		 //lists = WordListsDao.getLists(username);
		  
		  
		  
		  
		  return uldao.getLists(username);
		  
		  
	  }
	  
	  public ArrayList<String> getListDefinitions(String listname){
		  
		  
		  return uldao.getDefinitionsfromDB(listname);
		  
		  
		  
	  }
	  public ArrayList<String> getListWords(String listname){
		  
		  
		  return uldao.getwordsfromDB(listname);
		  
		  
		  
	  }
	
	  
	  
	  
	  public int getListSize(String listname){
		  
		  
		  return uldao.getsizeofListfromDB(listname);
		  
		  
		  
	  }
	  public String getListDescription(String listname){
		  
		  
		  return uldao.getDescriptionofListfromDB(listname);
		  
		  
		  
	  }
	
		
	  
	  public String getListImage(String listname){
		  
		  
		  return uldao.getImageofListfromDB(listname);
	  }

	  public boolean checkIfListExists(String listname){
		  
		  
		 boolean test = uldao.checkifListNameExists(listname);
		  
		  return test;
	  }
	  public void setCreationDateOfList(String date, String listname){
		
		  
		  uldao.SetCreationDateList(date, listname);
	  }
	  public String getCreatorOfList(String listname){
		  
		  
		  return uldao.getListCREATORfromDB(listname);
	  }
	  
	  
	  
	  
		public String getListCreationDate(String name) {
			
			return uldao.getCreationDateofList(name);
		}
		
	  
	  
	  public ArrayList<String> getListSizes(String username){
		  
		  return uldao.getsizeofListfromDBUSERNAME(username);
	  }
	  public ArrayList<ArrayList<String>> getListInfoProfile(String username){
		  
		  
		  return uldao.getListInfoProfile(username);
	  }
	  
	  
	  
	  public int getTotalAmountofLists(String username){
		  
		  return uldao.getTotalAmountOFLISTSFROMDB(username);
	  }
	  
	  
	  //---------------------------------------------------------------------EDIT DESC, NAME, WORDS, IMAGE >>
		public void setListDescription(String description, int id) {
			
			uldao.setDescriptionofListDB(description, id);
			
		}
		
		
		public void setListName(String newname, String name) {
			uldao.setListNameinDB(newname, name);
			
		}
		
		public void setListwords(ArrayList<String> words, String name) throws IOException {
			
			
			
			
			  
			
				 String StringofWords = words.toString();
				  

				 uldao.setListWordsinDB(StringofWords, name);			  
	
		
	
			
			
		}
		
		public ArrayList<String> getAllFromList(int id){
			
			return uldao.getAllFromList(id);
			
		}
		
//		public void AddWordToList(String word, String listname) throws IOException {
//			
//			
//			
//			ArrayList<String> listwordsresults = getListWords(listname);
//			
//			
//			  
//			String listwordsString = listwordsresults.toString();
//			String listwordsString2 = listwordsString.replaceAll("\\[", "").replaceAll("\\]","");
//			
//			ArrayList<String> listwords = new ArrayList<String>(Arrays.asList(listwordsString2.split(",")));
//			
//			listwords.add(word);
//			
//			int size = listwords.size();
//			
//			try{
//		    	setListwords(listwords, listname);
//		    	setListSize(size, listname);
//
//			}finally{
//		    	setListDefinitions(listwords, listname);
//			}
//		
//	}
		public void setListDefinitions(ArrayList<String> words, String name) throws IOException {
			  WordListsDao uldao2 = new WordListsDao();

			  try{

		  ArrayList<String> definitions = new ArrayList<String>();

		  for(int i=0;i<words.size();i++){
			
					Merriam merriam = new Merriam();

				 definitions.add(merriam.getDefinition(words.get(i)).concat(" !x!"));

			
				  
			  }
			  
				 String StringofDefinitions = definitions.toString();

				 uldao2.setListDefinitionsinDB(StringofDefinitions, name);
			  
			  }catch (IndexOutOfBoundsException e) {
				  e.printStackTrace();
			}
		
	
			
			
		}
		
		public void setListSize(int size, String name) throws IOException {
			
	
		//	int listsize = uldao.getsizeofListfromDB(name);
			
				 uldao.setListSizeinDB(size, name);
			  
		
			
			
		}
		
		  public void setListImage(String image,String listname){
			  
			  uldao.setImageofListfromDB(image, listname);
		  }
		  
		

		
	
	  
	  //-----------------------------------------------------------------LIKES & DISLIKES
	  
	  public void setListdisLikes(String usernames,String listname){
		  
		  uldao.AddLikeListtoDB(usernames, listname);
	  }
	  public void setListLikes(String usernames,String listname){
		  
		  uldao.AddDislikeListtoDB(usernames, listname);
	  }
	  
//  --------------------------------------------------------------
	  public ArrayList<String> getListLikes(String listname){
		  
		  return uldao.GetLikesListtoDB(listname);
	  }
	  public ArrayList<String> getListDislikes(String listname){
		  
		  return uldao.GetDislikesListtoDB(listname);
	  }
	  
	  
		//  --------------------------------------------------------------DELETE LIST
	  
	  public void DeleteList(String listname){
		  
		  
		  
		  uldao.DeleteListFromDB(listname);
	  }
	  
	 
	  
		//  --------------------------------------------------------------CREATE LIST
	  
	  public void CreateList(String listname, String date, String description, String username, ArrayList<String> words, String image) throws IOException{
		  
		  
		  
		  
		  try{

	  ArrayList<String> definitions = new ArrayList<String>();

			
			int listSize = words.size();
			
		  
		  
		  for(int i=0;i<words.size();i++){

				Merriam merriam = new Merriam();

			 definitions.add(merriam.getDefinition(words.get(i)).concat(" !x!"));
  
			  
		  }
		  
			 String StringofWords = words.toString();
			 String StringofDefinitions = definitions.toString();
			  
			 uldao.createUserList(listname, date, description, listSize, username,  StringofWords, StringofDefinitions, image);

			  
		  
		  }catch (IndexOutOfBoundsException e) {
			  e.printStackTrace();
		}
			    
		  
	  }
	  
	  public void CreateListWordNet(String listname, String date, String description, String username, String words, String image) throws IOException{

		  
			ArrayList<String> wordsArray = new ArrayList<String>(Arrays.asList(words.trim().split(",")));
			
			int listSize = wordsArray.size();

		  
			ArrayList<ArrayList<String>> Alldefinitions = new ArrayList<ArrayList<String>>();
			
			WordNet wn = new WordNet();
			
			for(int i = 0; i < listSize;i++){
				
				ArrayList<String> definitions = new ArrayList<String>();
				
				definitions = wn.getDefinitions(wordsArray.get(i).replace(" ", ""));
				Alldefinitions.add(definitions);
				
				
			}
			
			 String StringofWords = words.toString();
			 String StringofDefinitions = Alldefinitions.toString();

			 uldao.createUserList(listname, date, description, listSize, username,  StringofWords, StringofDefinitions, image);
		  
	  }
	  
	  
	  public void UpdateListWordNet(String listid,String words, int size) throws IOException{

		  
			ArrayList<String> wordsArray = new ArrayList<String>(Arrays.asList(words.trim().split(",")));
			
			int listSize = wordsArray.size();

		  
			ArrayList<ArrayList<String>> Alldefinitions = new ArrayList<ArrayList<String>>();
			
			WordNet wn = new WordNet();
			
			for(int i = 0; i < listSize;i++){
				
				ArrayList<String> definitions = new ArrayList<String>();
				
				definitions = wn.getDefinitions(wordsArray.get(i).replace(" ", ""));
				Alldefinitions.add(definitions);
				
				
			}
			
			 String StringofWords = words.toString();
			 String StringofDefinitions = Alldefinitions.toString();

			 uldao.updateUserList(Integer.parseInt(listid), size, StringofWords, StringofDefinitions);
		  
	  }
	  
	  
	  
	  
	  
// public void CreateList(String listname, String description, String username, ArrayList<String> words, String nodefs) throws IOException{
//		  
//		  
//		  
//		  
//		  try{
//
//	  ArrayList<String> definitions = new ArrayList<String>();
//
//			
//			int listSize = words.size();
//			
//		  
//		  
//		  for(int i=0;i<words.size();i++){
//
//				//Merriam merriam = new Merriam();
//
//			 definitions.add(" !x!");
//  
//			  
//		  }
//		  
//			 String StringofWords = words.toString();
//			 String StringofDefinitions = definitions.toString();
//			  
//			 uldao.createUserList(listname, description, listSize, username,  StringofWords, StringofDefinitions);
//
//			  
//		  
//		  }catch (IndexOutOfBoundsException e) {
//			  e.printStackTrace();
//		}
//			    
//		  
//	  }
	  

	
	  
//  --------------------------------------------------------------	//  --------------------------------------------------------------	//  --------------------------------------------------------------
	  
	  
	  // SERVER STUFF
	  
	
	
	  public String userfiles(File folder) {

		    for (final File fileEntry : folder.listFiles()) {
		    	
		      if (fileEntry.isDirectory()) {
		    	  userfiles(fileEntry);
		        
		      } else {
		    	  
		        if (fileEntry.isFile()) {
		        	
		          temp = fileEntry.getName();
		          if ((temp.substring(temp.lastIndexOf('.') + 1, temp.length()).toLowerCase()).equals("txt")){
		            UserLists.add(fileEntry.getName());
		          

		          }
		        }

		      }
		    }
			return UserLists.toString();
		  }
	  
	  
	  
	  public String userfilesURL(File folder) {

		    for (final File fileEntry : folder.listFiles()) {
		    	
		      if (fileEntry.isDirectory()) {
		    	  userfiles(fileEntry);
		        
		      } else {
		    	  
		        if (fileEntry.isFile()) {
		        	
		          temp = fileEntry.getName();
		          if ((temp.substring(temp.lastIndexOf('.') + 1, temp.length()).toLowerCase()).equals("txt")){
		        	  //UserListsURL.add(fileEntry.getName());
		            UserListsURL.add(folder.getAbsolutePath()+ "\\" + fileEntry.getName());

		          }
		        }

		      }
		    }
			return UserListsURL.toString();
		  }
	  


	public void editlist(String newname, String description, ArrayList<String> wordsArrayList,
			int listsize, String name) throws IOException {

       	setListName(newname, name);
   
//    	setListDescription(description, name);
    
    	setListwords(wordsArrayList, name);
    	
    	setListDefinitions(wordsArrayList, name);
    	
    	setListSize(listsize, name);
    	
		
		
	}

	
	public void editlist(String newname, String imageURL, String description, ArrayList<String> wordsArrayList,
			int listsize, String name) throws IOException {


		

       	setListName(newname, name);
       
       
    	setListImage(imageURL, name);
    	
    	
//    	setListDescription(description, name);
    	
    	
    	
    	
    	setListwords(wordsArrayList, name);
    	
    	setListDefinitions(wordsArrayList, name);
    	
    	setListSize(listsize, name);
    	
		
		
	}

	
	

	

	public void editlistdefinitions(ArrayList<String> wordsArrayList, String listname) throws IOException {


		

       //	setListName(newname, name);
       
       
    	//setListImage(imageURL, name);
    	
    	
    	//setListDescription(description, name);
    	
    	
    	
    	
    	//setListwords(wordsArrayList, name);
		
		int listsize = wordsArrayList.size();
    	
    	setListDefinitions(wordsArrayList, listname);
    	
    	setListSize(listsize, listname);
    	setListwords(wordsArrayList, listname);

		
		
	}
	  
	  public String AddListToUserDirectory(String user, String filename)throws IOException{

		  
		  
		  

			
			//READ FILE
	
					String directoryAbsolute = "C:/Users/jonathanlal/workspace/jonaProjects/Logophilia/WebContent/userfiles";

					File DefaultLists = new File(directoryAbsolute + File.separator + user + File.separator + "lists" + File.separator + user+".txt");

					FileInputStream fis = new FileInputStream(DefaultLists);
					 

					BufferedReader br = new BufferedReader(new InputStreamReader(fis));
				 
					String line = null;
					while ((line = br.readLine()) != null) {
					
						UserListsFromUserFile.add(line);
					}
				 
					br.close();
					
					
				// WRITE TO FILE NEW LIST	
					if (!DefaultLists.exists()) {
					UserListsFromUserFile.add(filename);
					DefaultLists.createNewFile();
//					FileWriter fw = new FileWriter(DefaultLists.getAbsoluteFile());
//					BufferedWriter bw = new BufferedWriter(fw);
					
//					for(int i=1;i <= UserListsFromUserFile.size();i++ ){
//						bw.write(UserListsFromUserFile.get(i));
//						bw.newLine();
//						
//					}
					//bw.write(filename);
					//bw.newLine();
//					bw.close();
					
					}

try{
		  
	
	
	
	
			//READ AGAIN
			//FileInputStream fis2 = new FileInputStream(fileSaveDir);
			 

			BufferedReader br2 = new BufferedReader(new InputStreamReader(fis));
		 
			String line2 = null;
			while ((line2 = br2.readLine()) != null) {
			
				UserListsFromUserFile2.add(line2);
			}
		 
			br2.close();
			
			
			
			
			
			

			
			
			
			} catch (FileNotFoundException e) {

				e.printStackTrace();
			} catch (IOException e) {
			
				e.printStackTrace();
			}


	  
		  
	//	  userliststest.
		  
		return UserListsFromUserFile2.toString();
		  
		  
	  }
	  
	  
	  
	  
	  
	  
	  
	  
	  public String userfilesfromuserfile(String user) throws IOException {
	File f = null;	
	String directoryAbsolute = "C:/Users/jonathanlal/workspace/jonaProjects/Logophilia/WebContent/userfiles" + File.separator + user + File.separator + "lists";
	f = new File(user+".txt");

	
	File fileSaveDir = new File(directoryAbsolute + File.separator + f);
	if (!fileSaveDir.exists()) {

		String content = "100WordsMiddleSchool.txt"  + "\n" + 	"1500_GREWordList.txt"		 + "\n" + 	"2500_WholeAlphabetSATWords.txt"	 + "\n" + 	"300SATWords2.txt"	 + "\n" + 	"350_GREHighFrequencyWords.txt";
		fileSaveDir.createNewFile();
//		FileWriter fw = new FileWriter(fileSaveDir.getAbsoluteFile());
//		BufferedWriter bw = new BufferedWriter(fw);
//		bw.write(content);
//		bw.close();

	
	}
	
				// THIS PART BELOW IS IMPORTANT
	try{
	FileInputStream fis = new FileInputStream(fileSaveDir);
	 

	BufferedReader br = new BufferedReader(new InputStreamReader(fis));

	String line = null;
	while ((line = br.readLine()) != null) {
	
		UserListsFromUserFile.add(line);
	}

	br.close();
	} catch (FileNotFoundException e) {

		e.printStackTrace();
	} catch (IOException e) {
	
		e.printStackTrace();
	}
	return UserListsFromUserFile.toString();
	}

	public void addLikeWordList(String username, String postID) {
		
		ArrayList<String> likes = getLikesWordList(postID);
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

			uldao.setLikesWordList(finallikes, postID);
			
		}		
		
	}
	public ArrayList<String> getLikesWordList(String postID){

		String likes = uldao.getLikesWordListInDB(postID);
		
		if(likes != null){
			ArrayList<String> wordlistlikes = new ArrayList<String>(Arrays.asList(likes.split(",")));
			return wordlistlikes;
		}else{
			
			return null;
		}
		
		
		
	}

	public void removeWord(String word, String listid) throws IOException {
		
        int listID = Integer.parseInt(listid);


		WordLists ul = new WordLists();

		ArrayList<String> list = ul.getAllFromList(listID);	
		

		String wordsString = list.get(5).replace(" ", ""); // remove spaces from string of words
		ArrayList<String> words = new ArrayList<String>(Arrays.asList(wordsString.split(",")));
		

		words.remove(word);
		
		int size = words.size();
		
		String stringwords = words.toString().replace("[", "");
		stringwords = stringwords.replace("]", "");
		
		ul.UpdateListWordNet(listid, stringwords, size);
		
		
	}

	public void AddWordToList(String word, String listID) throws IOException {

		
		 int id = Integer.parseInt(listID);


			WordLists ul = new WordLists();

			ArrayList<String> list = ul.getAllFromList(id);	
			

			String wordsString = list.get(5).replace(" ", ""); // remove spaces from string of words
			ArrayList<String> words = new ArrayList<String>(Arrays.asList(wordsString.split(",")));
			

			words.add(word);
			
			int size = words.size();
			
			String stringwords = words.toString().replace("[", "");
			stringwords = stringwords.replace("]", "");
			
			ul.UpdateListWordNet(listID, stringwords, size);
		
		
		
	}

	public void AddWordsList(String words, String listID) throws IOException {
		 int id = Integer.parseInt(listID);


			WordLists ul = new WordLists();

			ArrayList<String> list = ul.getAllFromList(id);	
			

			String wordsString = list.get(5).replace(" ", ""); // remove spaces from string of words
			
			ArrayList<String> wordsArrayNew = new ArrayList<String>(Arrays.asList(words.split(",")));
			ArrayList<String> wordsArrayOri = new ArrayList<String>(Arrays.asList(wordsString.split(",")));
			
			
			wordsArrayOri.addAll(wordsArrayNew);
			
			int size = wordsArrayOri.size();
			
			String stringwords = wordsArrayOri.toString().replace("[", "");
			stringwords = stringwords.replace("]", "");
			
			ul.UpdateListWordNet(listID, stringwords, size);
		
		
	}


	






	
	
	

}
