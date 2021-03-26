package com.coolapk.market.view.ad.tencent;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.view.ad.FeedAdSource;
import com.coolapk.market.view.ad.OnAdEventListener;
import com.coolapk.market.view.ad.OnAdLoadListener;
import com.qq.e.ads.nativ.express2.NativeExpressAD2;
import com.qq.e.ads.nativ.express2.NativeExpressADData2;
import com.qq.e.ads.nativ.express2.VideoOption2;
import com.qq.e.comm.util.AdError;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0001.B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0002J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0017H\u0016J\u0010\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u000fH\u0016J\u0018\u0010!\u001a\u00020\u001a2\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010#H\u0016J\u0010\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020\u001aH\u0002J\b\u0010(\u001a\u00020\u001aH\u0016J\u001a\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010-\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u0015H\u0016R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/coolapk/market/view/ad/tencent/GDTFeedAd2;", "Lcom/qq/e/ads/nativ/express2/NativeExpressAD2$AdLoadListener;", "Lcom/coolapk/market/view/ad/FeedAdSource;", "context", "Landroid/content/Context;", "postId", "", "count", "", "(Landroid/content/Context;Ljava/lang/String;I)V", "adDataList", "Ljava/util/ArrayList;", "Lcom/qq/e/ads/nativ/express2/NativeExpressADData2;", "Lkotlin/collections/ArrayList;", "adLoadListener", "Lcom/coolapk/market/view/ad/OnAdLoadListener;", "adManager", "Lcom/qq/e/ads/nativ/express2/NativeExpressAD2;", "getContext", "()Landroid/content/Context;", "eventListener", "Lcom/coolapk/market/view/ad/OnAdEventListener;", "isRelease", "", "state", "detachListeners", "", "ensureAdManager", "firstData", "", "isSucceedLoaded", "load", "listener", "onLoadSuccess", "adList", "", "onNoAD", "error", "Lcom/qq/e/comm/util/AdError;", "processAdData", "release", "render", "container", "Landroid/view/ViewGroup;", "data", "setOnAdEventListener", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: GDTFeedAd2.kt */
public final class GDTFeedAd2 implements NativeExpressAD2.AdLoadListener, FeedAdSource {
    public static final Companion Companion = new Companion(null);
    private static final int STATE_FAILED = 3;
    private static final int STATE_LOADING = 1;
    private static final int STATE_NONE = 0;
    private static final int STATE_SUCCESS = 2;
    private final ArrayList<NativeExpressADData2> adDataList = new ArrayList<>();
    private OnAdLoadListener adLoadListener;
    private NativeExpressAD2 adManager;
    private final Context context;
    private final int count;
    private OnAdEventListener eventListener;
    private boolean isRelease;
    private final String postId;
    private int state;

    public GDTFeedAd2(Context context2, String str, int i) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(str, "postId");
        this.context = context2;
        this.postId = str;
        this.count = i;
    }

    public final Context getContext() {
        return this.context;
    }

    @Override // com.coolapk.market.view.ad.FeedAdSource
    public void onResume() {
        FeedAdSource.DefaultImpls.onResume(this);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/coolapk/market/view/ad/tencent/GDTFeedAd2$Companion;", "", "()V", "STATE_FAILED", "", "STATE_LOADING", "STATE_NONE", "STATE_SUCCESS", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: GDTFeedAd2.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void ensureAdManager() {
        if (this.adManager == null) {
            NativeExpressAD2 nativeExpressAD2 = new NativeExpressAD2(this.context, this.postId, this);
            nativeExpressAD2.setAdSize(-1, -2);
            VideoOption2.Builder builder = new VideoOption2.Builder();
            builder.setAutoPlayPolicy(VideoOption2.AutoPlayPolicy.WIFI).setAutoPlayMuted(true).setDetailPageMuted(false).setMinVideoDuration(5).setMaxVideoDuration(60);
            nativeExpressAD2.setVideoOption2(builder.build());
            this.adManager = nativeExpressAD2;
        }
    }

    @Override // com.qq.e.ads.AbstractAD.BasicADListener
    public void onNoAD(AdError adError) {
        Intrinsics.checkNotNullParameter(adError, "error");
        LogUtils.e("广告加载失败, " + adError.getErrorCode() + ':' + adError.getErrorMsg(), new Object[0]);
        this.state = 3;
        OnAdLoadListener onAdLoadListener = this.adLoadListener;
        if (onAdLoadListener != null) {
            onAdLoadListener.onLoadError(new Exception(adError.getErrorCode() + ": " + adError.getErrorMsg()));
        }
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressAD2.AdLoadListener
    public void onLoadSuccess(List<NativeExpressADData2> list) {
        List<NativeExpressADData2> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            LogUtils.w("广告加载失败, 没有数据", new Object[0]);
            this.state = 3;
            OnAdLoadListener onAdLoadListener = this.adLoadListener;
            if (onAdLoadListener != null) {
                onAdLoadListener.onLoadError(new Exception("Ads is null on feed ad loaded"));
                return;
            }
            return;
        }
        LogUtils.i("广告加载成功，有" + list.size() + "条数据", new Object[0]);
        this.state = 2;
        if (this.isRelease) {
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                it2.next().destroy();
            }
            return;
        }
        this.adDataList.addAll(list2);
        processAdData();
        OnAdLoadListener onAdLoadListener2 = this.adLoadListener;
        if (onAdLoadListener2 != null) {
            onAdLoadListener2.onLoadSuccess(list);
        }
    }

    private final void processAdData() {
        if (!this.isRelease && !this.adDataList.isEmpty()) {
            ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue(this.adDataList);
            GDTFeedAd2$processAdData$1 gDTFeedAd2$processAdData$1 = new GDTFeedAd2$processAdData$1(this, concurrentLinkedQueue);
            NativeExpressADData2 nativeExpressADData2 = (NativeExpressADData2) concurrentLinkedQueue.poll();
            if (nativeExpressADData2 != null) {
                gDTFeedAd2$processAdData$1.invoke(nativeExpressADData2);
            }
        }
    }

    @Override // com.coolapk.market.view.ad.FeedAdSource
    public void load(OnAdLoadListener onAdLoadListener) {
        Intrinsics.checkNotNullParameter(onAdLoadListener, "listener");
        this.adLoadListener = onAdLoadListener;
        if (this.state == 0) {
            LogUtils.d("开始加载广告", new Object[0]);
            this.state = 1;
            ensureAdManager();
            NativeExpressAD2 nativeExpressAD2 = this.adManager;
            if (nativeExpressAD2 != null) {
                nativeExpressAD2.loadAd(this.count);
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
        Iterator<T> it2 = this.adDataList.iterator();
        while (it2.hasNext()) {
            it2.next().destroy();
        }
        this.adDataList.clear();
    }

    @Override // com.coolapk.market.view.ad.FeedAdSource
    public void render(ViewGroup viewGroup, Object obj) {
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        if (obj instanceof NativeExpressADData2) {
            View adView = ((NativeExpressADData2) obj).getAdView();
            if (!Intrinsics.areEqual(viewGroup.getChildAt(0), adView)) {
                Intrinsics.checkNotNullExpressionValue(adView, "view");
                ViewExtendsKt.detachFromParent(adView);
                viewGroup.removeAllViews();
                viewGroup.addView(adView);
            }
        }
    }

    @Override // com.coolapk.market.view.ad.FeedAdSource
    public void detachListeners() {
        this.eventListener = null;
        this.adLoadListener = null;
    }
}
