package com.example.classwork10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static RecyclerView recyclerView;
    public static RecyclerView.LayoutManager layoutManager;
    public static RecyclerView.Adapter adapter;


    private RequestQueue requestQueue;
    static ArrayList<Movie> movieList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        requestQueue = VolleySingleton.getInstance(this).getRequestQueue();
        movieList = new ArrayList<>();
        fetchMovies();

    }

    private void fetchMovies() {
        String url = "https://api.themoviedb.org/3/movie/popular?api_key=f216aa28291dcb2195fd3473f9515674&language=en-US&page=1";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, response -> {
//                    @Override
//                    public void onResponse(JSONObject response) {

                        try{
                            JSONArray jsonArray = response.getJSONArray("results");
                            for (int i = 0; i < jsonArray.length() ; i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String title = jsonObject.getString("title");
                                String overview = jsonObject.getString("overview");
                                double rating = jsonObject.getDouble("vote_average");
                                String imgUrl = "https://image.tmdb.org/t/p/w300" + jsonObject.getString("poster_path");

                                Movie movie = new Movie(title, imgUrl, rating, overview);
                                movieList.add(movie);
                            }
                        }catch (JSONException e){
                            e.printStackTrace();
                        }

                        RecyclerAdapter adapter = new RecyclerAdapter(MainActivity.this, movieList);
                        recyclerView.setAdapter(adapter);
//                    }

                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error
                        Log.d( "error", "yoyo");
                        Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
                requestQueue.add(jsonObjectRequest);
    }


}