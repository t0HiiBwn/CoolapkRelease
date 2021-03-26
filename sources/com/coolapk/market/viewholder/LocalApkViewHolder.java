package com.coolapk.market.viewholder;

import android.view.View;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.databinding.ItemLocalApkBinding;
import com.coolapk.market.event.Event;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.InstallState;
import com.coolapk.market.model.LocalApk;
import com.coolapk.market.model.MobileApp;
import com.coolapk.market.util.ViewUtil;

public class LocalApkViewHolder extends StateViewHolder {
    public static final int LAYOUT_ID = 2131558818;
    private LocalApk localApk;

    @Bindable
    public boolean isSelected() {
        return false;
    }

    public LocalApkViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
        ViewUtil.clickListener(view, this);
    }

    @Override // com.coolapk.market.viewholder.StateViewHolder, com.coolapk.market.util.RVStateEventChangedAdapter.IStateViewHolder
    public boolean onStateEventChanged(Event event) {
        return isEventBelongTo(event, this.localApk);
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        this.localApk = (LocalApk) obj;
        ItemLocalApkBinding itemLocalApkBinding = (ItemLocalApkBinding) getBinding();
        itemLocalApkBinding.setApk(this.localApk);
        itemLocalApkBinding.setVh(this);
        itemLocalApkBinding.executePendingBindings();
    }

    @Bindable
    public String getActionText() {
        InstallState installState = DataManager.getInstance().getInstallState(this.localApk.getFilePathMd5());
        if (installState != null) {
            switch (installState.getState()) {
                case 1:
                    return getContext().getString(2131886924);
                case 2:
                    return getContext().getString(2131886924);
                case 3:
                    return getContext().getString(2131886921);
                case 4:
                    return getContext().getString(2131886922);
                case 5:
                    return getContext().getString(2131886923);
                case 6:
                    return getContext().getString(2131886920);
            }
        }
        MobileApp mobileApp = DataManager.getInstance().getMobileApp(this.localApk.getPackageName());
        if (mobileApp == null || mobileApp.getVersionCode() >= this.localApk.getVersionCode()) {
            return getContext().getString(2131886137);
        }
        return getContext().getString(2131886155);
    }
}
