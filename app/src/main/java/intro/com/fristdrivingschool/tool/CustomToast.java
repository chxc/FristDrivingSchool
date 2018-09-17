package intro.com.fristdrivingschool.tool;


import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

public class CustomToast {

	private static Toast mToast;
	private static Handler mhandler = new Handler();
	private static Runnable r = new Runnable() {
		public void run() {
			mToast.cancel();
		};
	};

	public static void showToast(Context context, String text, int duratjion) {
		if(context!=null){
			mhandler.removeCallbacks(r);
			if (null != mToast) {
				mToast.setText(text);
			} else {
				mToast = Toast.makeText(context, text, Toast.LENGTH_LONG);
			}
			mhandler.postDelayed(r, 5000);
			mToast.show();
		}
	}
}