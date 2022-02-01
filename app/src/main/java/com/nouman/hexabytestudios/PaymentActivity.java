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

        jazzCash = new JazzCash(this, this, ResponseActivity.class, webView, "MC32336", "45u52gxa36", "u791w26e91", "http://localhost/loadx-pk/pay_with_jazzcash", price, "750");

        jazzCash.integrateNow();


    }

}