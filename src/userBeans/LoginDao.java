package userBeans;



import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.google.appengine.api.utils.SystemProperty;



  
public class LoginDao {  


public static boolean validate(String username, String userpass){          

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
pst.setString(2, userpass);  

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
	
    
    public static boolean validate3(String username, String userpass) {          
        boolean status = false;  
        Connection conn = null;  
        PreparedStatement pst = null;  
        ResultSet rs = null;  
  
        String url = "jdbc:mysql://localhost:3306/";  
        String dbName = "logophilia";  
        String driver = "com.mysql.jdbc.Driver";  
        String dbuser = "root";  
        String dbpassword = "1234";  
        try {  
            Class.forName(driver).newInstance();  
            conn = DriverManager  
                    .getConnection(url + dbName, dbuser, dbpassword);  
  
            pst = conn.prepareStatement("select * from user where username=? and userpass=?");  
            pst.setString(1, username);  
            pst.setString(2, userpass);  
  
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



	


    
    
}  