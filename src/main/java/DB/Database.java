package DB;

import java.sql.*;

public class Database {
    private static Database single_instance = null;
    private static Connection connection = null;
    private Database() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:mysql://79.112.59.146:3307/music_albums_diana?" +
                        "user=dbadiana&" +
                        "password=pass");

    }

    public static Database getInstance() throws SQLException {
        if(single_instance == null)
            single_instance = new Database();

        return single_instance;
    }

    public PreparedStatement getStatement(String query) throws SQLException {
        return connection.prepareStatement(query);
    }

    public void endConnection() throws SQLException {
        connection.close();
    }

}
