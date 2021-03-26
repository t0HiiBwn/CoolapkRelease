package com.coolapk.market.view.splash;

import android.os.Bundle;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.transition.TransitionManager;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppSetting;
import com.coolapk.market.databinding.SplashV9Binding;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.view.ad.AdSource;
import com.coolapk.market.view.splash.SplashTimer;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: BaseFullScreenAdActivity.kt */
public class BaseFullScreenAdActivity extends AppCompatActivity implements SplashTimer.OnEventListener {
    public static final Companion Companion = new Companion(null);
    public static final int LAUNCH_MODE_FIRST = 0;
    public static final int LAUNCH_MODE_RESUME = 1;
    private AdSource adSource;
    private SplashV9Binding binding;
    private boolean isDoFinishing;
    private boolean isResume;
    private boolean shouldFinishOnResume;
    private final SplashTimer splashTimer = new SplashTimer(this);

    protected boolean isDisplayOnly() {
        return false;
    }

    protected int launchMode() {
        return 0;
    }

    public static final /* synthetic */ AdSource access$getAdSource$p(BaseFullScreenAdActivity baseFullScreenAdActivity) {
        AdSource adSource2 = baseFullScreenAdActivity.adSource;
        if (adSource2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adSource");
        }
        return adSource2;
    }

    public static final /* synthetic */ SplashV9Binding access$getBinding$p(BaseFullScreenAdActivity baseFullScreenAdActivity) {
        SplashV9Binding splashV9Binding = baseFullScreenAdActivity.binding;
        if (splashV9Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return splashV9Binding;
    }

    /* compiled from: BaseFullScreenAdActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FullScreenAdUtils fullScreenAdUtils = FullScreenAdUtils.INSTANCE;
        Window window = getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "window");
        fullScreenAdUtils.setFullscreen(window);
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, 2131559145);
        Intrinsics.checkNotNullExpressionValue(contentView, "DataBindingUtil.setConte…this, R.layout.splash_v9)");
        SplashV9Binding splashV9Binding = (SplashV9Binding) contentView;
        this.binding = splashV9Binding;
        if (splashV9Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        CountdownView countdownView = splashV9Binding.skipButton;
        Intrinsics.checkNotNullExpressionValue(countdownView, "binding.skipButton");
        countdownView.setVisibility(0);
        SplashV9Binding splashV9Binding2 = this.binding;
        if (splashV9Binding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        CountdownView countdownView2 = splashV9Binding2.skipButton;
        Intrinsics.checkNotNullExpressionValue(countdownView2, "binding.skipButton");
        countdownView2.setAlpha(0.0f);
        SplashV9Binding splashV9Binding3 = this.binding;
        if (splashV9Binding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        splashV9Binding3.skipButton.setOnClickListener(new BaseFullScreenAdActivity$onCreate$1(this));
        SplashV9Binding splashV9Binding4 = this.binding;
        if (splashV9Binding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ImageView imageView = splashV9Binding4.sloganView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.sloganView");
        imageView.setVisibility(launchMode() == 1 ? 0 : 8);
        FullScreenAdUtils fullScreenAdUtils2 = FullScreenAdUtils.INSTANCE;
        fullScreenAdUtils2.logFile("当前开屏页启动模式为 " + launchMode());
        try {
            AppSetting appSetting = AppHolder.getAppSetting();
            Intrinsics.checkNotNullExpressionValue(appSetting, "AppHolder.getAppSetting()");
            String optString = appSetting.getConfigJson().optString("SplashAd.Type", "");
            Intrinsics.checkNotNullExpressionValue(optString, "splashAdType");
            List split$default = StringsKt.split$default((CharSequence) optString, new String[]{"|"}, false, 0, 6, (Object) null);
            String str = (String) split$default.get(0);
            if (str != null) {
                String obj = StringsKt.trim((CharSequence) str).toString();
                String str2 = (String) split$default.get(1);
                if (str2 != null) {
                    String obj2 = StringsKt.trim((CharSequence) str2).toString();
                    String str3 = (String) split$default.get(2);
                    if (str3 != null) {
                        String obj3 = StringsKt.trim((CharSequence) str3).toString();
                        if (!AdSource.Companion.checkName(obj)) {
                            if (Intrinsics.areEqual(obj, "NONE")) {
                                FullScreenAdUtils.INSTANCE.logFile("AdName为None，不展示广告");
                                finishSplash(false, true);
                                return;
                            }
                            obj = "COOLAPK_SPLASH";
                        }
                        AdSource adSource2 = new AdSource(this, obj, obj2, obj3);
                        this.adSource = adSource2;
                        SplashV9Binding splashV9Binding5 = this.binding;
                        if (splashV9Binding5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                        }
                        FrameLayout frameLayout = splashV9Binding5.adContainer;
                        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.adContainer");
                        FrameLayout frameLayout2 = frameLayout;
                        SplashV9Binding splashV9Binding6 = this.binding;
                        if (splashV9Binding6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                        }
                        CountdownView countdownView3 = splashV9Binding6.skipButton;
                        Intrinsics.checkNotNullExpressionValue(countdownView3, "binding.skipButton");
                        adSource2.setSplashContainer(frameLayout2, countdownView3);
                        if (launchMode() == 1) {
                            AdSource adSource3 = this.adSource;
                            if (adSource3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("adSource");
                            }
                            adSource3.setTimeout(100);
                        }
                        AdSource adSource4 = this.adSource;
                        if (adSource4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("adSource");
                        }
                        adSource4.setOnAdEventListener(new BaseFullScreenAdActivity$onCreate$2(this));
                        loadAd();
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
        } catch (Exception e) {
            FullScreenAdUtils.INSTANCE.logFile(e);
            finishSplash(false, true);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            FullScreenAdUtils fullScreenAdUtils = FullScreenAdUtils.INSTANCE;
            Window window = getWindow();
            Intrinsics.checkNotNullExpressionValue(window, "window");
            fullScreenAdUtils.setFullscreen(window);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (isDisplayOnly()) {
            super.onBackPressed();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.isResume = true;
        if (this.shouldFinishOnResume) {
            finishSplash$default(this, true, false, 2, null);
        } else {
            startCountdownIfAdShow();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.isResume = false;
        this.splashTimer.stopCountdown();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.splashTimer.destroy();
    }

    public final void startCountdownIfAdShow() {
        if (!isDisplayOnly() && this.isResume) {
            AdSource adSource2 = this.adSource;
            if (adSource2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adSource");
            }
            if (adSource2.isSplashShow() && !this.splashTimer.isStartCountdown()) {
                this.splashTimer.startCountdown();
            }
        }
    }

    @Override // com.coolapk.market.view.splash.SplashTimer.OnEventListener
    public void onTimeout() {
        AdSource adSource2 = this.adSource;
        if (adSource2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adSource");
        }
        if (adSource2.isLoaded()) {
            AdSource adSource3 = this.adSource;
            if (adSource3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adSource");
            }
            if (adSource3.isSplashShow()) {
                return;
            }
        }
        FullScreenAdUtils.INSTANCE.logFile("数据加载超时");
        finishSplash$default(this, true, false, 2, null);
    }

    @Override // com.coolapk.market.view.splash.SplashTimer.OnEventListener
    public void onCountdown(int i) {
        SplashV9Binding splashV9Binding = this.binding;
        if (splashV9Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        splashV9Binding.skipButton.setNumber(Integer.valueOf(i));
    }

    @Override // com.coolapk.market.view.splash.SplashTimer.OnEventListener
    public void onCountdownFinish() {
        finishSplash$default(this, true, false, 2, null);
    }

    private final void loadAd() {
        try {
            FullScreenAdUtils.INSTANCE.logFile("开始加载广告");
            AdSource adSource2 = this.adSource;
            if (adSource2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adSource");
            }
            adSource2.load(new BaseFullScreenAdActivity$loadAd$1(this));
            if (!isDisplayOnly()) {
                this.splashTimer.startTimeout();
            }
        } catch (Exception e) {
            FullScreenAdUtils.INSTANCE.logFile(e);
            finishSplash(false, true);
        }
    }

    public final void animLogoCenterIfNeed(int i) {
        if (i > FullScreenAdUtils.INSTANCE.getSloganMinHeight(this)) {
            SplashV9Binding splashV9Binding = this.binding;
            if (splashV9Binding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TransitionManager.beginDelayedTransition(splashV9Binding.bottomContainer);
            SplashV9Binding splashV9Binding2 = this.binding;
            if (splashV9Binding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            FrameLayout frameLayout = splashV9Binding2.bottomContainer;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.bottomContainer");
            FrameLayout frameLayout2 = frameLayout;
            ViewGroup.LayoutParams layoutParams = frameLayout2.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
                frameLayout2.setLayoutParams(layoutParams);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
    }

    public final void markAdLastShowTimestamp() {
        FullScreenAdUtils.INSTANCE.logFile("标记广告展示的时间");
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        instance.getPreferencesEditor().putLong("SPLASH_AD_LAST_SHOW", System.currentTimeMillis()).apply();
    }

    public final void markAdErrorTimestamp(Throwable th) {
        FullScreenAdUtils.INSTANCE.logFile("标记广告加载出错的时间");
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        instance.getPreferencesEditor().putLong("TENCENT_AD_ERROR_TIMESTAMP", System.currentTimeMillis()).apply();
    }

    static /* synthetic */ void finishSplash$default(BaseFullScreenAdActivity baseFullScreenAdActivity, boolean z, boolean z2, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                z2 = false;
            }
            baseFullScreenAdActivity.finishSplash(z, z2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: finishSplash");
    }

    public final synchronized void finishSplash(boolean z, boolean z2) {
        if (!this.isResume) {
            this.shouldFinishOnResume = true;
            return;
        }
        this.shouldFinishOnResume = false;
        if (!this.isDoFinishing) {
            this.isDoFinishing = true;
            if (launchMode() != 1) {
                finishSplashInternal(z);
            } else if (z2) {
                AppHolder.getMainThreadHandler().postDelayed(new BaseFullScreenAdActivity$finishSplash$1(this), 1000);
            } else {
                finishSplashInternal(true);
            }
        }
    }

    public final void finishSplashInternal(boolean z) {
        try {
            FullScreenAdUtils.INSTANCE.logFile("结束广告页");
            setResult(-1);
            finish();
            if (z) {
                overridePendingTransition(0, 2130771981);
            } else {
                overridePendingTransition(0, 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
