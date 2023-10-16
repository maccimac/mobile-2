package com.example.classwork10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView poster = findViewById(R.id.poster_img);
        TextView rating = findViewById(R.id.mRating);
        TextView title = findViewById(R.id.mTitle);
        TextView description = findViewById(R.id.mDescription);

        Bundle bundle = getIntent().getExtras();

        title.setText(bundle.getString("title"));
        rating.setText(Double.toString(bundle.getDouble("rating")));
        description.setText(bundle.getString("overview"));
//        title.setText(bundle.getString("title"));

        String mPoster = bundle.getString("poster");
        Picasso.get().load(mPoster).into(poster);
    }
}