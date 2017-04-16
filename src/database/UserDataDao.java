package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.appengine.api.utils.SystemProperty;

public class UserDataDao {

	public int getTotalAmountOfUserQuotesInDB(String username) {
//		ArrayList<String> quotes = new ArrayList<String>();
		int quotes = 0;
		
//		 boolean status = false;  
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
		   url = "jdbc:google:mysql://logophilia-1385:us-central1:logophiliadb/logophilia";
				  
				   
				} else {
				  // Connecting from an external network.
				  Class.forName("com.mysql.jdbc.Driver");
				  url = "jdbc:mysql://localhost:3306/logophilia?user=root";
				}

				conn = DriverManager.getConnection(url,"root","1234");

				pst = conn.prepareStatement("select quote_count from userdata where user = ?;");

				pst.setString(1, username);

				rs = pst.executeQuery();

				while (rs.next()) {

					 quotes = rs.getInt(1);
					
//					String id = Integer.toString(idint);
//					quotes.add(id);
					
					//TranscribedTalks = rs.get(1);
				

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
			return quotes;
		
		
	}
	
	
	
	
	public void updateUserQuoteSizeInDB(int quotesize, String username) {
		
		 boolean status = false;  
		 String url = null;
		 PreparedStatement pst = null;  
		 ResultSet rs = null;  
		 Connection conn = null;

		 try{


if (SystemProperty.environment.value() ==
 SystemProperty.Environment.Value.Production) {
//Connecting from App Engine.
//Load the class that provides the "jdbc:google:mysql://"
//prefix.
Class.forName("com.mysql.jdbc.GoogleDriver");
url =
 "jdbc:google:mysql://logophilia-1385:us-central1:logophiliadb/logophilia";

} else {
//Connecting from an external network.
Class.forName("com.mysql.jdbc.Driver");
url = "jdbc:mysql://localhost:3306/logophilia?user=root";
}
conn = DriverManager.getConnection(url,"root","1234");

 pst = conn.prepareStatement("update userdata set quote_count = ? where user = ?;");  
	            
	            pst.setInt(1, quotesize);  
	            pst.setString(2, username);  

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
		
		
	}




	public void registerUserDataInDB(String username, String profileImgx, String coverImgx, String date, String profileInfo, int quoteCount, int talksCount, String talks, int reviewCount) {
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
					"insert into userdata (user,user_profile,user_cover,creation_date,talks,talks_count,profile_info,quote_count,review_count) values (?,?,?,?,?,?,?,?,?);");

			pst.setString(1, username);
			pst.setString(2, profileImgx);
			pst.setString(3, coverImgx);
			pst.setString(4, date);
			pst.setString(5, talks);
			pst.setInt(6, talksCount);
			pst.setString(7, profileInfo);
			pst.setInt(8, quoteCount);
			pst.setInt(9, reviewCount);

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




	public ArrayList<String> getProfileInfoFromDB(String username) {
		
		
		
		ArrayList<String> profile = new ArrayList<String>();
//		int quotes = 0;
		
//		 boolean status = false;  
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
		   url = "jdbc:google:mysql://logophilia-1385:us-central1:logophiliadb/logophilia";
				  
				   
				} else {
				  // Connecting from an external network.
				  Class.forName("com.mysql.jdbc.Driver");
				  url = "jdbc:mysql://localhost:3306/logophilia?user=root";
				}

				conn = DriverManager.getConnection(url,"root","1234");

				pst = conn.prepareStatement("select user_profile,user_cover,creation_date,talks_count,profile_info,quote_count,review_count from userdata where user = ?;");

				pst.setString(1, username);

				rs = pst.executeQuery();

				while (rs.next()) {

					String userprofile = rs.getString(1);
					profile.add(userprofile);
					
					
					String usercover = rs.getString(2);
					profile.add(usercover);
					
					String date = rs.getString(3);
					profile.add(date);

					int talkCount = rs.getInt(4);
					profile.add(Integer.toString(talkCount));
					
					String profileInfo = rs.getString(5);
					profile.add(profileInfo);

					int quoteCount = rs.getInt(6);
					profile.add(Integer.toString(quoteCount));

					int reviewCount = rs.getInt(7);
					profile.add(Integer.toString(reviewCount));

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
			return profile;


	}




	public void setProfileImageInDB(String username, String image) {
		 boolean status = false;  
		 String url = null;
		 PreparedStatement pst = null;  
		 ResultSet rs = null;  
		 Connection conn = null;

		 try{


if (SystemProperty.environment.value() ==
SystemProperty.Environment.Value.Production) {
//Connecting from App Engine.
//Load the class that provides the "jdbc:google:mysql://"
//prefix.
Class.forName("com.mysql.jdbc.GoogleDriver");
url =
"jdbc:google:mysql://logophilia-1385:us-central1:logophiliadb/logophilia";

} else {
//Connecting from an external network.
Class.forName("com.mysql.jdbc.Driver");
url = "jdbc:mysql://localhost:3306/logophilia?user=root";
}
conn = DriverManager.getConnection(url,"root","1234");

pst = conn.prepareStatement("update userdata set user_profile=? where user=?;");  
	            
	            pst.setString(1, image);  
	            pst.setString(2, username);  

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
		
		
		
	}




	public void setCoverImageInDB(String username, String image) {
		 boolean status = false;  
		 String url = null;
		 PreparedStatement pst = null;  
		 ResultSet rs = null;  
		 Connection conn = null;

		 try{


if (SystemProperty.environment.value() ==
SystemProperty.Environment.Value.Production) {
//Connecting from App Engine.
//Load the class that provides the "jdbc:google:mysql://"
//prefix.
Class.forName("com.mysql.jdbc.GoogleDriver");
url =
"jdbc:google:mysql://logophilia-1385:us-central1:logophiliadb/logophilia";

} else {
//Connecting from an external network.
Class.forName("com.mysql.jdbc.Driver");
url = "jdbc:mysql://localhost:3306/logophilia?user=root";
}
conn = DriverManager.getConnection(url,"root","1234");

pst = conn.prepareStatement("update userdata set user_cover=? where user=?;");  
	            
	            pst.setString(1, image);  
	            pst.setString(2, username);  

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
		
		
		
		
	}




	public void setProfileDescription(String username, String description) {
		 boolean status = false;  
		 String url = null;
		 PreparedStatement pst = null;  
		 ResultSet rs = null;  
		 Connection conn = null;

		 try{


if (SystemProperty.environment.value() ==
SystemProperty.Environment.Value.Production) {
//Connecting from App Engine.
//Load the class that provides the "jdbc:google:mysql://"
//prefix.
Class.forName("com.mysql.jdbc.GoogleDriver");
url =
"jdbc:google:mysql://logophilia-1385:us-central1:logophiliadb/logophilia";

} else {
//Connecting from an external network.
Class.forName("com.mysql.jdbc.Driver");
url = "jdbc:mysql://localhost:3306/logophilia?user=root";
}
conn = DriverManager.getConnection(url,"root","1234");

pst = conn.prepareStatement("update userdata set profile_info=? where user=?;");  
	            
	            pst.setString(1, description);  
	            pst.setString(2, username);  

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
		
		
		
		
	}




	public void setTalksCountInDB(int watchedsize, String username) {
		 boolean status = false;  
		 String url = null;
		 PreparedStatement pst = null;  
		 ResultSet rs = null;  
		 Connection conn = null;

		 try{


if (SystemProperty.environment.value() ==
SystemProperty.Environment.Value.Production) {
//Connecting from App Engine.
//Load the class that provides the "jdbc:google:mysql://"
//prefix.
Class.forName("com.mysql.jdbc.GoogleDriver");
url =
"jdbc:google:mysql://logophilia-1385:us-central1:logophiliadb/logophilia";

} else {
//Connecting from an external network.
Class.forName("com.mysql.jdbc.Driver");
url = "jdbc:mysql://localhost:3306/logophilia?user=root";
}
conn = DriverManager.getConnection(url,"root","1234");

pst = conn.prepareStatement("update userdata set talks_count=? where user=?;");  
	            
	            pst.setInt(1, watchedsize);  
	            pst.setString(2, username);  

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
		
		
		
	}
	
public int getTalksCountFromDB(String username) {
		
		
		
		int talkscount = 0;
		
//		 boolean status = false;  
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
		   url = "jdbc:google:mysql://logophilia-1385:us-central1:logophiliadb/logophilia";
				  
				   
				} else {
				  // Connecting from an external network.
				  Class.forName("com.mysql.jdbc.Driver");
				  url = "jdbc:mysql://localhost:3306/logophilia?user=root";
				}

				conn = DriverManager.getConnection(url,"root","1234");

				pst = conn.prepareStatement("select talks_count from userdata where user = ?;");

				pst.setString(1, username);

				rs = pst.executeQuery();

				while (rs.next()) {

					talkscount = rs.getInt(1);

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
			return talkscount;


	}

	

	
	
	
	
	
	
	

}
