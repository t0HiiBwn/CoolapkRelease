package com.coolapk.market.widget;

import android.view.View;
import com.coolapk.market.manager.AppNotification;
import com.coolapk.market.widget.bubble.DragAndDropHelper;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onTargetDrop"}, k = 3, mv = {1, 4, 2})
/* compiled from: SearchAppHeader.kt */
final class SearchAppHeader$updateNotificationView$1 implements DragAndDropHelper.DragAndDrawListener {
    final /* synthetic */ AppNotification $appNotification;

    SearchAppHeader$updateNotificationView$1(AppNotification appNotification) {
        this.$appNotification = appNotification;
    }

    @Override // com.coolapk.market.widget.bubble.DragAndDropHelper.DragAndDrawListener
    public final void onTargetDrop(View view) {
        this.$appNotification.clearAllCount();
        this.$appNotification.clearOnlineCountByType("all");
    }
}
