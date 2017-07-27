package entity;

import com.ymksun.android.fivedailyworkouts.R;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Ymk Sun on 3/12/2016.
 */
public class WorkOut implements Serializable {

    private String title;
    private int[] images;
    private String facts;
    private String anim;
    private int frame;

    public WorkOut() {
    }

    public WorkOut(String title, int[] images, String facts, int frame) {
        this.title = title;
        this.images = images;
        this.facts = facts;
        this.frame = frame;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int[] getImages() {
        return images;
    }

    public void setImages(int[] images) {
        this.images = images;
    }

    public String getFacts() {
        return facts;
    }

    public void setFacts(String facts) {
        this.facts = facts;
    }

    public String getAnim() {
        return anim;
    }

    public void setAnim(String anim) {
        this.anim = anim;
    }

    public int getFrame() {
        return frame;
    }

    public void setFrame(int frame) {
        this.frame = frame;
    }

    public void setCurnches() {

        int[] imgarray = {R.drawable.democrunches_1, R.drawable.democrunches_2};
        String fact = "၁. မိမိကျောကို မြေပြင်နှင့် ထိကပ်ထား၍ လက်၂ဘက်ကို ခေါင်းအနောက်တွင် ယှက်ထားပါ။";
        fact += "\n\n၂. ဒူး၂ချောင်းကို ပုံတွင် ပြထားသည့်အတိုင်း ထောင်ထားပါ။";
        fact += "\n\n၃. ဒူးခေါင်းများကို မရွေ့စေဘဲ ခါးအထက်ပိုင်းကို ဖြည်းညှင်းစွာကြွ၍ ပြန်ချပါ။";

        setTitle("အိပ်ထ လေ့ကျင့်ခန်း");
        setImages(imgarray);
        setFacts(fact);
        setAnim("crunches");
        setFrame(2);
    }

    public void setVCurnches() {

        int[] imgarray = {R.drawable.demovcrunches_1, R.drawable.demovcrunches_2};
        String fact = "၁. ခန္ဓာကိုယ်ကို မြေပြင်နှင့်ထိကပ်စွာ လဲလျောင်းနေပါ။";
        fact += "\n\n၂. ခြေ၂ချောင်းကို ထား၍ လက်၂ဘက်ကိုလည်း ခေါင်းအနောက်တွင်ထားက ဆန့်တန်းစွာ ရှိပါစေ။";
        fact += "\n\n၃. ကိုယ်အပေါ်ပိုင်းနှင့် ခြေ၂ဘက်ကို တပြိုင်နက်မြှောက်ပါ။";
        fact += "\n\n၄. ခြေ၂ဘက်ကို လက်ဖြင့်ထိ၍ စက္ကန့် အနည်းငယ်အကြာထားပါ။";
        fact += "\n\n၅. နောက် ခန္ဓာကိုယ်ကို ဖြည်းညှင်းစွာ ပြန်ချပါ။";

        setTitle("ဗွီပုံအိပ်ထ လေ့ကျင့်ခန်း");
        setImages(imgarray);
        setFacts(fact);
        setAnim("vcrunches");
        setFrame(2);
    }

    public void setBicycle() {

        int[] imgarray = {R.drawable.demobicycle_1, R.drawable.demobicycle_2};
        String fact = "၁. လဲလျောင်း၍ လက်၂ဘက်ကို ခေါင်းနောက်တွင်ထားပါ။";
        fact += "\n\n၂. ခန္ဓာကိုယ်ကို ကြွ၍ ဗိုက်ကြွက်သားများကို ခေါက်ကာ ကျောဘက်ပိုင်းရဲ့ အနည်းငယ်ကိုသာ မြေနဲ့ထိထားပါ။";
        fact += "\n\n၃. ပခုံးများ ကြွစဉ်မှာပဲ ခြေထောက်များကိုလည်း တလှည့်စီ ကြွပေးပါ။";
        fact += "\n\n၄. ညာဘက်ဒူးကို ဘယ်တံတောင်ဆစ်ဖြင့် ထိနေစဉ် ဘယ်ဘက်ဒူးကို လေထဲတွင် ဆန့်ထားပါ။";
        fact += "\n\n၅. ဘယ်ဘက်ဒူးနှင့် ညာတံတောင်ဆစ်ကိုလည်း ထိုသို့ ပြုလုပ်၍ တလှည့်စီ လုပ်ပေးပါ။";

        setTitle("စက်ဘီးစီးပုံ လေ့ကျင့်ခန်း");
        setImages(imgarray);
        setFacts(fact);
        setAnim("bicycle");
        setFrame(4);
    }

    public void setSideBridge() {

        int[] imgarray = {R.drawable.demosidebridge_1, R.drawable.demosidebridge_2};
        String fact = "၁. ဘေးတိုက်အနေအထား လဲလျောင်းပါ။ ခြေ၂ချောင်းကို တခုအပေါ်တခု ထပ်လျှက်ထားပါ။";
        fact += "\n\n၂. လက်၁ဘက်ဖြင့် မြေကိုထောက်ထားပြီး တံတောင်သည် မြေပြင်နှင့် ထောင့်မှန်အနေအထား ရှိပါစေ။";
        fact += "\n\n၃. ထောက်ထားသော လက်ဖြင့် ခန္ဓာကိုယ် အပေါ်ပိုင်းကို မတင်ပါ။";
        fact += "\n\n၄. ကျန်လက်တဘက်ကို မသုံးဘဲ ထောက်ထားသော လက်နှင့် ခြေထောက်ကိုသာ သုံး၍ ခန္ဓာကိုယ်ကို မြှောက်ပေးပါ။";
        fact += "\n\n၅. အခြားဘက်ကိုလည်း ထိုသို့ တလှည့်စီ ပြုလုပ်ပေးပါ။";

        setTitle("ဘေးတိုက် လေ့ကျင့်ခန်း");
        setImages(imgarray);
        setFacts(fact);
        setAnim("sidebridge");
        setFrame(2);
    }

    public void setSideBend() {

        int[] imgarray = {R.drawable.demosidebend_1, R.drawable.demosidebend_2, R.drawable.demosidebend_3};
        String fact = "၁. ကိုယ်ကို မတ်၍ ခြေ၂ဘက်ကို ခွဲကာ ရပ်ပါ။ လက်၂ဘက်တွင် သင့်တော်သော အလေးမတုံးငယ်များ ကိုင်ထားပါ။";
        fact += "\n\n၂. ခန္ဓာအောက်ပိုင်းကို အသုံးမပြုဘဲ ဘေးတဘက်သို့စောင်းပါ။";
        fact += "\n\n၃. မူလ အနေအထားသို့ ပြန်မတ်ပါ။";
        fact += "\n\n၄. ထို့နောက် တခြားဘက်ကိုလည်း ၎င်းနည်းတူ ပြုလုပ်ပေးပါ။";

        setTitle("ပခုံးစောင်း လေ့ကျင့်ခန်း");
        setImages(imgarray);
        setFacts(fact);
        setAnim("sidebend");
        setFrame(4);
    }

}
