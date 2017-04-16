package etymologyOnline;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PopulateDatabaseServlet
 */
public class PopulateDatabaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PopulateDatabaseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Handling hand = new Handling();
		
		ArrayList<String> words = hand.getWords();
		
		ArrayList<String> etymologywords = hand.getEtymologyWords();
		
		words.removeAll(etymologywords);
		
		for(int i = 0; i < words.size(); i++){
			
		String word = words.get(i);	
		
		
//		for(String test: etymologywords){
			
			
//		if(!test.trim().contains(word.trim()) && word.length() > 3){
//		if(contains(etymologywords, word)){
		
			
			
//		}else{		
		
//		if(word.length() >= 3){
		String etymology = hand.getPage(word);
		
		if(etymology.length() > 10){
		hand.createEtymology(word, etymology);
		}
//		}
		
//		}
		
		
		}

		
		
//		}
		
		
		
		
		String etymologiesandwords = hand.getEtymology("a") ;
		
		
		String[] arr = etymologiesandwords.split(" !X ");
		
		String wordsA = arr[0].substring(1).replace(" !XZ ]", "");
		String etymologiesA = arr[1].substring(1).replace(" !XZ ]", "");
		
		ArrayList<String> wordsF = new ArrayList<String>(Arrays.asList(wordsA.split(" !XZ ,")));
		ArrayList<String> etymologyF = new ArrayList<String>(Arrays.asList(etymologiesA.split(" !XZ ,")));
		
		request.setAttribute("words", wordsF);
		request.setAttribute("etymologyArray", etymologyF);

		
		
		
		
		
        RequestDispatcher rd=request.getRequestDispatcher("test.jsp");    
        
        rd.forward(request,response);    
		
		
	}
	boolean contains(ArrayList<String> list, String name) {
	    for (String item : list) {
	        if (item.trim().contains(name.trim())) {
	            return true;
	        }
	    }
	    return false;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
