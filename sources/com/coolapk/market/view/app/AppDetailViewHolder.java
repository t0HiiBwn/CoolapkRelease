package com.coolapk.market.view.app;

import android.view.View;
import com.coolapk.market.databinding.ItemAppDetailBinding;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.viewholder.BindingViewHolder;
import java.util.ArrayList;

public class AppDetailViewHolder extends BindingViewHolder {
    public static final int LAYOUT_ID = 2131558590;
    private AppDetailViewModel viewModel;

    public AppDetailViewHolder(View view, AppDetailViewModel appDetailViewModel) {
        super(view);
        this.viewModel = appDetailViewModel;
        ItemAppDetailBinding itemAppDetailBinding = (ItemAppDetailBinding) getBinding();
        ViewUtil.clickListener(itemAppDetailBinding.permissionClickView, this);
        ViewUtil.clickListener(itemAppDetailBinding.versionHistoryView, this);
        ViewUtil.clickListener(itemAppDetailBinding.developerView, this);
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        ItemAppDetailBinding itemAppDetailBinding = (ItemAppDetailBinding) getBinding();
        itemAppDetailBinding.setViewModel(this.viewModel);
        itemAppDetailBinding.executePendingBindings();
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == 2131362387) {
            ActionManager.startDeveloperAppsActivity(getContext(), this.viewModel.getServiceApp().getDeveloperName());
        } else if (id != 2131363089) {
            if (id == 2131363905) {
                ActionManager.startHistoryVersionActivity(getContext(), this.viewModel.getServiceApp().getAppName(), this.viewModel.getServiceApp().getApkId(), this.viewModel.getServiceApp().getLogo());
            }
        } else if (!CollectionUtils.isEmpty(this.viewModel.getServiceApp().getPermissions())) {
            ActionManager.startPermissionActivity(getContext(), new ArrayList(this.viewModel.getServiceApp().getPermissions()));
        }
    }
}
