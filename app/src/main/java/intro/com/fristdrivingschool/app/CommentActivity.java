package intro.com.fristdrivingschool.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import intro.com.fristdrivingschool.R;
import intro.com.fristdrivingschool.base.BaseActivity;

/**评论输入页面*/
public class CommentActivity extends BaseActivity {
    private Context context;
    private String schoolId;
    private String coachId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);


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
        coachId=getIntent().getExtras().getString("coachId");
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {

    }

    @Override
    public void getData(int... mark) {

    }

    @Override
    public void success(String str, int mark, int... position) {

    }

    @Override
    public void error(String str, int mark, int... position) {

    }
}
