package com.coolapk.market.view.ad.toutiao;

import android.view.View;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.view.ad.OnAdEventListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"renderAndAutoNext", "", "Lcom/bytedance/sdk/openadsdk/TTNativeExpressAd;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: TTFeedAd.kt */
final class TTFeedAd$processAdData$1 extends Lambda implements Function1<TTNativeExpressAd, Unit> {
    final /* synthetic */ TTFeedAd this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TTFeedAd$processAdData$1(TTFeedAd tTFeedAd) {
        super(1);
        this.this$0 = tTFeedAd;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(TTNativeExpressAd tTNativeExpressAd) {
        invoke(tTNativeExpressAd);
        return Unit.INSTANCE;
    }

    public final void invoke(final TTNativeExpressAd tTNativeExpressAd) {
        Intrinsics.checkNotNullParameter(tTNativeExpressAd, "$this$renderAndAutoNext");
        tTNativeExpressAd.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener(this) {
            /* class com.coolapk.market.view.ad.toutiao.TTFeedAd$processAdData$1.AnonymousClass1 */
            final /* synthetic */ TTFeedAd$processAdData$1 this$0;

            {
                this.this$0 = r1;
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdClicked(View view, int i) {
                OnAdEventListener onAdEventListener = this.this$0.this$0.eventListener;
                if (onAdEventListener != null) {
                    View expressAdView = tTNativeExpressAd.getExpressAdView();
                    Intrinsics.checkNotNullExpressionValue(expressAdView, "data.expressAdView");
                    onAdEventListener.onAdClick(expressAdView, tTNativeExpressAd);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdShow(View view, int i) {
                OnAdEventListener onAdEventListener = this.this$0.this$0.eventListener;
                if (onAdEventListener != null) {
                    onAdEventListener.onAdShow(tTNativeExpressAd);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderFail(View view, String str, int i) {
                Intrinsics.checkNotNullParameter(str, "msg");
                LogUtils.e(str + " code:" + i, new Object[0]);
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderSuccess(View view, float f, float f2) {
                LogUtils.e("渲染成功", new Object[0]);
            }
        });
        tTNativeExpressAd.render();
    }
}
