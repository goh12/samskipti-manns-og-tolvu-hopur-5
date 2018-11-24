package is.apisavia.isavia.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import exceptions.EkkertSkjalFinnstException;

public abstract class SameiginlegtActivity extends AppCompatActivity {

    // Breyta til thess ad fara milli klasa.
    public Intent intentusGenre;
    public Intent intentusRegister;
    public Intent intentusMain;
    public Intent intentusFolklore;
    public Intent intentusWorldmusic;
    public Intent intentusPlayWorldmusic;
    public Intent intentusPlayFolklore;

    public int    lodrettur;
    public int    lagrettur;

    public String registering;
    
    public SameiginlegtActivity()
    {
        // Klasa-smidur;
        intentusRegister = null;
        intentusMain = null;
        intentusGenre = null;
        intentusFolklore = null;
        intentusWorldmusic = null;
        intentusPlayFolklore = null;
        intentusPlayWorldmusic = null;
        lagrettur = Configuration.ORIENTATION_LANDSCAPE;
        lodrettur = Configuration.ORIENTATION_PORTRAIT;
        //
        registering = "no";
    } // Klasa-smidur.
    //

    /**
     * Daemi um notkun:
     * int myndRamminnSnyr = hvernigSnuaSnjallsiminn();
     *
     * @return
     */
    public int hvernigSnuaSnjallsiminn()
    {
        Configuration config = getResources().getConfiguration();
        int ramminnSnyr      = config.orientation;
        //
        return ramminnSnyr;
        //
    } // public int hvernigSnuaSnjallsiminn()
    //




    /**
     * Notkun: lesaSkjal(String nafnSkjals)
     *
     * @param nafnSkjals
     * @return skilabreytu a strengjatagi med innihald skjalsins.
     * @throws IOException
     * @throws EkkertSkjalFinnstException
     */
    protected String lesaSkjal(String nafnSkjals)
            throws IOException, EkkertSkjalFinnstException
    {
        String str = "";
        //
        FileInputStream fIn = openFileInput(nafnSkjals);
		/*
    	   Eingongu til thess ad lesa gogn:
    	   Lesa og skrifa gogn ut a gagnageymslu.
    	 */
        BufferedReader lesari = new BufferedReader(new InputStreamReader(fIn));
        //
        str = lesari.readLine();
        //
        return str;
        //
    } // lesaSkjal ( . . . )
    //




    // -     -     -     -     -     -     -     -     -     -     -     -     -     -     - \\
    /**
     * Notkun (daemi): skrifaSkjal(NAFN_SKJALS, alltSkjalid);
     *
     * Daemi: alltSkjalid = "12"
     * Daemi: NAFN_SKJALS = "NrDalks", sem er geymslu a numer dalks.
     *
     * Tilgangur: Skrifa ut a SD-Korti snjallsimans oell gogn, sem eru
     *            numer dalks, sem vistadar hafa verid um leid og
     *            farsimanum var snuinn.
     *
     * Fyrir: Einn strengur, sem inniheldur numer a strengjatagu.
     *
     * Eftir: Alla upplýsinga, sem er eitt numer a strengjatagi,
     *        sem fyrr segir, eru vistud ut a SK-korti snjallsimans.
     *
     * @param nafnSkjals
     * @param alltSkjalid
     */
    @SuppressLint("WorldReadableFiles")
    protected void skrifaSkjal(String nafnSkjals, String alltSkjalid)
    {
        //
        try
        {
            FileOutputStream skrifaUtSkjal =
                    openFileOutput(nafnSkjals, MODE_PRIVATE);
            OutputStreamWriter skrifaUt = new OutputStreamWriter(skrifaUtSkjal);
			/*
			   Vidfangsbreytan: "alltSkjalid" er allan texta, sem
			   er numer dalks eda audkennis a strengjatagi.

			   Vista numerid, sem fyrr segir
			 */
            skrifaUt.write(alltSkjalid);
            skrifaUt.flush();
            skrifaUt.close();
            //
        } // try
        catch (FileNotFoundException e1)
        {
            Toast.makeText(this, e1.toString(),
                    Toast.LENGTH_LONG).show();
        }
        catch (IOException e)
        {
            Toast.makeText(this, e.toString(),
                    Toast.LENGTH_LONG).show();
        } // try catch catch
        //
    } // skrifaSkjal( . . . )
    //





    //
} // public abstract class SameiginlegtActivity extends AppCompatActivity
//.
