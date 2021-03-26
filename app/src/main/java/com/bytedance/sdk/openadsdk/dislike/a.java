package com.bytedance.sdk.openadsdk.dislike;

import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.q;
import java.util.List;

/* compiled from: DislikeDispatcher */
public class a {
    private static volatile a a;
    private final q<com.bytedance.sdk.openadsdk.c.a> b = p.f();

    private a() {
    }

    public static a a() {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a();
                }
            }
        }
        return a;
    }

    public void a(l lVar, List<FilterWord> list) {
        this.b.a(lVar, list);
    }
}
