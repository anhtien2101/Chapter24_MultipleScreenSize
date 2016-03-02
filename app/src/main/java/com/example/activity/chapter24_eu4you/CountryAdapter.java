package com.example.activity.chapter24_eu4you;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Tien on 02-Mar-16.
 */
public class CountryAdapter extends ArrayAdapter {
    private int layout;
    private Context context;
    private List<Country> countries;

    public CountryAdapter(Context context, int layout, List<Country> countries) {
        super(context, layout, countries);
        this.layout = layout;
        this.context = context;
        this.countries = countries;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CountryWrapper countryWrapper = null;
        // inflate to row if convertview == null
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(layout, null);
            countryWrapper = new CountryWrapper(convertView);
            convertView.setTag(countryWrapper); // save the countryWrapper to convertview
        } else { // get the view from convertview if convertview != null
            countryWrapper = (CountryWrapper) convertView.getTag();
        }
        // set the flag and name of country by position
        countryWrapper.imageView.setImageResource(countries.get(position).flag);
        countryWrapper.tv.setText(countries.get(position).name);
        return convertView;
    }
    // the class wrap textview and imageview to a row
    class CountryWrapper {
        private TextView tv;
        private ImageView imageView;

        CountryWrapper(View row) {
            tv = (TextView) row.findViewById(R.id.textview);
            imageView = (ImageView) row.findViewById(R.id.image);
        }
    }
}
