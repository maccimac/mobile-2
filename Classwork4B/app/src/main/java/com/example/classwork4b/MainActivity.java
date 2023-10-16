package com.example.classwork4b;

import androidx.appcompat.app.AppCompatActivity;
import com.example.classwork4b.databinding.ActivityMainBinding;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private  ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
//        setContentView(R.layout.activity_main);
        View view = binding.getRoot();
        setContentView(view);
        handleIntent();
    }

    private void handleIntent() {
        Intent intent = getIntent();
        Uri data = intent.getData();

        URL url = null;

        try {
            url = new URL(data.getScheme(), data.getHost(), data.getPath());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        
        binding.webView.loadUrl(url.toString());



    }
}