package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    EditText editAmount;
    TextView txtPercent, txtTip, txtTotal;
    Button btnIncrease, btnDecrease;

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
            }
        });

        btnDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adjustTip(false);
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

    public String getPercentStr(){
        String strPercent = txtPercent.getText().toString();
        return strPercent.replace("%", "");
    }

    public void adjustTip(Boolean increment){
        Integer percent = Integer.parseInt( getPercentStr() );
        if(increment == true){
            txtPercent.setText(
                    ( percent+1) + "%"
            );
        }else{
            txtPercent.setText(
                    (percent-1) + "%"
            );
        }

    }

    public void computeTip(){
        Double percent = Double.parseDouble(getPercentStr());
        Double billAmt = Double.parseDouble(editAmount.getText().toString());

        Double tip = billAmt * (percent/100);
        txtTip.setText("$" + tip);
        txtTotal.setText("$" + (billAmt + tip));
    }


}