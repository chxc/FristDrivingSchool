package intro.com.fristdrivingschool.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import intro.com.fristdrivingschool.R;
import intro.com.fristdrivingschool.tool.BaseFragment;

/**
 * Created by HFZS on 2018/7/5.
 *
 */

public class Home4Fragment extends BaseFragment {

    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.home4_layout,container,false);
        fristMethod();
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void getData(int... mark) {

    }

    @Override
    protected void initEvent() {

    }

    @Override
    public void onClick(View v) {

    }
}
