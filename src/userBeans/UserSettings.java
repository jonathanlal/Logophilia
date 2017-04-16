package userBeans;

import java.util.ArrayList;

import database.UserDataDao;
import database.UserSettingsDao;

public class UserSettings {
	
	UserSettingsDao usdao = new UserSettingsDao();
	
	public String getNewTab(String username){
		
		return usdao.getNewTabFromDB(username);
	}
	
	
	public void setNewTab(String current,String username){
		
		usdao.setNewTabInDB(current,username);
	}
	
	public ArrayList<String> getSettings(String username) {

		return usdao.getSettingsFromDB(username);
		
	}
	public void setHideSearch(String current, String username) {
		usdao.setHideSearchInDB(current,username);
		
	}
	public void setHideProfileImg(String current, String username) {
	
		usdao.setHideProfileImgInDB(current,username);
	}


	public boolean validatePass(String currentPass, String username) {

		return usdao.validatePassInDB(currentPass, username);
	}
	public boolean validateEmail(String currentEmail, String username) {

		return usdao.validateEmailInDB(currentEmail, username);
	}


	public String getEmail(String username) {

		return usdao.getEmailInDB(username);
	}
	public String getUsername(String email) {

		return usdao.getUsernameInDB(email);
	}


	public void waitPasswordChangeConfirmation(String username, String newPass, String code, String date) {
	
		usdao.waitPasswordChangeConfirmationInDB(username,newPass,code, date);
		
	}


	public String confirmCodeUser(String username) {
	
		return usdao.confirmCodeUserInDB(username);
	}
	public String confirmCodeEmail(String email) {
		
		return usdao.confirmCodeEmailInDB(email);
	}
	public boolean checkEmailExists(String fbid){
		
		return usdao.checkEmailExistsInDB(fbid);
	}


	public void nullCode(String username) {
	
		usdao.nullCodeInDB(username);
	}

	public void nullCodeByEmail(String email) {
		
		usdao.nullCodeByEmailInDB(email);
	}

	
	public String getNewPass(String username) {
		return usdao.getNewPassfromDB(username);
	}
	
	public String getNewPassByEmail(String email) {
		return usdao.getNewPassByEmailfromDB(email);
	}
	
	


	public void updateNewPass(String username, String newPass) {
		usdao.updateNewPassInDB(username, newPass);
		
	}


	public void waitEmailChangeConfirmation(String username, String newEmail, String code, String date) {
		usdao.waitEmailChangeConfirmationInDB(username,newEmail,code, date);

		
	}


	public String getNewEmail(String username) {
		return usdao.getNewEmailfromDB(username);
	}

	public String getUserPass(String email){
		
		return usdao.getUserpassInDB(email);
	}
	

	public void updateNewEmail(String username, String newEmail) {
		usdao.updateNewEmailInDB(username, newEmail);
		
	}


	public void registerUserSettings(String username, String newTab, String hideSearch,String hideProfileImg){
  	

			usdao.registerUserSettingsInDB(username,newTab,hideSearch,hideProfileImg);
			
		
	}


	public void addUserToEmailList(String username) {
		
		String useremail = getEmail(username);
	
		usdao.addUserToEmailListInDB(username, useremail);
	}


	public void removeUserFromEmailList(String username) {
	
		usdao.removeUserFromEmailList(username);
	}


	public void setEmailNewTalks(String current, String username) {
		
		usdao.setEmailNewTalksInDB(current,username);

	}


	public void setColours(String back, String text, String username) {
		usdao.setColoursInDB(back,text,username);
	}


	public String getAccountType(String username) {
		return usdao.getAccountTypeInDB(username);
	}
	public boolean validateEmail(String email) {

		return usdao.validateEmailInDB(email);
	}

	
	public void ForgotPassword(String newPass, String email, String code) {

		usdao.setForgotPasswordInDB(newPass,email,code);
	}


//	public void ResetPassword(String email, String newPass) {
//	
//		UserDataDao.resetPasswordInDB(email,newPass);
//	}
	
	
	
	
	

}
