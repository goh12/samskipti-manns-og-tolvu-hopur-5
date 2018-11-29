package is.apisavia.isavia.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.Arrays;

public class SearchActivity extends AppCompatActivity {

    private String [] songTitles;
    private ArrayList<String> listSongTitles;
    private EditText search;
    ArrayAdapter<String> adapter;
    ListView listViewSongs;

    //footer variables
    private ImageButton home;
    private ImageButton user;
    private ToggleButton tbFavorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.row_layout);
        tbFavorite = (ToggleButton) findViewById(R.id.tbToggleFav);

        setContentView(R.layout.activity_search);

        listViewSongs = (ListView) findViewById(R.id.songlist);
        search = (EditText) findViewById(R.id.search);

        songTitleListMethod();



        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().equals("")) {
                    songTitleListMethod();
                } else  {
                    searchSongs(s.toString());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        // click handler fyrir lögin, fer bara í sama spilarann
        listViewSongs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Intent intent = new Intent(SearchActivity.this, SongActivity.class);
                startActivity(intent);
            }
        });

        Log.d("String", "heyo");
        // click handler fyrir favorite
        tbFavorite.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d("clicked", "is this clicked");
                if (isChecked) {
                    tbFavorite.setBackgroundResource(R.drawable.heart_filled);
                } else {
                    tbFavorite.setBackgroundResource(R.drawable.heart);
                }
            }
        });

        // footer activity
        home = findViewById(R.id.imageButtonHomeScreen);
        user = findViewById(R.id.imageButtonUser);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchActivity.this, HotActivity.class);
                startActivity(intent);
            }
        });

        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchActivity.this, Userpage.class);
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

    private void searchSongs(String songSearch) {
        for (String i : songTitles) {
            if (!i.contains(songSearch)) {
                listSongTitles.remove(i);
            }
        }

        adapter.notifyDataSetChanged();
    }
}
