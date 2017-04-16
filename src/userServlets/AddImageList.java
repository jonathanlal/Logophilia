package userServlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

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

import logos.Logophilia;
import userBeans.SavedWords;
import userBeans.UserBean;
import userBeans.UserErosDao;
import userBeans.UserFeed;
import userBeans.WordLists;
import wordnet.WordNet;


public class AddImageList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  private static final int BUFFER_SIZE = 2 * 1024 * 1024;

    public AddImageList() {
        super();
    }
    private final GcsService gcsService = GcsServiceFactory.createGcsService(new RetryParams.Builder()
  	      .initialRetryDelayMillis(10)
  	      .retryMaxAttempts(10)
  	      .totalRetryPeriodMillis(15000)
  	      .build());


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = (request.getSession());
		String username = session.getAttribute("loggedInUser").toString();
		
//		String id = request.getParameter("id");
//		String type = request.getParameter("type");
//		String word = request.getParameter("word");
		
        Date now = new Date();
        DateFormat formatter = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM);
        
        String date = formatter.format(now).toString();
		

		Logophilia logos = new Logophilia();


			
			   String bucketName = "logophilia/wordimages";
			   
			   
		        String decider = null; 
		        
		    	  String sctype = null, sfieldname = null, sname = null;
		  		String definitionFromMerriam = null;
		  		ArrayList<String> definitionFromWordNet = null;
		  		
			
			
		  		 ServletFileUpload upload;
		  	      FileItemIterator iterator;
		  	      FileItemStream item = null;
		  	      InputStream stream = null;
//		  	      int wordID = 0; 
			
			
		          String word = null,id = null,imageURL = null,definition = null,image = null, type = null;

			
		          
		          try{
		  			
		  			upload = new ServletFileUpload();

		  			   iterator = upload.getItemIterator(request);
		  	            while (iterator.hasNext()) {
		  	                item = iterator.next();
		  	                stream = item.openStream();
		  	                String fieldname = item.getFieldName();
		  	                
		  				   if (item.isFormField()) {
		 					  String value = Streams.asString(stream);
		 					  
		 					  if (fieldname.equals("id")){
								  id = value;
							  }  
							  if (fieldname.equals("type")){
								  type = value;
							  }  
		 					  if (fieldname.equals("word")){
		 						 word = value;
		 					
		 						boolean checkifwordexists = logos.checkIfWordExists(word);
		 						
		 						if(!checkifwordexists){	 	
		 							logos.addWord(word, date, username);
		 							int wordID = logos.getWordID(word);
		 							
		 					    	 definitionFromWordNet = definitionWordNetArray(word);
							  		String def2 = definitionFromWordNet.toString().substring(1, definitionFromWordNet.toString().length() -1);
							  		
									logos.addDefinition(def2, wordID, date, username, "WordNet");
		 						}
							  }
							  if (fieldname.equals("imageURL")){
								  imageURL = value;

							  		if(imageURL.contains(".")){
							  			decider = "url"; 
							  			int wordID2 = logos.getWordID(word);
										logos.addImage(imageURL, wordID2, date, username);
							  			
							  			
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
//						  		String def2 = definitionFromWordNet.toString().substring(1, definitionFromWordNet.toString().length() -1);
		                	   int wordID = logos.getWordID(word);
								logos.addImage(imageURL, wordID, date, username);
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
				       	userbean.addErosListnet(username);
				       	userbean.addErosListcurrent(username);
					
						String eros = UserErosDao.getNetEros(username);
						String currenteros = UserErosDao.getCurrentEros(username);
				   
				        session.setAttribute("currenteros", currenteros);
				        session.setAttribute("eros", eros);

						

						
//							doGet(request, response);
				        
				        
				        
				        
				    	WordLists ul = new WordLists();
						ArrayList<String> likesUsers;
						int likesSize;
						ArrayList<String> list = ul.getAllFromList(Integer.parseInt(id));	
						
						String name = list.get(0);
						String description = list.get(1);
						String size = list.get(2);
						String likesString = list.get(3);
						
						if(likesString != null){
						likesUsers = new ArrayList<String>(Arrays.asList(likesString.split(",")));
						likesSize = likesUsers.size();
						}else{
						likesUsers = new ArrayList<String>();
						likesSize = 0;
						}

						String creator = list.get(4);		
						String wordsString = list.get(5).replace(" ", ""); // remove spaces from string of words
						ArrayList<String> words = new ArrayList<String>(Arrays.asList(wordsString.split(",")));
						
						String definitionsString = list.get(6).replace("]]", "").replace("[[", "");
						ArrayList<String> definitionsMaster = new ArrayList<String>(Arrays.asList(definitionsString.split("], \\[")));
							ArrayList<ArrayList<String>> definitionsAll = new ArrayList<ArrayList<String>>();		
							for(int i = 0; i < definitionsMaster.size(); i++){
								String replacedSplitChar = definitionsMaster.get(i).replace("], [", "");
								ArrayList<String> definitions = new ArrayList<String>(Arrays.asList(replacedSplitChar.split(",")));
								definitionsAll.add(definitions);
							}
						
						String date2 = list.get(7);
				   	String listdate = date2.substring(0, 11);
				   	String listtime = date2.substring(12,20);
						
						String imagelist = list.get(8);	
						
						
						
						String comments = list.get(9);
						ArrayList<String> commentsArray = new ArrayList<String>();
						if(comments != null){
						commentsArray = new ArrayList<String>(Arrays.asList(comments.split(" !X ")));
						commentsArray.remove(0);
						}
						  request.setAttribute("commentsArray", commentsArray);
						  request.setAttribute("commentsArraySize", commentsArray.size());

						
						
						SavedWords sw = new SavedWords();
				       ArrayList<String> savedwords = sw.getSavedWords(username);
				       ArrayList<String> savedwordsArray = new ArrayList<String>();
				    	boolean found = false;  	
				    	if(savedwords.size()> 0){    	
				       for(int i = 0; i < words.size(); i ++){
				       	
				       	String check = words.get(i);

				       	for(int x = 0; x < savedwords.size();x++){
				       		
				           	if(savedwords.get(x).contains(check)){
				           		savedwordsArray.add("yes");
				           		found = true;
				           	}           	
				       	}
				       	if(!found){
				       		savedwordsArray.add("no");
				       	}
				       	found = false;
				       }        
				    	}       
						
						
						  request.setAttribute("SavedWordsListCheck", savedwordsArray);

						
						  ArrayList<ArrayList<String>> wordimages = new ArrayList<ArrayList<String>>();
						  for(int i = 0; i <words.size();i++){
							  ArrayList<String> images = new ArrayList<String>();
							  int wordID = logos.getWordID(words.get(i));
							  images = logos.getImages(Integer.toString(wordID));
							  wordimages.add(images);
						  }
						  request.setAttribute("wordimagesArray", wordimages);
						  
						
						// for likes getParameters
						request.setAttribute("typelist", "w");
						request.setAttribute("idlist", Integer.parseInt(id));
						request.setAttribute("listname", name);
				       request.setAttribute("listdate", listdate);
				       request.setAttribute("listtime", listtime);
				       request.setAttribute("listcreator", creator);
				       request.setAttribute("wordsfromDB", words);
				       request.setAttribute("definitionsfromDB", definitionsAll);       
				       request.setAttribute("description", description);
				       request.setAttribute("listsize", size);               
				       request.setAttribute("listimage", imagelist);
				       request.setAttribute("listlikesSize", likesSize);
				       request.setAttribute("listlikes", likesUsers);

						
						
				       RequestDispatcher rd=request.getRequestDispatcher("List.jsp");    
				       
				       rd.forward(request,response); 
				       
				        


			
				}



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
