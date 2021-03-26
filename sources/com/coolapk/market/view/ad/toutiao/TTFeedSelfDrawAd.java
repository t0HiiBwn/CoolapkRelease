package com.coolapk.market.view.ad.toutiao;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.view.ad.FeedAdSource;
import com.coolapk.market.view.ad.OnAdEventListener;
import com.coolapk.market.view.ad.OnAdLoadListener;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 02\u00020\u0001:\u00010B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010#\u001a\u00020$H\u0016J\n\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010'\u001a\u00020\u0015H\u0016J\u0010\u0010(\u001a\u00020$2\u0006\u0010)\u001a\u00020\u000fH\u0016J\b\u0010*\u001a\u00020$H\u0016J\u001a\u0010+\u001a\u00020$2\u0006\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010&H\u0016J\u0010\u0010/\u001a\u00020$2\u0006\u0010)\u001a\u00020\u0013H\u0016R\"\u0010\n\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bj\n\u0012\u0006\u0012\u0004\u0018\u00010\f`\rX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR#\u0010\u001d\u001a\n \u001f*\u0004\u0018\u00010\u001e0\u001e8BX\u0002¢\u0006\f\n\u0004\b\"\u0010\u001c\u001a\u0004\b \u0010!¨\u00061"}, d2 = {"Lcom/coolapk/market/view/ad/toutiao/TTFeedSelfDrawAd;", "Lcom/coolapk/market/view/ad/FeedAdSource;", "context", "Landroid/content/Context;", "appId", "", "codeId", "count", "", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)V", "adDataList", "Ljava/util/ArrayList;", "Lcom/bytedance/sdk/openadsdk/TTFeedAd;", "Lkotlin/collections/ArrayList;", "adLoadListener", "Lcom/coolapk/market/view/ad/OnAdLoadListener;", "getContext", "()Landroid/content/Context;", "eventListener", "Lcom/coolapk/market/view/ad/OnAdEventListener;", "isRelease", "", "state", "ttAdManager", "Lcom/bytedance/sdk/openadsdk/TTAdManager;", "getTtAdManager", "()Lcom/bytedance/sdk/openadsdk/TTAdManager;", "ttAdManager$delegate", "Lkotlin/Lazy;", "ttAdNative", "Lcom/bytedance/sdk/openadsdk/TTAdNative;", "kotlin.jvm.PlatformType", "getTtAdNative", "()Lcom/bytedance/sdk/openadsdk/TTAdNative;", "ttAdNative$delegate", "detachListeners", "", "firstData", "", "isSucceedLoaded", "load", "listener", "release", "render", "container", "Landroid/view/ViewGroup;", "data", "setOnAdEventListener", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: TTFeedSelfDrawAd.kt */
public final class TTFeedSelfDrawAd implements FeedAdSource {
    public static final Companion Companion = new Companion(null);
    private static final int STATE_FAILED = 3;
    private static final int STATE_LOADING = 1;
    private static final int STATE_NONE = 0;
    private static final int STATE_SUCCESS = 2;
    private final ArrayList<TTFeedAd> adDataList = new ArrayList<>();
    private OnAdLoadListener adLoadListener;
    private final String appId;
    private final String codeId;
    private final Context context;
    private final int count;
    private OnAdEventListener eventListener;
    private boolean isRelease;
    private int state;
    private final Lazy ttAdManager$delegate = LazyKt.lazy(TTFeedSelfDrawAd$ttAdManager$2.INSTANCE);
    private final Lazy ttAdNative$delegate = LazyKt.lazy(new TTFeedSelfDrawAd$ttAdNative$2(this));

    /* access modifiers changed from: private */
    public final TTAdManager getTtAdManager() {
        return (TTAdManager) this.ttAdManager$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final TTAdNative getTtAdNative() {
        return (TTAdNative) this.ttAdNative$delegate.getValue();
    }

    public TTFeedSelfDrawAd(Context context2, String str, String str2, int i) {
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/coolapk/market/view/ad/toutiao/TTFeedSelfDrawAd$Companion;", "", "()V", "STATE_FAILED", "", "STATE_LOADING", "STATE_NONE", "STATE_SUCCESS", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: TTFeedSelfDrawAd.kt */
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
            Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new TTFeedSelfDrawAd$load$1(this, new AdSlot.Builder().setCodeId(this.codeId).setAdCount(this.count).setImageAcceptedSize(640, 320).build(), null), 2, null);
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
        this.adDataList.clear();
    }

    @Override // com.coolapk.market.view.ad.FeedAdSource
    public void render(ViewGroup viewGroup, Object obj) {
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        throw new IllegalStateException("SELF DRAW NOT SUPPORT");
    }

    @Override // com.coolapk.market.view.ad.FeedAdSource
    public void detachListeners() {
        this.eventListener = null;
        this.adLoadListener = null;
    }
}
