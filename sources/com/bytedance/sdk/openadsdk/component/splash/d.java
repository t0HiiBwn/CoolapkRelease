package com.bytedance.sdk.openadsdk.component.splash;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.video.c.a;
import com.bytedance.sdk.openadsdk.utils.aj;
import java.util.Map;

/* compiled from: SplashVideoController */
public class d extends a {
    private boolean j = false;

    @Override // com.bytedance.sdk.openadsdk.core.video.c.a
    protected int a() {
        return 3;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.a
    protected void c() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.a
    protected void d() {
    }

    d(Context context, ViewGroup viewGroup, l lVar) {
        super(context, viewGroup, lVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.a
    protected void a(int i, int i2) {
        if (this.b != null && i != 308) {
            String str = this.h ? "play_error" : "play_start_error";
            Map<String, Object> a = aj.a(this.b, i, i2, u());
            if (this.h) {
                a.put("duration", Long.valueOf(p()));
                a.put("percent", Integer.valueOf(r()));
                a.put("buffers_time", Long.valueOf(o()));
            }
            com.bytedance.sdk.openadsdk.c.d.d((Context) this.a.get(), this.b, "splash_ad", str, a);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.a
    protected void b() {
        if (!this.j) {
            this.j = true;
            com.bytedance.sdk.openadsdk.c.d.a((Context) this.a.get(), this.b, "splash_ad", "feed_over", this.c, 100, C());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.a
    protected void e() {
        com.bytedance.sdk.openadsdk.c.d.c((Context) this.a.get(), this.b, "splash_ad", "feed_play", B());
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.a
    protected void f() {
        com.bytedance.sdk.openadsdk.c.d.c((Context) this.a.get(), this.b, "splash_ad", "feed_play", B());
    }
}
