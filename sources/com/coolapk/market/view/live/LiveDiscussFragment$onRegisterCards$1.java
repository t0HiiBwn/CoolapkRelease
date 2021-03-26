package com.coolapk.market.view.live;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.model.LiveMessage;
import com.coolapk.market.view.live.LiveMessageViewHolder;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "itemView", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: LiveDiscussFragment.kt */
final class LiveDiscussFragment$onRegisterCards$1 extends Lambda implements Function1<View, BindingViewHolder> {
    final /* synthetic */ LiveDiscussFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LiveDiscussFragment$onRegisterCards$1(LiveDiscussFragment liveDiscussFragment) {
        super(1);
        this.this$0 = liveDiscussFragment;
    }

    public final BindingViewHolder invoke(View view) {
        Intrinsics.checkNotNullParameter(view, "itemView");
        return new LiveMessageViewHolder("0", view, this.this$0.getBindingComponent(), new ItemActionHandler(this) {
            /* class com.coolapk.market.view.live.LiveDiscussFragment$onRegisterCards$1.AnonymousClass1 */
            final /* synthetic */ LiveDiscussFragment$onRegisterCards$1 this$0;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.this$0 = r1;
            }

            @Override // com.coolapk.market.viewholder.ItemActionHandler
            public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
                Intrinsics.checkNotNullParameter(viewHolder, "holder");
                Intrinsics.checkNotNullParameter(view, "view");
                if (view.getId() == 2131362779) {
                    Object tag = view.getTag();
                    Objects.requireNonNull(tag, "null cannot be cast to non-null type com.coolapk.market.model.LiveMessage");
                    this.this$0.this$0.getLiveContext().onLiveMessageClick((LiveMessage) tag);
                }
            }

            @Override // com.coolapk.market.viewholder.ItemActionHandler
            public boolean onItemLongClick(RecyclerView.ViewHolder viewHolder, View view) {
                Intrinsics.checkNotNullParameter(viewHolder, "holder");
                Intrinsics.checkNotNullParameter(view, "view");
                if (view.getId() != 2131362779) {
                    return super.onItemLongClick(viewHolder, view);
                }
                Object tag = view.getTag();
                Objects.requireNonNull(tag, "null cannot be cast to non-null type com.coolapk.market.model.LiveMessage");
                this.this$0.this$0.getLiveContext().onLiveMessageLongClick((LiveMessage) tag);
                return true;
            }
        }, new LiveMessageViewHolder.Callback(this) {
            /* class com.coolapk.market.view.live.LiveDiscussFragment$onRegisterCards$1.AnonymousClass2 */
            final /* synthetic */ LiveDiscussFragment$onRegisterCards$1 this$0;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.this$0 = r1;
            }

            @Override // com.coolapk.market.view.live.LiveMessageViewHolder.Callback
            public boolean isPresenter(String str) {
                Intrinsics.checkNotNullParameter(str, "uid");
                return this.this$0.this$0.getViewModel().isPresenter(str);
            }
        }, this.this$0.commandHelper);
    }
}
