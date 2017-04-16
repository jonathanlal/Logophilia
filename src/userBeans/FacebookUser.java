package userBeans;

import database.FacebookUserDao;

public class FacebookUser {

	FacebookUserDao fbdao = new FacebookUserDao();
	
	public boolean userIdEXists(String fbid) {
	

		
		return fbdao.checkUserIDExists(fbid);
	}
	
	public String getAccountType(String fbid){
		
		return fbdao.getAccountTypeInDB(fbid);
		
	}
	public String getName(String fbid){
		
		return fbdao.getNameInDB(fbid);
	}
	
	public String getEmail(String username) {

		return fbdao.getEmailInDB(username);
	}

	public boolean validateEmail(String currentEmail, String username) {

		return fbdao.validateEmailInDB(currentEmail, username);
	}
	public boolean checkEmailExists(String useremail) {
		// TODO Auto-generated method stub
		return FacebookUserDao.checkEmailExistsInDB(useremail);
	}

	public void updateNewEmail(String username, String newEmail) {
		fbdao.updateNewEmailInDB(username, newEmail);
		
	}
	

}
