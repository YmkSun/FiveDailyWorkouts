package com.ymksun.android.fivedailyworkouts;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import util.CaluclateBMI;

public class BMIActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private String[] weightItems = {"ပေါင် (lbs)", "ကီလိုဂရမ် (kg)"};
    private String[] heightItems = {"လက်မ (inches)", "စင်တီမီတာ (cm)"};

    private Spinner spinWeight;
    private Spinner spinHeight;

    private EditText ageText;
    private EditText weightText;
    private EditText heightText;

    private RadioGroup radioGroup;
    private RadioButton maleBtn;
    private RadioButton femaleBtn;

    private TextView bmiAns;
    private TextView bmrAns;

    private Button calBtn;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        spinWeight = (Spinner) findViewById(R.id.spin_weight);
        spinWeight.setOnItemSelectedListener(this);
        spinWeight.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, weightItems));

        spinHeight = (Spinner) findViewById(R.id.spin_height);
        spinHeight.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, heightItems));
        spinHeight.setOnItemSelectedListener(this);

        ageText = (EditText) findViewById(R.id.bmi_age_txt);
        weightText = (EditText) findViewById(R.id.bmi_weight_txt);
        heightText = (EditText) findViewById(R.id.bmi_height_txt);

        radioGroup = (RadioGroup) findViewById(R.id.bmi_gender);
        maleBtn = (RadioButton) findViewById(R.id.bmi_male);
        femaleBtn = (RadioButton) findViewById(R.id.bmi_female);

        bmiAns = (TextView) findViewById(R.id.bmi_ans_txt);
        bmrAns = (TextView) findViewById(R.id.bmr_ans_txt);

        calBtn = (Button) findViewById(R.id.bmi_btn);
        calBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBmi();
            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void calculateBmi() {
        Double age, weight, height, bmi = 0.00d, bmr = 0.00d;
        String gender, result = "";

        if (!(ageText.getText().toString().equals("") && weightText.getText().toString().equals("") && heightText.getText().toString().equals(""))) {
            try {
                age = Double.parseDouble(ageText.getText().toString());
                weight = Double.parseDouble(weightText.getText().toString());
                height = Double.parseDouble(heightText.getText().toString());

                int check = radioGroup.getCheckedRadioButtonId();

                if (check == maleBtn.getId()) {
                    gender = "male";
                } else {
                    gender = "female";
                }

                CaluclateBMI cal = new CaluclateBMI();

                if (spinHeight.getSelectedItemPosition() == 0) {
                    bmi = cal.calulateBMI_LbIn(weight, height);
                }
                if (spinHeight.getSelectedItemPosition() == 1) {
                    bmi = cal.calulateBMI_KgCm(weight, height);
                }

                result = checkState(bmi);

                String bmitmp = String.valueOf(bmi);
                if(bmitmp.length()>6){
                    bmitmp = bmitmp.substring(0,6);
                }

                bmiAns.setText(bmitmp);
                bmrAns.setText(result);

            } catch (Exception e) {
                Toast.makeText(this, "မှားယွင်းမှုရှိနေပါ၍ ပြန်လည်စစ်ဆေးပါ", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(this, "အချက်အလက်များ ပြည့်စုံအောင် ဖြည့်ပေးပါ", Toast.LENGTH_SHORT).show();
        }

    }

    public String checkState(Double d){
        String state = "";

        if(d<=19){
            state = "ပိန်သောအခြေအနေ";
        }
        else if(d>19 && d<=24){
            state = "သာမန်အခြေအနေ";
        }
        else if(d>24 && d<=30){
            state = "ဝသောအခြေအနေ";
        }
        else if(d>30 && d<=40){
            state = "အဝလွန်သော အခြေအနေ";
        }
        else if(d>40){
            state = "အလွန်အမင်း ဝနေပါသည်";
        }

        return state;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        spinWeight.setSelection(position);
        spinHeight.setSelection(position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "BMI Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.ymksun.android.fivedailyworkouts/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "BMI Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.ymksun.android.fivedailyworkouts/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
