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

public class SchoolLocationAdapter extends PublicAdapter {

    private Context context;
    private List<Object> list;

    public SchoolLocationAdapter(Context context, List<Object> list) {
        super(list);
        this.context = context;
        this.list = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.school_location_item_layout, null);
            viewHolder=new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else
            viewHolder= (ViewHolder) convertView.getTag();
        return convertView;
    }

    class ViewHolder {
        @BindView(R.id.school_location_item_address)
        TextView schoolLocationItemAddress;
        @BindView(R.id.school_location_item_distance)
        TextView schoolLocationItemDistance;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
