package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.h;
import com.bytedance.sdk.openadsdk.h.d;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.ak;

public class ExpressVideoView extends NativeVideoTsView implements View.OnClickListener {
    protected int a;
    private boolean p = false;

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    protected void a(boolean z) {
    }

    public ExpressVideoView(Context context, l lVar, String str) {
        super(context, lVar, false, false, str, false, false);
        if ("draw_ad".equals(str)) {
            this.p = true;
        }
        setOnClickListener(this);
        setNeedNativeVideoPlayBtnVisible(false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    protected void b() {
        this.e = false;
        int d = aj.d(this.b.aj());
        if ("banner_ad".equalsIgnoreCase(this.k)) {
            p.h().s(String.valueOf(d));
        }
        super.b();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    protected void c() {
        if (this.p) {
            super.b(this.a);
        }
    }

    public void setCanInterruptVideoPlay(boolean z) {
        this.p = z;
    }

    public void setVideoPlayStatus(int i) {
        this.a = i;
    }

    public void setShouldCheckNetChange(boolean z) {
        if (this.c != null) {
            this.c.f(z);
        }
    }

    public void d() {
        if (this.i != null) {
            ak.a((View) this.i, 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView, android.view.View
    protected void onWindowVisibilityChanged(int i) {
        if (this.h == null || this.h.getVisibility() != 0) {
            super.onWindowVisibilityChanged(i);
        } else {
            k();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        if (this.h == null || this.h.getVisibility() != 0) {
            super.onWindowFocusChanged(z);
        } else {
            k();
        }
    }

    private void j() {
        ak.a((View) this.f, 0);
        ak.a((View) this.g, 0);
        ak.a((View) this.i, 8);
    }

    private void k() {
        g();
        if (this.f != null) {
            if (this.f.getVisibility() != 0) {
                d.a(getContext()).a(this.b.R().h(), this.g);
            } else {
                return;
            }
        }
        j();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.h != null && this.h.getVisibility() == 0) {
            ak.f(this.f);
        }
        b(this.a);
    }

    public void setShowAdInteractionView(boolean z) {
        h v;
        if (this.c != null && (v = this.c.v()) != null) {
            v.d(z);
        }
    }

    protected void e() {
        g();
        ak.a((View) this.f, 0);
    }
}
