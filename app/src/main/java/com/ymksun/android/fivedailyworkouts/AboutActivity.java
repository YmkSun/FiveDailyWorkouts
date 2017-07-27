package com.ymksun.android.fivedailyworkouts;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {

    private TextView aboutText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        aboutText = (TextView) findViewById(R.id.about_text);
        aboutText.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/mm3.ttf"));
        aboutText.setText(getContent());

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public String getContent(){
        String content = "နေ့စဉ် လှုပ်ရှားကို နေ့စဉ် မိမိနေအိမ်တွင် နေ၍ ခန္ဓာကိုယ်ကြံခိုင် သွယ်လျစေရန် ရေးသားထားပါသည်။";
        content += "\n\nနေ့စဉ် လှုပ်ရှားမှုပြုရန် လေ့ကျင့်နည်း ၅မျိုး ထည့်သွင်းထားပါသည်။";
        content += "\n\nနေ့စဉ် မိမိနှစ်သက်ရာ လေ့ကျင့်နည်းကို ရွေးချယ်၍ ထည့်သွင်းနိုင်ပါသည်။";
        content += "\n\nမိမိအိမ်တွင် လေ့ကျင့်၍ အားမရဘဲ ခန္ဓာကိုယ်အချိုးအစား ပြေပြစ်စေရန် ထပ်မံလေ့ကျင့်လိုသူများအတွက် အားကစား စင်တာများ ထည့်သွင်းပေးထားပါသည်။";

        return content;
    }

}
