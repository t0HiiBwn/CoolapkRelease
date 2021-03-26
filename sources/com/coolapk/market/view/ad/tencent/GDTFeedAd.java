package com.coolapk.market.view.ad.tencent;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.view.ad.FeedAdSource;
import com.coolapk.market.view.ad.OnAdEventListener;
import com.coolapk.market.view.ad.OnAdLoadListener;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.NativeExpressAD;
import com.qq.e.ads.nativ.NativeExpressADView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 &2\u00020\u0001:\u0001&B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0016H\u0016J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u000eH\u0016J\b\u0010 \u001a\u00020\u0019H\u0016J\u001a\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010%\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u0014H\u0016R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/coolapk/market/view/ad/tencent/GDTFeedAd;", "Lcom/coolapk/market/view/ad/FeedAdSource;", "context", "Landroid/content/Context;", "postId", "", "count", "", "(Landroid/content/Context;Ljava/lang/String;I)V", "adDataList", "Ljava/util/ArrayList;", "Lcom/qq/e/ads/nativ/NativeExpressADView;", "Lkotlin/collections/ArrayList;", "adLoadListener", "Lcom/coolapk/market/view/ad/OnAdLoadListener;", "adManager", "Lcom/qq/e/ads/nativ/NativeExpressAD;", "getContext", "()Landroid/content/Context;", "eventListener", "Lcom/coolapk/market/view/ad/OnAdEventListener;", "isRelease", "", "state", "detachListeners", "", "ensureAdManager", "firstData", "", "isSucceedLoaded", "load", "listener", "release", "render", "container", "Landroid/view/ViewGroup;", "data", "setOnAdEventListener", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: GDTFeedAd.kt */
public final class GDTFeedAd implements FeedAdSource {
    public static final Companion Companion = new Companion(null);
    private static final int STATE_FAILED = 3;
    private static final int STATE_LOADING = 1;
    private static final int STATE_NONE = 0;
    private static final int STATE_SUCCESS = 2;
    private final ArrayList<NativeExpressADView> adDataList = new ArrayList<>();
    private OnAdLoadListener adLoadListener;
    private NativeExpressAD adManager;
    private final Context context;
    private final int count;
    private OnAdEventListener eventListener;
    private boolean isRelease;
    private final String postId;
    private int state;

    public GDTFeedAd(Context context2, String str, int i) {
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/coolapk/market/view/ad/tencent/GDTFeedAd$Companion;", "", "()V", "STATE_FAILED", "", "STATE_LOADING", "STATE_NONE", "STATE_SUCCESS", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: GDTFeedAd.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void ensureAdManager() {
        if (this.adManager == null) {
            NativeExpressAD nativeExpressAD = new NativeExpressAD(this.context, new ADSize(-1, -2), this.postId, new GDTFeedAd$ensureAdManager$adManager$1(this));
            nativeExpressAD.setVideoOption(new VideoOption.Builder().setAutoPlayPolicy(0).setAutoPlayMuted(true).build());
            nativeExpressAD.setVideoPlayPolicy(1);
            nativeExpressAD.setMinVideoDuration(5);
            nativeExpressAD.setMaxVideoDuration(60);
            this.adManager = nativeExpressAD;
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
            NativeExpressAD nativeExpressAD = this.adManager;
            if (nativeExpressAD != null) {
                nativeExpressAD.loadAD(this.count);
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
        if ((obj instanceof NativeExpressADView) && !Intrinsics.areEqual(viewGroup.getChildAt(0), obj)) {
            View view = (View) obj;
            ViewExtendsKt.detachFromParent(view);
            viewGroup.removeAllViews();
            viewGroup.addView(view);
            ((NativeExpressADView) obj).render();
        }
    }

    @Override // com.coolapk.market.view.ad.FeedAdSource
    public void detachListeners() {
        this.eventListener = null;
        this.adLoadListener = null;
    }
}
