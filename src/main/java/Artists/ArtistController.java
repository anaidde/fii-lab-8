package Artists;

import java.sql.SQLException;
import java.util.List;

public interface ArtistController {
   public void create(String name, String country) throws SQLException;
   public List<Artist> findByName(String name) throws SQLException;
}
