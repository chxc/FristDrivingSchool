package intro.com.fristdrivingschool.app;

import android.app.Activity;
import android.content.Context;
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
import intro.com.fristdrivingschool.app.Home5.LoginActivity;
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
    private Context context;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.home5_layout, container, false);
        context=getContext();
        ButterKnife.bind(this, view);
        initEvent();
        getData();
        initView();
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
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.home5_headIcon://头部
                ActivityUntil.next((Activity) context,LoginActivity.class,null);
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
