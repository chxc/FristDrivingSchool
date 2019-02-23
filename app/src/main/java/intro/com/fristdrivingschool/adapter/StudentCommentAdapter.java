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
/**学员评价*/
public class StudentCommentAdapter extends PublicAdapter {
    private Context context;
    private List<String> list;

    public StudentCommentAdapter(Context context, List<String> list) {
        super(list);
        this.context = context;
        this.list = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.student_comment_item_layout, null);
            viewHolder=new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else
            viewHolder= (ViewHolder) convertView.getTag();
        viewHolder.studentCommentItemName.setText(""+list.get(position));
        return convertView;
    }

    class ViewHolder {
        @BindView(R.id.student_comment_item_icon)
        ImageView studentCommentItemIcon;
        @BindView(R.id.student_comment_item_name)
        TextView studentCommentItemName;
        @BindView(R.id.student_comment_item_content)
        TextView studentCommentItemContent;
        @BindView(R.id.student_comment_item_time)
        TextView studentCommentItemTime;
        @BindView(R.id.student_comment_item_praise)
        TextView studentCommentItemPraise;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
