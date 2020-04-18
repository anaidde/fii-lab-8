package Chart;

public class Chart {
    private int id;
    private String name;
    private int albumChartID;

    public Chart(int id, String name, int albumChartID) {
        this.id = id;
        this.name = name;
        this.albumChartID = albumChartID;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAlbumChartID() {
        return albumChartID;
    }
}
