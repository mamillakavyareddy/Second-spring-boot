package in.co.kavya.SecondSpringBoot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection2 {
	private static Connection con = null;
	  
    static
    {
        String url = "jdbc:mysql://localhost:3306/school";
        String user = "root";
        String pass = "Lucky@04";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection()
    {
        return con;
    }

}
