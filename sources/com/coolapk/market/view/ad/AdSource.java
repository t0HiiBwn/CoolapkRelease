package com.coolapk.market.view.ad;

import android.app.Activity;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import com.blankj.utilcode.util.ScreenUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTSplashAd;
import com.coolapk.market.AppHolder;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.util.KotlinExtendKt;
import com.coolapk.market.view.ad.toutiao.TTAdManagerHolder;
import com.coolapk.market.view.splash.FullScreenAdUtils;
import com.coolapk.market.view.splash.SplashViewV9;
import com.qq.e.ads.splash.SplashAD;
import java.io.File;
import java.util.Arrays;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdSource.kt */
public final class AdSource {
    public static final Companion Companion = new Companion(null);
    private static final String QQ_SPLASH_IMAGE_VIEW_NAME = "com.qq.e.comm.plugin.x.c";
    private static final String QQ_SPLASH_IMAGE_VIEW_NAME_2 = "com.qq.e.comm.plugin.y.c";
    private static final int SPLASH_DURATION_TIMEOUT = 5000;
    private static final String TT_SPLASH_IMAGE_VIEW_NAME = "pl.droidsonroids.gif.GifImageView";
    private final Activity activity;
    private ViewGroup adContainer;
    private final String appId;
    private Object data;
    private OnAdEventListener eventListener;
    private boolean isLoaded;
    private boolean isSplashShow;
    private final String name;
    private final String posId;
    private View skipContainer;
    private int timeout = 5000;

    public AdSource(Activity activity2, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(activity2, "activity");
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "appId");
        Intrinsics.checkNotNullParameter(str3, "posId");
        this.activity = activity2;
        this.name = str;
        this.appId = str2;
        this.posId = str3;
    }

    public final String getName() {
        return this.name;
    }

    /* compiled from: AdSource.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x0030 A[RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:11:0x0032 A[ORIG_RETURN, RETURN, SYNTHETIC] */
        public final boolean checkName(String str) {
            Intrinsics.checkNotNullParameter(str, "name");
            switch (str.hashCode()) {
                case -269205242:
                    return str.equals("TT_SPLASH");
                case -75272858:
                    if (str.equals("QQ_SPLASH")) {
                    }
                    break;
                case 2402104:
                    if (str.equals("NONE")) {
                    }
                    break;
                case 1238338067:
                    if (str.equals("COOLAPK_SPLASH")) {
                    }
                    break;
            }
        }
    }

    public final boolean isSplashShow() {
        return this.isSplashShow;
    }

    public final boolean isLoaded() {
        return this.isLoaded;
    }

    public final void load(OnAdLoadListener onAdLoadListener) {
        Intrinsics.checkNotNullParameter(onAdLoadListener, "listener");
        String str = this.name;
        int hashCode = str.hashCode();
        if (hashCode != -269205242) {
            if (hashCode != -75272858) {
                if (hashCode == 1238338067 && str.equals("COOLAPK_SPLASH")) {
                    this.isLoaded = true;
                    if (SplashViewV9.Companion.hasData(this.activity)) {
                        onAdLoadListener.onLoadSuccess(null);
                        this.isSplashShow = true;
                        OnAdEventListener onAdEventListener = this.eventListener;
                        if (onAdEventListener != null) {
                            onAdEventListener.onAdShow(null);
                            return;
                        }
                        return;
                    }
                    onAdLoadListener.onLoadError(new RuntimeException("No coolapk splash"));
                    return;
                }
            } else if (str.equals("QQ_SPLASH")) {
                loadGDTSplash(onAdLoadListener);
                return;
            }
        } else if (str.equals("TT_SPLASH")) {
            loadTTSplash(onAdLoadListener);
            return;
        }
        throw new RuntimeException("Unknown name: " + this.name);
    }

    private final void loadGDTSplash(OnAdLoadListener onAdLoadListener) {
        SplashAD splashAD = new SplashAD(this.activity, this.skipContainer, this.posId, new AdSource$loadGDTSplash$splashAD$1(this, onAdLoadListener), this.timeout);
        splashAD.fetchAndShowIn(this.adContainer);
        this.data = splashAD;
    }

    private final void loadTTSplash(OnAdLoadListener onAdLoadListener) {
        Pair<Integer, Integer> calculateAdViewFitSize = FullScreenAdUtils.INSTANCE.calculateAdViewFitSize(this.activity, 1080, 1920);
        TTAdManagerHolder.INSTANCE.get().createAdNative(this.activity).loadSplashAd(new AdSlot.Builder().setCodeId(this.posId).setSupportDeepLink(true).setImageAcceptedSize(NumberExtendsKt.getDp(calculateAdViewFitSize.getFirst()), NumberExtendsKt.getDp(calculateAdViewFitSize.getSecond())).build(), new AdSource$loadTTSplash$1(this, onAdLoadListener), this.timeout);
    }

    public final Object getData() {
        return this.data;
    }

    public final void setSplashContainer(ViewGroup viewGroup, View view) {
        Intrinsics.checkNotNullParameter(viewGroup, "adContainer");
        Intrinsics.checkNotNullParameter(view, "skipContainer");
        this.adContainer = viewGroup;
        this.skipContainer = view;
    }

    public final void setTimeout(int i) {
        this.timeout = i;
    }

    public final View getSplashView() {
        View view = null;
        if (!this.isLoaded) {
            return view;
        }
        String str = this.name;
        int hashCode = str.hashCode();
        if (hashCode != -269205242) {
            if (hashCode != -75272858) {
                if (hashCode == 1238338067 && str.equals("COOLAPK_SPLASH")) {
                    return new SplashViewV9(this.activity);
                }
            } else if (str.equals("QQ_SPLASH")) {
                return view;
            }
        } else if (str.equals("TT_SPLASH")) {
            Object obj = this.data;
            if (obj instanceof TTSplashAd) {
                return ((TTSplashAd) obj).getSplashView();
            }
            return view;
        }
        throw new RuntimeException("Unknown name to get splash view");
    }

    public final Pair<Integer, Integer> getSplashSize(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        if (!this.isLoaded) {
            return null;
        }
        String str = this.name;
        int hashCode = str.hashCode();
        if (hashCode != -269205242) {
            if (hashCode != -75272858) {
                if (hashCode != 1238338067 || !str.equals("COOLAPK_SPLASH") || !SplashViewV9.Companion.hasData(this.activity)) {
                    return null;
                }
                File splashImageFile = AppHolder.getAppSetting().getSplashImageFile(this.activity);
                Intrinsics.checkNotNullExpressionValue(splashImageFile, "AppHolder.getAppSetting(…SplashImageFile(activity)");
                Uri fromFile = Uri.fromFile(splashImageFile);
                Intrinsics.checkExpressionValueIsNotNull(fromFile, "Uri.fromFile(this)");
                Pair<Integer, Integer> bitmapSize = KotlinExtendKt.getBitmapSize(fromFile, this.activity);
                int screenWidth = ScreenUtils.getScreenWidth();
                int screenHeight = ScreenUtils.getScreenHeight();
                int intValue = (bitmapSize.getSecond().intValue() * screenWidth) / bitmapSize.getFirst().intValue();
                if (intValue <= screenHeight) {
                    screenHeight = intValue;
                }
                return new Pair<>(Integer.valueOf(screenWidth), Integer.valueOf(screenHeight));
            } else if (str.equals("QQ_SPLASH")) {
                return new Pair<>(1080, 1920);
            } else {
                return null;
            }
        } else if (str.equals("TT_SPLASH")) {
            return new Pair<>(1080, 1920);
        } else {
            return null;
        }
    }

    private final View findViewByName(ViewGroup viewGroup, String... strArr) {
        View findViewByName;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (ArraysKt.contains(strArr, childAt.getClass().getName())) {
                return childAt;
            }
            if ((childAt instanceof ViewGroup) && (findViewByName = findViewByName((ViewGroup) childAt, (String[]) Arrays.copyOf(strArr, strArr.length))) != null) {
                return findViewByName;
            }
        }
        return null;
    }

    public final void setOnAdEventListener(OnAdEventListener onAdEventListener) {
        Intrinsics.checkNotNullParameter(onAdEventListener, "listener");
        this.eventListener = onAdEventListener;
    }
}
