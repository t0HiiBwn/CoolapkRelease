package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.nativeexpress.d;
import com.bytedance.sdk.openadsdk.core.nativeexpress.e;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.utils.aj;

/* compiled from: H5AdInteractionManager */
public class j {
    private final Context a;
    private final l b;
    private a c;
    private e d;
    private d e;
    private View f;
    private String g = "rewarded_video";

    public j(Context context, l lVar, View view, String str) {
        this.b = lVar;
        this.a = context;
        this.f = view;
        if (TextUtils.isEmpty(str)) {
            this.g = aj.b(aj.c(lVar.aj()));
        } else {
            this.g = str;
        }
        if (lVar.T() == 4) {
            this.c = com.bytedance.sdk.openadsdk.downloadnew.a.a(context, lVar, this.g);
        }
        String str2 = this.g;
        e eVar = new e(context, lVar, str2, aj.a(str2));
        this.d = eVar;
        eVar.a(this.f);
        this.d.a(this.c);
        String str3 = this.g;
        d dVar = new d(context, lVar, str3, aj.a(str3));
        this.e = dVar;
        dVar.a(this.f);
        this.e.a(this.c);
    }

    public void a(int i, com.bytedance.sdk.openadsdk.core.d.j jVar) {
        d dVar;
        if (i != -1 && jVar != null) {
            int i2 = jVar.a;
            int i3 = jVar.b;
            int i4 = jVar.c;
            int i5 = jVar.d;
            if (i == 1) {
                e eVar = this.d;
                if (eVar != null) {
                    eVar.a(jVar);
                    this.d.a(this.f, i2, i3, i4, i5);
                }
            } else if (i == 2 && (dVar = this.e) != null) {
                dVar.a(jVar);
                this.e.a(this.f, i2, i3, i4, i5);
            }
        }
    }
}
