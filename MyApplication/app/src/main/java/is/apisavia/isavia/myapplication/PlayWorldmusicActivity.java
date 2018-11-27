package is.apisavia.isavia.myapplication;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;


public class PlayWorldmusicActivity extends SameiginlegtActivity {

    // SKILGREININGAR
    protected ImageView listen;

    protected ImageButton escape;
    protected ImageButton home;
    protected ImageButton tilbaka;

    protected TextView titillLagsins;

    protected Context context;

    protected String vefhlekkur;
    protected Integer veljaMynd;
    protected String veljaTexta;

    protected String vistaVefhlekk;
    protected String heimasidaFyrirVefHlekk;

    protected String tegund;

    protected InputStream is;

    protected Bundle bundle;
    protected Intent intent;
    private View v;

    private boolean isFavorite;

    /**
     * Klasasmidur.
     */
    public PlayWorldmusicActivity()
    {
        // Klasa-smidur
        listen = null;
        escape = null;
        home = null;
        tilbaka = null;
        context = null;

        vefhlekkur = "";
        vistaVefhlekk = "";
        heimasidaFyrirVefHlekk = "";

        tegund = "";

        is = null;
        titillLagsins = null;

        bundle = null;
        intent = null;

        veljaTexta = "";
        veljaMynd = 0;

        isFavorite = false;

        //
    } // public WorldmusicActivity ()
    //

    // SKILGREININGAR FYRIRKOMULAG.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_worldmusic);

        context = this;

        bundle = new Bundle();
        intent = new Intent(getApplicationContext(), WorldmusicActivity.class);

        intentusRegister = new Intent(context, RegisterActivity.class);
        intentusMain = new Intent(context, MainActivity.class);
        intentusGenre = new Intent(context, GenreActivity.class);
        intentusFolklore = new Intent(context, FolkloreActivity.class);
        intentusWorldmusic = new Intent(context, WorldmusicActivity.class);
        intentusPlayWorldmusic = new Intent(context, PlayWorldmusicActivity.class);

        intent = getIntent();
        bundle = intent.getExtras();

        isFavorite = bundle.getBoolean("is_favorite", false);
        veljaMynd = bundle.getInt("select_picture");
        vefhlekkur = bundle.getString("select_web_side");
        veljaTexta = bundle.getString("select_title");

        // BYRJA AD TENGJA HLUSTUN VID ALLT SEM HAEGT ER AD SMELLA A.
        listen = findViewById(R.id.imageViewMusic001);
        escape = findViewById(R.id.imageButtonEscape);
        home =  findViewById(R.id.imageButtonHome);
        tilbaka = findViewById(R.id.imageButtonLeftArrow);
        // favorite = findViewById(R.id.imageButtonFavorite);

        titillLagsins = findViewById(R.id.textViewMusic001);

        listen.setImageResource(veljaMynd);
        titillLagsins.setText(veljaTexta);

        // 4 smelli mogeguleikar (noefnin segir sig sjalft).
        listen.setHovered(true);
        escape.setHovered(true);
        home.setHovered(true);
        tilbaka.setHovered(true);
        // favorite.setHovered(true);

        if(isFavorite) {
            listen.setColorFilter(0xaa00ff00);
        } else {
            listen.clearColorFilter();
        } // if(isColored.equals("0xaa00ff00"))

        // Hlusta a valid lag af listanum.
        listen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                listen.setHovered(false);
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse(vefhlekkur)));

                // Notandinn kemur hingad tilbaka um leid og vidkomandi haettir ad hlusta i YouTube.
                //
            } // public void onClick(View v)
        }); // next.setOnClickListener(new View.OnClickListener()

        // FARA TILBAKA TIL GENRE (MYND AF VINSTRI OER).
        tilbaka.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                tilbaka.setHovered(false);
                startActivity(intentusWorldmusic);
                Bless.killApp(true);
                //
            } // public void onClick(View v)
        }); // next.setOnClickListener(new View.OnClickListener()

        // FARA TILBAKA TIL UPPHAFS-SIDU. I THESSUM RAMMA ER THAD "HOME" (MYND AF HUSI).
        home.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                home.setHovered(false);

                // Fara yfir i naesta ramma (GenreActivity.java).
                startActivity(intentusMain);

                // Loka upphafs-rammann.
                Bless.killApp(true);
                //
            } // public void onClick(View v)
        }); // next.setOnClickListener(new View.OnClickListener()

        escape.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Bless.killApp(true);
                //
            } // public void onClick(View v)
        }); // escape.setOnClickListener(new View.OnClickListener()
          //
        //
    } // void onCreate(Bundle savedInstanceState)
    //
} // public class WorldmusicActivity  extends SameiginlegtActivity
//.
