package com.coolapk.market.view.appmanager;

import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.MobileApp;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00040\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Lcom/coolapk/market/model/MobileApp;", "kotlin.jvm.PlatformType", "", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: MobileAppPresenter.kt */
final class MobileAppPresenter$onCreateRequest$1<V> implements Callable<List<MobileApp>> {
    final /* synthetic */ MobileAppPresenter this$0;

    MobileAppPresenter$onCreateRequest$1(MobileAppPresenter mobileAppPresenter) {
        this.this$0 = mobileAppPresenter;
    }

    @Override // java.util.concurrent.Callable
    public final List<MobileApp> call() {
        synchronized (this.this$0.taskLock) {
            while (this.this$0.isTaskLoading) {
                this.this$0.taskLock.wait();
            }
            Unit unit = Unit.INSTANCE;
        }
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        return instance.getMobileAppExistListFast();
    }
}
