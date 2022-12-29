package com.nouman.hexabytestudios;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.nouman.jazzcashlib.Constants;
import com.nouman.jazzcashlib.JazzCashResponse;

public class MainActivity extends AppCompatActivity {
    Button BuyNow,BuyNowActivityResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BuyNow = findViewById(R.id.buyNow);
        BuyNowActivityResult = findViewById(R.id.buyNowActivityResult);

        // for result on next screen//
        BuyNow.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, PaymentActivity.class);
            intent.putExtra("price", "1500.00");
            startActivity(intent);
        });


        // for result on this screen
        BuyNowActivityResult.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, PaymentActivity.class);
            intent.putExtra("price", "1500.00");
            jazzCashLauncher.launch(intent);

        });
    }

    ActivityResultLauncher<Intent> jazzCashLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        JazzCashResponse jazzCashResponse = (JazzCashResponse) data.getSerializableExtra(Constants.jazzCashResponse);
                        Toast.makeText(MainActivity.this, jazzCashResponse.getPpResponseMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
}