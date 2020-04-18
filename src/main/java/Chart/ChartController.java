package Chart;

import Albums.Album;
import Artists.Artist;

import java.sql.SQLException;
import java.util.List;

public interface ChartController {
    public void createChart(List<Album> albums) throws SQLException;
}
