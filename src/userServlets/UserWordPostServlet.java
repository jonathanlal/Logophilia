package userServlets;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;

import com.google.appengine.tools.cloudstorage.GcsFileOptions;
import com.google.appengine.tools.cloudstorage.GcsFilename;
import com.google.appengine.tools.cloudstorage.GcsOutputChannel;
import com.google.appengine.tools.cloudstorage.GcsService;
import com.google.appengine.tools.cloudstorage.GcsServiceFactory;
import com.google.appengine.tools.cloudstorage.RetryParams;
import logophilia.Merriam;
import userBeans.QuotePost;
import userBeans.SearchHistory;
import userBeans.UserBean;
import userBeans.UserErosDao;
import userBeans.UserFeed;
import userBeans.WordLists;
import userBeans.WordPost;
import wordnet.WordNet;

/**
 * Servlet implementation class UserPostServlet
 */

public class UserWordPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  private static final int BUFFER_SIZE = 2 * 1024 * 1024;


    public UserWordPostServlet() {
        super();
    }
    private final GcsService gcsService = GcsServiceFactory.createGcsService(new RetryParams.Builder()
    	      .initialRetryDelayMillis(10)
    	      .retryMaxAttempts(10)
    	      .totalRetryPeriodMillis(15000)
    	      .build());


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IndexOutOfBoundsException {
		HttpSession session = (request.getSession());

        String username = session.getAttribute("loggedInUser").toString();

        UserFeed uf = new UserFeed();
		
 			ArrayList<ArrayList<ArrayList<String>>> feed = uf.getMainFeedByUser(username);
 			
 			ArrayList<ArrayList<String>> posts = feed.get(0);
 			
 			  ArrayList<String>	WordOrQuotePostID = posts.get(0);
 			  ArrayList<String> WordOrQuotePost = posts.get(1);
 			  ArrayList<String> DefinitionOrAuthorPost = posts.get(2);
 			  ArrayList<String> usertextpost = posts.get(3);
 			  ArrayList<String> imagepost = posts.get(4);
 			  ArrayList<String> timepost = posts.get(5);
 			  ArrayList<String> userpost = posts.get(6);
 			  ArrayList<String> likesArraySize = posts.get(7);
 			  ArrayList<String> idFeedArray = posts.get(8);
 			  ArrayList<String> typeFeedArray = posts.get(9);
 			  ArrayList<String> savedwordscheck = posts.get(10);
 			  
 				session.setAttribute("wordorquotepostID", WordOrQuotePostID);
 				session.setAttribute("WordOrQuotePost", WordOrQuotePost);
 				session.setAttribute("DefinitionOrAuthorPost", DefinitionOrAuthorPost);
 				session.setAttribute("usertextpost", usertextpost);
 				session.setAttribute("imagepost", imagepost);
 				session.setAttribute("timepost", timepost);
 				session.setAttribute("userpost", userpost);
 				session.setAttribute("likesArraySize", likesArraySize);
 				session.setAttribute("savedwordsArrayCheck", savedwordscheck);

 				session.setAttribute("idFeedArray", idFeedArray);
 				session.setAttribute("typeFeedArray", typeFeedArray);

 				
 				ArrayList<ArrayList<String>> arrayception = feed.get(1);
 				
 				session.setAttribute("arrayception", arrayception);
 			
         
                
         
         	
             RequestDispatcher rd=request.getRequestDispatcher("UserProfile.jsp");    
             
              rd.forward(request,response);  
	}
		

		

 



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NullPointerException {
    	HttpSession session = (request.getSession());
    	
        String username = session.getAttribute("loggedInUser").toString();
        
        Date now = new Date();
        DateFormat formatter = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM);
        
        String date = formatter.format(now).toString();
			
		WordPost wp = new WordPost();
        
	    String bucketName = "logophilia/wordimages";

        String decider = null; 
        
  	  String sctype = null, sfieldname = null, sname = null;
		String definitionFromMerriam = null;
		ArrayList<String> definitionFromWordNet = null;


      ServletFileUpload upload;
      FileItemIterator iterator;
      FileItemStream item = null;
      InputStream stream = null;
      
      
          String wordpostword = null,usertxt = null,imageURL = null,definition = null,image = null;
        
        
          try{
  			
  			upload = new ServletFileUpload();

  			   iterator = upload.getItemIterator(request);
  	            while (iterator.hasNext()) {
  	                item = iterator.next();
  	                stream = item.openStream();
  	                String fieldname = item.getFieldName();
  	                
  				   if (item.isFormField()) {
 					  String value = Streams.asString(stream);

 					  if (fieldname.equals("wordpostword")){
 						 wordpostword = value;
// 						 definitionFromMerriam = definitionMerriam(wordpostword);
 						 definitionFromWordNet = definitionWordNetArray(wordpostword);
// 						definitionFromWordNet.get(0).substring(1);
// 						int size = definitionFromWordNet.size(); // delete first character '['
// 						definitionFromWordNet.get(size).substring(1, definitionFromWordNet.get(size).length() -1); // delete last character ']'
					  }
					  if (fieldname.equals("usertxt")){
						  usertxt = value;
					  }  
//					  if (fieldname.equals("definition")){
//						  definition = value;
//					  }
					  if (fieldname.equals("imageURL")){
						  imageURL = value;
	                        UserBean ub = new UserBean();

					  		if(imageURL.contains(".")){
					  			decider = "url"; 
					  			
					  			
//						  		String def1 =  definitionFromWordNet.toString().substring(1);
//						  		String def2 = def1.substring(1, def1.length() -1);
						  		String def2 = definitionFromWordNet.toString().substring(1, definitionFromWordNet.toString().length() -1);

						  		
								wp.createWordPost(wordpostword, usertxt,def2, imageURL, date, username);

					  			
					  			
					  				}
						  
						  
					  }


					  
					  
					  
					  
  				   } else{
						  

   	                   sfieldname = item.getFieldName();
   	                   sname = item.getName();

   	                   sctype = item.getContentType();
   	                   
   			

   	                   image = "https://storage.googleapis.com/logophilia/wordimages/"+sname;

   	                   
   	                   
   	                   
   	                   
   	                GcsFilename gcsfileName = new GcsFilename(bucketName, sname);

     	           GcsFileOptions options = new GcsFileOptions.Builder().acl("public-read").mimeType(sctype).build();
                   GcsOutputChannel outputChannel;
                   outputChannel = gcsService.createOrReplace(gcsfileName, options);

       
                   copy(stream, Channels.newOutputStream(outputChannel));
                   stream.close();
                   
                   
                   if(decider == null){
				  		String def2 = definitionFromWordNet.toString().substring(1, definitionFromWordNet.toString().length() -1);

					wp.createWordPost(wordpostword, usertxt, def2, image, date, username);
  				   }

					  
					  }
        
  					   
  				   }
  					 

  	  		} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
  					   
  					   
        
    	
//    	boolean definitionCheckBool = false;
//    	
//    	if(definition != null){
//    		definitionCheckBool = true;	
//    	}

//    	boolean imageCheckBool = false;
//    	
//    	if(imageURL !=null){
//    		imageCheckBool = true;	
//    	}
//    	
//		String definition = request.getParameter("definition");
//        String imageURL = request.getParameter("imageURL");
//		String wordpostword = request.getParameter("wordpostword");
//		String usertxtCheck = request.getParameter("usertxt");
//		if(usertxtCheck == null || usertxtCheck.isEmpty()){
//			
//			usertxt=" ";
//		}else{
//			
//			usertxt = request.getParameter("usertxt");
//		}
		
		

		
		
	

				
				
				
				
				
					
//				if(definition != null){
//					
//					wp.createWordPost(wordpostword, usertxt, definition+"", image, date, username);
//					
//						session.removeAttribute("eros");
//				        session.removeAttribute("currenteros");
//
//				       	UserBean userbean = new UserBean();
//						userbean.addEros(username.toString());
//					
//						String eros = UserErosDao.getNetEros(username.toString());
//						String currenteros = UserErosDao.getCurrentEros(username.toString());
//				   
//				        session.setAttribute("currenteros", currenteros);
//				        session.setAttribute("eros", eros);
//					
//					
//					
//				        UserFeed uf = new UserFeed();
//						
//						int WordID = uf.getWordPostID(username);
//
//				        uf.addToFeed(WordID+",","w,",username);
//
//				}else{
					
					
					session.removeAttribute("eros");
			        session.removeAttribute("currenteros");

			       	UserBean userbean = new UserBean();
//					userbean.addEros(username);
			       	userbean.minuscurrentEros(username);
				
					String eros = UserErosDao.getNetEros(username);
					String currenteros = UserErosDao.getCurrentEros(username);
			   
			        session.setAttribute("currenteros", currenteros);
			        session.setAttribute("eros", eros);

					
			        UserFeed uf = new UserFeed();
					
					int WordID = uf.getWordPostID(username);

			        uf.addToFeed(Integer.toString(WordID),"w",username);
//				}
				
	
				
	
					
						doGet(request, response);

		
			}



	}
	public String definitionMerriam(String wordpostword) throws IOException{
		
		Merriam merriam = new Merriam();	
		String merriamResults = merriam.finalResults(wordpostword);
		List<String> myList2 = new ArrayList<String>(Arrays.asList(merriamResults.split("\\^!")));	
		//SET ONE DEFINITION
		String firstdefinition = myList2.get(1);
		String firstdefinitionOnly1 = firstdefinition.replaceAll(", Definition-1:.*", "");
		String finaldefinitionlol = firstdefinitionOnly1.replaceAll("Definition-0:", "");			
		String finaldefinitionlolagain = finaldefinitionlol.substring(1);
		String finaldefinitionlolagainAgain = finaldefinitionlolagain.replaceAll(",", ";");
		String definitionFromMerriam = finaldefinitionlolagainAgain.replace("]", "");
		
		return definitionFromMerriam;
		
	}
	public ArrayList<String> definitionWordNetArray(String wordpostword) throws IOException{
		
WordNet wn = new WordNet();


ArrayList<String> definitions = wn.getDefinitions(wordpostword);

return definitions;
		
	}
	
	
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

