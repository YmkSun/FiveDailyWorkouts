package com.ymksun.android.fivedailyworkouts;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import entity.Centers;

public class ShowCenterActivity extends AppCompatActivity {

    private WebView webView;
    private TextView title;
    private TextView location;

    private Centers centers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_center);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent recIntent = getIntent();

        centers = (Centers) recIntent.getSerializableExtra("center");
        String name = (String) recIntent.getSerializableExtra("name");
        String loc = centers.getName();
        String latlong = ""+centers.getLtt()+","+centers.getLgt();

        title = (TextView) findViewById(R.id.center_title);
        title.setText(name);

        location = (TextView) findViewById(R.id.center_loc);
        location.setText(centers.getName());

        webView = (WebView)findViewById(R.id.webkit_view);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());

        String description = name + " <br> " + loc;
        String googleMapImage = "<img src=\"http://maps.googleapis.com/maps/api/staticmap?center="
                + latlong
                + "&" +
                "zoom=14&size=350x450&sensor=false\">";

        String myHTML = "<html><body><p>" + description + "</p>" + googleMapImage + "</body></hrml>";

        webView.loadData(myHTML, "text/html", "UTF-8");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                locate(centers.getLtt(), centers.getLgt());
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void locate(double lat, double lon){
        //String geoCode="geo:"+lat+","+lon+"?z=15";
        String httpGeoCode="https://maps.google.com/maps?q="+lat+","+lon+"(You are here)&iwloc=A&h1=en";

        Intent locateIntent=new Intent(Intent.ACTION_VIEW, Uri.parse(httpGeoCode));
        startActivity(locateIntent);
    }

}
