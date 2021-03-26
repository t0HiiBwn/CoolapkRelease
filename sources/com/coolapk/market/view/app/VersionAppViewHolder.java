package com.coolapk.market.view.app;

import android.text.TextUtils;
import android.view.View;
import androidx.databinding.Bindable;
import com.coolapk.market.databinding.ItemVersionAppBinding;
import com.coolapk.market.event.Event;
import com.coolapk.market.model.DownloadState;
import com.coolapk.market.model.VersionApp;
import com.coolapk.market.util.StateUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.viewholder.StateViewHolder;

public class VersionAppViewHolder extends StateViewHolder {
    public static final int LAYOUT_ID = 2131558990;
    private String apkId;
    private ItemVersionAppBinding binding;
    private VersionApp versionApp;

    public VersionAppViewHolder(View view, ItemActionHandler itemActionHandler, String str) {
        super(view, itemActionHandler);
        this.apkId = str;
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        this.versionApp = (VersionApp) obj;
        ItemVersionAppBinding itemVersionAppBinding = (ItemVersionAppBinding) getBinding();
        this.binding = itemVersionAppBinding;
        itemVersionAppBinding.setViewModel(this);
        ViewUtil.directClickListener(this.binding.actionContainer, this);
        notifyPropertyChanged(303);
        notifyPropertyChanged(1);
        notifyPropertyChanged(2);
        notifyPropertyChanged(3);
        notifyPropertyChanged(62);
        notifyPropertyChanged(286);
    }

    @Bindable
    public VersionApp getVersionApp() {
        return this.versionApp;
    }

    @Bindable
    public String getActionButtonBackground() {
        return StateUtils.getActionButtonBackground(findDownloadState());
    }

    @Bindable
    public int getActionButtonTextColor() {
        return StateUtils.getActionButtonTextColor(findDownloadState());
    }

    @Bindable
    public String getActionText() {
        String actionTextWithState = StateUtils.getActionTextWithState(getContext(), false, getVersionApp().getPackageName(), StateUtils.findLatestState(null, getVersionApp().getDownloadUrlMd5(this.apkId)));
        return (actionTextWithState == null || TextUtils.equals(actionTextWithState, getContext().getString(2131886142))) ? getContext().getString(2131886128) : actionTextWithState;
    }

    private DownloadState findDownloadState() {
        return StateUtils.findLatestDownloadState(getVersionApp().getDownloadUrlMd5(this.apkId));
    }

    @Bindable
    public long getCurrentLength() {
        DownloadState findDownloadState = findDownloadState();
        if (findDownloadState != null) {
            return findDownloadState.getCurrentLength();
        }
        return 0;
    }

    @Bindable
    public long getTotalLength() {
        DownloadState findDownloadState = findDownloadState();
        if (findDownloadState != null) {
            return findDownloadState.getTotalLength();
        }
        return 0;
    }

    @Override // com.coolapk.market.viewholder.StateViewHolder, com.coolapk.market.util.RVStateEventChangedAdapter.IStateViewHolder
    public boolean onStateEventChanged(Event event) {
        return isEventBelongTo(event, this.versionApp, this.apkId);
    }
}
