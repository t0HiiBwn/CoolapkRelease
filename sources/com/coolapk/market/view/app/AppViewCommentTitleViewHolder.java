package com.coolapk.market.view.app;

import android.view.View;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemAppViewCommentTitleBinding;
import com.coolapk.market.viewholder.BindingViewHolder;

public class AppViewCommentTitleViewHolder extends BindingViewHolder {
    public static final int LAYOUT_ID = 2131558602;
    private final AppViewViewModel viewModel;

    public AppViewCommentTitleViewHolder(View view, AppViewViewModel appViewViewModel, DataBindingComponent dataBindingComponent) {
        super(view, dataBindingComponent);
        this.viewModel = appViewViewModel;
        ((ItemAppViewCommentTitleBinding) getBinding()).filterView.setOnClickListener(this);
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        ItemAppViewCommentTitleBinding itemAppViewCommentTitleBinding = (ItemAppViewCommentTitleBinding) getBinding();
        itemAppViewCommentTitleBinding.setCommentNum(this.viewModel.getServiceApp().getCommentCount());
        itemAppViewCommentTitleBinding.executePendingBindings();
        itemAppViewCommentTitleBinding.filterTextView.setText(((AppViewListFragment) ((FragmentBindingComponent) getComponent()).getContainer()).getFilterArgs().getTextId());
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        AppViewListFragment appViewListFragment = (AppViewListFragment) ((FragmentBindingComponent) getComponent()).getContainer();
        if (view.getId() == 2131362555) {
            appViewListFragment.showFilterPopMenu(view);
        }
    }
}
