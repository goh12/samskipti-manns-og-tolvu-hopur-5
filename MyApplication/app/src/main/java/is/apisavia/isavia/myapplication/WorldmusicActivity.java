package is.apisavia.isavia.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.HeaderViewListAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

import exceptions.EkkertSkjalFinnstException;

//                                       SameiginlegtActivity.java er klasa yfir oellum hinum
//                                       kloesunum, sja SameiginlegtActivity.java.
public class WorldmusicActivity  extends SameiginlegtActivity {

    private static final String ListElements = null;
    // SKILGREININGAR
    protected LinearLayout rammi;

    protected ImageView music001;
    protected ImageView music002;
    protected ImageView music003;
    protected ImageView music004;
    protected ImageView music005;

    protected ImageView musicFavorite001;
    protected ImageView musicFavorite002;
    protected ImageView musicFavorite003;
    protected ImageView musicFavorite004;
    protected ImageView musicFavorite005;

    protected ImageButton escape;
    protected ImageButton home;
    protected ImageButton tilbaka;

    protected ImageButton addButton;

    protected ImageButton favorite01;
    protected ImageButton favorite02;
    protected ImageButton favorite03;
    protected ImageButton favorite04;
    protected ImageButton favorite05;

    protected TextView titillLagsins01;
    protected TextView titillLagsins02;
    protected TextView titillLagsins03;
    protected TextView titillLagsins04;
    protected TextView titillLagsins05;

    protected TextView titillLagsinsFavorite01;
    protected TextView titillLagsinsFavorite02;
    protected TextView titillLagsinsFavorite03;
    protected TextView titillLagsinsFavorite04;
    protected TextView titillLagsinsFavorite05;

    protected TextView setjaTitillFavorite;

    //LIST OF ARRAY STRINGS WHICH WILL SERVE AS LIST ITEMS
    protected ArrayList<String> listItems = new ArrayList<String>();

    //DEFINING A STRING ADAPTER WHICH WILL HANDLE THE DATA OF THE LISTVIEW
    protected ArrayAdapter<String> adapter;

    //RECORDING HOW MANY TIMES THE BUTTON HAS BEEN CLICKED
    protected int clickCounter;
    protected ListView myListView;


    // EFTIR AD VINNA THETTA VERK MED LIST-VIEW
    // protected ListView myListView; // (ListView)findViewById(R.id.list_view);
    // protected ListView listView;
    // protected ArrayList<String> listi;
    // protected ArrayList<ImageView> myndalisti;
    // protected ArrayAdapter<String> haldaUtanUmListan;
    // protected ArrayAdapter<ImageView> myndalistiUtanumHald;

    protected Context context;

    protected Bundle bundle;
    protected Intent intent;

    //// protected ArrayAdapter<String> adapter;
    protected String favorites = "00000";

    protected char favoriteNum01;
    protected char favoriteNum02;
    protected char favoriteNum03;
    protected char favoriteNum04;
    protected char favoriteNum05;

    protected char isNotFavorite;
    protected char isYesFavorite;

    protected boolean isFavorite01;
    protected boolean isFavorite02;
    protected boolean isFavorite03;
    protected boolean isFavorite04;
    protected boolean isFavorite05;

    /**
     * Klasasmidur.
     */
    public WorldmusicActivity()
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

        favorite01 = null;
        favorite02 = null;
        favorite03 = null;
        favorite04 = null;
        favorite05 = null;

        isFavorite01 = false;
        isFavorite02 = false;
        isFavorite03 = false;
        isFavorite04 = false;
        isFavorite05 = false;

        favoriteNum01 = '0';
        favoriteNum02 = '0';
        favoriteNum03 = '0';
        favoriteNum04 = '0';
        favoriteNum05 = '0';

        isNotFavorite = '0';
        isYesFavorite = '1';
        setjaTitillFavorite = null;
        myListView = null;
        clickCounter = 0;
        addButton = null;
        musicFavorite001 = null;
        musicFavorite002 = null;
        musicFavorite003 = null;
        musicFavorite004 = null;
        musicFavorite005 = null;
    } // public WorldmusicActivity ()
    //

    // SKILGREININGAR FYRIRKOMULAG
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worldmusic);

        context = this;
        rammi = new LinearLayout(context);

        bundle = new Bundle();
        intent = new Intent(getApplicationContext(), PlayWorldmusicActivity.class);
/*
        myListView = new ListView(context);

        myListView.findViewById(R.id.imageButtonFavorite);

        // if (myListView == null) {
        //     myListView = findViewById(R.id.list);
        // }

        adapter = new ArrayAdapter<String>(this,
                      android.R.layout.simple_list_item_1,
                      listItems);
*/


/*

        // myListView = findViewById(R.id.imageViewMusic003);
        addButton = (ImageButton) findViewById(R.id.imageButtonFavorite);
        // GetValue = (EditText) findViewById(R.id.editText1);

        final List< String > ListElementsArrayList = new ArrayList < String >
                (Arrays.asList(ListElements));


        final ArrayAdapter < String > adapter = new ArrayAdapter < String >
                (context, android.R.layout.simple_list_item_1,
                        ListElementsArrayList);

        myListView.setAdapter(adapter);
*/




        // EINFOELD BRADA-BIRGDAR OG TAK-MOERKUD LEID TIL THESS AD GEYMA "FAVORITES".
        // THESSI LEID GEYMA ALLT UPP AD 5 "FAVORITES" MIDID VID NUVERANDI UPPSETNINGU.
        // AESKILEGRA VAERI AD NOTAST VID T.D. SQLite MED O-TILGREINDUM FJOELDA LAGA,
        // EN TIMANS VEGNA VERDUR THESSI LEID AD DUGA I BILI.
        try
        {
            // Sjalfgefid er "enginn likar vid": (sjalfgefid i fyrstu ER JAFNT OG = "00000").
            favorites = lesaSkjal("favorites");
        }
        catch (IOException e)
        {
            // Sjalfgefid er "enginn likar vid" ER JAFNT OG = "00000".
            favorites = "00000";
        }
        catch (EkkertSkjalFinnstException e)
        {
            // Sjalfgefid er "enginn likar vid" ER JAFNT OG = "00000".
            favorites = "00000";
        }
        catch (Exception ee)
        {
            // Sjalfgefid er "enginn likar vid" ER JAFNT OG = "00000".
            favorites = "00000";
        } // try catch
        //
        favoriteNum01 = favorites.charAt(0); // LIKAR VID = FAVORITE "YES" = '1' ANNARS = '0'.
        favoriteNum02 = favorites.charAt(1);
        favoriteNum03 = favorites.charAt(2);
        favoriteNum04 = favorites.charAt(3);
        favoriteNum05 = favorites.charAt(4);

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

        musicFavorite001 = findViewById(R.id.imageViewMusicFavorite01);
        musicFavorite002 = findViewById(R.id.imageViewMusicFavorite02);
        musicFavorite003 = findViewById(R.id.imageViewMusicFavorite03);
        musicFavorite004 = findViewById(R.id.imageViewMusicFavorite04);
        musicFavorite005 = findViewById(R.id.imageViewMusicFavorite05);

        escape = findViewById(R.id.imageButtonEscape);
        home =  findViewById(R.id.imageButtonHome);
        tilbaka = findViewById(R.id.imageButtonLeftArrow);

        favorite01 = findViewById(R.id.imageButtonFavorite01);
        favorite02 = findViewById(R.id.imageButtonFavorite02);
        favorite03 = findViewById(R.id.imageButtonFavorite03);
        favorite04 = findViewById(R.id.imageButtonFavorite04);
        favorite05 = findViewById(R.id.imageButtonFavorite05);

        // listView = new ListView(context);
        // listView.findViewById(R.id.list);
        // listView.setBackground(R.drawable.favorite_kiss_emoji_png_transparent_icon_2);
        // listView.setClickable(true);


        if(lodrettur == hvernigSnuaSnjallsiminn()) {
            rammi.setBackgroundResource(R.drawable.texture_pattern_design_4_portrait);
        } else {
            rammi.setBackgroundResource(R.drawable.texture_pattern_design_4_landscape);
        } // if else

        titillLagsins01 = findViewById(R.id.textViewMusic001);
        titillLagsins02 = findViewById(R.id.textViewMusic002);
        titillLagsins03 = findViewById(R.id.textViewMusic003);
        titillLagsins04 = findViewById(R.id.textViewMusic004);
        titillLagsins05 = findViewById(R.id.textViewMusic005);

        // GEYMA EF TIMI VINNST TIL AD SNYRTA OG SETJA TEXTANN I BEINA LINU VID MYNDINA
        titillLagsinsFavorite01 = findViewById(R.id.textViewMusicFavorite01);
        titillLagsinsFavorite02 = findViewById(R.id.textViewMusicFavorite02);
        titillLagsinsFavorite03 = findViewById(R.id.textViewMusicFavorite03);
        titillLagsinsFavorite04 = findViewById(R.id.textViewMusicFavorite04);
        titillLagsinsFavorite05 = findViewById(R.id.textViewMusicFavorite05);

        music001.setImageResource(R.drawable.icon_balam_pichkari);
        music002.setImageResource(R.drawable.icon_andra_mai_tii_minte_draga_marie_marie_si_marioara_);
        music003.setImageResource(R.drawable.icon_sahydursun_garajayewa_sings_salamymny_);
        // A EFTIR AD FAETA VID TVO LOG I VIDBOT:
        music004.setImageResource(R.drawable.icon_sahydursun_garajayewa_sings_salamymny_);
        music005.setImageResource(R.drawable.icon_sahydursun_garajayewa_sings_salamymny_);

        titillLagsins01.setText(getString(R.string.vishal_dadlani_and_shalmali_kholgade_sing_balam_pickari));
        titillLagsins02.setText(getString(R.string.mai_tii_minte_drage_marie_cu_marie_si_marioara));
        titillLagsins03.setText(getString(R.string.sahydursun_sings_salamymny));
        // A EFTIR AD FAETA VID TVO LOG I VIDBOT:
        titillLagsins04.setText(getString(R.string.sahydursun_sings_salamymny));
        titillLagsins05.setText(getString(R.string.sahydursun_sings_salamymny));

        //// listi = new ArrayList<String>();

        music001.setHovered(true);
        music002.setHovered(true);
        music003.setHovered(true);
        music004.setHovered(true);
        music005.setHovered(true);

        escape.setHovered(true);
        home.setHovered(true);
        tilbaka.setHovered(true);

        // try og catch utan um
        //// adapter = new ArrayAdapter<String>(this, R.layout.activity_favorite);
        //// myListView.setAdapter(adapter);

        // Lesa af skjalinu: 0 = "EKKI FAVORITE" eda 1 = "FAVORITE".
        if(favoriteNum01 == '0') {
            isFavorite01 = false;
        } else {
            isFavorite01 = true;
        } // if(favoriteNum01 == '0')

        if(isFavorite01) {
            favorite01.setColorFilter(0xaa00ff00);
            music001.setColorFilter(0xaa00ff00);

            // Setja texta og hjarta nedst i rammanum.
            musicFavorite001.setImageResource(R.drawable.illustration_of_a_red_heart_pv_62x_46y);
            titillLagsinsFavorite01.setText(getString(R.string.vishal_dadlani_and_shalmali_kholgade_sing_balam_pickari));

        } else {
            favorite01.clearColorFilter();
            music001.clearColorFilter();

            // Taka burt texta og hjarta nedst i rammanum.
            musicFavorite001.setImageDrawable(null);
            titillLagsinsFavorite01.setText(null);

        } // if(isColored.equals("0xaa00ff00"))

        // Lesa af skjalinu: '0' = "EKKI FAVORITE" eda '0' = "FAVORITE", sem fyrr segir.
        if(favoriteNum02 == '0') {
            isFavorite02 = false;
        } else {
            isFavorite02 = true;
        } // if(favoriteNum02 == '0') else . . . . .

        if(isFavorite02) {
            favorite02.setColorFilter(0xaa00ff00);
            music002.setColorFilter(0xaa00ff00);

            // Setja texta og hjarta nedst i rammanum.
            musicFavorite002.setImageResource(R.drawable.illustration_of_a_red_heart_pv_62x_46y);
            titillLagsinsFavorite02.setText(getString(R.string.mai_tii_minte_drage_marie_cu_marie_si_marioara));

        } else {
            favorite02.clearColorFilter();
            music002.clearColorFilter();

            // Taka burt texta og hjarta nedst i rammanum.
            musicFavorite002.setImageDrawable(null);
            titillLagsinsFavorite02.setText(null);

        } // if(isColored.equals("0xaa00ff00")) else . . . . .

        // Lesa af skjalinu: 0 = "EKKI FAVORITE" eda 1 = "FAVORITE".
        if(favoriteNum03 == '0') {
            isFavorite03 = false;
        } else {
            isFavorite03 = true;
        } // if(favoriteNum01 == '0') else . . . . .

        if(isFavorite03) {
            favorite03.setColorFilter(0xaa00ff00);
            music003.setColorFilter(0xaa00ff00);

            // Setja texta og hjarta nedst i rammanum.
            musicFavorite003.setImageResource(R.drawable.illustration_of_a_red_heart_pv_62x_46y);
            titillLagsinsFavorite03.setText(getString(R.string.sahydursun_sings_salamymny));

        } else {
            favorite03.clearColorFilter();
            music003.clearColorFilter();

            // Taka burt texta og hjarta nedst i rammanum.
            musicFavorite003.setImageDrawable(null);
            titillLagsinsFavorite03.setText(null);

        } // if(isColored.equals("0xaa00ff00")) else . . . . .

        // Lesa af skjalinu: 0 = "EKKI FAVORITE" eda 1 = "FAVORITE".
        if(favoriteNum04 == '0') {
            isFavorite04 = false;
        } else {
            isFavorite04 = true;
        } // if(favoriteNum01 == '0') else . . . . .

        if(isFavorite04) {
            favorite04.setColorFilter(0xaa00ff00);
            music004.setColorFilter(0xaa00ff00);

            // Setja texta og hjarta nedst i rammanum.
            musicFavorite004.setImageResource(R.drawable.illustration_of_a_red_heart_pv_62x_46y);
            titillLagsinsFavorite04.setText(getString(R.string.sahydursun_sings_salamymny));

        } else {
            favorite04.clearColorFilter();
            music004.clearColorFilter();

            // Taka burt texta og hjarta nedst i rammanum.
            musicFavorite004.setImageDrawable(null);
            titillLagsinsFavorite04.setText(null);

        } // if(isColored.equals("0xaa00ff00")) else . . . . .

        // Lesa af skjalinu: 0 = "EKKI FAVORITE" eda 1 = "FAVORITE".
        if(favoriteNum05 == '0') {
            isFavorite05 = false;
        } else {
            isFavorite05 = true;
        } // if(favoriteNum05 == '0') else . . . . .

        if(isFavorite05) {
            favorite05.setColorFilter(0xaa00ff00);
            music005.setColorFilter(0xaa00ff00);

            // Setja texta og hjarta nedst i rammanum.
            musicFavorite005.setImageResource(R.drawable.illustration_of_a_red_heart_pv_62x_46y);
            titillLagsinsFavorite05.setText(getString(R.string.sahydursun_sings_salamymny));

        } else {
            favorite05.clearColorFilter();
            music005.clearColorFilter();

            // Taka burt texta og hjarta nedst i rammanum.
            musicFavorite005.setImageDrawable(null);
            titillLagsinsFavorite05.setText(null);

        } // if(isColored.equals("0xaa00ff00")) else . . . . .



        music001.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                music001.setHovered(false);

                // Boeglarinn (enska: bundle) flytur upplysingar yfir i naesta klasa, sem heitir:
                // "PlayWorldmusicActivity.java. Upplysingarnir eru 4 talsins, sem er fluttar yfir.
                bundle.putBoolean("is_favorite",isFavorite01);
                bundle.putInt("select_picture",R.drawable.icon_balam_pichkari);
                bundle.putString("select_web_side","http://www.youtube.com/watch?v=Hxy8BZGQ5Jo");
                bundle.putString("select_title",getString(R.string.vishal_dadlani_and_shalmali_kholgade_sing_balam_pickari));

                // GEYMT TIL THAEGINDIS THEGAR KODAN ER AFRITUD OG ADLAGAD I THJODLAGA-HLUTANUM.
                // bundle.putBoolean("is_favorite",isFavorite01);
                // bundle.putInt("select_picture",R.drawable.icon_dimitru_dobrican_si_dantausi_din_grosi_2011);
                // bundle.putString("select_web_side","https://www.youtube.com/watch?v=LUeYoGGluH4");
                // bundle.putString("select_title",getString(R.string.dumitru_dobrican_si_dantausi_din_grosi));

                // Fara yfir i naesta ramma.
                intentusPlayWorldmusic.putExtras(bundle);
                startActivity(intentusPlayWorldmusic);

                // Loka upphafs-rammann.
                Bless.killApp(true);
                //
            } // public void onClick(View v)
        }); // next.setOnClickListener(new View.OnClickListener()

        favorite01.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                favorite01.setHovered(false);

                // Setja tonlistar-lagid EKKI "Favorite" ef thad var adur Favorite.
                if(isFavorite01) {
                    favorite01.clearColorFilter(); // TAKA GRAENA SLAEDUNA NIDUR AF HJARTANU.
                    music001.clearColorFilter(); // TAKA GRAENA SLAEDUNA NIDUR AF MYNDINNI.

                    // EINFOELD BRADA-BIRGDAR OG TAK-MOERKUD LEID TIL THESS AD GEYMA "FAVORITES".
                    // THESSI LEID GEYMA ALLT UPP AD 5 "FAVORITES" MIDID VID NUVERANDI UPPSETNINGU.
                    // AESKILEGRA VAERI AD NOTAST VID T.D. SQLite MED O-TILGREINDUM FJOELDA LAGA,
                    // EN TIMANS VEGNA VERDUR THESSI LEID AD DUGA I BILI.

                    favorites = isNotFavorite + // LAG NR 1 TEKID AF UPP-A-HALDS-LISTANN "FAVORITE".
                            Character.toString(favorites.charAt(1)) +
                            Character.toString(favorites.charAt(2)) +
                            Character.toString(favorites.charAt(3)) +
                            Character.toString(favorites.charAt(4));
                    isFavorite01 = false;

                    // Taka burt texta og hjarta nedst i rammanum.
                    musicFavorite001.setImageDrawable(null);
                    titillLagsinsFavorite01.setText(null);

                    skrifaSkjal("favorites", favorites);
                    //
                  //
                // Setja tonlistar-lagid "FAVORITE" ef tha var ADUR EKKI "FAVORITE"
                } else {
                    favorite01.setColorFilter(0xaa00ff00); // SETJA GRAENA SLAEDU YFIR HJARTAD.
                    music001.setColorFilter(0xaa00ff00); // SETJA GRAENA SLAEDU YFIR MYNDINA.
                    favorites = isYesFavorite + // LAG NR. 1 SETT A UPP-A-HALDS-LISTANN "FAVORITE".
                            Character.toString(favorites.charAt(1)) + // HIN LOEGIN ERU ANNAD HVORT
                            Character.toString(favorites.charAt(2)) + // "FAVORITE" EDA EKKI SAM-
                            Character.toString(favorites.charAt(3)) + // KVAEMT VISTUD GOEGN AF
                            Character.toString(favorites.charAt(4)); // EFTIRFARANDI SKJALI:
                    isFavorite01 = true;                             // "skrifaSkjal("favorites,...

                    // Setja texta og hjarta nedst i rammanum.
                    musicFavorite001.setImageResource(R.drawable.illustration_of_a_red_heart_pv_62x_46y);
                    titillLagsinsFavorite01.setText(getString(R.string.vishal_dadlani_and_shalmali_kholgade_sing_balam_pickari));

                    skrifaSkjal("favorites", favorites);

                    // ***** KENNILEITI ***** //
                    //
                } // if(isColored.equals("0xaa00ff00"))
                //
            } // public void onClick(View v)
        }); // next.setOnClickListener(new View.OnClickListener()

        music002.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                music002.setHovered(false);

                bundle.putBoolean("is_favorite",isFavorite02);
                bundle.putInt("select_picture",R.drawable.icon_andra_mai_tii_minte_draga_marie_marie_si_marioara_);
                bundle.putString("select_web_side","https://www.youtube.com/watch?v=amYYTJ0tAfk");
                bundle.putString("select_title",getString(R.string.mai_tii_minte_drage_marie_cu_marie_si_marioara));

                // Fara yfir i naesta ramma.
                intentusPlayWorldmusic.putExtras(bundle);
                startActivity(intentusPlayWorldmusic);

                // Loka upphafs-rammann.
                Bless.killApp(true);
                //
            } // public void onClick(View v)
        }); // next.setOnClickListener(new View.OnClickListener()

        favorite02.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                favorite02.setHovered(false);

                if(isFavorite02) {
                    favorite02.clearColorFilter();
                    music002.clearColorFilter();
                    favorites =
                            Character.toString(favorites.charAt(0)) +
                            isNotFavorite +
                            Character.toString(favorites.charAt(2)) +
                            Character.toString(favorites.charAt(3)) +
                            Character.toString(favorites.charAt(4));

                    isFavorite02 = false;

                    // Taka burt texta og hjarta nedst i rammanum.
                    musicFavorite002.setImageDrawable(null);
                    titillLagsinsFavorite02.setText(null);

                    skrifaSkjal("favorites", favorites);
                } else {
                    favorite02.setColorFilter(0xaa00ff00);
                    music002.setColorFilter(0xaa00ff00);
                    favorites =
                            Character.toString(favorites.charAt(0)) +
                            isYesFavorite +
                            Character.toString(favorites.charAt(2)) +
                            Character.toString(favorites.charAt(3)) +
                            Character.toString(favorites.charAt(4));

                    isFavorite02 = true;

                    // Setja texta og hjarta nedst i rammanum.
                    musicFavorite002.setImageResource(R.drawable.illustration_of_a_red_heart_pv_62x_46y);
                    titillLagsinsFavorite02.setText(getString(R.string.mai_tii_minte_drage_marie_cu_marie_si_marioara));

                    skrifaSkjal("favorites", favorites);
                } // if(isColored.equals("0xaa00ff00"))
                //
            } // public void onClick(View v)
        }); // next.setOnClickListener(new View.OnClickListener()

        music003.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                music003.setHovered(false);

                bundle.putBoolean("is_favorite",isFavorite03);
                bundle.putInt("select_picture",R.drawable.icon_sahydursun_garajayewa_sings_salamymny_);
                bundle.putString("select_web_side","https://hah.life/video/ylJCWcXK2jZA/-/Sahydursun%20garaja%C3%BDewa%20-%20Salamymny");
                bundle.putString("select_title",getString(R.string.sahydursun_sings_salamymny));

                // Fara yfir i naesta ramma.
                intentusPlayWorldmusic.putExtras(bundle);
                startActivity(intentusPlayWorldmusic);

                // Loka upphafs-rammann.
                Bless.killApp(true);
                //
            } // public void onClick(View v)
        }); // next.setOnClickListener(new View.OnClickListener()

        favorite03.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                favorite03.setHovered(false);

                if(isFavorite03) {
                    favorite03.clearColorFilter();
                    music003.clearColorFilter();
                    favorites =
                            Character.toString(favorites.charAt(0)) +
                            Character.toString(favorites.charAt(1)) +
                            isNotFavorite +
                            Character.toString(favorites.charAt(3)) +
                            Character.toString(favorites.charAt(4));

                    isFavorite03 = false;

                    // Taka burt texta og hjarta nedst i rammanum.
                    musicFavorite003.setImageDrawable(null);
                    titillLagsinsFavorite03.setText(null);

                    skrifaSkjal("favorites", favorites);
                } else {
                    favorite03.setColorFilter(0xaa00ff00);
                    music003.setColorFilter(0xaa00ff00);
                    favorites =
                            Character.toString(favorites.charAt(0)) +
                            Character.toString(favorites.charAt(1)) +
                            isYesFavorite +
                            Character.toString(favorites.charAt(3)) +
                            Character.toString(favorites.charAt(4));

                    isFavorite03 = true;

                    // Setja texta og hjarta nedst i rammanum.
                    musicFavorite003.setImageResource(R.drawable.illustration_of_a_red_heart_pv_62x_46y);
                    titillLagsinsFavorite03.setText(getString(R.string.sahydursun_sings_salamymny));

                    skrifaSkjal("favorites", favorites);
                } // if(isColored.equals("0xaa00ff00"))
                //
            } // public void onClick(View v)
        }); // next.setOnClickListener(new View.OnClickListener()

        music004.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                music004.setHovered(false);

                bundle.putBoolean("is_favorite",isFavorite04);
                bundle.putInt("select_picture",R.drawable.icon_sahydursun_garajayewa_sings_salamymny_);
                bundle.putString("select_web_side","https://hah.life/video/ylJCWcXK2jZA/-/Sahydursun%20garaja%C3%BDewa%20-%20Salamymny");
                bundle.putString("select_title",getString(R.string.sahydursun_sings_salamymny));

                // Fara yfir i naesta ramma.
                intentusPlayWorldmusic.putExtras(bundle);
                startActivity(intentusPlayWorldmusic);

                // Loka upphafs-rammann.
                Bless.killApp(true);
                //
            } // public void onClick(View v)
        }); // next.setOnClickListener(new View.OnClickListener()

        favorite04.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                favorite04.setHovered(false);

                if(isFavorite04) {
                    favorite04.clearColorFilter();
                    music004.clearColorFilter();
                    favorites =
                            Character.toString(favorites.charAt(0)) +
                            Character.toString(favorites.charAt(1)) +
                            Character.toString(favorites.charAt(2)) +
                            isNotFavorite +
                            Character.toString(favorites.charAt(4));

                    isFavorite04 = false;

                    // Taka burt texta og hjarta nedst i rammanum.
                    musicFavorite004.setImageDrawable(null);
                    titillLagsinsFavorite04.setText(null);

                    skrifaSkjal("favorites", favorites);
                } else {
                    favorite04.setColorFilter(0xaa00ff00);
                    music004.setColorFilter(0xaa00ff00);
                    favorites =
                            Character.toString(favorites.charAt(0)) +
                            Character.toString(favorites.charAt(1)) +
                            Character.toString(favorites.charAt(2)) +
                            isYesFavorite +
                            Character.toString(favorites.charAt(4));

                    isFavorite04 = true;

                    // Setja texta og hjarta nedst i rammanum.
                    musicFavorite004.setImageResource(R.drawable.illustration_of_a_red_heart_pv_62x_46y);
                    titillLagsinsFavorite04.setText(getString(R.string.sahydursun_sings_salamymny));

                    skrifaSkjal("favorites", favorites);
                } // if(isColored.equals("0xaa00ff00"))
                //
            } // public void onClick(View v)
        }); // next.setOnClickListener(new View.OnClickListener()

        music005.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                music005.setHovered(false);

                bundle.putBoolean("is_favorite",isFavorite05);
                bundle.putInt("select_picture",R.drawable.icon_sahydursun_garajayewa_sings_salamymny_);
                bundle.putString("select_web_side","https://hah.life/video/ylJCWcXK2jZA/-/Sahydursun%20garaja%C3%BDewa%20-%20Salamymny");
                bundle.putString("select_title",getString(R.string.sahydursun_sings_salamymny));

                // Fara yfir i naesta ramma.
                intentusPlayWorldmusic.putExtras(bundle);
                startActivity(intentusPlayWorldmusic);

                // Loka upphafs-rammanum.
                Bless.killApp(true);
                //
            } // public void onClick(View v)
        }); // next.setOnClickListener(new View.OnClickListener()

        favorite05.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                favorite05.setHovered(false);

                if(isFavorite05) {
                    favorite05.clearColorFilter();
                    music005.clearColorFilter();
                    favorites =
                            Character.toString(favorites.charAt(0)) +
                            Character.toString(favorites.charAt(1)) +
                            Character.toString(favorites.charAt(2)) +
                            Character.toString(favorites.charAt(3)) +
                            isNotFavorite;

                    isFavorite05 = false;

                    // Taka burt texta og hjarta nedst i rammanum.
                    musicFavorite005.setImageDrawable(null);
                    titillLagsinsFavorite05.setText(null);

                    skrifaSkjal("favorites", favorites);
                } else {
                    favorite05.setColorFilter(0xaa00ff00);
                    music005.setColorFilter(0xaa00ff00);
                    favorites =
                            Character.toString(favorites.charAt(0)) +
                            Character.toString(favorites.charAt(1)) +
                            Character.toString(favorites.charAt(2)) +
                            Character.toString(favorites.charAt(3)) +
                            isYesFavorite;

                    isFavorite05 = true;

                    // Setja texta og hjarta nedst i rammanum.
                    musicFavorite005.setImageResource(R.drawable.illustration_of_a_red_heart_pv_62x_46y);
                    titillLagsinsFavorite05.setText(getString(R.string.sahydursun_sings_salamymny));

                    skrifaSkjal("favorites", favorites);
                } // if(isColored.equals("0xaa00ff00"))
                //
            } // public void onClick(View v)
        }); // next.setOnClickListener(new View.OnClickListener()

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









    //METHOD WHICH WILL HANDLE DYNAMIC INSERTION
    public void addItems(View v) {
        listItems.add("Clicked : "+clickCounter++);
        adapter.notifyDataSetChanged();
    }

    protected ListView getListView() {
        if (myListView == null) {
            myListView.findViewById(R.id.imageButtonFavorite);
        }
        return myListView;
    }

    protected void setListAdapter(ListAdapter adapter) {
        getListView().setAdapter(adapter);
    }

    protected ListAdapter getListAdapter() {
        ListAdapter adapter = getListView().getAdapter();
        if (adapter instanceof HeaderViewListAdapter) {
            return ((HeaderViewListAdapter)adapter).getWrappedAdapter();
        } else {
            return adapter;
        }
    }



    //
} // public class WorldmusicActivity  extends SameiginlegtActivity
//.
