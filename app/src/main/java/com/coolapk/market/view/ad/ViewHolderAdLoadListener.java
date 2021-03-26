package com.coolapk.market.view.ad;

import android.view.View;
import com.blankj.utilcode.util.EncryptUtils;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.view.ad.EntityAdHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0012\u0010\u001b\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/coolapk/market/view/ad/ViewHolderAdLoadListener;", "Lcom/coolapk/market/view/ad/OnAdEventListener;", "Lcom/coolapk/market/view/ad/OnAdLoadListener;", "name", "", "appId", "posId", "adViewHolderCallback", "Lcom/coolapk/market/view/ad/EntityAdHelper$AdViewHolderCallback;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/coolapk/market/view/ad/EntityAdHelper$AdViewHolderCallback;)V", "getAdViewHolderCallback", "()Lcom/coolapk/market/view/ad/EntityAdHelper$AdViewHolderCallback;", "setAdViewHolderCallback", "(Lcom/coolapk/market/view/ad/EntityAdHelper$AdViewHolderCallback;)V", "getAppId", "()Ljava/lang/String;", "getName", "getPosId", "onAdClose", "", "view", "Landroid/view/View;", "data", "", "onLoadError", "e", "", "onLoadSuccess", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: EntityAdHelper.kt */
final class ViewHolderAdLoadListener extends OnAdEventListener implements OnAdLoadListener {
    private EntityAdHelper.AdViewHolderCallback adViewHolderCallback;
    private final String appId;
    private final String name;
    private final String posId;

    public final String getName() {
        return this.name;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getPosId() {
        return this.posId;
    }

    public final EntityAdHelper.AdViewHolderCallback getAdViewHolderCallback() {
        return this.adViewHolderCallback;
    }

    public final void setAdViewHolderCallback(EntityAdHelper.AdViewHolderCallback adViewHolderCallback2) {
        this.adViewHolderCallback = adViewHolderCallback2;
    }

    public ViewHolderAdLoadListener(String str, String str2, String str3, EntityAdHelper.AdViewHolderCallback adViewHolderCallback2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "appId");
        Intrinsics.checkNotNullParameter(str3, "posId");
        this.name = str;
        this.appId = str2;
        this.posId = str3;
        this.adViewHolderCallback = adViewHolderCallback2;
    }

    @Override // com.coolapk.market.view.ad.OnAdLoadListener
    public void onLoadSuccess(Object obj) {
        LogUtils.i("广告成功", new Object[0]);
        if (obj != null) {
            for (Object obj2 : (List) obj) {
                AdInfo adInfo = null;
                if (obj2 instanceof View) {
                    adInfo = FeedAdUtils.INSTANCE.getAdInfo(this.name, this.appId, this.posId, (View) obj2);
                }
                if (adInfo != null) {
                    String encryptMD5ToString = EncryptUtils.encryptMD5ToString(adInfo.getTitle());
                    FeedAdUtils feedAdUtils = FeedAdUtils.INSTANCE;
                    String str = this.name;
                    Intrinsics.checkNotNullExpressionValue(encryptMD5ToString, "adMark");
                    if (feedAdUtils.containBandAd(str, encryptMD5ToString)) {
                        LogUtils.w("这个广告已屏蔽 " + adInfo, new Object[0]);
                        EntityAdHelper.AdViewHolderCallback adViewHolderCallback2 = this.adViewHolderCallback;
                        if (adViewHolderCallback2 != null) {
                            adViewHolderCallback2.onAdBan(adInfo);
                            return;
                        }
                        return;
                    }
                }
            }
        }
        EntityAdHelper.AdViewHolderCallback adViewHolderCallback3 = this.adViewHolderCallback;
        if (adViewHolderCallback3 != null) {
            adViewHolderCallback3.onAdLoadSuccess();
        }
    }

    @Override // com.coolapk.market.view.ad.OnAdLoadListener
    public void onLoadError(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "e");
        LogUtils.e("广告加载失败", th);
        EntityAdHelper.AdViewHolderCallback adViewHolderCallback2 = this.adViewHolderCallback;
        if (adViewHolderCallback2 != null) {
            adViewHolderCallback2.onAdLoadFail();
        }
    }

    @Override // com.coolapk.market.view.ad.OnAdEventListener
    public void onAdClose(View view, Object obj) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onAdClose(view, obj);
        AdInfo adInfo = FeedAdUtils.INSTANCE.getAdInfo(this.name, this.appId, this.posId, view);
        if (adInfo != null) {
            String encryptMD5ToString = EncryptUtils.encryptMD5ToString(adInfo.getTitle());
            FeedAdUtils feedAdUtils = FeedAdUtils.INSTANCE;
            String str = this.name;
            Intrinsics.checkNotNullExpressionValue(encryptMD5ToString, "adMark");
            feedAdUtils.banAd(str, encryptMD5ToString);
            ActionManager.reportSponsorClose(view.getContext(), adInfo.getId(), adInfo.getName(), adInfo.getAppId(), adInfo.getPosId(), adInfo.getTitle(), adInfo.getDesc(), adInfo.getPics(), adInfo.getInfo(), 0);
        }
        EntityAdHelper.AdViewHolderCallback adViewHolderCallback2 = this.adViewHolderCallback;
        if (adViewHolderCallback2 != null) {
            adViewHolderCallback2.onAdClose();
        }
    }
}
