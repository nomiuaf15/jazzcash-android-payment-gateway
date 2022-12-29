package com.nouman.hexabytestudios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

import com.nouman.jazzcashlib.JazzCash;


public class PaymentActivity extends AppCompatActivity {
    WebView webView;
    JazzCash jazzCash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        webView = findViewById(R.id.activity_payment_webview);

        Intent intentData = getIntent();
        String price = intentData.getStringExtra("price");


        // to get result on next screen//
        jazzCash = new JazzCash(this, this, webView, "Pass your JazzCash MerchantID here", "Pass your JazzCash password here", "Pass your JazzCash IntegritySalt Value here", "Pass your jazzCash Returnm Url here", "Pass the price here", "Pass your custom transaction id prefix", false, ResponseActivity.class);


        //to get result onActivityResult//
        jazzCash = new JazzCash(this, this, webView, "Pass your JazzCash MerchantID here", "Pass your JazzCash password here", "Pass your JazzCash IntegritySalt Value here", "Pass your jazzCash Returnm Url here", "Pass the price here", "Pass your custom transaction id prefix", false);

        jazzCash.integrateNow();

    }


}