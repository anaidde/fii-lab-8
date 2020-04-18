package Albums;

import Artists.Artist;
import DB.Database;

import java.sql.Statement;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AlbumDAO implements AlbumController {
    @Override
    public void create(String name, int artistId, int releaseYear) throws SQLException {
        Database database = Database.getInstance();

        PreparedStatement insertionStatement = database.getStatement("INSERT INTO Albums(name, artist_id, release_year) VALUES (?, ?, ?)");
        insertionStatement.setString(1, name);
        insertionStatement.setInt(2, artistId);
        insertionStatement.setInt(3, releaseYear);
        insertionStatement.execute();
        insertionStatement.close();
        //database.endConnection();
    }

    @Override
    public List<Album> findByArtist(int artistId) throws SQLException {
        Database database = Database.getInstance();

        PreparedStatement getAlbumsStatement = database.getStatement("SELECT * FROM Albums where artist_id = ?");
        getAlbumsStatement.setInt(1, artistId);
        ResultSet albumsRows = getAlbumsStatement.executeQuery();

        List<Album> albums = new ArrayList<>();
        while (albumsRows.next())
            albums.add(new Album(albumsRows.getInt(1), albumsRows.getString(2), albumsRows.getInt(3), albumsRows.getInt(4)));
        albumsRows.close();
        getAlbumsStatement.close();
        //database.endConnection();

        return albums;

    }

    public List<Album> getAllAlbums() throws SQLException {
        Database database = Database.getInstance();
        List<Album> albumList = new ArrayList<>();
        PreparedStatement albumsStatement= database.getStatement(
                "Select * from albums"
        );

        ResultSet albumsRows = albumsStatement.executeQuery();

        while(albumsRows.next()){
            albumList.add(new Album(albumsRows.getInt(1),albumsRows.getString(2), albumsRows.getInt(3), albumsRows.getInt(4) ));
        }
        albumsRows.close();

        return  albumList;

    }

    public void printAlbums() throws SQLException {
        Database database = Database.getInstance();
        String sqlQuery = "SELECT * from albums;";
        PreparedStatement statement = database.getStatement(sqlQuery);
        ResultSet albumsRows = statement.executeQuery();

        while(albumsRows.next())
            System.out.println("Album ID: " + albumsRows.getInt(1) + ", " + "Album name: " +  albumsRows.getString(2)
                    + ", " + "Artist ID: " +  albumsRows.getInt(3) + ", " + "Release Year: " + albumsRows.getInt(4));
    }
}
