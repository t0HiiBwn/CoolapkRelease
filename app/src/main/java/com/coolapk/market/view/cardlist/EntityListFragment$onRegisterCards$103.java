package com.coolapk.market.view.cardlist;

import android.view.View;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.FeedStackCardViewHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "itemView", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: EntityListFragment.kt */
final class EntityListFragment$onRegisterCards$103 extends Lambda implements Function1<View, BindingViewHolder> {
    final /* synthetic */ EntityListFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EntityListFragment$onRegisterCards$103(EntityListFragment entityListFragment) {
        super(1);
        this.this$0 = entityListFragment;
    }

    public final BindingViewHolder invoke(View view) {
        Intrinsics.checkNotNullParameter(view, "itemView");
        return new FeedStackCardViewHolder(view, this.this$0.getBindingComponent(), new Function1<Integer, Unit>(this) {
            /* class com.coolapk.market.view.cardlist.EntityListFragment$onRegisterCards$103.AnonymousClass1 */
            final /* synthetic */ EntityListFragment$onRegisterCards$103 this$0;

            {
                this.this$0 = r1;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i) {
                this.this$0.this$0.getDataList().remove(i);
            }
        });
    }
}
