package com.coolapk.market.view.backupList;

import android.content.Context;
import android.view.View;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.databinding.ItemBackupBinding;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.BackupInfo;
import com.coolapk.market.util.DateUtils;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0010B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0003H\u0016J\u0012\u0010\u000e\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0011"}, d2 = {"Lcom/coolapk/market/view/backupList/BackupItemViewholder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemBackupBinding;", "Lcom/coolapk/market/model/BackupInfo;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "bindToContent", "", "entity", "onClick", "view", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: BackupItemViewholder.kt */
public final class BackupItemViewholder extends GenericBindHolder<ItemBackupBinding, BackupInfo> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558619;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BackupItemViewholder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
    }

    public void bindToContent(BackupInfo backupInfo) {
        Intrinsics.checkNotNullParameter(backupInfo, "entity");
        ItemBackupBinding itemBackupBinding = (ItemBackupBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemBackupBinding, "binding");
        itemBackupBinding.setModel(backupInfo);
        ItemBackupBinding itemBackupBinding2 = (ItemBackupBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemBackupBinding2, "binding");
        itemBackupBinding2.setClick(this);
        ItemBackupBinding itemBackupBinding3 = (ItemBackupBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemBackupBinding3, "binding");
        itemBackupBinding3.setSubTitle(backupInfo.getDeviceTitle() + " " + backupInfo.getApkNumTitle() + " " + DateUtils.getCreateTimeDescription(getContext(), backupInfo.getCreateTime(), false));
        ((ItemBackupBinding) getBinding()).executePendingBindings();
        ((ItemBackupBinding) getBinding()).itemView.setOnLongClickListener(new BackupItemViewholder$bindToContent$1(this, backupInfo));
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        Intrinsics.checkNotNull(view);
        if (view.getId() == 2131362768) {
            Context context = getContext();
            ItemBackupBinding itemBackupBinding = (ItemBackupBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemBackupBinding, "binding");
            BackupInfo model = itemBackupBinding.getModel();
            Intrinsics.checkNotNull(model);
            Intrinsics.checkNotNullExpressionValue(model, "binding.model!!");
            ActionManager.startBackupDetailListActivity(context, model.getId());
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/backupList/BackupItemViewholder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: BackupItemViewholder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
