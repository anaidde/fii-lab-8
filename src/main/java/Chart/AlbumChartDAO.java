package Chart;

import Albums.Album;
import DB.Database;
import com.github.javafaker.Faker;

import java.util.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlbumChartDAO implements ChartController{
    @Override
    public void createChart(List<Album> albums) throws SQLException {
        Database database = Database.getInstance();
        List<Integer> topPositions = new ArrayList<>();
        int positionListIndex = 1;

        for(int i=1; i<=albums.size(); i++) {
            topPositions.add(new Integer(i));
        }
            Collections.shuffle(topPositions);

        for(Album album : albums) {
            PreparedStatement createAlbumChart = database.getStatement(
                    "insert into album_chart(album_id, album_name, top_position) values (?, ?, ?)"
            );
            createAlbumChart.setInt(1,album.getId());
            createAlbumChart.setString(2, album.getName());
            createAlbumChart.setInt(3, positionListIndex);
            createAlbumChart.execute();
            positionListIndex ++ ;
        }

    }

    public void showChart() throws SQLException {
        Database database = Database.getInstance();
        PreparedStatement filterArtistsByRank = database.getStatement
                ("select top_position, ar.id, ar.name, country from artists ar join albums al on ar.id = al.artist_id" +
                        " join album_chart ac on ac.album_id = al.id order by ac.top_position;");

        ResultSet topRow = filterArtistsByRank.executeQuery();
        List<AlbumChart> albumCharts = new ArrayList<>();
        while(topRow.next())
            System.out.println(
                    "Position: " + topRow.getInt(1) + " " +
                    "Artist ID: " + topRow.getInt(2) + " " +
                    "Artist Name: " + topRow.getString(3) + " " +
                    "Artist's Country: " + topRow.getString(4));
    }
}
