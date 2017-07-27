package com.ymksun.android.fivedailyworkouts;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

import entity.*;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private String [] workOuts = {"အိပ်ထ လေ့ကျင့်ခန်း", "ဗွီပုံအိပ်ထ လေ့ကျင့်ခန်း", "စက်ဘီးစီးပုံ လေ့ကျင့်ခန်း", "ဘေးတိုက် လေ့ကျင့်ခန်း", "ပခုံးစောင်း လေ့ကျင့်ခန်း"};

    private String [] days = {"တနင်္ဂနွေ", "တနင်္လာ", "အင်္ဂါ", "ဗုဒ္ဓဟူး", "ကြာသပတေး", "သောကြာ", "စနေ"};

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView=(ListView) findViewById(R.id.list_view);

        listView.setAdapter(new CustomListAdapter(this));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                viewWorkout(position);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_main);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addDaily(getDayOfWeek() - 1);
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_about) {
            Intent intent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_bmi) {
            Intent intent = new Intent(MainActivity.this, BMIActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_daily) {
            Intent intent = new Intent(MainActivity.this, DailyActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_quiz) {
            Intent intent = new Intent(MainActivity.this, QuizActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_centers) {
            Intent intent = new Intent(MainActivity.this, CenterActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_send) {
            Intent intent = new Intent(MainActivity.this, SendActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    class CustomListAdapter extends ArrayAdapter {

        Context context;

        public CustomListAdapter(Context context) {
            super(context, R.layout.custom_list, workOuts);
            this.context=context;
            System.out.print("");
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){

            LayoutInflater inflater=((Activity)context).getLayoutInflater();

            View row=inflater.inflate(R.layout.custom_list, null);

            TextView title=(TextView)row.findViewById(R.id.list_txt);

            title.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/mm3.ttf"));

            title.setText(workOuts[position]);

            return (row);
        }
    }

    public void viewWorkout(int position){
        switch (position){
            case 0: {
                Toast.makeText(getApplicationContext(), workOuts[0], Toast.LENGTH_SHORT).show();
                Intent crunchIntent = new Intent(MainActivity.this, WorkOutActivity.class);
                WorkOut crunches = new WorkOut();
                crunches.setCurnches();
                crunchIntent.putExtra("wo", crunches);
                startActivity(crunchIntent);
            } break;
            case 1: {
                Toast.makeText(getApplicationContext(), workOuts[1], Toast.LENGTH_SHORT).show();
                Intent vcrunchIntent=new Intent(MainActivity.this, WorkOutActivity.class);
                WorkOut vcrunches = new WorkOut();
                vcrunches.setVCurnches();
                vcrunchIntent.putExtra("wo", vcrunches);
                startActivity(vcrunchIntent);
            } break;
            case 2: {
                Toast.makeText(getApplicationContext(), workOuts[2], Toast.LENGTH_SHORT).show();
                Intent bicycleIntent=new Intent(MainActivity.this, WorkOutActivity.class);
                WorkOut bicycle = new WorkOut();
                bicycle.setBicycle();
                bicycleIntent.putExtra("wo", bicycle);
                startActivity(bicycleIntent);
            } break;
            case 3: {
                Toast.makeText(getApplicationContext(), workOuts[3], Toast.LENGTH_SHORT).show();
                Intent sidebridgeIntent=new Intent(MainActivity.this, WorkOutActivity.class);
                WorkOut sidebridge = new WorkOut();
                sidebridge.setSideBridge();
                sidebridgeIntent.putExtra("wo", sidebridge);
                startActivity(sidebridgeIntent);
            } break;
            case 4: {
                Toast.makeText(getApplicationContext(), workOuts[4], Toast.LENGTH_SHORT).show();
                Intent sidebendIntent=new Intent(MainActivity.this, WorkOutActivity.class);
                WorkOut sidebend = new WorkOut();
                sidebend.setSideBend();
                sidebendIntent.putExtra("wo", sidebend);
                startActivity(sidebendIntent);
            } break;
        }
    }

    public void addDaily(int num){

        switch (num) {
            case 0: {
                Toast.makeText(getApplicationContext(), days[0], Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, AddDailyActivity.class);
                intent.putExtra("day", 1);
                startActivity(intent);
            }
            break;
            case 1: {
                Toast.makeText(getApplicationContext(), days[1], Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, AddDailyActivity.class);
                intent.putExtra("day", 2);
                startActivity(intent);
            }
            break;
            case 2: {
                Toast.makeText(getApplicationContext(), days[2], Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, AddDailyActivity.class);
                intent.putExtra("day", 3);
                startActivity(intent);
            }
            break;
            case 3: {
                Toast.makeText(getApplicationContext(), days[3], Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, AddDailyActivity.class);
                intent.putExtra("day", 4);
                startActivity(intent);
            }
            break;
            case 4: {
                Toast.makeText(getApplicationContext(), days[4], Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, AddDailyActivity.class);
                intent.putExtra("day", 5);
                startActivity(intent);
            }
            break;
            case 5: {
                Toast.makeText(getApplicationContext(), days[5], Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, AddDailyActivity.class);
                intent.putExtra("day", 6);
                startActivity(intent);
            }
            break;
            case 6: {
                Toast.makeText(getApplicationContext(), days[6], Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, AddDailyActivity.class);
                intent.putExtra("day", 7);
                startActivity(intent);
            }
            break;
        }

    }

    public int getDayOfWeek() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        return dayOfWeek;
    }
}
