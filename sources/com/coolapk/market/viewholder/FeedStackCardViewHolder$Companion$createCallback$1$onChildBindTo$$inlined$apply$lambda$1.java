package com.coolapk.market.viewholder;

import com.coolapk.market.model.Entity;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.stackcard.StackFrameLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "invoke", "com/coolapk/market/viewholder/FeedStackCardViewHolder$Companion$createCallback$1$onChildBindTo$1$1"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedStackCardViewHolder.kt */
final class FeedStackCardViewHolder$Companion$createCallback$1$onChildBindTo$$inlined$apply$lambda$1 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ StackFrameLayout $this_apply;
    final /* synthetic */ FeedStackItemViewHolder $viewHolder$inlined;
    final /* synthetic */ FeedStackCardViewHolder$Companion$createCallback$1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedStackCardViewHolder$Companion$createCallback$1$onChildBindTo$$inlined$apply$lambda$1(StackFrameLayout stackFrameLayout, FeedStackCardViewHolder$Companion$createCallback$1 feedStackCardViewHolder$Companion$createCallback$1, FeedStackItemViewHolder feedStackItemViewHolder) {
        super(0);
        this.$this_apply = stackFrameLayout;
        this.this$0 = feedStackCardViewHolder$Companion$createCallback$1;
        this.$viewHolder$inlined = feedStackItemViewHolder;
    }

    /* Return type fixed from 'boolean' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public final Boolean invoke() {
        List<Entity> entities = FeedStackCardViewHolder$Companion$createCallback$1.access$getCard$p(this.this$0).getEntities();
        if (entities != null && entities.size() == 1) {
            Toast.show$default(this.$this_apply.getContext(), "没有更多了", 0, false, 12, null);
            return null;
        } else if (this.$viewHolder$inlined.getAdapterPosition() != 0) {
            return null;
        } else {
            FeedStackCardViewHolder$Companion$createCallback$1.access$getItemTouchHelper$p(this.this$0).startSwipe(this.$viewHolder$inlined);
            return 1;
        }
    }
}
