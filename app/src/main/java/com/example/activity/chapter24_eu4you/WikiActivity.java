package com.example.activity.chapter24_eu4you;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

// the activity with a webview show information about country selected on wiki
public class WikiActivity extends AppCompatActivity {
    public static final String url = "URL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wiki);

        WebView webView = (WebView) findViewById(R.id.webview);

        // get the url of the country by bundle
        Bundle b = getIntent().getExtras();
        String country_url = b.getString(url);
//        String country_url = getResources().getString(id_url);
        webView.loadUrl(country_url);
    }
}
