package com.coolapk.market.view.node.app;

import com.coolapk.market.manager.DataManager;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.node.app.AppNodePresenter;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lrx/Subscription;", "it", "Lcom/coolapk/market/view/node/app/AppNodePresenter$Request;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: AppNodeContract.kt */
final class AppNodePresenter$followApp$1 extends Lambda implements Function1<AppNodePresenter.Request, Subscription> {
    final /* synthetic */ String $apkId;
    final /* synthetic */ boolean $newValue;
    final /* synthetic */ boolean $oldValue;
    final /* synthetic */ AppNodePresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppNodePresenter$followApp$1(AppNodePresenter appNodePresenter, boolean z, String str, boolean z2) {
        super(1);
        this.this$0 = appNodePresenter;
        this.$newValue = z;
        this.$apkId = str;
        this.$oldValue = z2;
    }

    public final Subscription invoke(AppNodePresenter.Request request) {
        Observable<Result<Map<String, String>>> observable;
        Intrinsics.checkNotNullParameter(request, "it");
        if (this.$newValue) {
            observable = DataManager.getInstance().followApp(this.$apkId);
        } else {
            observable = DataManager.getInstance().unfollowApp(this.$apkId);
        }
        Subscription subscribe = observable.compose(RxUtils.applyIOSchedulers()).compose(request.applyLoading()).map(RxUtils.checkResult()).subscribe(new Action1<Result<Map<String, String>>>(this) {
            /* class com.coolapk.market.view.node.app.AppNodePresenter$followApp$1.AnonymousClass1 */
            final /* synthetic */ AppNodePresenter$followApp$1 this$0;

            {
                this.this$0 = r1;
            }

            public final void call(Result<Map<String, String>> result) {
                this.this$0.this$0.getView().onFollowAppComplete(this.this$0.$oldValue, this.this$0.$newValue, result, null);
            }
        }, new Action1<Throwable>(this) {
            /* class com.coolapk.market.view.node.app.AppNodePresenter$followApp$1.AnonymousClass2 */
            final /* synthetic */ AppNodePresenter$followApp$1 this$0;

            {
                this.this$0 = r1;
            }

            public final void call(Throwable th) {
                this.this$0.this$0.getView().onFollowAppComplete(this.this$0.$oldValue, this.this$0.$newValue, null, th);
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "if (newValue) {\n        …e)\n                    })");
        return subscribe;
    }
}
