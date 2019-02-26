package intro.com.fristdrivingschool.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import intro.com.fristdrivingschool.Custom.CustomListView;
import intro.com.fristdrivingschool.R;
import intro.com.fristdrivingschool.adapter.CoachAdapter;
import intro.com.fristdrivingschool.adapter.SchoolConnectAdapter;
import intro.com.fristdrivingschool.adapter.SchoolLocationAdapter;
import intro.com.fristdrivingschool.base.BaseActivity;
import intro.com.fristdrivingschool.tool.ActivityUntil;
import intro.com.fristdrivingschool.tool.GlideImageLoader;
import intro.com.fristdrivingschool.tool.PublicClass;

public class SchoolDetailsActivity extends BaseActivity {

    @BindView(R.id.school_details_title)
    TextView schoolDetailsTitle;
    @BindView(R.id.school_details_message)
    ImageView schoolDetailsMessage;
    @BindView(R.id.tag_list_top_layout)
    LinearLayout tagListTopLayout;
    @BindView(R.id.school_details_banner)
    Banner schoolDetailsBanner;
    @BindView(R.id.school_details_location)
    CustomListView schoolDetailsLocation;
    @BindView(R.id.school_details_connect)
    CustomListView schoolDetailsConnect;
    @BindView(R.id.school_details_coach_list)
    CustomListView schoolDetailsCoachList;
    private String schoolId;
    private String schoolName;
    private List<Object> listSchoolAddress = new ArrayList<>();
    private SchoolLocationAdapter schoolLocationAdapter;
    private List<String> listBanner = new ArrayList<>();
    private List<String> listTitle = new ArrayList<>();
    private List<String> listConnect = new ArrayList<>();
    private List<String> listCoach = new ArrayList<>();
    private SchoolConnectAdapter schoolConnectAdapter;
    private CoachAdapter coachAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_details);
        ButterKnife.bind(this);
    }

    @Override
    protected void initTab() {
        PublicClass.setThemeTopLayout(activity, tagListTopLayout, null, null, ((ViewGroup) findViewById(android.R.id.content)).getChildAt(0));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.school_details_title://返回
                ActivityUntil.back((Activity) activity);
                break;
        }

    }

    @Override
    public void initData() {
        schoolId = getIntent().getExtras().getString("schoolId");
        schoolName = getIntent().getExtras().getString("schoolName");
        getData(1);
    }

    @Override
    public void initView() {
        schoolDetailsBanner.setImageLoader(new GlideImageLoader());
        listBanner.add("http://img.mp.itc.cn/upload/20160911/42a24cb433c44598a23cd0b804d08fca_th.jpg");
        listBanner.add("http://img.mp.itc.cn/upload/20160911/42a24cb433c44598a23cd0b804d08fca_th.jpg");
        listBanner.add("http://img.mp.itc.cn/upload/20160911/42a24cb433c44598a23cd0b804d08fca_th.jpg");
        schoolDetailsBanner.setImages(listBanner);//banner图片
        listTitle.add("大厅");
        listTitle.add("车辆");
        listTitle.add("训练场地");
        schoolDetailsBanner.setBannerTitles(listTitle);//banner标题
        schoolDetailsBanner.start();

        /* 联系方式  */
        listConnect.add("");
        listConnect.add("");
        listConnect.add("");
        schoolConnectAdapter = new SchoolConnectAdapter(activity, listConnect);
        schoolDetailsConnect.setAdapter(schoolConnectAdapter);

        /* 地址 */
        listSchoolAddress.add(null);
        listSchoolAddress.add(null);
        listSchoolAddress.add(null);
        schoolLocationAdapter = new SchoolLocationAdapter(activity, listSchoolAddress);
        schoolDetailsLocation.setAdapter(schoolLocationAdapter);

        /*  教练   */
        listCoach.add("");
        listCoach.add("");
        listCoach.add("");
        coachAdapter=new CoachAdapter(activity,listCoach);
        schoolDetailsCoachList.setAdapter(coachAdapter);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void getData(int... mark) {
        switch (mark[0]) {
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
