package androiddev1631292.champlain.radioplayer.DB;

import androiddev1631292.champlain.radioplayer.Models.User;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBSQLiteManager extends SQLiteOpenHelper {

    private static ArrayList<User> user_list = new ArrayList<>();

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

    public void getContacts()
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

    public ArrayList<User> getContact_list()
    {
        // return contact list
        return user_list;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(User.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Do nothing, like a boss.
    }
}
