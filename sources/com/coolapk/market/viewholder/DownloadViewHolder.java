package com.coolapk.market.viewholder;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.databinding.ItemDownloadBinding;
import com.coolapk.market.event.Event;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.DownloadInfo;
import com.coolapk.market.model.DownloadState;
import com.coolapk.market.model.Extra;
import com.coolapk.market.util.ShapeUtils;
import com.coolapk.market.util.StateUtils;
import com.coolapk.market.util.StringUtils;
import com.coolapk.market.util.ViewUtil;
import java.util.Locale;

public class DownloadViewHolder extends StateViewHolder {
    public static final int LAYOUT_ID = 2131558675;
    private DownloadInfo downloadInfo;
    private Extra extra;

    public DownloadViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
        ViewUtil.clickListener(view, this);
    }

    @Override // com.coolapk.market.viewholder.StateViewHolder, com.coolapk.market.util.RVStateEventChangedAdapter.IStateViewHolder
    public boolean onStateEventChanged(Event event) {
        return isEventBelongTo(event, this.downloadInfo);
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        DownloadInfo downloadInfo2 = (DownloadInfo) obj;
        this.downloadInfo = downloadInfo2;
        Extra extra2 = downloadInfo2.getExtra();
        this.extra = extra2;
        if (extra2 != null) {
            ItemDownloadBinding itemDownloadBinding = (ItemDownloadBinding) getBinding();
            itemDownloadBinding.setVh(this);
            itemDownloadBinding.executePendingBindings();
            StateUtils.updateActionProgress(DataManager.getInstance().getDownloadState(this.downloadInfo.getUrlMd5()), itemDownloadBinding.actionContainer.getBackground());
            return;
        }
        throw new RuntimeException("Download info extra can not be null");
    }

    @Bindable
    public String getLogo() {
        return this.extra.getString("LOGO");
    }

    @Bindable
    public String getAppName() {
        String string = this.extra.getString("TITLE");
        return TextUtils.isEmpty(string) ? this.downloadInfo.getFileName() : string;
    }

    @Bindable
    public String getVersionName() {
        return String.format(Locale.US, "%s", this.extra.getString("VERSION_NAME"));
    }

    @Bindable
    public String getVersionCode() {
        return String.format(Locale.US, "(%d)", Integer.valueOf(this.extra.getInt("VERSION_CODE")));
    }

    @Bindable
    public String getActionText() {
        return StateUtils.getActionText(getContext(), this.extra.getString("PACKAGE_NAME"), null, this.downloadInfo.getUrlMd5());
    }

    @Bindable
    public String getActionButtonBackground() {
        return StateUtils.getActionButtonBackground(DataManager.getInstance().getDownloadState(this.downloadInfo.getUrlMd5()));
    }

    @Bindable
    public int getActionButtonTextColor() {
        return StateUtils.getActionButtonTextColor(DataManager.getInstance().getDownloadState(this.downloadInfo.getUrlMd5()));
    }

    @Bindable
    public String getDownloadSize() {
        DownloadState downloadState = DataManager.getInstance().getDownloadState(this.downloadInfo.getUrlMd5());
        if (downloadState == null) {
            return null;
        }
        if (downloadState.isSuccess()) {
            return StringUtils.formatSize(downloadState.getTotalLength());
        }
        return StringUtils.formatSize(downloadState.getCurrentLength()) + "/" + StringUtils.formatSize(downloadState.getTotalLength());
    }

    @Bindable
    public String getSpeed() {
        long j;
        long j2;
        DownloadState downloadState = DataManager.getInstance().getDownloadState(this.downloadInfo.getUrlMd5());
        long j3 = 0;
        if (downloadState != null) {
            j2 = downloadState.getDiffLength();
            j = downloadState.getDiffTime();
        } else {
            j2 = 0;
            j = 0;
        }
        StringBuilder sb = new StringBuilder();
        if (j != 0) {
            j3 = (j2 * 1000) / j;
        }
        sb.append(StringUtils.formatSize(j3));
        sb.append("/S");
        return sb.toString();
    }

    @Bindable
    public boolean isShowSpeed() {
        DownloadState downloadState = DataManager.getInstance().getDownloadState(this.downloadInfo.getUrlMd5());
        return downloadState != null && downloadState.isRunning();
    }

    @Bindable
    public boolean isShowVersion() {
        return !TextUtils.isEmpty(this.extra.getString("VERSION_NAME"));
    }

    @Bindable
    public Drawable getDownloadIconPlaceHolder() {
        return ShapeUtils.createDownloadIcon(getContext());
    }
}
