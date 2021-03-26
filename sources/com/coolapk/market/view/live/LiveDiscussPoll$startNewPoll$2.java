package com.coolapk.market.view.live;

import kotlin.Metadata;
import rx.Observable;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0012\u0012\u0002\b\u0003 \u0002*\b\u0012\u0002\b\u0003\u0018\u00010\u00010\u00012.\u0010\u0003\u001a*\u0012\u000e\b\u0001\u0012\n \u0002*\u0004\u0018\u00010\u00040\u0004 \u0002*\u0014\u0012\u000e\b\u0001\u0012\n \u0002*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lrx/Observable;", "kotlin.jvm.PlatformType", "next", "Ljava/lang/Void;", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: LiveDiscussPoll.kt */
final class LiveDiscussPoll$startNewPoll$2<T, R> implements Func1<Observable<? extends Void>, Observable<?>> {
    final /* synthetic */ LiveDiscussPoll this$0;

    LiveDiscussPoll$startNewPoll$2(LiveDiscussPoll liveDiscussPoll) {
        this.this$0 = liveDiscussPoll;
    }

    /* JADX DEBUG: Type inference failed for r2v2. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<?> */
    public final Observable<?> call(Observable<? extends Void> observable) {
        return (Observable<R>) observable.flatMap(AnonymousClass1.INSTANCE).takeWhile(new Func1<Long, Boolean>(this) {
            /* class com.coolapk.market.view.live.LiveDiscussPoll$startNewPoll$2.AnonymousClass2 */
            final /* synthetic */ LiveDiscussPoll$startNewPoll$2 this$0;

            {
                this.this$0 = r1;
            }

            public final Boolean call(Long l2) {
                return Boolean.valueOf(this.this$0.this$0.enableSubscription.get());
            }
        });
    }
}
