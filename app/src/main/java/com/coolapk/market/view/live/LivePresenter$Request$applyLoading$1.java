package com.coolapk.market.view.live;

import com.coolapk.market.view.live.LivePresenter;
import kotlin.Metadata;
import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u0001H\u0002H\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u0001H\u0002H\u0002\u0018\u00010\u00010\u0001\"\u0004\b\u0000\u0010\u00022*\u0010\u0004\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u0001H\u0002H\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u0001H\u0002H\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lrx/Observable;", "T", "kotlin.jvm.PlatformType", "observable", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: LivePresenter.kt */
final class LivePresenter$Request$applyLoading$1<T, R> implements Observable.Transformer<T, T> {
    final /* synthetic */ LivePresenter.Request this$0;

    LivePresenter$Request$applyLoading$1(LivePresenter.Request request) {
        this.this$0 = request;
    }

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Observable) ((Observable) obj));
    }

    public final Observable<T> call(Observable<T> observable) {
        return observable.doOnSubscribe(new Action0(this) {
            /* class com.coolapk.market.view.live.LivePresenter$Request$applyLoading$1.AnonymousClass1 */
            final /* synthetic */ LivePresenter$Request$applyLoading$1 this$0;

            {
                this.this$0 = r1;
            }

            @Override // rx.functions.Action0
            public final void call() {
                this.this$0.this$0.setLoading(true);
            }
        }).doOnUnsubscribe(new Action0(this) {
            /* class com.coolapk.market.view.live.LivePresenter$Request$applyLoading$1.AnonymousClass2 */
            final /* synthetic */ LivePresenter$Request$applyLoading$1 this$0;

            {
                this.this$0 = r1;
            }

            @Override // rx.functions.Action0
            public final void call() {
                this.this$0.this$0.setLoading(false);
            }
        }).doOnCompleted(new Action0(this) {
            /* class com.coolapk.market.view.live.LivePresenter$Request$applyLoading$1.AnonymousClass3 */
            final /* synthetic */ LivePresenter$Request$applyLoading$1 this$0;

            {
                this.this$0 = r1;
            }

            @Override // rx.functions.Action0
            public final void call() {
                this.this$0.this$0.setLoading(false);
            }
        }).doOnError(new Action1<Throwable>(this) {
            /* class com.coolapk.market.view.live.LivePresenter$Request$applyLoading$1.AnonymousClass4 */
            final /* synthetic */ LivePresenter$Request$applyLoading$1 this$0;

            {
                this.this$0 = r1;
            }

            public final void call(Throwable th) {
                this.this$0.this$0.setLoading(false);
            }
        });
    }
}
