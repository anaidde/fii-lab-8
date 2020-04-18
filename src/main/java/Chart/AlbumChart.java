package Chart;

public class AlbumChart {
    private int id;
    private int albumID;
    private String albumName;
    private int topPosition;

    public AlbumChart(int id, int albumID, String albumName, int topPosition) {
        this.id = id;
        this.albumID = albumID;
        this.albumName = albumName;
        this.topPosition = topPosition;
    }
}
