package com.mcs.dev_framework_v1;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class MainActivity extends AppCompatActivity {


    private String package_name = "com.android.settings";
    private String class_name = "com.android.settings.Settings";


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
        view.addJavascriptInterface(new webViewInterface(this), "MainActivityInterface"); // MainActivityInterface is what needs to be called in the javascript when passing a var value.


        //String url = "file:///android_asset/web/testpage.html";
        String url = "file:///android_asset/web/Small.html";

        view.loadUrl(url);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.mcs.dev_framework_v1/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
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



    public class webViewInterface {
// allows for passing variable values to javascript int he webview

        Context mContext;
        webViewInterface(Context c) {
            mContext = c;
        }
        @JavascriptInterface
        public List<ApplicationInfo> getUserInstalledApplications(Context context) {
            // Get installed applications
            final PackageManager packageManager = context.getPackageManager();
            List<ApplicationInfo> installedApplications =
                    packageManager.getInstalledApplications(PackageManager.GET_META_DATA);

            // Remove system apps
            Iterator<ApplicationInfo> it = installedApplications.iterator();
            while (it.hasNext()) {
                ApplicationInfo appInfo = it.next();
                if ((appInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 0) {
                    it.remove();
                }
            }

            // Return installed applications
            return installedApplications;
        }

//        public int getAppQuantity() {
//            int numberOfNonSystemApps = 0;
//
//            List<ApplicationInfo> appList = getPackageManager().getInstalledApplications(0);
//            for(ApplicationInfo info : appList) {
//                if((info.flags & ApplicationInfo.FLAG_SYSTEM) == 0) {
//                    numberOfNonSystemApps++;
//                }
//            }
//           // int numberOfInstalledApps = getPackageManager().getInstalledApplications(0).size();
//
//            return numberOfNonSystemApps;
//        }


        @JavascriptInterface
        public void launchCaller() {

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


    }

    @Override
    public void onStop() {
        super.onStop();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.mcs.dev_framework_v1/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.disconnect();
    }
}

