package com.coolapk.market.view.search;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;
import com.coolapk.market.network.ClientException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action0;
import rx.subscriptions.Subscriptions;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012.\u0010\u0002\u001a*\u0012\u000e\b\u0000\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0014\u0012\u000e\b\u0000\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "sub", "Lrx/Subscriber;", "Lcom/amap/api/location/AMapLocation;", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: SuperSearchFragment.kt */
final class SuperSearchFragment$onCreateRequest$5<T> implements Observable.OnSubscribe<AMapLocation> {
    final /* synthetic */ SuperSearchFragment this$0;

    SuperSearchFragment$onCreateRequest$5(SuperSearchFragment superSearchFragment) {
        this.this$0 = superSearchFragment;
    }

    public final void call(final Subscriber<? super AMapLocation> subscriber) {
        this.this$0.startSingleLocation(new AMapLocationListener() {
            /* class com.coolapk.market.view.search.SuperSearchFragment$onCreateRequest$5.AnonymousClass1 */

            @Override // com.amap.api.location.AMapLocationListener
            public final void onLocationChanged(AMapLocation aMapLocation) {
                Subscriber subscriber = subscriber;
                Intrinsics.checkNotNullExpressionValue(subscriber, "sub");
                if (!subscriber.isUnsubscribed()) {
                    Intrinsics.checkNotNullExpressionValue(aMapLocation, "aMapLocation");
                    if (aMapLocation.getErrorCode() != 0) {
                        subscriber.onError(new ClientException(-1, "定位失败，无法加载数据\n请检查定位权限或网络设置"));
                    } else {
                        subscriber.onNext(aMapLocation);
                    }
                }
            }
        });
        subscriber.add(Subscriptions.create(new Action0(this) {
            /* class com.coolapk.market.view.search.SuperSearchFragment$onCreateRequest$5.AnonymousClass2 */
            final /* synthetic */ SuperSearchFragment$onCreateRequest$5 this$0;

            {
                this.this$0 = r1;
            }

            @Override // rx.functions.Action0
            public final void call() {
                this.this$0.this$0.stopSingleLocation();
            }
        }));
    }
}
