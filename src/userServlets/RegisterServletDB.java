package userServlets;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
//import java.nio.file.Files;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.output.ByteArrayOutputStream;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
//[START gcs_imports]
import com.google.appengine.tools.cloudstorage.GcsFileOptions;
import com.google.appengine.tools.cloudstorage.GcsFilename;
import com.google.appengine.tools.cloudstorage.GcsInputChannel;
import com.google.appengine.tools.cloudstorage.GcsOutputChannel;
import com.google.appengine.tools.cloudstorage.GcsService;
import com.google.appengine.tools.cloudstorage.GcsServiceFactory;
import com.google.appengine.tools.cloudstorage.RetryParams;

import userBeans.RegisterDao;
import userBeans.SavedWords;
import userBeans.SearchHistory;
import userBeans.UserBean;
import userBeans.UserErosDao;
import userBeans.UserFeed;
import userBeans.UserNotifications;
import userBeans.UserSettings;

/**
 * Servlet implementation class RegisterServletDB
 */
//@WebServlet("/RegisterServletDB")
public class RegisterServletDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	public File folder4 = new File("C:/Users/jonathanlal/workspace/jonaProjects/Logophilia/WebContent/UserFiles");
//	public String directoryAbsolute = "C:/Users/jonathanlal/workspace/jonaProjects/Logophilia/WebContent/UserFiles";
//
//	public File defaultcover = new File("C:/Users/jonathanlal/workspace/jonaProjects/Logophilia/WebContent/img/cover.png");
//	public File defaultprofile = new File("C:/Users/jonathanlal/workspace/jonaProjects/Logophilia/WebContent/img/profile.jpg");
       
	
    private static final Logger log = Logger.getLogger(UploadServlet.class.getName());

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServletDB() {
        super();
        // TODO Auto-generated constructor stub
    }
    private final GcsService gcsService = GcsServiceFactory.createGcsService(new RetryParams.Builder()
    	      .initialRetryDelayMillis(10)
    	      .retryMaxAttempts(10)
    	      .totalRetryPeriodMillis(15000)
    	      .build());

    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	HttpSession session = (request.getSession());
        String username=request.getParameter("username");
        String useremail = request.getParameter("email");
        String userpass=request.getParameter("userpass");  
        String Cuserpass=request.getParameter("confirmPassword");

//        int test = 4;
		UserBean userbean = new UserBean();

        
        // and user does not already exist. 
        if(userpass.contains(Cuserpass) && userbean.checkUsernameExists(username) == false){
        	
        	
    		
	        Date creationTime = new Date(session.getCreationTime() );
//	        Date now = new Date();
	        DateFormat formatter = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM);
	        
	        String date = formatter.format(creationTime).toString();
        	

        		try{
        			

    		    	String bucketName = "logophilia/userfiles/"+username+"/settings";
        			GcsFilename gcsfileName = new GcsFilename(bucketName, "main.txt");
        	           GcsFileOptions options = new GcsFileOptions.Builder().acl("public-read").mimeType("text/plain").build();
                      GcsOutputChannel outputChannel;
                      outputChannel = gcsService.createOrReplace(gcsfileName, options);

                      String str = "No settings specified yet....";
                      byte[] content = str.getBytes();
                      ByteArrayInputStream stream = new ByteArrayInputStream(content);
                      copy(stream, Channels.newOutputStream(outputChannel));
                      stream.close();
							
        			
//        				File fileSaveDir = new File(directory);
//        				if (!fileSaveDir.exists()) {
//        					fileSaveDir.mkdir();
//        					//Files.copy(defaultcover.toPath(), filePathCover.toPath());
//        					//Files.copy(defaultprofile.toPath(), filePathProfile.toPath());
//                        	userbean.MakeDirectories(username, date);
//                  
//        					
//        					
//        				}

        	    	    
        	    	}catch(Exception e){
        	    		e.printStackTrace();
        	    	}
        		
        		
        		UserFeed uf = new UserFeed();
        		
        		uf.initializeFeed(username);
        		
        		
//        		session.setAttribute("creationTime", formatter.format(now));
        		session.setAttribute("creationTime", formatter.format(creationTime));
//        		session.setAttribute("lastAccessed", formatter.format(lastAccessed));
            	session.setAttribute("loggedInUser", username);
//            	session.setAttribute("useremail", useremail);
//            	session.setAttribute("userpass", userpass);

        	
        	if(useremail.isEmpty()){
//    			UserBean userbean = new UserBean();

        		
        		RegisterDao.newuser(username, userpass);
     
        		
        												//-----------------------------------------REGISTER NO EMAIL-----------------------------------------
    			
    			
    		      //--------------------------------------TO DATABASE USERDATA
//    	  	  	String profileImg = "userfiles/"+ username + "/" + username+"_profile.jpg";
        		
        		
//    			String profileImg = "C:/Users/jonathanlal/workspace/jonaProjects/Logophilia/WebContent/img/profile.jpg";
//    		   	String coverImg = "C:/Users/jonathanlal/workspace/jonaProjects/Logophilia/WebContent/img/cover.png";
    		   	
        		
         	  	String profileImgx = "lol,img/profile.jpg";
        	   	String coverImgx = "lol,img/cover.png";
        	   	
        	   	
        	 
    		   	
      			userbean.registerUserData(username,profileImgx,coverImgx,date,"profile title","profile body",0,10);

//        		RegisterDao.newuser(username, userpass);
        			
        	//-----------------------------------------SET & GET USER VARIABLES-----------------------------------------
        			
        		//-----------------------------------------EROS SET
        		   UserErosDao.setNetEros(username, 0);
                   UserErosDao.setCurrentEros(username, 10);
                   
                //-----------------------------------------EROS GET
                   String eros = userbean.getEros(username);
                   String currenteros = userbean.currentEros(username);
       	        	
                   
                //-----------------------------------------RANK
       	         String getRank = userbean.getRank(eros);
       	         
        	     	//-----------------------------------------COVER & PROFILE IMAGE       	     
            	  	String[] profileImg = userbean.getProfileImage(username).split(",");
     		   	String[] coverImg = userbean.getCoverImage(username).split(",");
     		   	
            	     
      			session.setAttribute("profileImg", profileImg[1]);
      			session.setAttribute("coverImg", coverImg[1]);

       	        //-----------------------------------------USER INTRO SET
     			userbean.setProfileInfo("Default Header(click to edit)", "Default body(click to edit)", username);
     			
     			//-----------------------------------------USER INTRO GET
     			String usertitleresults = userbean.getProfileInfoTitle(username);
    			String userbodyresults = userbean.getProfileInfoBody(username);
    			
    			
       	        //-----------------------------------------SET SAVED WORDS

    			SavedWords sw = new SavedWords();
    			sw.CreateUserSavedWords(username);
  
    		       //-----------------------------------------SET SEARCH HISTORY

    		    			SearchHistory sh = new SearchHistory();
    		    			sh.CreateSearchHistory(username);  
    			
    			
    		    			
    		    			
    		    		
    			//------------------------------------------------------------------SESSION SETS---------------------------------------------------------
       	        	
    			//-----------------------------------------RANK
    		    			
       	     session.setAttribute("Rank", getRank);	
       	     
       	     	//-----------------------------------------COVER & PROFILE IMAGE         	     
       	     
//       	  	String[] profileImg = userbean.getProfileImage(username).split(",");
//		   	String[] coverImg = userbean.getCoverImage(username).split(",");
		   	
       	     
 			session.setAttribute("profileImg", profileImg[1]);
 			session.setAttribute("coverImg", coverImg[1]);
 			
 			 	//-----------------------------------------USER INTRO
         	session.setAttribute("userbodyresults", userbodyresults);
         	session.setAttribute("usertitleresults", usertitleresults);
         		
         		//-----------------------------------------EROS
       	     session.setAttribute("currenteros", currenteros);
             session.setAttribute("eros", eros);
                   
             
      		//-----------------------------------------SET SAVED WORDS
             
  		    ArrayList<String> savedwords2 = sw.getSavedWords(username);
  		  savedwords2.remove(0);
  	        String Finalhstory2 = savedwords2.toString().replaceAll("]", "").substring(1); 
             session.setAttribute("savedwords", Finalhstory2);
             
             
      //----------------------------------------SET SEARCH HISTORY
             
 		    ArrayList<String> searchhistory2 = sh.getSearchHistory(username);
 		    searchhistory2.remove(0);
 	        String Finalhstory = searchhistory2.toString().replaceAll("]", "").substring(1); 		   	
 		   	session.setAttribute("searchhistory", Finalhstory);
             
             
 		   	// ------------------------------- SET SETTINGS
			//SET DEFAULT SETTINGS
 		   	UserSettings us = new UserSettings();
  			String newTab = "";
  			String hideSearch = "";
  			String hideProfileImg = "";

  			us.registerUserSettings(username,newTab,hideSearch,hideProfileImg);

			session.setAttribute("newTab", "");
			session.setAttribute("hideSearch", "");
			session.setAttribute("hideProfileImg", "");
                	
             
			// GET NOTIFICATIONS
			
		ArrayList<String> notifications	= new ArrayList<String>();
		session.setAttribute("notifications", notifications);
		session.setAttribute("notificationsSize", notifications.size());
//             
//                RequestDispatcher rd=request.getRequestDispatcher("UserProfile.jsp");    
//                
//                rd.forward(request,response);  
//        		
        	}else{
//    			UserBean userbean = new UserBean();

            										//-----------------------------------------REGISTER WITH EMAIL-----------------------------------------

    			
  		   	
    		   	
         	  	String profileImgx = "lol,img/profile.jpg";
        	   	String coverImgx = "lol,img/cover.png";
        	   	
        	   	
    		   	
    		   	
  		   	
    			userbean.registerUserData(username,profileImgx,coverImgx,date,"profile title","profile body",0,10);
    			
        		RegisterDao.newuser(username, userpass, useremail);
        		
            	//-----------------------------------------SET & GET USER VARIABLES-----------------------------------------
    			
        		//-----------------------------------------EROS SET
        		   UserErosDao.setNetEros(username, 0);
                   UserErosDao.setCurrentEros(username, 10);
                   
                //-----------------------------------------EROS GET
                   String eros = userbean.getEros(username);
                   String currenteros = userbean.currentEros(username);
       	        	
                   
                //-----------------------------------------RANK
       	         String getRank = userbean.getRank(eros);
       	         
       	        //-----------------------------------------COVER AND PROFILE IMAGE 
//       	  	String profileImg = "userfiles/"+ username + "/" + username+"_profile.jpg";
//		   	String coverImg = "userfiles/"+ username + "/" + username+"_cover.jpg";

       	        //-----------------------------------------USER INTRO SET
     			userbean.setProfileInfo("Default Header(click to edit)", "Default body(click to edit)", username);
     			
     			//-----------------------------------------USER INTRO GET
     			String usertitleresults = userbean.getProfileInfoTitle(username);
    			String userbodyresults = userbean.getProfileInfoBody(username);
    			
      	        //-----------------------------------------SET SAVED WORDS

    			SavedWords sw = new SavedWords();
    			sw.CreateUserSavedWords(username);
  
		       //-----------------------------------------SET SEARCH HISTORY

    			SearchHistory sh = new SearchHistory();
    			sh.CreateSearchHistory(username);  
		    			
			
			
    			//------------------------------------------------------------------SESSION SETS---------------------------------------------------------
       	        	
    			//-----------------------------------------RANK
       	     session.setAttribute("Rank", getRank);	
       	     
       	     	//-----------------------------------------COVER & PROFILE IMAGE

        	  	String[] profileImg = userbean.getProfileImage(username).split(",");
    		   	String[] coverImg = userbean.getCoverImage(username).split(",");
    		   	
           	     
     			session.setAttribute("profileImg", profileImg[1]);
     			session.setAttribute("coverImg", coverImg[1]);
       	     
       	     
 			
 			 	//-----------------------------------------USER INTRO
         	session.setAttribute("userbodyresults", userbodyresults);
         	session.setAttribute("usertitleresults", usertitleresults);
         		
         		//-----------------------------------------EROS
       	     session.setAttribute("currenteros", currenteros);
             session.setAttribute("eros", eros);
                   
             
      		//-----------------------------------------SET SAVED WORDS
             
  		    ArrayList<String> savedwords2 = sw.getSavedWords(username);
  		  savedwords2.remove(0);
  	        String Finalhstory2 = savedwords2.toString().replaceAll("]", "").substring(1); 
             session.setAttribute("savedwords", Finalhstory2);
             
             
      //----------------------------------------SET SEARCH HISTORY
             
 		    ArrayList<String> searchhistory2 = sh.getSearchHistory(username);
 		    searchhistory2.remove(0);
 	        String Finalhstory = searchhistory2.toString().replaceAll("]", "").substring(1); 		   	
 		   	session.setAttribute("searchhistory", Finalhstory);
             
             
 		   	// ------------------------------- SET SETTINGS
			//SET DEFAULT SETTINGS
 		   	UserSettings us = new UserSettings();
  			String newTab = "";
  			String hideSearch = "";
  			String hideProfileImg = "";

  			us.registerUserSettings(username,newTab,hideSearch,hideProfileImg);

			session.setAttribute("newTab", "");
			session.setAttribute("hideSearch", "");
			session.setAttribute("hideProfileImg", "");

	
			// GET NOTIFICATIONS
			
		ArrayList<String> notifications	= new ArrayList<String>();
		session.setAttribute("notifications", notifications);
		session.setAttribute("notificationsSize", notifications.size());
 		   	
 		   	
 		   	
 		   	
 		   	
        	}
        	
        	
            RequestDispatcher rd=request.getRequestDispatcher("UserProfile.jsp");    
            
            rd.forward(request,response);  
            
            
        	
        }else{
        	
        	
        	
            RequestDispatcher rd=request.getRequestDispatcher("login.jsp");    
            
            rd.forward(request,response);    
        	
        	
        	
        }
        
        
        
        
        
        
		
	
		
		
		
		
		
		
	}

	  private static final int BUFFER_SIZE = 2 * 1024 * 1024;

		
	 private void copy(InputStream input, OutputStream output) throws IOException {
		    try {
		      byte[] buffer = new byte[BUFFER_SIZE];
		      int bytesRead = input.read(buffer);
		      while (bytesRead != -1) {
		        output.write(buffer, 0, bytesRead);
		        bytesRead = input.read(buffer);
		      }
		    } finally {
		      input.close();
		      output.close();
		    }
		  }
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//	}


