package intro.com.fristdrivingschool.base;

import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by HFZS on 2018/7/17.
 */

public abstract class BaseFragment extends Fragment implements View.OnClickListener {

    public void fristMethod() {
        initView();
        initEvent();
        initTop();
    }
    protected abstract void initView();//初始化视图
    protected abstract void getData(int... mark);//初始化数据，获取数据
    protected abstract void initEvent();//初始化时间，部分特殊监听回调
    protected abstract void initTop();//初始化头部

}
