package com.coolapk.market.util;

import com.coolapk.market.AppHolder;
import com.coolapk.market.widget.Toast;
import rx.functions.Action1;

/* renamed from: com.coolapk.market.util.-$$Lambda$PhotoUtils$0ejH2UXvJPXm77PvWOkTKJQz7aY  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$PhotoUtils$0ejH2UXvJPXm77PvWOkTKJQz7aY implements Action1 {
    public static final /* synthetic */ $$Lambda$PhotoUtils$0ejH2UXvJPXm77PvWOkTKJQz7aY INSTANCE = new $$Lambda$PhotoUtils$0ejH2UXvJPXm77PvWOkTKJQz7aY();

    private /* synthetic */ $$Lambda$PhotoUtils$0ejH2UXvJPXm77PvWOkTKJQz7aY() {
    }

    @Override // rx.functions.Action1
    public final void call(Object obj) {
        Toast.error(AppHolder.getApplication(), (Throwable) obj);
    }
}
