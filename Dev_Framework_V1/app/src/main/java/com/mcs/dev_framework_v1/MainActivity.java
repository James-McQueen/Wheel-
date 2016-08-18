package com.mcs.dev_framework_v1;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.JavascriptInterface;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {


    private String package_name = "com.android.calculator2";
    private String class_name = "com.android.calculator2.Calculator";


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView view = (WebView) this.findViewById(R.id.webView);

        view.getSettings().setJavaScriptEnabled(true);
        view.setWebViewClient(new MyWebViewClient());
        view.addJavascriptInterface(new webViewInterface(), "MainActivityInterface");
        String url = "file:///android_asset/web/testpage.html";
        view.loadUrl(url);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private class MyWebViewClient extends WebViewClient
    {
        @Override
        //show the web page in webview but not in web browser
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl (url);
            return true;
        }
    }

    public class webViewInterface{

        @JavascriptInterface
        public void launchCaller(){

            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_LAUNCHER);
            intent.setComponent(new ComponentName(package_name, class_name));
            try {
                startActivity(intent);
            } catch (Exception e) {

                e.printStackTrace();
            }

        }
        public int getValue() {
            return 5;

        }
    }




    @Override
    public void onStop() {
        super.onStop();
    }
}

