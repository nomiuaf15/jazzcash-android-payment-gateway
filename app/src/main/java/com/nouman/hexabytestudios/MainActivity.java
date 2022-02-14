package com.nouman.hexabytestudios;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button BuyNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BuyNow = findViewById(R.id.buyNow);

        BuyNow.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, PaymentActivity.class);
            intent.putExtra("price", "1500.00");
            startActivity(intent);
        });
    }
}