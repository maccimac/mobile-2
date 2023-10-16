package com.example.classwork8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView myTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myTextView = findViewById(R.id.myText);
    }

    public void btnClick(View view) {
        AsyncTask task = new MyTask().execute();
//        task.cancel(true);

//        int cpu_course = Runtime.getRuntime().availableProcessors();
//        int i = 0;
//        while( i <= 10){
//            try{
//                Thread.sleep(1000);
//                i++;
//            }catch(Exception e){
//
//            }
//        }
//        myTextView.setText("Button pressed");
    }

    public class MyTask extends AsyncTask<String, Integer, String>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String result) {
//            super.onPostExecute(s);
            myTextView.setText(result);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
//            super.onProgressUpdate(values);
            myTextView.setText("Counter = " + values[0]);
        }

        @Override
        protected String doInBackground(String... strings) {
//            return null;
            int i = 0;
            while( i <= 10){

//                onProgressUpdate(i);
                publishProgress(i);
                try{
                    Thread.sleep(1000);
                    i++;
                }catch(Exception e){

                }
            }
            return "Button pressed";
        }
    }
}