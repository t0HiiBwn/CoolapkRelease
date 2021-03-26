package com.kk.taurus.playerbase.window;

import android.animation.Animator;
import android.content.Context;
import android.os.Build;
import android.view.MotionEvent;
import com.kk.taurus.playerbase.widget.BaseVideoView;
import com.kk.taurus.playerbase.window.IWindow;

public class WindowVideoView extends BaseVideoView implements IWindow {
    private IWindow.OnWindowListener mInternalWindowListener = new IWindow.OnWindowListener() {
        /* class com.kk.taurus.playerbase.window.WindowVideoView.AnonymousClass1 */

        @Override // com.kk.taurus.playerbase.window.IWindow.OnWindowListener
        public void onShow() {
            if (WindowVideoView.this.onWindowListener != null) {
                WindowVideoView.this.onWindowListener.onShow();
            }
        }

        @Override // com.kk.taurus.playerbase.window.IWindow.OnWindowListener
        public void onClose() {
            WindowVideoView.this.stop();
            WindowVideoView.this.resetStyle();
            if (WindowVideoView.this.onWindowListener != null) {
                WindowVideoView.this.onWindowListener.onClose();
            }
        }
    };
    private WindowHelper mWindowHelper;
    private IWindow.OnWindowListener onWindowListener;

    public WindowVideoView(Context context, FloatWindowParams floatWindowParams) {
        super(context);
        init(context, floatWindowParams);
    }

    private void init(Context context, FloatWindowParams floatWindowParams) {
        WindowHelper windowHelper = new WindowHelper(context, this, floatWindowParams);
        this.mWindowHelper = windowHelper;
        windowHelper.setOnWindowListener(this.mInternalWindowListener);
    }

    @Override // com.kk.taurus.playerbase.window.IWindow
    public void setOnWindowListener(IWindow.OnWindowListener onWindowListener2) {
        this.onWindowListener = onWindowListener2;
    }

    @Override // com.kk.taurus.playerbase.window.IWindow
    public void setDragEnable(boolean z) {
        this.mWindowHelper.setDragEnable(z);
    }

    @Override // com.kk.taurus.playerbase.window.IWindow
    public boolean isWindowShow() {
        return this.mWindowHelper.isWindowShow();
    }

    @Override // com.kk.taurus.playerbase.window.IWindow
    public void updateWindowViewLayout(int i, int i2) {
        this.mWindowHelper.updateWindowViewLayout(i, i2);
    }

    @Override // com.kk.taurus.playerbase.window.IWindow
    public boolean show() {
        return this.mWindowHelper.show();
    }

    @Override // com.kk.taurus.playerbase.window.IWindow
    public boolean show(Animator... animatorArr) {
        return this.mWindowHelper.show(animatorArr);
    }

    @Override // com.kk.taurus.playerbase.window.IWindow
    public void close() {
        setElevationShadow(0.0f);
        this.mWindowHelper.close();
    }

    @Override // com.kk.taurus.playerbase.window.IWindow
    public void close(Animator... animatorArr) {
        setElevationShadow(0.0f);
        this.mWindowHelper.close(animatorArr);
    }

    public void resetStyle() {
        setElevationShadow(0.0f);
        if (Build.VERSION.SDK_INT >= 21) {
            clearShapeStyle();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.mWindowHelper.onInterceptTouchEvent(motionEvent) || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mWindowHelper.onTouchEvent(motionEvent) || super.onTouchEvent(motionEvent);
    }
}
