package is.apisavia.isavia.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.IOException;

import exceptions.EkkertSkjalFinnstException;

import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT;
import static is.apisavia.isavia.myapplication.R.id.editTextUsername;
import static is.apisavia.isavia.myapplication.R.id.imageViewStart;

public class RegisterActivity extends SameiginlegtActivity {

    // SKILGREININGAR
    protected ImageView   start;
    protected EditText username;
    protected EditText password;
    protected ImageButton escape;
    protected ImageButton next;

    protected Context context;

    /**
     * Klasasmidur.
     */
    public RegisterActivity()
    {
        // Klasa-smidur
        start = null;
        username = null;
        password = null;
        escape = null;
        next = null;
        context = null;
    } // public RegisterActivity ()
    //

    // UPPSETNINGA FYRIRKOMULAG
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        context = this;

        // Skjarinn verdur ad vera upprett thad kemur best ut annad veldur flaekju i thessu tilfelli
        setRequestedOrientation(SCREEN_ORIENTATION_SENSOR_PORTRAIT);

        // intentusGenre = new Intent(getApplicationContext(), GenreActivity.class);
        intentusRegister = new Intent(context, RegisterActivity.class);
        intentusMain = new Intent(context, MainActivity.class);

        try
        {
            // Upplysingar um inn-skraning (sjalfgefid i fyrstu = "no").
            registering = lesaSkjal("register");
        }
        catch (IOException e)
        {
            // Sjalfgefid er enska.
            registering   = "no";
        }
        catch (EkkertSkjalFinnstException e)
        {
            // Sjalfgefid er enska.
            registering   = "no";
        }
        catch (Exception ee)
        {
            // Sjalfgefid er enska.
            registering   = "no";
        }
        //
        if(registering.equalsIgnoreCase("yes")) {
            startActivity(intentusMain);
            // Loka upphafs-rammann.
            Bless.killApp(true);
            //
        } // if(registering.equalsIgnoreCase("yes"))

        // BYRJA AD TENGJA HLUSTUN VID ALLT SEM HAEGT ER AD SMELLA A.
        start = findViewById(imageViewStart);
        username = findViewById(editTextUsername);
        password = findViewById(R.id.editTextPassword);
        escape = findViewById(R.id.imageButtonEscape);
        next = findViewById(R.id.imageButtonRightArrow);

        // UPPHAFS-STILLA OELLU SMELLI-FYRIRKOMULAGID(SETJA INN UPPHAFS-UTLIT ADUR EN SMELLT ER).
        start.setImageResource(R.drawable.ftmjcxxxuvhwvpbaqmsi_kurteisi);
        escape.setHovered(true);
        next.setHovered(true);

        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                next.setHovered(false);

                skrifaSkjal("register", "yes");

                // Fara yfir i naesta ramma (GenreActivity.java).
                // startActivityForResult(intentusGenre, 0);
                startActivity(intentusMain);

                // Loka upphafs-rammann.
                Bless.killApp(true);
                //
            } // public void onClick(View v)
        }); // next.setOnClickListener(new View.OnClickListener()

        escape.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                skrifaSkjal("register", "not yet");
                Bless.killApp(true);
                //
            } // public void onClick(View v)
        }); // escape.setOnClickListener(new View.OnClickListener()

        // tengjaHlustun();
/*
        start.setOnTouchListener((View.OnTouchListener) context);
        username.setOnTouchListener((View.OnTouchListener) context);
        password.setOnTouchListener((View.OnTouchListener) context);
        escape.setOnTouchListener((View.OnTouchListener) context);
        next.setOnTouchListener((View.OnTouchListener) context);
*/


        /*
        View.OnTouchListener clickListener = new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                Toast.makeText(context, "GO TO GENRE!", Toast.LENGTH_LONG).show();
                next.setHovered(false);

                // Fara yfir i naesta ramma (GenreActivity.java).
                //// startActivityForResult(intentusGenre, 0);

                // Loka upphafs-rammann.
                //// Bless.killApp(true);
                //
                return false;

            }
        };
        start.setOnTouchListener(clickListener);
        */
    } // void onCreate(Bundle savedInstanceState)


    // FRAMKVAEMDAR HLUTINN, SEM SMELLT ER OG KEMUR UT SEM UPP-A-KOMU = "EVENT".



    /*
     * boolean OnTouchListener(View v, MotionEvent event)
     *
     * @param v
     * @param event
     * @return
     */
/*
    public boolean onTouchListener(View v, MotionEvent event) {
        //
        boolean b = false;
        // final Intent intent = new Intent(this, AipVeljaActivity.class);
        //
        //
        //   TAKKINN SMELLUR NIDUR =>
        //
        //
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            if (v == start) {
                start.setBackgroundResource(R.drawable.ftmjcxxxuvhwvpbaqmsi_kurteisi_velja_);
                start.setHovered(true);
            } else if (v == username) {
                username.setTextColor(0xff0000cc); // Blar.
                username.setTextSize(12f);
                username.setHint("@string/username");
                username.setHovered(true);
            } else if (v == password) {
                password.setTextColor(0xff0000cc); // Blar.
                password.setTextSize(12f);
                password.setHint("@string/password");
                password.setHovered(true);
            } //
            else if (v == escape) {
                escape.setHovered(true);
            } else if (v == next) {
                next.setHovered(true);
            } //
            //
            else {
                //
            } // if(v == lesa)
            // if(v == isavia) else
        // if (event.get . . .ACTION_DOWN endar her)
        } else if (event.getAction() == MotionEvent.ACTION_CANCEL) {
            if (v == start) {
                start.setBackgroundResource(R.drawable.ftmjcxxxuvhwvpbaqmsi_kurteisi_velja_);
                start.setHovered(true);
            } else if (v == username) {
                username.setTextColor(0xff0000cc); // Blar.
                username.setTextSize(12f);
                username.setHint("@string/username");
                username.setTextKeepState("@string/username");
                username.setHovered(true);
            } else if (v == password) {
                password.setTextColor(0xff0000cc); // Blar.
                password.setTextSize(12f);
                password.setHint("@string/password");
                password.setHovered(true);
            } //
            else if (v == escape) {
                escape.setHovered(true);
            } else if (v == next) {
                next.setHovered(true);
            } else {
                //
            } // if else
            // if (event.get . . .ACTION_CANCEL )
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            if (v == start) {
                start.setBackgroundResource(R.drawable.ftmjcxxxuvhwvpbaqmsi_kurteisi);
                start.setHovered(false);
            } else if (v == username) {
                username.setTextColor(0xff0000cc); // Blar.
                username.setTextSize(12f);
                username.setHint("@string/username");
                username.setHovered(false);
                // Enginn adgerd sem komin er enn-tha.
            } else if (v == password) {
                password.setTextColor(0xff0000cc); // Blar.
                password.setTextSize(12f);
                password.setHint("@string/password");
                password.setHovered(false);
                // Enginn adgerd sem komin er enn-tha.
            } //
            else if (v == escape) {
                escape.setHovered(false);

                // Haetta i forritinu.
                Bless.killApp(true);
                //
            } else if (v == next) {
                next.setHovered(false);

                // Fara yfir i naesta ramma (GenreActivity.java).
                startActivityForResult(intentusGenre, 0);

                // Loka upphafs-rammann.
                Bless.killApp(true);
                //
            } else {
                //
            } // if else.
            //
        } // else if (event.getAction() == MotionEvent.ACTION_UP)
        //
        return b;
    } // public boolean onTouch(View v, MotionEvent event)
*/
    /*
    public void tengjaHlustun()
    {
        start.setOnTouchListener((View.OnTouchListener) context);
        username.setOnTouchListener((View.OnTouchListener) context);
        password.setOnTouchListener((View.OnTouchListener) context);
        escape.setOnTouchListener((View.OnTouchListener) context);
        next.setOnTouchListener((View.OnTouchListener) context);
        //
    } // tengjaHlustunExcel
    */


} // class RegisterActivity extends AppCompatActivity
