package intro.com.fristdrivingschool;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import intro.com.fristdrivingschool.adapter.HomeFragmentAdapter;
import intro.com.fristdrivingschool.app.Home1Fragment;
import intro.com.fristdrivingschool.app.Home3Fragment;
import intro.com.fristdrivingschool.app.Home5Fragment;
import intro.com.fristdrivingschool.tool.PublicClass;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.main_fragment_viewpager)
    ViewPager mainFragmentViewpager;
    @BindView(R.id.activity_main)
    LinearLayout activityMain;
    @BindView(R.id.main_tab)
    TabLayout mainTab;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context=this;
        PublicClass.setTranslucentStatus((Activity) context);
        ButterKnife.bind(this);
        initView();
    }

    //初始化视图
    private void initView() {
        List<Fragment> listFragment = new ArrayList<>();

        Home1Fragment home1Fragment = new Home1Fragment();
        //Home2Fragment home2Fragment = new Home2Fragment();
        Home3Fragment home3Fragment = new Home3Fragment();
        //Home4Fragment home4Fragment = new Home4Fragment();
        Home5Fragment home5Fragment = new Home5Fragment();

        listFragment.add(home1Fragment);
        //listFragment.add(home2Fragment);
        listFragment.add(home3Fragment);
        //listFragment.add(home4Fragment);
        listFragment.add(home5Fragment);

        List<String> listTab=new ArrayList<>();
        listTab.add("预约");
        //listTab.add("资讯");
        listTab.add("学习");
        //listTab.add("4");
        listTab.add("个人中心");

        FragmentManager fragmentManager = getSupportFragmentManager();
        HomeFragmentAdapter homeFragmentAdapter = new HomeFragmentAdapter(fragmentManager, listFragment, listTab);
        mainFragmentViewpager.setAdapter(homeFragmentAdapter);
        mainTab.setupWithViewPager(mainFragmentViewpager,true);//设置关联ViewPagerTab
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

        }
    }

    private long exitTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK
                && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Toast.makeText(getApplicationContext(), "再按一次返回键退出应用",
                        Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
