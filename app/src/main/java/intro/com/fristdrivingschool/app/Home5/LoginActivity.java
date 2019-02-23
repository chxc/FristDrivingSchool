package intro.com.fristdrivingschool.app.Home5;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
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
import intro.com.fristdrivingschool.tool.SharedPreferencesUtils;
import intro.com.fristdrivingschool.tool.StaticValue;
import intro.com.fristdrivingschool.tool.YCStringTool;

/**
 * 登陆页面
 */
public class LoginActivity extends BaseActivity {

    @BindView(R.id.login_closed)
    TextView loginClosed;
    @BindView(R.id.login_username)
    EditText loginUsername;
    @BindView(R.id.login_username_clear)
    ImageView loginUsernameClear;
    @BindView(R.id.login_pwd)
    EditText loginPwd;
    @BindView(R.id.login_pwd_clear)
    ImageView loginPwdClear;
    @BindView(R.id.login_remember)
    CheckBox loginRemember;
    @BindView(R.id.login_loginBtu)
    TextView loginLoginBtu;
    @BindView(R.id.login_forget)
    TextView loginForget;
    @BindView(R.id.login_register)
    TextView loginRegister;
    @BindView(R.id.activity_login)
    LinearLayout activityLogin;
    private Context context;

    private String userName;
    private String userPassWord;
    private boolean loginRemeberValue=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        context = this;
    }

    @Override
    protected void initTab() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.login_closed://关闭
                ActivityUntil.back((Activity) context);
                break;

            case R.id.login_loginBtu://登陆
                userName=loginUsername.getText().toString().trim();
                userPassWord=loginPwd.getText().toString().trim();
                if(YCStringTool.isNull(userName,userPassWord)){
                    CustomToast.showToast(context,"账户密码不可为空！",2000);
                    return;
                }
                if(loginRemeberValue){
                    SharedPreferencesUtils.savaString(context,SharedPreferencesUtils.userNameValue,userName);
                    SharedPreferencesUtils.savaString(context,SharedPreferencesUtils.userPasswordValue,userPassWord);
                }
                getData(1);
                break;

            case R.id.login_register://注册
                ActivityUntil.next((Activity) context,RegisterActivity.class,null);
                break;

            case R.id.login_forget://忘记密码

                break;

            case R.id.login_remember://自动登陆
                loginRemeberValue=loginRemeberValue^true;
                YCStringTool.logi(this.context.getClass(),"自动登陆"+loginRemeberValue);;
                SharedPreferencesUtils.savaBoolean(context,SharedPreferencesUtils.loginRememberValue,loginRemeberValue);
                break;
        }
    }

    @Override
    public void initData() {
        loginRemeberValue=SharedPreferencesUtils.getBoolean(context,SharedPreferencesUtils.loginRememberValue);
        userName=SharedPreferencesUtils.getString(context,SharedPreferencesUtils.userNameValue);
        userPassWord=SharedPreferencesUtils.getString(context,SharedPreferencesUtils.userPasswordValue);

        loginRemember.setChecked(loginRemeberValue);//设置自动登陆按钮
        loginUsername.setText(userName);//设置用户名
        loginPwd.setText(userPassWord);//设置用户密码
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
                Map<String, String> loginMap = new HashMap<>();
                loginMap.put("username", userName);
                loginMap.put("password", userPassWord);
                MyNetListener.getString(context, Request.Method.POST, this,
                        StaticValue.loginURL, 1, loginMap);
                break;
        }

    }

    @Override
    public void success(String str, int mark, int... position) {
        YCStringTool.logi(this.getClass(), "登陆界面" + str);
    }

    @Override
    public void error(String str, int mark, int... position) {
        YCStringTool.logi(this.getClass(), "登陆界面" + str);
    }
}
