package com.coolapk.market.view.feed.dialog;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/coolapk/market/view/feed/dialog/SheetResultReplace;", "Lcom/coolapk/market/view/feed/dialog/SheetResult;", "sheetGroupList", "", "Lcom/coolapk/market/view/feed/dialog/SheetGroup;", "backToTop", "", "(Ljava/util/List;Z)V", "getBackToTop", "()Z", "getSheetGroupList", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SheetData.kt */
public final class SheetResultReplace extends SheetResult {
    private final boolean backToTop;
    private final List<SheetGroup> sheetGroupList;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.coolapk.market.view.feed.dialog.SheetResultReplace */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SheetResultReplace copy$default(SheetResultReplace sheetResultReplace, List list, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            list = sheetResultReplace.sheetGroupList;
        }
        if ((i & 2) != 0) {
            z = sheetResultReplace.backToTop;
        }
        return sheetResultReplace.copy(list, z);
    }

    public final List<SheetGroup> component1() {
        return this.sheetGroupList;
    }

    public final boolean component2() {
        return this.backToTop;
    }

    public final SheetResultReplace copy(List<SheetGroup> list, boolean z) {
        Intrinsics.checkNotNullParameter(list, "sheetGroupList");
        return new SheetResultReplace(list, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SheetResultReplace)) {
            return false;
        }
        SheetResultReplace sheetResultReplace = (SheetResultReplace) obj;
        return Intrinsics.areEqual(this.sheetGroupList, sheetResultReplace.sheetGroupList) && this.backToTop == sheetResultReplace.backToTop;
    }

    public int hashCode() {
        List<SheetGroup> list = this.sheetGroupList;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        boolean z = this.backToTop;
        if (z) {
            z = true;
        }
        int i = z ? 1 : 0;
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        return hashCode + i;
    }

    public String toString() {
        return "SheetResultReplace(sheetGroupList=" + this.sheetGroupList + ", backToTop=" + this.backToTop + ")";
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SheetResultReplace(List<SheetGroup> list, boolean z) {
        super(null);
        Intrinsics.checkNotNullParameter(list, "sheetGroupList");
        this.sheetGroupList = list;
        this.backToTop = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SheetResultReplace(List list, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? true : z);
    }

    public final boolean getBackToTop() {
        return this.backToTop;
    }

    public final List<SheetGroup> getSheetGroupList() {
        return this.sheetGroupList;
    }
}
