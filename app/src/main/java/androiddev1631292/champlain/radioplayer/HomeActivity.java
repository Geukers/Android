package androiddev1631292.champlain.radioplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import androiddev1631292.champlain.radioplayer.DB.DBSQLiteManager;
import androiddev1631292.champlain.radioplayer.Models.Song;

public class HomeActivity extends AppCompatActivity {


    ArrayList<Song> songs;
    DBSQLiteManager manager;
    SongAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        RecyclerView rvContacts = findViewById(R.id.recyclerView);

        rvContacts.addItemDecoration(new DividerItemDecoration(getApplicationContext(),DividerItemDecoration.VERTICAL));

        //contacts = DBManager.getContact_list();

        manager = new DBSQLiteManager(this);

        songs = manager.getMaster_list();
        manager.getMasterSongs();

        adapter = new SongAdapter(songs);
        rvContacts.setAdapter(adapter);
        rvContacts.setLayoutManager(new LinearLayoutManager(this));
    }
}
