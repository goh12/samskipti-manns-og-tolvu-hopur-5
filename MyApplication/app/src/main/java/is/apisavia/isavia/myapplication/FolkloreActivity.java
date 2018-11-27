package is.apisavia.isavia.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FolkloreActivity  extends SameiginlegtActivity {

    // SKILGREININGAR
    protected LinearLayout rammi;
    protected ImageView music001;
    protected ImageView music002;
    protected ImageView music003;
    protected ImageView music004;
    protected ImageView music005;

    protected ImageButton escape;
    protected ImageButton home;
    protected ImageButton tilbaka;

    protected TextView titillLagsins01;
    protected TextView titillLagsins02;
    protected TextView titillLagsins03;
    protected TextView titillLagsins04;
    protected TextView titillLagsins05;

    protected Integer numActivity;

    protected Context context;

    protected Bundle bundle; // new Bundle();
    protected Intent intent; // new Intent(getApplicationContext(), secondActivity.class);

    /**
     * Klasasmidur.
     */
    public FolkloreActivity()
    {
        // Klasa-smidur
        music001 = null;
        music002 = null;
        music003 = null;
        music004 = null;
        music005 = null;
        escape = null;
        home = null;
        tilbaka = null;
        context = null;
        bundle = null;
        intent = null;
        rammi = null;

        titillLagsins01 = null;
        titillLagsins02 = null;
        titillLagsins03 = null;
        titillLagsins04 = null;
        titillLagsins05 = null;
        numActivity = 0;
    } // public WorldmusicActivity ()
    //
    // SKILGREININGAR FYRIRKOMULAG

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_folklore);

        context = this;
        rammi = new LinearLayout(context);

        bundle = new Bundle();
        intent = new Intent(getApplicationContext(), PlayFolkloreActivity.class);

        intentusRegister = new Intent(context, RegisterActivity.class);
        intentusMain = new Intent(context, MainActivity.class);
        intentusGenre = new Intent(context, GenreActivity.class);
        intentusFolklore = new Intent(context, FolkloreActivity.class);
        intentusWorldmusic = new Intent(context, WorldmusicActivity.class);
        intentusPlayWorldmusic = new Intent(context, PlayWorldmusicActivity.class);
        intentusPlayFolklore = new Intent(context, PlayFolkloreActivity.class);

        // BYRJA AD TENGJA HLUSTUN VID ALLT SEM HAEGT ER AD SMELLA A.
        music001 = findViewById(R.id.imageViewMusic001);
        music002 = findViewById(R.id.imageViewMusic002);
        music003 = findViewById(R.id.imageViewMusic003);
        music004 = findViewById(R.id.imageViewMusic004);
        music005 = findViewById(R.id.imageViewMusic005);

        escape = findViewById(R.id.imageButtonEscape);
        home =  findViewById(R.id.imageButtonHome);
        tilbaka = findViewById(R.id.imageButtonLeftArrow);

        if(lodrettur == hvernigSnuaSnjallsiminn()) {
            rammi.setBackgroundResource(R.drawable.texture_pattern_design_14_portrait);
        } else {
            rammi.setBackgroundResource(R.drawable.texture_pattern_design_14_landscape);
        } // if else

        titillLagsins01 = findViewById(R.id.textViewMusic001);
        titillLagsins02 = findViewById(R.id.textViewMusic002);
        titillLagsins03 = findViewById(R.id.textViewMusic003);
        titillLagsins04 = findViewById(R.id.textViewMusic004);
        titillLagsins05 = findViewById(R.id.textViewMusic005);

        // music001.setImageResource(R.drawable.icon_balam_pichkari);
        music001.setImageResource(R.drawable.icon_dimitru_dobrican_si_dantausi_din_grosi_2011);

        music002.setImageResource(R.drawable.icon_andra_mai_tii_minte_draga_marie_marie_si_marioara_);
        music003.setImageResource(R.drawable.icon_sahydursun_garajayewa_sings_salamymny_);
        music004.setImageResource(R.drawable.icon_sahydursun_garajayewa_sings_salamymny_);
        music005.setImageResource(R.drawable.icon_sahydursun_garajayewa_sings_salamymny_);

        // titillLagsins01.setText(getString(R.string.vishal_dadlani_and_shalmali_kholgade_sing_balam_pickari));
        titillLagsins01.setText(getString(R.string.dumitru_dobrican_si_dantausi_din_grosi));

        titillLagsins02.setText(getString(R.string.mai_tii_minte_drage_marie_cu_marie_si_marioara));
        titillLagsins03.setText(getString(R.string.sahydursun_sings_salamymny));
        titillLagsins04.setText(getString(R.string.sahydursun_sings_salamymny));
        titillLagsins05.setText(getString(R.string.sahydursun_sings_salamymny));

        music001.setHovered(true);
        music002.setHovered(true);
        music003.setHovered(true);
        music004.setHovered(true);
        music005.setHovered(true);

        escape.setHovered(true);
        home.setHovered(true);
        tilbaka.setHovered(true);

        music001.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                music001.setHovered(false);

                // bundle.putInt("select_picture",R.drawable.icon_balam_pichkari);
                // bundle.putString("select_web_side","http://www.youtube.com/watch?v=Hxy8BZGQ5Jo");
                // bundle.putString("select_title",getString(R.string.vishal_dadlani_and_shalmali_kholgade_sing_balam_pickari));

                bundle.putInt("select_picture",R.drawable.icon_dimitru_dobrican_si_dantausi_din_grosi_2011);
                bundle.putString("select_web_side","https://www.youtube.com/watch?v=LUeYoGGluH4");
                bundle.putString("select_title",getString(R.string.dumitru_dobrican_si_dantausi_din_grosi));


                // Fara yfir i naesta ramma.
                intentusPlayFolklore.putExtras(bundle);
                startActivity(intentusPlayFolklore);

                // Loka upphafs-rammann.
                Bless.killApp(true);
                //
            } // public void onClick(View v)
        }); // next.setOnClickListener(new View.OnClickListener()

        music002.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                music002.setHovered(false);

                bundle.putInt("select_picture",R.drawable.icon_andra_mai_tii_minte_draga_marie_marie_si_marioara_);
                bundle.putString("select_web_side","https://www.youtube.com/watch?v=amYYTJ0tAfk");
                bundle.putString("select_title",getString(R.string.mai_tii_minte_drage_marie_cu_marie_si_marioara));

                // Fara yfir i naesta ramma.
                intentusPlayFolklore.putExtras(bundle);
                startActivity(intentusPlayFolklore);

                // Loka upphafs-rammann.
                Bless.killApp(true);
                //
            } // public void onClick(View v)
        }); // next.setOnClickListener(new View.OnClickListener()

        music003.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                music003.setHovered(false);

                bundle.putInt("select_picture",R.drawable.icon_sahydursun_garajayewa_sings_salamymny_);
                bundle.putString("select_web_side","https://hah.life/video/ylJCWcXK2jZA/-/Sahydursun%20garaja%C3%BDewa%20-%20Salamymny");
                bundle.putString("select_title",getString(R.string.sahydursun_sings_salamymny));

                // Fara yfir i naesta ramma.
                intentusPlayFolklore.putExtras(bundle);
                startActivity(intentusPlayFolklore);

                // Loka upphafs-rammann.
                Bless.killApp(true);
                //
            } // public void onClick(View v)
        }); // next.setOnClickListener(new View.OnClickListener()

        music004.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                music004.setHovered(false);

                bundle.putInt("select_picture",R.drawable.icon_sahydursun_garajayewa_sings_salamymny_);
                bundle.putString("select_web_side","https://hah.life/video/ylJCWcXK2jZA/-/Sahydursun%20garaja%C3%BDewa%20-%20Salamymny");
                bundle.putString("select_title",getString(R.string.sahydursun_sings_salamymny));

                // Fara yfir i naesta ramma.
                intentusPlayFolklore.putExtras(bundle);
                startActivity(intentusPlayFolklore);

                // Loka upphafs-rammann.
                Bless.killApp(true);
                //
            } // public void onClick(View v)
        }); // next.setOnClickListener(new View.OnClickListener()

        music005.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                music005.setHovered(false);

                bundle.putInt("select_picture",R.drawable.icon_sahydursun_garajayewa_sings_salamymny_);
                bundle.putString("select_web_side","https://hah.life/video/ylJCWcXK2jZA/-/Sahydursun%20garaja%C3%BDewa%20-%20Salamymny");
                bundle.putString("select_title",getString(R.string.sahydursun_sings_salamymny));

                // Fara yfir i naesta ramma.
                intentusPlayFolklore.putExtras(bundle);
                startActivity(intentusPlayFolklore);

                // Loka upphafs-rammanum.
                Bless.killApp(true);
                //
            } // public void onClick(View v)
        }); // next.setOnClickListener(new View.OnClickListener()



        // imageViewAccordion

        // FARA TILBAKA TIL GENRE (MYND AF VINSTRI OER).
        tilbaka.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                tilbaka.setHovered(false);

                // Fara yfir i naesta ramma (GenreActivity.java).
                startActivity(intentusGenre);

                // Loka upphafs-rammann.
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
        //
        //
    } // void onCreate(Bundle savedInstanceState)
    //
} // public class WorldmusicActivity  extends SameiginlegtActivity
//.
