package userBeans;

import java.util.ArrayList;

public class UserLists {
	
	
	public ArrayList<ArrayList<String>> getUserLists(String username){
		
		ArrayList<ArrayList<String>> AllListsMaster = new ArrayList<ArrayList<String>>();
		
		 QuoteLists ql = new QuoteLists();
		 WordLists wl = new WordLists();
		 SavedLists sl = new SavedLists();
		
		 ArrayList<ArrayList<String>> wordlistinfo = wl.getListInfoProfile(username);
		 
		 if(wordlistinfo != null){
	        	        
	        ArrayList<String> wlistids = wordlistinfo.get(0);
	        ArrayList<String> wlistnames = wordlistinfo.get(1);
	        ArrayList<String> wlistsizes = wordlistinfo.get(2);
	        ArrayList<String> wlistlikes = wordlistinfo.get(3); // fix this to get size of each element in it
	      
	        
		 }
	        
	   	 ArrayList<ArrayList<String>> quotelistinfo = ql.getListInfoProfile(username);
	        
	        ArrayList<String> qlistids = quotelistinfo.get(0);
	        ArrayList<String> qlistnames = quotelistinfo.get(1);
	        ArrayList<String> qlistsizes = quotelistinfo.get(2);
	        ArrayList<String> qlistlikes = quotelistinfo.get(3); // fix this to get size of each element in it
	        
	        
		   	 ArrayList<ArrayList<String>> savedlistinfo = sl.getListInfoProfile(username);
		        
		        ArrayList<String> slistids = savedlistinfo.get(0);
		        ArrayList<String> slistnames = savedlistinfo.get(1);
		        ArrayList<String> slistsizes = savedlistinfo.get(2);
		        ArrayList<String> slistlikes = savedlistinfo.get(3); // fix this to get size of each element in it
	        
	        
		        
		        
		        ArrayList<String> masterids = new ArrayList<String>();
		        ArrayList<String> masternames = new ArrayList<String>();
		        ArrayList<String> mastersizes = new ArrayList<String>();
		        ArrayList<String> masterlikes = new ArrayList<String>();
		        
		        
		        masterids.addAll(wlistids);
		        masterids.addAll(qlistids);
		        masterids.addAll(slistids);
		        
		        
		        
		        
		        
		        
//	        session.setAttribute("userlistids", listids);
//	    	session.setAttribute("userlistsizes", listsizes);		
//	        session.setAttribute("userlistnames", listnames);
//	        session.setAttribute("userlistlikes", listlikes);
		
		 
		 
	}
	

}
