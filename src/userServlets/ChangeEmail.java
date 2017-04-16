package userServlets;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import userBeans.FacebookUser;
import userBeans.UserBeanDao;
//import models.RegisterUser;
import userBeans.UserSettings;

/**
 * Servlet implementation class ChangeEmail
 */
public class ChangeEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeEmail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Integer code = Integer.parseInt(request.getParameter("code"));
		String username = request.getParameter("user");
		UserSettings us = new UserSettings();
	
		
		Integer codefromDB = Integer.parseInt(us.confirmCodeUser(username));
		
		if(code.equals(codefromDB)){
			
	    	HttpSession session = (request.getSession());
			String newEmail = us.getNewEmail(username); // get new pass from temporary DB

  			
	    // if username contains numbers
	    	if(username.matches("[0-9]+")){ 
	    		FacebookUser fbu = new FacebookUser();
	    		
	    		fbu.updateNewEmail(username,newEmail);
	    		
	    		
	    	}else{
	    	
			
	    		us.updateNewEmail(username, newEmail); // update new pass in user
			
		
	    	}
		
		
		
		
		us.nullCode(username); // make null code in temp DB

			
			
			request.setAttribute("successEmailChange", "Success. New Email Updated!");
			
		      RequestDispatcher rd=request.getRequestDispatcher("settings.jsp");    
		        
		        rd.forward(request,response);  
		        
			
		}else{
			
			request.setAttribute("errorEmailChange", "Error. Something went wrong. No change.");
		      RequestDispatcher rd=request.getRequestDispatcher("settings.jsp");    
	        
	        rd.forward(request,response);    
			
			
		}
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = (request.getSession());
		  
			String username;
	    	 if(null == session.getAttribute("fbAccount")){  
	    		 
	    		 username = session.getAttribute("username").toString();
	    	 
	    	 }else{
	 			username = session.getAttribute("fbAccount").toString();

	    		 
	    	 }
		
//		RegisterUser ru = new RegisterUser();
		
		
	String currentEmail = request.getParameter("cemail");
	String newEmail = request.getParameter("nemail");
	String confirmNewEmail = request.getParameter("cnemail");
	
	UserSettings us = new UserSettings();
	
	
	if(null != session.getAttribute("fbAccount").toString()){
		
		username = session.getAttribute("fbAccount").toString();
		
		FacebookUser fbu = new FacebookUser();
		
		
		
		
		
		
		
		if(fbu.validateEmail(currentEmail, username) && newEmail.matches(confirmNewEmail) && !fbu.checkEmailExists(newEmail)){
			
	        Date creationTime = new Date(session.getCreationTime() );
	        DateFormat formatter = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM);
	        
	        String date = formatter.format(creationTime).toString();
			
		String email = us.getEmail(username); // get user email
		String code = Integer.toString(gen());	// create random code

		us.waitEmailChangeConfirmation(username,newEmail,code,date); // add to database values
		
		sendMultipartMail(code,username,newEmail); // send email with code to confirm
		
		request.setAttribute("ConfirmEmailChange", "Confirm email change by clicking on the link sent to your new email");
			
		}else{
			
			request.setAttribute("incorrectEmailChange", "Old email incorrect or new email does not match confirm email. Or new email already exists under another account.");

			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}else{
	
	
		UserBeanDao ubdao = new UserBeanDao();

	if(us.validateEmail(currentEmail, username) && newEmail.matches(confirmNewEmail) && !ubdao.checkEmailExistsInDB(newEmail)){
		
        Date creationTime = new Date(session.getCreationTime() );
        DateFormat formatter = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM);
        
        String date = formatter.format(creationTime).toString();
		
	String email = us.getEmail(username); // get user email
	String code = Integer.toString(gen());	// create random code

	us.waitEmailChangeConfirmation(username,newEmail,code,date); // add to database values
	
	sendMultipartMail(code,username,newEmail); // send email with code to confirm
	
	request.setAttribute("ConfirmEmailChange", "Confirm email change by clicking on the link sent to your new email");
		
	}else{
		
		request.setAttribute("incorrectEmailChange", "Old email incorrect or new email does not match confirm email. Or new email already exists under another account.");

		
	}
	
	
	
	
	
	
	
	
	
	
	
	}
	
	
	
	
	
	
    RequestDispatcher rd=request.getRequestDispatcher("Settings.jsp");    
    
    rd.forward(request,response);  
		
		
	}
	public int gen() {
	    Random r = new Random( System.currentTimeMillis() );
	    return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
	}
        

	private void sendMultipartMail(String code,String username,String email) throws FileNotFoundException{
	    Properties props = new Properties();
	    Session session = Session.getDefaultInstance(props, null);

	    String msgBody = ".some random text lol..";

	    try {
	      Message msg = new MimeMessage(session);
	      msg.setFrom(new InternetAddress("noreply.askterencemckenna@gmail.com", "AskTerenceMcKenna.com"));
	      msg.addRecipient(Message.RecipientType.TO,
	                       new InternetAddress(email, "McKennite"));
	      msg.setSubject("Confirm Email Change");
	      msg.setText(msgBody);

  		

	      // [START multipart_example]
	      String htmlBody = "<h1>Change email by clicking on the link below:</h1><br>"
	    		+ "<a href=\"www.logophilia.org/ChangeEmail?code="+code+"&amp;user="+username+"\">Click this link to confirm email change</a>";
//	      		+ "<h1>test title welcome lol</h1>"
//	    		+ "<img src=\"img/ASK.png\">"
//	      		+ "<p> does it work or no? </p>";          // ...
	      


//	      byte[] attachmentData = null;
	      
//	      byte[] attachmentData = null;  // ...
	      Multipart mp = new MimeMultipart();

	      MimeBodyPart htmlPart = new MimeBodyPart();
	      htmlPart.setContent(htmlBody, "text/html");
	      mp.addBodyPart(htmlPart);

//	      MimeBodyPart attachment = new MimeBodyPart();
//	      InputStream attachmentDataStream = new ByteArrayInputStream(attachmentData);
//	      attachment.setFileName("Terence.jpg");
//	      attachment.setContent(attachmentDataStream, "image/png");
//	      mp.addBodyPart(attachment);

	      msg.setContent(mp);
	      // [END multipart_example]

	      Transport.send(msg);

	    } catch (AddressException e) {
	      // ...
	    } catch (MessagingException e) {
	      // ...
	    } catch (UnsupportedEncodingException e) {
	      // ...
	    }
	  }
	
	
	
}
