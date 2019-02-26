package intro.com.fristdrivingschool.tool;

import android.util.Log;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 处理字符串类
 * */
public class YCStringTool {

    //将指定字符串拆分多次打印
    public static void SplitStr(String str, int mark) {
        int start = 0;
        int end = 0;
        for (int i = 1; i <= mark; i++) {
            if (i != mark) {
                end = (str.length() / mark) * i;
                Log.i("TAG123456","SplitStr:" + i + " -q-->" + str.substring(start, end));
                start = end;
            } else {
                Log.i("TAG123456","SplitStr:" + i + " --->"+ str.substring(start, str.length()));
            }
        }
    }

    public static void logi(Class c,String str) {
        Log.i("TAG123456","11    \n"+c.getName()+"\n -------------->"+ str);
    }

    /**
     * 判断是否为空  若存在就返回
     * */
    public static boolean isNull(String... str) {
        for (int i = 0; i < str.length; i++) {
            if (str[i] == null)
                return true;
            if (str[i].length() == 0)
                return true;
        }
        return false;
    }

    public static String forMatTime(long time) {// 格式化时间
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
        return formatter.format(time);
    }

    public static String forMatTimeData(long time) {
        time*=1000;
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(time);
    }

    public static String forMatTimeDataForZBW(String time) {
        long timel = Long.parseLong(time);
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(timel);
    }


    // 自定义时间格式
    public static String forMatTimeDataForYouSelf(long time,DateFormat formatter) {
        return formatter.format(time);
    }

    public static CharSequence getTime(long time) {
        time = time * 1000;
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        if (formatter == null)
            formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return formatter.format(new Date(time));
    }

    /**
     * 强制保留小数点后两位
     * */
    public static double formatDouble(double str){
        DecimalFormat df = new DecimalFormat("00.0");
        return  Double.parseDouble(df.format(str));
    }

    /**
     * 根据传值、判断显示MB还是KB
     * */
    public static String formatKbOrMb(double str){
        if(str>(1024*1024)){//文件大小大于1MB
            return formatDouble(str/(1024.0*1024.0))+"M";
        }else {//文件大小小于1MB
            return formatDouble(str/(1024.0))+"K";
        }
    }

}