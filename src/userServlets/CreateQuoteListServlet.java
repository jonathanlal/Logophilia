package userServlets;



import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PushbackInputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Channels;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
//import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;

//import com.google.appengine.repackaged.com.google.io.base.Buffers.ByteArrayAdapter;
import com.google.appengine.tools.cloudstorage.GcsFileOptions;
import com.google.appengine.tools.cloudstorage.GcsFilename;
import com.google.appengine.tools.cloudstorage.GcsOutputChannel;
import com.google.appengine.tools.cloudstorage.GcsService;
import com.google.appengine.tools.cloudstorage.GcsServiceFactory;
import com.google.appengine.tools.cloudstorage.RetryParams;

import userBeans.QuoteLists;
import userBeans.QuotePost;
import userBeans.UserBean;
import userBeans.UserErosDao;



public class CreateQuoteListServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final int BUFFER_SIZE = 2 * 1024 * 1024;


    public CreateQuoteListServlet() {
        super();
    }
    
	private final GcsService gcsService = GcsServiceFactory.createGcsService(new RetryParams.Builder()
		      .initialRetryDelayMillis(10)
		      .retryMaxAttempts(10)
		      .totalRetryPeriodMillis(15000)
		      .build());

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
    	HttpSession session = (request.getSession());
        String username = session.getAttribute("loggedInUser").toString();
        String sizeSession = session.getAttribute("quotelistSize").toString();
        int size = Integer.parseInt(sizeSession.trim());
     
    	//Get date 
        Date creationTime = new Date(session.getCreationTime() );      
        DateFormat formatter = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM);   
        String date = formatter.format(creationTime).toString();
        
        QuoteLists ql = new QuoteLists();
        
        String bucketName = "logophilia/listimages/quotelist";

        String decider = null; 

  	  String sctype = null, sfieldname = null, sname = null;
        
      ServletFileUpload upload;
      FileItemIterator iterator;
      FileItemStream item = null;
      InputStream stream = null;
      ArrayList<String> authors = new ArrayList<String>();
      ArrayList<String> quotes = new ArrayList<String>();
      String name = null,description = null,imageURL = null,image = null;
//      int size = 0;
      
      try{
			
			upload = new ServletFileUpload();

			   iterator = upload.getItemIterator(request);
	            while (iterator.hasNext()) {
	                item = iterator.next();
	                stream = item.openStream();
	                String fieldname = item.getFieldName();
	                
		if (item.isFormField()) {
		  String value = Streams.asString(stream);

				  if (fieldname.equals("name")){
						 name = value;
				  }
				  if (fieldname.equals("description")){
					  description = value;
				  }
//				  if (fieldname.equals("size")){
//					  size = Integer.parseInt(value.trim());
//				  }
				  
				  for(int i = 0; i < size; i++){
				  if (fieldname.equals("quote_"+i)){
					String quote = value;
					quotes.add(quote);
				  }
				  if (fieldname.equals("author_"+i)){
					 String author = value;
					 authors.add(author);
				  }
				  }
				  
				  if (fieldname.equals("imageURL")){
					  imageURL = value;
                        UserBean ub = new UserBean();

				  		if(imageURL.contains(".")){
				  			decider = "url"; 
				  			
				  		    ql.CreateList(name, date, description, username, quotes, authors, imageURL);

				  			
				  				}
 
				  }
		 } else{
			  

             sfieldname = item.getFieldName();
             sname = item.getName();

             sctype = item.getContentType();
             
	


      
      
      if(decider == null){
          image = "https://storage.googleapis.com/logophilia/listimages/quotelist/"+sname;


       GcsFilename gcsfileName = new GcsFilename(bucketName, sname);

       GcsFileOptions options = new GcsFileOptions.Builder().acl("public-read").mimeType(sctype).build();
   GcsOutputChannel outputChannel;
   outputChannel = gcsService.createOrReplace(gcsfileName, options);


   copy(stream, Channels.newOutputStream(outputChannel));
   stream.close();
    	  
   	   
		    ql.CreateList(name, date, description, username, quotes, authors, image);
		   }

		  
		  }

			   
		   }
			 

	} catch (FileUploadException e) {
	e.printStackTrace();
} catch (Exception e) {
	e.printStackTrace();
} finally {
        
	
	
	UserBean ub = new UserBean();
	
	ub.createlistEros(username); // minus 10 eros
    String eros = UserErosDao.getNetEros(username.toString());
    String currenteros = UserErosDao.getCurrentEros(username.toString());
    session.setAttribute("currenteros", currenteros);
    session.setAttribute("eros", eros);
    
    
    ArrayList<ArrayList<String>> listinfo = ql.getListInfoProfile(username);
    
    
    ArrayList<String> listids = listinfo.get(0);
    ArrayList<String> listnames = listinfo.get(1);
    ArrayList<String> listsizes = listinfo.get(2);
    ArrayList<String> listlikes = listinfo.get(3); // fix this to get size of each element in it
    
    
    session.setAttribute("userquotelistids", listids);
	session.setAttribute("userquotelistsizes", listsizes);		
    session.setAttribute("userquotelistnames", listnames);
    session.setAttribute("userquotelistlikes", listlikes);
	
    
    
    
   	
    RequestDispatcher rd=request.getRequestDispatcher("UserProfile.jsp");    
    
     rd.forward(request,response);  
    
	
	
	
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