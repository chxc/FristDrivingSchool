package intro.com.fristdrivingschool.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import intro.com.fristdrivingschool.R;

public class CoachAdapter extends PublicAdapter {
    private Context context;
    private List<String> list;

    public CoachAdapter(Context context, List<String> list) {
        super(list);
        this.context = context;
        this.list = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.coach_item_layout, null);
            viewHolder=new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else
            viewHolder= (ViewHolder) convertView.getTag();
        return convertView;
    }

    class ViewHolder {
        @BindView(R.id.coach_item_icon)
        ImageView coachItemIcon;
        @BindView(R.id.coach_item_name)
        TextView coachItemName;
        @BindView(R.id.coach_item_grade)
        TextView coachItemGrade;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
