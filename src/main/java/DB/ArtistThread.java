package DB;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ArtistThread implements Runnable{
    private int id;

    public ArtistThread(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    private void displayArtists(int id) throws SQLException, PropertyVetoException {
        Connection connection = null;
        String selectSQL = "Select * from artists where id = ?";
        PreparedStatement prepStmt = null;
        try {
            ComboPooledDataSource basicDS = ConnectionPool.getInstance().getComboPooledDataSource();
            connection = basicDS.getConnection();
            prepStmt = connection.prepareStatement(selectSQL);
            prepStmt.setInt(1, id);
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                System.out.println("id : " + rs.getInt("id") + " Name : "
                        + rs.getString("name") + " Country : " + rs.getInt("country"));
            }
        } finally {
            if (prepStmt != null) {
                prepStmt.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    public void run() {
        try {
            this.displayArtists(1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
    }
}
