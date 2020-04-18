package Albums;

import java.sql.SQLException;
import java.util.List;

public interface AlbumController {
    public void create(String name, int artistId, int releaseYear) throws SQLException;
    public List<Album> findByArtist(int artistId) throws SQLException;
}
