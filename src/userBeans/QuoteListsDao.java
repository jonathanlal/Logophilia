package userBeans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.appengine.api.utils.SystemProperty;

public class QuoteListsDao {
	
	ArrayList<String> lists = new ArrayList<String>();
	ArrayList<String> likes = new ArrayList<String>();
	ArrayList<String> dislikes = new ArrayList<String>();
	ArrayList<String> sizeoflists = new ArrayList<String>();
	int sizeArray;


	public void createUserList(String listname, String date, String description, int listSize, String username, String stringofQuotes, String stringofAuthors) {
		
	
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
						"insert into quotelists (name,date,description,size,creator,quotes,authors) values (?,?,?,?,?,?,?);");

				pst.setString(1, listname);
				pst.setString(2, date);
				pst.setString(3, description);
				pst.setInt(4, listSize);
				pst.setString(5, username);
				pst.setString(6, stringofQuotes);
				pst.setString(7, stringofAuthors);

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
	
	
	
	
	
	
	
	
	
	
	
	public int getTotalAmountOFLISTSFROMDB(String username){
		
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

			pst = conn.prepareStatement("select COUNT(*) from quotelists where creator=?;");

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
	
	
	
	
	
	
	
	
	
	
	
	public boolean checkifListNameExists(String listname) {
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

				pst = conn.prepareStatement("select name from quotelists where name=?");
				pst.setString(1, listname);

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













	public void setImageofListfromDB(String image, String listname) {


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

			pst = conn.prepareStatement("update quotelists set image=? where name=?;");

			pst.setString(1, image);
			pst.setString(2, listname);

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













	public ArrayList<String> getsizeofListfromDBUSERNAME(String username) {

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
			pst = conn.prepareStatement("select size from quotelists where creator=?;");

			pst.setString(1, username);

			rs = pst.executeQuery();
			while (rs.next()) {
				sizeArray = rs.getInt(1);
				String sizeArrayString = Integer.toString(sizeArray);
				sizeoflists.add(sizeArrayString);

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
		return sizeoflists;
	}













	public ArrayList<String> getLists(String username) {
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
			pst = conn.prepareStatement("select name from quotelists where creator=?;");

			pst.setString(1, username);

			rs = pst.executeQuery();

			while (rs.next()) {
				results = rs.getString(1);
				lists.add(results);

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
		return lists;
	}











	public ArrayList<String> getAllFromList(int listID) {
		ArrayList<String> info = new ArrayList<String>();

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

			pst = conn.prepareStatement("select * from quotelists where idlists=?;");

			pst.setInt(1, listID);

			rs = pst.executeQuery();

			while (rs.next()) {
				String name = rs.getString(2);
				info.add(name); //1
				
				String description = rs.getString(3);
				info.add(description); //2
				
				String size = Integer.toString(rs.getInt(4));
				info.add(size); //3
				
				String likes = rs.getString(5);
				info.add(likes); //4
				
//				String dislikes = rs.getString(6);
//				info.add(dislikes);
				
				String creator = rs.getString(7);
				info.add(creator); //5
				
				String quotes = rs.getString(8);
				info.add(quotes); //6

				String authors = rs.getString(9);
				info.add(authors); //7
				
				String date = rs.getString(10);
				info.add(date); //8
				
//				String views = Integer.toString(rs.getInt(11));
//				info.add(likes);
				
				String image = rs.getString(12);
				info.add(image); //9
				
				String comments = rs.getString(13);
				info.add(comments); //10

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

		return info;

	}











	public ArrayList<ArrayList<String>> getListInfoProfile(String username) {
	ArrayList<ArrayList<String>> allinfo = new ArrayList<ArrayList<String>>();
		
		ArrayList<String> ids = new ArrayList<String>();
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<String> sizes = new ArrayList<String>();
		ArrayList<String> likes = new ArrayList<String>();

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

			pst = conn.prepareStatement("select idlists,name,size,likes from quotelists where creator=?;");

			pst.setString(1, username);

			rs = pst.executeQuery();

			while (rs.next()) {

				int id = rs.getInt(1);
				ids.add(Integer.toString(id));
				
				String name = rs.getString(2);
				names.add(name); 

				String size = Integer.toString(rs.getInt(3));
				sizes.add(size); 
				
				String listlikes = rs.getString(4);
				likes.add(listlikes); 


			}
			allinfo.add(ids);
			allinfo.add(names);
			allinfo.add(sizes);
			allinfo.add(likes);
			

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

		return allinfo;

	}











	public String getLikesQuoteListInDB(String postID) {
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

		           
	           pst = conn.prepareStatement("select likes from quotelists where idlists=?;");  

	           
	           
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











	public void setLikesQuoteList(String finallikes, String postID) {
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

	 
		           
	           pst = conn.prepareStatement("update quotelists set likes=? where idlists=?;");  
	           
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
