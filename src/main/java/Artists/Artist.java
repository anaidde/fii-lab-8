package Artists;

public class Artist  {
    private int id;
    private String name;
    private String country;

    public Artist(int id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public int getID() { return this.id; }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String toString() {
        return this.id + " " + this.name + " " + this.country;
    }

}
