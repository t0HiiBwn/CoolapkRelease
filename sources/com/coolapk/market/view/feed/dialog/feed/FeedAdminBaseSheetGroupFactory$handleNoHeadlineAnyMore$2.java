package com.coolapk.market.view.feed.dialog.feed;

import com.coolapk.market.AppHolder;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.event.FeedRemoveHeadlineEvent;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.greenrobot.eventbus.EventBus;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"action", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedAdminBaseSheetGroupFactory.kt */
final class FeedAdminBaseSheetGroupFactory$handleNoHeadlineAnyMore$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ FeedAdminBaseSheetGroupFactory$handleNoHeadlineAnyMore$1 $onErrorEvent$1;
    final /* synthetic */ FeedAdminBaseSheetGroupFactory this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedAdminBaseSheetGroupFactory$handleNoHeadlineAnyMore$2(FeedAdminBaseSheetGroupFactory feedAdminBaseSheetGroupFactory, FeedAdminBaseSheetGroupFactory$handleNoHeadlineAnyMore$1 feedAdminBaseSheetGroupFactory$handleNoHeadlineAnyMore$1) {
        super(0);
        this.this$0 = feedAdminBaseSheetGroupFactory;
        this.$onErrorEvent$1 = feedAdminBaseSheetGroupFactory$handleNoHeadlineAnyMore$1;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        this.this$0.presenter.removeFromHeadlineV8(this.this$0.getFeed(), false).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new EmptySubscriber<String>(this) {
            /* class com.coolapk.market.view.feed.dialog.feed.FeedAdminBaseSheetGroupFactory$handleNoHeadlineAnyMore$2.AnonymousClass1 */
            final /* synthetic */ FeedAdminBaseSheetGroupFactory$handleNoHeadlineAnyMore$2 this$0;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.this$0 = r1;
            }

            @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
            public void onError(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "e");
                super.onError(th);
                this.this$0.$onErrorEvent$1.invoke(th);
            }

            public void onNext(String str) {
                Intrinsics.checkNotNullParameter(str, "s");
                super.onNext((AnonymousClass1) str);
                Toast.show$default(AppHolder.getApplication(), str, 0, false, 12, null);
                if (this.this$0.this$0.getFeed().getIsV8Headline()) {
                    EventBus.getDefault().post(new FeedRemoveHeadlineEvent(this.this$0.this$0.getFeed().getId()));
                }
            }
        });
    }
}
