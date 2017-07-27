package com.ymksun.android.fivedailyworkouts;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import entity.WorkOut;

public class DailyActivity extends AppCompatActivity {

    private String [] days = {"တနင်္ဂနွေ", "တနင်္လာ", "အင်္ဂါ", "ဗုဒ္ဓဟူး", "ကြာသပတေး", "သောကြာ", "စနေ"};

    private int [] colors = {
            R.color.colorRed, R.color.colorOrange, R.color.colorYellow, R.color.colorGreen,
            R.color.colorBlue, R.color.colorViolet, R.color.colorIndigo
    };

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView=(ListView) findViewById(R.id.daily_list);

        listView.setAdapter(new CustomListAdapter(this));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                addDaily(position);
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    class CustomListAdapter extends ArrayAdapter {

        Context context;

        public CustomListAdapter(Context context) {
            super(context, R.layout.daily_list, days);
            this.context=context;
            System.out.print("");
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){

            LayoutInflater inflater=((Activity)context).getLayoutInflater();

            View row=inflater.inflate(R.layout.daily_list, null);

            View view = (View) row.findViewById(R.id.temp_daily_view);
            view.setBackgroundColor(getResources().getColor(colors[position]));

            TextView title=(TextView) row.findViewById(R.id.daily_list_txt);

            title.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/mm3.ttf"));
            title.setText(days[position]);

            return (row);
        }
    }

    public void addDaily(int num){

        switch (num) {
            case 0: {
                Toast.makeText(getApplicationContext(), days[0], Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(DailyActivity.this, AddDailyActivity.class);
                intent.putExtra("day", 1);
                startActivity(intent);
            }
            break;
            case 1: {
                Toast.makeText(getApplicationContext(), days[1], Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(DailyActivity.this, AddDailyActivity.class);
                intent.putExtra("day", 2);
                startActivity(intent);
            }
            break;
            case 2: {
                Toast.makeText(getApplicationContext(), days[2], Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(DailyActivity.this, AddDailyActivity.class);
                intent.putExtra("day", 3);
                startActivity(intent);
            }
            break;
            case 3: {
                Toast.makeText(getApplicationContext(), days[3], Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(DailyActivity.this, AddDailyActivity.class);
                intent.putExtra("day", 4);
                startActivity(intent);
            }
            break;
            case 4: {
                Toast.makeText(getApplicationContext(), days[4], Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(DailyActivity.this, AddDailyActivity.class);
                intent.putExtra("day", 5);
                startActivity(intent);
            }
            break;
            case 5: {
                Toast.makeText(getApplicationContext(), days[5], Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(DailyActivity.this, AddDailyActivity.class);
                intent.putExtra("day", 6);
                startActivity(intent);
            }
            break;
            case 6: {
                Toast.makeText(getApplicationContext(), days[6], Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(DailyActivity.this, AddDailyActivity.class);
                intent.putExtra("day", 7);
                startActivity(intent);
            }
            break;
        }

    }

}
