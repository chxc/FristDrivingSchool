package intro.com.fristdrivingschool.tool;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by HFZS on 2018/7/17.
 */

public abstract class BaseFragment extends Fragment implements View.OnClickListener {
    protected Activity activity;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }
    protected void fristMethod(){
        activity=getActivity();
        initData();
        initView();
        initEvent();
    }
    protected abstract void initData();//初始数据
    protected abstract void initView();//初始化视图
    protected abstract void getData(int... mark);//初始化数据，获取数据
    protected abstract void initEvent();//初始化时间，部分特殊监听回调
}
