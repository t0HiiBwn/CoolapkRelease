package com.coolapk.market.view.ad.toutiao;

import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.view.ad.OnAdLoadListener;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.coolapk.market.view.ad.toutiao.TTFeedSelfDrawAd$load$1", f = "TTFeedSelfDrawAd.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: TTFeedSelfDrawAd.kt */
final class TTFeedSelfDrawAd$load$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AdSlot $adSlot;
    int label;
    final /* synthetic */ TTFeedSelfDrawAd this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TTFeedSelfDrawAd$load$1(TTFeedSelfDrawAd tTFeedSelfDrawAd, AdSlot adSlot, Continuation continuation) {
        super(2, continuation);
        this.this$0 = tTFeedSelfDrawAd;
        this.$adSlot = adSlot;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new TTFeedSelfDrawAd$load$1(this.this$0, this.$adSlot, continuation);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TTFeedSelfDrawAd$load$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.getTtAdNative().loadFeedAd(this.$adSlot, new TTAdNative.FeedAdListener(this) {
                /* class com.coolapk.market.view.ad.toutiao.TTFeedSelfDrawAd$load$1.AnonymousClass1 */
                final /* synthetic */ TTFeedSelfDrawAd$load$1 this$0;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                {
                    this.this$0 = r1;
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener, com.bytedance.sdk.openadsdk.a.b
                public void onError(int i, String str) {
                    Intrinsics.checkNotNullParameter(str, "message");
                    LogUtils.e("广告加载失败, " + i + ':' + str, new Object[0]);
                    this.this$0.this$0.state = 3;
                    OnAdLoadListener onAdLoadListener = this.this$0.this$0.adLoadListener;
                    if (onAdLoadListener != null) {
                        onAdLoadListener.onLoadError(new Exception(i + ": " + str));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
                public void onFeedAdLoad(List<TTFeedAd> list) {
                    List<TTFeedAd> list2 = list;
                    if (list2 == null || list2.isEmpty()) {
                        LogUtils.w("广告加载失败, 没有数据", new Object[0]);
                        this.this$0.this$0.state = 3;
                        OnAdLoadListener onAdLoadListener = this.this$0.this$0.adLoadListener;
                        if (onAdLoadListener != null) {
                            onAdLoadListener.onLoadError(new Exception("Ads is null on feed ad loaded"));
                            return;
                        }
                        return;
                    }
                    LogUtils.i("广告加载成功，有" + list.size() + "条数据", new Object[0]);
                    this.this$0.this$0.state = 2;
                    this.this$0.this$0.adDataList.addAll(list2);
                    OnAdLoadListener onAdLoadListener2 = this.this$0.this$0.adLoadListener;
                    if (onAdLoadListener2 != null) {
                        onAdLoadListener2.onLoadSuccess(list);
                    }
                }
            });
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
