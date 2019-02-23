package intro.com.fristdrivingschool.app.Home5;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.Request;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import intro.com.fristdrivingschool.R;
import intro.com.fristdrivingschool.base.BaseActivity;
import intro.com.fristdrivingschool.tool.ActivityUntil;
import intro.com.fristdrivingschool.tool.CustomToast;
import intro.com.fristdrivingschool.tool.Net.MyNetListener;
import intro.com.fristdrivingschool.tool.StaticValue;
import intro.com.fristdrivingschool.tool.YCStringTool;

public class RegisterActivity extends BaseActivity {

    @BindView(R.id.register_top_back)
    TextView registerTopBack;
    @BindView(R.id.register_top_layout)
    LinearLayout registerTopLayout;
    @BindView(R.id.register_phone)
    EditText registerPhone;
    @BindView(R.id.register_token)
    EditText registerToken;
    @BindView(R.id.register_gettokenBtu)
    Button registerGettokenBtu;
    @BindView(R.id.register_inputPsw)
    EditText registerInputPsw;
    @BindView(R.id.register_inputPswAgain)
    EditText registerInputPswAgain;
    @BindView(R.id.register_submit)
    TextView registerSubmit;

    private Context context;
    private String userPhone;
    private String userPassWord;
    private String userPassWordAgain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        context=this;
    }

    @Override
    protected void initTab() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.register_top_back://返回
                ActivityUntil.back((Activity) context);
                break;

            case R.id.register_submit://提交
                userPhone=registerPhone.getText().toString().trim();
                userPassWord=registerInputPsw.getText().toString().trim();
                userPassWordAgain=registerInputPswAgain.getText().toString().trim();
                if(YCStringTool.isNull(userPhone,userPassWord,userPassWordAgain)){
                    CustomToast.showToast(context,"所有信息不得为空！",2000);
                    return;
                }
                if(!userPassWordAgain.equalsIgnoreCase(userPassWord)){
                    CustomToast.showToast(context,"两次输入密码不相同！",2000);
                    return;
                }
                getData(1);
                break;
        }
    }

    @Override
    public void initData() {
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {

    }

    @Override
    public void getData(int... mark) {
        switch (mark[0]){
            case 1:
                Map<String,String> map=new HashMap<>();
                map.put("username",userPhone);
                map.put("password",userPassWord);
                MyNetListener.getString(context, Request.Method.POST,this,StaticValue.registerUrl,1,map);
                break;
        }
    }

    @Override
    public void success(String str, int mark, int... position) {
        switch (mark){
            case 1://提交
                YCStringTool.logi(this.context.getClass(),str);
                break;
        }
    }

    @Override
    public void error(String str, int mark, int... position) {

    }
}
