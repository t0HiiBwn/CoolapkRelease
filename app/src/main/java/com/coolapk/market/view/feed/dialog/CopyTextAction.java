package com.coolapk.market.view.feed.dialog;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007HÆ\u0003J/\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/coolapk/market/view/feed/dialog/CopyTextAction;", "Lcom/coolapk/market/view/feed/dialog/SheetAction;", "text", "", "isCopyFree", "", "textBuilder", "Lkotlin/Function0;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function0;)V", "()Z", "getText", "()Ljava/lang/String;", "getTextBuilder", "()Lkotlin/jvm/functions/Function0;", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SheetData.kt */
public final class CopyTextAction implements SheetAction {
    private final boolean isCopyFree;
    private final String text;
    private final Function0<String> textBuilder;

    public CopyTextAction() {
        this(null, false, null, 7, null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.coolapk.market.view.feed.dialog.CopyTextAction */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CopyTextAction copy$default(CopyTextAction copyTextAction, String str, boolean z, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            str = copyTextAction.text;
        }
        if ((i & 2) != 0) {
            z = copyTextAction.isCopyFree;
        }
        if ((i & 4) != 0) {
            function0 = copyTextAction.textBuilder;
        }
        return copyTextAction.copy(str, z, function0);
    }

    public final String component1() {
        return this.text;
    }

    public final boolean component2() {
        return this.isCopyFree;
    }

    public final Function0<String> component3() {
        return this.textBuilder;
    }

    public final CopyTextAction copy(String str, boolean z, Function0<String> function0) {
        Intrinsics.checkNotNullParameter(str, "text");
        return new CopyTextAction(str, z, function0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CopyTextAction)) {
            return false;
        }
        CopyTextAction copyTextAction = (CopyTextAction) obj;
        return Intrinsics.areEqual(this.text, copyTextAction.text) && this.isCopyFree == copyTextAction.isCopyFree && Intrinsics.areEqual(this.textBuilder, copyTextAction.textBuilder);
    }

    public int hashCode() {
        String str = this.text;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        boolean z = this.isCopyFree;
        if (z) {
            z = true;
        }
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = (hashCode + i2) * 31;
        Function0<String> function0 = this.textBuilder;
        if (function0 != null) {
            i = function0.hashCode();
        }
        return i5 + i;
    }

    public String toString() {
        return "CopyTextAction(text=" + this.text + ", isCopyFree=" + this.isCopyFree + ", textBuilder=" + this.textBuilder + ")";
    }

    public CopyTextAction(String str, boolean z, Function0<String> function0) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.text = str;
        this.isCopyFree = z;
        this.textBuilder = function0;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CopyTextAction(String str, boolean z, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? false : z, (i & 4) != 0 ? null : function0);
    }

    public final String getText() {
        return this.text;
    }

    public final Function0<String> getTextBuilder() {
        return this.textBuilder;
    }

    public final boolean isCopyFree() {
        return this.isCopyFree;
    }
}
