package com.example.finalspractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class FirstActivity extends AppCompatActivity {

    ArrayList<String> myArrayList = new ArrayList<String>();
    ArrayAdapter<String> myLVAdapter;
    ListView myListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        myListView = findViewById(R.id.myListView1);

        // Simple
        myArrayList.add("Hello");
        myArrayList.add("There");
        myLVAdapter = new ArrayAdapter<>(
                this,
                 android.R.layout.simple_list_item_1, // simple adapter
                myArrayList
                );
        myListView.setAdapter(myLVAdapter);

        // With to and from
        String[] from = {"text1", "text2"};
        int[] to = {R.id.textMain, R.id.textSecondary};

        HashMap hashA = new HashMap<>();
        hashA.put("text1", myArrayList.get(0));
        hashA.put("text2", "This is a secondary text");
        ArrayList newList = new ArrayList();
        newList.add(hashA);

        SimpleAdapter adapter = new SimpleAdapter(
                FirstActivity.this,
                newList,
                R.layout.my_adapter_resource,
                from, to);
        myListView.setAdapter(adapter);

    }
}