package Artists;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import DB.Database;

public class ArtistsDAO implements ArtistController {
    @Override
    public void create(String name, String country) throws SQLException {
        Database database = Database.getInstance();

        PreparedStatement insertionStatement = database.getStatement("INSERT INTO Artists(Name, Country) VALUES(?, ?)");
        insertionStatement.setString(1, name);
        insertionStatement.setString(2, country);
        insertionStatement.execute();
        insertionStatement.close();
        //database.endConnection();
    }

    @Override
    public List<Artist> findByName(String name) throws SQLException {
        Database database = Database.getInstance();

        PreparedStatement getArtistsStatement = database.getStatement("SELECT ID, Country FROM Artists WHERE Name = ?");
        getArtistsStatement.setString(1, name);
        ResultSet artistRows = getArtistsStatement.executeQuery();

        List<Artist> artists = new ArrayList<>();
        while (artistRows.next())
            artists.add(new Artist(artistRows.getInt(1), name, artistRows.getString(2)));
        artistRows.close();
        getArtistsStatement.close();
        //database.endConnection();
        return artists;
    }

    public void endConnexion(Database database) throws SQLException {
        database.endConnection();
    }

    public void printArtists() throws SQLException {
        Database database = Database.getInstance();
        String sqlQuery = "SELECT * from artists;";
        PreparedStatement statement = database.getStatement(sqlQuery);
        ResultSet artistsRows = statement.executeQuery();

        while(artistsRows.next())
            System.out.println("Artist ID: " + artistsRows.getInt(1) + ", " + "Artist name: " +  artistsRows.getString(2)
                    + ", " + "Country: " +  artistsRows.getString(3));
    }
}
