package com.example.classwork5broadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    BroadcastReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configureReceiver();

//        //1
//        Intent intent = new Intent();
//
//        intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
//
//        intent.setAction("com.example.Broadcast");
//        intent.putExtra("MyData", 1000);
//        sendBroadcast(intent);
//
//        // 3
//        IntentFilter filter = new IntentFilter("com.example.Broadcast");
//        MyReceiver receiver = new MyReceiver();
//        registerReceiver(receiver, filter);
//
//        // unregisterReceiver(receiver)

    }

    public void configureReceiver(){
        IntentFilter filter = new IntentFilter();
        filter.addAction("com.example.sendBroadcast");
        filter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        receiver = new MyReceiver();
        registerReceiver(receiver, filter);
    }


    public void broadcastIntent(View view) {
        Intent intent = new Intent();
        intent.setAction("com.example.sendBroadcast");
        intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
//        intent.putExtra("MyData", 1000);
        sendBroadcast(intent);
    }

    @Override
    protected  void  onDestroy(){
        super.onDestroy();
        unregisterReceiver(receiver);
    }
}