package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.appengine.api.utils.SystemProperty;

public class DailyWordDao {

	public void setDailyWordInDB(String word, String definition, String date) {

		
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

			pst = conn.prepareStatement(
					"insert into dailyword (word,definition,date) values (?,?,?);");

			pst.setString(1, word);
			pst.setString(2, definition);
			pst.setString(3, date);
			
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

	public ArrayList<String> getDailyWordInDB() {
		ArrayList<String> dailywordinfo = new ArrayList<String>();

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
				
				pst = conn.prepareStatement("select word,definition from dailyword order by id DESC LIMIT 1");

				//pst.setString(1, username);

				rs = pst.executeQuery();

				while (rs.next()) {
//					ArrayList<String> results = new ArrayList<String>();

//					int idint = rs.getInt(1);
//					
//					String id = Integer.toString(idint);
//					quote.add(id+" X!");
					
					String word = rs.getString(1);
					dailywordinfo.add(word);
					
//					String tags = rs.getString(3);
//					results.add(tags+" X!");
					
//					String user = rs.getString(4);
//					quote.add(user+" X!");

					String definition = rs.getString(2);
					dailywordinfo.add(definition);

//					String date = rs.getString(3);
//					quote.add(date);
					
//					int count = rs.getInt(7);
//					String quotecount = Integer.toString(count);
//					results.add(quotecount+" X!");
						
//					String cheese = results.toString();
					
//					quote.add(cheese);

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
			return dailywordinfo;
	}

}
