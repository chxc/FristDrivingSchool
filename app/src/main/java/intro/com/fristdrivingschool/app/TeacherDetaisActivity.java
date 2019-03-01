package intro.com.fristdrivingschool.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.Request;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import intro.com.fristdrivingschool.Custom.CustomListView;
import intro.com.fristdrivingschool.Custom.HorizontalListView;
import intro.com.fristdrivingschool.R;
import intro.com.fristdrivingschool.adapter.PictureAdapter;
import intro.com.fristdrivingschool.adapter.StudentCommentAdapter;
import intro.com.fristdrivingschool.base.BaseActivity;
import intro.com.fristdrivingschool.tool.ActivityUntil;
import intro.com.fristdrivingschool.tool.CustomToast;
import intro.com.fristdrivingschool.tool.Net.MyNetListener;
import intro.com.fristdrivingschool.tool.PublicClass;
import intro.com.fristdrivingschool.tool.StaticValue;
import intro.com.fristdrivingschool.tool.YCStringTool;

public class TeacherDetaisActivity extends BaseActivity {
    @BindView(R.id.teacher_details_title)
    TextView teacherDetailsTitle;
    @BindView(R.id.teacher_details_message)
    ImageView teacherDetailsMessage;
    @BindView(R.id.tag_list_top_layout)
    LinearLayout tagListTopLayout;
    @BindView(R.id.teacher_details_Icon)
    ImageView teacherDetailsIcon;
    @BindView(R.id.teacher_details_Name)
    TextView teacherDetailsName;
    @BindView(R.id.teacher_details_Phone)
    TextView teacherDetailsPhone;
    @BindView(R.id.teacher_details_Location)
    TextView teacherDetailsLocation;
    @BindView(R.id.teacher_details_BelongTo)
    TextView teacherDetailsBelongTo;
    @BindView(R.id.teacher_details_PhoneIcon)
    ImageView teacherDetailsPhoneIcon;
    @BindView(R.id.teacher_details_pic)
    HorizontalListView teacherDetailsPic;
    @BindView(R.id.teacher_details_comment)
    CustomListView teacherDetailsComment;
    @BindView(R.id.activity_teacher_detais)
    LinearLayout activityTeacherDetais;
    @BindView(R.id.teacher_details_comment_btu)
    LinearLayout teacherDetailsCommentBtu;
    private String coach_id = "";//教练id
    private List<String> listCoachPicture;//教练照片
    private PictureAdapter pictureAdapter;
    private List<String> listStudentComment;
    private StudentCommentAdapter studentCommentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_detais);
        ButterKnife.bind(this);
    }

    @Override
    protected void initTab() {
        Bundle bundle = getIntent().getExtras();
        coach_id = bundle.getString("coach_id");
        if (YCStringTool.isNull(coach_id)) {
            CustomToast.showToast(activity.getApplicationContext(), "暂无该教练信息", 2000);
            finish();
        }
        getData(1);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.teacher_details_title://返回
                ActivityUntil.back((Activity) activity);
                break;
            case R.id.teacher_details_comment_btu://跳转评论输入页面
                PublicClass.goToCommentActivity((Activity) activity,"","");
                break;

            case R.id.teacher_details_BelongTo://跳转驾校
                PublicClass.goToSchoolDetailsActivity(activity, "1","某某驾校");
                break;
        }
    }

    @Override
    public void initData() {
    }

    @Override
    public void initView() {
        listCoachPicture = new ArrayList<>();
        listCoachPicture.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1550814177659&di=90b41f74376af8d2c07d3b2eda8d139e&imgtype=0&src=http%3A%2F%2Fmmbiz.qpic.cn%2Fmmbiz_jpg%2FaIUouuhnp7ssWaMe4xy6uicJvFLsFnOvEf0YaH56fyGQYhTgqxGtbFTfVpJaXmfrAZMg0TX3tskus3AhoCmcUibA%2F640%3Fwx_fmt%3Djpeg");
        listCoachPicture.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1550814177659&di=90b41f74376af8d2c07d3b2eda8d139e&imgtype=0&src=http%3A%2F%2Fmmbiz.qpic.cn%2Fmmbiz_jpg%2FaIUouuhnp7ssWaMe4xy6uicJvFLsFnOvEf0YaH56fyGQYhTgqxGtbFTfVpJaXmfrAZMg0TX3tskus3AhoCmcUibA%2F640%3Fwx_fmt%3Djpeg");
        listCoachPicture.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1550814177659&di=90b41f74376af8d2c07d3b2eda8d139e&imgtype=0&src=http%3A%2F%2Fmmbiz.qpic.cn%2Fmmbiz_jpg%2FaIUouuhnp7ssWaMe4xy6uicJvFLsFnOvEf0YaH56fyGQYhTgqxGtbFTfVpJaXmfrAZMg0TX3tskus3AhoCmcUibA%2F640%3Fwx_fmt%3Djpeg");
        listCoachPicture.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1550814177659&di=90b41f74376af8d2c07d3b2eda8d139e&imgtype=0&src=http%3A%2F%2Fmmbiz.qpic.cn%2Fmmbiz_jpg%2FaIUouuhnp7ssWaMe4xy6uicJvFLsFnOvEf0YaH56fyGQYhTgqxGtbFTfVpJaXmfrAZMg0TX3tskus3AhoCmcUibA%2F640%3Fwx_fmt%3Djpeg");
        listCoachPicture.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1550814177659&di=90b41f74376af8d2c07d3b2eda8d139e&imgtype=0&src=http%3A%2F%2Fmmbiz.qpic.cn%2Fmmbiz_jpg%2FaIUouuhnp7ssWaMe4xy6uicJvFLsFnOvEf0YaH56fyGQYhTgqxGtbFTfVpJaXmfrAZMg0TX3tskus3AhoCmcUibA%2F640%3Fwx_fmt%3Djpeg");
        listCoachPicture.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1550814177659&di=90b41f74376af8d2c07d3b2eda8d139e&imgtype=0&src=http%3A%2F%2Fmmbiz.qpic.cn%2Fmmbiz_jpg%2FaIUouuhnp7ssWaMe4xy6uicJvFLsFnOvEf0YaH56fyGQYhTgqxGtbFTfVpJaXmfrAZMg0TX3tskus3AhoCmcUibA%2F640%3Fwx_fmt%3Djpeg");
        listCoachPicture.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1550814177659&di=90b41f74376af8d2c07d3b2eda8d139e&imgtype=0&src=http%3A%2F%2Fmmbiz.qpic.cn%2Fmmbiz_jpg%2FaIUouuhnp7ssWaMe4xy6uicJvFLsFnOvEf0YaH56fyGQYhTgqxGtbFTfVpJaXmfrAZMg0TX3tskus3AhoCmcUibA%2F640%3Fwx_fmt%3Djpeg");
        pictureAdapter = new PictureAdapter(activity, listCoachPicture);
        teacherDetailsPic.setAdapter(pictureAdapter);

        listStudentComment = new ArrayList<>();
        listStudentComment.add("学员车神" + 1);
        listStudentComment.add("学员车神" + 2);
        listStudentComment.add("学员车神" + 3);
        listStudentComment.add("学员车神" + 4);
        listStudentComment.add("学员车神" + 5);
        studentCommentAdapter = new StudentCommentAdapter(activity, listStudentComment);
        teacherDetailsComment.setAdapter(studentCommentAdapter);
    }

    @Override
    public void initListener() {
    }

    @Override
    public void getData(int... mark) {
        switch (mark[0]) {
            case 1:
                Map<String, String> coachMap = new HashMap<>();
                coachMap.put("coach_id", coach_id);
                MyNetListener.getString(activity, Request.Method.POST, this, StaticValue.coachDetails, mark[0], coachMap);
                break;
        }
    }

    @Override
    public void success(String str, int mark, int... position) {
        switch (mark) {
            case 1://教练信息
                YCStringTool.logi(this.getClass(), "教练信息" + str);
                break;
        }
    }

    @Override
    public void error(String str, int mark, int... position) {

    }
}
