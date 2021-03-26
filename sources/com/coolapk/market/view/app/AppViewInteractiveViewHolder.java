package com.coolapk.market.view.app;

import android.graphics.Color;
import android.view.View;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.FragmentActivity;
import com.coolapk.market.databinding.ItemAppViewInteractiveBinding;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.util.ThemeUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.app.AppViewContract;
import com.coolapk.market.viewholder.BindingViewHolder;

public class AppViewInteractiveViewHolder extends BindingViewHolder {
    public static final int LAYOUT_ID = 2131558606;
    private final AppViewContract.Presenter presenter;
    private final AppViewViewModel viewModel;

    public AppViewInteractiveViewHolder(View view, AppViewViewModel appViewViewModel, AppViewContract.Presenter presenter2, DataBindingComponent dataBindingComponent) {
        super(view, dataBindingComponent, null);
        this.viewModel = appViewViewModel;
        this.presenter = presenter2;
        ItemAppViewInteractiveBinding itemAppViewInteractiveBinding = (ItemAppViewInteractiveBinding) getBinding();
        ThemeUtils.setRatingBarColor(itemAppViewInteractiveBinding.ratingBarAverage, Color.parseColor("#ffb712"));
        ViewUtil.clickListener(itemAppViewInteractiveBinding.ratingView, this);
        ViewUtil.clickListener(itemAppViewInteractiveBinding.discoveryOfTheirsView, this);
        ViewUtil.clickListener(itemAppViewInteractiveBinding.ratingOfTheirsView, this);
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        ItemAppViewInteractiveBinding itemAppViewInteractiveBinding = (ItemAppViewInteractiveBinding) getBinding();
        itemAppViewInteractiveBinding.setViewModel(this.viewModel);
        itemAppViewInteractiveBinding.executePendingBindings();
        itemAppViewInteractiveBinding.rate5.getLayoutParams().width = this.viewModel.getVoteWidth5();
        itemAppViewInteractiveBinding.rate4.getLayoutParams().width = this.viewModel.getVoteWidth4();
        itemAppViewInteractiveBinding.rate3.getLayoutParams().width = this.viewModel.getVoteWidth3();
        itemAppViewInteractiveBinding.rate2.getLayoutParams().width = this.viewModel.getVoteWidth2();
        itemAppViewInteractiveBinding.rate1.getLayoutParams().width = this.viewModel.getVoteWidth1();
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        FragmentActivity fragmentActivity = (FragmentActivity) getContext();
        int id = view.getId();
        if (id == 2131362410) {
            ActionManager.startDiscoveryOfTheirsActivity(getContext(), this.viewModel.getServiceApp().getApkId());
        } else if (id == 2131363206) {
            ActionManager.startRatingOfTheirsActivity(getContext(), this.viewModel.getServiceApp().getApkId());
        } else if (id == 2131363213) {
            RatingDialog newInstance = RatingDialog.newInstance();
            newInstance.setViewModel(this.viewModel);
            newInstance.setPresenter(this.presenter);
            newInstance.show(fragmentActivity.getSupportFragmentManager(), (String) null);
        }
    }
}
