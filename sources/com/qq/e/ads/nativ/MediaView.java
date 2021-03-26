package com.qq.e.ads.nativ;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.util.GDTLogger;

public final class MediaView extends FrameLayout {
    private int a;
    private int b;

    public MediaView(Context context) {
        super(context);
    }

    public MediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MediaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.view.View, android.view.ViewGroup
    protected final void onAttachedToWindow() {
        GDTLogger.d("onAttachedToWindow");
        super.onAttachedToWindow();
        if (Build.VERSION.SDK_INT >= 11 && !isHardwareAccelerated()) {
            GDTLogger.e("Hardware acceleration is off");
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected final void onMeasure(int i, int i2) {
        if ((SDKStatus.getSDKVersionCode() == 11 || SDKStatus.getSDKVersionCode() == 12) && this.a > 0 && this.b > 0) {
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            int i3 = this.b;
            int i4 = size * i3;
            int i5 = this.a;
            if (i4 < i5 * size2 || size2 == 0) {
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec((size * this.b) / this.a, 1073741824);
                i = makeMeasureSpec;
            } else {
                i = (size * i3 > i5 * size2 || size == 0) ? View.MeasureSpec.makeMeasureSpec((i5 * size2) / i3, 1073741824) : View.MeasureSpec.makeMeasureSpec(size, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2, 1073741824);
            }
        }
        super.onMeasure(i, i2);
    }

    public final void setRatio(int i, int i2) {
        this.a = i;
        this.b = i2;
    }
}
