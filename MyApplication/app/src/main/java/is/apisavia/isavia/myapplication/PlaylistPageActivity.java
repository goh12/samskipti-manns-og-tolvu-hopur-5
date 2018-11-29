package is.apisavia.isavia.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class PlaylistPageActivity extends AppCompatActivity {

    private ImageButton home, search ,user;
    private ImageButton party, house, jazz;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist_page);

        party = findViewById(R.id.partybtn);
        house = findViewById(R.id.housebtn);
        jazz = findViewById(R.id.jazzbtn);

        party.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlaylistPageActivity.this, PlaylistActivity.class);
                startActivity(intent);
            }
        });

        house.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlaylistPageActivity.this, PlaylistActivity.class);
                startActivity(intent);
            }
        });

        jazz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlaylistPageActivity.this, PlaylistActivity.class);
                startActivity(intent);
            }
        });

        // footer activity
        home = findViewById(R.id.imageButtonHomeScreen);
        search = findViewById(R.id.imageButtonSearch);
        user = findViewById(R.id.imageButtonUser);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlaylistPageActivity.this, SearchActivity.class);

                startActivity(intent);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlaylistPageActivity.this, HotActivity.class);
                startActivity(intent);
            }
        });

        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlaylistPageActivity.this, Userpage.class);
                startActivity(intent);
            }
        });

    }
}
