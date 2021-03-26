package com.coolapk.market.view.feedv8;

import android.content.DialogInterface;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.view.feedv8.SubmitFeedV8Activity;
import com.coolapk.market.view.feedv8.draft.RoughDraftHelper;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: SubmitFeedV8Activity.kt */
final class SubmitFeedV8Activity$SaveDialog$onCreateDialog$2 implements DialogInterface.OnClickListener {
    final /* synthetic */ SubmitFeedV8Activity.SaveDialog this$0;

    SubmitFeedV8Activity$SaveDialog$onCreateDialog$2(SubmitFeedV8Activity.SaveDialog saveDialog) {
        this.this$0 = saveDialog;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        RoughDraftHelper.Companion.getInstance().setEditingDraftSaveToDisk(true, true);
        this.this$0.requireActivity().finish();
        StatisticHelper.Companion.getInstance().recordSaveDraftEvent("保存草稿");
        Toast.show$default(this.this$0.getActivity(), "已保存到草稿箱", 0, false, 12, null);
    }
}
