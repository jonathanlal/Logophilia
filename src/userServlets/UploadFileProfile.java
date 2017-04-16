package userServlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;

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

import com.google.appengine.api.images.Image;
import com.google.appengine.api.images.ImagesService;
import com.google.appengine.api.images.ImagesServiceFactory;
import com.google.appengine.api.images.Transform;
import com.google.appengine.tools.cloudstorage.GcsFileOptions;
import com.google.appengine.tools.cloudstorage.GcsFilename;
import com.google.appengine.tools.cloudstorage.GcsOutputChannel;
import com.google.appengine.tools.cloudstorage.GcsService;
import com.google.appengine.tools.cloudstorage.GcsServiceFactory;
import com.google.appengine.tools.cloudstorage.RetryParams;

import userBeans.UserBean;


public class UploadFileProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  private static final int BUFFER_SIZE = 2 * 1024 * 1024;


	public UploadFileProfile() {
		super();

	}
	
	  private final GcsService gcsService = GcsServiceFactory.createGcsService(new RetryParams.Builder()
		      .initialRetryDelayMillis(10)
		      .retryMaxAttempts(10)
		      .totalRetryPeriodMillis(15000)
		      .build());

	  
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		String username;
	   	 if(null == session.getAttribute("fbAccount")){  
	   		 
	   		 username = session.getAttribute("loggedInUser").toString();
	   	 
	   	 }else{
				username = session.getAttribute("fbAccount").toString();

	   		 
	   	 }
	   	 
	    	session.removeAttribute("profileImg");

	    	String bucketName = "logophilia/userfiles/"+username+"/images/profiles";
	    	
	    	
	    	
	    	
		    	
    	  String sctype = null, sfieldname;
          ServletFileUpload upload;
          FileItemIterator iterator;
          FileItemStream item = null;
          InputStream stream = null;
          String imgURL = null;
          String imgUpload = null;

	
		try {

			upload = new ServletFileUpload();


            iterator = upload.getItemIterator(request);
            while (iterator.hasNext()) {
                item = iterator.next();
                stream = item.openStream();
                String fieldname = item.getFieldName();
                

                if (item.isFormField()) {

                	String value = Streams.asString(stream);
			   
                	if(fieldname.equals("imgURL")){
                		imgURL = value;
                        UserBean ub = new UserBean();
                        
				  		if(imgURL.contains(".")){
					  		
				  			ub.setProfileImage(username, imgURL);
				  			session.setAttribute("profileImg", imgURL);
				  				}
                              
                	}
                	

                	
			   } else {
				   

                   sfieldname = item.getFieldName();
                   final String sname = item.getName();

                   sctype = item.getContentType();
                   UserBean ub = new UserBean();


                   imgUpload = "https://storage.googleapis.com/logophilia/userfiles/"+username+"/images/profiles/"+sname;

                   
                   
                
                   
                   GcsFilename gcsfileName = new GcsFilename(bucketName, sname);

                   GcsFileOptions options = new GcsFileOptions.Builder().acl("public-read").mimeType(sctype).build();
                   GcsOutputChannel outputChannel;
                   outputChannel = gcsService.createOrReplace(gcsfileName, options);

                   copy(stream, Channels.newOutputStream(outputChannel));
                 

                   
              

                   
                   stream.close();
						
					
                   
                   
                   
                   ub.setProfileImage(username, imgUpload);
                   
     				session.setAttribute("profileImg", imgUpload);
				
               }
				
                
                
                
                
			}
			
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			
	

			
	
			
		RequestDispatcher rd = request.getRequestDispatcher("UserProfile.jsp");
			rd.forward(request, response);
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
