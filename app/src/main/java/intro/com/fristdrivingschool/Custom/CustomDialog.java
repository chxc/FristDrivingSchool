package intro.com.fristdrivingschool.Custom;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import intro.com.fristdrivingschool.R;

/**
 * Created by HFZS on 2018/8/7.
 */

public class CustomDialog extends AlertDialog {
    private String message;
    private View.OnClickListener onEnsureListener;
    private View.OnClickListener onCancelListener;

    public CustomDialog(Context context) {
        super(context);
    }

    public CustomDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    protected CustomDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.dialog_custom_layout);

        WindowManager m = getWindow().getWindowManager();
        Display d = m.getDefaultDisplay();  //为获取屏幕宽、高
        android.view.WindowManager.LayoutParams p = getWindow().getAttributes();  //获取对话框当前的参数值
        p.width = (int) (d.getWidth() * 0.6);    //宽度设置为屏幕的0.5
        getWindow().setAttributes(p);     //设置生效

        TextView content = (TextView) findViewById(R.id.dialog_custom_layout_tip);
        TextView btn_sure = (TextView) findViewById(R.id.dialog_custom_layout_ensure);
        TextView btn_cancel = (TextView) findViewById(R.id.dialog_custom_layout_cancel);

        btn_cancel.setOnClickListener(onCancelListener);//取消监听
        btn_sure.setOnClickListener(onEnsureListener);//确定监听

        content.setText(message);
    }


    public void setMsg(String message) {
        this.message = message;
    }

    /**
     * 确定按钮
     */
    public void setOnEnsureListener(View.OnClickListener onEnsureListener) {
        this.onEnsureListener = onEnsureListener;
    }

    /**
     * 取消按钮
     */
    public void setOnCancelListener(View.OnClickListener onCancelListener) {
        this.onCancelListener = onCancelListener;
    }

}
