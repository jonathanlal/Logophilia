package database;

import java.util.ArrayList;

public class LeaderBoard {
	
	
	
	public ArrayList<String> getLeaderBoard(){
		
		
		
		
		LeaderBoardDao lbd = new LeaderBoardDao();
		
		
		
		
		
		return lbd.getLeaderBoardinDB();
		
		
		
	}
	
	

}
