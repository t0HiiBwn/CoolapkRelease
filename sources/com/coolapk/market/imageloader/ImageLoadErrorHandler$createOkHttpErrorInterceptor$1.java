package com.coolapk.market.imageloader;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "intercept"}, k = 3, mv = {1, 4, 2})
/* compiled from: ImageLoadErrorHandler.kt */
final class ImageLoadErrorHandler$createOkHttpErrorInterceptor$1 implements Interceptor {
    public static final ImageLoadErrorHandler$createOkHttpErrorInterceptor$1 INSTANCE = new ImageLoadErrorHandler$createOkHttpErrorInterceptor$1();

    ImageLoadErrorHandler$createOkHttpErrorInterceptor$1() {
    }

    @Override // okhttp3.Interceptor
    public final Response intercept(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        Response proceed = chain.proceed(request);
        int code = proceed.code();
        if (code == 404 || code > 500) {
            ImageLoadErrorHandler.INSTANCE.markImageLoadError(request.url().toString(), code, "");
        } else if (code == 200) {
            try {
                if (proceed.peekBody(1).contentLength() == 0) {
                    ImageLoadErrorHandler.INSTANCE.markImageLoadError(request.url().toString(), code, "zero_length_file");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return proceed;
    }
}
