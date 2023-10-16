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
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class MainActivity extends AppCompatActivity {

    Future<String> future;

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

        ExecutorService executor = Executors.newSingleThreadExecutor();
        future = executor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                long endTime = System.currentTimeMillis() + 15 * 1000;
                while (System.currentTimeMillis() < endTime){
                    synchronized (this){
                        try {

                            wait(endTime - System.currentTimeMillis());
                        }catch(Exception e){

                        }
                    }
                }
                return ("Task completed");
            }
        });

//        executor.submit(new Runnable() {
//            @Override
//            public void run() {
//                long endTime = System.currentTimeMillis() + 15 * 1000;
//                while (System.currentTimeMillis() < endTime){
//                    synchronized (this){
//                        try {
//
//                            wait(endTime - System.currentTimeMillis());
//                        }catch(Exception e){
//
//                        }
//                    }
//                }
////                handler.sendEmptyMessage(0);
//                Message msg = handler.obtainMessage();
//                Bundle bundle = new Bundle();
////                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm ss z");
////                String currentDateTime = simpleDateFormat.format(new Date());
//                bundle.putString("myKey", "Thread completed");
//                msg.setData(bundle);
//                handler.sendMessage(msg);
//            }
//        });

//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        };
//        Thread myThread = new Thread(runnable);
//        myThread.start();
//        binding.myTextView.setText("Button pressed");

        executor.shutdown();

    }

    public void statusClick(View view) {
        if(future.isDone()){
            String result = null;

            try{
                result = future.get(3, TimeUnit.SECONDS);
            }catch (ExecutionException | InterruptedException | TimeoutException e){
                e.printStackTrace();
            }
            binding.myTextView.setText("Task complete");
        } else {
            binding.myTextView.setText(
                    "Waiting"
            );

        }

    }
}