package com.bytedance.sdk.openadsdk.downloadnew.a.a;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.i;
import com.ss.android.a.a.a.b;
import java.lang.ref.WeakReference;

/* compiled from: LibAppStatus */
public class a implements b {
    private final WeakReference<Context> a;

    public a(Context context) {
        this.a = new WeakReference<>(context);
    }

    @Override // com.ss.android.a.a.a.b
    public boolean a() {
        return i.d().a();
    }
}
