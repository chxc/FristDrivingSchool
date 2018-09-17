package intro.com.fristdrivingschool.app;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import intro.com.fristdrivingschool.R;
import intro.com.fristdrivingschool.base.BaseActivity;
import intro.com.fristdrivingschool.tool.ActivityUntil;

public class TeacherDetaisActivity extends BaseActivity {

    @BindView(R.id.teacher_details_title)
    TextView teacherDetailsTitle;
    @BindView(R.id.teacher_details_message)
    ImageView teacherDetailsMessage;
    @BindView(R.id.tag_list_top_layout)
    LinearLayout tagListTopLayout;
    @BindView(R.id.activity_teacher_detais)
    LinearLayout activityTeacherDetais;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_detais);
        ButterKnife.bind(this);
        context=this;
    }

    @Override
    protected void initTab() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.teacher_details_title://返回
                ActivityUntil.back((Activity) context);
                break;
        }
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {

    }

    @Override
    public void getData() {

    }
}
