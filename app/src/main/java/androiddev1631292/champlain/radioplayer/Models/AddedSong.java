package androiddev1631292.champlain.radioplayer.Models;

public class AddedSong {

    public static final String TABLE_NAME = "AddedSong";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_SONGID = "songID";
    public static final String COLUMN_USERNAME = "username";


    // DB create
    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_SONGID + " INTEGER,"
            + COLUMN_USERNAME + " TEXT)";

    public Integer ID;
    public Integer songID;
    public String username;

    public AddedSong(Integer songID, String username) {
        this.songID = songID;
        this.username = username;
    }

    public AddedSong()
    {

    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getSongID() {
        return songID;
    }

    public void setSongID(Integer songID) {
        this.songID = songID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
