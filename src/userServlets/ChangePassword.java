package userServlets;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.util.ArrayList;
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

//import userBeans.RegisterUser;
//import userBeans.UserData;
import userBeans.UserSettings;

/**
 * Servlet implementation class ChangePassword
 */
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePassword() {
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

  			
		String newPass = us.getNewPass(username); // get new pass from temporary DB
			
		us.updateNewPass(username, newPass); // update new pass in user
			
		
		
		us.nullCode(username); // make null code in temp DB

			
			
			request.setAttribute("successPassChange", "Success. New Password Updated!");
			
		      RequestDispatcher rd=request.getRequestDispatcher("settings.jsp");    
		        
		        rd.forward(request,response);  
		        
			
		}else{
			
			request.setAttribute("errorPassChange", "Error. Something went wrong. No change.");
		      RequestDispatcher rd=request.getRequestDispatcher("settings.jsp");    
	        
	        rd.forward(request,response);    
			
			
		}
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = (request.getSession());
		String username = session.getAttribute("username").toString();
		
		
		
	String currentPass = request.getParameter("cpass");
	String newPass = request.getParameter("npass");
	String confirmNewPass = request.getParameter("cnpass");
	
	UserSettings us = new UserSettings();
	
	if(us.validatePass(currentPass, username) && newPass.matches(confirmNewPass)){
		
        Date creationTime = new Date(session.getCreationTime() );
        DateFormat formatter = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM);
        
        String date = formatter.format(creationTime).toString();
		
	String email = us.getEmail(username); // get user email
	String code = Integer.toString(gen());	// create random code

	us.waitPasswordChangeConfirmation(username,newPass,code,date); // add to database values
	
	sendMultipartMail(code,username,email); // send email with code to confirm
	
	request.setAttribute("ConfirmPassChange", "Confirm password change by clicking on the link sent to your email");
		
	}else{
		
		request.setAttribute("incorrectPassChange", "Old Password incorrect or new password does not match confirm password.");

		
	}
	
    RequestDispatcher rd=request.getRequestDispatcher("settings.jsp");    
    
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
	      msg.setSubject("Confirm Password Change");
	      msg.setText(msgBody);

  		

	      // [START multipart_example]
	      String htmlBody = "<h1>Change password by clicking on the link below:</h1><br>"
	    		+ "<a href=\"www.logophilia.org/ChangePassword?code="+code+"&amp;user="+username+"\">Click this link to confirm password change</a>";
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
