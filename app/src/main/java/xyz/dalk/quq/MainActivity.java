package xyz.dalk.quq;

//import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    //Initialize
    public Switch zhuang;
    public Switch zhan;
    public Switch qing;
    public Switch zimo;
    public Switch jia;
    public Switch dian;
    public Switch bao;
    public Switch tong;
    public Switch qi;
    public Switch piao;
    public Switch zd;
    public CheckBox wohule;
    public int mine = 0;
    public int others = 0;
    public EditText wodan;
    public EditText tadan;
    public TextView score = null;
    public boolean dianpao = false;
    public boolean hu = false;
    public boolean zdp = false;
    public boolean z = false;

    int[] fcuk = {0,0,0,0,0,0,0,0,0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        zhuang = findViewById(R.id.zhuang);
        zhan = findViewById(R.id.zhan);
        qing = findViewById(R.id.qing);
        zimo = findViewById(R.id.zimo);
        jia = findViewById(R.id.jia);
        piao = findViewById(R.id.piao);
        dian = findViewById(R.id.dian);
        bao = findViewById(R.id.bao);
        tong = findViewById(R.id.tong);
        qi = findViewById(R.id.qi);
        zd = findViewById(R.id.zd);
        wohule = findViewById(R.id.hu);
        dian = findViewById(R.id.dian);
        wodan = findViewById(R.id.mine);
        tadan = findViewById(R.id.others);
        score = findViewById(R.id.score);

        zhuang.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                z=isChecked;
                if(isChecked) zd.setChecked(false);
                refresh();
            }
        });
        zhan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                fcuk[1]=isChecked?1:0;
                refresh();
            }
        });
        qing.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                fcuk[2]=isChecked?1:0;
                refresh();
            }
        });
        zimo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    fcuk[3]=1;
                    dian.setChecked(false);
                    tong.setChecked(false);
                }
                else{
                    bao.setChecked(false);
                    fcuk[3]=0;
                }
                refresh();
            }
        });
        jia.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    qi.setChecked(false);
                    piao.setChecked(false);
                    fcuk[4]=1;
                }else{
                    fcuk[4]=0;
                }
                refresh();
            }
        });
        dian.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    dianpao = true;
                    zimo.setChecked(false);
                }
                else{
                    dianpao = false;
                }
                refresh();
            }
        });
        bao.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    tong.setChecked(false);
                    zimo.setChecked(true);
                    dian.setChecked(false);
                    fcuk[5]=1;
                }else {
                    fcuk[5]=0;
                }
                refresh();
            }
        });
        tong.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    bao.setChecked(false);
                    zimo.setChecked(false);
                    dianpao = false;
                    dian.setChecked(false);
                    fcuk[6]=2;
                }else{
                    fcuk[6]=0;
                }
                refresh();
            }
        });
        qi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    piao.setChecked(false);
                    jia.setChecked(false);
                    fcuk[7]=3;
                }else {
                    fcuk[7]=0;
                }
                refresh();
            }
        });
        piao.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    qi.setChecked(false);
                    jia.setChecked(false);
                    fcuk[8]=2;
                }else {
                    fcuk[8]=0;
                }
                refresh();
            }
        });
        wohule.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                hu=isChecked;
                refresh();
            }
        });
        zd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    zhuang.setChecked(false);
                    dian.setChecked(false);
                    dianpao=false;
                    zdp=true;
                }
                else{
                    zdp=false;
                }
                refresh();
            }
        });
        wodan.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                String s = v.getText().toString();
                if(!s.equals("")){
                    mine = Integer.parseInt(s);
                }
                else{
                    mine = 0;
                }
                refresh();
                return false;
            }
        });
        tadan.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                String s = v.getText().toString();
                if(!s.equals("")){
                    others = Integer.parseInt(s);
                }
                else{
                    others = 0;
                }
                refresh();
                return false;
            }
        });
    }

    public void refresh(){
        int pw = 0;
        for(int i=0;i<=8;i++){
            pw+=fcuk[i];
        }
        int base = (int)Math.pow(2,pw);
        int scoreHere;
        if(hu){
            if(zdp){
                scoreHere=6*base;
            }
            else{
                if(dianpao){
                    if(z){
                        scoreHere=8*base;
                    }
                    else{
                        scoreHere=5*base;
                    }
                }else{
                    //前面自摸已经算过翻倍了，所以此处不乘自摸
                    if(z){
                        scoreHere=6*base;
                    }else{
                        scoreHere=4*base;
                    }
                }
            }
        }else{
            if(dianpao){
                if(z){
                    scoreHere=-4*base;
                }else{
                    scoreHere=-2*base;
                }
            }else{
                if(z){
                    scoreHere=-2*base;
                }else{
                    scoreHere=-base;
                }
            }
        }
        scoreHere+=3*mine;
        scoreHere-=others;
        String s =String.valueOf(scoreHere);
        score.setText(s);
    }

    public void refresh_hu(){

    }

}
