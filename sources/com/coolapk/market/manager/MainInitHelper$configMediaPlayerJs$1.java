package com.coolapk.market.manager;

import com.coolapk.market.network.HttpClientFactory;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Request;
import okhttp3.ResponseBody;
import org.apache.commons.io.IOUtils;
import rx.Observable;
import rx.functions.Func0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lrx/Observable;", "", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: MainInitHelper.kt */
final class MainInitHelper$configMediaPlayerJs$1<R> implements Func0<Observable<Unit>> {
    final /* synthetic */ File $storeFile;
    final /* synthetic */ String $url;

    MainInitHelper$configMediaPlayerJs$1(String str, File file) {
        this.$url = str;
        this.$storeFile = file;
    }

    @Override // rx.functions.Func0, java.util.concurrent.Callable
    public final Observable<Unit> call() {
        try {
            InputStream inputStream = null;
            Request build = new Request.Builder().url(this.$url).method("GET", null).build();
            HttpClientFactory instance = HttpClientFactory.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "HttpClientFactory.getInstance()");
            ResponseBody body = instance.getDownloadHttpClient().newCall(build).execute().body();
            if (body != null) {
                inputStream = body.byteStream();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(this.$storeFile);
            IOUtils.copy(inputStream, fileOutputStream);
            IOUtils.closeQuietly((OutputStream) fileOutputStream);
            IOUtils.closeQuietly(inputStream);
            return Observable.empty();
        } catch (Throwable th) {
            return Observable.error(th);
        }
    }
}
