package logophilia;

import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.DailyWord;

/**
 * Servlet implementation class DailyWordServlet
 */
public class DailyWordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DailyWordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = (request.getSession());

		DailyWord dw = new DailyWord();
		
		ArrayList<String> dailywordinfo = dw.getDailyWord();
		
		String word = dailywordinfo.get(0);
		String definitions = dailywordinfo.get(1);
		
		Date now = new Date();
        DateFormat formatter = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM);       
        String date = formatter.format(now).toString();
		
		
        
        session.setAttribute("date", date);
        session.setAttribute("dailyword", word);
        session.setAttribute("dailyworddefinitions", definitions);
//		session.setAttribute("dailywords", word);
		
		  RequestDispatcher rd=request.getRequestDispatcher("index.jsp");    
	      
	      rd.forward(request,response);    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
