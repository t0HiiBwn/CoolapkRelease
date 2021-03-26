package com.coolapk.market.view.photo;

import com.coolapk.market.AppHolder;
import com.coolapk.market.AppSetting;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.model.EntityCard;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u00012\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "Lrx/Observable;", "", "kotlin.jvm.PlatformType", "loaded", "", "call", "(Ljava/lang/Boolean;)Lrx/Observable;"}, k = 3, mv = {1, 4, 2})
/* compiled from: SplashView.kt */
final class SplashView$executeImageTask$subscription$2<T, R> implements Func1<Boolean, Observable<Long>> {
    public static final SplashView$executeImageTask$subscription$2 INSTANCE = new SplashView$executeImageTask$subscription$2();

    SplashView$executeImageTask$subscription$2() {
    }

    public final Observable<Long> call(Boolean bool) {
        if (!bool.booleanValue()) {
            return Observable.just(0L);
        }
        AppSetting appSetting = AppHolder.getAppSetting();
        Intrinsics.checkNotNullExpressionValue(appSetting, "AppHolder.getAppSetting()");
        EntityCard imageCard = appSetting.getImageCard();
        if (imageCard != null) {
            EntityCard entityCard = imageCard;
            if (EntityExtendsKt.getIntExtraData(entityCard, "timeout", 0) > 0) {
                return Observable.timer((long) EntityExtendsKt.getIntExtraData(entityCard, "timeout", 0), TimeUnit.SECONDS);
            }
        }
        return Observable.timer((long) 2500.0f, TimeUnit.MILLISECONDS);
    }
}
