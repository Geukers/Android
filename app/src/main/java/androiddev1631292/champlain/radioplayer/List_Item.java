package androiddev1631292.champlain.radioplayer;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import androiddev1631292.champlain.radioplayer.DB.DBSQLiteManager;
import androiddev1631292.champlain.radioplayer.Models.Song;

public class List_Item extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_list_item);
    }
}
