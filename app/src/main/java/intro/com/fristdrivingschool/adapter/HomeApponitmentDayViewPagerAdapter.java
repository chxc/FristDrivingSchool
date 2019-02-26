package intro.com.fristdrivingschool.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import intro.com.fristdrivingschool.Bean.Home1Bean;
import intro.com.fristdrivingschool.Custom.CustomGridView;
import intro.com.fristdrivingschool.R;
import intro.com.fristdrivingschool.tool.YCStringTool;

public class HomeApponitmentDayViewPagerAdapter extends PagerAdapter {
    private Context context;
    private List<Home1Bean.DataBean.DateBean> list;

    public HomeApponitmentDayViewPagerAdapter(Context context, List<Home1Bean.DataBean.DateBean> list) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //container.removeView(container);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.home1_day_appointment_item_layout, null);
        ViewHolder viewHolder=new ViewHolder(view);
        GridViewAdapter gridViewAdapter = new GridViewAdapter(context,list.get(position).getAppointment());
        viewHolder.home1DayAppointmentItemGridview.setAdapter(gridViewAdapter );
        container.addView(view);
        return view;
    }

    class ViewHolder {
        @BindView(R.id.home1_day_appointment_item_gridview)
        CustomGridView home1DayAppointmentItemGridview;
        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return YCStringTool.forMatTimeData(list.get(position).getT());
    }

}
