package androiddev1631292.champlain.radioplayer.DB;

import androiddev1631292.champlain.radioplayer.Models.Song;
import androiddev1631292.champlain.radioplayer.Models.User;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBSQLiteManager extends SQLiteOpenHelper {

    private static ArrayList<User> user_list = new ArrayList<>();
    private static ArrayList<Song> master_list = new ArrayList<>();

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "User_db";

    public DBSQLiteManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public User addUser(User c)
    {
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(User.COLUMN_USERNAME, c.getUsername());
        values.put(User.COLUMN_EMAIL, c.getEmail());
        values.put(User.COLUMN_PASSWORD, c.getPassword());

        long id = db.insert(User.TABLE_NAME, null, values);
        db.close();

        user_list.add(c);

        return c;
    }

    public void getUsers()
    {
        // Select All Query
        String selectQuery = "SELECT  * FROM " + User.TABLE_NAME + " ORDER BY " +
                User.COLUMN_USERNAME + " DESC";

        user_list.clear();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                User c = new User();
                c.setUsername(cursor.getString(cursor.getColumnIndex(User.COLUMN_USERNAME)));
                c.setEmail(cursor.getString(cursor.getColumnIndex(User.COLUMN_EMAIL)));
                c.setPassword(cursor.getString(cursor.getColumnIndex(User.COLUMN_PASSWORD)));

                user_list.add(c);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();
    }

    public ArrayList<User> getUser_list()
    {
        // return contact list

        return user_list;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(User.CREATE_TABLE);
        db.execSQL(Song.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Do nothing, like a boss.
    }



    //
    //Master/Shop Songs
    //
    public Song addMasterSong(Song c)
    {
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Song.COLUMN_ID, c.getID());
        values.put(Song.COLUMN_NAME, c.getName());
        values.put(Song.COLUMN_ARTIST, c.getArtist());
        values.put(Song.COLUMN_ALBUM, c.getAlbum());
        values.put(Song.COLUMN_GENRE, c.getGenre());
        values.put(Song.COLUMN_YEAR, c.getYear());

        long id = db.insert(Song.TABLE_NAME, null, values);
        db.close();

        c.setID((int)id);
        master_list.add(c);

        return c;
    }

    public void getMasterSongs()
    {
        // Select All Query
        String selectQuery = "SELECT  * FROM " + Song.TABLE_NAME + " ORDER BY " +
                Song.COLUMN_NAME + " DESC";

        master_list.clear();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Song c = new Song();
                c.setID(cursor.getInt(cursor.getColumnIndex(Song.COLUMN_ID)));
                c.setName(cursor.getString(cursor.getColumnIndex(Song.COLUMN_NAME)));
                c.setArtist(cursor.getString(cursor.getColumnIndex(Song.COLUMN_ARTIST)));
                c.setAlbum(cursor.getString(cursor.getColumnIndex(Song.COLUMN_ALBUM)));
                c.setGenre(cursor.getString(cursor.getColumnIndex(Song.COLUMN_GENRE)));
                c.setYear(cursor.getString(cursor.getColumnIndex(Song.COLUMN_YEAR)));

                master_list.add(c);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();
    }

    public ArrayList<Song> getMaster_list()
    {
        // return contact list

        return master_list;
    }

}
