package com.example.tipcalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText editAmount;
    TextView txtPercent, txtTip, txtTotal;
    Button btnIncrease, btnDecrease;
    String percentStr, billAmtStr;
    Double percent, billAmt;

    DecimalFormat df = new DecimalFormat("0.00");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editAmount = this.findViewById(R.id.editBillAmt);
        txtPercent = this.findViewById(R.id.txtPercent);
        txtTip = this.findViewById(R.id.txtTip);
        txtTotal = this.findViewById(R.id.txtTotal);
        btnIncrease = this.findViewById(R.id.btnIncrease);
        btnDecrease = this.findViewById(R.id.btnDecrease);

        btnIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adjustTip(true);
                computeTip();
            }
        });

        btnDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adjustTip(false);
                computeTip();
            }
        });


        editAmount.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                if ( actionId == EditorInfo.IME_NULL || actionId == EditorInfo.IME_NULL)
                {
                    computeTip();
                    return true;
                }
                return false;
            }
        });

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("billAmtStr", billAmtStr);
        outState.putDouble("percent", percent);

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if(savedInstanceState != null) {
            billAmtStr = savedInstanceState.getString("billAmtStr", "");
            percent = savedInstanceState.getDouble("percent", 0.15);

            editAmount.setText(billAmtStr);
            txtPercent.setText((percent * 100) + "%") ;
            computeTip();
        }
    }

    public String getPercentStr(){
        String strPercent = txtPercent.getText().toString();
        return strPercent.replace("%", "");
    }

    public void adjustTip(Boolean increment){
        percentStr =  getPercentStr();
        Integer percentInt = Integer.parseInt(percentStr);

        if(increment == true){
            txtPercent.setText(
                    ( percentInt+1) + "%"
            );

        }else{
            txtPercent.setText(
                    (percentInt-1) + "%"
            );
        }
        percent = Double.parseDouble(percentStr);
    }

    public void computeTip(){
        percent = Double.parseDouble(getPercentStr())/100;
        billAmtStr = editAmount.getText().toString();
        billAmt = Double.parseDouble(editAmount.getText().toString());

        Double tip = billAmt * percent;
        txtTip.setText("$" + df.format(tip));
        txtTotal.setText("$" + df.format(billAmt + tip));
    }


}