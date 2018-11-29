package is.apisavia.isavia.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Userpage extends AppCompatActivity {

    private Button favorite;
    private Button playlist;
    private Button artists;
    private ImageButton home, search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userpage);

        favorite = findViewById(R.id.button2);
        playlist = findViewById(R.id.playlistbtn);
        artists = findViewById(R.id.artistbtn);

        favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Userpage.this, UserActivity.class);
                startActivity(intent);
            }
        });

        playlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Userpage.this, PlaylistPageActivity.class);
                startActivity(intent);
            }
        });

        artists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Userpage.this, UserActivity.class);
                startActivity(intent);
            }
        });

        // footer activity
        home = findViewById(R.id.imageButtonHomeScreen);
        search = findViewById(R.id.imageButtonSearch);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Userpage.this, SearchActivity.class);
                startActivity(intent);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Userpage.this, HotActivity.class);
                startActivity(intent);
            }
        });

    }


}
