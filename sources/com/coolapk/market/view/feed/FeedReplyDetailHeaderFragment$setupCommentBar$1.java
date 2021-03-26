package com.coolapk.market.view.feed;

import android.view.View;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.FeedReply;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedReplyDetailHeaderFragment.kt */
final class FeedReplyDetailHeaderFragment$setupCommentBar$1 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ FeedReply $feedReply;
    final /* synthetic */ FeedReplyDetailHeaderFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedReplyDetailHeaderFragment$setupCommentBar$1(FeedReplyDetailHeaderFragment feedReplyDetailHeaderFragment, FeedReply feedReply) {
        super(1);
        this.this$0 = feedReplyDetailHeaderFragment;
        this.$feedReply = feedReply;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke(view);
        return Unit.INSTANCE;
    }

    public final void invoke(View view) {
        Intrinsics.checkNotNullParameter(view, "v");
        if (view.getId() == 2131362289) {
            ActionManager.startReplyActivity(this.this$0.getActivity(), this.$feedReply);
        }
    }
}
