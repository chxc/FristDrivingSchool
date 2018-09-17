package intro.com.fristdrivingschool.adapter;

import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by HFZS on 2018/5/28.
 */

public abstract  class PublicAdapter<T> extends BaseAdapter {
    private List<T> list;

    public PublicAdapter(List<T> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
