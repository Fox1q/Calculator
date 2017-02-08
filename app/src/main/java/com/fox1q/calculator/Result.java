package com.fox1q.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        String firstNumber = getIntent().getStringExtra(MainActivity.EXTRA_FIRST_NUMBER);
        String secondNumber = getIntent().getStringExtra(MainActivity.EXTRA_SECOND_NUMBER);

        TextView textView = (TextView) findViewById(R.id.text_result);
        textView.setText(generateCalculatedString(firstNumber, secondNumber));
    }

    private String generateCalculatedString(String firstNumber, String secondNumber) {
        String string = firstNumber + " + ";
        if (secondNumber.matches("^-\\d+$")) string = string + "( " + secondNumber + " )";
        else string += secondNumber;
        string = string + " = " + (Integer.valueOf(firstNumber) + Integer.valueOf(secondNumber));
        return string;
    }
}