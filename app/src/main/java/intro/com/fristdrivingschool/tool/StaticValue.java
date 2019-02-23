package intro.com.fristdrivingschool.tool;

import android.content.Context;

/**
 * Created by HFZS on 2018/12/24.
 */

public class StaticValue {

    public static final String PATH="http://topyc.xyz?service=";
    public static final String  home1="App.Index.Index";//首页接口
    public static final String  loginURL="App.User.Login";//登陆接口
    public static final String  registerUrl="App.User.Register";//注册页面

    public static final String  coachDetails="App.School.Coach";//教练详情

    /*-----------------------------         静态值         -------------------------------*/

    private static String useId="";//用户id


    /*-------------------------      静态值获取方法     -------------------------------*/
    /** 获取用户id* */
    public synchronized static String getUseId(Context context){
        if(YCStringTool.isNull(useId)){
            useId=SharedPreferencesUtils.getString(context,SharedPreferencesUtils.USERID);
        }
        return useId;
    }

}
