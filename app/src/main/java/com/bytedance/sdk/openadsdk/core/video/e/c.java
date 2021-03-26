package com.bytedance.sdk.openadsdk.core.video.e;

import android.os.Build;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.video.a.b.a;
import com.bytedance.sdk.openadsdk.i.f.b;

/* compiled from: VideoPreloadUtils */
public class c {
    public static void a(b bVar) {
        if (Build.VERSION.SDK_INT >= 23) {
            new a(p.a(), bVar.a, bVar.c, (long) bVar.b).b();
        } else {
            com.bytedance.sdk.openadsdk.i.f.a.a().a(bVar);
        }
    }
}
