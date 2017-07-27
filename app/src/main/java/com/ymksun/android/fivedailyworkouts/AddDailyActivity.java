package com.ymksun.android.fivedailyworkouts;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import dbaction.DailyDB;
import entity.*;

public class AddDailyActivity extends AppCompatActivity {

    private int day;
    private String [] days = {"တနင်္ဂနွေ", "တနင်္လာ", "အင်္ဂါ", "ဗုဒ္ဓဟူး", "ကြာသပတေး", "သောကြာ", "စနေ"};

    private DailyDB db;
    private Daily olddaily;

    private TextView dayTitle;
    private CheckBox wo1, wo2, wo3, wo4, wo5;
    private Button saveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_daily);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent recIntent = getIntent();
        day = (int) recIntent.getIntExtra("day", 0);

        olddaily = new Daily();

        db = new DailyDB();
        olddaily = db.view(day);

        dayTitle = (TextView) findViewById(R.id.add_daily_title);
        dayTitle.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/mm3.ttf"));
        dayTitle.setText(days[day - 1]);

        wo1 = (CheckBox) findViewById(R.id.workout_one);
        wo2 = (CheckBox) findViewById(R.id.workout_two);
        wo3 = (CheckBox) findViewById(R.id.workout_three);
        wo4 = (CheckBox) findViewById(R.id.workout_four);
        wo5 = (CheckBox) findViewById(R.id.workout_five);

        if(olddaily.getWorkoutOne().equals("true")){
            wo1.setChecked(true);
        }
        if(olddaily.getWorkOutTwo().equals("true")){
            wo2.setChecked(true);
        }
        if(olddaily.getWorkOutThree().equals("true")){
            wo3.setChecked(true);
        }
        if(olddaily.getWorkOutFour().equals("true")){
            wo4.setChecked(true);
        }
        if(olddaily.getWorkOutFive().equals("true")){
            wo5.setChecked(true);
        }

        saveBtn = (Button) findViewById(R.id.daily_save_btn);
        saveBtn.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/mm3.ttf"));
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveDailyWorkout(v);
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void saveDailyWorkout(View v){

        Daily daily = new Daily(day, olddaily.getDay(), "false", "false", "false", "false", "false");


        daily.setDailyId(day);

        if(wo1.isChecked()){
            daily.setWorkoutOne("true");
        }
        if(wo2.isChecked()){
            daily.setWorkOutTwo("true");
        }
        if(wo3.isChecked()){
            daily.setWorkOutThree("true");
        }
        if(wo4.isChecked()){
            daily.setWorkOutFour("true");
        }
        if(wo5.isChecked()){
            daily.setWorkOutFive("true");
        }

        int flag = db.update(olddaily, daily);

        if(flag>0){
            Log.i("Update Info", "update success!!!");
        }
        else{
            Log.i("Update Info", "update unsuccess!!!");
        }

    }

}
