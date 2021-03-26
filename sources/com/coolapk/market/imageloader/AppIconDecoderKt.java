package com.coolapk.market.imageloader;

import com.coolapk.market.AppHolder;
import com.coolapk.market.extend.NumberExtendsKt;
import kotlin.Metadata;
import me.zhanghai.android.appiconloader.AppIconLoader;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"appIconLoader", "Lme/zhanghai/android/appiconloader/AppIconLoader;", "getAppIconLoader", "()Lme/zhanghai/android/appiconloader/AppIconLoader;", "presentation_coolapkAppRelease"}, k = 2, mv = {1, 4, 2})
/* compiled from: AppIconDecoder.kt */
public final class AppIconDecoderKt {
    private static final AppIconLoader appIconLoader = new AppIconLoader(NumberExtendsKt.getDp((Number) 48), false, AppHolder.getApplication());

    public static final AppIconLoader getAppIconLoader() {
        return appIconLoader;
    }
}
