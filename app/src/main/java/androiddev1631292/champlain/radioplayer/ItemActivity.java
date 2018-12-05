package androiddev1631292.champlain.radioplayer;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import androiddev1631292.champlain.radioplayer.DB.DBSQLiteManager;
import androiddev1631292.champlain.radioplayer.Models.AddedSong;
import androiddev1631292.champlain.radioplayer.Models.Song;

public class ItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        Bundle extras = getIntent().getExtras();
        String ID = Integer.toString(extras.getInt("ID"));

        int IDi = Integer.parseInt(ID);

        final DBSQLiteManager db = new DBSQLiteManager(this);

        Song song = db.getSong(ID);

        TextView songName = findViewById(R.id.SongName);
        TextView artistName = findViewById(R.id.Artist);
        TextView albumName = findViewById(R.id.Album);
        TextView genreName = findViewById(R.id.Genre);
        TextView year = findViewById(R.id.Year);
        Button btnAdd = findViewById(R.id.BtnAdd);
        Button btnBack = findViewById(R.id.BtnBackToList);

        songName.setText(song.getName());
        artistName.setText(song.getArtist());
        albumName.setText(song.getAlbum());
        genreName.setText(song.getGenre());
        year.setText(song.getYear());

        SharedPreferences prefs = this.getSharedPreferences("Radio", MODE_PRIVATE);
        String t = prefs.getString("Username", "Error");

        final AddedSong newSong = new AddedSong(IDi, t);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(ItemActivity.this, AddSongActivity.class));

            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                db.addSong(newSong);

                startActivity(new Intent(ItemActivity.this, AddSongActivity.class));

            }
        });
    }
}
