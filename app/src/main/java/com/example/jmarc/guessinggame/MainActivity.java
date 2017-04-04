package com.example.jmarc.guessinggame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView statusText;
    private EditText guessField;

    private int secretNumber = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random random = new Random();
        secretNumber = 1 + random.nextInt(10); // 1 to 10 random value


        statusText = (TextView) findViewById(R.id.statusText);
        guessField = (EditText) findViewById(R.id.guessField);

        statusText.setText("Hello world");

        guessField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence string, int start, int before, int count) {
//                method is when user types something in this method changes

                try {
                    int value = Integer.parseInt(string.toString());

                    if (value == secretNumber) {
                        statusText.setText("you won");
                    }
                } catch (Exception e) {

                }

                statusText.setText(string);

            }

            @Override
            public void afterTextChanged(Editable s) {
                System.out.println("done");
            }
        });

    }
}


