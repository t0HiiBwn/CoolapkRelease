package com.coolapk.market.view.album;

import android.content.DialogInterface;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.util.StringUtils;
import com.coolapk.market.view.album.AlbumItemDialog;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: AlbumItemDialog.kt */
final class AlbumItemDialog$InfoDialogFragment$onCreateDialog$1 implements DialogInterface.OnClickListener {
    final /* synthetic */ AlbumItemDialog.InfoDialogFragment this$0;

    AlbumItemDialog$InfoDialogFragment$onCreateDialog$1(AlbumItemDialog.InfoDialogFragment infoDialogFragment) {
        this.this$0 = infoDialogFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        ActionManager.startTextViewActivity(this.this$0.getActivity(), StringUtils.getModelInfo(this.this$0.modelInfo), 12, "feed");
    }
}
