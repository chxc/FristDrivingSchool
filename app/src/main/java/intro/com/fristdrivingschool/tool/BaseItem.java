package intro.com.fristdrivingschool.tool;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by HFZS on 2018/5/29.
 * Item父类
 */

public abstract class BaseItem extends Fragment{

    private Context context;
    private View view;

    public BaseItem(Context context, View view) {
        this.context = context;
        this.view = view;
        initView(context,view);
        initEvent(context,view);
    }

    public abstract void initView(Context context,View view);//初始化视图
    public abstract void getData();//获取数据
    public abstract void initEvent(Context context, View view);//初始化监听

}
