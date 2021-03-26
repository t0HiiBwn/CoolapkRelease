package com.coolapk.market.view.ad.toutiao;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.blankj.utilcode.util.ConvertUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.view.ad.FeedAdSource;
import com.coolapk.market.view.ad.OnAdEventListener;
import com.coolapk.market.view.ad.OnAdLoadListener;
import com.coolapk.market.view.cardlist.divider.ViewMarginData;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 32\u00020\u0001:\u00013B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\fH\u0002J\b\u0010&\u001a\u00020$H\u0016J\n\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010)\u001a\u00020\u0015H\u0016J\u0010\u0010*\u001a\u00020$2\u0006\u0010+\u001a\u00020\u000fH\u0016J\b\u0010,\u001a\u00020$H\u0002J\b\u0010-\u001a\u00020$H\u0016J\u001a\u0010.\u001a\u00020$2\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010(H\u0016J\u0010\u00102\u001a\u00020$2\u0006\u0010+\u001a\u00020\u0013H\u0016R\"\u0010\n\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bj\n\u0012\u0006\u0012\u0004\u0018\u00010\f`\rX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR#\u0010\u001d\u001a\n \u001f*\u0004\u0018\u00010\u001e0\u001e8BX\u0002¢\u0006\f\n\u0004\b\"\u0010\u001c\u001a\u0004\b \u0010!¨\u00064"}, d2 = {"Lcom/coolapk/market/view/ad/toutiao/TTFeedAd;", "Lcom/coolapk/market/view/ad/FeedAdSource;", "context", "Landroid/content/Context;", "appId", "", "codeId", "count", "", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)V", "adDataList", "Ljava/util/ArrayList;", "Lcom/bytedance/sdk/openadsdk/TTNativeExpressAd;", "Lkotlin/collections/ArrayList;", "adLoadListener", "Lcom/coolapk/market/view/ad/OnAdLoadListener;", "getContext", "()Landroid/content/Context;", "eventListener", "Lcom/coolapk/market/view/ad/OnAdEventListener;", "isRelease", "", "state", "ttAdManager", "Lcom/bytedance/sdk/openadsdk/TTAdManager;", "getTtAdManager", "()Lcom/bytedance/sdk/openadsdk/TTAdManager;", "ttAdManager$delegate", "Lkotlin/Lazy;", "ttAdNative", "Lcom/bytedance/sdk/openadsdk/TTAdNative;", "kotlin.jvm.PlatformType", "getTtAdNative", "()Lcom/bytedance/sdk/openadsdk/TTAdNative;", "ttAdNative$delegate", "bindDislike", "", "ad", "detachListeners", "firstData", "", "isSucceedLoaded", "load", "listener", "processAdData", "release", "render", "container", "Landroid/view/ViewGroup;", "data", "setOnAdEventListener", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: TTFeedAd.kt */
public final class TTFeedAd implements FeedAdSource {
    public static final Companion Companion = new Companion(null);
    private static final int STATE_FAILED = 3;
    private static final int STATE_LOADING = 1;
    private static final int STATE_NONE = 0;
    private static final int STATE_SUCCESS = 2;
    private final ArrayList<TTNativeExpressAd> adDataList = new ArrayList<>();
    private OnAdLoadListener adLoadListener;
    private final String appId;
    private final String codeId;
    private final Context context;
    private final int count;
    private OnAdEventListener eventListener;
    private boolean isRelease;
    private int state;
    private final Lazy ttAdManager$delegate = LazyKt.lazy(TTFeedAd$ttAdManager$2.INSTANCE);
    private final Lazy ttAdNative$delegate = LazyKt.lazy(new TTFeedAd$ttAdNative$2(this));

    /* access modifiers changed from: private */
    public final TTAdManager getTtAdManager() {
        return (TTAdManager) this.ttAdManager$delegate.getValue();
    }

    private final TTAdNative getTtAdNative() {
        return (TTAdNative) this.ttAdNative$delegate.getValue();
    }

    public TTFeedAd(Context context2, String str, String str2, int i) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(str, "appId");
        Intrinsics.checkNotNullParameter(str2, "codeId");
        this.context = context2;
        this.appId = str;
        this.codeId = str2;
        this.count = i;
    }

    public final Context getContext() {
        return this.context;
    }

    @Override // com.coolapk.market.view.ad.FeedAdSource
    public void onResume() {
        FeedAdSource.DefaultImpls.onResume(this);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/coolapk/market/view/ad/toutiao/TTFeedAd$Companion;", "", "()V", "STATE_FAILED", "", "STATE_LOADING", "STATE_NONE", "STATE_SUCCESS", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: TTFeedAd.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.view.ad.FeedAdSource
    public void load(OnAdLoadListener onAdLoadListener) {
        Intrinsics.checkNotNullParameter(onAdLoadListener, "listener");
        this.adLoadListener = onAdLoadListener;
        if (this.state == 0) {
            LogUtils.d("开始加载广告", new Object[0]);
            this.state = 1;
            getTtAdNative().loadNativeExpressAd(new AdSlot.Builder().setCodeId(this.codeId).setAdCount(this.count).setExpressViewAcceptedSize((float) ConvertUtils.px2dp(((float) ScreenUtils.getScreenWidth()) - (((float) ViewMarginData.Companion.getDEFAULT_SIZE()) * 2.0f)), 0.0f).build(), new TTFeedAd$load$1(this));
        }
    }

    /* access modifiers changed from: private */
    public final void processAdData() {
        if (!this.isRelease && !this.adDataList.isEmpty()) {
            ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue(this.adDataList);
            TTFeedAd$processAdData$1 tTFeedAd$processAdData$1 = new TTFeedAd$processAdData$1(this);
            TTNativeExpressAd tTNativeExpressAd = (TTNativeExpressAd) concurrentLinkedQueue.poll();
            if (tTNativeExpressAd != null) {
                tTFeedAd$processAdData$1.invoke(tTNativeExpressAd);
            }
        }
    }

    @Override // com.coolapk.market.view.ad.FeedAdSource
    public boolean isSucceedLoaded() {
        return this.state == 2;
    }

    @Override // com.coolapk.market.view.ad.FeedAdSource
    public Object firstData() {
        return CollectionsKt.firstOrNull((List<? extends Object>) this.adDataList);
    }

    @Override // com.coolapk.market.view.ad.FeedAdSource
    public void setOnAdEventListener(OnAdEventListener onAdEventListener) {
        Intrinsics.checkNotNullParameter(onAdEventListener, "listener");
        this.eventListener = onAdEventListener;
    }

    @Override // com.coolapk.market.view.ad.FeedAdSource
    public void release() {
        this.isRelease = true;
        for (T t : this.adDataList) {
            if (t != null) {
                t.destroy();
            }
        }
        this.adDataList.clear();
    }

    @Override // com.coolapk.market.view.ad.FeedAdSource
    public void render(ViewGroup viewGroup, Object obj) {
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        if (obj instanceof TTNativeExpressAd) {
            TTNativeExpressAd tTNativeExpressAd = (TTNativeExpressAd) obj;
            bindDislike(tTNativeExpressAd);
            View expressAdView = tTNativeExpressAd.getExpressAdView();
            if (!Intrinsics.areEqual(viewGroup.getChildAt(0), expressAdView)) {
                Intrinsics.checkNotNullExpressionValue(expressAdView, "view");
                ViewExtendsKt.detachFromParent(expressAdView);
                viewGroup.removeAllViews();
                viewGroup.addView(expressAdView);
                tTNativeExpressAd.render();
            }
        }
    }

    private final void bindDislike(TTNativeExpressAd tTNativeExpressAd) {
        List<FilterWord> filterWords = tTNativeExpressAd.getFilterWords();
        List<FilterWord> list = filterWords;
        if (!(list == null || list.isEmpty())) {
            DislikeDialog dislikeDialog = new DislikeDialog(this.context, filterWords);
            dislikeDialog.setOnDislikeItemClick(new TTFeedAd$bindDislike$1(this, tTNativeExpressAd));
            tTNativeExpressAd.setDislikeDialog(dislikeDialog);
            Context context2 = this.context;
            if (!(context2 instanceof Activity)) {
                context2 = null;
            }
            tTNativeExpressAd.setDislikeCallback((Activity) context2, new TTFeedAd$bindDislike$2(this, tTNativeExpressAd));
        }
    }

    @Override // com.coolapk.market.view.ad.FeedAdSource
    public void detachListeners() {
        this.eventListener = null;
        this.adLoadListener = null;
    }
}
