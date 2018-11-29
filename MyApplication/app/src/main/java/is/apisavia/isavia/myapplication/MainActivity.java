package is.apisavia.isavia.myapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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

public class MainActivity extends AppCompatActivity {
    // SKILGREININGAR
    protected ImageView start = null;
    protected EditText etUsername;
    protected EditText etPassword;
    protected ImageButton escape = null;

    protected Context context = null;

    private ImageButton register;
    private ImageButton signIn;


    public MainActivity()
    {
        // Klasa-smidur
    } // public RegisterActivity ()
    //
    // UPPSETNINGA FYRIRKOMULAG
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        final EditText etUsername = (EditText) findViewById(R.id.editTextEmail);
        final EditText etPassword = (EditText) findViewById(R.id.editTextPassword);

        register = findViewById(R.id.imageButtonRegister);
        signIn = findViewById(R.id.imageButtonSignIn);


        // on click listener til að opna register ham
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegister();
            }
        });

        // on click listener til að skrá sig inn
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username = etUsername.getText().toString();
                final String password = etPassword.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            Log.d("json", response);
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success) {

                                String name = jsonResponse.getString("name");

                                Intent intent = new Intent(MainActivity.this, HotActivity.class);
                                intent.putExtra("name",name); // til að senda nafn til genre

                                MainActivity.this.startActivity(intent);

                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                builder.setMessage("Login failed")
                                        .setNegativeButton("Retry",null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                LoginRequest loginRequest = new LoginRequest(username, password, responseListener);
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                queue.add(loginRequest);
            }
        });

    } // void onCreate(Bundle savedInstanceState)

    //fall til að opna register view
    public void openRegister() {
        Intent intent = new Intent(context, RegisterActivity.class);
        startActivity(intent);
    }

    //
} // public class MainActivity
//.
