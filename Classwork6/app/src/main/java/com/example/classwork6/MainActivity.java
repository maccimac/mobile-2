package com.example.classwork6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.classwork6.databinding.ActivityMainBinding;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    Handler handler = new Handler(Looper.getMainLooper()){
        @Override // type @Override then choose Override / Implement Methods
        public void handleMessage(@NonNull Message msg) {
//            super.handleMessage(msg);
            Bundle bundle = msg.getData();
            String str = bundle.getString("myKey");
            binding.myTextView.setText(str);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

    }

    public void buttonClick(View view) {

        ExecutorService excutor = Executors.newSingleThreadExecutor();



        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                long endTime = System.currentTimeMillis() + 15 * 1000;
                while (System.currentTimeMillis() < endTime){
                    synchronized (this){
                        try {

                            wait(endTime - System.currentTimeMillis());
                        }catch(Exception e){

                        }
                    }
                }
//                handler.sendEmptyMessage(0);
                Message msg = handler.obtainMessage();
                Bundle bundle = new Bundle();

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm ss z");
                String currentDateTime = simpleDateFormat.format(new Date());

                bundle.putString("myKey", "Thread completed on " + currentDateTime);
                msg.setData(bundle);
                handler.sendMessage(msg);
            }
        };
        Thread myThread = new Thread(runnable);
        myThread.start();
//        binding.myTextView.setText("Button pressed");

    }
}