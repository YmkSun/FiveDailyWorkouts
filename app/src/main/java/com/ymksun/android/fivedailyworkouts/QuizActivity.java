package com.ymksun.android.fivedailyworkouts;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class QuizActivity extends AppCompatActivity {

    private TextView quizText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        quizText = (TextView) findViewById(R.id.quiz_txt);
        quizText.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/mm3.ttf"));
        quizText.setText(setTxt());

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public String setTxt(){
        String body = new String();

        body = "၁. ခန္ဓာကိုယ် ပြေပြစ်သွယ်လျစေရန် အငံကို လျှော့စားပါ။ အငံဓာတ်သည် မိမိဗိုက်သားအတွင်းရှိ ရေဓာတ်ကို ပိုမိုထိန်းထားပေးကာ ပို၍ဝစေပါသည်။";
        body += "\n\n၂. ကိုယ်လက်လှုပ်ရှား ပြုလုပ်ရာတွင် ဟန်ချက်ငြိမ်ငြိမ် ထိန်းနိုင်စေရန် လိုအပ်ပါက ပစ္စည်းကိရိယာများ အကူအညီကိုယူပါ။";
        body += "\n\n၃. မိမိစားသုံးသော ကာဗွန်ဟိုက်ဒြိတ်ကိုလည်း အတတ်နိုင်ဆုံးလျှော့ချပါ။ လတ်ဆတ်သော အသီးအနှံများများစားခြင်းဖြင့် ကျန်းမာရေးကောင်းမွန်အောင် စောင့်ရှောက်ပါ။";
        body += "\n\n၄. လေ့ကျင့်ခန်းများကို နည်းစနစ်ကျစွာ ပြုလုပ်ပါ။ လေ့ကျင့်ချိန်များ အကြားရှိ နားချိန်ကို စက္ကန့်၃၀အထိ လျှော့ချပါ။";
        body += "\n\n၅. လေ့ကျင့်ခန်းများ ပြုလုပ်ရာတွင်လည်း အပြင်းအထန် တဆက်တည်း မပြုလုပ်ဘဲ ကြွက်သားများကို အနားပေးကာ ချိန်ဆ၍ ပြုလုပ်ပါ။ လေ့လာတတ်ကျွမ်းသော ပညာရှင်များထံမှ နည်းနာများကို ရယူပါ။";

        return body;
    }

}
