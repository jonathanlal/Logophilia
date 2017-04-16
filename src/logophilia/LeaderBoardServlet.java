package logophilia;

import java.io.IOException;
import java.util.ArrayList;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.LeaderBoard;

/**
 * Servlet implementation class LeaderBoardServlet
 */
public class LeaderBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LeaderBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//HttpSession session = (request.getSession());
        //String username = session.getAttribute("loggedInUser").toString();

//		request.getSession().getAttribute("loggedInUser");
//		String UserSelectionTodaysWord = request.getParameter("button1");
//		String UserSelectionViewT = request.getParameter("ViewT");
//		String UserSelectionViewL = request.getParameter("ViewL");
//		String user = session.getAttribute("loggedInUser").toString();
		//String charts = request.getParameter("leaderboard");
		
		
		
		
		
		
	//	if(charts != null){
		
		
		LeaderBoard lb = new LeaderBoard();
		
		ArrayList<String> leaderboard = lb.getLeaderBoard();
		ArrayList<String> SelectedUserArray = new ArrayList<String>();
		ArrayList<String> SelectedUserErosArray = new ArrayList<String>();
		
		for(int i = 0; i < leaderboard.size(); i++){
			
			String toArray = leaderboard.get(i);
			String[] userArray = toArray.split(",");
			String finaluser = userArray[0].substring(1);
			
			SelectedUserArray.add(finaluser);
			
			String[] ErosArray = toArray.split(",");
			String finaleros = ErosArray[1].substring(0, ErosArray[1].length()-1);

			SelectedUserErosArray.add(finaleros);
			
			
			
		}
		
		

		
		
		
		
		
		request.setAttribute("usernameLeaderBoard", SelectedUserArray);
		request.setAttribute("ErosLeaderBoard", SelectedUserErosArray);

		
		request.setAttribute("scores", leaderboard.size());
		
		
		RequestDispatcher rd = request.getRequestDispatcher("Leaderboard.jsp");
		rd.forward(request, response);
		
		
		
		
		
//	}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
