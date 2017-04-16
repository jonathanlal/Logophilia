package database;

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

import logophilia.Wikipedia;
import logophilia.google2;
import userBeans.QuotePost;
import userBeans.Shard;
import userBeans.UserFeed;
import userBeans.UserFeedDao;
import userBeans.WordLists;
import userBeans.WordPost;
import userBeans.WordPostDao;

/**
 * Servlet implementation class TestServlet
 */
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  private static final int BUFFER_SIZE = 2 * 1024 * 1024;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
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
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    	
//    	HttpSession session = (request.getSession());
//      String username = session.getAttribute("loggedInUser").toString();
////		String username = "springy";
//      
//    	
//    	WordPost wp = new WordPost();
//    	wp.addLikeWordPost(username, "1");
//    	
//    	int likes = wp.getLikesWordPost("1").size()-1; //-1 because the comma (,) in the beginning of the arraylist
//    	
//    	session.setAttribute("likestest", likes);
//    	
//        String text = "oh wow this is cool, should have worked, check";
//
//        response.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.
//        response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
//        response.getWriter().write(text);       // Write response body.
//    }

    
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	
    	google2 google = new google2();
		String googleResults = google.finalResults("cow");
		List<String> myList = new ArrayList<String>(Arrays.asList(googleResults.split("\\s+")));
		request.setAttribute("myList", myList);									
		
		
		
	      RequestDispatcher rd=request.getRequestDispatcher("test.jsp");    
	      
	      rd.forward(request,response);    
		
    	
    	
    }
    
    
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
}
