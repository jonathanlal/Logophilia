package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.appengine.api.utils.SystemProperty;

public class UserSettingsDao {

	public ArrayList<String> getSettingsFromDB(String username) {
	
		
		ArrayList<String> settings = new ArrayList<String>();
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

				pst = conn.prepareStatement("select new_tab,hide_searches,hide_profileimg from usersettings where user = ?;");

				pst.setString(1, username);

				rs = pst.executeQuery();

				while (rs.next()) {

					String newtab = rs.getString(1);
					settings.add(newtab);
					
					
					String hidesearch = rs.getString(2);
					settings.add(hidesearch);
					
	

					String profileImg = rs.getString(3);
					settings.add(profileImg);
					
		

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
			return settings;


	}

	public void setNewTabInDB(String current,String username) {
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

//if(current.contains("yes")){
	
	pst = conn.prepareStatement("update usersettings set new_tab=? where user=?;");  

//}else{
	
//	pst = conn.prepareStatement("update usersettings set new_tab='yes' where user=?;");  

//}
				pst.setString(1, current);
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

	public String getNewTabFromDB(String username) {
	
		
		String status = null;
		
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

				pst = conn.prepareStatement("select new_tab from usersettings where user = ?;");

				pst.setString(1, username);

				rs = pst.executeQuery();

				while (rs.next()) {

					status = rs.getString(1);

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
			return status;


	}

	public void setHideSearchInDB(String current, String username) {
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

//if(current.contains("yes")){
	
	pst = conn.prepareStatement("update usersettings set hide_searches=? where user=?;");  


				pst.setString(1, current);
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

	public void setHideProfileImgInDB(String current, String username) {
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

//if(current.contains("yes")){
	
	pst = conn.prepareStatement("update usersettings set hide_profileimg=? where user=?;");  


				pst.setString(1, current);
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

	public boolean validatePassInDB(String currentPass, String username) {

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




			pst = conn.prepareStatement("select * from user where username=? and userpass=?");  
			pst.setString(1, username);  
			pst.setString(2, currentPass);  

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
		   url = "jdbc:google:mysql://logophilia-1385:us-central1:logophiliadb/logophilia";
				  
				   
				} else {
				  // Connecting from an external network.
				  Class.forName("com.mysql.jdbc.Driver");
				  url = "jdbc:mysql://localhost:3306/logophilia?user=root";
				}

				conn = DriverManager.getConnection(url,"root","1234");

				pst = conn.prepareStatement("select useremail from user where username = ?;");

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
	
	
	public String getUserpassInDB(String email) {

		String pass = null;
		
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

				pst = conn.prepareStatement("select userpass from user where useremail=?;");

				pst.setString(1, email);

				rs = pst.executeQuery();

				while (rs.next()) {

					pass = rs.getString(1);

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
			return pass;


	}

	
	
	
	
	public String getUsernameInDB(String email) {

		String username = null;
		
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

				pst = conn.prepareStatement("select username from user where useremail = ?;");

				pst.setString(1, username);

				rs = pst.executeQuery();

				while (rs.next()) {

					username = rs.getString(1);

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
			return username;


	}


	public void waitPasswordChangeConfirmationInDB(String username, String newPass, String code, String date) {

		
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

			pst = conn.prepareStatement(
					"insert into emailandpasswordchange (user,newpass,code,date,this) values (?,?,?,?,?);");

			pst.setString(1, username);
			pst.setString(2, newPass);
//			pst.setString(3, useremail);
			pst.setString(3, code);
			pst.setString(4, date);
			pst.setString(5, "this");

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

	public String confirmCodeUserInDB(String username) {
		String code = null;

		
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

				pst = conn.prepareStatement("select code from emailandpasswordchange where user=? and this='this';");

				pst.setString(1, username);

				rs = pst.executeQuery();

				while (rs.next()) {

					code = rs.getString(1);
					
//					String id = Integer.toString(idint);
//					TranscribedTalks.add(id);
					
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
			return code;
		
		
	}
	
	public String confirmCodeEmailInDB(String email) {
		String code = null;

		
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

				pst = conn.prepareStatement("select code from emailandpasswordchange where newemail=? and this='this';");

				pst.setString(1, email);

				rs = pst.executeQuery();

				while (rs.next()) {

					code = rs.getString(1);
					
//					String id = Integer.toString(idint);
//					TranscribedTalks.add(id);
					
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
			return code;
		
		
	}

	public void nullCodeInDB(String username) {

		 
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
 "jdbc:google:mysql://logophilia-1385:us-central1:logophiliadb/logophilia";

} else {
//Connecting from an external network.
Class.forName("com.mysql.jdbc.Driver");
url = "jdbc:mysql://localhost:3306/logophilia?user=root";
}

conn = DriverManager.getConnection(url,"root","1234");

	           
				pst = conn.prepareStatement("update emailandpasswordchange set code=null and this=null where this='this' and user=?");  

	            pst.setString(1, username);  


	            
	  
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

	public String getNewPassfromDB(String username) {

		String pass = null;
		
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

				pst = conn.prepareStatement("select newpass from emailandpasswordchange where this='this' and user=?;");

				pst.setString(1, username);

				rs = pst.executeQuery();

				while (rs.next()) {

					pass = rs.getString(1);

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
			return pass;


	}
	public String getNewPassByEmailfromDB(String email) {

		String pass = null;
		
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

				pst = conn.prepareStatement("select newpass from emailandpasswordchange where this='this' and newemail=?;");

				pst.setString(1, email);

				rs = pst.executeQuery();

				while (rs.next()) {

					pass = rs.getString(1);

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
			return pass;


	}
	
	
	
	public void updateNewPassInDB(String username, String newPass) {

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
"jdbc:google:mysql://logophilia-1385:us-central1:logophiliadb/logophilia";

} else {
//Connecting from an external network.
Class.forName("com.mysql.jdbc.Driver");
url = "jdbc:mysql://localhost:3306/logophilia?user=root";
}

conn = DriverManager.getConnection(url,"root","1234");

	           
				pst = conn.prepareStatement("update user set userpass=? where username=?");  

	            pst.setString(1, newPass);  
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
		    "jdbc:google:mysql://logophilia-1385:us-central1:logophiliadb/logophilia";
		  
		   
		} else {
		  // Connecting from an external network.
		  Class.forName("com.mysql.jdbc.Driver");
		  url = "jdbc:mysql://localhost:3306/logophilia?user=root";
		}

		conn = DriverManager.getConnection(url,"root","1234");




			pst = conn.prepareStatement("select * from user where username=? and useremail=?");  
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

	public boolean validateEmailInDB(String email) {

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
			pst.setString(1, email);  

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
	
	
	public void waitEmailChangeConfirmationInDB(String username, String newEmail, String code, String date) {

		
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

			pst = conn.prepareStatement(
					"insert into emailandpasswordchange (user,newemail,code,date,this) values (?,?,?,?,?);");

			pst.setString(1, username);
			pst.setString(2, newEmail);
//			pst.setString(3, useremail);
			pst.setString(3, code);
			pst.setString(4, date);
			pst.setString(5, "this");

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

	public String getNewEmailfromDB(String username) {

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
		   url = "jdbc:google:mysql://logophilia-1385:us-central1:logophiliadb/logophilia";
				  
				   
				} else {
				  // Connecting from an external network.
				  Class.forName("com.mysql.jdbc.Driver");
				  url = "jdbc:mysql://localhost:3306/logophilia?user=root";
				}

				conn = DriverManager.getConnection(url,"root","1234");

				pst = conn.prepareStatement("select newemail from emailandpasswordchange where this='this' and user=?;");

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
"jdbc:google:mysql://logophilia-1385:us-central1:logophiliadb/logophilia";

} else {
//Connecting from an external network.
Class.forName("com.mysql.jdbc.Driver");
url = "jdbc:mysql://localhost:3306/logophilia?user=root";
}

conn = DriverManager.getConnection(url,"root","1234");

	           
				pst = conn.prepareStatement("update user set useremail=? where username=?");  

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

	public void registerUserSettingsInDB(String username, String newTab, String hideSearch, String hideProfileImg){

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

				pst = conn.prepareStatement(
						"insert into usersettings(user,new_tab,hide_searches,hide_profileimg) values (?,?,?,?);");

				pst.setString(1, username);
				pst.setString(2, newTab);
				pst.setString(3, hideSearch);
				pst.setString(4, hideProfileImg);

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

	public void addUserToEmailListInDB(String username,String useremail) {

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

			pst = conn.prepareStatement(
					"insert into emailnewtalks (username,useremail) values (?,?);");

			pst.setString(1, username);
			pst.setString(2, useremail);


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

	public void removeUserFromEmailList(String username) {
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

//if(current.contains("yes")){
	
	pst = conn.prepareStatement("delete from emailnewtalks where username=?;");

	pst.setString(1, username);


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

	public void setEmailNewTalksInDB(String current, String username) {
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

//if(current.contains("yes")){
	
	pst = conn.prepareStatement("update usersettings set new_talks_email=? where user=?;");  


				pst.setString(1, current);
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

	public void setColoursInDB(String back, String text, String username) {
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

//if(current.contains("yes")){
	
	pst = conn.prepareStatement("update usersettings set background_colour=?, text_colour=? where user=?;");  


				pst.setString(1, back);
	            pst.setString(2, text);
	            pst.setString(3, username);

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

	public String getAccountTypeInDB(String username) {
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
		   url =  "jdbc:google:mysql://logophilia-1385:us-central1:logophiliadb/logophilia";
				  
				   
				} else {
				  // Connecting from an external network.
				  Class.forName("com.mysql.jdbc.Driver");
				  url = "jdbc:mysql://localhost:3306/logophilia?user=root";
				}

				conn = DriverManager.getConnection(url,"root","1234");

				pst = conn.prepareStatement("select account_type from user where username=?;");

				pst.setString(1, username);

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

	

	public void setForgotPasswordInDB(String newPass, String email, String code) {

		
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

			pst = conn.prepareStatement(
					"insert into emailandpasswordchange (newpass,newemail,code,this) values (?,?,?,?);");

			pst.setString(1, newPass);
			pst.setString(2, email);
			pst.setString(3, code);
//			pst.setString(3, useremail);
//			pst.setString(3, code);
//			pst.setString(4, date);
			pst.setString(4, "this");

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

	public void nullCodeByEmailInDB(String email) {

		 
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
"jdbc:google:mysql://logophilia-1385:us-central1:logophiliadb/logophilia";

} else {
//Connecting from an external network.
Class.forName("com.mysql.jdbc.Driver");
url = "jdbc:mysql://localhost:3306/logophilia?user=root";
}

conn = DriverManager.getConnection(url,"root","1234");

	           
				pst = conn.prepareStatement("update emailandpasswordchange set code=null and this=null where this='this' and newemail=?");  

	            pst.setString(1, email);  


	            
	  
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

	public boolean checkEmailExistsInDB(String fbid) {
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


			pst = conn.prepareStatement("select useremail from userfb where fbid=?");  
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
	
	
	
	//public static void resetPasswordInDB(String newPass, String email) {
//	 boolean status2 = false;  
//	 String url = null;
//	 PreparedStatement pst = null;  
//	 ResultSet rs = null;  
//	 Connection conn = null;
//
//	 try{
//
//
//if (SystemProperty.environment.value() ==
//SystemProperty.Environment.Value.Production) {
////Connecting from App Engine.
////Load the class that provides the "jdbc:google:mysql://"
////prefix.
//Class.forName("com.mysql.jdbc.GoogleDriver");
//url =
//"jdbc:google:mysql://logophilia-1385:us-central1:logophiliadb/logophilia";
//
//} else {
////Connecting from an external network.
//Class.forName("com.mysql.jdbc.Driver");
//url = "jdbc:mysql://localhost:3306/logophilia?user=root";
//}
//
//conn = DriverManager.getConnection(url,"root","1234");
//
//         
//			pst = conn.prepareStatement("update user set userpass=? where useremail=?");  
//
//          pst.setString(1, newPass);  
//          pst.setString(2, email);  
//
//          
//
//          pst.executeUpdate();
//          rs = pst.executeQuery("SELECT LAST_INSERT_ID()");
//          status2 = rs.next();  
//
//      } catch (Exception e) {  
//          System.out.println(e);  
//      } finally {  
//          if (conn != null) {  
//              try {  
//                  conn.close();  
//              } catch (SQLException e) {  
//                  e.printStackTrace();  
//              }  
//          }  
//          if (pst != null) {  
//              try {  
//                  pst.close();  
//              } catch (SQLException e) {  
//                  e.printStackTrace();  
//              }  
//          }  
//          if (rs != null) {  
//              try {  
//                  rs.close();  
//              } catch (SQLException e) {  
//                  e.printStackTrace();  
//              }  
//          }  
//      }  
//
//}
	
	
	
	
	

}
