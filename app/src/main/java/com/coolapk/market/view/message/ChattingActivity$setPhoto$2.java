package com.coolapk.market.view.message;

import kotlin.Metadata;
import okhttp3.ResponseBody;
import rx.Observable;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a*\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0014\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lrx/Observable;", "Lokhttp3/ResponseBody;", "kotlin.jvm.PlatformType", "it", "", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: ChattingActivity.kt */
final class ChattingActivity$setPhoto$2<T, R> implements Func1<Throwable, Observable<? extends ResponseBody>> {
    public static final ChattingActivity$setPhoto$2 INSTANCE = new ChattingActivity$setPhoto$2();

    ChattingActivity$setPhoto$2() {
    }

    public final Observable<? extends ResponseBody> call(Throwable th) {
        return Observable.error(th);
    }
}
