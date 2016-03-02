package com.example.activity.chapter24_eu4you;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    static private List<Country> countryList = new ArrayList<Country>();
    public ListView listView;
    WebView browser;

    static {
        countryList.add(new Country(R.drawable.australia, R.string.australia, R.string.australia_url));
        countryList.add(new Country(R.drawable.austria, R.string.austria, R.string.austria_url));
        countryList.add(new Country(R.drawable.brazil, R.string.brazil, R.string.brazil_url));
        countryList.add(new Country(R.drawable.congo, R.string.congo, R.string.congo_url));
        countryList.add(new Country(R.drawable.eritrea, R.string.eritrea, R.string.eritrea_url));
        countryList.add(new Country(R.drawable.estonia, R.string.estonia, R.string.estonia_url));
        countryList.add(new Country(R.drawable.finland, R.string.finland, R.string.finland_url));
        countryList.add(new Country(R.drawable.gabon, R.string.gabon, R.string.gabon_url));
        countryList.add(new Country(R.drawable.new_zealand, R.string.new_zealand, R.string.new_zealand_url));
        countryList.add(new Country(R.drawable.suriname, R.string.suriname, R.string.suriname_url));
        countryList.add(new Country(R.drawable.switzerland, R.string.switzerland, R.string.switzerland_url));
        countryList.add(new Country(R.drawable.syria, R.string.syria, R.string.syria_url));
        countryList.add(new Country(R.drawable.thailand, R.string.thailand, R.string.thailand_url));
        countryList.add(new Country(R.drawable.togo, R.string.togo, R.string.togo_url));
        countryList.add(new Country(R.drawable.tunisia, R.string.tunisia, R.string.tunisia_url));
        countryList.add(new Country(R.drawable.turkey, R.string.turkey, R.string.turkey_url));
        countryList.add(new Country(R.drawable.tuvalu, R.string.tuvalu, R.string.tuvalu_url));
        countryList.add(new Country(R.drawable.ukraine, R.string.ukraine, R.string.ukraine_url));
        countryList.add(new Country(R.drawable.united_states, R.string.united_states, R.string.united_states_url));
        countryList.add(new Country(R.drawable.uruguay, R.string.uruguay, R.string.uruguay_url));
        countryList.add(new Country(R.drawable.venezuela, R.string.venezuela, R.string.venezuela_url));
        countryList.add(new Country(R.drawable.vietnam, R.string.vietnam, R.string.vietnam_url));
        countryList.add(new Country(R.drawable.wales, R.string.wales, R.string.wales_url));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CountryAdapter adapter = new CountryAdapter(this, R.layout.row_layout, countryList);
        listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);
        browser = (WebView) findViewById(R.id.browser);


        // set if the row(item) of listview is clicked
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                int id_url = countryList.get(position).url;
                String url = getResources().getString(id_url);
                if (browser == null) {
                   /* Intent i = new Intent(MainActivity.this, WikiActivity.class);
                    // send the url of the country
                    i.putExtra(WikiActivity.url, url);*/
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
                } else {
                    browser.setVisibility(View.VISIBLE);
                    browser.setWebViewClient(new WebViewClient());
                    browser.loadUrl(url);
                }
            }
        });
    }
}
