package userBeans;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.appengine.api.utils.SystemProperty;



public class SearchHistoryDao {

	

		 ArrayList<String> words = new ArrayList<String>();

		
		public void addToSearchHistoryfromDB(String searchedwords, String username) {

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
			   url = "jdbc:mysql://localhost:3306/logophilia?user=root";
			 }

			 conn = DriverManager.getConnection(url,"root","1234");

			           
		            pst = conn.prepareStatement("update searchhistory set searchedwords=? where username=?;");  
		            
		            pst.setString(1, searchedwords); 
		            pst.setString(2, username);  
		 

		  
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
		
		

		
		public ArrayList<String> getSearchedWordsfromDB(String username) {
			String results;
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
			   url = "jdbc:mysql://localhost:3306/logophilia?user=root";
			 }

			 conn = DriverManager.getConnection(url,"root","1234");

		  
			           
		            pst = conn.prepareStatement("select searchedwords from searchhistory where username=?;");  

		            		            pst.setString(1, username);  
		 
		  
		            rs = pst.executeQuery();
		   
		            while(rs.next()){
		            	results = rs.getString(1);
		            	words.add(results);
		            	
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
		
		
		public void CreateSearchedWords(String username) {

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
			   url = "jdbc:mysql://localhost:3306/logophilia?user=root";
			 }

			 conn = DriverManager.getConnection(url,"root","1234");


			           
		            pst = conn.prepareStatement("insert into searchhistory (username,searchedwords) values (?,?);");  
		            
		            pst.setString(1, username); 
		            pst.setString(2, "X!X");  

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
		
	
	
}
