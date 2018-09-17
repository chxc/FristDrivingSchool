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

    public final static String SEARCH_NUM="search_num";//搜索下标
    public final static String SEARCH_CONTEN="search_content";//搜索保存的前缀
    public final static String HOME_DATA_new="home_data_news";//首页最新数据
    public final static String HOME_BANNER="home_banner";//首页Banner
    public final static String HOME_DATA_quality="home_data_quality";//首页最新数据
    public final static String FIRST_INIT="first_init";//第一次启动

    public final static String HIDEBAR="pref_actionbar_switch";//隐藏操作栏
    public final static String LOCKLANDSCAPE="lockLandscapeValue";//锁定横屏

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
