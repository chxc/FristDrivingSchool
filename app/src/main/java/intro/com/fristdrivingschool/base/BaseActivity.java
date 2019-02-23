package intro.com.fristdrivingschool.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import intro.com.fristdrivingschool.Custom.SwipeBackActivity;
import intro.com.fristdrivingschool.R;
import intro.com.fristdrivingschool.tool.Net.MyNetListener;
import intro.com.fristdrivingschool.tool.PublicClass;
import intro.com.fristdrivingschool.tool.SharedPreferencesUtils;


/**
 * Created by HFZS on 2018/8/21.
 */

public abstract class BaseActivity extends SwipeBackActivity implements View.OnClickListener,BaseFuncIml,MyNetListener.NetListener {

    public Activity activity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity=this;
    }

    public void initTheme(){
        int key= SharedPreferencesUtils.getInt(activity,"THEME");
        if(key==100)
            setTheme(R.style.TruanceDayNightTheme);
        else setTheme(R.style.TruanceTheme);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    /**
     * 在onPostCreate里面调用被实现后的各个方法
     * onPostCreate意思是在onCreate完全执行完成之后调用的方法，因为本类是抽象父类，
     * 若我们在onCreate里面调用各大init方法此时还未实现，故其为空，但当我们在onPostCreate里实现
     * 此时继承类已完成init方法的实现，故在此调用
     * */
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        initData();
        initView();
        initTab();
        initListener();
        PublicClass.setTranslucentStatus(activity);
    }

    protected abstract void initTab();
}
