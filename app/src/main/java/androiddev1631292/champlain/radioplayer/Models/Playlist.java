package androiddev1631292.champlain.radioplayer.Models;

public class Playlist {
    public static final String TABLE_NAME = "Playlist";
    public static final String COLUMN_ID = "id";

    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT)";

    public Integer ID;

    public Playlist(Integer ID) {
        this.ID = ID;
    }

    public Playlist()
    {

    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }
}
