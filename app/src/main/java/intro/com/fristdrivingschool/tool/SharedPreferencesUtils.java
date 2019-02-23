package intro.com.fristdrivingschool.tool;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;


/**
 * Created by HFZS on 2018/5/30.
 * THEME：主题颜色
 * FIRST_INIT  第一次启动
 */

public class SharedPreferencesUtils {
    private final static String APP_SING="ZSSING";//标签

    public final static String USERID="userId";//用户ID
    public final static String loginRememberValue="loginRememberValue";//登陆页面自动登陆
    public final static String userNameValue="userNameValue";//登陆页面自动登陆
    public final static String userPasswordValue="userPasswordValue";//登陆页面自动登陆

    public static void savaString(Context context, String key, String value) {
        SharedPreferences preferences = context.getSharedPreferences(APP_SING,
                Activity.MODE_PRIVATE);
        Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static void savaBoolean(Context context, String key, Boolean value) {
        SharedPreferences preferences = context.getSharedPreferences(APP_SING,
                Activity.MODE_PRIVATE);
        Editor editor = preferences.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    public static void savaInt(Context context, String key, int value) {
        SharedPreferences preferences = context.getSharedPreferences(APP_SING,
                Activity.MODE_PRIVATE);
        Editor editor = preferences.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public static void savaLong(Context context, String key, Long value) {
        SharedPreferences preferences = context.getSharedPreferences(APP_SING,
                Activity.MODE_PRIVATE);
        Editor editor = preferences.edit();
        editor.putLong(key, value);
        editor.commit();
    }

    public static String getString(Context context, String key) {
        SharedPreferences preferences = context.getSharedPreferences(APP_SING,
                Activity.MODE_PRIVATE);
        return preferences.getString(key, null);

    }

    public static boolean getBoolean(Context context, String key) {
        if(context==null)
            return false;
        SharedPreferences preferences = context.getSharedPreferences(APP_SING,
                Activity.MODE_PRIVATE);
        return preferences.getBoolean(key, false);
    }

    public static int getInt(Context context, String key) {
        SharedPreferences preferences = context.getSharedPreferences(APP_SING,
                Activity.MODE_PRIVATE);
        return preferences.getInt(key, 0);
    }

    public static Long getLong(Context context, String key) {
        SharedPreferences preferences = context.getSharedPreferences(APP_SING,
                Activity.MODE_PRIVATE);
        return preferences.getLong(key, 0L);
    }

    public static void RemoveString(Context context, String key) {
        SharedPreferences preferences = context.getSharedPreferences(APP_SING,
                Activity.MODE_PRIVATE);
        Editor editor = preferences.edit();
        editor.remove(key);
        editor.commit();
    }
}
