package com.example.roadresolver;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{

    GoogleSignInClient mGoogleSignInClient;
    String name, email;
    EditText etLocation, etComments;
    RequestQueue queue;

    TextView tvDate;
    final String URL = "http://10.20.153.195/road_resolve/api.php";
    //final String URL = "http://192.168.0.159/road_resolve/api.php"; //putera ip test


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        name = sharedPreferences.getString("displayName", "");
        email = sharedPreferences.getString("email", "");

        queue = Volley.newRequestQueue(getApplicationContext());

        //-------------------------------

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_news:
                        Intent newsIntent = new Intent(SecondActivity.this, ThirdActivity.class);
                        startActivity(newsIntent);
                        finish();
                        return true;

                    case R.id.navigation_reports:
                        return true;

                    case R.id.navigation_profile:
                        Intent aboutUsIntent = new Intent(SecondActivity.this,ProfileActivity.class);
                        startActivity(aboutUsIntent);
                        finish();
                        return true;
                }
                return false;
            }
        });
        bottomNavigationView.setSelectedItemId(R.id.navigation_reports);

        //-----------------------------

        etLocation = findViewById(R.id.etLocation);
        etComments = findViewById(R.id.etComments);

        Button button = findViewById(R.id.btnSubmit);

        tvDate = (TextView) findViewById(R.id.tvDate);

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        String displaydate = sdf.format(date);

        tvDate.setText(displaydate);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //volley call
                makeRequest();
            }
        });

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
    }


    public void makeRequest() {

        if (etLocation.getText().toString().isEmpty()) {
            etLocation.setError("Report Name is required");
            etLocation.requestFocus();
            return;
        }

        if (etComments.getText().toString().isEmpty()) {
            etComments.setError("Location is required");
            etComments.requestFocus();
            return;
        }

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), response, Toast.LENGTH_LONG).show();
            }
        }, errorListener) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();

                params.put("name", name);
                params.put("email", email);
                params.put("location", etLocation.getText().toString());
                params.put("comments", etComments.getText().toString());

                return params;
            }
        };
        queue.add(stringRequest);
    }

    public Response.ErrorListener errorListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
        }
    };

    @Override
    public void onClick(View view) {

    }
}
