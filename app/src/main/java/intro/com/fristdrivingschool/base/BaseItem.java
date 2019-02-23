package intro.com.fristdrivingschool.base;

import android.content.Context;
import android.view.View;

public abstract class BaseItem {
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
    public abstract void initEvent(Context context, View view) /*throws Exception*/;//初始化监听
}
