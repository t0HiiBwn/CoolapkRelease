package com.coolapk.market.view.ad;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.blankj.utilcode.util.ScreenUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTSplashAd;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppSetting;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.manager.AppPictureSizeManager;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.view.ad.toutiao.TTAdManagerHolder;
import com.coolapk.market.view.splash.FullScreenAdUtils;
import com.coolapk.market.view.splash.SplashViewV9;
import com.qq.e.ads.splash.SplashAD;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0003\u0018\u0000 +2\u00020\u0001:\u0001+B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001J\u001c\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\nJ\b\u0010\u001d\u001a\u0004\u0018\u00010\u0016J\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!J\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010#\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002J\u000e\u0010$\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\rJ\u0016\u0010%\u001a\u00020\u001f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010&\u001a\u00020\u001f2\u0006\u0010\u0017\u001a\u00020\u0018J'\u0010'\u001a\u0004\u0018\u00010\u0016*\u00020\n2\u0012\u0010(\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050)\"\u00020\u0005H\u0002¢\u0006\u0002\u0010*R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0007\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/coolapk/market/view/ad/AdSource;", "", "activity", "Landroid/app/Activity;", "name", "", "appId", "posId", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "adContainer", "Landroid/view/ViewGroup;", "data", "eventListener", "Lcom/coolapk/market/view/ad/OnAdEventListener;", "<set-?>", "", "isLoaded", "()Z", "isSplashShow", "getName", "()Ljava/lang/String;", "skipContainer", "Landroid/view/View;", "timeout", "", "getData", "getSplashSize", "Lkotlin/Pair;", "viewGroup", "getSplashView", "load", "", "listener", "Lcom/coolapk/market/view/ad/OnAdLoadListener;", "loadGDTSplash", "loadTTSplash", "setOnAdEventListener", "setSplashContainer", "setTimeout", "findViewByName", "names", "", "(Landroid/view/ViewGroup;[Ljava/lang/String;)Landroid/view/View;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/coolapk/market/view/ad/AdSource$Companion;", "", "()V", "QQ_SPLASH_IMAGE_VIEW_NAME", "", "QQ_SPLASH_IMAGE_VIEW_NAME_2", "SPLASH_DURATION_TIMEOUT", "", "TT_SPLASH_IMAGE_VIEW_NAME", "checkName", "", "name", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
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
                    SplashViewV9 splashViewV9 = new SplashViewV9(this.activity);
                    splashViewV9.setEventListener(this.eventListener);
                    return splashViewV9;
                }
            } else if (str.equals("QQ_SPLASH")) {
                return view;
            }
        } else if (str.equals("TT_SPLASH")) {
            Object obj = this.data;
            return obj instanceof TTSplashAd ? ((TTSplashAd) obj).getSplashView() : view;
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
                AppSetting appSetting = AppHolder.getAppSetting();
                Intrinsics.checkNotNullExpressionValue(appSetting, "AppHolder.getAppSetting()");
                EntityCard imageCard = appSetting.getImageCard();
                Intrinsics.checkNotNullExpressionValue(imageCard, "AppHolder.getAppSetting().imageCard");
                AppPictureSizeManager.PictureSize size = AppPictureSizeManager.getInstance().getSize(imageCard.getPic());
                if (size == null) {
                    return new Pair<>(1080, 1920);
                }
                int screenWidth = ScreenUtils.getScreenWidth();
                int screenHeight = ScreenUtils.getScreenHeight();
                int height = (size.getHeight() * screenWidth) / size.getWidth();
                if (height <= screenHeight) {
                    screenHeight = height;
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
