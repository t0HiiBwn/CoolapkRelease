package com.coolapk.market.view.feed.dialog;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/coolapk/market/view/feed/dialog/SheetGroup;", "", "type", "Lcom/coolapk/market/view/feed/dialog/SheetGroupType;", "items", "", "Lcom/coolapk/market/view/feed/dialog/SheetDataItem;", "(Lcom/coolapk/market/view/feed/dialog/SheetGroupType;Ljava/util/List;)V", "getItems", "()Ljava/util/List;", "getType", "()Lcom/coolapk/market/view/feed/dialog/SheetGroupType;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SheetData.kt */
public final class SheetGroup {
    private final List<SheetDataItem> items;
    private final SheetGroupType type;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.coolapk.market.view.feed.dialog.SheetGroup */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SheetGroup copy$default(SheetGroup sheetGroup, SheetGroupType sheetGroupType, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            sheetGroupType = sheetGroup.type;
        }
        if ((i & 2) != 0) {
            list = sheetGroup.items;
        }
        return sheetGroup.copy(sheetGroupType, list);
    }

    public final SheetGroupType component1() {
        return this.type;
    }

    public final List<SheetDataItem> component2() {
        return this.items;
    }

    public final SheetGroup copy(SheetGroupType sheetGroupType, List<SheetDataItem> list) {
        Intrinsics.checkNotNullParameter(sheetGroupType, "type");
        Intrinsics.checkNotNullParameter(list, "items");
        return new SheetGroup(sheetGroupType, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SheetGroup)) {
            return false;
        }
        SheetGroup sheetGroup = (SheetGroup) obj;
        return Intrinsics.areEqual(this.type, sheetGroup.type) && Intrinsics.areEqual(this.items, sheetGroup.items);
    }

    public int hashCode() {
        SheetGroupType sheetGroupType = this.type;
        int i = 0;
        int hashCode = (sheetGroupType != null ? sheetGroupType.hashCode() : 0) * 31;
        List<SheetDataItem> list = this.items;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "SheetGroup(type=" + this.type + ", items=" + this.items + ")";
    }

    public SheetGroup(SheetGroupType sheetGroupType, List<SheetDataItem> list) {
        Intrinsics.checkNotNullParameter(sheetGroupType, "type");
        Intrinsics.checkNotNullParameter(list, "items");
        this.type = sheetGroupType;
        this.items = list;
    }

    public final List<SheetDataItem> getItems() {
        return this.items;
    }

    public final SheetGroupType getType() {
        return this.type;
    }
}
