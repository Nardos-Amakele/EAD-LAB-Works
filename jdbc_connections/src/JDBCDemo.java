import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCDemo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/enterprise_database";
        String username = "root"; 
        String password = "12345678Characters@"; 

        String driver = "com.mysql.cj.jdbc.Driver";

        try {
            Class.forName(driver);

            Connection conn = DriverManager.getConnection(url, username, password);

            System.out.println("Established Connection");

            conn.close();
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found. Add the JDBC driver to your classpath.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Failed to establish connection.");
            e.printStackTrace();
        }
    }
}
