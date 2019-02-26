package intro.com.fristdrivingschool.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import intro.com.fristdrivingschool.R;
import intro.com.fristdrivingschool.app.Home5.AboutUsActivity;
import intro.com.fristdrivingschool.app.Home5.AppointmentHistoryActivity;
import intro.com.fristdrivingschool.app.Home5.FeedBackActivity;
import intro.com.fristdrivingschool.app.Home5.LoginActivity;
import intro.com.fristdrivingschool.app.Home5.SetThemeActivity;
import intro.com.fristdrivingschool.tool.ActivityUntil;
import intro.com.fristdrivingschool.tool.BaseFragment;

/**
 * Created by HFZS on 2018/7/5.
 */

public class Home5Fragment extends BaseFragment {

    View view;
    @BindView(R.id.home5_headIcon)
    ImageView home5HeadIcon;
    @BindView(R.id.home5_headName)
    TextView home5HeadName;
    @BindView(R.id.home5_layout_appointment_history)
    TextView home5LayoutAppointmentHistory;
    @BindView(R.id.home5_layout_appointment_feedBack)
    TextView home5LayoutAppointmentFeedBack;
    @BindView(R.id.home5_layout_appointment_aboutUs)
    TextView home5LayoutAppointmentAboutUs;
    @BindView(R.id.home5_layout_appointment_setTheme)
    TextView home5LayoutAppointmentSetTheme;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.home5_layout, container, false);
        ButterKnife.bind(this, view);
        fristMethod();
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void getData(int... mark) {

    }

    @Override
    protected void initEvent() {
        home5HeadIcon.setOnClickListener(this);
        home5LayoutAppointmentHistory.setOnClickListener(this);
        home5LayoutAppointmentFeedBack.setOnClickListener(this);
        home5LayoutAppointmentAboutUs.setOnClickListener(this);
        home5LayoutAppointmentSetTheme.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home5_headIcon://头部
                ActivityUntil.next(activity, LoginActivity.class, null);
                break;
            case R.id.home5_layout_appointment_history://预约历史
                ActivityUntil.next(activity, AppointmentHistoryActivity.class, null);
                break;
            case R.id.home5_layout_appointment_feedBack://反馈
                ActivityUntil.next(activity, FeedBackActivity.class, null);
                break;
            case R.id.home5_layout_appointment_aboutUs://关于我们
                ActivityUntil.next(activity, AboutUsActivity.class, null);
                break;
            case R.id.home5_layout_appointment_setTheme://主题设置
                ActivityUntil.next(activity, SetThemeActivity.class, null);
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
