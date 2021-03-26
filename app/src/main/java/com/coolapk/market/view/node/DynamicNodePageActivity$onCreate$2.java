package com.coolapk.market.view.node;

import com.coolapk.market.network.ClientException;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "e", "", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: DynamicNodePageActivity.kt */
final class DynamicNodePageActivity$onCreate$2<T> implements Action1<Throwable> {
    final /* synthetic */ DynamicNodePageActivity this$0;

    DynamicNodePageActivity$onCreate$2(DynamicNodePageActivity dynamicNodePageActivity) {
        this.this$0 = dynamicNodePageActivity;
    }

    public final void call(Throwable th) {
        String str = "获取信息失败，请重试";
        if (th instanceof ClientException) {
            DynamicNodePageActivity dynamicNodePageActivity = this.this$0;
            String message = th.getMessage();
            if (message != null) {
                str = message;
            }
            dynamicNodePageActivity.setLoadingError(str);
        } else {
            this.this$0.setLoadingError(str);
        }
        Toast.error(this.this$0.getActivity(), th);
    }
}
