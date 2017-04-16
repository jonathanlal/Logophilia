package userBeans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.google.appengine.api.utils.SystemProperty;

public class PostCommentDao {

	public void AddCommentsWordPostInDB(String postID,String comments) {

//		String comments = null;
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
		   url =  "jdbc:google:mysql://logophilia-1385:us-central1:logophiliadb/logophilia";
				  
				   
				} else {
				  // Connecting from an external network.
				  Class.forName("com.mysql.jdbc.Driver");
				  url = "jdbc:mysql://localhost:3306/logophilia?user=root";
				}

				conn = DriverManager.getConnection(url,"root","1234");

				pst = conn.prepareStatement("update wordposts set comments=? where id=?;");

				pst.setString(1, comments);
				pst.setString(2, postID);

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

	public void AddCommentsQuotePostInDB(String postID,String comments) {

//		String comments = null;
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
		   url =  "jdbc:google:mysql://logophilia-1385:us-central1:logophiliadb/logophilia";
				  
				   
				} else {
				  // Connecting from an external network.
				  Class.forName("com.mysql.jdbc.Driver");
				  url = "jdbc:mysql://localhost:3306/logophilia?user=root";
				}

				conn = DriverManager.getConnection(url,"root","1234");

				pst = conn.prepareStatement("update quoteposts set comments=? where id=?;");

				pst.setString(1, comments);
				pst.setString(2, postID);

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

	public String getWordPostCommentsInDB(String postID) {


		String comments = null;
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
		   url =  "jdbc:google:mysql://logophilia-1385:us-central1:logophiliadb/logophilia";
				  
				   
				} else {
				  // Connecting from an external network.
				  Class.forName("com.mysql.jdbc.Driver");
				  url = "jdbc:mysql://localhost:3306/logophilia?user=root";
				}

				conn = DriverManager.getConnection(url,"root","1234");

				pst = conn.prepareStatement("select comments from wordposts where id=?;");

				pst.setString(1, postID);

				rs = pst.executeQuery();

				while (rs.next()) {

					comments = rs.getString(1);
					
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
			return comments;

		
	}

	
	public String getQuotePostCommentsInDB(String postID) {


		String comments = null;
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
		   url =  "jdbc:google:mysql://logophilia-1385:us-central1:logophiliadb/logophilia";
				  
				   
				} else {
				  // Connecting from an external network.
				  Class.forName("com.mysql.jdbc.Driver");
				  url = "jdbc:mysql://localhost:3306/logophilia?user=root";
				}

				conn = DriverManager.getConnection(url,"root","1234");

				pst = conn.prepareStatement("select comments from quoteposts where id=?;");

				pst.setString(1, postID);

				rs = pst.executeQuery();

				while (rs.next()) {

					comments = rs.getString(1);
					
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
			return comments;

		
	}

	public String getWordListCommentsInDB(String postID) {


		String comments = null;
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
		   url =  "jdbc:google:mysql://logophilia-1385:us-central1:logophiliadb/logophilia";
				  
				   
				} else {
				  // Connecting from an external network.
				  Class.forName("com.mysql.jdbc.Driver");
				  url = "jdbc:mysql://localhost:3306/logophilia?user=root";
				}

				conn = DriverManager.getConnection(url,"root","1234");

				pst = conn.prepareStatement("select comments from lists where idlists=?;");

				pst.setString(1, postID);

				rs = pst.executeQuery();

				while (rs.next()) {

					comments = rs.getString(1);
					
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
			return comments;

		
	}

	public void AddCommentsWordListInDB(String postID, String comments) {

//		String comments = null;
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
		   url =  "jdbc:google:mysql://logophilia-1385:us-central1:logophiliadb/logophilia";
				  
				   
				} else {
				  // Connecting from an external network.
				  Class.forName("com.mysql.jdbc.Driver");
				  url = "jdbc:mysql://localhost:3306/logophilia?user=root";
				}

				conn = DriverManager.getConnection(url,"root","1234");

				pst = conn.prepareStatement("update lists set comments=? where idlists=?;");

				pst.setString(1, comments);
				pst.setString(2, postID);

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
