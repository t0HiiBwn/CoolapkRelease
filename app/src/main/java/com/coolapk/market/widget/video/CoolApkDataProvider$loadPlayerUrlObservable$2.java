package com.coolapk.market.widget.video;

import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.VideoUrls;
import com.coolapk.market.util.RxUtils;
import kotlin.Metadata;
import rx.Observable;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a*\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0014\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lrx/Observable;", "Lcom/coolapk/market/model/VideoUrls;", "kotlin.jvm.PlatformType", "it", "", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: CoolApkDataProvider.kt */
final class CoolApkDataProvider$loadPlayerUrlObservable$2<T, R> implements Func1<Throwable, Observable<? extends VideoUrls>> {
    final /* synthetic */ String $requestParams;

    CoolApkDataProvider$loadPlayerUrlObservable$2(String str) {
        this.$requestParams = str;
    }

    public final Observable<? extends VideoUrls> call(Throwable th) {
        return DataManager.getInstance().getPlayerUrl(this.$requestParams).flatMap(RxUtils.flatCheckResultToData());
    }
}
