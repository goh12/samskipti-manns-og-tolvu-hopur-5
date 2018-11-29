package is.apisavia.isavia.myapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

public class HotActivity extends AppCompatActivity {
    //footer variables
    private ImageButton home;
    private ImageButton search;
    private ImageButton user;
    // g
    private ImageButton avicii, world, christmas, folklore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hot);

        // Button activity
        avicii = findViewById(R.id.aviciiBtn);
        world = findViewById(R.id.worldBtn);
        christmas = findViewById(R.id.christmasBtn);
        folklore = findViewById(R.id.folkLoreBtn);

        avicii.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HotActivity.this, PlaylistActivity.class);
                startActivity(intent);
            }
        });

        world.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HotActivity.this, PlaylistActivity.class);
                startActivity(intent);
            }
        });

        christmas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HotActivity.this, PlaylistActivity.class);
                startActivity(intent);
            }
        });

        folklore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HotActivity.this, PlaylistActivity.class);
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
                Intent intent = new Intent(HotActivity.this, SearchActivity.class);

                startActivity(intent);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HotActivity.this, HotActivity.class);
                startActivity(intent);
            }
        });

        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HotActivity.this, Userpage.class);
                startActivity(intent);
            }
        });
    }
}
