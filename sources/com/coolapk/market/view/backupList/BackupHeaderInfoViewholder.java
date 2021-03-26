package com.coolapk.market.view.backupList;

import android.view.View;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.databinding.ItemBackupHeaderInfoBinding;
import com.coolapk.market.model.BackupInfo;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u000e2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000eB\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0003H\u0016¨\u0006\u000f"}, d2 = {"Lcom/coolapk/market/view/backupList/BackupHeaderInfoViewholder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemBackupHeaderInfoBinding;", "Lcom/coolapk/market/model/BackupInfo;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "bindToContent", "", "entity", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: BackupHeaderInfoViewholder.kt */
public final class BackupHeaderInfoViewholder extends GenericBindHolder<ItemBackupHeaderInfoBinding, BackupInfo> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558626;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BackupHeaderInfoViewholder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
    }

    public void bindToContent(BackupInfo backupInfo) {
        Intrinsics.checkNotNullParameter(backupInfo, "entity");
        ItemBackupHeaderInfoBinding itemBackupHeaderInfoBinding = (ItemBackupHeaderInfoBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemBackupHeaderInfoBinding, "binding");
        itemBackupHeaderInfoBinding.setModel(backupInfo);
        ItemBackupHeaderInfoBinding itemBackupHeaderInfoBinding2 = (ItemBackupHeaderInfoBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemBackupHeaderInfoBinding2, "binding");
        itemBackupHeaderInfoBinding2.setClick(this);
        ((ItemBackupHeaderInfoBinding) getBinding()).executePendingBindings();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/backupList/BackupHeaderInfoViewholder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: BackupHeaderInfoViewholder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
