package com.tencent.android.tpush.inappmessage;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.os.Build;
import android.view.Window;
import android.widget.RelativeLayout;
import com.tencent.android.tpush.logging.TLogger;

/* compiled from: ProGuard */
public class c extends h {
    @Override // com.tencent.android.tpush.inappmessage.a
    boolean d() {
        return false;
    }

    @Override // com.tencent.android.tpush.inappmessage.a, android.app.Dialog, android.content.DialogInterface
    public /* bridge */ /* synthetic */ void cancel() {
        super.cancel();
    }

    public c(Activity activity, d dVar, Intent intent) {
        super(activity, dVar, intent);
    }

    @Override // com.tencent.android.tpush.inappmessage.a
    protected void e() {
        Window window = getWindow();
        if (window != null) {
            window.addFlags(2);
            if (Build.VERSION.SDK_INT >= 14) {
                window.setDimAmount(0.7f);
            }
        }
    }

    @Override // com.tencent.android.tpush.inappmessage.a
    protected RelativeLayout.LayoutParams b() {
        Point a = i.a(this.b);
        int a2 = i.a(this.b, (float) this.d.a());
        int a3 = i.a(this.b, (float) this.d.b());
        TLogger.i("Center Popup", "size.x = " + a.x + ", size.y =" + a.y + "width = " + a2 + ", height =" + a3);
        int i = a.x - i.d;
        int i2 = a.y - i.d;
        double d = (double) a2;
        double d2 = d / ((double) a3);
        if (a2 > i && ((int) (d / d2)) < i2) {
            a3 = (int) (((double) i) / d2);
            a2 = i;
        }
        if (a3 <= i2 || ((int) (((double) a3) * d2)) >= i) {
            i2 = a3;
        } else {
            a2 = (int) (((double) i2) * d2);
        }
        TLogger.i("Center Popup", "InAppMsg LayoutParams width = " + a2 + ", height = " + i2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a2, -2);
        layoutParams.addRule(13, -1);
        return layoutParams;
    }
}
