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
import com.coolapk.market.event.MainInitEvent;
import com.coolapk.market.extend.EventBusExtendsKt;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.manager.MainInitHelper;
import com.coolapk.market.view.ad.AdSource;
import com.coolapk.market.view.splash.SplashTimer;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000 42\u00020\u00012\u00020\u0002:\u00014B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0013H\u0002J\u001a\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u000b2\b\b\u0002\u0010\u0019\u001a\u00020\u000bH\u0002J\u0010\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u000bH\u0002J\b\u0010\u001b\u001a\u00020\u000bH\u0014J\b\u0010\u001c\u001a\u00020\u001dH\u0014J\u0010\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0010\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020\u0013H\u0002J\b\u0010#\u001a\u00020\u0013H\u0016J\u0010\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u0015H\u0016J\b\u0010&\u001a\u00020\u0013H\u0016J\u0012\u0010'\u001a\u00020\u00132\b\u0010(\u001a\u0004\u0018\u00010)H\u0014J\b\u0010*\u001a\u00020\u0013H\u0014J\u0010\u0010+\u001a\u00020\u00132\u0006\u0010,\u001a\u00020-H\u0007J\b\u0010.\u001a\u00020\u0013H\u0014J\b\u0010/\u001a\u00020\u0013H\u0014J\b\u00100\u001a\u00020\u0013H\u0016J\u0010\u00101\u001a\u00020\u00132\u0006\u00102\u001a\u00020\u000bH\u0016J\b\u00103\u001a\u00020\u0013H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/coolapk/market/view/splash/BaseFullScreenAdActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/coolapk/market/view/splash/SplashTimer$OnEventListener;", "()V", "adSource", "Lcom/coolapk/market/view/ad/AdSource;", "binding", "Lcom/coolapk/market/databinding/SplashV9Binding;", "doStartRunnable", "Ljava/lang/Runnable;", "isDoFinishing", "", "isResume", "isStarted", "Ljava/util/concurrent/atomic/AtomicBoolean;", "shouldFinishOnResume", "splashTimer", "Lcom/coolapk/market/view/splash/SplashTimer;", "animLogoCenterIfNeed", "", "bottomHeight", "", "doStart", "finishSplash", "animation", "delayFinishOnResume", "finishSplashInternal", "isDisplayOnly", "launchMode", "", "loadAd", "markAdErrorTimestamp", "error", "", "markAdLastShowTimestamp", "onBackPressed", "onCountdown", "number", "onCountdownFinish", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onMainInitEventChanged", "event", "Lcom/coolapk/market/event/MainInitEvent;", "onPause", "onResume", "onTimeout", "onWindowFocusChanged", "hasFocus", "startCountdownIfAdShow", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: BaseFullScreenAdActivity.kt */
public abstract class BaseFullScreenAdActivity extends AppCompatActivity implements SplashTimer.OnEventListener {
    public static final Companion Companion = new Companion(null);
    public static final String LAUNCH_MODE_COLD_BOOT = "COLD_BOOT";
    public static final String LAUNCH_MODE_HOT_BOOT = "HOT_BOOT";
    public static final long WAIT_FOR_MAIN_INIT_TIMEOUT = 1000;
    private AdSource adSource;
    private SplashV9Binding binding;
    private final Runnable doStartRunnable = new BaseFullScreenAdActivity$doStartRunnable$1(this);
    private boolean isDoFinishing;
    private boolean isResume;
    private AtomicBoolean isStarted = new AtomicBoolean(false);
    private boolean shouldFinishOnResume;
    private final SplashTimer splashTimer = new SplashTimer(this);

    protected boolean isDisplayOnly() {
        return false;
    }

    protected String launchMode() {
        return "COLD_BOOT";
    }

    public static final /* synthetic */ SplashV9Binding access$getBinding$p(BaseFullScreenAdActivity baseFullScreenAdActivity) {
        SplashV9Binding splashV9Binding = baseFullScreenAdActivity.binding;
        if (splashV9Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return splashV9Binding;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/coolapk/market/view/splash/BaseFullScreenAdActivity$Companion;", "", "()V", "LAUNCH_MODE_COLD_BOOT", "", "LAUNCH_MODE_HOT_BOOT", "WAIT_FOR_MAIN_INIT_TIMEOUT", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
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
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, 2131559152);
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
        FullScreenAdUtils fullScreenAdUtils2 = FullScreenAdUtils.INSTANCE;
        fullScreenAdUtils2.logFile("当前开屏页启动模式为 " + launchMode());
        if (Intrinsics.areEqual(launchMode(), "COLD_BOOT") || !MainInitHelper.INSTANCE.isDataLoaded()) {
            FullScreenAdUtils.INSTANCE.logFile("等待1000ms后才解析广告");
            AppHolder.getMainThreadHandler().postDelayed(this.doStartRunnable, 1000);
        } else {
            FullScreenAdUtils.INSTANCE.logFile("立即解析广告");
            doStart();
        }
        EventBus eventBus = EventBus.getDefault();
        Intrinsics.checkNotNullExpressionValue(eventBus, "EventBus.getDefault()");
        EventBusExtendsKt.safeRegister(eventBus, this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onMainInitEventChanged(MainInitEvent mainInitEvent) {
        Intrinsics.checkNotNullParameter(mainInitEvent, "event");
        if (!this.isStarted.get()) {
            FullScreenAdUtils.INSTANCE.logFile("配置文件加载完毕，我们可以立即解析");
            AppHolder.getMainThreadHandler().removeCallbacks(this.doStartRunnable);
            doStart();
        }
    }

    /* access modifiers changed from: private */
    public final void doStart() {
        if (!this.isStarted.get()) {
            this.isStarted.set(true);
            FullScreenAdUtils.INSTANCE.logFile("开始解析广告");
            if (Intrinsics.areEqual(launchMode(), "COLD_BOOT")) {
                FullScreenAdUtils.INSTANCE.logFile("冷启动检测是否需要显示广告");
                if (!FullScreenAdUtils.shouldShowAd(this)) {
                    finishSplash(false, true);
                    return;
                }
            }
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
                            SplashV9Binding splashV9Binding = this.binding;
                            if (splashV9Binding == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("binding");
                            }
                            FrameLayout frameLayout = splashV9Binding.adContainer;
                            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.adContainer");
                            FrameLayout frameLayout2 = frameLayout;
                            SplashV9Binding splashV9Binding2 = this.binding;
                            if (splashV9Binding2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("binding");
                            }
                            CountdownView countdownView = splashV9Binding2.skipButton;
                            Intrinsics.checkNotNullExpressionValue(countdownView, "binding.skipButton");
                            adSource2.setSplashContainer(frameLayout2, countdownView);
                            if (Intrinsics.areEqual(launchMode(), "HOT_BOOT")) {
                                adSource2.setTimeout(100);
                            }
                            adSource2.setOnAdEventListener(new BaseFullScreenAdActivity$doStart$1(this));
                            loadAd(adSource2);
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
    }

    private final void loadAd(AdSource adSource2) {
        try {
            FullScreenAdUtils.INSTANCE.logFile("开始加载广告");
            adSource2.load(new BaseFullScreenAdActivity$loadAd$1(this, adSource2));
            if (!isDisplayOnly()) {
                this.splashTimer.startTimeout();
            }
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
        if (!this.isStarted.get()) {
            return;
        }
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
        if (this.isStarted.get()) {
            this.splashTimer.stopCountdown();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.isStarted.get()) {
            this.splashTimer.destroy();
        } else {
            AppHolder.getMainThreadHandler().removeCallbacks(this.doStartRunnable);
        }
        EventBus eventBus = EventBus.getDefault();
        Intrinsics.checkNotNullExpressionValue(eventBus, "EventBus.getDefault()");
        EventBusExtendsKt.safeUnregister(eventBus, this);
    }

    /* access modifiers changed from: private */
    public final void startCountdownIfAdShow() {
        AdSource adSource2;
        if (!isDisplayOnly() && this.isResume && (adSource2 = this.adSource) != null && adSource2.isSplashShow() && !this.splashTimer.isStartCountdown()) {
            this.splashTimer.startCountdown();
        }
    }

    @Override // com.coolapk.market.view.splash.SplashTimer.OnEventListener
    public void onTimeout() {
        AdSource adSource2 = this.adSource;
        if (adSource2 == null) {
            return;
        }
        if (!adSource2.isLoaded() || !adSource2.isSplashShow()) {
            FullScreenAdUtils.INSTANCE.logFile("数据加载超时");
            finishSplash$default(this, true, false, 2, null);
        }
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

    /* access modifiers changed from: private */
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
            ImageView imageView = splashV9Binding2.sloganView;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.sloganView");
            imageView.setVisibility(8);
            SplashV9Binding splashV9Binding3 = this.binding;
            if (splashV9Binding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            FrameLayout frameLayout = splashV9Binding3.bottomContainer;
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

    /* access modifiers changed from: private */
    public final void markAdLastShowTimestamp() {
        FullScreenAdUtils.INSTANCE.logFile("标记广告展示的时间");
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        instance.getPreferencesEditor().putLong("SPLASH_AD_LAST_SHOW", System.currentTimeMillis()).apply();
    }

    /* access modifiers changed from: private */
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

    /* access modifiers changed from: private */
    public final synchronized void finishSplash(boolean z, boolean z2) {
        if (!this.isResume) {
            this.shouldFinishOnResume = true;
            return;
        }
        this.shouldFinishOnResume = false;
        if (!this.isDoFinishing) {
            this.isDoFinishing = true;
            String launchMode = launchMode();
            if (launchMode.hashCode() != 521267140 || !launchMode.equals("HOT_BOOT")) {
                finishSplashInternal(z);
            } else if (z2) {
                AppHolder.getMainThreadHandler().postDelayed(new BaseFullScreenAdActivity$finishSplash$1(this), 1000);
            } else {
                finishSplashInternal(true);
            }
        }
    }

    /* access modifiers changed from: private */
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
