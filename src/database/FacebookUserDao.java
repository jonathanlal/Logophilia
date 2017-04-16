package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.google.appengine.api.utils.SystemProperty;

public class FacebookUserDao {

	public boolean checkUserIDExists(String fbid) {
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
			    "jdbc:google:mysql://askterencemckenna-1382:us-central1:askterencemckennadb/askterencemckenna";
			  
			   
			} else {
			  // Connecting from an external network.
			  Class.forName("com.mysql.jdbc.Driver");
			  url = "jdbc:mysql://localhost:3306/askterencemckenna?user=root";
			}

			conn = DriverManager.getConnection(url,"root","1234");


			pst = conn.prepareStatement("select * from userfb where fbid=?");  
			pst.setString(1, fbid);  
//			pst.setString(2, userpass);  

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
	
	public boolean validateEmailInDB(String currentEmail, String username) {

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
		    "jdbc:google:mysql://askterencemckenna-1382:us-central1:askterencemckennadb/askterencemckenna";
		  
		   
		} else {
		  // Connecting from an external network.
		  Class.forName("com.mysql.jdbc.Driver");
		  url = "jdbc:mysql://localhost:3306/askterencemckenna?user=root";
		}

		conn = DriverManager.getConnection(url,"root","1234");




			pst = conn.prepareStatement("select * from userfb where fbid=? and useremail=?");  
			pst.setString(1, username);  
			pst.setString(2, currentEmail);  

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
	public String getEmailInDB(String username) {

		String email = null;
		
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
		   url = "jdbc:google:mysql://askterencemckenna-1382:us-central1:askterencemckennadb/askterencemckenna";
				  
				   
				} else {
				  // Connecting from an external network.
				  Class.forName("com.mysql.jdbc.Driver");
				  url = "jdbc:mysql://localhost:3306/askterencemckenna?user=root";
				}

				conn = DriverManager.getConnection(url,"root","1234");

				pst = conn.prepareStatement("select useremail from userfb where fbid = ?;");

				pst.setString(1, username);

				rs = pst.executeQuery();

				while (rs.next()) {

					email = rs.getString(1);

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
			return email;


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
		    "jdbc:google:mysql://askterencemckenna-1382:us-central1:askterencemckennadb/askterencemckenna";
		  
		   
		} else {
		  // Connecting from an external network.
		  Class.forName("com.mysql.jdbc.Driver");
		  url = "jdbc:mysql://localhost:3306/askterencemckenna?user=root";
		}

		conn = DriverManager.getConnection(url,"root","1234");


		pst = conn.prepareStatement("select * from userfb where useremail=?");  
		pst.setString(1, useremail);  
//		pst.setString(2, userpass);  

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
//		}
	}
	
	public String getAccountTypeInDB(String fbid) {
		String accountype = null;

		
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
		   url =  "jdbc:google:mysql://askterencemckenna-1382:us-central1:askterencemckennadb/askterencemckenna";
				  
				   
				} else {
				  // Connecting from an external network.
				  Class.forName("com.mysql.jdbc.Driver");
				  url = "jdbc:mysql://localhost:3306/askterencemckenna?user=root";
				}

				conn = DriverManager.getConnection(url,"root","1234");

				pst = conn.prepareStatement("select account_type from userfb where fbid=?;");

				pst.setString(1, fbid);

				rs = pst.executeQuery();

				while (rs.next()) {

					accountype = rs.getString(1);
					
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
			return accountype;
		
		
	}

	public void updateNewEmailInDB(String username, String newEmail) {

		 boolean status2 = false;  
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
"jdbc:google:mysql://askterencemckenna-1382:us-central1:askterencemckennadb/askterencemckenna";

} else {
//Connecting from an external network.
Class.forName("com.mysql.jdbc.Driver");
url = "jdbc:mysql://localhost:3306/askterencemckenna?user=root";
}

conn = DriverManager.getConnection(url,"root","1234");

	           
				pst = conn.prepareStatement("update userfb set useremail=? where username=?");  

	            pst.setString(1, newEmail);  
	            pst.setString(2, username);  

	            
	  
	            pst.executeUpdate();
	            rs = pst.executeQuery("SELECT LAST_INSERT_ID()");
	            status2 = rs.next();  
	  
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

	public String getNameInDB(String fbid) {
		String FullName = null;

		
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
		   url =  "jdbc:google:mysql://askterencemckenna-1382:us-central1:askterencemckennadb/askterencemckenna";
				  
				   
				} else {
				  // Connecting from an external network.
				  Class.forName("com.mysql.jdbc.Driver");
				  url = "jdbc:mysql://localhost:3306/askterencemckenna?user=root";
				}

				conn = DriverManager.getConnection(url,"root","1234");

				pst = conn.prepareStatement("select firstname,secondname from userfb where fbid=?;");

				pst.setString(1, fbid);

				rs = pst.executeQuery();

				while (rs.next()) {

					String firstname = rs.getString(1);
					String secondname = rs.getString(2);
					
					FullName = firstname + " " + secondname;
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
			return FullName;
		
		
	}
	
	
	

}
