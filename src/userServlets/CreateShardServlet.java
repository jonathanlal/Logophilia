package userServlets;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import userBeans.Shard;

/**
 * Servlet implementation class CreateShardServlet
 */
public class CreateShardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateShardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

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
      String username = session.getAttribute("loggedInUser").toString();
//		String username = "jona";
  	
      
      
		String shard = request.getParameter("content"); // insert this to text file and save on google storage then save the file location in DB

		
		
		
		
		
		String title = request.getParameter("title");
		
      
      Date creationTime = new Date(session.getCreationTime() );
//    Date now = new Date();
    DateFormat formatter = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM);
    
    String time = formatter.format(creationTime).toString();
      
      
    
    Shard shards = new Shard();
    
    shards.createShard(title, "not implemented", shard, time, username);
    
    
    
    
    
    
    
    
   
    
    
    
    
    
    
    
      
      RequestDispatcher rd=request.getRequestDispatcher("test.jsp");    
      
      rd.forward(request,response);    
		
		
		
		
		
		
		
		
		
	}

}
