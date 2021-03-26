package com.coolapk.market.view.user.block;

import android.view.View;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.databinding.ItemUserBinding;
import com.coolapk.market.model.User;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.viewholder.UserViewHolder;
import com.coolapk.market.widget.ActionButtonFrameLayout;
import kotlin.jvm.internal.Intrinsics;

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
