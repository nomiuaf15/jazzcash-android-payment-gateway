package com.nouman.jazzcashlib;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class JazzCash {

    private String postData = "";
    private String sortedString = "";
    private String price;
    private String DateString;
    private String expiryDateString;
    private String TransactionIdString;

    Date currentDateHourPlusOne;
    Calendar c;
    Context context;
    Class responseActivity;
    Activity currentActivity;
    JazzCashResponse jazzCashResponse;


    private WebView webView;
    private String pp_MerchantID;
    private String pp_Password;
    private String IntegritySalt;
    private String pp_ReturnURL;
    private String pp_Amount;
    private String paymentReturnUrl;
    private String pp_TxnDateTime;
    private String pp_TxnExpiryDateTime;
    private String pp_TxnRefNo;
    private String pp_Version = "1.1";
    private String pp_TxnType = "";
    private String pp_Language = "EN";
    private String pp_SubMerchantID = "";
    private String pp_BankID = "TBANK";
    private String pp_ProductID = "RETL";
    private String pp_TxnCurrency = "PKR";
    private String pp_BillReference = "billRef";
    private String pp_Description = "Description of transaction";
    private String pp_SecureHash = "";
    private String pp_mpf_1 = "1";
    private String pp_mpf_2 = "2";
    private String pp_mpf_3 = "3";
    private String pp_mpf_4 = "4";
    private String pp_mpf_5 = "5";

    public JazzCash(Context context, Activity currentActivity, Class responseActivity, WebView jazzCashWebView, String jazzCashMerchantID, String jazzCashPassword, String jazzCashIntegritySalt, String jazzCashReturnURL, String jazzCashPrice) {
        this.context = context;
        this.currentActivity = currentActivity;
        this.responseActivity = responseActivity;
        this.webView = jazzCashWebView;
        this.pp_MerchantID = jazzCashMerchantID;
        this.pp_Password = jazzCashPassword;
        this.IntegritySalt = jazzCashIntegritySalt;
        this.pp_ReturnURL = jazzCashReturnURL;
        this.price = jazzCashPrice;
        this.paymentReturnUrl = jazzCashReturnURL;

        jazzCashResponse = new JazzCashResponse();

        setPrice(price);

        setWebView(webView);

        setDate();

        setTranscationID();

    }

    public JazzCash(Context context, Activity currentActivity, Class responseActivity, WebView jazzCashWebView, String jazzCashMerchantID, String jazzCashPassword, String jazzCashIntegritySalt, String jazzCashReturnURL, String jazzCashPrice, String jazzCashMPF1) {
        this.context = context;
        this.currentActivity = currentActivity;
        this.responseActivity = responseActivity;
        this.webView = jazzCashWebView;
        this.pp_MerchantID = jazzCashMerchantID;
        this.pp_Password = jazzCashPassword;
        this.IntegritySalt = jazzCashIntegritySalt;
        this.pp_ReturnURL = jazzCashReturnURL;
        this.price = jazzCashPrice;
        this.pp_mpf_1 = jazzCashMPF1;
        this.paymentReturnUrl = jazzCashReturnURL;


        jazzCashResponse = new JazzCashResponse();

        setPrice(price);

        setWebView(webView);

        setDate();

        setTranscationID();

    }


    public JazzCash(Context context, Activity currentActivity, Class responseActivity, WebView jazzCashWebView, String jazzCashMerchantID, String jazzCashPassword, String jazzCashIntegritySalt, String jazzCashReturnURL, String jazzCashPrice, String jazzCashMPF1, String jazzCashMPF2) {
        this.context = context;
        this.currentActivity = currentActivity;
        this.responseActivity = responseActivity;
        this.webView = jazzCashWebView;
        this.pp_MerchantID = jazzCashMerchantID;
        this.pp_Password = jazzCashPassword;
        this.IntegritySalt = jazzCashIntegritySalt;
        this.pp_ReturnURL = jazzCashReturnURL;
        this.price = jazzCashPrice;
        this.pp_mpf_1 = jazzCashMPF1;
        this.pp_mpf_2 = jazzCashMPF2;
        this.paymentReturnUrl = jazzCashReturnURL;


        jazzCashResponse = new JazzCashResponse();

        setPrice(price);

        setWebView(webView);

        setDate();

        setTranscationID();

    }


    public JazzCash(Context context, Activity currentActivity, Class responseActivity, WebView jazzCashWebView, String jazzCashMerchantID, String jazzCashPassword, String jazzCashIntegritySalt, String jazzCashReturnURL, String jazzCashPrice, String jazzCashMPF1, String jazzCashMPF2, String jazzCashMPF3) {
        this.context = context;
        this.currentActivity = currentActivity;
        this.responseActivity = responseActivity;
        this.webView = jazzCashWebView;
        this.pp_MerchantID = jazzCashMerchantID;
        this.pp_Password = jazzCashPassword;
        this.IntegritySalt = jazzCashIntegritySalt;
        this.pp_ReturnURL = jazzCashReturnURL;
        this.price = jazzCashPrice;
        this.pp_mpf_1 = jazzCashMPF1;
        this.pp_mpf_2 = jazzCashMPF2;
        this.pp_mpf_3 = jazzCashMPF3;
        this.paymentReturnUrl = jazzCashReturnURL;


        jazzCashResponse = new JazzCashResponse();

        setPrice(price);

        setWebView(webView);

        setDate();

        setTranscationID();

    }

    public JazzCash(Context context, Activity currentActivity, Class responseActivity, WebView jazzCashWebView, String jazzCashMerchantID, String jazzCashPassword, String jazzCashIntegritySalt, String jazzCashReturnURL, String jazzCashPrice, String jazzCashMPF1, String jazzCashMPF2, String jazzCashMPF3, String jazzCashMPF4) {
        this.context = context;
        this.currentActivity = currentActivity;
        this.responseActivity = responseActivity;
        this.webView = jazzCashWebView;
        this.pp_MerchantID = jazzCashMerchantID;
        this.pp_Password = jazzCashPassword;
        this.IntegritySalt = jazzCashIntegritySalt;
        this.pp_ReturnURL = jazzCashReturnURL;
        this.price = jazzCashPrice;
        this.pp_mpf_1 = jazzCashMPF1;
        this.pp_mpf_2 = jazzCashMPF2;
        this.pp_mpf_3 = jazzCashMPF3;
        this.pp_mpf_4 = jazzCashMPF4;
        this.paymentReturnUrl = jazzCashReturnURL;


        jazzCashResponse = new JazzCashResponse();

        setPrice(price);

        setWebView(webView);

        setDate();

        setTranscationID();

    }

    public JazzCash(Context context, Activity currentActivity, Class responseActivity, WebView jazzCashWebView, String jazzCashMerchantID, String jazzCashPassword, String jazzCashIntegritySalt, String jazzCashReturnURL, String jazzCashPrice, String jazzCashMPF1, String jazzCashMPF2, String jazzCashMPF3, String jazzCashMPF4, String jazzCashMPF5) {
        this.context = context;
        this.currentActivity = currentActivity;
        this.responseActivity = responseActivity;
        this.webView = jazzCashWebView;
        this.pp_MerchantID = jazzCashMerchantID;
        this.pp_Password = jazzCashPassword;
        this.IntegritySalt = jazzCashIntegritySalt;
        this.pp_ReturnURL = jazzCashReturnURL;
        this.price = jazzCashPrice;
        this.pp_mpf_1 = jazzCashMPF1;
        this.pp_mpf_2 = jazzCashMPF2;
        this.pp_mpf_3 = jazzCashMPF3;
        this.pp_mpf_4 = jazzCashMPF4;
        this.pp_mpf_5 = jazzCashMPF5;
        this.paymentReturnUrl = jazzCashReturnURL;


        jazzCashResponse = new JazzCashResponse();

        setPrice(price);

        setWebView(webView);

        setDate();

        setTranscationID();

    }

    public void integrateNow() {

        sortedString += IntegritySalt + "&";
        sortedString += pp_Amount + "&";
        sortedString += pp_BankID + "&";
        sortedString += pp_BillReference + "&";
        sortedString += pp_Description + "&";
        sortedString += pp_Language + "&";
        sortedString += pp_MerchantID + "&";
        sortedString += pp_Password + "&";
        sortedString += pp_ProductID + "&";
        sortedString += pp_ReturnURL + "&";
        //sortedString += pp_SubMerchantID + "&";
        sortedString += pp_TxnCurrency + "&";
        sortedString += pp_TxnDateTime + "&";
        sortedString += pp_TxnExpiryDateTime + "&";
        //sortedString += pp_TxnType + "&";
        sortedString += pp_TxnRefNo + "&";
        sortedString += pp_Version + "&";
        sortedString += pp_mpf_1 + "&";
        sortedString += pp_mpf_2 + "&";
        sortedString += pp_mpf_3 + "&";
        sortedString += pp_mpf_4 + "&";
        sortedString += pp_mpf_5;

        pp_SecureHash = php_hash_hmac(sortedString, IntegritySalt);
        System.out.println("JazzCashLogs: sortedString : " + sortedString);
        System.out.println("JazzCashLogs: pp_SecureHash : " + pp_SecureHash);

        try {
            postData += URLEncoder.encode("pp_Version", "UTF-8")
                    + "=" + URLEncoder.encode(pp_Version, "UTF-8") + "&";
            postData += URLEncoder.encode("pp_TxnType", "UTF-8")
                    + "=" + pp_TxnType + "&";
            postData += URLEncoder.encode("pp_Language", "UTF-8")
                    + "=" + URLEncoder.encode(pp_Language, "UTF-8") + "&";
            postData += URLEncoder.encode("pp_MerchantID", "UTF-8")
                    + "=" + URLEncoder.encode(pp_MerchantID, "UTF-8") + "&";
            postData += URLEncoder.encode("pp_SubMerchantID", "UTF-8")
                    + "=" + pp_SubMerchantID + "&";
            postData += URLEncoder.encode("pp_Password", "UTF-8")
                    + "=" + URLEncoder.encode(pp_Password, "UTF-8") + "&";
            postData += URLEncoder.encode("pp_BankID", "UTF-8")
                    + "=" + URLEncoder.encode(pp_BankID, "UTF-8") + "&";
            postData += URLEncoder.encode("pp_ProductID", "UTF-8")
                    + "=" + URLEncoder.encode(pp_ProductID, "UTF-8") + "&";
            postData += URLEncoder.encode("pp_TxnRefNo", "UTF-8")
                    + "=" + URLEncoder.encode(pp_TxnRefNo, "UTF-8") + "&";
            postData += URLEncoder.encode("pp_Amount", "UTF-8")
                    + "=" + URLEncoder.encode(pp_Amount, "UTF-8") + "&";
            postData += URLEncoder.encode("pp_TxnCurrency", "UTF-8")
                    + "=" + URLEncoder.encode(pp_TxnCurrency, "UTF-8") + "&";
            postData += URLEncoder.encode("pp_TxnDateTime", "UTF-8")
                    + "=" + URLEncoder.encode(pp_TxnDateTime, "UTF-8") + "&";
            postData += URLEncoder.encode("pp_BillReference", "UTF-8")
                    + "=" + URLEncoder.encode(pp_BillReference, "UTF-8") + "&";
            postData += URLEncoder.encode("pp_Description", "UTF-8")
                    + "=" + URLEncoder.encode(pp_Description, "UTF-8") + "&";
            postData += URLEncoder.encode("pp_TxnExpiryDateTime", "UTF-8")
                    + "=" + URLEncoder.encode(pp_TxnExpiryDateTime, "UTF-8") + "&";
            postData += URLEncoder.encode("pp_ReturnURL", "UTF-8")
                    + "=" + URLEncoder.encode(pp_ReturnURL, "UTF-8") + "&";
            postData += URLEncoder.encode("pp_SecureHash", "UTF-8")
                    + "=" + pp_SecureHash + "&";
            postData += URLEncoder.encode("ppmpf_1", "UTF-8")
                    + "=" + URLEncoder.encode(pp_mpf_1, "UTF-8") + "&";
            postData += URLEncoder.encode("ppmpf_2", "UTF-8")
                    + "=" + URLEncoder.encode(pp_mpf_2, "UTF-8") + "&";
            postData += URLEncoder.encode("ppmpf_3", "UTF-8")
                    + "=" + URLEncoder.encode(pp_mpf_3, "UTF-8") + "&";
            postData += URLEncoder.encode("ppmpf_4", "UTF-8")
                    + "=" + URLEncoder.encode(pp_mpf_4, "UTF-8") + "&";
            postData += URLEncoder.encode("ppmpf_5", "UTF-8")
                    + "=" + URLEncoder.encode(pp_mpf_5, "UTF-8");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        System.out.println("JazzCashLogs: postData : " + postData);

        webView.postUrl("https://sandbox.jazzcash.com.pk/CustomerPortal/transactionmanagement/merchantform/", postData.getBytes());
    }

    @SuppressLint({"JavascriptInterface", "SetJavaScriptEnabled"})
    private void setWebView(WebView webView) {

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.setWebViewClient(new MyWebViewClient());
        webSettings.setDomStorageEnabled(true);
        webView.addJavascriptInterface(new FormDataInterface(), "FORMOUT");


    }


    private void setDate() {

        Date Date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddkkmmss");
        DateString = dateFormat.format(Date);
        System.out.println("JazzCashLogs: DateString : " + DateString);

        // Convert Date to Calendar
        c = Calendar.getInstance();
        c.setTime(Date);
        c.add(Calendar.HOUR, 1);

        // Convert calendar back to Date
        currentDateHourPlusOne = c.getTime();
        expiryDateString = dateFormat.format(currentDateHourPlusOne);
        System.out.println("JazzCashLogs: expiryDateString : " + expiryDateString);


        pp_TxnDateTime = DateString;
        pp_TxnExpiryDateTime = expiryDateString;

    }

    private void setTranscationID() {
        TransactionIdString = "T" + DateString;
        pp_TxnRefNo = TransactionIdString;
    }

    private void setPrice(String amount) {
        String[] finalPrice = price.split("\\.");
        amount = finalPrice[0];
        pp_Amount = amount + "00";
    }


    private class MyWebViewClient extends WebViewClient {
        private final String jsCode = "" + "function parseForm(form){" +
                "var values='';" +
                "for(var i=0 ; i< form.elements.length; i++){" +
                "   values+=form.elements[i].name+'='+form.elements[i].value+'&'" +
                "}" +
                "var url=form.action;" +
                "console.log('parse form fired');" +
                "window.FORMOUT.processFormData(url,values);" +
                "   }" +
                "for(var i=0 ; i< document.forms.length ; i++){" +
                "   parseForm(document.forms[i]);" +
                "};";

        //private static final String DEBUG_TAG = "CustomWebClient";

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            if (url.equals(paymentReturnUrl)) {
                System.out.println("JazzCashLogs: return url cancelling");
                view.stopLoading();
                return;
            }
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            //Log.d(DEBUG_TAG, "Url: "+url);
            if (url.equals(paymentReturnUrl)) {
                return;
            }
            view.loadUrl("javascript:(function() { " + jsCode + "})()");

            super.onPageFinished(view, url);
        }
    }

    private class FormDataInterface {
        @JavascriptInterface
        public void processFormData(String url, String formData) throws ClassNotFoundException {
            Intent i = new Intent(context, Class.forName(responseActivity.getName()));
//            Bundle bundle = new Bundle();

            System.out.println("JazzCashLogs: Url:" + url + " form data " + formData);
            if (url.equals(paymentReturnUrl)) {
                String[] values = formData.split("&");
//                i.putExtra("JazzCashResponse",values);

                for (String pair : values) {
                    String[] nameValue = pair.split("=");
                    if (nameValue.length == 2) {
                        System.out.println("JazzCashLogs: Name:" + nameValue[0] + " value:" + nameValue[1]);
//                        bundle.putString(nameValue[0], nameValue[1]);
                        if (nameValue[0].equalsIgnoreCase("pp_Amount")) {
                            jazzCashResponse.setPpAmount(nameValue[1]);
                        } else if (nameValue[0].equalsIgnoreCase("pp_BillReference")) {
                            jazzCashResponse.setPpBillReference(nameValue[1]);
                        } else if (nameValue[0].equalsIgnoreCase("pp_Language")) {
                            jazzCashResponse.setPpLanguage(nameValue[1]);
                        } else if (nameValue[0].equalsIgnoreCase("pp_MerchantID")) {
                            jazzCashResponse.setPpMerchantID(nameValue[1]);
                        } else if (nameValue[0].equalsIgnoreCase("pp_ResponseCode")) {
                            jazzCashResponse.setPpResponseCode(nameValue[1]);
                        } else if (nameValue[0].equalsIgnoreCase("pp_ResponseMessage")) {
                            jazzCashResponse.setPpResponseMessage(nameValue[1]);
                        } else if (nameValue[0].equalsIgnoreCase("pp_RetreivalReferenceNo")) {
                            jazzCashResponse.setPpRetreivalReferenceNo(nameValue[1]);
                        } else if (nameValue[0].equalsIgnoreCase("pp_SecureHash")) {
                            jazzCashResponse.setPpSecureHash(nameValue[1]);
                        } else if (nameValue[0].equalsIgnoreCase("pp_TxnCurrency")) {
                            jazzCashResponse.setPpTxnCurrency(nameValue[1]);
                        } else if (nameValue[0].equalsIgnoreCase("pp_TxnDateTime")) {
                            jazzCashResponse.setPpTxnDateTime(nameValue[1]);
                        } else if (nameValue[0].equalsIgnoreCase("pp_TxnRefNo")) {
                            jazzCashResponse.setPpTxnRefNo(nameValue[1]);
                        } else if (nameValue[0].equalsIgnoreCase("pp_TxnType")) {
                            jazzCashResponse.setPpTxnType(nameValue[1]);
                        } else if (nameValue[0].equalsIgnoreCase("pp_Version")) {
                            jazzCashResponse.setPpVersion(nameValue[1]);
                        } else if (nameValue[0].equalsIgnoreCase("ppmpf_1")) {
                            jazzCashResponse.setPpmbf1(nameValue[1]);
                        } else if (nameValue[0].equalsIgnoreCase("ppmpf_2")) {
                            jazzCashResponse.setPpmbf2(nameValue[1]);
                        } else if (nameValue[0].equalsIgnoreCase("ppmpf_3")) {
                            jazzCashResponse.setPpmbf3(nameValue[1]);
                        } else if (nameValue[0].equalsIgnoreCase("ppmpf_4")) {
                            jazzCashResponse.setPpmbf4(nameValue[1]);
                        } else if (nameValue[0].equalsIgnoreCase("ppmpf_5")) {
                            jazzCashResponse.setPpmbf5(nameValue[1]);
                        } else {

                        }
                    }
                }

                i.putExtra(Constants.jazzCashResponse, jazzCashResponse);
                currentActivity.startActivity(i);

                return;
            }
        }
    }

    public static String php_hash_hmac(String data, String secret) {
        String returnString = "";
        try {
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
            sha256_HMAC.init(secret_key);
            byte[] res = sha256_HMAC.doFinal(data.getBytes());
            returnString = bytesToHex(res);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return returnString;
    }

    public static String bytesToHex(byte[] bytes) {
        final char[] hexArray = "0123456789abcdef".toCharArray();
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0, v; j < bytes.length; j++) {
            v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

    public JazzCashResponse getJazzCashResponse() {

        return jazzCashResponse;
    }

}
