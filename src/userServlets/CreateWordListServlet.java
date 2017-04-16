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

import userBeans.UserBean;
import userBeans.UserErosDao;
import userBeans.WordLists;


public class CreateWordListServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final int BUFFER_SIZE = 2 * 1024 * 1024;
	
//	int LISTSIZE1;
//	String imageSaveURLString;
//	
	

    public CreateWordListServlet() {
        super();
    }
    
	private final GcsService gcsService = GcsServiceFactory.createGcsService(new RetryParams.Builder()
		      .initialRetryDelayMillis(10)
		      .retryMaxAttempts(10)
		      .totalRetryPeriodMillis(15000)
		      .build());

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
    	HttpSession session = (request.getSession());
        String username = session.getAttribute("loggedInUser").toString();
        

//        String name = request.getParameter("wordlistname"); //.replace(all illegal chars windows does not accept for filenames, "");
//        String imageURL = request.getParameter("imageURL");
//        String imageLOCAL = request.getParameter("imageLOCAL");     
//        String description = request.getParameter("description");
//        String newlistofwords = request.getParameter("NewWordList");
        
//        String returnPage = null;
        
        
//             
//        UserBean ub = new UserBean();
//        boolean listexist = ul.checkIfListExists(name);
//        boolean usernamecheckeros = ub.checkEnoughtoCreateListEros(username);
        

        
        
//if(listexist == false && usernamecheckeros == true){ // if file does not exist and user has enough eros
	  
	
	
	
	//Get date 
    Date creationTime = new Date(session.getCreationTime() );      
    DateFormat formatter = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM);   
    String date = formatter.format(creationTime).toString();
	
	
	
    WordLists ul = new WordLists();
	
	
    String bucketName = "logophilia/listimages/wordlist";

    String decider = null; 

	  String sctype = null, sfieldname = null, sname = null;

	  ArrayList<ArrayList<String>> definitionFromWordNet = null; //array list of arraylists.. 
//	  ArrayList<String> words = null;

    ServletFileUpload upload;
    FileItemIterator iterator;
    FileItemStream item = null;
    InputStream stream = null;
	
	
    String name = null,description = null,newlistofwords = null,imageURL = null,image = null;


    try{
			
			upload = new ServletFileUpload();

			   iterator = upload.getItemIterator(request);
	            while (iterator.hasNext()) {
	                item = iterator.next();
	                stream = item.openStream();
	                String fieldname = item.getFieldName();
	                
		if (item.isFormField()) {
		  String value = Streams.asString(stream);

				  if (fieldname.equals("wordlistname")){
						 name = value;
				  }
				  if (fieldname.equals("description")){
					  description = value;
				  }
				  if (fieldname.equals("words")){
					  newlistofwords = value;
//					  newlistofwords = "majestic, kitchen, rubble";
//			  			words = new ArrayList<String>(Arrays.asList(newlistofwords.split(",")));

				  }

				  
				  if (fieldname.equals("imageURL")){
					  imageURL = value;
                        UserBean ub = new UserBean();

				  		if(imageURL.contains(".")){
				  			decider = "url"; 
				  			


				  		    ul.CreateListWordNet(name, date, description, username, newlistofwords, imageURL);

				  			
				  				}
					  
					  
				  }
				  
				  
		   } else{
				  

                  sfieldname = item.getFieldName();
                  sname = item.getName();

                  sctype = item.getContentType();
                  
		

                  image = "https://storage.googleapis.com/logophilia/listimages/wordlist/"+sname;


               GcsFilename gcsfileName = new GcsFilename(bucketName, sname);

	           GcsFileOptions options = new GcsFileOptions.Builder().acl("public-read").mimeType(sctype).build();
           GcsOutputChannel outputChannel;
           outputChannel = gcsService.createOrReplace(gcsfileName, options);


           copy(stream, Channels.newOutputStream(outputChannel));
           stream.close();
           
           
           if(decider == null){
        	   
//	  			words = new ArrayList<String>(Arrays.asList(newlistofwords.split(",")));

	  		    ul.CreateListWordNet(name, date, description, username, newlistofwords, image);
			   }

			  
			  }

				   
			   }
				 

		} catch (FileUploadException e) {
		e.printStackTrace();
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
				  
				  
				  
				  
				  
				  
				  
				  
	
	
	
	
	
//	int LISTSIZE1 = ub.gettotalamountofuserlist(username); // to garuantee that the user does not lose eros by double clicking or whatever
    	
	

  
    
 	//put words from input into array seperating each word with a space 
//	ArrayList<String> wordsArrayList = new ArrayList<String>(Arrays.asList(newlistofwords.split("\\s+")));

//    ul.CreateList(name, date, description, username, wordsArrayList);

				
		
		UserBean ub = new UserBean();
		
		ub.createlistEros(username); // minus 10 eros
	    String eros = UserErosDao.getNetEros(username.toString());
	    String currenteros = UserErosDao.getCurrentEros(username.toString());
        session.setAttribute("currenteros", currenteros);
        session.setAttribute("eros", eros);
        
        
        ArrayList<ArrayList<String>> listinfo = ul.getListInfoProfile(username);
        
        
        ArrayList<String> listids = listinfo.get(0);
        ArrayList<String> listnames = listinfo.get(1);
        ArrayList<String> listsizes = listinfo.get(2);
        ArrayList<String> listlikes = listinfo.get(3); // fix this to get size of each element in it
        
        
        session.setAttribute("userlistids", listids);
    	session.setAttribute("userlistsizes", listsizes);		
        session.setAttribute("userlistnames", listnames);
        session.setAttribute("userlistlikes", listlikes);
		
        
        
        
       	
        RequestDispatcher rd=request.getRequestDispatcher("UserProfile.jsp");    
        
         rd.forward(request,response);  
        
        
		
		
	}
		
		
		
		
		
		
		

   
				
				
				
			     
			      
			      
   
//					int LISTSIZE2 = ub.gettotalamountofuserlist(username);
//			    	if(LISTSIZE2 > LISTSIZE1){ // only minus points if list size is changed and list was reallly created					     	
			    		
				
//				        returnPage = "/UserProfile.jsp";
//			    				}
 
				
//			    	RequestDispatcher rd=request.getRequestDispatcher("/UserProfile.jsp");    
//
//			    	rd.forward(request,response);    
	           
	         //------------------------------------------------------------------//------------------------------------------------------------------

//				}
	
        	
        	
//    } 
   
		
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
