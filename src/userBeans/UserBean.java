package userBeans;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class UserBean {

	public static File folder = new File("C:/Users/jonathanlal/workspace/jonaProjects/Logophilia/WebContent/word_lists");
	//public File folder = new File("C:/Users/jonathanlal/workspace/jonaProjects/Logophilia/WebContent/userfiles");
	public String directoryAbsolute = "C:/Users/jonathanlal/workspace/jonaProjects/Logophilia/WebContent/userfiles";

	
	
	public void registerUserData(String username, String profile, String cover, String date, String title, String body, int eros, int currenteros){	
		UserBeanDao ub = new UserBeanDao();
		ub.registerUserinDBUserData(username,profile,cover,date,title,body,eros,currenteros);
	}
	public void setProfileInfoTitle(String username, String infotitle) {
		UserBeanDao ub = new UserBeanDao();
		ub.setProfileInfoTitleinDB(username, infotitle);
	}
	public void setProfileInfoBody(String username, String infobody) {
		UserBeanDao ub = new UserBeanDao();
		ub.setProfileInfoBodyinDB(username, infobody);
	}
	public void setProfileInfo(String infotitle, String infobody, String username) {
		setProfileInfoTitle(username,infotitle);
		 setProfileInfoBody(username,infobody);
	}
	public void setProfileImage(String username, String image) {
		UserBeanDao ub = new UserBeanDao();
		ub.setProfileImageinDB(username, image);
	}
	public void setCoverImage(String username, String image) {
		UserBeanDao ub = new UserBeanDao();
		ub.setCoverImageinDB(username, image);
	}
	public String getProfileImage(String username) {
		UserBeanDao ub = new UserBeanDao();
		return ub.getProfileImagefromDB(username);
	}
	public String getCoverImage(String username) {
		UserBeanDao ub = new UserBeanDao();
		return ub.getCoverImagefromDB(username);
	}
	public String getProfileInfoTitle(String username) {
		UserBeanDao ub = new UserBeanDao();
		return ub.getProfileInfoTitlefromDB(username);
	}
	public String getProfileInfoBody(String username) {
		UserBeanDao ub = new UserBeanDao();
		return ub.getProfileInfoBodyfromDB(username);
	}	
	public String getCreationTimeOfUser(String username){
		UserBeanDao ub = new UserBeanDao();
		return ub.getCreationDateOfUserfromDB(username);		
	}
	
	
//	1//set user_profile 
	
//	public void setUserProfileImage(String username, String image){
//		
//		UserBeanDao ub = new UserBeanDao();
//		
//		ub.setUserProfileinDB(username, image);
//	}
	
	
//	
//	2//get ''
//	
//	3//set user_cover
//	
//	4//get ''
//	
//	5//set creation_date
//	
//	6//get ''
//	
//	7//set info_title
//	
//	8//get ''
//	
//	9//set info_body
//	
//	0//get ''
//	
//	Eros...
	

	
	
	
	
	public void MakeDirectories(String user, String date){
		
		
   File f = null;
   f = new File(user+"_CreationDate.txt");

	File fileSaveDirSettingsFILE = new File(directoryAbsolute + File.separator + user + File.separator + "settings" + File.separator + f);
//	File DefaultLists = new File(directoryAbsolute + File.separator + user + File.separator + "lists" + File.separator + user+".txt");
	//String content = "100WordsMiddleSchool.txt"  + "\n" + 	"1500_GREWordList.txt"		 + "\n" + 	"2500_WholeAlphabetSATWords.txt"	 + "\n" + 	"300SATWords2.txt"	 + "\n" + 	"350_GREHighFrequencyWords.txt";
	//create saved words file

	// create the user's own folder in uploads folder of server.
	//String listsDir = directoryAbsolute + File.separator + user + File.separator + "lists";
	String ImagesDir = directoryAbsolute + File.separator + user + File.separator + "images";

	String settingsDir = directoryAbsolute + File.separator + user + File.separator + "settings"; // + File.separator + user+"_settings.txt";
	
	

	
	
	File fileSaveDirSettings = new File(settingsDir);

	//File fileSaveDir = new File(listsDir);
	File fileSaveDirImages = new File(ImagesDir);

	if (!fileSaveDirSettings.exists()) {
		//fileSaveDir.mkdir();
		fileSaveDirSettings.mkdir();
		fileSaveDirImages.mkdir();
		
		
		
//		try{
//			
//			this creates a text file in folder lists that holds "1500_GREwordlits".. etc...
//			DefaultLists.createNewFile();
//			FileWriter fw = new FileWriter(DefaultLists.getAbsoluteFile());
//			BufferedWriter bw = new BufferedWriter(fw);
//			bw.write(content);
//			bw.close();
//
//
//			
//			fileSaveDirSettingsFILE.createNewFile();
//			FileWriter fw2 = new FileWriter(fileSaveDirSettingsFILE.getAbsoluteFile());
//			BufferedWriter bw2 = new BufferedWriter(fw2);
//			bw2.write(date);
//			bw2.close();
//
//			
//			
//			 
//			
//			
//			
//			
//		}catch(IOException e){
//			e.printStackTrace();
//		}
//		
//		
//		
	}

	
	}
	
	

	
	public boolean checkUsernameExists(String username){
		
		RegisterDao ub = new RegisterDao();
		
		return ub.checkifUsernameExists(username);
		
	}
	
	
	
	public String getRank(String username){
		String eros = getEros(username);
        int erosInt = Integer.valueOf(eros);
        String rank = "";
		
		if(erosInt < 100){
			
			rank = "Neophyte";
		}
			
		if(erosInt > 100 && erosInt < 600){
			
			rank = "Word G";
		}
		if(erosInt > 600){
			
			rank = "bitch";
		}
		
		
		
		return rank;
		
	}
	
	
	
	

	public String getEros(String username) {
        String eros = UserErosDao.getNetEros(username);
		return eros;
	}
	
	public void addEros(String username){
        String eros = UserErosDao.getNetEros(username);
        int erosInt = Integer.valueOf(eros);
        int addOne = 1;
        erosInt = erosInt + addOne;
        UserErosDao.setNetEros(username, erosInt);
		addcurrentEros(username);
        

	}
	public void addErosAnotherUser(String username){
        String eros = UserErosDao.getNetEros(username);
        int erosInt = Integer.valueOf(eros);
        int addOne = 2;
        erosInt = erosInt + addOne;
        UserErosDao.setNetEros(username, erosInt);
		addcurrentEros(username);
        

	}
	public void createlistEros(String username){
	    String currenteros = UserErosDao.getCurrentEros(username);
        int erosInt = Integer.valueOf(currenteros);
        int minusTen = 10;
        erosInt = erosInt - minusTen;
        UserErosDao.setCurrentEros(username, erosInt);	
		
	}
	public int gettotalamountofuserlist(String username){
		
		WordListsDao ul = new WordListsDao();
		
		
		return ul.getTotalAmountOFLISTSFROMDB(username);
		
	}
	
	public int gettotalamountofuserquotelist(String username){
		
		
	QuoteListsDao ql = new QuoteListsDao();
		
		
		return ql.getTotalAmountOFLISTSFROMDB(username);
		
		
	}
	
	public boolean checkEnoughtoCreateListEros(String username){
	    String currenteros = UserErosDao.getCurrentEros(username);
        int erosInt = Integer.valueOf(currenteros);
        int Ten = 10;
        
        if(erosInt >= Ten){
        	
        	return true;
        	
        }else{
   
		
		return false;
        }
		
	}
	
	public String currentEros(String username){
	    String currenteros = UserErosDao.getCurrentEros(username);	
		return currenteros;
	}
	public void addcurrentEros(String username){
        String eros = UserErosDao.getCurrentEros(username);
        int erosInt = Integer.valueOf(eros);
        int addOne = 1;
        erosInt = erosInt + addOne;
        UserErosDao.setCurrentEros(username, erosInt);
//		addEros(username);
//		return;

	}
	
	public void minuscurrentEros(String username){
	    String currenteros = UserErosDao.getCurrentEros(username);
        int erosInt = Integer.valueOf(currenteros);
        int minusTwo = 3;
        erosInt = erosInt - minusTwo;
        UserErosDao.setCurrentEros(username, erosInt);		
	}

	public void addErosListnet(String username) {
        String eros = UserErosDao.getNetEros(username);
        int erosInt = Integer.valueOf(eros);
        int addthree = 3;
        erosInt = erosInt + addthree;
        UserErosDao.setNetEros(username, erosInt);		
	}
	public void addErosListcurrent(String username) {
        String eros = UserErosDao.getCurrentEros(username);
        int erosInt = Integer.valueOf(eros);
        int addthree = 3;
        erosInt = erosInt + addthree;
        UserErosDao.setCurrentEros(username, erosInt);		
	}
	
	
	
	
	
	
}



