package database;
import java.io.*;
import java.util.ArrayList;

import org.jsoup.*;
import org.jsoup.nodes.Document;


public class DailyWord {
	
	DailyWordDao dwdao = new DailyWordDao();
	
	public String wotd(){
		
		Document doc = null;
		
		try{
			doc = Jsoup.connect("https://en.wiktionary.org/wiki/Wiktionary:Word_of_the_day").get();
		}catch(IOException e){
			e.printStackTrace();
		}
		String content = doc.select("td").get(1).text();
		
		String word = content.replaceAll("\\s(.*, replacement)","");
		
//		System.out.println(word);
		return word;
		
	}
	
	public void setDailyWord(String word, String definition, String date){
		
		dwdao.setDailyWordInDB(word, definition, date);
		
	}
	
	public ArrayList<String> getDailyWord(){
		
		
		return dwdao.getDailyWordInDB();
	}
	

}
