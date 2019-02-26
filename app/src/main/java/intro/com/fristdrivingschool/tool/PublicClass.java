package intro.com.fristdrivingschool.tool;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.lang.ref.WeakReference;

import intro.com.fristdrivingschool.R;
import intro.com.fristdrivingschool.app.CommentActivity;
import intro.com.fristdrivingschool.app.SchoolDetailsActivity;
import intro.com.fristdrivingschool.app.TeacherDetaisActivity;

/**
 * Created by HFZS on 2018/3/21.
 */

public class PublicClass {

    /**
     * 判断是否有网络
     * */
    public static boolean isNetworkAvailable(Context context) {
        // 获取手机所有连接管理对象（包括对wi-fi,net等连接的管理）
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager == null) {
            return false;
        } else {// 获取NetworkInfo对象
            //   NetworkInfo[] networkInfo = connectivityManager.getAllNetworkInfo();
            NetworkInfo activeNetInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            NetworkInfo mobNetInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
            if (activeNetInfo.isConnected()) {//   Toast.makeText(context, "WIFI网络连接成功", Toast.LENGTH_SHORT).show();
                return true;
            }
            if (mobNetInfo.isConnected()) {// Toast.makeText(context, "手机网络连接成功", Toast.LENGTH_SHORT).show();
                return true;
            }
            if (!activeNetInfo.isConnected() && !mobNetInfo.isConnected()) {//   Toast.makeText(context, "网络断开连接", Toast.LENGTH_SHORT).show();
                return false;
            }
        }
        return false;
    }

    //下载图片
    public static void Picasso(Context context, String game_logage, ImageView img) {
        try {
                Glide.with(context).load(game_logage)
                        .placeholder(R.mipmap.ic_launcher)
                        .error(R.mipmap.ic_launcher).into(img);
        } catch (Exception e) {
            YCStringTool.logi(PublicClass.class,"错误" + e);
        }
    }

    /**
     * 初始化高度
     * */
    public static void setListViewHeightBasedOnChildren(ListView listView) {
        if (listView == null)
            return;
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return;
        }
        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }

    /**
     * 获取版本号
     * */
    public static int getLocalVersion(Context ctx) {
        int localVersion = 0;
        try {
            PackageInfo packageInfo = ctx.getApplicationContext()
                    .getPackageManager()
                    .getPackageInfo(ctx.getPackageName(), 0);
            localVersion = packageInfo.versionCode;
            Log.i("TAG", "本软件的版本号。。" + localVersion);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return localVersion;
    }

    /**
     * 设置沉浸模式
     * */
    public static void setTranslucentStatus(Activity context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // 透明状态栏
            context.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // 透明导航栏
            //getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            SystemStatusManager tintManager = new SystemStatusManager(context);
            tintManager.setStatusBarTintEnabled(true);
            tintManager.setStatusBarTintResource(getColor(context));//你要设置的颜色
            context.getWindow().getDecorView().setFitsSystemWindows(true);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = context.getWindow();
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(Color.TRANSPARENT);
            }
        }
    }
    /**
     * 设置标题栏颜色---更改主题时使用
     * views[0]  ---> TitleLayout   大的LineaLayout
     * views[1]  ---> TabLayout
     * views[2]  ---> TitleTV     头部标题
     * views[3]  ---> layoutBg//整体布局的背景
     * */
    public static void setThemeTopLayout(Context context,View... views){
        try {
            int key= SharedPreferencesUtils.getInt(context,"THEME");
            setTranslucentStatus((Activity) context);
            if(views[0]!=null)
                views[0].setBackgroundResource(getColor(context));
            if(views[1]!=null) {//TabLayout
                TabLayout tabLayouts= (TabLayout) views[1];
                if(key==27) {//夜间模式
                    tabLayouts.setTabTextColors(context.getResources().getColor(R.color.theme1),context.getResources().getColor(R.color.white));
                }
                else { //非夜间模式
                    tabLayouts.setTabTextColors(context.getResources().getColor(R.color.drak444),context.getResources().getColor(R.color.white));
                }
                tabLayouts.setBackgroundResource(getColor(context));
            }
            if(views[2]!=null) {
                if(key==27)
                    ((TextView) views[2]).setTextColor(context.getResources().getColor(R.color.white));
            /*else
                ((TextView) views[2]).setTextColor(R.color.white);*/
            }
            if(views[3]!=null&&key==27)//背景颜色
                views[3].setBackgroundResource(getColor(context));
            else
                views[3].setBackgroundResource(R.color.white);
            if(views[4]!=null)
                views[4].setBackgroundResource(getColor(context));
        }catch (ArrayIndexOutOfBoundsException e){}

    }



    /**
     * 系统默认颜色
     * */
    public static int getColor(Context context){
        int key= SharedPreferencesUtils.getInt(context,"THEME");
        switch (key){
            case 1:
                return R.color.color1;
            case 2:
                return R.color.color2;
            case 3:
                return R.color.color3;
            case 4:
                return R.color.color4;
            case 5:
                return R.color.color5;
            case 6:
                return R.color.color6;
            case 7:
                return R.color.color7;
            case 8:
                return R.color.color8;
            case 9:
                return R.color.color9;
            case 10:
                return R.color.color10;
            case 11:
                return R.color.color11;
            case 12:
                return R.color.color12;
            case 13:
                return R.color.color13;
            case 14:
                return R.color.color14;
            case 15:
                return R.color.color15;
            case 16:
                return R.color.color16;
            case 17:
                return R.color.color17;
            case 18:
                return R.color.color18;
            case 19:
                return R.color.color19;
            case 20:
                return R.color.color20;
            case 21:
                return R.color.color21;
            case 22:
                return R.color.color22;
            case 23:
                return R.color.color23;
            case 24:
                return R.color.color24;
            case 25:
                return R.color.color25;
            case 26:
                return R.color.color26;
            default:
                return R.color.color1;
        }
    }

    /**
     * 拨打电话（跳转到拨号界面，用户手动点击拨打）
     * @param phoneNum 电话号码
     */
    public static void diallPhone(Context context,String phoneNum) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        Uri data = Uri.parse("tel:" + phoneNum);
        intent.setData(data);
        context.startActivity(intent);
    }

    /**
     * 根据app包名打开指定app
     */
    public static void openAppForPackageName(Context context, String packageName) {
        final PackageManager pm = context.getPackageManager();
        Intent intent = pm.getLaunchIntentForPackage(packageName);
        context.getApplicationContext().startActivity(intent);
    }

    /**跳转教练详情页面*/
    public static void goToTeacherDetaisActivity(Activity context, String coach_id ){
        Bundle bundle=new Bundle();
        bundle.putString("coach_id",coach_id);
        ActivityUntil.next(context, TeacherDetaisActivity.class, bundle);
    }

    /**加载网络文件*/
    public static void putImage(Context context,String url,ImageView img){
        try {
            final WeakReference<ImageView> imageViewWeakReference = new WeakReference<>(img);
            ImageView target = imageViewWeakReference.get();
            if (target != null) {
                Glide.with(context).load(url)
                        .placeholder(R.mipmap.ic_launcher)
                        .error(R.mipmap.ic_launcher).into(target);
            }
        } catch (Exception e) {
            YCStringTool.logi(PublicClass.class,"错误" + e);
        }
    }

    /**跳转驾校详情*/
    public static void goToSchoolDetailsActivity(Activity context, String schoolId,String schoolName) {
        Bundle bundle=new Bundle();
        bundle.putString("schoolId",schoolId);
        bundle.putString("schoolName",schoolName);
        ActivityUntil.next(context,SchoolDetailsActivity.class,bundle);
    }

    /**跳转评论输入页面*/
    public static void goToCommentActivity(Activity context, String schoolId, String coachId) {
        Bundle bundle=new Bundle();
        bundle.putString("schoolId",schoolId);
        bundle.putString("coachId",coachId);
        ActivityUntil.next(context,CommentActivity.class,bundle);
    }
}
