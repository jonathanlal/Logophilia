package etymologyOnline;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Handling {
	
	DatabaseDao dbdao = new DatabaseDao();

	
	public ArrayList<String> getWords(){	
		
		return dbdao.getAllWords();
		
	}
	
	public void createEtymology(String word, String etymology){
		
		dbdao.createEtymologyInDB(word, etymology);
	}
	
	
	
	public String getPage(String word) throws SocketTimeoutException,NullPointerException{
		

	    Document doc = null;
	    try {
	        doc = Jsoup.connect("http://www.etymonline.com/index.php?allowed_in_frame=0&search="+word).userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36").get();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } catch (NullPointerException e){
	    	e.printStackTrace();
	    }
	    

	    
	    
	    ArrayList<String> words = new ArrayList<String>();
	    Elements wordsE = doc.select("dt");
	    
	    for(int i = 0; i < wordsE.size(); i++){
	    	
	    	words.add(wordsE.get(i).text() + " !XZ ");
	    	
	    }
	    
	    ArrayList<String> etymology = new ArrayList<String>();
	    Elements etymologyE = doc.select("dd");
	    
	    for(int i = 0; i < etymologyE.size(); i++){
	    	
	    	etymology.add(etymologyE.get(i).text() + " !XZ ");
	    	
	    }
	    
	    
	    

	    return words.toString() + " !X " + etymology.toString();
		
	}

	public String getEtymology(String word) {
	
		return dbdao.getEtymologyFromDB(word);
	}
	
	public ArrayList<String> getEtymologyWords(){
		
		return dbdao.getEtymologyWordsFromDB();
	}
	
	

}
