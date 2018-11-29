package is.apisavia.isavia.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class PlaylistActivity extends AppCompatActivity {

    private String [] songTitles;
    private ArrayList<String> listSongTitles;
    ArrayAdapter<String> adapter;
    ListView listViewSongs;

    //footer variables
    private ImageButton home;
    private ImageButton search;
    private ImageButton user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        listViewSongs = (ListView) findViewById(R.id.songlist);

        songTitleListMethod();

        // click handler fyrir lögin, fer bara í sama spilarann
        listViewSongs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Intent intent = new Intent(PlaylistActivity.this, SongActivity.class);
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
                Intent intent = new Intent(PlaylistActivity.this, SearchActivity.class);

                startActivity(intent);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlaylistActivity.this, HotActivity.class);

                startActivity(intent);
            }
        });

        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlaylistActivity.this, Userpage.class);
                startActivity(intent);
            }
        });


    }

    private void songTitleListMethod () {
        songTitles = new String[]{"Timmy tom", "Lorem Ipsum", "Fun Song", "Jump", "Sit Down"};
        listSongTitles = new ArrayList<>(Arrays.asList(songTitles));
        adapter = new ArrayAdapter<>(this, R.layout.row_layout, R.id.songTitle, listSongTitles);
        listViewSongs.setAdapter(adapter);
    }
}
