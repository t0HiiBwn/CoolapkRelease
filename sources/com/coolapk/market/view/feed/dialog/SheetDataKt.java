package com.coolapk.market.view.feed.dialog;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\u001a:\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t\u001a\u0010\u0010\u000b\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\r0\f¨\u0006\u000e"}, d2 = {"findAndIndex", "", "", "Lcom/coolapk/market/view/feed/dialog/SheetGroup;", "groupType", "Lcom/coolapk/market/view/feed/dialog/SheetGroupType;", "sheetAction", "Lcom/coolapk/market/view/feed/dialog/SheetAction;", "callback", "Lkotlin/Function2;", "", "makeLastItemDivider", "", "Lcom/coolapk/market/view/feed/dialog/SheetDataItem;", "presentation_coolapkAppRelease"}, k = 2, mv = {1, 4, 2})
/* compiled from: SheetData.kt */
public final class SheetDataKt {
    public static final void findAndIndex(List<SheetGroup> list, SheetGroupType sheetGroupType, SheetAction sheetAction, Function2<? super SheetGroup, ? super Integer, Unit> function2) {
        Integer num;
        boolean z;
        T t;
        boolean z2;
        Intrinsics.checkNotNullParameter(list, "$this$findAndIndex");
        Intrinsics.checkNotNullParameter(sheetGroupType, "groupType");
        Intrinsics.checkNotNullParameter(sheetAction, "sheetAction");
        Intrinsics.checkNotNullParameter(function2, "callback");
        Iterator<T> it2 = list.iterator();
        while (true) {
            num = null;
            z = true;
            if (!it2.hasNext()) {
                t = null;
                break;
            }
            t = it2.next();
            if (t.getType() == sheetGroupType) {
                z2 = true;
                continue;
            } else {
                z2 = false;
                continue;
            }
            if (z2) {
                break;
            }
        }
        T t2 = t;
        if (t2 != null) {
            Iterator<SheetDataItem> it3 = t2.getItems().iterator();
            int i = 0;
            while (true) {
                if (!it3.hasNext()) {
                    i = -1;
                    break;
                } else if (Intrinsics.areEqual(it3.next().getSheetAction(), sheetAction)) {
                    break;
                } else {
                    i++;
                }
            }
            Integer valueOf = Integer.valueOf(i);
            if (valueOf.intValue() < 0) {
                z = false;
            }
            if (z) {
                num = valueOf;
            }
            if (num != null) {
                function2.invoke(t2, Integer.valueOf(num.intValue()));
            }
        }
    }

    public static final void makeLastItemDivider(List<SheetDataItem> list) {
        Intrinsics.checkNotNullParameter(list, "$this$makeLastItemDivider");
        if (!list.isEmpty()) {
            list.add(SheetDataItem.copy$default((SheetDataItem) CollectionsKt.removeLast(list), null, null, null, null, null, 0, true, false, 191, null));
        }
    }
}
