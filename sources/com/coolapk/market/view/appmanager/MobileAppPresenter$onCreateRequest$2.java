package com.coolapk.market.view.appmanager;

import com.coolapk.market.model.MobileApp;
import java.util.List;
import kotlin.Metadata;
import rx.Observable;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010 \n\u0000\u0010\u0000\u001a*\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0014\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012*\u0010\u0004\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00060\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lrx/Observable;", "Lcom/coolapk/market/model/MobileApp;", "kotlin.jvm.PlatformType", "mobileApps", "", "", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: MobileAppPresenter.kt */
final class MobileAppPresenter$onCreateRequest$2<T, R> implements Func1<List<MobileApp>, Observable<? extends MobileApp>> {
    public static final MobileAppPresenter$onCreateRequest$2 INSTANCE = new MobileAppPresenter$onCreateRequest$2();

    MobileAppPresenter$onCreateRequest$2() {
    }

    public final Observable<? extends MobileApp> call(List<MobileApp> list) {
        return Observable.from(list);
    }
}
