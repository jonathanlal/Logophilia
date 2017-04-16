package logophilia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Pattern;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;

public class google2 {
	StringBuilder results = new StringBuilder();
	String finalResults;


	public  String psuedomain(String qry) throws IOException {

//		String key = "AIzaSyDYXqosDvLdZK4VYwF00zeq46YzYUFPznA";
//		URL url = new URL("https://www.googleapis.com/customsearch/v1?key=" + key
//				+ "&cx=AIzaSyC5A4amwKe8cTQL0f2bWD20hTvdletd-_g&q=" + qry + "&alt=json");

		
		String key = "AIzaSyABOpf35pB-LYESGbxfhDogNB3hbizy6Z8";
		String cx = "003844057964482485756%3Agk9sat4nqji";
		
	URL url = new URL ("https://www.googleapis.com/customsearch/v1?q="+qry+"&cx="+cx+"&key="+key);
		
		
		
		// CONNECTION LOGIC
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");
		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
		String output;
		while ((output = br.readLine()) != null) {
			Pattern pattern = Pattern.compile("(?:(?:https?)+\\:\\/\\/+[a-zA-Z0-9\\/\\._-]{1,})+(?:(?:jpe?g|png|gif))");
			Matcher matcher = pattern.matcher(output);
			if (matcher.find()) {
				results.append(matcher.group() + "\n");
			}

		}
		conn.disconnect();
		finalResults = removeDup();
		return finalResults;
	}

	public  String removeDup() {
		String[] tokens = results.toString().split("\n");
		StringBuilder resultBuilder = new StringBuilder();
		Set<String> alreadyPresent = new HashSet<String>();

		boolean first = true;
		for (String token : tokens) {

			if (!alreadyPresent.contains(token)) {
				if (first)
					first = false;
				else
					resultBuilder.append("\n");

				if (!alreadyPresent.contains(token))
					resultBuilder.append(token + "\n");
			}

			alreadyPresent.add(token);
		}
		String result = resultBuilder.toString();
		return result;
	}
	
	public String finalResults(String query){
		
		try {
			psuedomain(query);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return finalResults;
		
		
	}

}
