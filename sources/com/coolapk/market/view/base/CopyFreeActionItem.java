package com.coolapk.market.view.base;

import com.coolapk.market.AppHolder;
import com.coolapk.market.manager.ActionManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/coolapk/market/view/base/CopyFreeActionItem;", "Lcom/coolapk/market/view/base/ActionItem;", "title", "", "content", "(Ljava/lang/String;Ljava/lang/String;)V", "takeAction", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: MultiItemDialogFragment.kt */
public final class CopyFreeActionItem extends ActionItem {
    private final String content;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CopyFreeActionItem(String str, String str2) {
        super(str, null, 2, null);
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "content");
        this.content = str2;
    }

    @Override // com.coolapk.market.view.base.ActionItem
    public void takeAction() {
        ActionManager.startTextViewActivity(AppHolder.getCurrentActivity(), this.content);
    }
}
