package logophilia;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Wikipedia {
	
	
	
	
	
	
	
	public String getBeg(String search){
		
		String beg = null;
		
        Document doc = null;
		try {
			doc = Jsoup.connect("http://en.wikipedia.org/wiki/"+search).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Elements getP = doc.select("p");
		Element firstP = doc.select("p").first();
//		Element toc = doc.getElementById("toc");
//		Element nextSib = doc.
		
//		String test = nextSib.tagName();
		
		for(int i = 0; i < getP.size(); i++){
			Element nextSib = doc.select("p").get(i);
			String element = nextSib.html();
			
			 beg = beg + element;

			if(element.contains("")){
				
				return beg;
			}
			
		}
		return beg;
		
	}
	
	
	
		
		public String getExtended(String search){
		String extended = null;
		
		  Document doc = null;
			try {
				doc = Jsoup.connect("http://en.wikipedia.org/wiki/"+search).get();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			
		
		
			return extended;
		}
		
		
		//ArrayList<Element> beg = doc.select("p");
//		String beg = getP.html();
//		
//		
//		
//		
//		
//		return beg;
//	}
	
	
	
	public String getPage(String search){
		
        Document doc = null;
		try {
			doc = Jsoup.connect("http://en.wikipedia.org/wiki/"+search).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
        String page = doc.html();
		
		
		return page;
		
	}
	
	
	
	
	
	

}
