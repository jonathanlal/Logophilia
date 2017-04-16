package userBeans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LogophiliaDBDao {

	public void getWord(String listname, String description, int listSize, String username,
			String words,String definitions) {
		        Connection conn = null;  
		        PreparedStatement pst = null;  
		        ResultSet rs = null;  
		  
		        String url = "jdbc:google:mysql://104.198.201.141/3306";
		        
		        String dbName = "logophiliadb";  
		        String driver = "com.mysql.jdbc.GoogleDriver";  
		        String dbuser = "root";  
		        String dbpassword = "";  
		        try {  
		        	
		        	
		        	
		            Class.forName(driver).newInstance();  
		            conn = DriverManager  
		                    .getConnection(url + dbName, dbuser, dbpassword);  
		  
		           
		            pst = conn.prepareStatement("insert into lists (name,description,size,creator,words,definitions) values (?,?,?,?,?,?);");  
		            

		            pst.setString(1, listname);  
		            pst.setString(2, description);
		            pst.setInt(3, listSize);
		            pst.setString(4, username);
		            pst.setString(5, words);   
		            pst.setString(6, definitions);
		            
		  
		            pst.executeUpdate();
		            rs = pst.executeQuery("SELECT LAST_INSERT_ID()");
		            //status = rs.next();  
		  
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
//		        return status;  
		    }


	
	public void CheckWordExists(String listname, String description, int listSize, String username,
			String words,String definitions) {
		
		       // boolean status = false;  
		        Connection conn = null;  
		        PreparedStatement pst = null;  
		        ResultSet rs = null;  
		  
		        String url = "jdbc:mysql://localhost:3306/";  
		        String dbName = "logophilia";  
		        String driver = "com.mysql.jdbc.Driver";  
		        String dbuser = "root";  
		        String dbpassword = "1234";  
		        try {  
		        	
		        	
		        	
		            Class.forName(driver).newInstance();  
		            conn = DriverManager  
		                    .getConnection(url + dbName, dbuser, dbpassword);  
		  
		           
		            pst = conn.prepareStatement("insert into lists (name,description,size,creator,words,definitions) values (?,?,?,?,?,?);");  

		            
		            pst.setString(1, listname);  
		            pst.setString(2, description);
		            pst.setInt(3, listSize);
		            pst.setString(4, username);
		            pst.setString(5, words);   
		            pst.setString(6, definitions);
		            
		  
		            pst.executeUpdate();
		            rs = pst.executeQuery("SELECT LAST_INSERT_ID()");
		            //status = rs.next();  
		  
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

	
	public void createWord(String listname, String description, int listSize, String username,
			String words,String definitions) {
		
		        Connection conn = null;  
		        PreparedStatement pst = null;  
		        ResultSet rs = null;  
		  
		        String url = "jdbc:mysql://localhost:3306/";  
		        String dbName = "logophilia";  
		        String driver = "com.mysql.jdbc.Driver";  
		        String dbuser = "root";  
		        String dbpassword = "1234";  
		        try {  
		        	
		        	
		        	
		            Class.forName(driver).newInstance();  
		            conn = DriverManager  
		                    .getConnection(url + dbName, dbuser, dbpassword);  
		  
		           
		            pst = conn.prepareStatement("insert into lists (name,description,size,creator,words,definitions) values (?,?,?,?,?,?);");  

		            pst.setString(1, listname);  
		            pst.setString(2, description);
		            pst.setInt(3, listSize);
		            pst.setString(4, username);
		            pst.setString(5, words);   
		            pst.setString(6, definitions);
		            
		  
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
