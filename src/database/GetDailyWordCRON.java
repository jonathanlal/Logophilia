package database;

import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wordnet.WordNet;


public class GetDailyWordCRON extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public GetDailyWordCRON() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		DailyWord dw = new DailyWord();
		WordNet wn = new WordNet();
		
		String word = dw.wotd();
		
        Date now = new Date();
        DateFormat formatter = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM);       
        String date = formatter.format(now).toString();
		
		ArrayList<String> definitions = wn.getDefinitions(word);
		String def1 =  definitions.toString().substring(1);
  		String def2 = def1.substring(1, def1.length() -1);
        
  		dw.setDailyWord(word, def2, date);
  		
  		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
