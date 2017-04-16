package logophilia;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merriam {
	StringBuilder results = new StringBuilder();
	String finalResults;
	String finalword;
	String finaldefinition;
	String finaletymology;
	String finalSound;
	String finalCollImg;
	
	String finalDefWordShuffle;

	ArrayList<String> definitionsList;
	ArrayList<String> wordsList;
	ArrayList<String> etymologyList;
	ArrayList<String> finalSoundList;
	ArrayList<String> finalCollImgList;

	ArrayList<String> DefWordShuffle;
	
	
	String qry;
	int qSize;
	

	public String psuedomain(String qry) throws IOException {
		wordsList = new ArrayList<String>();
		definitionsList = new ArrayList<String>();
		etymologyList = new ArrayList<String>();
		finalSoundList = new ArrayList<String>();
		finalCollImgList = new ArrayList<String>();
		
		DefWordShuffle = new ArrayList<String>();
		
		//int count = 1;

		String key = "?key=16467c38-7391-4c16-aeb5-e656c87f5f3f";

		URL url = new URL("http://www.dictionaryapi.com/api/v1/references/collegiate/xml/" + qry + key);

		String urlstring = url.toString();

		// CONNECTION LOGIC
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/xml");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		// Results LOOP
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(urlstring);
			doc.getDocumentElement().normalize();
			NodeList nListw = doc.getElementsByTagName("entry");
			NodeList nListet = doc.getElementsByTagName("et");
			NodeList nListdef = doc.getElementsByTagName("def");
			NodeList nListdef2 = doc.getElementsByTagName("def");
			
		//	NodeList nListdt = doc.getElementsByTagName("dt");
			NodeList nListCImg = doc.getElementsByTagName("capt");
			NodeList nListSound = doc.getElementsByTagName("sound");
			int nListSIZE = nListw.getLength();

			conn.disconnect();

			qSize = nListSIZE;

					// GET WORDS
					for (int temp = 0; temp < nListw.getLength(); temp++) {
						Node nNode = nListw.item(temp);
						Element eElement2 = (Element) nNode;
						String words = ("Word-" + temp + ": " + eElement2.getAttributeNode("id").getValue());
						//wordsList.add("<p>");

						wordsList.add(words);
						
						
						//DefWordShuffle.add(words);

					}
					// GET DEFINITIONS
					for (int temp = 0; temp < nListdef.getLength(); temp++) {
						Node nNode = nListdef.item(temp);
						Element eElement2 = (Element) nNode;
						String definitions = ("Definition-" + temp + ": " + eElement2.getTextContent());
						//definitionsList.add("<p>");

						definitionsList.add(definitions);
						
						//DefWordShuffle.add(definitions);
					}
					//SHUFFLE LOOP AND SHIT
					for (int rack = 0; rack <= nListdef2.getLength(); rack++) {                                   // Full results need to be dynamically shown 
						//Node nNode = nListdef2.item(rack);
						//Element eElement2 = (Element) nNode;
						//String definitions = ("DEFINITION-" + rack + ": " + eElement2.getTextContent());
					//	String WaD = "WORD-"+rack+": "+ eElement2.getAttributeNode("id").getValue() + "DEFINITION-"+rack+": "+ 
						
						
						
//						DefWordShuffle.add(wordsList.get(rack));

//						DefWordShuffle.add(definitionsList.get(rack)); 			//definitionsList.get(rack)
						
						
						
					}	
					// GET ETYMOLOGY
					for (int temp = 0; temp < nListet.getLength(); temp++) {
						Node nNode = nListet.item(temp);
						Element eElement2 = (Element) nNode;
						String etymology = ("<b>Etymology-" + temp + ": </b>" + eElement2.getTextContent());
						etymologyList.add("<p>");
						etymologyList.add(etymology);
		
					}
					// GET CAPTION FOR MERRIAM IMAGE
					for (int temp = 0; temp < nListCImg.getLength(); temp++) {
						Node nNode2 = nListCImg.item(temp);
						Element eElement3 = (Element) nNode2;
						String collimg = (" " + eElement3.getTextContent());
						finalCollImgList.add(collimg);
					}
					// GET SOUNDS
					for (int temp = 0; temp < nListSound.getLength(); temp++) {
						Node nNode = nListSound.item(temp);
						Element eElement2 = (Element) nNode;
						String playsound = (eElement2.getTextContent());
						String audioNoB = playsound.replaceAll("!.*", "");
						String audioHead = "http://media.merriam-webster.com/soundc11/";
						String firstLetterDir = audioNoB.substring(0, 1);
		
								// SOUND CONDITIONS
		//						if (firstLetterDir.contains("b")) {
		//							String middle = "bix/";
		//							String middle2 = "b/";
		//							String audioFinal = audioHead + middle + audioNoB;
		//							String audioFinal2 = audioHead + middle2 + audioNoB;
		//							finalSoundList.add(audioFinal);
		//							finalSoundList.add(audioFinal2);
		//		
		//						} else if (firstLetterDir.contains("g")) {
		//							String middle = "gg/";
		//							String middle2 = "g/";
		//							String audioFinal = audioHead + middle + audioNoB;
		//							String audioFinal2 = audioHead + middle2 + audioNoB;
		//							finalSoundList.add(audioFinal);
		//							finalSoundList.add(audioFinal2);
		//						} else {
		//		
									String middle = "" + firstLetterDir + "/";
									String audioFinal = audioHead + middle + audioNoB;
									finalSoundList.add(audioFinal);
		//							}

			}		

					//count++;
					
					
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch(ArrayIndexOutOfBoundsException e){
			e.printStackTrace();
		}
		
		
	
		
		finaldefinition = definitionsList.toString();
		finalword = wordsList.toString();
		finaletymology = etymologyList.toString();
		finalSound = finalSoundList.toString();
		finalCollImg = finalCollImgList.toString();
		
		//SHUFFLE LOGIC
//		wordsList.addAll(definitionsList);
//		Collections.sort(wordsList);
		finalDefWordShuffle = DefWordShuffle.toString();
		
		
		

		String epic = finalword + "^!"+ finaldefinition + "^!" + finaletymology + "^!" + finalSound + "^!"+ finalCollImg + "^!" + qSize + "^!" + finalDefWordShuffle;

		return epic;
	}

	public String finalResults(String query) throws IOException {

		return psuedomain(query);

	}
	
	public String getDefinition(String query) throws IOException{
		
		
		String results = psuedomain(query);
		List<String> myList2 = new ArrayList<String>(Arrays.asList(results.split("\\^!")));
		String firstdefinition = myList2.get(1);

		String firstdefinitionOnly1 = firstdefinition.replaceAll(", Definition-1:.*", "");
		String finaldefinitionlol = firstdefinitionOnly1.replaceAll("Definition-0:", "");			
		String finaldefinitionlolagain = finaldefinitionlol.substring(1);
				
		String[] finaldefinitionlolagain3 = finaldefinitionlolagain.split("( [a-z] \\()");
		
		int getbiggeronelol0 = finaldefinitionlolagain3[0].length();
		//int getbiggeronelol1 = finaldefinitionlolagain3[1].length();
		
		if(getbiggeronelol0 < 24){
			//fixes the fuck up where the first definition of the array is not included fully. 
			String wholedefinition = finaldefinitionlolagain3[0] + finaldefinitionlolagain3[1];
			return wholedefinition;

			
		}else{
			
			return finaldefinitionlolagain3[0];

		}
		
		
		
		
	}
	
	
	

}
