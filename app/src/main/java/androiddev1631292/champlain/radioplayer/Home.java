package androiddev1631292.champlain.radioplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button BtnNews = findViewById(R.id.BtnNews);
        Button BtnAdd = findViewById(R.id.BtnAddSongs);
        Button BtnList = findViewById(R.id.BtnList);
        Button BtnAbout = findViewById(R.id.BtnAbout);
        Button BtnContact = findViewById(R.id.BtnContact);


        BtnNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Home.this, News.class));

            }
        });

        BtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Home.this, AddSongActivity.class));

            }
        });

        BtnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Home.this, Playlist.class));

            }
        });

        BtnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Home.this, About_Us.class));

            }
        });

        BtnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Home.this, Contact_Us.class));

            }
        });

    }
}
