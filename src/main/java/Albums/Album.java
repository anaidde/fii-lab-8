package Albums;

public class Album {
    private String name;
    private int artistId;
    private int releaseYear;
    private int id;
    private int topNumber;

    public Album(int id, String name, int artistId, int releaseYear) {
        this.id = id;
        this.name = name;
        this.artistId = artistId;
        this.releaseYear = releaseYear;
    }

    public void setTopNumber(int topNumber) {
        this.topNumber = topNumber;
    }

    public int getTopNumber() {
        return this.topNumber;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getArtistId() {
        return artistId;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String toString() {
        return this.id + " " + this.name + " " + this.artistId + " " + this.releaseYear;
    }

}
