package com.coolapk.market.view.feedv8.util;

import android.app.Activity;
import android.app.Dialog;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lkotlin/Function0;", "", "url", "", "dialog", "Landroid/app/Dialog;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedGoodsHelper.kt */
final class FeedGoodsHelper$showLoadingGoodsDialog$2 extends Lambda implements Function2<String, Dialog, Function0<? extends Unit>> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ Function1 $callback;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedGoodsHelper$showLoadingGoodsDialog$2(Function1 function1, Activity activity) {
        super(2);
        this.$callback = function1;
        this.$activity = activity;
    }

    public final Function0<Unit> invoke(String str, Dialog dialog) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        final Subscription subscribe = Observable.zip(FeedGoodsHelper.INSTANCE.buildFeedGoodsLoader(str), Observable.timer(1300, TimeUnit.MILLISECONDS), FeedGoodsHelper$showLoadingGoodsDialog$2$subscription$1.INSTANCE).observeOn(AndroidSchedulers.mainThread()).doOnUnsubscribe(new FeedGoodsHelper$showLoadingGoodsDialog$2$subscription$2(dialog)).subscribe((Subscriber) new FeedGoodsHelper$showLoadingGoodsDialog$2$subscription$3(this));
        return new Function0<Unit>() {
            /* class com.coolapk.market.view.feedv8.util.FeedGoodsHelper$showLoadingGoodsDialog$2.AnonymousClass1 */

            @Override // kotlin.jvm.functions.Function0
            public final void invoke() {
                Subscription subscription = subscribe;
                Intrinsics.checkNotNullExpressionValue(subscription, "subscription");
                if (!subscription.isUnsubscribed()) {
                    subscribe.unsubscribe();
                }
            }
        };
    }
}
