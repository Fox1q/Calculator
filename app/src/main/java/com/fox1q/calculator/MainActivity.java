package com.fox1q.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    static final String EXTRA_FIRST_NUMBER = "first_number";
    static final String EXTRA_SECOND_NUMBER = "second_number";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.addition);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = "^-?\\d+$";

                Intent intent = new Intent(MainActivity.this,Result.class);
                EditText editText = (EditText) findViewById(R.id.first_number);
                if(!editText.getText().toString().matches(number)){
                    editText.setError(getString(R.string.error));
                    return;
                }
                intent.putExtra(EXTRA_FIRST_NUMBER, editText.getText().toString());
                editText = (EditText) findViewById(R.id.second_number);
                if(!editText.getText().toString().matches(number)){
                    editText.setError(getString(R.string.error));
                    return;
                }
                intent.putExtra(EXTRA_SECOND_NUMBER, editText.getText().toString());
                startActivity(intent);
            }
        });
    }
}