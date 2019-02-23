package intro.com.fristdrivingschool.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import intro.com.fristdrivingschool.Custom.RecyclerImageView;
import intro.com.fristdrivingschool.R;
import intro.com.fristdrivingschool.tool.PublicClass;

/**图片适配器*/
public class PictureAdapter extends PublicAdapter {
    private Context context;
    private List<String> list;

    public PictureAdapter(Context context, List<String> list) {
        super(list);
        this.context = context;
        this.list = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.picture_item_layout, null);
            viewHolder=new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else
            viewHolder= (ViewHolder) convertView.getTag();
        PublicClass.putImage(context.getApplicationContext(),list.get(position),viewHolder.pictureItemImg);
        return convertView;
    }

    class ViewHolder {
        @BindView(R.id.picture_item_img)
        RecyclerImageView pictureItemImg;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
