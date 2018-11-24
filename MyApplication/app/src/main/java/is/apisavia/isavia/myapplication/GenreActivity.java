package is.apisavia.isavia.myapplication;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import static is.apisavia.isavia.myapplication.R.*;


public class GenreActivity  extends SameiginlegtActivity {

    // SKILGREININGAR
    protected LinearLayout rammi;
    protected ImageView classic;
    protected ImageView jazz;
    protected ImageView folklore;
    protected ImageView worldmusic;
    protected ImageView blues;
    protected ImageView accordion;

    protected ImageButton escape;
    protected ImageButton tilbaka;

    protected Context context;


    /**
     * Klasasmidur.
     */
    public GenreActivity()
    {
        // Klasa-smidur
        classic = null;
        jazz = null;
        folklore = null;
        blues = null;
        accordion = null;
        escape = null;
        tilbaka = null;
        context = null;
        worldmusic = null;
        rammi = null;
    } // public GenreActivity ()
    //
    // SKILGREININGAR FYRIRKOMULAG
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_genre);

        context = this;
        rammi = new LinearLayout(context);

        intentusMain = new Intent(context, MainActivity.class);
        intentusGenre = new Intent(context, GenreActivity.class);
        intentusFolklore = new Intent(context, FolkloreActivity.class);
        intentusWorldmusic = new Intent(context, WorldmusicActivity.class);

        // BYRJA AD TENGJA HLUSTUN VID ALLT SEM HAEGT ER AD SMELLA A.
        rammi = findViewById(id.linearLayoutRammi);

        classic = findViewById(id.imageViewClassic);
        jazz = findViewById(id.imageViewJazz);
        folklore = findViewById(id.imageViewFolkore);
        worldmusic = findViewById(id.imageViewWorldmusic);
        blues = findViewById(id.imageViewBlues);
        accordion = findViewById(id.imageViewAccordion);

        escape = findViewById(id.imageButtonEscape);
        tilbaka = findViewById(id.imageButtonLeftArrow);

        classic.setImageResource(drawable.icon_fiddle_classic_styttri);
        jazz.setImageResource(drawable.icon_blues);
        folklore.setImageResource(drawable.icon_belarus_);
        worldmusic.setImageResource(drawable.icon_world_music_as_earth_and_g_music_key);
        blues.setImageResource(drawable.ftmjcxxxuvhwvpbaqmsi_kurteisi);
        accordion.setImageResource(drawable.h0620_akkordeon);

        classic.setHovered(true);
        jazz.setHovered(true);
        folklore.setHovered(true);
        worldmusic.setHovered(true);
        blues.setHovered(true);
        accordion.setHovered(true);

        escape.setHovered(true);
        tilbaka.setHovered(true);

        if(lodrettur == hvernigSnuaSnjallsiminn()) {
            rammi.setBackgroundResource(drawable.texture_pattern_design_2_portrait);
        } else {
            rammi.setBackgroundResource(drawable.texture_pattern_design_2_landscape);
        } // if else

        classic.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                classic.setHovered(false);

                // Fara yfir i naesta ramma (GenreActivity.java).
                // startActivityForResult(intentusGenre, 0);
                startActivity(intentusMain);

                // Loka upphafs-rammann.
                Bless.killApp(true);
                //
            } // public void onClick(View v)
        }); // next.setOnClickListener(new View.OnClickListener()

        jazz.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                jazz.setHovered(false);

                // Fara yfir i naesta ramma (GenreActivity.java).
                // startActivityForResult(intentusGenre, 0);
                startActivity(intentusMain);

                // Loka upphafs-rammann.
                Bless.killApp(true);
                //
            } // public void onClick(View v)
        }); // next.setOnClickListener(new View.OnClickListener()

        folklore.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                folklore.setHovered(false);

                // Fara yfir i naesta ramma (GenreActivity.java).
                // startActivityForResult(intentusGenre, 0);
                startActivity(intentusFolklore);

                // Loka upphafs-rammann.
                Bless.killApp(true);
                //
            } // public void onClick(View v)
        }); // next.setOnClickListener(new View.OnClickListener()

        worldmusic.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                worldmusic.setHovered(false);

                // Fara yfir i naesta ramma (GenreActivity.java).
                // startActivityForResult(intentusGenre, 0);
                startActivity(intentusWorldmusic);

                // Loka upphafs-rammann.
                Bless.killApp(true);
                //
            } // public void onClick(View v)
        }); // next.setOnClickListener(new View.OnClickListener()

        blues.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                blues.setHovered(false);

                // Fara yfir i naesta ramma (GenreActivity.java).
                // startActivityForResult(intentusGenre, 0);
                startActivity(intentusMain);

                // Loka upphafs-rammann.
                Bless.killApp(true);
                //
            } // public void onClick(View v)
        }); // next.setOnClickListener(new View.OnClickListener()

        accordion.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                accordion.setHovered(false);

                // Fara yfir i naesta ramma (GenreActivity.java).
                // startActivityForResult(intentusGenre, 0);
                startActivity(intentusMain);

                // Loka upphafs-rammann.
                Bless.killApp(true);
                //
            } // public void onClick(View v)
        }); // next.setOnClickListener(new View.OnClickListener()



        // imageViewAccordion

        // FARA TILBAKA TIL UPPHAFS-SIDU. I OEDRUM ROEMMUM VERDUR THAD "HOME" (MYND AF HUSI).
        tilbaka.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                tilbaka.setHovered(false);

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

    } // void onCreate(Bundle savedInstanceState)
    //
} // public GenreActivity()
//.