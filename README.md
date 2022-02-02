# JAZZ CASH ANDROID PAYMENT GATEWAY LIBRARY

Add the following maven into your **Projects build.Gradle**

````
allprojects {
    repositories {
               maven { url 'https://jitpack.io' }
            }
    }
````


Add the following dependency into your **App build.Gradle**

````
implementation 'com.github.nomiuaf15:jazzcashpaymentgateway:1.0'
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

        jazzCash = new JazzCash(this, this, ResponseActivity.class, webView, "Pass your JazzCash MerchantID here", "Pass your JazzCash password here", "Pass your JazzCash IntegritySalt Value here", "Pass your jazzCash Returnm Url here", "Pass the price here", "Add Custom Variable 1 Values here");

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


## Now Run and Test your app.

# Screenshots


![device-2022-02-02-114752](https://user-images.githubusercontent.com/80037756/152107679-3f27369f-0d38-4221-b8b1-f93e66c38ace.png)

![device-2022-02-02-115140](https://user-images.githubusercontent.com/80037756/152107836-89cd5919-1c5a-4fdc-b030-35cad6709a44.png)

![device-2022-02-02-115205](https://user-images.githubusercontent.com/80037756/152108536-8e78df93-00ed-4feb-a2e8-131f6110b182.png)

![device-2022-02-02-115239](https://user-images.githubusercontent.com/80037756/152108595-2d45c5df-9d1f-46db-8035-1c045a34d76d.png)

![device-2022-02-02-115353](https://user-images.githubusercontent.com/80037756/152108630-80d0acd1-becb-4abb-ad3a-5cc0dd7b380d.png)
