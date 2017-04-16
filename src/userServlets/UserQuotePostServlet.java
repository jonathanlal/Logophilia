package userServlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

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
import userBeans.UserBean;
import userBeans.UserErosDao;
import userBeans.UserFeed;
import userBeans.WordPost;

/**
 * Servlet implementation class UserQuotePostServlet
 */
public class UserQuotePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  private static final int BUFFER_SIZE = 2 * 1024 * 1024;

       

    public UserQuotePostServlet() {
        super();
    }
    private final GcsService gcsService = GcsServiceFactory.createGcsService(new RetryParams.Builder()
  	      .initialRetryDelayMillis(10)
  	      .retryMaxAttempts(10)
  	      .totalRetryPeriodMillis(15000)
  	      .build());


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
			
		QuotePost qp = new QuotePost();

		
	    String bucketName = "logophilia/quoteimages";

	    String decider = null; 
		
	  	  String sctype = null, sfieldname = null, sname = null;

		
	      ServletFileUpload upload;
	      FileItemIterator iterator;
	      FileItemStream item = null;
	      InputStream stream = null;
		
		
	      
          String quote = null,usertxt = null,imageURL = null,author = null,image = null;

		
		
          
          
          
          
          
          
          
          try{
    			
    			upload = new ServletFileUpload();

    			   iterator = upload.getItemIterator(request);
    	            while (iterator.hasNext()) {
    	                item = iterator.next();
    	                stream = item.openStream();
    	                String fieldname = item.getFieldName();
    	                
    				   if (item.isFormField()) {
   					  String value = Streams.asString(stream);

   					  if (fieldname.equals("quote")){
   						 quote = value;
  					  }
   					  if (fieldname.equals("author")){
    						 author = value;
   					  }
  					  if (fieldname.equals("usertxt")){
  						  usertxt = value;
  					  }  

  					  if (fieldname.equals("imageURL")){
  						  imageURL = value;
  	                        UserBean ub = new UserBean();

  					  		if(imageURL.contains(".")){
  					  			decider = "url"; 
  					  			
  						  		
  								qp.createQuotePost(quote,author, usertxt, imageURL, date, username);

  					  			
  					  			
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

								qp.createQuotePost(quote,author, usertxt, image, date, username);
      				   }

    					  
    					  }
            
      					   
      				   }
      					 


      	  		} catch (FileUploadException e) {
    				e.printStackTrace();
    			} catch (Exception e) {
    				e.printStackTrace();
    			} finally {
          
          
          


						session.removeAttribute("eros");
				        session.removeAttribute("currenteros");

				       	UserBean userbean = new UserBean();
						userbean.addEros(username.toString());
					
						String eros = UserErosDao.getNetEros(username.toString());
						String currenteros = UserErosDao.getCurrentEros(username.toString());
				   
				        session.setAttribute("currenteros", currenteros);
				        session.setAttribute("eros", eros);
					
					
					
	
						UserFeed uf = new UserFeed();
						
						
						int QuoteID = uf.getQuotePostID(username);

				        uf.addToFeed(Integer.toString(QuoteID),"q",username);
						
				        
					
				        
				        
				        
						doGet(request, response);

				        
    			}
				        
				        
				
				
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
