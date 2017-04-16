package logos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.appengine.api.utils.SystemProperty;

public class LogophiliaDao {
	
	
	public boolean validate(String word){          

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
		    "jdbc:google:mysql://logophilia-1385:us-central1:logophiliadb/logos";
		} else {
		  // Connecting from an external network.
		  Class.forName("com.mysql.jdbc.Driver");
		  url = "jdbc:mysql://localhost:3306/logos?user=root";
		}

		conn = DriverManager.getConnection(url,"root","1234");

		pst = conn.prepareStatement("select * from words where word=?;");  
		pst.setString(1, word);  


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

	public int getWordIDInDB(String word) {

		int id = 0;  
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
		    "jdbc:google:mysql://logophilia-1385:us-central1:logophiliadb/logos";
		} else {
		  // Connecting from an external network.
		  Class.forName("com.mysql.jdbc.Driver");
		  url = "jdbc:mysql://localhost:3306/logos?user=root";
		}

		conn = DriverManager.getConnection(url,"root","1234");

		pst = conn.prepareStatement("select id from words where word=?;");  
		pst.setString(1, word);  


		rs = pst.executeQuery();
		while (rs.next()) {
			id = rs.getInt(1);  
			

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
		return id;  
	}

	public void AddWordInDB(String word, String date, String username) {
		String id = null;  
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
		    "jdbc:google:mysql://logophilia-1385:us-central1:logophiliadb/logos";
		} else {
		  // Connecting from an external network.
		  Class.forName("com.mysql.jdbc.Driver");
		  url = "jdbc:mysql://localhost:3306/logos?user=root";
		}

		conn = DriverManager.getConnection(url,"root","1234");

		pst = conn.prepareStatement("insert into words (word,date_added,added_by) values (?,?,?);");  
		
		pst.setString(1, word);  
		pst.setString(2, date);  
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

	public void AddImageInDB(String image, int wordID, String date, String username) {
		String id = null;  
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
		    "jdbc:google:mysql://logophilia-1385:us-central1:logophiliadb/logos";
		} else {
		  // Connecting from an external network.
		  Class.forName("com.mysql.jdbc.Driver");
		  url = "jdbc:mysql://localhost:3306/logos?user=root";
		}

		conn = DriverManager.getConnection(url,"root","1234");

		pst = conn.prepareStatement("insert into images (image,word_id,date_added,added_by) values (?,?,?,?);");  
		
		pst.setString(1, image);  
		pst.setInt(2, wordID);  
		pst.setString(3, date);
		pst.setString(4, username);
		
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

	public ArrayList<String> getImagesDao(String wordID) {
		ArrayList<String> images = new ArrayList<String>();

//		String results;

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
		    "jdbc:google:mysql://logophilia-1385:us-central1:logophiliadb/logos";
		} else {
		  // Connecting from an external network.
		  Class.forName("com.mysql.jdbc.Driver");
		  url = "jdbc:mysql://localhost:3306/logos?user=root";
		}

		conn = DriverManager.getConnection(url,"root","1234");
			pst = conn.prepareStatement("select image from images where word_id=?;");

			pst.setString(1, wordID);

			rs = pst.executeQuery();
			while (rs.next()) {
				String image = rs.getString(1);
				images.add(image);

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
		return images;
	}

	public void AddDefinitionInDB(String definition, int wordID, String date, String username, String dictionary) {
		String id = null;  
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
		    "jdbc:google:mysql://logophilia-1385:us-central1:logophiliadb/logos";
		} else {
		  // Connecting from an external network.
		  Class.forName("com.mysql.jdbc.Driver");
		  url = "jdbc:mysql://localhost:3306/logos?user=root";
		}

		conn = DriverManager.getConnection(url,"root","1234");

		pst = conn.prepareStatement("insert into definitions (definition,word_id,date_added,added_by,dictionary) values (?,?,?,?,?);");  
		
		pst.setString(1, definition);  
		pst.setInt(2, wordID);  
		pst.setString(3, date);
		pst.setString(4, username);
		pst.setString(5, dictionary);
		
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
