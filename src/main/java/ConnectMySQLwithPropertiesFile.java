import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectMySQLwithPropertiesFile {
    public static Properties readPropertiesFile() throws IOException {
        Properties properties = new Properties();
        InputStream inputStream = new FileInputStream("/Users/mozammel/Desktop/IdeaProjects/DB_Connections/src/main/resources/app.properties");
        properties.load(inputStream);
        inputStream.close();
        return properties;
    }
    public static Connection connectDB() throws ClassNotFoundException, SQLException, IOException {
        Properties properties = readPropertiesFile();
        String userName = properties.getProperty("userName");
        String password = properties.getProperty("password");
        // url = protocol//[hosts][/database][?properties]
        String url = properties.getProperty("url");
        // Load the driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, userName, password);
        System.out.println("Connected");
        return connection;
    }
}
