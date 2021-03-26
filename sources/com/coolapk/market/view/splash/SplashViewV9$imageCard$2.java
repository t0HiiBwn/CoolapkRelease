package com.coolapk.market.view.splash;

import com.coolapk.market.AppHolder;
import com.coolapk.market.AppSetting;
import com.coolapk.market.model.EntityCard;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/coolapk/market/model/EntityCard;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: SplashViewV9.kt */
final class SplashViewV9$imageCard$2 extends Lambda implements Function0<EntityCard> {
    public static final SplashViewV9$imageCard$2 INSTANCE = new SplashViewV9$imageCard$2();

    SplashViewV9$imageCard$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final EntityCard invoke() {
        AppSetting appSetting = AppHolder.getAppSetting();
        Intrinsics.checkNotNullExpressionValue(appSetting, "AppHolder.getAppSetting()");
        return appSetting.getImageCard();
    }
}
