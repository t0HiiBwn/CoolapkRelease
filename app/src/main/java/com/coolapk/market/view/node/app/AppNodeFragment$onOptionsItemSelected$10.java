package com.coolapk.market.view.node.app;

import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.util.RxLogin;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import rx.Subscriber;
import rx.Subscription;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lrx/Subscription;", "kotlin.jvm.PlatformType", "app", "Lcom/coolapk/market/model/ServiceApp;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: AppNodeFragment.kt */
final class AppNodeFragment$onOptionsItemSelected$10 extends Lambda implements Function1<ServiceApp, Subscription> {
    final /* synthetic */ AppNodeFragment $fragment;
    final /* synthetic */ AppNodeFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppNodeFragment$onOptionsItemSelected$10(AppNodeFragment appNodeFragment, AppNodeFragment appNodeFragment2) {
        super(1);
        this.this$0 = appNodeFragment;
        this.$fragment = appNodeFragment2;
    }

    public final Subscription invoke(final ServiceApp serviceApp) {
        Intrinsics.checkNotNullParameter(serviceApp, "app");
        return RxLogin.getInstance(this.this$0.getActivity()).requestLogin().subscribe((Subscriber<? super Boolean>) new Subscriber<Boolean>(this) {
            /* class com.coolapk.market.view.node.app.AppNodeFragment$onOptionsItemSelected$10.AnonymousClass1 */
            final /* synthetic */ AppNodeFragment$onOptionsItemSelected$10 this$0;

            @Override // rx.Observer
            public void onCompleted() {
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "e");
            }

            {
                this.this$0 = r1;
            }

            public void onNext(Boolean bool) {
                Intrinsics.checkNotNull(bool);
                if (bool.booleanValue()) {
                    ActionManager.startCollectionSelectActivity(this.this$0.$fragment, serviceApp.getId(), serviceApp.getEntityType(), 6666);
                }
            }
        });
    }
}
