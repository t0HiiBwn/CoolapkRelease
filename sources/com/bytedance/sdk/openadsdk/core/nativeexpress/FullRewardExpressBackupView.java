package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.d.j;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.u;

public class FullRewardExpressBackupView extends BackupView {
    private View k;

    /* renamed from: l  reason: collision with root package name */
    private NativeExpressView f1314l;
    private FrameLayout m;
    private a n;

    public FullRewardExpressBackupView(Context context) {
        super(context);
        this.a = context;
    }

    public void a(l lVar, NativeExpressView nativeExpressView, a aVar) {
        u.b("FullRewardExpressBackupView", "show backup view");
        setBackgroundColor(-1);
        this.b = lVar;
        this.f1314l = nativeExpressView;
        this.n = aVar;
        if (aj.c(this.b.aj()) == 7) {
            this.e = "rewarded_video";
        } else {
            this.e = "fullscreen_interstitial_ad";
        }
        b();
        this.f1314l.addView(this, new ViewGroup.LayoutParams(-2, -2));
    }

    private void b() {
        this.f = ak.c(this.a, (float) this.f1314l.getExpectExpressWidth());
        this.g = ak.c(this.a, (float) this.f1314l.getExpectExpressWidth());
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(this.f, this.g);
        }
        layoutParams.width = this.f;
        layoutParams.height = this.g;
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
        }
        setLayoutParams(layoutParams);
        this.b.n();
        c();
    }

    private void c() {
        View inflate = LayoutInflater.from(this.a).inflate(ac.f(this.a, "tt_backup_full_reward"), (ViewGroup) this, true);
        this.k = inflate;
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(ac.e(this.a, "tt_bu_video_container"));
        this.m = frameLayout;
        frameLayout.removeAllViews();
    }

    public FrameLayout getVideoContainer() {
        return this.m;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    protected void a(int i, j jVar) {
        NativeExpressView nativeExpressView = this.f1314l;
        if (nativeExpressView != null) {
            nativeExpressView.a(i, jVar);
        }
    }
}
