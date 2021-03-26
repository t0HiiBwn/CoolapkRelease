package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import com.bytedance.sdk.openadsdk.utils.u;

public class TTScrollView extends ScrollView {
    private int a;
    private boolean b = false;
    private a c;
    private boolean d = false;

    public interface a {
        void a(boolean z);
    }

    public TTScrollView(Context context) {
        super(context);
    }

    public TTScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TTScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View, android.view.ViewGroup
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.b) {
            try {
                this.b = true;
                View childAt = ((ViewGroup) getChildAt(0)).getChildAt(1);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                layoutParams.height = getHeight();
                childAt.setLayoutParams(layoutParams);
            } catch (Throwable th) {
                u.f("TTScrollView", "onLayout error" + th.toString());
            }
        }
    }

    public void setListener(a aVar) {
        this.c = aVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0037, code lost:
        if (getScrollY() == 0) goto L_0x0039;
     */
    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        a aVar;
        boolean z = true;
        if (motionEvent.getAction() == 1 && getScrollY() < this.a) {
            if (getScrollY() > this.a / 2) {
                post(new Runnable() {
                    /* class com.bytedance.sdk.openadsdk.core.widget.TTScrollView.AnonymousClass1 */

                    @Override // java.lang.Runnable
                    public void run() {
                        TTScrollView tTScrollView = TTScrollView.this;
                        tTScrollView.smoothScrollTo(0, tTScrollView.a);
                    }
                });
            } else {
                if (getScrollY() > 0) {
                    post(new Runnable() {
                        /* class com.bytedance.sdk.openadsdk.core.widget.TTScrollView.AnonymousClass2 */

                        @Override // java.lang.Runnable
                        public void run() {
                            TTScrollView.this.smoothScrollTo(0, 0);
                        }
                    });
                }
                aVar = this.c;
                if (!(aVar == null || z == this.d)) {
                    aVar.a(z);
                }
                this.d = z;
            }
            z = false;
            aVar = this.c;
            aVar.a(z);
            this.d = z;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.onOverScrolled(i, i2, z, z2);
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.a = getChildAt(0).getMeasuredHeight();
        post(new Runnable() {
            /* class com.bytedance.sdk.openadsdk.core.widget.TTScrollView.AnonymousClass3 */

            @Override // java.lang.Runnable
            public void run() {
                TTScrollView tTScrollView = TTScrollView.this;
                tTScrollView.smoothScrollTo(0, tTScrollView.a);
            }
        });
    }

    public boolean a() {
        return this.d;
    }
}
