package com.coolapk.market.imageloader;

import android.util.SparseBooleanArray;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.network.Result;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import okhttp3.Interceptor;
import rx.Subscriber;
import rx.schedulers.Schedulers;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0007J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/coolapk/market/imageloader/ImageLoadErrorHandler;", "", "()V", "ERROR_TYPE_ZERO_LENGTH_FILE", "", "hashcodeArray", "Landroid/util/SparseBooleanArray;", "createOkHttpErrorInterceptor", "Lokhttp3/Interceptor;", "markImageLoadError", "", "url", "code", "", "type", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ImageLoadErrorHandler.kt */
public final class ImageLoadErrorHandler {
    private static final String ERROR_TYPE_ZERO_LENGTH_FILE = "zero_length_file";
    public static final ImageLoadErrorHandler INSTANCE = new ImageLoadErrorHandler();
    private static final SparseBooleanArray hashcodeArray = new SparseBooleanArray();

    private ImageLoadErrorHandler() {
    }

    @JvmStatic
    public static final Interceptor createOkHttpErrorInterceptor() {
        return ImageLoadErrorHandler$createOkHttpErrorInterceptor$1.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final void markImageLoadError(String str, int i, String str2) {
        SparseBooleanArray sparseBooleanArray = hashcodeArray;
        if (!sparseBooleanArray.get(str.hashCode())) {
            sparseBooleanArray.put(str.hashCode(), true);
            DataManager.getInstance().markImageError(str, String.valueOf(i), str2).subscribeOn(Schedulers.io()).subscribe((Subscriber<? super Result<String>>) new EmptySubscriber());
        }
    }
}
