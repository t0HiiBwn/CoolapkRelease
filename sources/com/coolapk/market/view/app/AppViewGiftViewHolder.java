package com.coolapk.market.view.app;

import android.view.View;
import com.coolapk.market.databinding.ItemAppViewGiftBinding;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.ItemActionHandler;

public class AppViewGiftViewHolder extends BindingViewHolder {
    public static final int LAYOUT_ID = 2131558608;
    private final AppViewViewModel viewModel;

    public AppViewGiftViewHolder(View view, AppViewViewModel appViewViewModel, ItemActionHandler itemActionHandler) {
        super(view, itemActionHandler);
        this.viewModel = appViewViewModel;
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        ItemAppViewGiftBinding itemAppViewGiftBinding = (ItemAppViewGiftBinding) getBinding();
        itemAppViewGiftBinding.setViewModel(this.viewModel);
        itemAppViewGiftBinding.executePendingBindings();
    }
}
