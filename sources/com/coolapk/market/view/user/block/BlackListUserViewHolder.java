package com.coolapk.market.view.user.block;

import android.view.View;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.databinding.ItemUserBinding;
import com.coolapk.market.model.User;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.viewholder.UserViewHolder;
import com.coolapk.market.widget.ActionButtonFrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/coolapk/market/view/user/block/BlackListUserViewHolder;", "Lcom/coolapk/market/viewholder/UserViewHolder;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "isRequesting", "", "bindToContent", "", "user", "Lcom/coolapk/market/model/User;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: BlackListUserViewHolder.kt */
public final class BlackListUserViewHolder extends UserViewHolder {
    private boolean isRequesting;

    public BlackListUserViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
    }

    @Override // com.coolapk.market.viewholder.UserViewHolder
    public void bindToContent(User user) {
        super.bindToContent(user);
        this.isRequesting = false;
        ActionButtonFrameLayout actionButtonFrameLayout = ((ItemUserBinding) getBinding()).actionContainer;
        Intrinsics.checkNotNullExpressionValue(actionButtonFrameLayout, "binding.actionContainer");
        actionButtonFrameLayout.setVisibility(0);
        ((ItemUserBinding) getBinding()).actionButton.setText(2131886115);
        ((ItemUserBinding) getBinding()).cardView.setOnClickListener(new BlackListUserViewHolder$bindToContent$1(this, user));
        ((ItemUserBinding) getBinding()).actionContainer.setOnClickListener(new BlackListUserViewHolder$bindToContent$2(this, user));
    }
}
