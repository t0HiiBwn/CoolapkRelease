package com.coolapk.market.view.product;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.User;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.viewholder.UserViewHolder;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: SimpleUserListFragment.kt */
final class SimpleUserListFragment$onActivityCreated$1 extends Lambda implements Function1<View, RecyclerView.ViewHolder> {
    final /* synthetic */ SimpleUserListFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SimpleUserListFragment$onActivityCreated$1(SimpleUserListFragment simpleUserListFragment) {
        super(1);
        this.this$0 = simpleUserListFragment;
    }

    public final RecyclerView.ViewHolder invoke(View view) {
        Intrinsics.checkNotNullParameter(view, "it");
        return new UserViewHolder(view, this.this$0.getComponent(), new ItemActionHandler(this) {
            /* class com.coolapk.market.view.product.SimpleUserListFragment$onActivityCreated$1.AnonymousClass1 */
            final /* synthetic */ SimpleUserListFragment$onActivityCreated$1 this$0;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.this$0 = r1;
            }

            @Override // com.coolapk.market.viewholder.ItemActionHandler
            public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
                Intrinsics.checkNotNullParameter(viewHolder, "holder");
                Intrinsics.checkNotNullParameter(view, "view");
                super.onItemClick(viewHolder, view);
                if (!UiUtils.isInvalidPosition(viewHolder.getAdapterPosition()) && view.getId() == 2131362200) {
                    Object obj = this.this$0.this$0.getDataList().get(viewHolder.getAdapterPosition());
                    Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.model.User");
                    User user = (User) obj;
                    ActionManager.startUserSpaceActivity(viewHolder.itemView.findViewById(2131362672), user.getUid(), user.getUserAvatar());
                }
            }
        });
    }
}
