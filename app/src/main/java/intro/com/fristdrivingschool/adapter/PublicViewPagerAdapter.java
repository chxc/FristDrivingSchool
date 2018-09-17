package intro.com.fristdrivingschool.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by HFZS on 2018/7/5.
 */

public class PublicViewPagerAdapter extends PagerAdapter {
    private List<View> list;
    private List<String> listTag;

    public PublicViewPagerAdapter(List<View> list, List<String> listTag) {
        this.list = list;
        this.listTag = listTag;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        container.addView(list.get(position),0);
        return list.get(position);
    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView(list.get(position));
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
       /* if(listTab!=null){
            if(listTab.size()==list.size()){*/
        return listTag.get(position);
            /*}
        }
        return super.getPageTitle(position);*/
    }
}
