package com.coolapk.market.viewholder;

import android.view.View;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.databinding.ItemRelatedDataBinding;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.RelatedData;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.util.ViewUtil;

public class RelatedDataViewHolder extends BindingViewHolder {
    public static final int LAYOUT_ID = 2131558902;

    public RelatedDataViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
        ViewUtil.clickListener(view, this);
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        RelatedData relatedData = (RelatedData) obj;
        ItemRelatedDataBinding itemRelatedDataBinding = (ItemRelatedDataBinding) getBinding();
        itemRelatedDataBinding.setAvatar(relatedData.getUserAvatar());
        itemRelatedDataBinding.setName(relatedData.getUserName());
        itemRelatedDataBinding.executePendingBindings();
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (!UiUtils.isInvalidPosition(getAdapterPosition())) {
            ItemRelatedDataBinding itemRelatedDataBinding = (ItemRelatedDataBinding) getBinding();
            ActionManager.startUserSpaceActivity(itemRelatedDataBinding.iconView, itemRelatedDataBinding.getName(), itemRelatedDataBinding.getAvatar());
        }
    }
}
