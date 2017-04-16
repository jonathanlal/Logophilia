package userBeans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.google.appengine.api.utils.SystemProperty;

public class UserBeanDao {
	
	
	String results;

	
	
	
	
	
	
	
	// REGISTER
//	SET
//	PROFILE,COVER,CREATIONDATE,INFOTITLE,INFOBODY
//	
//	GET
//	PROFILE,COVER,CREATIONDATE,INFOTITLE,INFOBODY

	
	
public void registerUserinDBUserData(String username, String profile, String cover, String date, String title, String body, int eros, int currenteros){
	

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
				"insert into userdata (user,user_profile,user_cover,creation_date,info_title,info_body,userneteros,usercurrenteros) values (?,?,?,?,?,?,?,?);");

		pst.setString(1, username);
		pst.setString(2, profile);
		pst.setString(3, cover);
		pst.setString(4, date);
		pst.setString(5, title);
		pst.setString(6, body);
		pst.setInt(7, eros);
		pst.setInt(8, currenteros);

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

public void setProfileInfoTitleinDB(String username, String infotitle) {
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

			pst = conn.prepareStatement("update userdata set info_title=? where user=?;");

			pst.setString(1, infotitle);
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

public void setProfileInfoBodyinDB(String username, String infobody) {

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

		pst = conn.prepareStatement("update userdata set info_body=? where user=?;");

		pst.setString(1, infobody);
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
public void setProfileImageinDB(String username, String image) {
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

		pst = conn.prepareStatement("update userdata set user_profile=? where user=?;");

		pst.setString(1, image);
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
public void setCoverImageinDB(String username, String image) {

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
		pst = conn.prepareStatement("update userdata set user_cover=? where user=?;");

		pst.setString(1, image);
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




public String getProfileImagefromDB(String username) {
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
		pst = conn.prepareStatement("select user_profile from userdata where user=?;");

		pst.setString(1, username);

		rs = pst.executeQuery();

		while (rs.next()) {
			results = rs.getString(1);

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


public String getCoverImagefromDB(String username) {
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
		pst = conn.prepareStatement("select user_cover from userdata where user=?;");

		pst.setString(1, username);

		rs = pst.executeQuery();

		while (rs.next()) {
			results = rs.getString(1);

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




public String getCreationDateOfUserfromDB(String username) {
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

		pst = conn.prepareStatement("select creation_date from userdata where user=?;");

		pst.setString(1, username);

		rs = pst.executeQuery();

		while (rs.next()) {
			results = rs.getString(1);

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
public String getProfileInfoTitlefromDB(String username) {
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

		pst = conn.prepareStatement("select info_title from userdata where user=?;");

		pst.setString(1, username);

		rs = pst.executeQuery();

		while (rs.next()) {
			results = rs.getString(1);

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
public String getProfileInfoBodyfromDB(String username) {

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

		pst = conn.prepareStatement("select info_body from userdata where user=?;");

		pst.setString(1, username);

		rs = pst.executeQuery();

		while (rs.next()) {
			results = rs.getString(1);

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

	
	

	
		
public static boolean checkEmailExistsInDB(String useremail) {

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


	pst = conn.prepareStatement("select * from user where useremail=?");  
	pst.setString(1, useremail);  
//	pst.setString(2, userpass);  

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
//	}
}		
		
	

}
