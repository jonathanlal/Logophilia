package userBeans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.appengine.api.utils.SystemProperty;

public class QuotePostDao {

	
	//ArrayList<String> shards = new ArrayList<String>();
	ArrayList<String> QuotePosts = new ArrayList<String>();


	
	
	public void deleteQuotePost(String postID) {

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

			pst = conn.prepareStatement("delete from quoteposts where id=?;");

			pst.setString(1, postID);
//			pst.setString(2, username);

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
	
	
	
	
	
	
	
	
	
	public void createQuotePostinDB(String quote, String author, String usertext, String image, String time, String user) {

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
					"insert into quoteposts (quote,author,usertext,image,time,user) values (?,?,?,?,?,?);");

			pst.setString(1, quote);
			pst.setString(2, author);
			pst.setString(3, usertext);
			pst.setString(4, image);
			pst.setString(5, time);
			pst.setString(6, user);


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
	public int getTotalAmountOFPOSTSFROMDB(String username){
	
		int sizeArrayString = 0;
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
			pst = conn.prepareStatement("select COUNT(*) from quoteposts where user=?;");

			pst.setString(1, username);

			rs = pst.executeQuery();
			while (rs.next()) {
			//	sizeArray = rs.getInt(1);
				 sizeArrayString = rs.getInt(1);
				//sizeoflists.add(sizeArrayString);

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
		return sizeArrayString;
		
		
		
		
		
		
	}
	
	public ArrayList<String> getQuotePostsinDB(String username){
		
		
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
			pst = conn.prepareStatement("select * from quoteposts where user=?;");

			pst.setString(1, username);

			rs = pst.executeQuery();

			while (rs.next()) {
				ArrayList<String> results = new ArrayList<String>();

				String quote = rs.getString(2);
				results.add(quote);
				String usertext = rs.getString(3);
				results.add(usertext);
				String author = rs.getString(4);
				results.add(author);

				String image = rs.getString(5);
				results.add(image);

				String time = rs.getString(6);
				results.add(time);
				
				String user = rs.getString(7);
				results.add(user);
					
				String cheese = results.toString();
				
				QuotePosts.add(cheese);

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
		return QuotePosts;
	}
	public void deleteQuotePost(String username, String word) {

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

			pst = conn.prepareStatement("delete from quoteposts where word=? and user=?;");

			pst.setString(1, word);
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

public ArrayList<String> getAllQuotePostsinDB(){
		
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
			pst = conn.prepareStatement("select * from quoteposts;");

			//pst.setString(1, username);

			rs = pst.executeQuery();

			while (rs.next()) {
				ArrayList<String> results = new ArrayList<String>();

				String word = rs.getString(2);
				results.add(word);
				String usertext = rs.getString(3);
				results.add(usertext);
				String definition = rs.getString(4);
				results.add(definition);

				String image = rs.getString(5);
				results.add(image);

				String time = rs.getString(6);
				results.add(time);
				
				String user = rs.getString(7);
				results.add(user);
					
				String cheese = results.toString();
				
				QuotePosts.add(cheese);

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
		return QuotePosts;
	}
public ArrayList<String> getQuotePostinDBByID(String ID) {
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
		pst = conn.prepareStatement("select * from quoteposts where id=?;");

		pst.setString(1, ID);

		rs = pst.executeQuery();

		while (rs.next()) {

			int id = rs.getInt(1);
			results.add(Integer.toString(id));
			
			String quote = rs.getString(2);
			results.add(quote);
			
			String usertext = rs.getString(3);
			results.add(usertext);
			
			String author = rs.getString(4);
			results.add(author);

			String image = rs.getString(5);
			results.add(image);

			String time = rs.getString(6);
			results.add(time);
			
			String user = rs.getString(7);
			results.add(user);
			
			String likes = rs.getString(8);
			results.add(likes);
//			
//			String dislikes = rs.getString(9);
//			results.add(dislikes);
			
			String comments = rs.getString(10);
			
			if(comments == null){
				results.add("");
				
			}else{
			results.add(comments);
			}
			//cheese = results.toString();
			
//			wordPost.add(cheese);

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

public String getLikesQuotePostInDB(String postID) {
	
	String Likes = null;
	String results = null;
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

	           
           pst = conn.prepareStatement("select likes from quoteposts where id=?;");  

           
           
           pst.setString(1, postID);  

 
           rs = pst.executeQuery();

          while(rs.next()){
           	Likes = rs.getString(1);
           
           	
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
		return Likes;
}

	
public void setLikesQuotePost(String finallikes, String postID) {



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


	           
          pst = conn.prepareStatement("update quoteposts set likes=? where id=?;");  
          
          pst.setString(1, finallikes); 
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
