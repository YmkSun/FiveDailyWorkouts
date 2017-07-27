package com.ymksun.android.fivedailyworkouts;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SendActivity extends AppCompatActivity {

    private EditText mailBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mailBody = (EditText) findViewById(R.id.mail_body);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMail();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void sendMail(){
        String mailSubj = "Giving Advice";
        String mailText = mailBody.getText().toString();
        String mailRecList[]=new String[1];
        mailRecList[0]="ymksun90@gmail.com";

        Intent mailIntent = new Intent(Intent.ACTION_SEND);
        mailIntent.setType("text/plain");
        mailIntent.putExtra(Intent.EXTRA_EMAIL, mailRecList);
        mailIntent.putExtra(Intent.EXTRA_SUBJECT, mailSubj);
        mailIntent.putExtra(Intent.EXTRA_TEXT, mailText);
        Intent.createChooser(mailIntent, "To complete action choose");
        startActivity(mailIntent);
    }

}
