package intro.com.fristdrivingschool.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.io.File;

import intro.com.fristdrivingschool.MainActivity;
import intro.com.fristdrivingschool.R;
import intro.com.fristdrivingschool.tool.ActivityUntil;
import intro.com.fristdrivingschool.tool.CustomToast;

public class TestActivity extends AppCompatActivity implements View.OnClickListener{

    private int a=0;
    private long lastTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        File file=new File( getExternalFilesDir(null)+"");
        file.mkdirs();
        File file1=new File(getExternalFilesDir(null)+"/tip");
        File file2=new File(getExternalFilesDir(null)+"/tip1");

        if(!file1.exists()){
            CustomToast.showToast(this,"错误",500);
            finish();
        }else if(file2.exists()){
            ActivityUntil.next(this,MainActivity.class,null);
            finish();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.test_tv:
                a=1;
                CustomToast.showToast(this,""+a,500);
                lastTime=System.currentTimeMillis();
            break;

            case R.id.test_tv1:
                if(a==1&&System.currentTimeMillis()-lastTime<200) {
                    a++;
                    lastTime=System.currentTimeMillis();
                }
                if(a==2&&System.currentTimeMillis()-lastTime<200){
                    a++;
                    ActivityUntil.next(this, MainActivity.class,null);
                    finish();
                }
                break;
        }
    }

}
