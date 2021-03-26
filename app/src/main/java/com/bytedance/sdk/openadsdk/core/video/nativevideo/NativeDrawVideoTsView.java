package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.h.d;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.ak;

public class NativeDrawVideoTsView extends NativeVideoTsView implements View.OnClickListener {
    private boolean a = false;

    public NativeDrawVideoTsView(Context context, l lVar) {
        super(context, lVar);
        setOnClickListener(this);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    protected void b() {
        this.e = false;
        this.k = "draw_ad";
        p.h().s(String.valueOf(aj.d(this.b.aj())));
        super.b();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    protected void c() {
        if (this.a) {
            super.c();
        }
    }

    public void setCanInterruptVideoPlay(boolean z) {
        this.a = z;
    }

    public void a(Bitmap bitmap, int i) {
        i.d().a(bitmap);
        this.f1320l = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView, android.view.View
    protected void onWindowVisibilityChanged(int i) {
        if (this.h == null || this.h.getVisibility() != 0) {
            super.onWindowVisibilityChanged(i);
        } else {
            e();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        if (this.h == null || this.h.getVisibility() != 0) {
            super.onWindowFocusChanged(z);
        } else {
            e();
        }
    }

    private void d() {
        ak.a((View) this.f, 0);
        ak.a((View) this.g, 0);
        ak.a((View) this.i, 8);
    }

    private void e() {
        g();
        if (this.f != null) {
            if (this.f.getVisibility() != 0) {
                d.a(getContext()).a(this.b.R().h(), this.g);
            } else {
                return;
            }
        }
        d();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.h != null && this.h.getVisibility() == 0) {
            ak.f(this.f);
        }
        c();
    }
}
