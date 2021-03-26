package com.coolapk.market.view.base;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\u0006H\u0016R\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/coolapk/market/view/base/ActionItem;", "", "title", "", "action", "Lkotlin/Function0;", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "getAction", "()Lkotlin/jvm/functions/Function0;", "getTitle", "()Ljava/lang/String;", "takeAction", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: MultiItemDialogFragment.kt */
public class ActionItem {
    private final Function0<Unit> action;
    private final String title;

    public ActionItem(String str, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.title = str;
        this.action = function0;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ActionItem(String str, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : function0);
    }

    public final Function0<Unit> getAction() {
        return this.action;
    }

    public final String getTitle() {
        return this.title;
    }

    public void takeAction() {
        Function0<Unit> function0 = this.action;
        if (function0 != null) {
            function0.invoke();
        }
    }
}
