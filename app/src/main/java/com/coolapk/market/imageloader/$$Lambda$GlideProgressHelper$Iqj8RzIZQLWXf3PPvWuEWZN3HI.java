package com.coolapk.market.imageloader;

import okhttp3.Interceptor;
import okhttp3.Response;

/* renamed from: com.coolapk.market.imageloader.-$$Lambda$GlideProgressHelper$Iqj8Rz-IZQLWXf3PPvWuEWZN3HI  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$GlideProgressHelper$Iqj8RzIZQLWXf3PPvWuEWZN3HI implements Interceptor {
    public static final /* synthetic */ $$Lambda$GlideProgressHelper$Iqj8RzIZQLWXf3PPvWuEWZN3HI INSTANCE = new $$Lambda$GlideProgressHelper$Iqj8RzIZQLWXf3PPvWuEWZN3HI();

    private /* synthetic */ $$Lambda$GlideProgressHelper$Iqj8RzIZQLWXf3PPvWuEWZN3HI() {
    }

    @Override // okhttp3.Interceptor
    public final Response intercept(Interceptor.Chain chain) {
        return GlideProgressHelper.lambda$createOkHttpClient$0(chain);
    }
}
