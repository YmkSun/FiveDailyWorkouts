package com.ymksun.android.fivedailyworkouts;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import entity.WorkOut;
import util.AnimationView;

public class AnimateActivity extends AppCompatActivity implements View.OnClickListener{

    private AnimationView animView;

    private Button startBtn;
    private Button stopBtn;
    private CheckBox checkBox;
    private TextView title;

    private WorkOut workOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animate);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent recIntent = getIntent();

        workOut = (WorkOut) recIntent.getSerializableExtra("wo");

        animView = (AnimationView) this.findViewById(R.id.anim_view);

        animView.loadAnimation(workOut.getAnim(), workOut.getFrame(), 0, 0);

        title = (TextView) findViewById(R.id.anim_title);
        title.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/mm3.ttf"));
        title.setText(workOut.getTitle());

        startBtn = (Button) findViewById(R.id.btn_start);
        stopBtn = (Button) findViewById(R.id.btn_stop);

        startBtn.setOnClickListener(this);
        stopBtn.setOnClickListener(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==startBtn.getId()) {
            animView.playAnimation();
        }
        else if(v.getId()==stopBtn.getId()) {
            animView.stopAnimation();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        animView.stopAnimation();
        Intent backIntent=new Intent(this, MainActivity.class);
        startActivity(backIntent);
    }


}
