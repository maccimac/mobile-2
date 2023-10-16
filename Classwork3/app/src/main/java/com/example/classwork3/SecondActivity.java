package com.example.classwork3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.classwork3.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {

    private ActivitySecondBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Bundle extra = getIntent().getExtras();
        if(extra == null) return;
        String qStr = extra.getString("qStr");
        binding.textViewSec.setText(qStr);
    }


    public void returnText(View view) {
        finish();
    }

    @Override
    public void finish(){
        Intent data = new Intent();
        String returnString = binding.editTextSecond.getText().toString();
        data.putExtra("returnData", returnString);
        setResult(RESULT_OK, data);
        super.finish();
    }
}