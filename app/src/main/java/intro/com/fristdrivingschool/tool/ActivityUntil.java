package intro.com.fristdrivingschool.tool;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import intro.com.fristdrivingschool.R;

/**
 * Created by HFZS on 2018/3/21.
 */

public class ActivityUntil {
    public static List<Activity> activities = new ArrayList<Activity>();
    public static long lastTime=0;
    public static <T> void next(Activity from, Class<T> to, Bundle bundle) {
        if(System.currentTimeMillis()-lastTime<600){
            return;
        }
        lastTime=System.currentTimeMillis();
        Intent intent = new Intent(from, to);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        from.startActivity(intent);
        from.overridePendingTransition(R.anim.push_left_in,
                R.anim.push_left_out);
    }

    public static void back(Activity from) {
        from.finish();
        from.overridePendingTransition(R.anim.push_right_in,
                R.anim.push_right_out);
    }
}
