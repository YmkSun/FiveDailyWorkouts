package com.ymksun.android.fivedailyworkouts;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import entity.Centers;
import entity.WorkOut;

public class CenterActivity extends AppCompatActivity {

    private Centers [] clist = {
            new Centers("Bahan,Pearl Road", 16.815764, 96.154804),
            new Centers("9th Mile,Mayankon", 16.880150, 96.129521),
            new Centers("Yakin Road,Yakin", 16.000000, 96.330000),
            new Centers("Baho Road,Insein", 16.887238, 96.107556),
            new Centers("Pyay Road,Kamayut", 16.822451, 96.131149),
            new Centers("Gyi Myin tai", 16.792792, 96.126648),
            new Centers("Pyay Road,Dagon", 16.790739, 96.144093),
            new Centers("Mayangon", 16.862939, 96.144291)
    };

    private String [] names = {"REAL FITNESS", "MINDHAMA", "YANGON YOGA", "3 Season Gym", "NOVOTEL YANGON MAX", "SINGER BEAUTY LAND(Ladies only)", "TAW WIN Gardan", "BALANCE FITNESS"};

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_center);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView=(ListView) findViewById(R.id.center_list);

        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                viewCenters(position);
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void viewCenters(int position){
        Toast.makeText(getApplicationContext(), names[0], Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(CenterActivity.this, ShowCenterActivity.class);
        intent.putExtra("center", clist[position]);
        intent.putExtra("name", names[position]);
        startActivity(intent);


    }

}
