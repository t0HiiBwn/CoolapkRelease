package com.coolapk.market.view.message;

import android.net.Uri;
import android.util.Pair;
import com.coolapk.market.manager.DataManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import rx.Observable;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a*\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0014\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012F\u0010\u0004\u001aB\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00060\u0006 \u0003* \u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lrx/Observable;", "Lokhttp3/ResponseBody;", "kotlin.jvm.PlatformType", "result", "Landroid/util/Pair;", "", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: ChattingActivity.kt */
final class ChattingActivity$setPhoto$3<T, R> implements Func1<Pair<String, String>, Observable<? extends ResponseBody>> {
    final /* synthetic */ ChattingActivity this$0;

    ChattingActivity$setPhoto$3(ChattingActivity chattingActivity) {
        this.this$0 = chattingActivity;
    }

    public final Observable<? extends ResponseBody> call(Pair<String, String> pair) {
        Uri parse = Uri.parse((String) pair.second);
        Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(result.second)");
        return DataManager.getInstance().sendMessageForPic(this.this$0.userId, parse.getEncodedPath());
    }
}
