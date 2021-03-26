package com.coolapk.market.viewholder;

import android.text.TextUtils;
import android.view.View;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.AlbumAppBinding;
import com.coolapk.market.event.Event;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Album;
import com.coolapk.market.model.AlbumItem;
import com.coolapk.market.model.MobileApp;
import com.coolapk.market.model.UpgradeInfo;
import com.coolapk.market.view.album.AlbumItemViewModel;
import com.coolapk.market.widget.ActionButtonFrameLayout;

public class AlbumItemViewHolder extends StateViewHolder {
    public static final int LAYOUT_ID = 2131558579;
    private Album mAlbum;
    private AlbumItem mAlbumItem;
    private AlbumAppBinding mBinding;
    private FragmentManager mFragmentManager;
    private MobileApp mMobileApp;
    private String[] urlMd5s;
    private AlbumItemViewModel viewModel;

    public AlbumItemViewHolder(Album album, FragmentManager fragmentManager, View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
        this.mFragmentManager = fragmentManager;
        this.mAlbum = album;
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        this.mAlbumItem = (AlbumItem) obj;
        this.mMobileApp = DataManager.getInstance().getMobileAppExistFast(this.mAlbumItem.getPackageName());
        this.urlMd5s = getUrlMd5s();
        AlbumAppBinding albumAppBinding = (AlbumAppBinding) getBinding();
        this.mBinding = albumAppBinding;
        albumAppBinding.setViewHolder(this);
        AlbumItemViewModel albumItemViewModel = new AlbumItemViewModel(getContext());
        this.viewModel = albumItemViewModel;
        albumItemViewModel.setAlbumItem(this.mAlbumItem);
        this.mBinding.setViewModel(this.viewModel);
        int i = 8;
        if (TextUtils.equals(this.mAlbumItem.getApkId(), "0")) {
            this.mBinding.sourceNameView.setText(getContext().getString(2131886580, this.mAlbumItem.getSourceName()));
            this.mBinding.sourceNameView.setVisibility(0);
        } else {
            this.mBinding.sourceNameView.setVisibility(8);
        }
        boolean isCommunityMode = AppHolder.getAppMetadata().isCommunityMode();
        ActionButtonFrameLayout actionButtonFrameLayout = this.mBinding.actionContainer;
        if (!isCommunityMode) {
            i = 0;
        }
        actionButtonFrameLayout.setVisibility(i);
        this.mBinding.executePendingBindings();
    }

    @Override // com.coolapk.market.viewholder.StateViewHolder, com.coolapk.market.util.RVStateEventChangedAdapter.IStateViewHolder
    public boolean onStateEventChanged(Event event) {
        return isEventBelongTo(event, this.mAlbumItem);
    }

    private String[] getUrlMd5s() {
        UpgradeInfo upgradeInfo;
        String[] strArr = new String[3];
        strArr[0] = this.mAlbumItem.getDownloadUrlMd5();
        MobileApp mobileApp = this.mMobileApp;
        if (!(mobileApp == null || (upgradeInfo = mobileApp.getUpgradeInfo()) == null)) {
            strArr[1] = upgradeInfo.getDownloadUrlMd5(0);
            strArr[2] = upgradeInfo.getDownloadUrlMd5(1);
        }
        return strArr;
    }
}
