package com.coolapk.market.view.sharev8;

import android.app.Activity;
import android.view.View;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.sharev8.ShareImageListActivity;
import java.io.File;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: ShareImageListActivity.kt */
final class ShareImageListActivity$DataAdapter$onBindViewHolder$6 implements View.OnClickListener {
    final /* synthetic */ ShareImageListActivity.DataAdapter this$0;

    ShareImageListActivity$DataAdapter$onBindViewHolder$6(ShareImageListActivity.DataAdapter dataAdapter) {
        this.this$0 = dataAdapter;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ActionManager.shareImage(this.this$0.getContext(), new File(this.this$0.getPath()));
        Activity activityNullable = UiUtils.getActivityNullable(this.this$0.getContext());
        if (activityNullable != null) {
            activityNullable.finish();
        }
    }
}
