package intro.com.fristdrivingschool.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;

import java.util.List;

import intro.com.fristdrivingschool.R;

/**
 * Created by HFZS on 2018/8/7.
 */

public class FlowLayoutTagAdapter extends TagAdapter<String> {
    private List<String> list;
    private Context context;
    public FlowLayoutTagAdapter(Context context,List<String> list) {
        super(list);
        this.context=context;
        this.list=list;
    }


    @Override
    public View getView(FlowLayout parent, int position, String s) {
        View view=LayoutInflater.from(context).inflate(R.layout.tag_item_layout,parent,false);
        switch (position%5) {
            case 0:
                view.setBackgroundResource(R.drawable.shape_solid_color1_5dp);
                break;
            case 1:
                view.setBackgroundResource(R.drawable.shape_solid_color2_5dp);
                break;
            case 2:
                view.setBackgroundResource(R.drawable.shape_solid_color3_5dp);
                break;
            case 3:
                view.setBackgroundResource(R.drawable.shape_solid_color4_5dp);
                break;
            case 4:
                view.setBackgroundResource(R.drawable.shape_solid_color5_5dp);
                break;
        }
        ((TextView)view).setText(list.get(position));
        return view;
    }
}
