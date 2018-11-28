package androiddev1631292.champlain.radioplayer;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import androiddev1631292.champlain.radioplayer.DB.DBSQLiteManager;
import androiddev1631292.champlain.radioplayer.Models.AddedSong;
import androiddev1631292.champlain.radioplayer.Models.Song;

public class Playlist extends AppCompatActivity {


    ArrayList<AddedSong> addedSongs;
    ArrayList<Song> songs;
    ArrayList<Song> list;
    DBSQLiteManager manager;
    AddedSongAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        Button btnReturn = findViewById(R.id.BtnReturn2);

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Playlist.this, Home.class));

            }
        });

        RecyclerView rvContacts = findViewById(R.id.ReAddedSongs);

        rvContacts.addItemDecoration(new DividerItemDecoration(getApplicationContext(),DividerItemDecoration.VERTICAL));

        manager = new DBSQLiteManager(this);

        SharedPreferences prefs = this.getSharedPreferences("Radio", MODE_PRIVATE);
        String t = prefs.getString("Username", null);

        addedSongs = manager.getAddedSong_list();
        songs = manager.getMaster_list();

        manager.getAddedSong();
        manager.getMasterSongs();

        for(AddedSong as : addedSongs )
        {
            for(Song s : songs)
            {
                if(t == as.getUsername() && s.getID() == as.getSongID())
                {
                    list.add(s);
                }
            }
        }

        adapter = new AddedSongAdapter(list);
        rvContacts.setAdapter(adapter);
        rvContacts.setLayoutManager(new LinearLayoutManager(this));
    }
}
