package intro.com.fristdrivingschool.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import intro.com.fristdrivingschool.R;
import intro.com.fristdrivingschool.base.BaseActivity;

public class SchoolDetailsActivity extends BaseActivity {
    private Context context;
    private String schoolId;
    private String schoolName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_details);
        context=this;
    }

    @Override
    protected void initTab() {

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void initData() {
        schoolId=getIntent().getExtras().getString("schoolId");
        schoolName=getIntent().getExtras().getString("schoolName");
        getData(1);
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {

    }

    @Override
    public void getData(int... mark) {
        switch (mark[0]){
            case 1://驾校详情
                break;
        }
    }

    @Override
    public void success(String str, int mark, int... position) {

    }

    @Override
    public void error(String str, int mark, int... position) {

    }
}
