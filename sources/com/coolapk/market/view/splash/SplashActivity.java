package com.coolapk.market.view.splash;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\rH\u0014J\b\u0010\u0003\u001a\u00020\u0004H\u0014R\u001d\u0010\u0003\u001a\u0004\u0018\u00010\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001d\u0010\t\u001a\u0004\u0018\u00010\u00048BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\n\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/coolapk/market/view/splash/SplashActivity;", "Lcom/coolapk/market/view/splash/BaseFullScreenAdActivity;", "()V", "launchMode", "", "getLaunchMode", "()Ljava/lang/String;", "launchMode$delegate", "Lkotlin/Lazy;", "mode", "getMode", "mode$delegate", "isDisplayOnly", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SplashActivity.kt */
public final class SplashActivity extends BaseFullScreenAdActivity {
    public static final Companion Companion = new Companion(null);
    public static final String KEY_LAUNCH_MODE = "MODE";
    public static final String KEY_MODE = "MODE";
    public static final String MODE_COUNTDOWN = "COUNTDOWN";
    public static final String MODE_DISPLAY_ONLY = "ONLY_DISPLAY";
    private final Lazy launchMode$delegate = LazyKt.lazy(new SplashActivity$launchMode$2(this));
    private final Lazy mode$delegate = LazyKt.lazy(new SplashActivity$mode$2(this));

    private final String getLaunchMode() {
        return (String) this.launchMode$delegate.getValue();
    }

    private final String getMode() {
        return (String) this.mode$delegate.getValue();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/coolapk/market/view/splash/SplashActivity$Companion;", "", "()V", "KEY_LAUNCH_MODE", "", "KEY_MODE", "MODE_COUNTDOWN", "MODE_DISPLAY_ONLY", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SplashActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.view.splash.BaseFullScreenAdActivity
    protected String launchMode() {
        String launchMode = getLaunchMode();
        return launchMode != null ? launchMode : "COLD_BOOT";
    }

    @Override // com.coolapk.market.view.splash.BaseFullScreenAdActivity
    protected boolean isDisplayOnly() {
        return Intrinsics.areEqual(getMode(), "ONLY_DISPLAY");
    }
}
