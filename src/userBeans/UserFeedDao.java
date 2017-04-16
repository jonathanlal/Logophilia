package userBeans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.google.appengine.api.utils.SystemProperty;

public class UserFeedDao {
	
	ArrayList<String> quoteposts = new ArrayList<String>();


	public void createUserFeedRecord(String username){
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

			pst = conn.prepareStatement(
					"insert into userfeed (postid,type,username) values ('','',?)");

//			pst.setString(1, postid);
//			pst.setString(2, type);
			pst.setString(1, username);



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
	
	
	
	public void addToFeedDB(String postid, String type, String username) {
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

			pst = conn.prepareStatement(
					"update userfeed set postid=?,type=? where username=?;");

			pst.setString(1, postid);
			pst.setString(2, type);
			pst.setString(3, username);



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

	public ArrayList<String> getFeedDB(String username) {
		ArrayList<String> results = new ArrayList<String>();
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
				pst = conn.prepareStatement("select * from userfeed where username=?;");

				pst.setString(1, username);

				rs = pst.executeQuery();

				while (rs.next()) {

					String postid = rs.getString(2);
					results.add(postid);
					String type = rs.getString(3);
					results.add(type);
					//results.add("!");
//					String definition = rs.getString(4);
//					results.add(definition);
//
//					String image = rs.getString(5);
//					results.add(image);
//
//					String time = rs.getString(6);
//					results.add(time);
//					
//					String user = rs.getString(7);
//					results.add(user);
						
					 //cheese = results.toString();
					
					//quoteposts.add(cheese);

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
			return results;
		}
		
		
	public String getFeedIDDB(String username) {
 
		String postid = null;
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
				pst = conn.prepareStatement("select postid from userfeed where username=?;");

				pst.setString(1, username);

				rs = pst.executeQuery();

				while (rs.next()) {

					postid = rs.getString(1);
					//results.add(postid);
//					String type = rs.getString(3);
//					results.add(type);
					//results.add("!");
//					String definition = rs.getString(4);
//					results.add(definition);
//
//					String image = rs.getString(5);
//					results.add(image);
//
//					String time = rs.getString(6);
//					results.add(time);
//					
//					String user = rs.getString(7);
//					results.add(user);
						
					 //cheese = results.toString();
					
					//quoteposts.add(cheese);

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
			return postid;
		}
	
	public String getFeedTypeDB(String username) {
		 
		String type = null;
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
				pst = conn.prepareStatement("select type from userfeed where username=?;");

				pst.setString(1, username);

				rs = pst.executeQuery();

				while (rs.next()) {

					type = rs.getString(1);
					//results.add(type);
//					String type = rs.getString(3);
//					results.add(type);
					//results.add("!");
//					String definition = rs.getString(4);
//					results.add(definition);
//
//					String image = rs.getString(5);
//					results.add(image);
//
//					String time = rs.getString(6);
//					results.add(time);
//					
//					String user = rs.getString(7);
//					results.add(user);
						
					 //cheese = results.toString();
					
					//quoteposts.add(cheese);

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
			return type;
		}
	
		
	
	
	public int getQuoteID(String username) {
		 
		int quoteID = 0;
		String ID = null;
		 boolean status = false;  
		 String url = null;
		 PreparedStatement pst = null;  
		 ResultSet rs = null;  
		 Connection conn = null;
			int generatedKey = 0;

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
				pst = conn.prepareStatement("select max(id) from quoteposts where user=?;");

				pst.setString(1, username);

				rs = pst.executeQuery();

				while (rs.next()) {
					quoteID = rs.getInt(1);


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
			return quoteID;
		}
	
	
	
	public int getWordID(String username) {
		 
		int wordID = 0;
		String ID = null;
		 boolean status = false;  
		 String url = null;
		 PreparedStatement pst = null;  
		 ResultSet rs = null;  
		 Connection conn = null;
			int generatedKey = 0;

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
				pst = conn.prepareStatement("select max(id) from wordposts where user=?;");

				pst.setString(1, username);

				rs = pst.executeQuery();

				while (rs.next()) {
					wordID = rs.getInt(1);


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
			return wordID;
		}



	public void nullUserFeed(String username) {
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

			pst = conn.prepareStatement(
					"update userfeed set postid='',type='' where username=?;");

//			pst.setString(1, postid);
//			pst.setString(2, type);
			pst.setString(1, username);



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

//}
