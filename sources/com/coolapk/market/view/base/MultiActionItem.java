package com.coolapk.market.view.base;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0018\u0010\u0004\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0001R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R#\u0010\u0004\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/coolapk/market/view/base/MultiActionItem;", "Lcom/coolapk/market/view/base/ActionItem;", "title", "", "builder", "Lkotlin/Function1;", "", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "actionItems", "getBuilder", "()Lkotlin/jvm/functions/Function1;", "addActionItem", "item", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: MultiItemDialogFragment.kt */
public final class MultiActionItem extends ActionItem {
    private final List<ActionItem> actionItems = new ArrayList();
    private final Function1<List<ActionItem>, Unit> builder;

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.functions.Function1<? super java.util.List<com.coolapk.market.view.base.ActionItem>, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MultiActionItem(String str, Function1<? super List<ActionItem>, Unit> function1) {
        super(str, null, 2, null);
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(function1, "builder");
        this.builder = function1;
    }

    public final Function1<List<ActionItem>, Unit> getBuilder() {
        return this.builder;
    }

    public final MultiActionItem addActionItem(ActionItem actionItem) {
        Intrinsics.checkNotNullParameter(actionItem, "item");
        this.actionItems.add(actionItem);
        return this;
    }
}
