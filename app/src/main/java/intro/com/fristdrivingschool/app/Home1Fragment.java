package intro.com.fristdrivingschool.app;

import android.app.Activity;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
import intro.com.fristdrivingschool.Custom.CustomDialog;
import intro.com.fristdrivingschool.Custom.CustomGridView;
import intro.com.fristdrivingschool.R;
import intro.com.fristdrivingschool.adapter.FlowLayoutTagAdapter;
import intro.com.fristdrivingschool.adapter.GridViewAdapter;
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
    private View view;
    private ViewHolder holder;
    private Activity context;
    private Home1Bean home1Bean;
    private List<Home1Bean.DataBean.TodayBean.AppointmentBean> todatList;
    private GridViewAdapter gridViewAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.home1_layout, container, false);
        holder = new ViewHolder(view);
        context = getActivity();
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected void initData() {
        SharedPreferencesUtils.savaString(context,SharedPreferencesUtils.USERID,"1");
        getData(1);
    }

    @Override
    public void initView() {
        //预约时间点
        todatList = new ArrayList<>();
        gridViewAdapter = new GridViewAdapter(todatList, context);
        holder.home1LayoutClassGridview.setAdapter(gridViewAdapter);
        //标签
        List<String> list1 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list1.add("标签" + i);
        }
        FlowLayoutTagAdapter flowLayoutTagAdapter = new FlowLayoutTagAdapter(context, list1);
        holder.home1LayoutTeacherTag.setAdapter(flowLayoutTagAdapter);
        holder.home1LayoutTeacherBelongTo.getPaint().setFlags(Paint. UNDERLINE_TEXT_FLAG );//设置下划线
    }

    @Override
    public void getData(int... mark) {
        switch (mark[0]){
            case 1://获取首页数据
                Map<String, String> loginMap = new HashMap<>();
                loginMap.put("user_id", StaticValue.getUseId(context));
                MyNetListener.getString(context,Request.Method.POST,this,
                        StaticValue.home1,mark[0],loginMap);
                break;
        }
    }

    @Override
    public void initEvent() {
        holder.home1LayoutTeacherPhoneIcon.setOnClickListener(this);
        holder.home1LayoutTeacherBelongTo.setOnClickListener(this);
        holder.home1LayoutDrivingSchool.setOnClickListener(this);
        holder.home1LayoutAppointmentTime.setOnClickListener(this);
        holder.home1LayoutTeacherIcon.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home1_layout_teacherPhoneIcon://教练电话
                PublicClass.diallPhone(context, "13969531234");
                break;

            case R.id.home1_layout_drivingSchool://驾校
                PublicClass.openAppForPackageName(context,"com.rtk.app");
                context.finish();
                break;

            case R.id.home1_layout_appointmentTime://已预约的时间
                final CustomDialog customDialog = new CustomDialog(context, R.style.CustomDialog);
                customDialog.setMsg("您要取消预约吗？");
                customDialog.setOnCancelListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        CustomToast.showToast(context, "取消", 2000);
                        customDialog.dismiss();
                    }
                });
                customDialog.setOnEnsureListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        CustomToast.showToast(context, "确定", 2000);
                        customDialog.dismiss();
                    }
                });
                customDialog.show();
                break;
            case R.id.home1_layout_teacherIcon://教练详情页
                PublicClass.goToTeacherDetaisActivity(context,"1");
                break;
            case R.id.home1_layout_teacherBelongTo://驾校详情
                PublicClass.goToSchoolDetailsActivity(context,"1",
                        "某某驾校");
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void success(String str, int mark, int... position) {
        switch (mark){
            case 1://首页数据
                YCStringTool.logi(this.getClass(),"首页数据"+str);
                Gson gson=new GsonBuilder().enableComplexMapKeySerialization().create();
                home1Bean = gson.fromJson(str, Home1Bean.class);
                todatList.addAll(home1Bean.getData().getToday().getAppointment());
                holder.home1LayoutTeacherName.setText(home1Bean.getData().getCoachdata().getName());//教练名;
                holder.home1LayoutTeacherPhone.setText(home1Bean.getData().getCoachdata().getConnect());//教练电话
                holder.home1LayoutTeacherLocation.setText(home1Bean.getData().getCoachdata().getConnect());//教练电话
                holder.home1LayoutTeacherLocation.setText(home1Bean.getData().getCoachdata().getConnect());//教练电话
                holder.home1LayoutDrivingSchool.setText(home1Bean.getData().getCoachdata().getSchool());//驾校名
                gridViewAdapter.notifyDataSetChanged();
                break;
        }
    }

    @Override
    public void error(String str, int mark, int... position) {
    }

    class ViewHolder {
        @BindView(R.id.home1_layout_teacherIcon)
        ImageView home1LayoutTeacherIcon;
        @BindView(R.id.home1_layout_teacherPhoneIcon)
        ImageView home1LayoutTeacherPhoneIcon;
        @BindView(R.id.home1_layout_drivingSchool)
        TextView home1LayoutDrivingSchool;
        @BindView(R.id.home1_layout_teacherName)
        TextView home1LayoutTeacherName;
        @BindView(R.id.home1_layout_teacherPhone)
        TextView home1LayoutTeacherPhone;
        @BindView(R.id.home1_layout_teacherLocation)
        TextView home1LayoutTeacherLocation;
        @BindView(R.id.home1_layout_teacherBelongTo)
        TextView home1LayoutTeacherBelongTo;
        @BindView(R.id.home1_layout_appointmentTime)
        TextView home1LayoutAppointmentTime;
        @BindView(R.id.home1_layout_class_gridview)
        CustomGridView home1LayoutClassGridview;
        @BindView(R.id.home1_layout_teacherTag)
        TagFlowLayout home1LayoutTeacherTag;
        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
