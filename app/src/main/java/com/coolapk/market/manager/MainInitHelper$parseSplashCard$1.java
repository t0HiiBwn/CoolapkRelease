package com.coolapk.market.manager;

import android.app.Application;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.coolapk.market.AppHolder;
import com.coolapk.market.imageloader.GlideApp;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.apache.commons.io.FileUtils;
import rx.Observable;
import rx.functions.Func0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lrx/Observable;", "", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: MainInitHelper.kt */
final class MainInitHelper$parseSplashCard$1<R> implements Func0<Observable<Unit>> {
    final /* synthetic */ File $maybeTheSplashFile;
    final /* synthetic */ Ref.ObjectRef $pendingSplashUrl;

    MainInitHelper$parseSplashCard$1(Ref.ObjectRef objectRef, File file) {
        this.$pendingSplashUrl = objectRef;
        this.$maybeTheSplashFile = file;
    }

    /* JADX WARN: Type inference failed for: r1v5, types: [com.coolapk.market.imageloader.GlideRequest] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // rx.functions.Func0, java.util.concurrent.Callable
    public final Observable<Unit> call() {
        try {
            Application application = AppHolder.getApplication();
            Intrinsics.checkNotNullExpressionValue(application, "AppHolder.getApplication()");
            Resources resources = application.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "AppHolder.getApplication().resources");
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            FileUtils.copyFile((File) GlideApp.with(AppHolder.getApplication()).load((String) this.$pendingSplashUrl.element).downloadOnly(displayMetrics.widthPixels, displayMetrics.heightPixels).get(), this.$maybeTheSplashFile);
            return Observable.empty();
        } catch (Throwable th) {
            return Observable.error(th);
        }
    }
}
