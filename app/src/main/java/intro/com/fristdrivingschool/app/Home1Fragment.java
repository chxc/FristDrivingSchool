package intro.com.fristdrivingschool.app;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import intro.com.fristdrivingschool.Bean.Home1Bean;
import intro.com.fristdrivingschool.Custom.CustomListView;
import intro.com.fristdrivingschool.Custom.ViewPagerForScrollView;
import intro.com.fristdrivingschool.R;
import intro.com.fristdrivingschool.adapter.FlowLayoutTagAdapter;
import intro.com.fristdrivingschool.adapter.HaveAppointmentAdapter;
import intro.com.fristdrivingschool.adapter.HomeApponitmentDayViewPagerAdapter;
import intro.com.fristdrivingschool.app.Home5.AppointmentHistoryActivity;
import intro.com.fristdrivingschool.tool.ActivityUntil;
import intro.com.fristdrivingschool.tool.BaseFragment;
import intro.com.fristdrivingschool.tool.CustomToast;
import intro.com.fristdrivingschool.tool.Net.MyNetListener;
import intro.com.fristdrivingschool.tool.PublicClass;
import intro.com.fristdrivingschool.tool.SharedPreferencesUtils;
import intro.com.fristdrivingschool.tool.StaticValue;
import intro.com.fristdrivingschool.tool.YCStringTool;

/**
 * Created by HFZS on 2018/7/5.
 */

public class Home1Fragment extends BaseFragment implements MyNetListener.NetListener {

    Unbinder unbinder;
    @BindView(R.id.home1_layout_drivingSchool)
    TextView home1LayoutDrivingSchool;
    @BindView(R.id.home1_layout_teacherIcon)
    ImageView home1LayoutTeacherIcon;
    @BindView(R.id.home1_layout_teacherName)
    TextView home1LayoutTeacherName;
    @BindView(R.id.home1_layout_teacherPhone)
    TextView home1LayoutTeacherPhone;
    @BindView(R.id.home1_layout_teacherLocation)
    TextView home1LayoutTeacherLocation;
    @BindView(R.id.home1_layout_teacherBelongTo)
    TextView home1LayoutTeacherBelongTo;
    @BindView(R.id.home1_layout_teacherPhoneIcon)
    ImageView home1LayoutTeacherPhoneIcon;
    @BindView(R.id.home1_layout_day_tab)
    TabLayout home1LayoutDayTab;
    @BindView(R.id.home1_layout_day_viewpager)
    ViewPagerForScrollView home1LayoutDayViewPager;
    @BindView(R.id.home1_layout_teacherTag)
    TagFlowLayout home1LayoutTeacherTag;
    @BindView(R.id.home1_swipeRefresh)
    SwipeRefreshLayout home1SwipeRefresh;
    @BindView(R.id.home1_layout_appointmentTime)
    CustomListView home1LayoutAppointmentTime;
    @BindView(R.id.home1_layout_appointmentHistory)
    TextView home1LayoutAppointmentHistory;
    private View view;
    private Home1Bean home1Bean;
    private HomeApponitmentDayViewPagerAdapter homeApponitmentDayViewPagerAdapter;
    private ArrayList<Home1Bean.DataBean.DateBean> listDayAppointment = new ArrayList<>();
    private HaveAppointmentAdapter haveAppointmentAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.home1_layout, container, false);
        unbinder = ButterKnife.bind(this, view);
        fristMethod();
        return view;
    }

    @Override
    protected void initData() {
        SharedPreferencesUtils.savaString(activity, SharedPreferencesUtils.USERID, "1");
        getData(1);
    }

    @Override
    public void initView() {
        //预约天数ViewPager
        homeApponitmentDayViewPagerAdapter = new HomeApponitmentDayViewPagerAdapter(activity, listDayAppointment);
        home1LayoutDayViewPager.setAdapter(homeApponitmentDayViewPagerAdapter);
        home1LayoutDayTab.setupWithViewPager(home1LayoutDayViewPager, true);//设置关联ViewPagerTab
        //标签
        List<String> list1 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list1.add("标签" + i);
        }
        FlowLayoutTagAdapter flowLayoutTagAdapter = new FlowLayoutTagAdapter(activity, list1);
        home1LayoutTeacherTag.setAdapter(flowLayoutTagAdapter);
        home1LayoutTeacherBelongTo.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);//设置下划线

        haveAppointmentAdapter = new HaveAppointmentAdapter(activity, list1);//已预约
        home1LayoutAppointmentTime.setAdapter(haveAppointmentAdapter);
    }

    @Override
    public void getData(int... mark) {
        switch (mark[0]) {
            case 1://获取首页数据
                Map<String, String> loginMap = new HashMap<>();
                loginMap.put("user_id", StaticValue.getUseId(activity));
                MyNetListener.getString(activity, Request.Method.POST, this,
                        StaticValue.home1, mark[0], loginMap);
                break;
        }
    }

    @Override
    public void initEvent() {
        home1LayoutTeacherPhoneIcon.setOnClickListener(this);
        home1LayoutTeacherBelongTo.setOnClickListener(this);
        home1LayoutDrivingSchool.setOnClickListener(this);
        home1LayoutTeacherIcon.setOnClickListener(this);
        home1LayoutAppointmentHistory.setOnClickListener(this);

        //下拉监听
        home1SwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getData(1);
            }
        });
    }

    @Override
    public void onClick(View v) {
        try {
            switch (v.getId()) {
                case R.id.home1_layout_teacherPhoneIcon://教练电话
                    PublicClass.diallPhone(activity, home1Bean.getData().getCoachdata().getConnect());
                    break;

                case R.id.home1_layout_drivingSchool://驾校
                    PublicClass.openAppForPackageName(activity, "com.rtk.app");
                    activity.finish();
                    break;
                case R.id.home1_layout_teacherIcon://教练详情页
                    PublicClass.goToTeacherDetaisActivity(activity, "1");
                    break;
                case R.id.home1_layout_teacherBelongTo://驾校详情
                    PublicClass.goToSchoolDetailsActivity(activity, "1",
                            "某某驾校");
                    break;
                case R.id.home1_layout_appointmentHistory://预约历史
                    ActivityUntil.next(activity,AppointmentHistoryActivity.class,null);
                    break;

            }
        } catch (NullPointerException e) {
            CustomToast.showToast(activity, "空指针", 2000);

        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void success(String str, int mark, int... position) {
        home1SwipeRefresh.setRefreshing(false);
        switch (mark) {
            case 1://首页数据
                YCStringTool.logi(this.getClass(), "首页数据" + str);
                Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();
                home1Bean = gson.fromJson(str, Home1Bean.class);
                //todatList.addAll(home1Bean.getData().getToday().getAppointment());
                home1LayoutTeacherName.setText(home1Bean.getData().getCoachdata().getName());//教练名;
                home1LayoutTeacherPhone.setText(home1Bean.getData().getCoachdata().getConnect());//教练电话
                home1LayoutTeacherLocation.setText(home1Bean.getData().getCoachdata().getLocation());//教练地址
                home1LayoutDrivingSchool.setText(home1Bean.getData().getCoachdata().getSchool());//驾校名
                listDayAppointment.clear();
                listDayAppointment.addAll(home1Bean.getData().getDate());
                homeApponitmentDayViewPagerAdapter.notifyDataSetChanged();
                break;
        }
    }

    @Override
    public void error(String str, int mark, int... position) {
        home1SwipeRefresh.setRefreshing(false);
    }
}
