package wordnet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.appengine.api.utils.SystemProperty;

public class WordNetDao {

	public int getWordIDFromDB(String word) {

			int wordid = 0;
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
					pst = conn.prepareStatement("select * from words where lemma=?;");

					pst.setString(1, word);

					rs = pst.executeQuery();

					while (rs.next()) {
//					
						wordid = rs.getInt(1);
					


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
				return wordid;
			}

	public ArrayList<Integer> getDefinitionIDsFromDB(int wordID) {
		
		ArrayList<Integer> definitionIds = new ArrayList<Integer>();

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
				pst = conn.prepareStatement("select synsetid from senses where wordid=?;");

				pst.setInt(1, wordID);

				rs = pst.executeQuery();

				while (rs.next()) {

					int id = rs.getInt(1);
					definitionIds.add(id);

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
			return definitionIds;
		
	}

	public String getDefinition(int wordid) {
	
		String definition = null;
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
				pst = conn.prepareStatement("select definition from synsets where synsetid=?;");

				pst.setInt(1, wordid);

				rs = pst.executeQuery();

				while (rs.next()) {

					 definition = rs.getString(1);
			
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
			return definition;
		
		
		
		
	}

	public ArrayList<Integer> getSynonymIDsFromDB(ArrayList<Integer> synsetID) {
		
		ArrayList<Integer> wordIDs = new ArrayList<Integer>();

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
		 
		 
		 
		 
		 for(int i = 0; i < synsetID.size();i++){
			 
			 
			 
				pst = conn.prepareStatement("select wordid from senses where synsetid=?;");

				pst.setInt(1, synsetID.get(i));

				rs = pst.executeQuery();

				while (rs.next()) {

					int id = rs.getInt(1);
					wordIDs.add(id);

				}
			 
			 
			 
			 
			 
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
			return wordIDs;
		
	}

	public String getWord(int wordID) {

		String word = null;
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
				pst = conn.prepareStatement("select lemma from words where wordid=?;");

				pst.setInt(1, wordID);

				rs = pst.executeQuery();

				while (rs.next()) {
//				
					word = rs.getString(1);
				


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
			return word;
	}

	public ArrayList<Integer> getFirstSynonymIDFromDB(int wordID) {

		
		
		
		
		ArrayList<Integer> synIds = new ArrayList<Integer>();
//		int firstWordID = 0;
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
				pst = conn.prepareStatement("select synsetid from senses where wordid=?;");

				pst.setInt(1, wordID);

				rs = pst.executeQuery();

				while (rs.next()) {

				int id = rs.getInt(1);
				synIds.add(id);

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
			return synIds;
		
		
		
		
		
	}

	public String getExample(int synID) {

		String example = null;
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
				pst = conn.prepareStatement("select sample from samples where synsetid=?;");

				pst.setInt(1, synID);

				rs = pst.executeQuery();

				while (rs.next()) {
//				
					example = rs.getString(1);
				


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
			return example;
	}
	
	
	
	
	
	

}
