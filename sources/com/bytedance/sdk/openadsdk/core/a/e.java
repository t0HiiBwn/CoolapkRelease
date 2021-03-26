package com.bytedance.sdk.openadsdk.core.a;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.d.l;

/* compiled from: RewardBarClickListener */
public abstract class e extends a {
    protected abstract void a_(View view, int i, int i2, int i3, int i4);

    public e(Context context, l lVar, String str, int i) {
        super(context, lVar, str, i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.a.a, com.bytedance.sdk.openadsdk.core.a.b, com.bytedance.sdk.openadsdk.core.a.c
    public void a(View view, int i, int i2, int i3, int i4) {
        a_(view, i, i2, i3, i4);
        super.a(view, i, i2, i3, i4);
    }
}
