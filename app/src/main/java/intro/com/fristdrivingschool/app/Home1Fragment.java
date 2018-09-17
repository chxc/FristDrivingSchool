package intro.com.fristdrivingschool.app;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.zhy.view.flowlayout.TagFlowLayout;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import intro.com.fristdrivingschool.Custom.CustomDialog;
import intro.com.fristdrivingschool.R;
import intro.com.fristdrivingschool.adapter.FlowLayoutTagAdapter;
import intro.com.fristdrivingschool.adapter.GridViewAdapter;
import intro.com.fristdrivingschool.tool.ActivityUntil;
import intro.com.fristdrivingschool.tool.BaseFragment;
import intro.com.fristdrivingschool.tool.CustomToast;
import intro.com.fristdrivingschool.tool.PublicClass;

/**
 * Created by HFZS on 2018/7/5.
 */

public class Home1Fragment extends BaseFragment {
    private View view;
    private ViewHolder holder;
    private Activity context;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.home1_layout, container, false);
        holder = new ViewHolder(view);
        context=getActivity();
        initEvent();
        getData();
        initView();
        return view;
    }

    @Override
    public void initView() {
        //预约时间点
        List<String> list=new ArrayList<>();
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        GridViewAdapter  gridViewAdapter=new GridViewAdapter(list,context);
        holder.home1LayoutClassGridview.setAdapter(gridViewAdapter);
        reMesureGridViewHeight(holder.home1LayoutClassGridview);

        //标签
        List<String> list1=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list1.add("标签"+i);
        }
        FlowLayoutTagAdapter flowLayoutTagAdapter=new FlowLayoutTagAdapter(context,list1);
        holder.home1LayoutTeacherTag.setAdapter(flowLayoutTagAdapter);


    }

    @Override
    public void getData() {


    }

    @Override
    public void initEvent() {
        holder.home1LayoutTeacherPhoneIcon.setOnClickListener(this);
        holder.home1LayoutDrivingSchool.setOnClickListener(this);
        holder.home1LayoutAppointmentTime.setOnClickListener(this);
        holder.home1LayoutTeacherIcon.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.home1_layout_teacherPhoneIcon://教练电话
                PublicClass.diallPhone(context,"13969531234");
                break;

            case R.id.home1_layout_drivingSchool://驾校
                context.finish();
                break;

            case R.id.home1_layout_appointmentTime://已预约的时间
                final CustomDialog customDialog=new CustomDialog(context,R.style.CustomDialog);
                customDialog.setMsg("您要取消预约吗？");
                customDialog.setOnCancelListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        CustomToast.showToast(context,"取消",2000);
                        customDialog.dismiss();
                    }
                });
                customDialog.setOnEnsureListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        CustomToast.showToast(context,"确定",2000);
                        customDialog.dismiss();
                    }
                });
                customDialog.show();
                break;

            case R.id.home1_layout_teacherIcon://教练详情页
                ActivityUntil.next(context,TeacherDetaisActivity.class,null);
                break;

        }
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
        GridView home1LayoutClassGridview;
        @BindView(R.id.home1_layout_teacherTag)
        TagFlowLayout home1LayoutTeacherTag;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
    /**
     * 设置GridView高度
     * */
    public void reMesureGridViewHeight(GridView gridView) {
        // 获取GridView对应的Adapter
        ListAdapter listAdapter = gridView.getAdapter();
        if (listAdapter == null) {
            return;
        }
        int rows;
        int columns = 0;
        int horizontalBorderHeight = 0;
        Class<?> clazz = gridView.getClass();
        try {
            // 利用反射，取得每行显示的个数
            Field column = clazz.getDeclaredField("mRequestedNumColumns");
            column.setAccessible(true);
            columns = (Integer) column.get(gridView);
            //          columns = gridView.getNumColumns();//Call requires API level 11

            // 利用反射，取得横向分割线高度
            Field horizontalSpacing = clazz.getDeclaredField("mRequestedHorizontalSpacing");
            horizontalSpacing.setAccessible(true);
            horizontalBorderHeight = (Integer) horizontalSpacing.get(gridView);

            //          horizontalBorderHeight = gridView.getHorizontalSpacing();//Call requires API level 16
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 判断数据总数除以每行个数是否整除。不能整除代表有多余，需要加一行
        if (listAdapter.getCount() % columns > 0) {
            rows = listAdapter.getCount() / columns + 1;
        } else {
            rows = listAdapter.getCount() / columns;
        }
        int totalHeight = 0;
        for (int i = 0; i < rows; i++) { // 只计算每项高度*行数
            View listItem = listAdapter.getView(i, null, gridView);
            listItem.measure(0, 0); // 计算子项View 的宽高
            totalHeight += listItem.getMeasuredHeight(); // 统计所有子项的总高度
        }
        ViewGroup.LayoutParams params = gridView.getLayoutParams();
        params.height = totalHeight + horizontalBorderHeight * (rows - 1);// 最后加上分割线总高度
        gridView.setLayoutParams(params);
    }

}
