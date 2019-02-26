package intro.com.fristdrivingschool.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import intro.com.fristdrivingschool.Bean.Home1Bean;
import intro.com.fristdrivingschool.Custom.CustomDialog;
import intro.com.fristdrivingschool.R;
import intro.com.fristdrivingschool.tool.CustomToast;
import intro.com.fristdrivingschool.tool.YCStringTool;

/**
 * Created by HFZS on 2018/7/5.
 */

public class GridViewAdapter extends PublicAdapter {
    private Context context;
    private List<Home1Bean.DataBean.DateBean.AppointmentBean> list;
    private CustomDialog customDialog;

    public GridViewAdapter(Context context,List<Home1Bean.DataBean.DateBean.AppointmentBean> list) {
        super(list);
        this.context = context;
        this.list = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.appointment_gridview_layout_item, parent, false);
        MyViewHolder holder=new MyViewHolder(convertView);
        if(list.get(position).getHasNum()>list.get(position).getNotNum()){
            holder.appointmentGridviewItem.setEnabled(true);
        }
        holder.appointmentGridviewTime.setText(list.get(position).getTime());
        holder.appointmentGridviewNum.setText(list.get(position).getNotNum()+"/"+list.get(position).getHasNum());
        holder.appointmentGridviewItem.setOnClickListener(new MyListener(position,2));
        return convertView;
    }

    private class MyListener implements View.OnClickListener{
        private int position;
        private int mark;

        public MyListener(int position, int mark) {
            this.position = position;
            this.mark = mark;
        }

        @Override
        public void onClick(View v) {
            switch (mark){
                case 0://Dialog确定
                    CustomToast.showToast(context,"确定的："+position,2000);
                    Log.i("TAG123", "确定的:"+"postion:"+position);
                    customDialog.dismiss();
                    break;
                case 1://取消
                    customDialog.dismiss();
                    break;

                case 2://item点击
                    YCStringTool.logi(this.getClass(),"点击"+position);
                    customDialog=new CustomDialog(context);
                    customDialog.setOnEnsureListener(new MyListener(position,0));
                    customDialog.setOnCancelListener(new MyListener(position,1));
                    customDialog.setMsg("请确定预约时间点12：00-12：40");
                    customDialog.show();
                    break;

            }
        }
    }

    class MyViewHolder{
        @BindView(R.id.appointment_gridview_time)
        TextView appointmentGridviewTime;
        @BindView(R.id.appointment_gridview_num)
        TextView appointmentGridviewNum;
        @BindView(R.id.appointment_gridview_item)
        LinearLayout appointmentGridviewItem;

        MyViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
