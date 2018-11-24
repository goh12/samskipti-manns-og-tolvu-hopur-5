package is.apisavia.isavia.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import java.io.File;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class PlayFolkloreActivity extends SameiginlegtActivity {



    protected String       webUrl                        = "";
    @SuppressWarnings("unused")
    private static final String TAG                      = "RegisterActivity";
    public  static final int DIALOG_DOWNLOAD_PROGRESS    = 0;
    private static final int REQUEST_CODE                = 10;
    //
    // titill... inniheldur nuverandi vefslod a hverjum tima.
    protected final Activity titillAllraEfst             = this;




    protected Uri          uriIsavia                     = null;
    //
    protected WebView      wv                            = null;

    //
    //// protected ImageView    bidmynd                       = null;
    //
    protected URL          url                           = null; // Nytt fra Alnetinu.
    protected URL          kurl                          = null; // Aip skjol ur skjalageymslunni.
    protected HttpURLConnection con                      = null;
    //
    protected File         extStorageAppBasePath         = null;
    protected File         extStorageAppCachePath        = null;



    // SKILGREININGAR
    protected ImageView listen;
    protected VideoView showVidio;

    protected ImageButton escape;
    protected ImageButton home;
    protected ImageButton tilbaka;
    protected ImageButton favorite;

    protected TextView titillLagsins;

    protected Context context;

    protected String vefhlekkur;
    protected Integer veljaMynd;
    protected String veljaTexta;

    protected String vistaVefhlekk;
    protected String heimasidaFyrirVefHlekk;

    protected String tegund;

    protected Integer numActivity;

    protected InputStream is;

    protected Bundle bundle; // new Bundle();
    protected Intent intent; // new Intent(getApplicationContext(), secondActivity.class);
    private View v;
    private MotionEvent event;

    private boolean isFavorite;

    /**
     * Klasasmidur.
     */
    public PlayFolkloreActivity()
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
        favorite = null;
        isFavorite = false;
        numActivity = 0;
    } // public WorldmusicActivity ()
    //
    // SKILGREININGAR FYRIRKOMULAG

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_worldmusic);

        context = this;

        intentusRegister = new Intent(context, RegisterActivity.class);
        intentusMain = new Intent(context, MainActivity.class);
        intentusGenre = new Intent(context, GenreActivity.class);
        intentusFolklore = new Intent(context, FolkloreActivity.class);
        intentusWorldmusic = new Intent(context, WorldmusicActivity.class);
        intentusPlayWorldmusic = new Intent(context, PlayWorldmusicActivity.class);

        intent = getIntent();
        bundle = intent.getExtras();

        veljaMynd = bundle.getInt("select_picture");
        vefhlekkur = bundle.getString("select_web_side");
        veljaTexta = bundle.getString("select_title");

        // BYRJA AD TENGJA HLUSTUN VID ALLT SEM HAEGT ER AD SMELLA A.
        listen = findViewById(R.id.imageViewMusic001);
        escape = findViewById(R.id.imageButtonEscape);
        home =  findViewById(R.id.imageButtonHome);
        tilbaka = findViewById(R.id.imageButtonLeftArrow);
        favorite = findViewById(R.id.imageButtonFavorite);

        titillLagsins = findViewById(R.id.textViewMusic001);

        listen.setImageResource(veljaMynd);
        titillLagsins.setText(veljaTexta);

        // 4 smelli mogeguleikar (noefnin segir sig sjalft).
        listen.setHovered(true);
        escape.setHovered(true);
        home.setHovered(true);
        tilbaka.setHovered(true);
        favorite.setHovered(true);

        // Hlusta a valid lag af listanum.
        listen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                listen.setColorFilter(0xaa00ff00);
                listen.setHovered(false);
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse(vefhlekkur)));

                listen.clearColorFilter();

                // Notandinn kemur hingad tilbaka um leid og vidkomandi haettir ad hlusta i YouTube.
                //
            } // public void onClick(View v)
        }); // next.setOnClickListener(new View.OnClickListener()

        // FARA TILBAKA TIL GENRE (MYND AF VINSTRI OER).
        tilbaka.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                tilbaka.setHovered(false);

                // Fara tilbaka i WorldmusicActivity.java.
                startActivity(intentusFolklore);
                // listen.setColorFilter(0xaa00ff00);
                listen.clearColorFilter();
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

        // imageButtonHome

        escape.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Bless.killApp(true);
                //
            } // public void onClick(View v)
        }); // escape.setOnClickListener(new View.OnClickListener()


        favorite.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                favorite.setHovered(false);

                if(isFavorite) {
                    listen.clearColorFilter();
                    isFavorite = false;
                } else {
                    listen.setColorFilter(0xaa00ff00);
                    isFavorite = true;
                } // if(isColored.equals("0xaa00ff00"))

                // listen.clearColorFilter();
                // finishActivity(0);
                // Notandinn kemur hingad tilbaka um leid og vidkomandi haettir ad hlusta i YouTube.
                //
            } // public void onClick(View v)
        }); // next.setOnClickListener(new View.OnClickListener()



        //
    } // void onCreate(Bundle savedInstanceState)
    //
} // public class WorldmusicActivity  extends SameiginlegtActivity
//.
