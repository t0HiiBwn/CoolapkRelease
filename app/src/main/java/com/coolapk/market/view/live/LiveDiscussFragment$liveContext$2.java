package com.coolapk.market.view.live;

import androidx.fragment.app.FragmentActivity;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/coolapk/market/view/live/LiveContext;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: LiveDiscussFragment.kt */
final class LiveDiscussFragment$liveContext$2 extends Lambda implements Function0<LiveContext> {
    final /* synthetic */ LiveDiscussFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LiveDiscussFragment$liveContext$2(LiveDiscussFragment liveDiscussFragment) {
        super(0);
        this.this$0 = liveDiscussFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public final LiveContext invoke() {
        FragmentActivity activity = this.this$0.getActivity();
        Objects.requireNonNull(activity, "null cannot be cast to non-null type com.coolapk.market.view.live.LiveContext");
        return (LiveContext) activity;
    }
}
