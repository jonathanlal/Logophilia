package userBeans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.appengine.api.utils.SystemProperty;

public class WordListsDao {
	ArrayList<String> lists = new ArrayList<String>();
	ArrayList<String> definitions = new ArrayList<String>();
	ArrayList<String> words = new ArrayList<String>();
	ArrayList<String> likes = new ArrayList<String>();
	ArrayList<String> dislikes = new ArrayList<String>();

	ArrayList<String> sizeoflists = new ArrayList<String>();

	String description;

	int size;
	int sizeArray;
	String results;
	String date;
	String creator;

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
			pst = conn.prepareStatement("select name from lists where creator=?;");

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

	public String getDescriptionofListfromDB(String listname) {


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
		
			pst = conn.prepareStatement("select description from lists where name=?;");

			pst.setString(1, listname);

			rs = pst.executeQuery();

			while (rs.next()) {
				description = rs.getString(1);

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

		return description;

	}

	public ArrayList<String> getDefinitionsfromDB(String listname) {
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

			pst = conn.prepareStatement("select definitions from lists where name=?;");

			pst.setString(1, listname);

			rs = pst.executeQuery();
			while (rs.next()) {
				results = rs.getString(1);
				definitions.add(results);

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
		return definitions;
	}

	public ArrayList<String> getwordsfromDB(String listname) {
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

			pst = conn.prepareStatement("select words from lists where name=?;");

			pst.setString(1, listname);

			rs = pst.executeQuery();
			while (rs.next()) {
				results = rs.getString(1);
				words.add(results);

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
		return words;
	}

	public int getsizeofListfromDB(String listname) {

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

			pst = conn.prepareStatement("select size from lists where name=?;");

			pst.setString(1, listname);

			rs = pst.executeQuery();

			while (rs.next()) {

				size = rs.getInt(1);

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
		return size;
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

			pst = conn.prepareStatement("select COUNT(*) from lists where creator=?;");

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
			pst = conn.prepareStatement("select size from lists where creator=?;");

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

	public void createUserList(String listname, String date, String description, int listSize, String username, String words,
			String definitions, String image) {

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
					"insert into lists (name,date,description,size,creator,words,definitions,image) values (?,?,?,?,?,?,?,?);");

			pst.setString(1, listname);
			pst.setString(2, date);
			pst.setString(3, description);
			pst.setInt(4, listSize);
			pst.setString(5, username);
			pst.setString(6, words);
			pst.setString(7, definitions);
			pst.setString(8, image);
			
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

	public String getImageofListfromDB(String listname) {


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

			pst = conn.prepareStatement("select image from lists where name=?;");

			pst.setString(1, listname);

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

			pst = conn.prepareStatement("update lists set image=? where name=?;");

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

	public String getCreationDateofList(String name) {


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
			pst = conn.prepareStatement("select date from lists where name=?;");

			pst.setString(1, name);

			rs = pst.executeQuery();

			while (rs.next()) {
				date = rs.getString(1);

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

		return date;
	}

	public String getListCREATORfromDB(String name) {


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

			pst = conn.prepareStatement("select creator from lists where name=?;");

			pst.setString(1, name);

			rs = pst.executeQuery();

			while (rs.next()) {
				creator = rs.getString(1);

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

		return creator;
	}

	public void SetCreationDateList(String date, String listname) {


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
			pst = conn.prepareStatement("insert into lists (date,name) values (?,?);");
			//insert into lists (name,description,size,creator,words,definitions) values (?,?,?,?,?,?);")
			pst.setString(1, date);
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

	// -----------------------------------------------------------------------------------------------------
	// LIKES & DISLIKES <<<<
	public void AddLikeListtoDB(String usernames, String listname) {

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

			pst = conn.prepareStatement("update lists set likes=? where name=?;");

			pst.setString(1, usernames);
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

	public void AddDislikeListtoDB(String usernames, String listname) {

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

			pst = conn.prepareStatement("update lists set dislikes=? where name=?;");

			pst.setString(1, usernames);
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

	public ArrayList<String> GetLikesListtoDB(String listname) {

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
			pst = conn.prepareStatement("select likes from lists where name=?;");

			pst.setString(1, listname);

			rs = pst.executeQuery();
			while (rs.next()) {
				results = rs.getString(1);
				likes.add(results);

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
		return likes;
	}

	public ArrayList<String> GetDislikesListtoDB(String listname) {

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
			pst = conn.prepareStatement("select dislikes from lists where name=?;");

			pst.setString(1, listname);

			rs = pst.executeQuery();
			while (rs.next()) {
				results = rs.getString(1);
				dislikes.add(results);

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
		return dislikes;
	}

	public void DeleteListFromDB(String listname) {


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

			pst = conn.prepareStatement("delete from lists where name=?;");

			pst.setString(1, listname);

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

			pst = conn.prepareStatement("select name from lists where name=?");
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

	public void setDescriptionofListDB(String description, int id) {


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

			pst = conn.prepareStatement("update lists set description=? where idlists=?;");

			pst.setString(1, description);
			pst.setInt(2, id);
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

	public void setListNameinDB(String newname, String name) {

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
			pst = conn.prepareStatement("update lists set name=? where name=?;");

			pst.setString(1, newname);
			pst.setString(2, name);
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

	public void setListWordsinDB(String words, String name) {

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

			pst = conn.prepareStatement("update lists set words=? where name=?;");

			pst.setString(1, words);
			pst.setString(2, name);
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

	public void setListDefinitionsinDB(String definitions, String name) {

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
			pst = conn.prepareStatement("update lists set definitions=? where name=?;");

			pst.setString(1, definitions);
			pst.setString(2, name);

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

	public void setListSizeinDB(int listSize, String name) {

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
			pst = conn.prepareStatement("update lists set size=? where name=?;");

			pst.setInt(1, listSize);
			pst.setString(2, name);

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

	public ArrayList<String> getAllFromList(int id) {
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

			pst = conn.prepareStatement("select * from lists where idlists=?;");

			pst.setInt(1, id);

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
				
				String words = rs.getString(8);
				info.add(words); //6

				String definitions = rs.getString(9);
				info.add(definitions); //7
				
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

			pst = conn.prepareStatement("select idlists,name,size,likes from lists where creator=?;");

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

//				allinfo.add(info);

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

	public String getLikesWordListInDB(String postID) {

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

		           
	           pst = conn.prepareStatement("select likes from lists where idlists=?;");  

	           
	           
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

	public void setLikesWordList(String finallikes, String postID) {
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

	 
		           
	           pst = conn.prepareStatement("update lists set likes=? where idlists=?;");  
	           
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

	public void updateUserList(int listid, int size, String stringofWords, String stringofDefinitions) {
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

	           pst = conn.prepareStatement("update lists set words=?,definitions=?,size=? where idlists=?;");  
	           
	           pst.setString(1, stringofWords); 
	           pst.setString(2, stringofDefinitions);  
	           pst.setInt(3, size);
	           pst.setInt(4, listid);

	 
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
