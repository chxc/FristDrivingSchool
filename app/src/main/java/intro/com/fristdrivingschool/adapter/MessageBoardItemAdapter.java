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

/**
 * Created by HFZS on 2018/8/14.
 */

public class MessageBoardItemAdapter extends PublicAdapter {
    private Context context;
    private List<String> list;

    public MessageBoardItemAdapter(List<String> list, Context context) {
        super(list);
        this.context = context;
        this.list = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyHolder myHolder;
        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.message_board_item_layout, null);
            myHolder=new MyHolder(convertView);
            convertView.setTag(myHolder);
        }else{
            myHolder= (MyHolder) convertView.getTag();
        }
        myHolder.messageBoardItemName.setText("用户名"+position);
        myHolder.messageBoardItemContent.setText("评论内容"+position);
        return convertView;
    }

     class MyHolder {
        @BindView(R.id.message_board_item_icon)
        ImageView messageBoardItemIcon;
        @BindView(R.id.message_board_item_name)
        TextView messageBoardItemName;
        @BindView(R.id.message_board_item_content)
        TextView messageBoardItemContent;
        @BindView(R.id.message_board_item_time)
        TextView messageBoardItemTime;
        @BindView(R.id.message_board_item_reply)
        TextView messageBoardItemReply;

        MyHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
