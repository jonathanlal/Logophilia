package etymologyOnline;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.appengine.api.utils.SystemProperty;

public class DatabaseDao {
	
	
	public ArrayList<String> getAllWords(){
		
		
		ArrayList<String> words = new ArrayList<String>();

		 boolean status = false;  
		 String url = null;
		 PreparedStatement pst = null;  
		 ResultSet rs = null;  
		 Connection conn = null;

		 try{

		 if (SystemProperty.environment.value() ==
		     SystemProperty.Environment.Value.Production) {
		   // Connecting from App Engine.
		   // Load the class that provides the "jdbc:google:mysql://"
		   // prefix.
		   Class.forName("com.mysql.jdbc.GoogleDriver");
		   url =
		     "jdbc:google:mysql://logophilia-1385:us-central1:logophiliadb/wordnet31";
		 } else {
		   // Connecting from an external network.
		   Class.forName("com.mysql.jdbc.Driver");
		   url = "jdbc:mysql://localhost:3306/wordnet31?user=root";
		 }

		 conn = DriverManager.getConnection(url,"root","1234");
				pst = conn.prepareStatement("select lemma from words where lemma REGEXP '^[A-Za-z]*$';");

//				pst.setInt(1, wordID);

				rs = pst.executeQuery();

				while (rs.next()) {

					String word = rs.getString(1);
					words.add(word);

				}

			} catch (Exception e) {
				System.out.println(e);
			} finally {
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if (pst != null) {
					try {
						pst.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			return words;

		
	}
	
	
	public void createEtymologyInDB(String word, String etymology) {

		 boolean status = false;  
		 String url = null;
		 PreparedStatement pst = null;  
		 ResultSet rs = null;  
		 Connection conn = null;

		 try{

		 if (SystemProperty.environment.value() ==
		     SystemProperty.Environment.Value.Production) {
		   // Connecting from App Engine.
		   // Load the class that provides the "jdbc:google:mysql://"
		   // prefix.
		   Class.forName("com.mysql.jdbc.GoogleDriver");
		   url =
		     "jdbc:google:mysql://logophilia-1385:us-central1:logophiliadb/logophilia";
		 } else {
		   // Connecting from an external network.
		   Class.forName("com.mysql.jdbc.Driver");
		   url = "jdbc:mysql://localhost:3306/etymology?user=root";
		 }

		 conn = DriverManager.getConnection(url,"root","1234");

			pst = conn.prepareStatement(
					"insert into etymology (word,etymology) values (?,?);");

			pst.setString(1, word);
			pst.setString(2, etymology);


			pst.executeUpdate();
			rs = pst.executeQuery("SELECT LAST_INSERT_ID()");

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}


	public String getEtymologyFromDB(String word) {
		
//		ArrayList<String> words = new ArrayList<String>();
String etymology = null;
		 boolean status = false;  
		 String url = null;
		 PreparedStatement pst = null;  
		 ResultSet rs = null;  
		 Connection conn = null;

		 try{

		 if (SystemProperty.environment.value() ==
		     SystemProperty.Environment.Value.Production) {
		   // Connecting from App Engine.
		   // Load the class that provides the "jdbc:google:mysql://"
		   // prefix.
		   Class.forName("com.mysql.jdbc.GoogleDriver");
		   url =
		     "jdbc:google:mysql://logophilia-1385:us-central1:logophiliadb/wordnet31";
		 } else {
		   // Connecting from an external network.
		   Class.forName("com.mysql.jdbc.Driver");
		   url = "jdbc:mysql://localhost:3306/etymology?user=root";
		 }

		 conn = DriverManager.getConnection(url,"root","1234");
				pst = conn.prepareStatement("select etymology from etymology where word = ?");

				pst.setString(1, word);

				rs = pst.executeQuery();

				while (rs.next()) {

					etymology = rs.getString(1);
//					words.add(word);

				}

			} catch (Exception e) {
				System.out.println(e);
			} finally {
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if (pst != null) {
					try {
						pst.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			return etymology;

		
	}


	public ArrayList<String> getEtymologyWordsFromDB() {
		
		ArrayList<String> words = new ArrayList<String>();

		 boolean status = false;  
		 String url = null;
		 PreparedStatement pst = null;  
		 ResultSet rs = null;  
		 Connection conn = null;

		 try{

		 if (SystemProperty.environment.value() ==
		     SystemProperty.Environment.Value.Production) {
		   // Connecting from App Engine.
		   // Load the class that provides the "jdbc:google:mysql://"
		   // prefix.
		   Class.forName("com.mysql.jdbc.GoogleDriver");
		   url =
		     "jdbc:google:mysql://logophilia-1385:us-central1:logophiliadb/wordnet31";
		 } else {
		   // Connecting from an external network.
		   Class.forName("com.mysql.jdbc.Driver");
		   url = "jdbc:mysql://localhost:3306/etymology?user=root";
		 }

		 conn = DriverManager.getConnection(url,"root","1234");
				pst = conn.prepareStatement("select word from etymology");

//				pst.setInt(1, wordID);

				rs = pst.executeQuery();

				while (rs.next()) {

					String word = rs.getString(1);
					words.add(word);

				}

			} catch (Exception e) {
				System.out.println(e);
			} finally {
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if (pst != null) {
					try {
						pst.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			return words;

		
	}
	
	
	
	
	

}
