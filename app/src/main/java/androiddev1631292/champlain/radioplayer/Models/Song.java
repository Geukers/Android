package androiddev1631292.champlain.radioplayer.Models;

public class Song {

    public static final String TABLE_NAME = "MasterSongs";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_ARTIST = "artist";
    public static final String COLUMN_ALBUM = "album";
    public static final String COLUMN_GENRE = "genre";
    public static final String COLUMN_YEAR = "year";


    // DB create
    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_NAME + " TEXT,"
            + COLUMN_ARTIST + " TEXT,"
            + COLUMN_ALBUM + " TEXT,"
            + COLUMN_GENRE + " TEXT,"
            + COLUMN_YEAR + " TEXT)";

    private Integer ID;
    public String name;
    public String artist;
    public String album;
    public String genre;
    public String year;

    public Song(String name, String artist, String album, String genre, String year){
        this.name = name;
        this.artist = artist;
        this.album = album;
        this.genre = genre;
        this.year = year;
    }

    public Song()
    {

    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
