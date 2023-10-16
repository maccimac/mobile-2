package com.example.optionsmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String str = "";
        switch(item.getItemId()){
            case R.id.menu_settings:
                str = "Settings";
                break;
            case R.id.one:
                str = "One";
                break;
            case R.id.two:
                str = "Two";
                break;
            case R.id.search:
                str = "Search";
                break;
            case R.id.discard:
                str = "Discard";
                break;
            case R.id.ActivityOne:
                startActivity(new Intent(
                        this,
                        Activity1.class
                ));
                break;
            case R.id.ActivityTwo:
                startActivity(new Intent(
                        this,
                        Activity2.class
                ));
                break;
            default:
        }

        if(str != ""){
            textView.setText(str + " was selected");
            Toast.makeText(this, str, Toast.LENGTH_LONG).show();
        }




        return true;
    }
}