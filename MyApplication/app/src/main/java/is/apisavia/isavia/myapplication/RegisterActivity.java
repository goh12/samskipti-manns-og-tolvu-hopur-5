package is.apisavia.isavia.myapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import exceptions.EkkertSkjalFinnstException;

import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT;
import static is.apisavia.isavia.myapplication.R.id.editTextUsername;

public class RegisterActivity extends SameiginlegtActivity {

    // SKILGREININGAR
    protected ImageView   start;
    protected EditText username;
    protected ImageButton escape;
    protected ImageButton next;

    protected Context context;

    private EditText enteredPassword;
    private EditText enteredConfirmPassword;
    private EditText enteredEmail;
    private EditText enteredUsername;

    private String email;
    private String password;

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

        // upphafsstillum sem admin og 1234 svo hægt sé að sleppa nýskrá sig í hvert skipti
        email = "Admin";
        password = "1234";
    } // public RegisterActivity ()
    //

    // UPPSETNINGA FYRIRKOMULAG
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        next = findViewById(R.id.imageButtonRightArrow);

        // upplýsingar fengnar úr editText römmum
        enteredUsername = (EditText) findViewById(R.id.editTextUsername);
        enteredEmail = (EditText) findViewById(R.id.editTextEmail);
        enteredPassword = (EditText) findViewById(R.id.editTextPassword);
        enteredConfirmPassword = (EditText) findViewById(R.id.editTextPasswordConfig);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = enteredUsername.getText().toString();
                String email = enteredEmail.getText().toString();
                String password = enteredPassword.getText().toString();
                String passwordConfirmed = enteredConfirmPassword.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if (success) {
                                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                                RegisterActivity.this.startActivity(intent);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                builder.setMessage("Register failed")
                                        .setNegativeButton("Retry",null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                if (password.equals(passwordConfirmed)) {
                    RegisterRequest registerRequest = new RegisterRequest(name,email,password,responseListener);
                    RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                    queue.add(registerRequest);
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                    builder.setMessage("Register failed")
                            .setNegativeButton("Retry",null)
                            .create()
                            .show();
                }


            }
        });

    }

} // class RegisterActivity extends AppCompatActivity
