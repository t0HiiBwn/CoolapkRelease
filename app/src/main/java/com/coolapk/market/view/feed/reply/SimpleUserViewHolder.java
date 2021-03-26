package com.coolapk.market.view.feed.reply;

import android.view.View;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.databinding.ItemSimpleUserViewBinding;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.User;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.widget.UserAvatarView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u000e2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000eB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0003H\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0005H\u0016R\u000e\u0010\t\u001a\u00020\u0003X.¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/coolapk/market/view/feed/reply/SimpleUserViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemSimpleUserViewBinding;", "Lcom/coolapk/market/model/User;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;)V", "user", "bindToContent", "", "onClick", "view", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SimpleUserViewHolder.kt */
public final class SimpleUserViewHolder extends GenericBindHolder<ItemSimpleUserViewBinding, User> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558933;
    private User user;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SimpleUserViewHolder(View view, DataBindingComponent dataBindingComponent) {
        super(view, dataBindingComponent, null);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/feed/reply/SimpleUserViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SimpleUserViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void bindToContent(User user2) {
        Intrinsics.checkNotNullParameter(user2, "user");
        this.user = user2;
        ItemSimpleUserViewBinding itemSimpleUserViewBinding = (ItemSimpleUserViewBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemSimpleUserViewBinding, "binding");
        itemSimpleUserViewBinding.setModel(user2);
        ItemSimpleUserViewBinding itemSimpleUserViewBinding2 = (ItemSimpleUserViewBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemSimpleUserViewBinding2, "binding");
        itemSimpleUserViewBinding2.setClick(this);
        ((ItemSimpleUserViewBinding) getBinding()).executePendingBindings();
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onClick(view);
        if (view.getId() == 2131362200) {
            UserAvatarView userAvatarView = ((ItemSimpleUserViewBinding) getBinding()).iconView;
            User user2 = this.user;
            if (user2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("user");
            }
            String uid = user2.getUid();
            User user3 = this.user;
            if (user3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("user");
            }
            ActionManager.startUserSpaceActivity(userAvatarView, uid, user3.getUserAvatar());
        }
    }
}
