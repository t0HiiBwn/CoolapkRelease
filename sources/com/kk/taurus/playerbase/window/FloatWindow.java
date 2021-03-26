package com.kk.taurus.playerbase.window;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.kk.taurus.playerbase.style.IStyleSetter;
import com.kk.taurus.playerbase.style.StyleSetter;
import com.kk.taurus.playerbase.window.IWindow;

public class FloatWindow extends FrameLayout implements IWindow, IStyleSetter {
    private IWindow.OnWindowListener mInternalWindowListener = new IWindow.OnWindowListener() {
        /* class com.kk.taurus.playerbase.window.FloatWindow.AnonymousClass1 */

        @Override // com.kk.taurus.playerbase.window.IWindow.OnWindowListener
        public void onShow() {
            if (FloatWindow.this.onWindowListener != null) {
                FloatWindow.this.onWindowListener.onShow();
            }
        }

        @Override // com.kk.taurus.playerbase.window.IWindow.OnWindowListener
        public void onClose() {
            FloatWindow.this.resetStyle();
            if (FloatWindow.this.onWindowListener != null) {
                FloatWindow.this.onWindowListener.onClose();
            }
        }
    };
    private IStyleSetter mStyleSetter;
    private WindowHelper mWindowHelper;
    private IWindow.OnWindowListener onWindowListener;

    public FloatWindow(Context context, View view, FloatWindowParams floatWindowParams) {
        super(context);
        if (view != null) {
            addView(view);
        }
        this.mStyleSetter = new StyleSetter(this);
        WindowHelper windowHelper = new WindowHelper(context, this, floatWindowParams);
        this.mWindowHelper = windowHelper;
        windowHelper.setOnWindowListener(this.mInternalWindowListener);
    }

    @Override // com.kk.taurus.playerbase.window.IWindow
    public void setOnWindowListener(IWindow.OnWindowListener onWindowListener2) {
        this.onWindowListener = onWindowListener2;
    }

    @Override // com.kk.taurus.playerbase.style.IStyleSetter
    public void setRoundRectShape(float f) {
        this.mStyleSetter.setRoundRectShape(f);
    }

    @Override // com.kk.taurus.playerbase.style.IStyleSetter
    public void setRoundRectShape(Rect rect, float f) {
        this.mStyleSetter.setRoundRectShape(rect, f);
    }

    @Override // com.kk.taurus.playerbase.style.IStyleSetter
    public void setOvalRectShape() {
        this.mStyleSetter.setOvalRectShape();
    }

    @Override // com.kk.taurus.playerbase.style.IStyleSetter
    public void setOvalRectShape(Rect rect) {
        this.mStyleSetter.setOvalRectShape(rect);
    }

    @Override // com.kk.taurus.playerbase.style.IStyleSetter
    public void clearShapeStyle() {
        this.mStyleSetter.clearShapeStyle();
    }

    @Override // com.kk.taurus.playerbase.style.IStyleSetter
    public void setElevationShadow(float f) {
        setElevationShadow(-16777216, f);
    }

    @Override // com.kk.taurus.playerbase.style.IStyleSetter
    public void setElevationShadow(int i, float f) {
        setBackgroundColor(i);
        ViewCompat.setElevation(this, f);
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
