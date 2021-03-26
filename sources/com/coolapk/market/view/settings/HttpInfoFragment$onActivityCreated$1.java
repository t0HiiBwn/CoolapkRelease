package com.coolapk.market.view.settings;

import kotlin.Metadata;
import okhttp3.ResponseBody;
import org.json.JSONObject;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lokhttp3/ResponseBody;", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: HttpInfoFragment.kt */
final class HttpInfoFragment$onActivityCreated$1<T> implements Action1<ResponseBody> {
    final /* synthetic */ HttpInfoFragment this$0;

    HttpInfoFragment$onActivityCreated$1(HttpInfoFragment httpInfoFragment) {
        this.this$0 = httpInfoFragment;
    }

    public final void call(ResponseBody responseBody) {
        HttpInfoFragment.access$getTextView$p(this.this$0).setText(new JSONObject(responseBody.string()).toString(2));
    }
}
