package userBeans;

import java.util.ArrayList;

public class UserNotifications {
	
	UserNotificationsDao undao = new UserNotificationsDao();
	
	public ArrayList<String> getNotifications(String username){

		return undao.getNotificationsInDB(username);
		
	}
	
	public void addNotification(String username, String notification, String date, String link){
		
		undao.AddNotificationInDB(username, notification, date, link);
		
	}
	
	
	public void clearNotifications(String username){
		
		undao.ClearNotificationsInDB(username);
	}
	
	
	
	
	
	

}
