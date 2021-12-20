package com.yc.banner.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

/**
 * <pre>
 *     @author 杨充
 *     blog  : https://github.com/yangchong211
 *     time  : 2019/6/20
 *     desc  : 自定义ViewPager，主要是处理边界极端情况
 *     revise:
 * </pre>
 */
public class BannerViewPager extends ViewPager {

    private boolean scrollable = true;

    public BannerViewPager(Context context) {
        super(context);
    }

    public BannerViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if(this.scrollable) {
            if (getCurrentItem() == 0 && getChildCount() == 0) {
                return false;
            }
            //捕获滑动过程中，和其他控件组合起来用时，可能出现的异常
            try {
                return super.onTouchEvent(ev);
            } catch (IllegalArgumentException ex) {
                ex.printStackTrace();
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if(this.scrollable) {
            if (getCurrentItem() == 0 && getChildCount() == 0) {
                return false;
            }
            //捕获滑动过程中，和其他控件组合起来用时，可能出现的异常
            try {
                return super.onInterceptTouchEvent(ev);
            } catch (IllegalArgumentException ex) {
                ex.printStackTrace();
                return false;
            }
        } else {
            return false;
        }
    }

    public void setScrollable(boolean scrollable) {
        this.scrollable = scrollable;
    }
}