package com.coolapk.market.view.feedv8;

import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.network.ClientException;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.feedv8.util.FeedGoodsHelper;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a*\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0014\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012*\u0010\u0004\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lrx/Observable;", "Lcom/coolapk/market/model/Entity;", "kotlin.jvm.PlatformType", "result", "Lcom/coolapk/market/network/Result;", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: SubmitFeedV8Activity.kt */
final class SubmitFeedV8Activity$loadShareInfo$subscription$1<T, R> implements Func1<Result<Entity>, Observable<? extends Entity>> {
    final /* synthetic */ String $url;

    SubmitFeedV8Activity$loadShareInfo$subscription$1(String str) {
        this.$url = str;
    }

    public final Observable<? extends Entity> call(Result<Entity> result) {
        Intrinsics.checkNotNullExpressionValue(result, "result");
        Integer status = result.getStatus();
        if (status != null && status.intValue() == -302) {
            FeedGoodsHelper feedGoodsHelper = FeedGoodsHelper.INSTANCE;
            String message = result.getMessage();
            Intrinsics.checkNotNullExpressionValue(message, "result.message");
            return feedGoodsHelper.loadHtmlSourceCodeFromUrl(message).subscribeOn(AndroidSchedulers.mainThread()).flatMap(new Func1<Pair<? extends String, ? extends String>, Observable<? extends Entity>>(this) {
                /* class com.coolapk.market.view.feedv8.SubmitFeedV8Activity$loadShareInfo$subscription$1.AnonymousClass1 */
                final /* synthetic */ SubmitFeedV8Activity$loadShareInfo$subscription$1 this$0;

                {
                    this.this$0 = r1;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // rx.functions.Func1
                public /* bridge */ /* synthetic */ Observable<? extends Entity> call(Pair<? extends String, ? extends String> pair) {
                    return call((Pair<String, String>) pair);
                }

                public final Observable<? extends Entity> call(Pair<String, String> pair) {
                    return DataManager.getInstance().loadShareUrlV11(this.this$0.$url, pair.getFirst(), pair.getSecond()).map(RxUtils.checkResultToData()).subscribeOn(Schedulers.io());
                }
            }).timeout(20, TimeUnit.SECONDS, Observable.error(new RuntimeException("获取数据超时...")));
        }
        ClientException checkResult = result.checkResult();
        if (checkResult != null) {
            return Observable.error(checkResult);
        }
        return Observable.just(result.getData());
    }
}
