package com.coolapk.market.view.backupList;

import android.content.Context;
import android.view.View;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.databinding.ItemBackupAppBinding;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.LocalApp;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0010B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0003H\u0016J\u0012\u0010\u000e\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0011"}, d2 = {"Lcom/coolapk/market/view/backupList/BackupLocalAppViewholder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemBackupAppBinding;", "Lcom/coolapk/market/model/LocalApp;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "bindToContent", "", "entity", "onClick", "view", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: BackupLocalAppViewholder.kt */
public final class BackupLocalAppViewholder extends GenericBindHolder<ItemBackupAppBinding, LocalApp> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558624;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BackupLocalAppViewholder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
    }

    public void bindToContent(LocalApp localApp) {
        Intrinsics.checkNotNullParameter(localApp, "entity");
        ItemBackupAppBinding itemBackupAppBinding = (ItemBackupAppBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemBackupAppBinding, "binding");
        itemBackupAppBinding.setApp(localApp);
        ItemBackupAppBinding itemBackupAppBinding2 = (ItemBackupAppBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemBackupAppBinding2, "binding");
        BackupLocalAppViewholder backupLocalAppViewholder = this;
        itemBackupAppBinding2.setClick(backupLocalAppViewholder);
        ((ItemBackupAppBinding) getBinding()).actionContainer.setOnClickListener(backupLocalAppViewholder);
        ((ItemBackupAppBinding) getBinding()).executePendingBindings();
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        Intrinsics.checkNotNull(view);
        int id = view.getId();
        if (id == 2131361887 || id == 2131362083) {
            Context context = getContext();
            ItemBackupAppBinding itemBackupAppBinding = (ItemBackupAppBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemBackupAppBinding, "binding");
            LocalApp app = itemBackupAppBinding.getApp();
            Intrinsics.checkNotNull(app);
            Intrinsics.checkNotNullExpressionValue(app, "binding.app!!");
            String url = app.getUrl();
            ItemBackupAppBinding itemBackupAppBinding2 = (ItemBackupAppBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemBackupAppBinding2, "binding");
            LocalApp app2 = itemBackupAppBinding2.getApp();
            Intrinsics.checkNotNull(app2);
            Intrinsics.checkNotNullExpressionValue(app2, "binding.app!!");
            ActionManager.startExternalMarketByName(context, url, "", app2.getPackageName());
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/backupList/BackupLocalAppViewholder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: BackupLocalAppViewholder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
