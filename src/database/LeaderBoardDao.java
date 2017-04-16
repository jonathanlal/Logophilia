package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.appengine.api.utils.SystemProperty;

public class LeaderBoardDao {
	
	
	
	
	
	ArrayList<String> scores = new ArrayList<String>();
	
	
public ArrayList<String> getLeaderBoardinDB(){
		
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

			pst = conn.prepareStatement("select user,userneteros from userdata;");

			//pst.setString(1, username);

			rs = pst.executeQuery();

			while (rs.next()) {
				ArrayList<String> results = new ArrayList<String>();

				String user = rs.getString(1);
				results.add(user);
				String neteros = rs.getString(2);
				results.add(neteros);
//				String definition = rs.getString(3);
//				results.add(definition);
//
//				String image = rs.getString(5);
//				results.add(image);
//
//				String time = rs.getString(6);
//				results.add(time);
//				
//				String user = rs.getString(7);
//				results.add(user);
					
				String cheese = results.toString();
				
				scores.add(cheese);

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
		return scores;
	}

}
