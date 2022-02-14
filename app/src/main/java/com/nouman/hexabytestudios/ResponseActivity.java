package com.nouman.hexabytestudios;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.nouman.jazzcashlib.Constants;
import com.nouman.jazzcashlib.JazzCashResponse;

public class ResponseActivity extends AppCompatActivity {
    TextView responseText;
    JazzCashResponse jazzCashResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_response);
        responseText = findViewById(R.id.responseText);

        if (getIntent() != null) {

            jazzCashResponse = (JazzCashResponse) getIntent().getSerializableExtra(Constants.jazzCashResponse);

            responseText.setText(jazzCashResponse.getPpResponseMessage());
        }


    }
}