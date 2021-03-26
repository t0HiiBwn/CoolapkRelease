package com.coolapk.market.view.backupList;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.databinding.ItemBackupHeaderBinding;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.DownloadInfo;
import com.coolapk.market.model.DownloadState;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.model.MobileApp;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.model.UpgradeInfo;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.DateUtils;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.ShapeUtils;
import com.coolapk.market.util.StateUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0018B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0002J\u0012\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005H\u0016J\u0018\u0010\u0014\u001a\u00020\u000f2\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/coolapk/market/view/backupList/BackupHeaderViewholder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemBackupHeaderBinding;", "Lcom/coolapk/market/model/HolderItem;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "isDetail", "", "isDownloading", "bindToContent", "", "entity", "createList", "onClick", "view", "onDownload", "list", "", "Lcom/coolapk/market/model/ServiceApp;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: BackupHeaderViewholder.kt */
public final class BackupHeaderViewholder extends GenericBindHolder<ItemBackupHeaderBinding, HolderItem> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558625;
    private boolean isDetail;
    private boolean isDownloading;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BackupHeaderViewholder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x012e  */
    public void bindToContent(HolderItem holderItem) {
        boolean z;
        Intrinsics.checkNotNullParameter(holderItem, "entity");
        ItemBackupHeaderBinding itemBackupHeaderBinding = (ItemBackupHeaderBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemBackupHeaderBinding, "binding");
        itemBackupHeaderBinding.setModel(holderItem);
        ItemBackupHeaderBinding itemBackupHeaderBinding2 = (ItemBackupHeaderBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemBackupHeaderBinding2, "binding");
        itemBackupHeaderBinding2.setClick(this);
        this.isDetail = TextUtils.equals(holderItem.getEntityType(), "backupDeatilHeader");
        ProgressBar progressBar = ((ItemBackupHeaderBinding) getBinding()).loadingView;
        Intrinsics.checkNotNullExpressionValue(progressBar, "binding.loadingView");
        int i = 8;
        progressBar.setVisibility(8);
        TextView textView = ((ItemBackupHeaderBinding) getBinding()).titleView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
        textView.setVisibility(this.isDetail ? 0 : 8);
        ImageView imageView = ((ItemBackupHeaderBinding) getBinding()).logoView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.logoView");
        imageView.setVisibility(this.isDetail ? 8 : 0);
        String str = this.isDetail ? "备份时间：" : "上次备份时间：";
        ItemBackupHeaderBinding itemBackupHeaderBinding3 = (ItemBackupHeaderBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemBackupHeaderBinding3, "binding");
        if (holderItem.getDateline() != null) {
            Long dateline = holderItem.getDateline();
            Intrinsics.checkNotNull(dateline);
            if (dateline.longValue() > 0) {
                z = true;
                String str2 = str + DateUtils.getCreateTimeDescription(getContext(), holderItem.getDateline(), true);
                if (!z) {
                    str2 = "上次备份时间：您还没创建过备份";
                }
                itemBackupHeaderBinding3.setTime(str2);
                ItemBackupHeaderBinding itemBackupHeaderBinding4 = (ItemBackupHeaderBinding) getBinding();
                Intrinsics.checkNotNullExpressionValue(itemBackupHeaderBinding4, "binding");
                itemBackupHeaderBinding4.setCount("我的备份单（" + holderItem.getIntValue() + (char) 65289);
                TextView textView2 = ((ItemBackupHeaderBinding) getBinding()).actionView;
                Intrinsics.checkNotNullExpressionValue(textView2, "binding.actionView");
                textView2.setBackground(ShapeUtils.createActionCornerBg(getContext(), ResourceUtils.getColorInt(getContext(), 2131100159), 24));
                LinearLayout linearLayout = ((ItemBackupHeaderBinding) getBinding()).countView;
                Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.countView");
                if (!TextUtils.equals("backupDeatilHeader", holderItem.getEntityTemplate())) {
                    i = 0;
                }
                linearLayout.setVisibility(i);
                ((ItemBackupHeaderBinding) getBinding()).executePendingBindings();
            }
        }
        z = false;
        String str2 = str + DateUtils.getCreateTimeDescription(getContext(), holderItem.getDateline(), true);
        if (!z) {
        }
        itemBackupHeaderBinding3.setTime(str2);
        ItemBackupHeaderBinding itemBackupHeaderBinding4 = (ItemBackupHeaderBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemBackupHeaderBinding4, "binding");
        itemBackupHeaderBinding4.setCount("我的备份单（" + holderItem.getIntValue() + (char) 65289);
        TextView textView2 = ((ItemBackupHeaderBinding) getBinding()).actionView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.actionView");
        textView2.setBackground(ShapeUtils.createActionCornerBg(getContext(), ResourceUtils.getColorInt(getContext(), 2131100159), 24));
        LinearLayout linearLayout = ((ItemBackupHeaderBinding) getBinding()).countView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.countView");
        if (!TextUtils.equals("backupDeatilHeader", holderItem.getEntityTemplate())) {
        }
        linearLayout.setVisibility(i);
        ((ItemBackupHeaderBinding) getBinding()).executePendingBindings();
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        Intrinsics.checkNotNull(view);
        if (view.getId() == 2131361982) {
            if (this.isDetail) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                Activity activityNullable = UiUtils.getActivityNullable(context);
                if (activityNullable instanceof BackupDetailListActivity) {
                    onDownload(((BackupDetailListActivity) activityNullable).getAppList());
                    return;
                }
                return;
            }
            ProgressBar progressBar = ((ItemBackupHeaderBinding) getBinding()).loadingView;
            Intrinsics.checkNotNullExpressionValue(progressBar, "binding.loadingView");
            progressBar.setVisibility(0);
            TextView textView = ((ItemBackupHeaderBinding) getBinding()).actionView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.actionView");
            textView.setText("");
            DataManager.getInstance().checkCount().map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe(new BackupHeaderViewholder$onClick$1(this), new BackupHeaderViewholder$onClick$2(this));
        }
    }

    /* access modifiers changed from: private */
    public final void createList() {
        ProgressBar progressBar = ((ItemBackupHeaderBinding) getBinding()).loadingView;
        Intrinsics.checkNotNullExpressionValue(progressBar, "binding.loadingView");
        progressBar.setVisibility(8);
        TextView textView = ((ItemBackupHeaderBinding) getBinding()).actionView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.actionView");
        textView.setText("创建备份单");
        String str = Build.BRAND + '-' + Build.MODEL + "的备份单 " + DateUtils.getCreateTimeDescription(getContext(), Long.valueOf(DateUtils.getTimestamp()), false);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Activity activityNullable = UiUtils.getActivityNullable(context);
        if (activityNullable instanceof BackupListActivity) {
            ((BackupListActivity) activityNullable).setBackupTitle(str);
        }
        BackupCreateDialog newInstance = BackupCreateDialog.Companion.newInstance();
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        newInstance.show(ContextExtendsKt.requireAppCompatActivity(context2).getSupportFragmentManager(), (String) null);
    }

    private final void onDownload(List<? extends ServiceApp> list) {
        List<? extends ServiceApp> list2 = list;
        if (CollectionUtils.isEmpty(list2) || CollectionUtils.isEmpty(list2)) {
            return;
        }
        if (!this.isDownloading) {
            List<MobileApp> mobileAppUpgradeListFast = DataManager.getInstance().getMobileAppUpgradeListFast(false);
            Intrinsics.checkNotNull(list);
            for (ServiceApp serviceApp : list) {
                if (!TextUtils.equals(serviceApp.getApkId(), "0")) {
                    serviceApp.getDownloadUrlMd5(0);
                    MobileApp mobileAppExistFast = DataManager.getInstance().getMobileAppExistFast(serviceApp.getPackageName());
                    if (mobileAppExistFast == null || !mobileAppUpgradeListFast.contains(mobileAppExistFast)) {
                        if (mobileAppExistFast == null) {
                            ActionManager.startDownload(getContext(), serviceApp, 0);
                            this.isDownloading = true;
                            TextView textView = ((ItemBackupHeaderBinding) getBinding()).actionView;
                            Intrinsics.checkNotNullExpressionValue(textView, "binding.actionView");
                            textView.setText("暂停恢复");
                        }
                    } else if (mobileAppExistFast.getUpgradeInfo() != null) {
                        UpgradeInfo upgradeInfo = mobileAppExistFast.getUpgradeInfo();
                        Intrinsics.checkNotNull(upgradeInfo);
                        UpgradeInfo upgradeInfo2 = mobileAppExistFast.getUpgradeInfo();
                        Intrinsics.checkNotNull(upgradeInfo2);
                        DownloadState findLatestDownloadState = StateUtils.findLatestDownloadState(upgradeInfo.getDownloadUrlMd5(0), upgradeInfo2.getDownloadUrlMd5(1));
                        if (findLatestDownloadState == null || !findLatestDownloadState.isSuccess()) {
                            UpgradeInfo upgradeInfo3 = mobileAppExistFast.getUpgradeInfo();
                            Intrinsics.checkNotNull(upgradeInfo3);
                            Intrinsics.checkNotNullExpressionValue(upgradeInfo3, "mMobileApp.upgradeInfo!!");
                            ActionManager.startDownload(getContext(), mobileAppExistFast, upgradeInfo3.getDownloadUrlTypeSmart());
                            this.isDownloading = true;
                            TextView textView2 = ((ItemBackupHeaderBinding) getBinding()).actionView;
                            Intrinsics.checkNotNullExpressionValue(textView2, "binding.actionView");
                            textView2.setText("暂停恢复");
                        }
                    }
                }
            }
            return;
        }
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        for (DownloadInfo downloadInfo : instance.getDownloadInfoList()) {
            Intrinsics.checkNotNullExpressionValue(downloadInfo, "downloadInfo");
            DownloadState findLatestDownloadState2 = StateUtils.findLatestDownloadState(downloadInfo.getUrlMd5());
            if (findLatestDownloadState2 != null && findLatestDownloadState2.isRunning()) {
                ActionManager.stopDownload(getContext(), findLatestDownloadState2.getUrl());
                this.isDownloading = false;
                TextView textView3 = ((ItemBackupHeaderBinding) getBinding()).actionView;
                Intrinsics.checkNotNullExpressionValue(textView3, "binding.actionView");
                textView3.setText("全部恢复");
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/backupList/BackupHeaderViewholder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: BackupHeaderViewholder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
