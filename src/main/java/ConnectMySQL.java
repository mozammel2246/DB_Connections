import java.sql.*;

public class ConnectMySQL {

    public static Connection connectDB() throws ClassNotFoundException, SQLException {
        String userName = "root";
        String password = "root";
        // url = protocol//[hosts][/database][?properties]
        String url = "jdbc:mysql://localhost:3306/sys?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        // Load the driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, userName, password);
        System.out.println("Connected");
        return connection;
    }
}
