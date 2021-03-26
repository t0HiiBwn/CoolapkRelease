package com.coolapk.market.view.live;

import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Live;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.live.LivePresenter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import rx.Subscriber;
import rx.Subscription;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lrx/Subscription;", "it", "Lcom/coolapk/market/view/live/LivePresenter$Request;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: LivePresenter.kt */
final class LivePresenter$loadLive$1 extends Lambda implements Function1<LivePresenter.Request, Subscription> {
    final /* synthetic */ LivePresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LivePresenter$loadLive$1(LivePresenter livePresenter) {
        super(1);
        this.this$0 = livePresenter;
    }

    public final Subscription invoke(LivePresenter.Request request) {
        Intrinsics.checkNotNullParameter(request, "it");
        Subscription subscribe = DataManager.getInstance().getLiveDetail(this.this$0.liveId).compose(RxUtils.applyIOSchedulers()).compose(request.applyLoading()).map(RxUtils.checkResult()).subscribe((Subscriber<? super R>) new EmptySubscriber<Result<Live>>(this) {
            /* class com.coolapk.market.view.live.LivePresenter$loadLive$1.AnonymousClass1 */
            final /* synthetic */ LivePresenter$loadLive$1 this$0;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.this$0 = r1;
            }

            @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
            public void onError(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "error");
                this.this$0.this$0.getView().onLiveLoaded(null, th);
            }

            public void onNext(Result<Live> result) {
                Intrinsics.checkNotNullParameter(result, "result");
                this.this$0.this$0.setNewResult(result);
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "DataManager.getInstance(… }\n                    })");
        return subscribe;
    }
}
