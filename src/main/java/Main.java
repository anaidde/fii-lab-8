import Albums.Album;
import Albums.AlbumDAO;
import Artists.Artist;
import Artists.ArtistsDAO;
import Chart.AlbumChartDAO;
import DB.ArtistThread;
import DB.ConnectionPool;
import DB.MyThreadPoolExecutor;
import com.github.javafaker.Faker;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

public class Main {

    public static <PooledConnectionDataSource> void main(String[] args) throws SQLException, PropertyVetoException {
        AlbumDAO album = new AlbumDAO();
        ArtistsDAO artist = new ArtistsDAO();
        AlbumChartDAO albumChart = new AlbumChartDAO();
        Faker faker = new Faker();

        String artistName = faker.artist().name();
        String artistCountry = faker.country().name();
        artist.create(artistName, artistCountry);

        String albumName = faker.rockBand().name();
        int artistID = artist.findByName(artistName).get(0).getID();
        int releaseYear = faker.number().numberBetween(1950, 2020);
        album.create(albumName, artistID, releaseYear);

        List<Album> albumList = new ArrayList<>();
        List<Artist> artistList = new ArrayList<>();

        albumList = album.findByArtist(2);
        for (Album album1 : albumList) {
            System.out.println(album1);
        }

        artistList = artist.findByName("RHCP");
        for (Artist artist1 : artistList) {
            System.out.println(artist1);
        }

        List<Album> albums = new ArrayList<>();
        albums = album.getAllAlbums();
        System.out.println("Artists");
        artist.printArtists();
        System.out.println("Albums");
        album.printAlbums();
        System.out.println("Current Chart");
        albumChart.createChart(albums);
        albumChart.showChart();

        MyThreadPoolExecutor threadPoolExecutor = (MyThreadPoolExecutor) Executors.newFixedThreadPool(15);


        for (int i = 1; i <= 15; i++) {
            Runnable artistThread = new ArtistThread(i);
            threadPoolExecutor.execute(artistThread);
            artistThread.run();
        }

    }

}
