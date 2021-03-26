package com.coolapk.market.view.ad.tencent;

import android.view.View;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.view.ad.OnAdEventListener;
import com.qq.e.ads.nativ.express2.AdEventListener;
import com.qq.e.ads.nativ.express2.MediaEventListener;
import com.qq.e.ads.nativ.express2.NativeExpressADData2;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"renderAndAutoNext", "", "Lcom/qq/e/ads/nativ/express2/NativeExpressADData2;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: GDTFeedAd2.kt */
final class GDTFeedAd2$processAdData$1 extends Lambda implements Function1<NativeExpressADData2, Unit> {
    final /* synthetic */ ConcurrentLinkedQueue $queue;
    final /* synthetic */ GDTFeedAd2 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GDTFeedAd2$processAdData$1(GDTFeedAd2 gDTFeedAd2, ConcurrentLinkedQueue concurrentLinkedQueue) {
        super(1);
        this.this$0 = gDTFeedAd2;
        this.$queue = concurrentLinkedQueue;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(NativeExpressADData2 nativeExpressADData2) {
        invoke(nativeExpressADData2);
        return Unit.INSTANCE;
    }

    public final void invoke(final NativeExpressADData2 nativeExpressADData2) {
        Intrinsics.checkNotNullParameter(nativeExpressADData2, "$this$renderAndAutoNext");
        nativeExpressADData2.setAdEventListener(new AdEventListener(this) {
            /* class com.coolapk.market.view.ad.tencent.GDTFeedAd2$processAdData$1.AnonymousClass1 */
            final /* synthetic */ GDTFeedAd2$processAdData$1 this$0;

            {
                this.this$0 = r1;
            }

            @Override // com.qq.e.ads.nativ.express2.AdEventListener
            public void onAdClosed() {
                OnAdEventListener onAdEventListener = this.this$0.this$0.eventListener;
                if (onAdEventListener != null) {
                    View adView = nativeExpressADData2.getAdView();
                    Intrinsics.checkNotNullExpressionValue(adView, "data.adView");
                    onAdEventListener.onAdClose(adView, nativeExpressADData2);
                }
            }

            @Override // com.qq.e.ads.nativ.express2.AdEventListener
            public void onClick() {
                OnAdEventListener onAdEventListener = this.this$0.this$0.eventListener;
                if (onAdEventListener != null) {
                    View adView = nativeExpressADData2.getAdView();
                    Intrinsics.checkNotNullExpressionValue(adView, "data.adView");
                    onAdEventListener.onAdClick(adView, nativeExpressADData2);
                }
            }

            @Override // com.qq.e.ads.nativ.express2.AdEventListener
            public void onExposed() {
                OnAdEventListener onAdEventListener = this.this$0.this$0.eventListener;
                if (onAdEventListener != null) {
                    onAdEventListener.onAdShow(nativeExpressADData2);
                }
            }

            @Override // com.qq.e.ads.nativ.express2.AdEventListener
            public void onRenderFail() {
                LogUtils.e("广告渲染失败", new Object[0]);
                NativeExpressADData2 nativeExpressADData2 = (NativeExpressADData2) this.this$0.$queue.poll();
                if (nativeExpressADData2 != null) {
                    this.this$0.invoke(nativeExpressADData2);
                }
            }

            @Override // com.qq.e.ads.nativ.express2.AdEventListener
            public void onRenderSuccess() {
                LogUtils.i("广告渲染成功", new Object[0]);
                NativeExpressADData2 nativeExpressADData2 = (NativeExpressADData2) this.this$0.$queue.poll();
                if (nativeExpressADData2 != null) {
                    this.this$0.invoke(nativeExpressADData2);
                }
            }
        });
        nativeExpressADData2.setMediaListener(new MediaEventListener() {
            /* class com.coolapk.market.view.ad.tencent.GDTFeedAd2$processAdData$1.AnonymousClass2 */

            @Override // com.qq.e.ads.nativ.express2.MediaEventListener
            public void onVideoCache() {
            }

            @Override // com.qq.e.ads.nativ.express2.MediaEventListener
            public void onVideoComplete() {
            }

            @Override // com.qq.e.ads.nativ.express2.MediaEventListener
            public void onVideoError() {
            }

            @Override // com.qq.e.ads.nativ.express2.MediaEventListener
            public void onVideoPause() {
            }

            @Override // com.qq.e.ads.nativ.express2.MediaEventListener
            public void onVideoResume() {
            }

            @Override // com.qq.e.ads.nativ.express2.MediaEventListener
            public void onVideoStart() {
            }
        });
        nativeExpressADData2.render();
    }
}
