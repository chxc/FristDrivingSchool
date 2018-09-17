package intro.com.fristdrivingschool.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by HFZS on 2018/7/6.
 * 首页Fragment适配器
 */

public class HomeFragmentAdapter extends FragmentPagerAdapter {

    private FragmentManager fm;
    private List<Fragment> list;
    private List<String> listTag;

    public HomeFragmentAdapter(FragmentManager fm, List<Fragment> list, List<String> listTag) {
        super(fm);
        this.fm = fm;
        this.list = list;
        this.listTag = listTag;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return listTag.get(position);
    }
}
