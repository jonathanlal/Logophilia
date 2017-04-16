package userBeans;

import java.util.ArrayList;

public class SavedLists {

	SavedListDao sldao = new SavedListDao();
	
	
	public void saveList(String id, String username, String type){
		
		sldao.SetSavedListInDB(id, username, type);
		
	}
	
	public ArrayList<ArrayList<String>> getSavedLists(String username){
		
		return sldao.getSavedListsfromDB(username);
	}
	
	
	
}
