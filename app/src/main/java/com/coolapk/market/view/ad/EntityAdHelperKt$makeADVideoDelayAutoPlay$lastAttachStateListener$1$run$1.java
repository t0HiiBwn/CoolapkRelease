package com.coolapk.market.view.ad;

import com.coolapk.market.util.LogUtils;
import com.qq.e.ads.nativ.VideoPreloadListener;
import kotlin.Metadata;
import kotlin.Unit;
import rx.Observable;
import rx.functions.Func0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lrx/Observable;", "", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: EntityAdHelper.kt */
final class EntityAdHelperKt$makeADVideoDelayAutoPlay$lastAttachStateListener$1$run$1<R> implements Func0<Observable<Unit>> {
    final /* synthetic */ EntityAdHelperKt$makeADVideoDelayAutoPlay$lastAttachStateListener$1 this$0;

    EntityAdHelperKt$makeADVideoDelayAutoPlay$lastAttachStateListener$1$run$1(EntityAdHelperKt$makeADVideoDelayAutoPlay$lastAttachStateListener$1 entityAdHelperKt$makeADVideoDelayAutoPlay$lastAttachStateListener$1) {
        this.this$0 = entityAdHelperKt$makeADVideoDelayAutoPlay$lastAttachStateListener$1;
    }

    @Override // rx.functions.Func0, java.util.concurrent.Callable
    public final Observable<Unit> call() {
        this.this$0.$adData.preloadVideo(new VideoPreloadListener(this) {
            /* class com.coolapk.market.view.ad.EntityAdHelperKt$makeADVideoDelayAutoPlay$lastAttachStateListener$1$run$1.AnonymousClass1 */
            final /* synthetic */ EntityAdHelperKt$makeADVideoDelayAutoPlay$lastAttachStateListener$1$run$1 this$0;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.this$0 = r1;
            }

            @Override // com.qq.e.ads.nativ.VideoPreloadListener
            public void onVideoCached() {
                if (this.this$0.this$0.$view.isAttachedToWindow()) {
                    this.this$0.this$0.$adData.startVideo();
                    LogUtils.d("开始播放 from onVideoCached", new Object[0]);
                }
            }

            @Override // com.qq.e.ads.nativ.VideoPreloadListener
            public void onVideoCacheFailed(int i, String str) {
                LogUtils.d("onVideoCacheFailed", new Object[0]);
            }
        });
        return Observable.empty();
    }
}
