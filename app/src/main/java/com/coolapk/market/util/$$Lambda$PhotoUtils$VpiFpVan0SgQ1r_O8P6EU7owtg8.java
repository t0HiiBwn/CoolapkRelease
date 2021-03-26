package com.coolapk.market.util;

import com.coolapk.market.AppHolder;
import com.coolapk.market.widget.Toast;
import rx.functions.Action1;

/* renamed from: com.coolapk.market.util.-$$Lambda$PhotoUtils$VpiFpVan0SgQ1r_O8P6EU7owtg8  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$PhotoUtils$VpiFpVan0SgQ1r_O8P6EU7owtg8 implements Action1 {
    public static final /* synthetic */ $$Lambda$PhotoUtils$VpiFpVan0SgQ1r_O8P6EU7owtg8 INSTANCE = new $$Lambda$PhotoUtils$VpiFpVan0SgQ1r_O8P6EU7owtg8();

    private /* synthetic */ $$Lambda$PhotoUtils$VpiFpVan0SgQ1r_O8P6EU7owtg8() {
    }

    @Override // rx.functions.Action1
    public final void call(Object obj) {
        Toast.error(AppHolder.getApplication(), (Throwable) obj);
    }
}
