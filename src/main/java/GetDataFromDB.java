import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetDataFromDB {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        getData();
    }
    public static void getData() throws SQLException, ClassNotFoundException, IOException {
        String query = "select * from host_summary";
        Statement statement = ConnectMySQLwithPropertiesFile.connectDB().createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        resultSet.next();
        String statements = resultSet.getString("statement_latency");
        System.out.println(statements);
    }
}
