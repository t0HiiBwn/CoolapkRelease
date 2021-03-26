package com.coolapk.market.view.sharev8;

import android.app.Activity;
import android.view.View;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.sharev8.ShareImageListActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: ShareImageListActivity.kt */
final class ShareImageListActivity$DataAdapter$onBindViewHolder$5 implements View.OnClickListener {
    final /* synthetic */ HolderItem $data;
    final /* synthetic */ ShareImageListActivity.DataAdapter this$0;

    ShareImageListActivity$DataAdapter$onBindViewHolder$5(ShareImageListActivity.DataAdapter dataAdapter, HolderItem holderItem) {
        this.this$0 = dataAdapter;
        this.$data = holderItem;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ShareImageListActivity.DataAdapter dataAdapter = this.this$0;
        String entityType = this.$data.getEntityType();
        Intrinsics.checkNotNullExpressionValue(entityType, "data.entityType");
        dataAdapter.shareToType(entityType);
        Activity activityNullable = UiUtils.getActivityNullable(this.this$0.getContext());
        if (activityNullable != null) {
            activityNullable.finish();
        }
    }
}
