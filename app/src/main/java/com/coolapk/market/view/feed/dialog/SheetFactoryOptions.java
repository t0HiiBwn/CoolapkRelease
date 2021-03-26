package com.coolapk.market.view.feed.dialog;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/coolapk/market/view/feed/dialog/SheetFactoryOptions;", "", "applyModifier", "", "(Z)V", "getApplyModifier", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SheetData.kt */
public final class SheetFactoryOptions {
    public static final Companion Companion = new Companion(null);
    private static final SheetFactoryOptions DEFAULT = new SheetFactoryOptions(false, 1, null);
    private final boolean applyModifier;

    public SheetFactoryOptions() {
        this(false, 1, null);
    }

    public static /* synthetic */ SheetFactoryOptions copy$default(SheetFactoryOptions sheetFactoryOptions, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = sheetFactoryOptions.applyModifier;
        }
        return sheetFactoryOptions.copy(z);
    }

    public final boolean component1() {
        return this.applyModifier;
    }

    public final SheetFactoryOptions copy(boolean z) {
        return new SheetFactoryOptions(z);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof SheetFactoryOptions) && this.applyModifier == ((SheetFactoryOptions) obj).applyModifier;
        }
        return true;
    }

    public int hashCode() {
        boolean z = this.applyModifier;
        if (z) {
            return 1;
        }
        return z ? 1 : 0;
    }

    public String toString() {
        return "SheetFactoryOptions(applyModifier=" + this.applyModifier + ")";
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/view/feed/dialog/SheetFactoryOptions$Companion;", "", "()V", "DEFAULT", "Lcom/coolapk/market/view/feed/dialog/SheetFactoryOptions;", "getDEFAULT", "()Lcom/coolapk/market/view/feed/dialog/SheetFactoryOptions;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SheetData.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SheetFactoryOptions getDEFAULT() {
            return SheetFactoryOptions.DEFAULT;
        }
    }

    public SheetFactoryOptions(boolean z) {
        this.applyModifier = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SheetFactoryOptions(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z);
    }

    public final boolean getApplyModifier() {
        return this.applyModifier;
    }
}
