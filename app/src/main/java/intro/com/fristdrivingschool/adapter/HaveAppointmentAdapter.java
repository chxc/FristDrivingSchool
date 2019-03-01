package intro.com.fristdrivingschool.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import intro.com.fristdrivingschool.Custom.CustomDialog;
import intro.com.fristdrivingschool.R;
import intro.com.fristdrivingschool.tool.CustomToast;

/**已预约Adapter*/
public class HaveAppointmentAdapter extends PublicAdapter {

    private Context context;
    private List<String> list;
    private CustomDialog customDialog;

    public HaveAppointmentAdapter(Context context, List<String> list) {
        super(list);
        this.context = context;
        this.list = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.have_appointment_item_layout, null);
            viewHolder=new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else
            viewHolder= (ViewHolder) convertView.getTag();
        viewHolder.haveAppointmentItemCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customDialog = new CustomDialog(context, R.style.CustomDialog);
                customDialog.setMsg("您要取消预约吗？");
                customDialog.setOnCancelListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        CustomToast.showToast(context, "关闭", 2000);
                        customDialog.dismiss();
                    }
                });
                customDialog.setOnEnsureListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        CustomToast.showToast(context, "确定取消", 2000);
                        customDialog.dismiss();
                    }
                });
                customDialog.show();
            }
        });
        return convertView;
    }

    class ViewHolder {
        @BindView(R.id.have_appointment_item_time)
        TextView haveAppointmentItemTime;
        @BindView(R.id.have_appointment_item_cancel)
        TextView haveAppointmentItemCancel;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
