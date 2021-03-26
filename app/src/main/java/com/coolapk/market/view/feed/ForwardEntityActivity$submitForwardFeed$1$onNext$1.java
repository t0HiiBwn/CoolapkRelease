package com.coolapk.market.view.feed;

import com.coolapk.market.widget.Toast;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: ForwardEntityActivity.kt */
final class ForwardEntityActivity$submitForwardFeed$1$onNext$1 implements Runnable {
    final /* synthetic */ ForwardEntityActivity$submitForwardFeed$1 this$0;

    ForwardEntityActivity$submitForwardFeed$1$onNext$1(ForwardEntityActivity$submitForwardFeed$1 forwardEntityActivity$submitForwardFeed$1) {
        this.this$0 = forwardEntityActivity$submitForwardFeed$1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Toast.show$default(this.this$0.this$0.getActivity(), "发布成功", 0, false, 12, null);
    }
}
