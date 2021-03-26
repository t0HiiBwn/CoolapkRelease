package com.coolapk.market.imageloader;

import okhttp3.Interceptor;
import okhttp3.Response;

/* renamed from: com.coolapk.market.imageloader.-$$Lambda$GlideProgressHelper$WwyHDMxu5j-bIqQvUAMUaBTJlAA  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$GlideProgressHelper$WwyHDMxu5jbIqQvUAMUaBTJlAA implements Interceptor {
    public static final /* synthetic */ $$Lambda$GlideProgressHelper$WwyHDMxu5jbIqQvUAMUaBTJlAA INSTANCE = new $$Lambda$GlideProgressHelper$WwyHDMxu5jbIqQvUAMUaBTJlAA();

    private /* synthetic */ $$Lambda$GlideProgressHelper$WwyHDMxu5jbIqQvUAMUaBTJlAA() {
    }

    @Override // okhttp3.Interceptor
    public final Response intercept(Interceptor.Chain chain) {
        return GlideProgressHelper.lambda$createOkHttpClient$1(chain);
    }
}
