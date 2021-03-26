package com.coolapk.market.view.base;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0003\u001a&\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b¨\u0006\t"}, d2 = {"addItem", "", "", "Lcom/coolapk/market/view/base/ActionItem;", "item", "title", "", "action", "Lkotlin/Function0;", "presentation_coolapkAppRelease"}, k = 2, mv = {1, 4, 2})
/* compiled from: MultiItemDialogFragment.kt */
public final class MultiItemDialogFragmentKt {
    public static final void addItem(List<ActionItem> list, String str, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(list, "$this$addItem");
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(function0, "action");
        list.add(new ActionItem(str, function0));
    }

    public static final void addItem(List<ActionItem> list, ActionItem actionItem) {
        Intrinsics.checkNotNullParameter(list, "$this$addItem");
        Intrinsics.checkNotNullParameter(actionItem, "item");
        list.add(actionItem);
    }
}
