package com.example.roadresolver;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ThirdActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private static final String ROAD_URL = "http://10.20.153.195/road_resolve/json.php";
    //private static final String ROAD_URL = "http://192.168.0.159/road_resolve/json.php"; //putera ip test

    List<Road> roadList;
    RecyclerView recyclerView;
    RoadAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        roadList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadRoads();
    }

    protected void loadRoads() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, ROAD_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray roads = new JSONArray(response);

                    for (int i = 0; i < roads.length(); i++) {
                        JSONObject roadObject = roads.getJSONObject(i);

                        String title = roadObject.getString("news_title");
                        String desc = roadObject.getString("news_desc");


                        Road road = new Road(title, desc);
                        roadList.add(road);
                    }

                    adapter = new RoadAdapter(ThirdActivity.this, roadList);
                    recyclerView.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ThirdActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        Volley.newRequestQueue(this).add(stringRequest);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_news:
                break;

            case R.id.navigation_reports:
                Intent reportsIntent = new Intent(ThirdActivity.this, SecondActivity.class);
                startActivity(reportsIntent);
                finish();
                break;

            case R.id.navigation_profile:
                Intent aboutUsIntent = new Intent(ThirdActivity.this, ProfileActivity.class);
                startActivity(aboutUsIntent);
                finish();
                break;
        }

        return true;
    }
}
