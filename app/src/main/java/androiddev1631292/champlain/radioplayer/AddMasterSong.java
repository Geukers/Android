package androiddev1631292.champlain.radioplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import androiddev1631292.champlain.radioplayer.DB.DBSQLiteManager;
import androiddev1631292.champlain.radioplayer.Models.Song;
import androiddev1631292.champlain.radioplayer.Models.User;

public class AddMasterSong extends AppCompatActivity {


    ArrayList<Song> songs;
    DBSQLiteManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_master_song);

        manager = new DBSQLiteManager(this);
        songs = manager.getMaster_list();
        manager.getMasterSongs();

        Button RegisterBtn = findViewById(R.id.AddSong);
        Button BackBtn = findViewById(R.id.BtnBack);

        RegisterBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                EditText name1 = findViewById(R.id.BoxName);
                EditText artist1 = findViewById(R.id.BoxArtist);
                EditText album1 = findViewById(R.id.BoxAlbum);
                EditText genre1 = findViewById(R.id.BoxGenre);
                EditText year1 = findViewById(R.id.BoxYear);

                String name = name1.getText().toString();
                String artist = artist1.getText().toString();
                String album = album1.getText().toString();
                String genre = genre1.getText().toString();
                String year = year1.getText().toString();

                Song newSong = new Song(name, artist, album, genre, year);

                addMasterSong(newSong);

                name1.setText("");
                artist1.setText("");
                album1.setText("");
                genre1.setText("");
                year1.setText("");

                Toast toast = Toast.makeText(getApplicationContext(), "Song Added", Toast.LENGTH_SHORT);
                toast.show();

            }
        });


        BackBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                startActivity(new Intent(AddMasterSong.this, Home.class));
            }
        });
    }

    private void addMasterSong(Song c) {

        //Contact createdContact = DBManager.addContact(c);

        DBSQLiteManager dbslm = new DBSQLiteManager(this);
        dbslm.addMasterSong(c);

    }
}
