# JAZZ CASH ANDROID PAYMENT GATEWAY LIBRARY

Add the following maven into your Projects build.Gradle

````
allprojects {
    repositories {
               maven { url 'https://jitpack.io' }
            }
    }
````

Add the following dependency into your app build.Gradle

````
implementation 'com.github.nomiuaf15:jazzcashpaymentgateway:1.1'
````

For Gradle Version 7.0 >

add these following lines into the settings.gradle

````
dependencyResolutionManagement {
repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
   repositories {
                 google()
                 mavenCentral()
                 jcenter()
            maven { url 'https://jitpack.io'}
            }
     }
````

Create Three Activities

1. Main Activity
2. Payment Activity
3. Response Activity

add three layouts as well

1. activity_main.xml
2. activity_payment.xml
3. activity_response.xml

Add following code into your activity_main.xml

````
    <Button
        android:id="@+id/buyNow"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Buy Now"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

````

Add following code into your activity_payment.xml

````
    <WebView
        android:id="@+id/activity_payment_webview"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:visibility="visible"/>
````

Add following code into your activity_response.xml

````
    <TextView
        android:id="@+id/responseText"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:gravity="center"
        android:textSize="16dp"
        android:textColor="@color/black"
        android:text="JazzCash Response Message Here."/>
````

That's it for the xml files. Now move to the java files.

Add the following code in MainActivity.java

````
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BuyNow = findViewById(R.id.buyNow);

        BuyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PaymentActivity.class);
                intent.putExtra("price", "1500.00");
                startActivity(intent);
            }
        });

    }

````

Add the following code in PaymentActivity.java

````
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        webView = findViewById(R.id.activity_payment_webview);

        Intent intentData = getIntent();
        String price = intentData.getStringExtra("price");

        jazzCash = new JazzCash(this, this, ResponseActivity.class, webView, "Pass your JazzCash MerchantID here", "Pass your JazzCash password here", "Pass your JazzCash IntegritySalt Value here", "Pass your jazzCash Returnm Url here", "Pass the price here");

        jazzCash.integrateNow();


    }
````

If You wanna pass or save custom values then use the following code (max 5 values)

````
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        webView = findViewById(R.id.activity_payment_webview);

        Intent intentData = getIntent();
        String price = intentData.getStringExtra("price");

        jazzCash = new JazzCash(this, this, ResponseActivity.class, webView, "Pass your JazzCash MerchantID here", "Pass your JazzCash password here", "Pass your JazzCash IntegritySalt Value here", "Pass your jazzCash Returnm Url here", "Pass the price here", "Add Custom Value if you wanna pass here");

        jazzCash.integrateNow();


    }
````

Add the following code in ResponseActivity.java

````
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
````

Now Run and Test your app.

<table>
    <tr>
<td><img src="https://user-images.githubusercontent.com/80037756/153843347-9c3c9f28-eb0c-4460-9d6c-8a731da1c844.png"/></td> 
<td><img src="https://user-images.githubusercontent.com/80037756/153843357-bdf081dd-398b-4d13-b68a-f9ef09ea5420.png"/></td>
    </tr>
<tr>
<td><img src="https://user-images.githubusercontent.com/80037756/153843373-834d0468-87ee-4c71-9133-6e489da88a8d.png"/></td>
<td><img src="https://user-images.githubusercontent.com/80037756/153843382-79bda4a6-698f-4561-9815-742c4f874141.png"/></td>
    </tr>
    <tr>
<td><img src="https://user-images.githubusercontent.com/80037756/153843399-ea062f63-b778-46d0-b43d-11402d4d4bd5.png" /> </td>
    </tr>
</table>

