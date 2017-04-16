package userBeans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.google.appengine.api.utils.SystemProperty;

public class RegisterDao {

	 public static boolean newuser(String username, String userpass, String useremail) {          
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
	  
	           
	            pst = conn.prepareStatement("insert into user (username,userpass,useremail) values (?,?,?);");  
	            
	            pst.setString(1, username);  
	            pst.setString(2, userpass);  
	            pst.setString(3, useremail);
	  
	            pst.executeUpdate();
	            rs = pst.executeQuery("SELECT LAST_INSERT_ID()");
	            status = rs.next();  
	  
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
	        return status;  
	    }

	
	 public static boolean newuser(String username, String userpass) {          
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

	           
	            pst = conn.prepareStatement("insert into user (username,userpass) values (?,?);");  
	            
	            pst.setString(1, username);  
	            pst.setString(2, userpass);  
	            
	  
	            pst.executeUpdate();
	            rs = pst.executeQuery("SELECT LAST_INSERT_ID()");
	            status = rs.next();  
	  
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
	        return status;  
	    }
	
	

	
		public boolean checkifUsernameExists(String username) {
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
				pst = conn.prepareStatement("select username from user where username=?");
				pst.setString(1, username);

				rs = pst.executeQuery();
				status = rs.next();

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
			return status;
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
