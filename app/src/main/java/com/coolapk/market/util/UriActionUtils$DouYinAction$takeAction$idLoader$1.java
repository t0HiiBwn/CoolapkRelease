package com.coolapk.market.util;

import android.net.Uri;
import com.coolapk.market.network.HttpClientFactory;
import com.coolapk.market.util.UriActionUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/net/Uri;", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: UriActionUtils.kt */
final class UriActionUtils$DouYinAction$takeAction$idLoader$1<T, R> implements Func1<Uri, String> {
    final /* synthetic */ UriActionUtils.DouYinAction this$0;

    UriActionUtils$DouYinAction$takeAction$idLoader$1(UriActionUtils.DouYinAction douYinAction) {
        this.this$0 = douYinAction;
    }

    public final String call(Uri uri) {
        Request.Builder builder = new Request.Builder();
        String uri2 = uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "it.toString()");
        Request build = builder.url(uri2).headers(Headers.Companion.of("User-Agent", this.this$0.userAgent)).method("GET", null).build();
        Response response = null;
        try {
            HttpClientFactory instance = HttpClientFactory.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "HttpClientFactory.getInstance()");
            response = instance.getVideoParamsHttpClient().newCall(build).execute();
            Uri parse = Uri.parse(response.request().url().toString());
            Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(response.request.url.toString())");
            String lastPathSegment = parse.getLastPathSegment();
            if (response != null) {
                response.close();
            }
            return lastPathSegment;
        } catch (Exception unused) {
            if (response != null) {
                response.close();
            }
            return "";
        }
    }
}
