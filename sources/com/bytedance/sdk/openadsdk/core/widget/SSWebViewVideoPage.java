package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import androidx.core.view.ScrollingView;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;

public class SSWebViewVideoPage extends SSWebView {
    private boolean a = true;
    private float b = -1.0f;
    private boolean c = false;
    private ViewParent d;

    public SSWebViewVideoPage(Context context) {
        super(context);
    }

    public SSWebViewVideoPage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SSWebViewVideoPage(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView, android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.d == null) {
            this.d = a(this);
        }
        if (motionEvent.getAction() == 0) {
            this.b = motionEvent.getY();
        } else if (motionEvent.getAction() == 2) {
            float y = motionEvent.getY() - this.b;
            int i = (y > 0.0f ? 1 : (y == 0.0f ? 0 : -1));
            if (i > 0) {
                a(true);
            } else if (i != 0 && y < 0.0f) {
                a(false);
            }
            this.b = motionEvent.getY();
        } else if (motionEvent.getAction() == 1) {
            a();
            this.c = false;
        } else if (motionEvent.getAction() == 3) {
            a();
            this.c = false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void a(boolean z) {
        if (((ScrollView) this.d).getScrollY() == 0) {
            if (z) {
                a();
            } else {
                b();
            }
        } else if (!this.a) {
            a();
        } else if (z) {
            b();
        } else {
            a();
        }
    }

    public void a() {
        if (!this.c) {
            this.d.requestDisallowInterceptTouchEvent(true);
            this.c = true;
        }
    }

    public void b() {
        if (!this.c) {
            this.d.requestDisallowInterceptTouchEvent(false);
            this.c = true;
        }
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.onOverScrolled(i, i2, z, z2);
        if (i2 != 0 || !z2) {
            this.a = false;
        } else {
            this.a = true;
        }
    }

    private ViewParent a(View view) {
        ViewParent parent = view.getParent();
        return ((parent instanceof ViewPager) || (parent instanceof AbsListView) || (parent instanceof ScrollView) || (parent instanceof HorizontalScrollView) || (parent instanceof ScrollingView) || !(parent instanceof View)) ? parent : a((View) parent);
    }
}
