package intro.com.fristdrivingschool.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import intro.com.fristdrivingschool.R;

/**
 * 场地适配器
 */
public class SchoolTrainingGroundAdapter extends PublicAdapter {
    private Context context;
    private List<String> list;

    public SchoolTrainingGroundAdapter(Context context, List<String> list) {
        super(list);
        this.context = context;
        this.list = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.school_training_ground_item_layout, null);
            viewHolder=new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else
            viewHolder= (ViewHolder) convertView.getTag();
        return convertView;
    }

    class ViewHolder {
        @BindView(R.id.school_training_ground_item_name)
        TextView schoolTrainingGroundItemName;
        @BindView(R.id.school_training_ground_item_isShortDistance)
        TextView schoolTrainingGroundItemIsShortDistance;
        @BindView(R.id.school_training_ground_item_address)
        TextView schoolTrainingGroundItemAddress;
        @BindView(R.id.school_training_ground_item_distance)
        TextView schoolTrainingGroundItemDistance;
        @BindView(R.id.school_training_ground_item_subject)
        TextView schoolTrainingGroundItemSubject;
        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
