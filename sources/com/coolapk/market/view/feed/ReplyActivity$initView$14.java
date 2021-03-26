package com.coolapk.market.view.feed;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.binding.ContextBindingComponent;
import com.coolapk.market.view.feed.ReplyActivity;
import com.coolapk.market.viewholder.ItemActionHandler;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: ReplyActivity.kt */
final class ReplyActivity$initView$14 extends Lambda implements Function1<View, RecyclerView.ViewHolder> {
    final /* synthetic */ ContextBindingComponent $component;
    final /* synthetic */ ReplyActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ReplyActivity$initView$14(ReplyActivity replyActivity, ContextBindingComponent contextBindingComponent) {
        super(1);
        this.this$0 = replyActivity;
        this.$component = contextBindingComponent;
    }

    public final RecyclerView.ViewHolder invoke(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return new ReplyActivity.ItemAddPhotoViewHolder(view, this.$component, new ItemActionHandler(this) {
            /* class com.coolapk.market.view.feed.ReplyActivity$initView$14.AnonymousClass1 */
            final /* synthetic */ ReplyActivity$initView$14 this$0;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.this$0 = r1;
            }

            @Override // com.coolapk.market.viewholder.ItemActionHandler
            public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
                this.this$0.this$0.pickPhoto();
            }
        });
    }
}
