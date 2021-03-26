package com.coolapk.market.viewholder;

import android.app.Activity;
import android.view.View;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.AppHolder;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.databinding.ItemDeveloperCardBinding;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.util.RxLogin;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.app.AppViewContract;
import com.coolapk.market.view.app.AppViewViewModel;
import rx.Subscriber;

public class DeveloperCardViewHolder extends BindingViewHolder {
    public static final int LAYOUT_ID = 2131558668;
    private final AppViewContract.Presenter presenter;
    private final AppViewViewModel viewModel;

    public DeveloperCardViewHolder(View view, AppViewViewModel appViewViewModel, AppViewContract.Presenter presenter2, DataBindingComponent dataBindingComponent) {
        super(view, dataBindingComponent, null);
        this.viewModel = appViewViewModel;
        this.presenter = presenter2;
        ItemDeveloperCardBinding itemDeveloperCardBinding = (ItemDeveloperCardBinding) getBinding();
        ViewUtil.clickListener(itemDeveloperCardBinding.followView, this);
        ViewUtil.clickListener(itemDeveloperCardBinding.sendView, this);
        ViewUtil.clickListener(itemDeveloperCardBinding.atView, this);
        ViewUtil.clickListener(itemDeveloperCardBinding.developerView, this);
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        ItemDeveloperCardBinding itemDeveloperCardBinding = (ItemDeveloperCardBinding) getBinding();
        itemDeveloperCardBinding.setViewModel(this.viewModel);
        UiUtils.setDrawableStrokeColors(itemDeveloperCardBinding.followView.getBackground(), new int[]{0}, AppHolder.getAppTheme().getColorAccent());
        UiUtils.setDrawableStrokeColors(itemDeveloperCardBinding.sendView.getBackground(), new int[]{0}, AppHolder.getAppTheme().getColorAccent());
        UiUtils.setDrawableStrokeColors(itemDeveloperCardBinding.atView.getBackground(), new int[]{0}, AppHolder.getAppTheme().getColorAccent());
        itemDeveloperCardBinding.executePendingBindings();
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
            case 2131362092:
                ServiceApp serviceApp = this.viewModel.getServiceApp();
                ActionManager.startAppCommentActivity((Activity) getContext(), serviceApp, "@" + this.viewModel.getServiceApp().getDeveloperProfile().getUserName() + " ");
                return;
            case 2131362387:
                ActionManager.startUserSpaceActivity(((ItemDeveloperCardBinding) getBinding()).avatarView, this.viewModel.getServiceApp().getDeveloperProfile().getUid(), this.viewModel.getServiceApp().getDeveloperProfile().getUserAvatar());
                return;
            case 2131362582:
                RxLogin.getInstance(getContext()).requestLogin().subscribe((Subscriber<? super Boolean>) new EmptySubscriber<Boolean>() {
                    /* class com.coolapk.market.viewholder.DeveloperCardViewHolder.AnonymousClass1 */

                    public void onNext(Boolean bool) {
                        if (bool.booleanValue()) {
                            boolean isFollowDeveloper = DeveloperCardViewHolder.this.viewModel.isFollowDeveloper();
                            boolean z = !DeveloperCardViewHolder.this.viewModel.isFollowDeveloper();
                            DeveloperCardViewHolder.this.presenter.followUser(DeveloperCardViewHolder.this.viewModel.getServiceApp().getDeveloperProfile().getUid(), isFollowDeveloper, z);
                            DeveloperCardViewHolder.this.viewModel.setFollowDeveloper(z);
                        }
                    }
                });
                return;
            case 2131363343:
                ActionManager.startChattingActivity(getContext(), this.viewModel.getServiceApp().getDeveloperProfile().getUid(), this.viewModel.getServiceApp().getDeveloperProfile().getUserName());
                return;
            default:
                return;
        }
    }
}
