package intro.com.fristdrivingschool.Custom;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;

/**
 * Created by HFZS on 2018/3/21.
 */

public class MyHorizontalScrollView extends HorizontalScrollView {

    private Handler mHandler;

    private ScrollViewListener scrollViewListener;

    /**
     * 滚动状态: IDLE=滚动停止 TOUCH_SCROLL=手指拖动滚动 FLING=滚动
     */
    enum ScrollType {
        IDLE, TOUCH_SCROLL, FLING
    };

    /**
     * 记录当前滚动的距离
     */
    private int currentX = -9999999;

    /**
     * 当前滚动状态
     */
    private ScrollType scrollType = ScrollType.IDLE;

    public interface ScrollViewListener {
        void onScrollChanged(ScrollType scrollType);
    }

    public MyHorizontalScrollView(Context context) {
        super(context);
        init();
    }

    public MyHorizontalScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyHorizontalScrollView(Context context, AttributeSet attrs,
                                  int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
		/*
		 * mHandler = new Handler(); scrollViewListener = new
		 * ScrollViewListener() {
		 *
		 * @Override public void onScrollChanged(ScrollType scrollType) { if
		 * (scrollType == ScrollType.TOUCH_SCROLL) { left = false; } else if
		 * (scrollType == ScrollType.FLING) { mark = false; }
		 *
		 * } };
		 */
    }

    /**
     * 滚动监听runnable
     */
    private Runnable scrollRunnable = new Runnable() {
        @Override
        public void run() {
            if (getScrollX() == currentX) {
                // 滚动停止,取消监听线程
                scrollType = ScrollType.IDLE;
                if (scrollViewListener != null) {
                    scrollViewListener.onScrollChanged(scrollType);
                }
                mHandler.removeCallbacks(this);
                return;
            } else {
                // 手指离开屏幕,但是view还在滚动
                scrollType = ScrollType.FLING;
                if (scrollViewListener != null) {
                    scrollViewListener.onScrollChanged(scrollType);
                }
            }
            currentX = getScrollX();
            // 滚动监听间隔:milliseconds
            mHandler.postDelayed(this, 50);
        }
    };

    public static boolean lock;
    public static boolean left = true;

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if(left){
                    lock = false;
                }else {
                    lock = true;
                }
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                lock = false;
                break;
            case MotionEvent.ACTION_CANCEL:lock = false;
        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if(left){
                    lock = false;
                }else {
                    lock = true;
                }
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:lock = false;
                break;
            case MotionEvent.ACTION_CANCEL:lock = false;
                break;
        }
        return super.onTouchEvent(ev);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        // TODO Auto-generated method stub
        super.onScrollChanged(l, t, oldl, oldt);
        int maxScrollX = getChildAt(0).getMeasuredWidth() - getMeasuredWidth();
        if (getScrollX() == 0) {
            left = true;
            lock = false;
        } else if (getScrollX() == maxScrollX) {
            left = false;
            lock = false;
        } else {
            left = false;
            lock = false;
        }
    }

}
